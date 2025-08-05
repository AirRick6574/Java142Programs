import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class FileExamples {
	public static void main(String[] args) throws FileNotFoundException { //throws will declare and accept exception if it happens
		
		File file = new File("hiclass.txt"); //creates new object, creates object which will point to file path
		File fileTest = new File("/Users/ewok/Documents/Java142SchoolRepository/public.txt"); //creates new object, creates object which will point to file path
		System.out.println(file.exists()); //Checks if file exists in system folder
		System.out.println(fileTest.exists()); //Checks if file exists in system folder
		
		System.out.println(file); //Prints contents of object (Filepath)
		System.out.println(fileTest); //Prints contents of object (Filepath test)
		
		File fileSeperatorFile = new File(File.separator + "Users" + File.separator + "ewok" + File.separator + "Documents" + File.separator); 
		//File.seperator will use the correct file separator based on the operation system separator. 
		
		System.out.println(fileSeperatorFile);
		
		System.out.println(file.getPath()); //gets contents (file path of object) similar to println
		
		System.out.println(); 
		
		
		// Create a File object for C:\Users\Default\Documents\hiclass.txt
		File notepad = new File("/Users/ewok/Documents/Java142SchoolRepository/Lesson_07_21_2025/src/hiclass.txt");
		
		System.out.println("Hi class exists in folder!!!!!  " + notepad.exists()); // True if file exists
		System.out.println("length of file is : " + notepad.length()); // Length of file in bytes (Counts text characters and spacing in nutshell)
		
		// Read all the lines of the file
		
		Scanner s = new Scanner(notepad); //can throw error if non existant. 
		System.out.println("\n----------------------------------"); 
		
		while (s.hasNextLine()) { // As long as there are more lines to read
			String line = s.nextLine(); // Read the next line
			System.out.println(line); // Print it out
			}
		
		Scanner j = new Scanner(notepad); //can throw error if non existant. 
		System.out.println("\n-------------------------------"); 
		
		String token1 = j.next(); //creates new scanner j for next block of code
		System.out.println(token1); //prints first token found of scanner ("South")
		
		if (j.hasNextInt()) { //checks if next token is a integer and will run code
			int token2 = j.nextInt(); //attaches variable to next token which is integer
			System.out.println(token2);
		}
		
		if (j.hasNext()) { //checks if next token is a string and will run code
			String token3 = j.next(); //attaches variable to next token which is integer
			System.out.println(token3);
		}
			
			

	}
}
