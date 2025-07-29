//Java doc comments for all constants
package assignmentTwo;

/**
 * @author 
 */

public class ManagersCrossing {
	
	/**
	 * 
	 */
	public static final int Left = 1;
	/**
	 * 
	 */
	public static final int Right = 2;
	public static final int MAX_PEOPLE_IN_BOAT = 2;
	
	/**
	 *  //engineers need to know its 1 or two
	 * @param boatBefore
	 * @param managerABefore
	 * @param managerBBefore
	 * @param managerCBefore
	 * @param engineerABefore
	 * @param engineerBBefore
	 * @param engineerCBefore
	 * @param boatAfter
	 * @param managerAAfter
	 * @param managerBAfter
	 * @param managerCAfter
	 * @param engineerAAfter
	 * @param engineerBAfter
	 * @param engineerCAfter
	 * @return
	 */
	
	public static boolean isMoveOkay(int boatBefore, int managerABefore, int managerBBefore, 
			int managerCBefore, int engineerABefore, int engineerBBefore, int engineerCBefore, 
			int boatAfter, int managerAAfter, int managerBAfter, int managerCAfter, 
			int engineerAAfter, int engineerBAfter, int engineerCAfter) {
		
		//Check First Rule, 
		//Rule: parameter variables are 1 or 2.
		//If Violated, Display message and return false
		
		//Check this
		if ((boatBefore != Left && boatAfter != Right) 
			|| (managerABefore != Left && managerAAfter != Right)
			|| (managerBBefore != Left && managerBAfter != Right)
			|| (managerCBefore != Left && managerCAfter != Right)
			|| (engineerABefore != Left && engineerAAfter != Right)
			|| (engineerBAfter != Left && engineerBAfter != Right) 
			|| (engineerCBefore != Left && engineerCAfter != Right)){
			System.out.println("All positions must be 1 or 2!");
			return false;	
		}
		
		//Check Second Rule:
		//Rule: Check that the boat is changing position
		//Error: The boat must move!, display and return false
		if (boatBefore == boatAfter) {
			System.out.println("The boat must move!");
			return false;
		}
		
		
		//Check Third Rule:
		//Rule: make sure that each person you’re trying to move is on the same side as the boat
		//Error: You may not move a person who is not with the boat! Display and return false
		
		
		//Check Fourth Rule:
		//Rule: Make Sure you are moving one or two people, print following message and return false
		//Error: You must move one or two people
		
		//Check Fifth Rule: 
		//Rule: Make Sure no manager would recruit anyone, There will be three separate checks, 
		//One for each manager A,B,C in that order.  For each check, if a recruitment would happen, 
		//print the following error message, replacing X  with A, B, or C as appropriate, and return false:
		//Error: Manager X would try to recruit someone!
		
		//Check Sixth Rule: 
		//Rule: if none of the errors above occurred, 
		//check to see if the after positions solve the puzzle. If so, print:
		//You solved the puzzle!
		
		//return True if no rules violated 
		
		
		
		return true;
	}
	
	public static void main(String[] args) {
		
	}
	//Rework this
	public static int checkMoving(int personBefore, int personAfter, int numThingMoving, int numThingsMoving) {
		if (personBefore != numThingMoving) {
			if(personBefore != personAfter) {
				System.out.println("You may not move a person who is not with the boat!");
				return -1;
			}
			numThingsMoving++;
		}
		return numThingMoving;
	}
}
