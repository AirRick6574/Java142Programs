import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class askFileName {
	public static String askFileName() {
		Scanner ScannerSystem = new Scanner(System.in);
		
		while (true) {
			System.out.print("Type a file name: " );
			String fileName = ScannerSystem.next();
			
			File file = new File(fileName);
			if (file.exists() == true) {
				return fileName;
			}
		}
	}


	public static void flipCoins(Scanner scanner) throws FileNotFoundException {
		int headsCounter = 0;
		int tailsCounter = 0;
		int coinsCount = 0;
		
		String fileName = scanner.next();
		File file = new File(fileName);
		
		Scanner systemScanner = new Scanner(file);
		while (systemScanner.hasNextLine()) { // As long as there are more lines to read
			String line = systemScanner.next(); // Read the next line
			
			switch (line.toLowerCase()) {
				case "h":
					headsCounter++;
					coinsCount++;
					continue;
				case "t":
					tailsCounter++;
					coinsCount++;
					continue;
			};
			
		}
		
		double percentage = headsCounter / coinsCount;
		System.out.println(headsCounter + " heads (" + (int)percentage + "%)" );
		
		if (headsCounter > tailsCounter) {
			System.out.println("There were more heads!");
		}
		
		
	}

	public static void flipCoin(Scanner fileScanner) {
	    // For each line in the file (each set of coin flips)
		
        
	    while (fileScanner.hasNextLine()) {
	    	int headsCounter = 0;
	        int coinsCount = 0;
	        int tailsCounter = 0;
	        
	        String line = fileScanner.nextLine();
	        Scanner lineScanner = new Scanner(line);
	        
	        // Read tokens (flips) in the line
	        while (lineScanner.hasNext()) {
	            String token = lineScanner.next();
	            if (token.equalsIgnoreCase("h")) {
	                headsCounter++;
	                coinsCount++;
	            } else if (token.equalsIgnoreCase("t")) {
	            	tailsCounter++;
	                coinsCount++;
	            } 
	        }
	        
	        lineScanner.close();
	        
	        int percentage = (int) ((double) headsCounter / coinsCount * 100);
			System.out.println(headsCounter + " heads (" + percentage + "%)" );
			
			if (headsCounter > tailsCounter) {
				System.out.println("There were more heads!");
			}
			
			System.out.println();
	    }
	}
	
	
	
}