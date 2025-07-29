/**
 * Utility class to determine whether a move in the Farmer problem game is legal.
 */
public class FarmerProblem {
	
	/**
	 * Max Number of Items on Boat, excluding the farmer
	 */
	public static final int MAX_ITEMS_ON_BOAT = 1;
	/**
	 * Represent the Left Side of the river
	 */
	public static final int Left = 1;
	/**
	 * Represent the right side of the river
	 */
	public static final int Right = 2; 
	
	// Each before/after position variable is
	// 1 if that thing is on the starting side (left)
	// and 2 if that thing is on the ending side (right)
	
	/**
	 * Determines whether the move was legal. 1 = left. 2 = right.
	 * All parameters must be 1 or 2. 
	 * 
	 * @param wolfBefore The Position of the wolf before the move. 
	 * @param goatBefore The position of the goat before the move. 
	 * @param cabbageBefore The position of the cabbage before the move. 
	 * @param boatBefore The position of the boat before the move. 
	 * @param wolfAfter The position of the boat after the move.
	 * @param goatAfter The position of the boat after the move
	 * @param cabbageAfter The position of the cabbage after the move. 
	 * @returnIf True If move is allowed, false otherwise. 
	 */
	public static boolean isMoveLegal(int wolfBefore, int
			goatBefore, int cabbageBefore, int boatBefore, int wolfAfter, int
			goatAfter, int cabbageAfter) {
		
		
		//Check 1
		//Check the move against each rule, if move is violated.
		//immediately display error message and return false. 
			//If any move is not violated, return true
		int numThingsMoving = 0;
		
		numThingsMoving = checkMoving(wolfBefore, boatBefore, wolfAfter, numThingsMoving, "Wolf");
		if (numThingsMoving < 0) {
			return false;
		}
		
		numThingsMoving = checkMoving(goatBefore, boatBefore, goatAfter, numThingsMoving, "Goat");
		if (numThingsMoving < 0) {
			return false;
		}
		
		numThingsMoving = checkMoving(cabbageBefore, boatBefore, cabbageAfter, numThingsMoving, "Cabbage");
		if (numThingsMoving < 0) {
			return false;
		}
		
		//Check 2 
		//The boat can only hold one item. 
		//The farmer is combined with the boat in this representation. 
		//So only one item plus the boat can move. 
			//If more than one item moves, display message and return false. 
		
		if (numThingsMoving > MAX_ITEMS_ON_BOAT) {
			System.out.println("You are moving too many Items :(");
			return false;
		}
			
		//Check 3
		//We cannot leave any one item alone (without farmer on same side) 
		//with another item that it wants to eat. 
			//If item is left alone with an item it will eat, display error and return false.  
		int boatAfter = Right;
		if (boatBefore == Right) {
			boatAfter = Left;
		}
		if (boatBefore == Left) {
			boatAfter = Right;
		}
		
		if (wolfAfter == goatAfter && wolfAfter != boatAfter) {
			//If item is left alone with an item it will eat, display error and return false. 
			System.out.println("The Wolf would eat the goat");
			return false;
		} 
		
		if (goatAfter == cabbageAfter && cabbageAfter != boatAfter) {
			//If item is left alone with an item it will eat, display error and return false. 
			System.out.println("The Cabbage would eat the goat");
			return false;
		} 
		
		//Check whether Game has been won
		if (wolfAfter == Right && goatAfter == Right && cabbageAfter == Right) {
			System.out.println("You Win");
		}
		
		//If all checks have been completed and have passed, return True
		return true;
	}



	private static int checkMoving(int itemBefore, int itemAfter, int numThingMoving, int numThingsMoving, String thingName) {
		if (itemBefore != numThingMoving) {
			if(itemBefore != itemAfter) {
				//If any move is not violated, return true
				//Comment should line up with statement
				System.out.println(thingName + " must be on same side as boat!");
				return -1; //Indicates Rule violated since number cannot pass
			}
			numThingsMoving++;
		}
		return numThingsMoving;
	}
	
	/*
	public static int wouldEat(int itemEaterBefore, int itemEaterAfter, int itemEater) {
		
	}
	
	*/
	
	public static void main(String[] args) {
		
	}
}
