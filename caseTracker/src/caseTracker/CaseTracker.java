package caseTracker;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.print.Printable;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.concurrent.CountDownLatch;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class CaseTracker {
	
	public static final int CHERYL_TURN_NUMBER = 4;
	public static final int CHRIS_TURN_NUMBER = 5;
	
	
	public static int count = 5; 
	public static int loopCount = 0; //Counter for when cycle loops to zero
	
	
	private JFrame caseTrackerFrame;
	private JPanel caseManagerPanel; 
	
	//Constructor Method, (Create GUI)
	public CaseTracker() {
		caseTrackerFrame = new JFrame();
		caseTrackerFrame.setSize(800, 600); // Sets the frame to 800 pixels wide and 600 pixels high
		caseTrackerFrame.setAlwaysOnTop(true);  // force top
		
		//Case Manager Panel
		caseManagerPanel = new JPanel(); //Panel to contain CaseManager content
		//panel.setBorder(BorderFactory.createEmptyBorder(100, 100, 100, 100)); //Sets boarder while creating new boarder with size positions
		caseManagerPanel.setLayout(new GridLayout(6, 2)); //uses grid layout to set layout of panel window (0 rows, 1 column)
		
		
		caseTrackerFrame.add(caseManagerPanel, BorderLayout.CENTER); //add panels to frame and will center it
		caseTrackerFrame.setTitle("Case Counter"); //title frame
		caseTrackerFrame.pack(); //pack is used to automatically size the window to accommodate preferred sizes and layout. 
		caseTrackerFrame.setVisible(true); //Sets frame visible
			
	}
	
	//Gather Information and add to array. 
	public static Map<String, Integer> getInformation() throws FileNotFoundException {
		// Create a LINKED HASH MAP (Hashed map will create randomness) 
		//design a HashMap does not preserve insertion order.
        Map<String, Integer> caseManagersInfoMap = new LinkedHashMap<>();
        
        //Load File 
        //ASSUMES FILE IS IN FORMAT
        try (Scanner scanner = new Scanner(new File("CaseCount.txt"))) {
            while (scanner.hasNext()) {
                String key = scanner.next(); //gets next name
                int value = scanner.nextInt(); //Get next int
                caseManagersInfoMap.put(key, value); //Puts value in map
            }
        }
        //Return Map of Case Managers
        return caseManagersInfoMap;
	}
	
	public static void updateInformationToFile(Map<String, Integer> caseManagersInfoMap) throws FileNotFoundException {
		try (PrintWriter writer = new PrintWriter(new File("CaseCount.txt"))) {
			 for (var entry : caseManagersInfoMap.entrySet()) {
			     writer.println(entry.getKey() + " " + entry.getValue());
			 }
		}
	}
	
	
	public static String findCurrentCaseManagerName(Map<String, Integer> caseManagersInfoMap, int person) {
		int i = 0;
		for (String key : caseManagersInfoMap.keySet()) {
			if (i == person) {
				return key;
			}
			i++;
		}
		return "Person Non Existent";
	}
	
	//Updates Turn to next person in list (up to down)
	public static void iterateTurn(Map<String, Integer> caseManagersInfoMap) {
		count++;
		
		//Check if count will exceed Amount of Case Managers, if yes reset.
		//Update loop count
		if (count >= caseManagersInfoMap.size()) {
			count = 0;
			loopCount++;
		}
	}
	
	//Updates Turn to next person in list (up to down)
	public static void islegalTurn(Map<String, Integer> caseManagersInfoMap, int count) {
		String currentCaseManager = findCurrentCaseManagerName(caseManagersInfoMap, count);
		
		//Check if current
		
		//check if turn is senior case manager
		if (count == CHERYL_TURN_NUMBER || count == CHRIS_TURN_NUMBER) {
			if (loopCount == 2) {
				System.out.println("Turn is legal");
			}
		}
		
		
	}
	
	//Adds Cases to Map
	public static void addCases(Map<String, Integer> caseManagersInfoMap, String caseManager, int casesAdded) {
		caseManagersInfoMap.put(caseManager,  caseManagersInfoMap.get(caseManager) + casesAdded);
	}
	
	public static void main(String[] args) throws FileNotFoundException {
		//new CaseTracker(); // Call Constructor to create window
		Map<String, Integer> caseManagersMap = getInformation();
		System.out.println(caseManagersMap);
		int minValue = Collections.min(caseManagersMap.values());
		System.out.println("Lowest Value: " + minValue);
		
		
		String testString = findCurrentCaseManagerName(caseManagersMap, count);
		System.out.println(testString);
		
		for (int i = 0; i < 8; i++) {
			iterateTurn(caseManagersMap);
			String testString2 = findCurrentCaseManagerName(caseManagersMap, count);
			System.out.println("Turn is " + testString2);
			
		}
		
		
	}
}


/*
//Manipulate
counters.put("a", counters.get("a") + 1);

//Save back
try (PrintWriter writer = new PrintWriter(new File("data.txt"))) {
 for (var entry : counters.entrySet()) {
     writer.println(entry.getKey() + " " + entry.getValue());
 }
*/