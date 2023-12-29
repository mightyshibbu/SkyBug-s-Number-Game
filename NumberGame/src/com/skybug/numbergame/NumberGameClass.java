package com.skybug.numbergame;
import javax.swing.*; 												//1. Import swing to use Frames
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
import javax.swing.*; 

public class NumberGameClass extends JFrame implements ActionListener{
	JButton reset;
	int randomnumber;
	JTextField inputnumbertf;
	JButton submit;
	JButton exit;
	int count=0;
	NumberGameClass(){
		
		 setTitle("SkyBug- Number Game"); 
		 setExtendedState(JFrame.MAXIMIZED_BOTH); //defines size of frame
		 getContentPane().setBackground(Color.pink);
		 setLayout(null); 
		 setLocation(0,0); //set location of window with reference to the top left corner as origin
		 
		 ImageIcon logo = new ImageIcon("pexels-anna-shvets-3683053.jpg"); // Replace with your image path
	        Image logoImage = logo.getImage().getScaledInstance(1920, 1080, Image.SCALE_DEFAULT); // Scale the image to fit the frame
	        ImageIcon backgroundImage = new ImageIcon(logoImage);

	        // Create a JPanel with the image as background
	        JPanel backgroundPanel = new JPanel() {
	            @Override
	            protected void paintComponent(Graphics g) {
	                super.paintComponent(g);
	                g.drawImage(backgroundImage.getImage(), 0, 0, getWidth(), getHeight(), this);
	            }
	        };
	        backgroundPanel.setLayout(null); // Set layout to null for absolute positioning
	        backgroundPanel.setBounds(0, 0, getWidth(), getHeight()); // Set bounds to cover the entire frame
	        add(backgroundPanel);
		 JLabel Welcome = new JLabel("Welcome to Mighty's Lucky Number!");
		 Welcome.setFont(new Font("Osward", Font.BOLD, 38));
		 Welcome.setBounds(420, 40, 1600,80);
		 add(Welcome);
		 
		 JLabel Instructions = new JLabel("* There is a number hidden inside the box ranging from 10 to 110. If you can guess it using hints, it will be yours! *");
		 Instructions .setBounds(260, 180, 2000,40);
		 Instructions .setFont(new Font("Raleway", Font.PLAIN, 22));
		 add(Instructions);	 

		 randomnumber = (int)(Math.random()*100+10);
		 System.out.println(randomnumber);
		 
		 inputnumbertf = new JTextField();
		 inputnumbertf.setBounds(700, 500 , 100,60 );
		 inputnumbertf.setFont(new Font("Osward", Font.BOLD, 45));
		 add(inputnumbertf);
		 
		 submit = new JButton("SUBMIT");
		 submit.setBounds(700, 650, 100,40);
		 submit.setBackground(Color.BLACK);
		 submit.setForeground(Color.WHITE);
		 submit.addActionListener(this);
		 add(submit);
		 
		 reset = new JButton("New Game");
		 reset.setBounds(700, 700, 100,40);
		 reset.setBackground(Color.BLACK);
		 reset.setForeground(Color.WHITE);
		 reset.addActionListener(this);
		 add(reset);
 
		 exit = new JButton("EXIT");
		 exit.setBounds(700, 800, 100,40);
		 exit.setBackground(Color.BLACK);
		 exit.setForeground(Color.WHITE);
		 exit.addActionListener(this);
		 add(exit);
		 
		 setVisible(true); 		//makes the frame visible to user
		 }
	@Override
	public void actionPerformed(ActionEvent e) {
	    if (e.getSource() == reset) {
	        inputnumbertf.setText("");
	        count=0;
	        generateNewRandomNumber();
	    } else if (e.getSource() == exit) {
	        setVisible(false);
	    } else if (e.getSource() == submit) {
	        String inputstring = inputnumbertf.getText();
	        try {
	            int input = Integer.parseInt(inputstring);
	            int score=100- (count*10);
				if (input == randomnumber) {
	                System.out.println("Correct guess!");
	                JOptionPane.showMessageDialog(null, "CORRECT !");
	                JOptionPane.showMessageDialog(null, "Score: " + score);
	                
	            } else if (input < randomnumber) {
	                System.out.println("Too Low");
	                JOptionPane.showMessageDialog(null, "Too Low");
	                if(count<10) {
		                count++;
		            }else {
		            	JOptionPane.showMessageDialog(null, "Game Over!");
		            	JOptionPane.showMessageDialog(null, "Score: " + score);
		            }
	                
	            } else if (input > randomnumber) {
	                System.out.println("Too High");
	                JOptionPane.showMessageDialog(null, "Too High");
	                if(count<10) {
		                count++;
		            }else {
		            	JOptionPane.showMessageDialog(null, "Game Over!");
		            	JOptionPane.showMessageDialog(null, "Score: " + score);
		            }
	            } else {
	                System.out.println("Invalid input");
	                JOptionPane.showMessageDialog(null, "Invalid input");
	                count++;
	            }
	        } catch (NumberFormatException e1) {
	            System.out.println("Invalid input format: " + e1);
	            JOptionPane.showMessageDialog(null, "Invalid input format");
	        }finally {
	        	inputnumbertf.setText("");
	        }
	    }
	}
	private void generateNewRandomNumber() {
		// TODO Auto-generated method stub
		randomnumber = (int) (Math.random() * 100 + 10);
        System.out.println("New random number: " + randomnumber);
	}
	public static void main(String[] args) {
		new NumberGameClass();
	}
}
