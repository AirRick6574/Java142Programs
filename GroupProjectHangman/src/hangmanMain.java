import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;


public class hangmanMain {
	// Create a Scanner object to read input from the console
	  
	static Scanner scanner = new Scanner(System.in); 
	
	static final int NUMBER_OF_CHANCES = 5;
	public static int failedAttempts = 0;
	
	public static final String WORD_NAME = gatherStartInput();
	
	public static String gatherStartInput() {
		System.out.print("What is word? \n");
		String name = scanner.nextLine(); // Read a full line of text
		
		return name;
	}
	
	public static char gatherGeussInput() {
		System.out.println("What is your guess");
		char charGeuss = scanner.next().charAt(0); //next() function returns the next token/word in the input as a string and charAt(0) function returns the first character in that string,
		
		return charGeuss;
	}
	
	public static List<Character> wordProcess(char charGeuss, int matchedLetter, List<Character> coveredWordList) {
		coveredWordList.set(matchedLetter, charGeuss);
		System.out.println(coveredWordList);
		return coveredWordList;
	}
	
	public static void countCharacters(String wordName, char charGeuss, List<Character> coveredWordList) {
		int charactersMatch = 0;
		
		for (int i = 0; i < wordName.length(); i++) {
			if (charGeuss == wordName.charAt(i)){
				System.out.println(charGeuss + " matches at Letter " + (i+1));
				charactersMatch++;
				coveredWordList = wordProcess(charGeuss, i, coveredWordList);
			}
		}
		if (charactersMatch == 0) {
			failedAttempts++;
		}
		System.out.println("Characters that matched " + charactersMatch);
		System.out.println(failedAttempts);
	}
	
	public static void main(String[] args) {
		System.out.println("word is: " + WORD_NAME);
		
		int wordCount = WORD_NAME.length();
		System.out.println("WordCount is: " + wordCount);
		
		List<Character> coveredWordList = new ArrayList<>();
		for (int i = 0; i < wordCount; i++) {
			coveredWordList.add('*');
		}
		
		//Loop
		while (coveredWordList.contains('*')) {
			if (failedAttempts == NUMBER_OF_CHANCES) {
				System.out.println("\nYou Failed");
				System.exit(1); 
			}
			System.out.println(coveredWordList);
			
			char charGuess = gatherGeussInput();
			System.out.println("character guess is: " + charGuess);
			
			countCharacters(WORD_NAME, charGuess, coveredWordList);
		}
		System.out.println("Game Over, You Won");
		
	}
} 
