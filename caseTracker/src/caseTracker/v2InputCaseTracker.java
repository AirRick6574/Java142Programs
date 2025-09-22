package caseTracker;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.PageAttributes.OriginType;
import java.awt.image.BufferedImage;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class v2InputCaseTracker {
	
	//Total CaseManagers Currently
	public static final int TOTAL_CASE_MANAGERS = 6; 
	
	//File Path String
	public static final String FILE_PATH = "CaseCount.txt";
	
	//Turn Numbers for Senior Case Managers
	public static final int CHERYL_TURN_NUMBER = 4;
	public static final int CHRIS_TURN_NUMBER = 5;
	
	//Current Case Manager Turn (name) 
	public static String currentCaseManagerName;
	
	//Create Case Manager Arrays
	public static String[] caseManagerNames = new String[TOTAL_CASE_MANAGERS];
	public static Integer[] caseManagersCases = new Integer[TOTAL_CASE_MANAGERS];

	public static int turnLoop = 0; //Counter for when cycle loops to zero
	public static int currentTurn = 0; //Initialize current turn
	
	long count = 0; 
	private JFrame frame;
	private JLabel label; //Create global label object so that it can be used by listener
	private JButton button; 
	private JPanel panel; 
	
	public v2InputCaseTracker() throws IOException {
		/*
		frame = new JFrame();
	 	frame.setAlwaysOnTop(true);  // force top
	 
	 	label = new JLabel("Case Totals");
		label.setPreferredSize(new Dimension(200, 30));
		label.setHorizontalAlignment(JLabel.CENTER);
		label.setVerticalAlignment(JLabel.CENTER);
		
		panel = new JPanel();
		panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		
		int rows = 2;
		int cols = 6;
		panel.setLayout(new GridLayout(rows, cols, 0, 0));
		
		// Fill grid and add borders
		for (int i = 0; i < rows * cols; i++) {
		    JPanel cell = new JPanel();
		    cell.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		
		    if (i == 0) { 
		        cell.add(label); // put the label in the first cell
		    }
		
		    panel.add(cell);
		}
		panel.setPreferredSize(new Dimension(200, 30));
		
				
		frame.add(panel, BorderLayout.CENTER);
		frame.setSize(1280, 720); // Sets the frame size to 800x600 pixels
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("TestFrame");
		
		//frame.pack();
		frame.setVisible(true);
		*/
		
		//-------------FRAMES------------------------------
		
		// Create the JFrame
        JFrame frame = new JFrame("Sized Panel Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1200, 400); // Set initial frame size
        frame.setBackground(Color.RED); // Set a background color for visibility
        
        
        //-------------- PANELS------------------------------
        
        JPanel titleJPanel = new JPanel();
        titleJPanel.setBackground(Color.RED); // Set a background color for visibility
        
        JPanel leftColumn = new JPanel();
        leftColumn.setBackground(Color.RED); // Set a background color for visibility
        
        // Create the JPanel
        JPanel caseNumberPanels = new JPanel();
        caseNumberPanels.setBackground(Color.LIGHT_GRAY); // Set a background color for visibility
        
        // Create the JPanel
        JPanel caseTypeJPanel = new JPanel();
        caseTypeJPanel.setBackground(Color.LIGHT_GRAY); // Set a background color for visibility
        
        //Create a wrapper with FlowLayout (centers it & respects preferred size)
        JPanel caseCountJPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 0, 25));
        caseCountJPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        
        
        
        
        //----------------------WRAPPER--------------------
        
        //Create a wrapper with FlowLayout (centers it & respects preferred size)
        JPanel wrapper = new JPanel(new BorderLayout(0, 0)); 
        
        //---------------------LABELS
        JLabel caseManagerLabel = new JLabel("CASE MANAGER SYSTEM");
		titleJPanel.add(caseManagerLabel);
		titleJPanel.setBackground(Color.DARK_GRAY);
		caseManagerLabel.setForeground(Color.black);
		titleJPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));

		JButton standardButton = new JButton("Standard Cases");
		JButton TBDButton = new JButton("TBD Cases");
		JButton TBD2Button = new JButton("TBD2 Cases");
		
		
		int rows = 4;
		int cols = 1; 
		leftColumn.setLayout(new GridLayout(rows,cols, 0, 0));
		// Fill grid and add borders (Numbers Panel grid)
		for (int i = 0; i < rows * cols; i++) {
			JPanel cell = new JPanel();
			cell.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));    
			leftColumn.add(cell);
		}
		
		// Set the preferred size of the panel
        leftColumn.setPreferredSize(new Dimension(70, 125)); // Set preferred width and height
		
		
        rows = 4;
		cols = 6;
		caseNumberPanels.setLayout(new GridLayout(rows, cols, 0, 0));
		
		// Fill grid and add borders (Numbers Panel grid)
		for (int i = 0; i < rows * cols; i++) {
			JPanel cell = new JPanel();
			cell.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
			
			if (i < 6) {
			    // Set the preferred size of the panel
				JLabel label = new JLabel(caseManagerNames[i]);
				label.setForeground(Color.black);
				cell.add(label);
				cell.setBackground(Color.GRAY);
			}
			
			if (i > 5 && i < 12) {
			    // Make this particular cell vertical
			    cell.setLayout(new BoxLayout(cell, BoxLayout.Y_AXIS));
				
				// Set the preferred size of the panel
				JLabel label = new JLabel(String.valueOf(caseManagersCases[i-6]));
				cell.add(label);

		        // Load the image
				// 1. Load the original image
	            BufferedImage originalImage = ImageIO.read(new File("test.jpg"));

	            // 2. Resize the image
	            // getScaledInstance returns a new Image object scaled to the specified dimensions
	            Image scaledImage = originalImage.getScaledInstance(50, 50, Image.SCALE_SMOOTH);

	            // 3. Create an ImageIcon from the scaled Image
	            ImageIcon imageIcon = new ImageIcon(scaledImage);
	            
		        // Create a JLabel with the image
		        JLabel imageLabel = new JLabel(imageIcon);
		        imageLabel.setAlignmentX(JLabel.CENTER_ALIGNMENT);
		        cell.add(imageLabel);
		        
		        label.setHorizontalAlignment(JLabel.CENTER);
		        label.setHorizontalTextPosition(JLabel.CENTER);
			}
			
			if (i > 5) {
				cell.setBackground(Color.LIGHT_GRAY);
			}	    
			caseNumberPanels.add(cell);
		}
		

        // Set the preferred size of the panel
        caseNumberPanels.setPreferredSize(new Dimension(800, 125)); // Set preferred width and height
        
        wrapper.add(caseCountJPanel, BorderLayout.NORTH);
        wrapper.add(caseNumberPanels, BorderLayout.CENTER);
        wrapper.add(titleJPanel, BorderLayout.NORTH);
        wrapper.add(leftColumn, BorderLayout.WEST);
        
       

        // Pack the frame to adjust its size based on preferred sizes of components
        // Note: If you want a fixed frame size, you might call setSize() after pack()
        // or just rely on setSize() if you don't care about components' preferred sizes.
        
        
        frame.add(wrapper, BorderLayout.CENTER);

        // Center the frame on the screen
        frame.setLocationRelativeTo(null);

        // Make the frame visible
        frame.setVisible(true);
    }

	
	
	public static void getFileInformation() throws FileNotFoundException {
		int loopcounter = 0;
		
		//Load File 
        //ASSUMES FILE IS IN FORMAT
        try (Scanner scanner = new Scanner(new File("CaseCount.txt"))) {
            for (int i = 0; i < TOTAL_CASE_MANAGERS; i++) {
            	caseManagerNames[loopcounter] = scanner.next(); //gets next name
            	caseManagersCases[loopcounter] = scanner.nextInt(); //Get next int
                loopcounter++;
            }
            
            //Save Current Turn and update
            if (scanner.hasNext()) {
            	scanner.next();
            	currentTurn = scanner.nextInt();
            	
            	scanner.next();
            	turnLoop = scanner.nextInt();
            }
        }
	}
	
	public static String findCurrentCaseManagerName() {
		return caseManagerNames[currentTurn];
	}
	
	//Updates Turn to next person in list (up to down)
	public static void iterateTurn() {
		currentTurn++;
			
		//Check if count will exceed Amount of Case Managers, if yes reset.
		//Update loop count
		if (currentTurn >= caseManagerNames.length) {
			currentTurn = 0;
			turnLoop++;
		}
	}
	
	//Updates Turn to next person in list (up to down)
	public static boolean islegalTurn() {
		currentCaseManagerName = findCurrentCaseManagerName();
			
		//Find current min number in array while ignoring total of senior case managers
		//Finds min by first creating a array copy from 0 to 4, then turning into list, then finding min of list
		int min = Collections.min(Arrays.asList(Arrays.copyOfRange(caseManagersCases, 0, 4)));
			
		//check if turn is senior case manager (First Checks if is senior manager)
		if (currentTurn == CHERYL_TURN_NUMBER || currentTurn == CHRIS_TURN_NUMBER) {
			//Create nested loop to ensure turn number does not run other if statement and ends here.
			if (turnLoop == 2) {
				//Reset loop after both senior case managers had been given cases
				if (currentTurn == CHRIS_TURN_NUMBER) {
					System.out.println("Loop Reset");
					turnLoop = 0;
				}
				return true;
			} else {
				return false;
			}
		}
		
		//Check if current turn is less than lowest + 1
		if (caseManagersCases[currentTurn] <= min + 1) {
			return true;
		}	
		return false;
	}
	
	
	public static int inputCasesAdded() {
	    Scanner scanner = new Scanner(System.in);
		System.out.println("How many cases to add? ");
		int casesAdded = scanner.nextInt();
		return casesAdded;
	}
	
	public static void addCases(int casesToAdd) {
		caseManagersCases[currentTurn] = caseManagersCases[currentTurn] + casesToAdd;
		
		//Reset System.
		iterateTurn();
		saveToFile();
	}
	
	public static void saveToFile() {
		try {
			//Create FileWriterer wrapped in buffer writer for increased performance 
			BufferedWriter writer = new BufferedWriter(new FileWriter("CaseCount.txt"));
		     
			for (int i = 0; i < TOTAL_CASE_MANAGERS; i++) {
				writer.write(caseManagerNames[i] + " " + caseManagersCases[i]);
				writer.newLine(); // Add a new line after each entry
			}
			
			writer.write("CurrentTurn ");
			writer.write(String.valueOf(currentTurn)); //Write as String by converting instead of writing as unicode
			
			writer.newLine(); // Add a new line after each entry
			
			writer.write("TurnLoop ");
			writer.write(String.valueOf(turnLoop)); //Write as String by converting instead of writing as unicode
			
			writer.close();
		      
		    } catch (IOException e) {
		      System.out.println("An error occurred.");
		      e.printStackTrace();
		    }
	}
	
	public static void main(String[] args) throws IOException {
		getFileInformation();
		new v2InputCaseTracker(); // Call Constructor to create window
		
		while (true) {
			
			System.out.println(Arrays.toString(caseManagerNames));
			System.out.println(Arrays.toString(caseManagersCases));
			
			
			//Iterate through case managers until turn is legal
			while (!islegalTurn()) {
				iterateTurn();
			}
			
			System.out.println();
			System.out.println("Current turn is: " + findCurrentCaseManagerName());
			//System.out.println("Turn Loop Currently: " + turnLoop);
			//System.out.println("Current turn: " + (currentTurn + 1));
			int casesAdded = inputCasesAdded();
			addCases(casesAdded);
			
		}
		
	}
}


//DEBUG CODE

/* Copy of code with debug comments
 * //Updates Turn to next person in list (up to down)
	public static boolean islegalTurn() {
		currentCaseManagerName = findCurrentCaseManagerName();
			
		//Find current min number in array while ignoring total of senior case managers
		//Finds min by first creating a array copy from 0 to 4, then turning into list, then finding min of list
		int min = Collections.min(Arrays.asList(Arrays.copyOfRange(caseManagersCases, 0, 4)));
			
		//check if turn is senior case manager (First Checks if is senior manager)
		if (currentTurn == CHERYL_TURN_NUMBER || currentTurn == CHRIS_TURN_NUMBER) {
			//Create nested loop to ensure turn number does not run other if statement and ends here.
			if (turnLoop == 2) {
				//System.out.println("Turn is legal");
				//1
				//System.out.println("Min Currently: " + min + "." + " Current Turn: " + currentCaseManagerName + "." + " Current Case Load: " + caseManagersCases[currentTurn] + "." + " Passsed at 1");
				//Reset loop after both senior case managers had been given cases
				if (currentTurn == CHRIS_TURN_NUMBER) {
					System.out.println("Loop Reset");
					turnLoop = 0;
				}
				return true;
			} else {
				//System.out.println("Turn not allowed");
				//2
				//System.out.println("Min Currently: " + min + "." + " Current Turn: " + currentCaseManagerName + "." + " Current Case Load: " + caseManagersCases[currentTurn] + "." + " Turnloop: " + turnLoop + "." + " Failed at 2");
				return false;
			}
		}
		//Check if current turn is less than lowest + 1
		if (caseManagersCases[currentTurn] <= min + 1) {
			//System.out.println("Turn is legal");
			//3
			//System.out.println("Min Currently: " + min + "." + " Current Turn: " + currentCaseManagerName + "." + " Current Case Load: " + caseManagersCases[currentTurn] + "." + " Passed at 3");
			return true;
		}	
		//System.out.println("Turn not allowed");
		//4
		//System.out.println("Min Currently: " + min + "." + " Current Turn: " + currentCaseManagerName + "." + " Current Case Load: " + caseManagersCases[currentTurn] + "." + " Failed at 4");
		return false;
	}
	*/
