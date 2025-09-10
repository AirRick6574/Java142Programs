package caseTracker;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;



public class ButtonTest implements ActionListener{
	
	long count = 0; 
	private JFrame frame;
	private JLabel label; //Create global label object so that it can be used by listener
	private JButton button; 
	private JPanel panel; 
	
	//Constructor Method (Create GUI)
	public ButtonTest() {
		frame = new JFrame();
		
		frame.setAlwaysOnTop(true);  // force top
		
		button = new JButton("Click Me"); //new button with text
		
		label = new JLabel("Number of Clicks: 0"); //object that can display text, image or both.
		label.setPreferredSize(new Dimension(200, 30)); //Set preferred Size
		label.setHorizontalAlignment(JLabel.CENTER); //Center text
		label.setVerticalAlignment(JLabel.CENTER);//Center Text
		button.addActionListener(this); //add listener that will check for button, THIS goes to class
		
		panel = new JPanel(); //Panel to contain window content
		
		panel.setBorder(BorderFactory.createEmptyBorder(100, 100, 100, 100)); //Sets boarder while creating new boarder with size positions
		panel.setLayout(new GridLayout(0, 1)); //uses grid layout to set layout of panel window (0 rows, 1 column)
		
		panel.add(button);
		panel.add(label);
		
		frame.add(panel, BorderLayout.CENTER); //add panels to frame and will center it
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //update frame to determine what to do when closed
		frame.setTitle("TestFrame"); //title frame
		frame.pack(); //pack is used to automatically size the window to accommodate preferred sizes and layout. 
		frame.setVisible(true); //Sets frame visible
	}
	
	public static void main(String[] args) {
		new ButtonTest(); // Call Constructor to create window
	}
	
	//Method that will be called when listener has detected button press. 
	@Override
	public void actionPerformed(ActionEvent e) {
		count++;
		label.setText("Number of Clicks: " + count);
		frame.pack(); // re-pack to adjust to new text size
	}
}
