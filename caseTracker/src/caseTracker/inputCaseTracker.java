package caseTracker;

import java.awt.BorderLayout;
import java.awt.PageAttributes.OriginType;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class inputCaseTracker {
	
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
	
	public static void main(String[] args) throws FileNotFoundException {
		getFileInformation();
		
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
