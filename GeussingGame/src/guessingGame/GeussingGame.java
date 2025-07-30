package guessingGame;

import java.util.Arrays;
import java.util.function.IntPredicate;

public class GeussingGame {
	
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
		
		//While guess is not correct 
		while (!guessIsCorrect) {
			
			//Prompt for a guess sequence
			promptForGuess(SEQUENCE_LENGTH, NUM_POSSIBLE_GUESSES);
			
			//Read guess from keyboard
			String guessString = readGuessInput();
			
			//Parse the guess sequence 
			int[] parsedGeuss = parseGuess(guessString);
			
			//Determine number of black and white pegs
			int numWhitePegs = countWhitePegs(secretSequence, parsedGeuss);
			int numBlackPegs = countBlackPegs(secretSequence, parsedGeuss);
			
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
		int[] secretSequence = new int[lengthofSequence];
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
		System.out.println("Geuss");
	}
	
	/**
	 * Will gather input from scannner. Will be returned as string
	 * @author Erick Ruiz
	 * @return will return the input as string 
	 */
	public static String readGuessInput() {
		
		return "2341";
	}
	
	/**
	 * @author Erick Ruiz
	 * @param guess String gathered from scanner input
	 * @return will return String guess after being converted to int
	 */
	public static int[] parseGuess(String guess) {
		int[] parsedDummyGeuss = {1, 2, 3 , 4};
		return parsedDummyGeuss;
	}
	
	/**
	 * @author Erick Ruiz
	 * @param secretSequence
	 * @param parsedGeuss
	 * @return
	 */
	public static int countBlackPegs(int[] secretSequence, int[] parsedGeuss) {
		return 4;
	}
	
	/**
	 * @author Erick Ruiz
	 * @param secretSequence
	 * @param parsedGeuss
	 * @return
	 */
	public static int countWhitePegs(int[] secretSequence, int[] parsedGeuss) {
		return 0;
	}
	
	/**
	 * @author Erick Ruiz
	 * @param numBlackPegs
	 * @param numWhitePegs
	 */
	public static void displayPegs(int numBlackPegs, int numWhitePegs) {
		System.out.println("0, 4");
	}
	
	public static void displayWinMessage() {
		System.out.println("YOU WON");
		
	}
	
	
}
