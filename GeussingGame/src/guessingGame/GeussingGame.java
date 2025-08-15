package guessingGame;

import java.io.Console;
import java.util.Arrays;
import java.util.Scanner;
import java.util.function.IntPredicate;

//import sun.security.util.Length;

public class GeussingGame {
	
	private static final int FIRST_COLOR = 1;

	/**
	 * Represents the length of the sequence 
	 */
	public static final int SEQUENCE_LENGTH = 4;
	
	/**
	 * Represents the number of possible guesses
	 */
	public static final int NUM_POSSIBLE_GUESSES = 4;
	
	/**
	 * Main Method to run the guessing game
	 * @author Erick Ruiz
	 * @param args Ignored. Legacy 
	 */
	public static void main(String[] args) {
		//Create secret Sequence -- createSecretSequence(int lengthOfSeqeunce, int numPossibleColumns)
		int[] secretSequence = createSecretSequence(SEQUENCE_LENGTH, NUM_POSSIBLE_GUESSES);
		
		boolean guessIsCorrect = false;
		
		//Prompt for a guess sequence
		promptForGuess(SEQUENCE_LENGTH, NUM_POSSIBLE_GUESSES);
		
		boolean inputIsValid = false;
		
		//While guess is not correct 
		while (!guessIsCorrect) {
			while(!inputIsValid) {
				//Create a guess scanner
				Scanner console = new Scanner(System.in);
				
				//Read guess from keyboard
				String guessString = readGuessInput(console);
			
				//Check length of guessString and rerun until appropriate length 
				//if
				
			//Parse the guess sequence 
			int[] parsedGeuss = parseGuess(guessString);
			
			//Determine number of white pegs
			int numWhitePegs = countWhitePegs(secretSequence, parsedGeuss);
			
			//Determine number of black 
			int numBlackPegs = countBlackPegs(secretSequence, parsedGeuss);
			
			//Test number of black pegs
			//System.out.println(Arrays.toString(secretSequence));
			
			if (numBlackPegs == SEQUENCE_LENGTH) {
				guessIsCorrect = true;
			}
			
			//Display Pegs
			displayPegs(numBlackPegs, numWhitePegs);
		}
		//Display Win Message
		
		System.out.println(Arrays.toString(createSecretSequence(4, 6)));
		displayWinMessage();
		}
	}
	
	/**
	 * Create a random sequences of integers (representing colors) of the specified length 
	 * from the specified number of colors
	 * 
	 * @author Erick Ruiz
	 * 
	 * @param lengthofSequence The length of the secret sequence of colors
	 * @param numPossibleColors The number of colors from which the sequence is drawn 
	 * @return The secret sequence of integers representing colors.
	 */
	public static int[] createSecretSequence(int lengthofSequence, int numPossibleColors) {
		
		//Create s secret sequence of colors.
		int[] secretSequence = new int[lengthofSequence];
		
		//Populate the sequence with random colors
		for (int i = 0; i < lengthofSequence; i++) {
			secretSequence[i] = (int)(Math.random() * numPossibleColors) + 1;
		}
		return secretSequence;
	}
	
	/**
	 * @author Erick Ruiz
	 * @param lengthOfSequence
	 * @param numPossibleColors
	 */
	public static void promptForGuess(int lengthOfSequence, int numPossibleColors) {
		System.out.println("Please enter a sequence of " + lengthOfSequence 
				+ " between " + FIRST_COLOR + " - " + numPossibleColors + ":");
	}
	
	/**
	 * Will gather input from scannner. Will be returned as string
	 * @author Erick Ruiz
	 * @return will return the input as string 
	 */
	public static String readGuessInput(Scanner console) { //scanner name is console 
		String inputString = console.nextLine();
		
		return inputString;
		
	}
	
	/**
	 * @author Erick Ruiz
	 * @param guess String gathered from scanner input
	 * @return will return String guess after being converted to int
	 */
	public static int[] parseGuess(String guess) {
		char[] guessChars = guess.toCharArray(); //converts guess into a array of characters
		
		//System.out.println("sdadasdsas " + Arrays.toString(guessChars));
		
		//Create int array with length being constant
		int[] parsedGeuss = new int[SEQUENCE_LENGTH];
		
		for (int i = 0; i < guessChars.length; i++) {
			parsedGeuss[i] = Character.getNumericValue(guessChars[i]);
		}
		
		return parsedGeuss;
	}
	
	/**
	 * @author Erick Ruiz
	 * @param secretSequence
	 * @param parsedGeuss
	 * @return
	 */
	public static int countBlackPegs(int[] secretSequence, int[] parsedGeuss) {
		int numBlackpegs = 0;
		
		for (int i = 0; i < secretSequence.length; i++) {
			if (secretSequence[i] == parsedGeuss[i]) {
				numBlackpegs++;
			}
		}
		return numBlackpegs;
	}
	
	/**
	 * @author Erick Ruiz
	 * @param secretSequence
	 * @param parsedGeuss
	 * @return
	 */
	public static int countWhitePegs(int[] secretSequence, int[] parsedGeuss) { //Mark Correct numbers in incorrect locations as white peg
		
		
		// Keep track of which sequence digits were matched
		boolean[] wasDigitMatched = new boolean[secretSequence.length];
		int numWhitePegs = 0;
		// Look at each of the guess digits
		for (int i = 0; i < parsedGeuss.length; i++) {
			// If this guess was a perfect match, skip it
			if (parsedGeuss[i] == secretSequence[i]) {
				continue;
			}
			/* Otherwise, try to match guess digit against each of the
			 * secret sequence digits */
			for (int j = 0; j < secretSequence.length; j++) {
				if (parsedGeuss[i] == secretSequence[j] // If there is a numerical match
					// and that match doesn’t have a perfect match (black peg)
					&& secretSequence[j] != parsedGeuss[j]
					// and it wasn't already matched
					&& !wasDigitMatched[j]) {
					
					numWhitePegs++; // We have found a white-peg match!
					// Don’t match this sequence digit again!
					wasDigitMatched[j] = true;
					break; // Quit trying to match this guess digit!
				}
			}
		}
		return numWhitePegs;
	}

	/**
	 * @author Erick Ruiz
	 * @param numBlackPegs
	 * @param numWhitePegs
	 */
	public static void displayPegs(int numBlackPegs, int numWhitePegs) {
		//System.out.println("0, 4");
		System.out.println("Black Pegs: " + numBlackPegs);
		System.out.println("White Pegs: " + numWhitePegs);
	}
	
	public static void displayWinMessage() {
		System.out.println("YOU WON");
		
	}
	
	
}
