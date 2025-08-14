/*-----------------------------------------------------------------------------
 * This code has issues, needs fixing
 * ----------------------------------------------------------------------------
 * 
 */

import java.awt.im.InputContext;
import java.util.Arrays;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class pigLatin {
	public static void pigLatin(Scanner ScannerSystem) {
		String matchingWords = "aeiou";
		
		ScannerSystem.useDelimiter("\\Z"); 
		String fileString = ScannerSystem.next();
		
		String[] fileStringToArray = fileString.split(" ");
		
		for (int i = 0; i < fileStringToArray.length; i++) {
			//Check if String Array [i]'s first letter has exists in wordbank by checking if index returns more than 0 
			if (matchingWords.indexOf(Character.toLowerCase(fileStringToArray[i].charAt(0))) >= 0) {
				fileStringToArray[i] =  fileStringToArray[i] + "yay";  
			} else {
				fileStringToArray[i] =  fileStringToArray[i].substring(1) + fileStringToArray[i].charAt(0) + "ay";  
			}
			System.out.println(Arrays.toString(fileStringToArray));
		}
		
		String stringArraysToString = String.join(" ", fileStringToArray); 
		System.out.println(stringArraysToString);
	}
	
	public static void main(String[] args) throws FileNotFoundException {
		Scanner input = new Scanner(new File("Untitled1.txt"));
		pigLatin(input);
	}
}
