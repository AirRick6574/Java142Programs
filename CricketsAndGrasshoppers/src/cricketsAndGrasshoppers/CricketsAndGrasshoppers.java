package cricketsAndGrasshoppers;

import java.util.Scanner;

/**
 * Simulates a two-player board game where Crickets move right and
 * Grasshoppers move left on a linear strip. Players alternate turns
 * until one cannot move.
 * @author Erick Ruiz
 */
public class CricketsAndGrasshoppers {
	
	/**
	 * Cricket represented by number 1, used for Board lists
	 */
	public static final int NUMBER_REPRESENTING_CRICKETS = 1;
	/**
	 * Grasshopper represented by number 1, used for Board lists
	 */
	public static final int NUMBER_REPRESENTING_GRASSHOPPERS = 2;
	/**
	 * Empty Spaces represented by number 0, used for Board lists
	 */
	public static final int NUMBER_REPRESENTING_EMPTYSPACE = 0;
	/**
	 * Cricket represented by String C, used for Board lists to create String Board List
	 */
	public static final String CHARACTER_REPRESENTING_CRICKETS = "C";
	/**
	 * Grasshoppers represented by String G, used for Board lists to create String Board List
	 */
	public static final String CHARACTER_REPRESENTING_GRASSHOPPERS = "G";
	/**
	 * EmptySpaces represented by String ., used for Board lists to create String Board List
	 */
	public static final String CHARACTER_REPRESENTING_EMPTYSPACE = ".";
	/**
	 * Direction of the cricket, 1 signifies moving forward position = position + 1
	 */
	public static final int CRICKET_MOVE_DIRECTION = 1;
	/**
	 * Direction of the Grasshopper, -1 signifies moving forward position = position - 1
	 */
	public static final int GRASSHOPPER_MOVE_DIRECTION = -1;
	/**
	 * Max number of players allowed, used for main method
	 */
	public static final int PLAYER_LIMIT_MAX = 10;
	
	/**
	 * Max number of open spaces allowed, used for main method
	 */
	public static final int OPEN_SPACES_MAX = 9;
	
	/**
	 * promptNumberReadLine will 3 parameters, return int. Will print out prompt,
	 * Use scanner to read input and check if number is
	 * 1. integer
	 * 2. Within 1 and Max
	 * @param scanner the Scanner to use for input
	 * @param prompt String that will be printed out
	 * @param the maximum allowed value
	 * @return a validated integer input from the user
	 */
	public static int promptNumberReadLine(Scanner scanner, String prompt, int max) {
		int inputNumber;
		
		while (true) {
			System.out.print(prompt);
			
			//Checks if next line is Int
			if(!scanner.hasNextInt()) {
				System.out.println("That was not a valid number! Please try again.");
				scanner.nextLine(); //Clears Line to prevent Loop
				continue;
			}
			
			inputNumber = scanner.nextInt();
			scanner.nextLine(); // consume leftover newline
			
			//Check if input number is within limits
			if (1 > inputNumber || inputNumber > max) {
				System.out.println("That was not a valid number! Please try again.");
				continue;
			}
			return inputNumber;	
		}		
	}
	
	/**
	 * Create Board process the amount of playerPieces and amount of Spaces 
	 * and returns a array containing playerPieces of both sides (Grasshoppers and Crickets)
	 * and the spaces in between the two side
	 * Example Output: [1, 1, 1, 0, 0, 0, 2, 2, 2]
	 * @param piecesPerPlayer number for the amount of players on both sides
	 * @param spacesInMiddle amount of spaces in middle, also a number
	 * @return returns int[] array of the board with both sides of players 
	 * (Grasshoppers and Crickets) and the spacing in between
	 */
	public static int[] createBoard(int piecesPerPlayer, int spacesInMiddle) {
		int totalBoardSize = (piecesPerPlayer * 2) + spacesInMiddle;
		int[] currentBoardList = new int[totalBoardSize];
		
		//Create Cricket Characters in List Loop
		for (int j = 0; j < piecesPerPlayer; j++) {
			currentBoardList[j] = NUMBER_REPRESENTING_CRICKETS;
		}
		
		//Create Grasshopper Characters in List Loop
		for (int i = totalBoardSize - 1; i >= totalBoardSize - piecesPerPlayer ; i--) {
			currentBoardList[i] = NUMBER_REPRESENTING_GRASSHOPPERS;
		}
		
		return currentBoardList;
	}
	
	/**
	 * Converts given int[] array into a String
	 * @param board int[] array representing open spaces, players in 0, 1, 2
	 * @return will return a String of the board
	 */
	public static String boardToString(int[] board) {
		String boardStringOutput = "";
		
		//For loop to iterate over List
		for (int i = 0; i < board.length; i++) {
			//Check which number is in list element using cases
			switch (board[i]) {
				case NUMBER_REPRESENTING_CRICKETS: 
					boardStringOutput += (CHARACTER_REPRESENTING_CRICKETS); 
					break;
				case NUMBER_REPRESENTING_GRASSHOPPERS:
					boardStringOutput += CHARACTER_REPRESENTING_GRASSHOPPERS; 
					break;
				case NUMBER_REPRESENTING_EMPTYSPACE: 
					boardStringOutput += CHARACTER_REPRESENTING_EMPTYSPACE; 
					break;
			}
		}
		return boardStringOutput;
	}
	
	/**
	 * Will check if player has any available positions, will return false in no positions
	 * are available 
	 * @param board int[] array that will be checked for available positions
	 * @param player (int) player that needs to be checked for available positions 
	 * @return returns boolean, True if position is available, false if no more positions
	 */ 
	public static boolean canMove(int[] board, int player) {
		int direction;
		
		if (player == NUMBER_REPRESENTING_CRICKETS) {
			direction = CRICKET_MOVE_DIRECTION;
		} else {
			direction = GRASSHOPPER_MOVE_DIRECTION;
		}
		
		for (int i = 0; i < board.length; i++) {
			//Check if current position is of player
			if (board[i] != player) {
				continue;
			} 
			
			int oneStepPosition = i + direction;
			int hopStepPosition = i + (direction * 2);
			
			//Check one step
			if (oneStepPosition >= 0 && oneStepPosition < board.length 
					&& board[oneStepPosition] == NUMBER_REPRESENTING_EMPTYSPACE) {
				return true;
			}
			
			//Check Hop, must hop over a space that is not empty into empty space
			if (hopStepPosition >= 0 && hopStepPosition < board.length 
					&& board[oneStepPosition] != NUMBER_REPRESENTING_EMPTYSPACE
					&& board[oneStepPosition] != player  
					&& board[hopStepPosition] == NUMBER_REPRESENTING_EMPTYSPACE) {
				return true;
			}
		}
		return false;
	}
	
	/**
	 * Will move the position of the player by rewriting board array
	 * @param board int[] array of player board that will be rewritten for move
	 * @param player player that will be moved, also used to determine direction
	 * @param position positions that the player wants to move from. 
	 * @return true if move was successful, false if cannot move
	 */
	public static boolean move(int[] board, int player, int position) {
		
		//Check if position is in array
		if (position < 1 || position > board.length) {
		    return false; // Invalid position
		}
		
		//Check 
		int listPositionIndex = position - 1;
	    if (board[listPositionIndex] != player) {
	        return false;
	    }
		
		int direction;
		
		if (player == NUMBER_REPRESENTING_CRICKETS) {
			direction = CRICKET_MOVE_DIRECTION;
		} else {
			direction = GRASSHOPPER_MOVE_DIRECTION;
		}
		
		int oneStepPosition = position + direction - 1;
		int hopStepPosition = position + (direction * 2) - 1;
		
		//Check one step
		if (oneStepPosition >= 0 && oneStepPosition < board.length 
				&& board[oneStepPosition] == NUMBER_REPRESENTING_EMPTYSPACE) {
			board[oneStepPosition] = board[position - 1];
			board[position - 1] = 0;
			return true;
		}
		
		//Check Hop, must hop over a space that is not empty into empty space
		if (oneStepPosition >= 0 && oneStepPosition < board.length 
				&& hopStepPosition >= 0 && hopStepPosition < board.length 
				&& board[oneStepPosition] != NUMBER_REPRESENTING_EMPTYSPACE
				&& board[oneStepPosition] != player  
				&& board[hopStepPosition] == NUMBER_REPRESENTING_EMPTYSPACE) {
			board[hopStepPosition] = board[position - 1];
			board[position - 1] = 0;
			return true;
		}
		return false;
	}
	
	/**
	 * Will begun initializing the game, asking for needed prompts 
	 * and then creating board based on prompts 
	 * @param scanner the Scanner to use for input
	 * @return returns array of called method createBoard 
	 * (will create a board based on input variables)
	 */
	public static int[] initializeGame(Scanner scanner) {
	    int piecesPerPlayer = promptNumberReadLine(
	            scanner,
	            "Please enter the number of pieces for each player (1-" + PLAYER_LIMIT_MAX + "): ",
	            PLAYER_LIMIT_MAX);

	    int spacesInMiddle = promptNumberReadLine(
	            scanner,
	            "Please enter the number of spaces in the middle (1-" + OPEN_SPACES_MAX + "): ",
	            OPEN_SPACES_MAX);

	    return createBoard(piecesPerPlayer, spacesInMiddle);
	}
	
	/**
	 * switches playerTurn to other player  
	 * @param playerTurn integer representing the players turn
	 * @return playerturn after it has been swapped
	 */
	public static int switchPlayer(int playerTurn) {
		// Switch players (Tried learning ternary operators Here) 
		playerTurn = (playerTurn == NUMBER_REPRESENTING_CRICKETS)
				? NUMBER_REPRESENTING_GRASSHOPPERS
				: NUMBER_REPRESENTING_CRICKETS;
		return playerTurn;
	}
	
	/**
	 * Method will play the turn, asking for requested move, 
	 * checking if move is possible and then updating board once move has been done. 
	 * @param ScannerSystem the Scanner to use for input
	 * @param currentIntBoard array of the current board
	 * @param playerTurn integer representing whose turn it is
	 */
	public static void playTurn(Scanner ScannerSystem, int[] currentIntBoard, int playerTurn) {
		String movePrompt = 
				(playerTurn == NUMBER_REPRESENTING_CRICKETS ? "Crickets" : "Grasshoppers")
		        + ", please enter your move (1-" + currentIntBoard.length + "): ";
		
		boolean allowedMove = false;
		
		while (!allowedMove) {
			int playerPosition = promptNumberReadLine(
					ScannerSystem, 
					movePrompt, 
					currentIntBoard.length);
			
			if (currentIntBoard[playerPosition - 1] != playerTurn) {
				System.out.println("That space does not contain a "
						+ "piece you can move! Please try again.");
				continue;
			}
			
			allowedMove = move(currentIntBoard, playerTurn, playerPosition);
			
			if (!allowedMove) {
				System.out.println("That space does not contain a piece you can move! "
						+ "Please try again.");
			}	
		}
	}
	
	/**
	 * Will run game by calling other methods, ends loops when one side cannot move
	 * Prompts for game conditions, then alternate turns
	 * @param args Legacy Code
	 */
	public static void main(String[] args) {
		//Introductory Code Before Loop
		Scanner ScannerSystem = new Scanner(System.in);
		int[] currentIntBoard = initializeGame(ScannerSystem);
		
		int playerTurn = 1;
	
		System.out.println(boardToString(currentIntBoard));
		
		while (canMove(currentIntBoard, playerTurn)) {
			
			playTurn(ScannerSystem, currentIntBoard, playerTurn);
			
			playerTurn = switchPlayer(playerTurn);
			
			if (!canMove(currentIntBoard, playerTurn)) {
		    	break;
		    }
		    
		    System.out.println(boardToString(currentIntBoard));
		}
		
		// Game over - the other player wins
		//(Tried learning ternary operators Here) 
	    String winner = (playerTurn == NUMBER_REPRESENTING_CRICKETS) 
	    		? "Grasshoppers" 
	    		: "Crickets";
	    System.out.println(winner + " win!");
	}
}





