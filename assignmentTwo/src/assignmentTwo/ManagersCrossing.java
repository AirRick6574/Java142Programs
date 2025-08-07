package assignmentTwo;

/**
 * Class  ManagerCrossing is a helper library that will run checks to ensure 
 * that the Manager and Engineers game is ran fairly. It would also print outputs
 * based on game violations.
 * @author Erick Ruiz
 */
public class ManagersCrossing {
	
	/**
	 * Left Side of River. Assigned to Managers and Engineers on Left Side
	 */
	public static final int LEFT = 1;
	/**
	 * Right Side of River. Assigned to Managers and Engineers on Right Side
	 */
	public static final int RIGHT = 2;
	/**
	 * Constant MAX_PEOPLE_IN_BOAT will be used to ensure the maximum limit of 
	 * people in boat is checked and then enforced. 
	 */
	public static final int MAX_PEOPLE_IN_BOAT = 2;
	/**
	 * Constant MIN_PEOPLE_IN_BOAT will be used to ensure the minimum limit of 
	 * people in boat is checked and then enforced. 
	 */
	public static final int MIN_PEOPLE_IN_BOAT = 1;
	
	/**
	 * Method isValidPosition will take one parameter and will run a check to
	 * determine if the parameter is on a valid side. 
	 * @param pos Parameter (Engineer X or Manager X) that will be checked
	 * @return True if parameter is on a valid side. False if parameter is 
	 * on a invalid side. 
	 */
	public static boolean isValidPosition(int pos) {  
		return pos == LEFT || pos == RIGHT; 
	} //Returns true if parameter is 1 or 2 and false if otherwise different.
	
	/**
	 * Method checkMoving will take 4 Parameters and will run a check to determine if 
	 * parameter (Engineer X or Manager X) move is allowed.
	 * @param parameterBefore (Engineer X or Manager X) position before the move
	 * @param parameterAfter (Engineer X or Manager X) position before the move
	 * @param boatBefore Boat's position before the move. 
	 * @param numThingsMoving Number of things moving with the boat at once. Limit is 2. 
	 * @return Will return a integer. If move is not legal, the return integer will be -1.
	 * If move was legal, numThingsMoving will add one to itself and return itself. 
	 */
	public static int checkMoving(
			int parameterBefore, int parameterAfter, int boatBefore, int numThingsMoving) {
		if (parameterBefore != parameterAfter) {
			if(parameterBefore != boatBefore) {
				System.out.println("You may not move a person who is not with the boat!");
				return  -1;
				//indicate failure returning -1 instead of positive integer. 
			}
			numThingsMoving++;
		}
		return numThingsMoving;
	}
	
	/**
	 * isMoveOkay will run multiple checks to find violations of rules. If no rules are violated,
	 * the game will output a "puzzle solved".
	 * @param boatBefore Variable used to depict where Boat was previously before the move. 
	 * Variable can be assigned as 1 or 2. 1 means variable was on left before the move. 
	 * 2 means variable was on Right before the move. 
	 * @param managerABefore Variable used to depict where managerABefore was previously 
	 * before the move. Variable can be assigned as 1 or 2. 
	 * 1 means variable was on left before the move. 2 means variable was on Right before the move. 
	 * @param managerBBefore Variable used to depict where managerBBefore was previously 
	 * before the move. Variable can be assigned as 1 or 2. 
	 * 1 means variable was on left before the move. 2 means variable was on Right before the move. 
	 * @param managerCBefore Variable used to depict where managerCBefore was previously 
	 * before the move. Variable can be assigned as 1 or 2. 
	 * 1 means variable was on left before the move. 2 means variable was on Right before the move. 
	 * @param engineerABefore Variable used to depict where engineerABefore was previously 
	 * before the move. Variable can be assigned as 1 or 2. 
	 * 1 means variable was on left before the move. 2 means variable was on Right before the move. 
	 * @param engineerBBefore Variable used to depict where engineerBBefore was previously 
	 * before the move. Variable can be assigned as 1 or 2. 
	 * 1 means variable was on left before the move. 2 means variable was on Right before the move. 
	 * @param engineerCBefore Variable used to depict where engineerCBefore was previously 
	 * before the move. Variable can be assigned as 1 or 2. 
	 * 1 means variable was on left before the move. 2 means variable was on Right before the move.
	 * @param boatAfter Variable used to depict where Boat was previously after the move.
	 * Variable can be assigned as 1 or 2. 1 means variable was on left after the move. 
	 * 2 means variable was on Right after the move. 
	 * @param managerAAfter Variable used to depict where managerAAfter was previously 
	 * after the move. Variable can be assigned as 1 or 2. 
	 * 1 means variable was on left after the move. 2 means variable was on Right after the move. 
	 * @param managerBAfter Variable used to depict where managerBAfter was previously 
	 * after the move. Variable can be assigned as 1 or 2. 
	 * 1 means variable was on left after the move. 2 means variable was on Right after the move. 
	 * @param managerCAfter Variable used to depict where managerCAfter was previously 
	 * after the move. Variable can be assigned as 1 or 2. 
	 * 1 means variable was on left after the move. 2 means variable was on Right after the move. 
	 * @param engineerAAfter Variable used to depict where engineerAAfter was previously 
	 * after the move. Variable can be assigned as 1 or 2. 
	 * 1 means variable was on left after the move. 2 means variable was on Right after the move. 
	 * @param engineerBAfter Variable used to depict where engineerBAfter was previously 
	 * after the move. Variable can be assigned as 1 or 2. 
	 * 1 means variable was on left after the move. 2 means variable was on Right after the move. 
	 * @param engineerCAfter Variable used to depict where engineerCAfter was previously 
	 * after the move. Variable can be assigned as 1 or 2. 
	 * 1 means variable was on left after the move. 2 means variable was on Right after the move. 
	 * @return Will return false if any of the rule checks have been violated.
	 * if no rules have been violated, the return will be true. 
	 */
	public static boolean isMoveOkay(
			int boatBefore, 
			int managerABefore, 
			int managerBBefore, 
			int managerCBefore, 
			int engineerABefore, 
			int engineerBBefore, 
			int engineerCBefore, 
			int boatAfter, 
			int managerAAfter, 
			int managerBAfter, 
			int managerCAfter, 
			int engineerAAfter, 
			int engineerBAfter, 
			int engineerCAfter) {
		//Rule 1: Characters must be left or right
		if (!isValidPosition(boatBefore) || !isValidPosition(boatAfter) 
			|| !isValidPosition(managerABefore) || !isValidPosition(managerAAfter) 
			|| !isValidPosition(managerBBefore) || !isValidPosition(managerBAfter) 
			|| !isValidPosition(managerCBefore) || !isValidPosition(managerCAfter) 
			|| !isValidPosition(engineerABefore) || !isValidPosition(engineerAAfter) 
			|| !isValidPosition(engineerBBefore) || !isValidPosition(engineerBAfter) 
			|| !isValidPosition(engineerCBefore) || !isValidPosition(engineerCAfter)) {
			System.out.println("All positions must be 1 or 2!");
			return false;
		}
		
		//Rule 2: Boat must change sides
		if (boatBefore == boatAfter) {
			System.out.println("The boat must move!");
			return false;
		}
		
		//Rule 3: Moving Person must be on same side as boat. 
		int numThingsMoving = 0;
		numThingsMoving = checkMoving(
				managerABefore, managerAAfter, boatBefore, numThingsMoving);
		if (numThingsMoving < 0) {
			return false;
		}
		numThingsMoving = checkMoving(
				managerBBefore, managerBAfter, boatBefore, numThingsMoving);
		if (numThingsMoving < 0) {
			return false;
		}
		numThingsMoving = checkMoving(
				managerCBefore, managerCAfter, boatBefore, numThingsMoving);
		if (numThingsMoving < 0) {
			return false;
		}
		numThingsMoving = checkMoving(
				engineerABefore, engineerAAfter, boatBefore, numThingsMoving);
		if (numThingsMoving < 0) {
			return false;
		}
		numThingsMoving = checkMoving(
				engineerBBefore, engineerBAfter, boatBefore, numThingsMoving);
		if (numThingsMoving < 0) {
			return false;
		}
		numThingsMoving = checkMoving(
				engineerCBefore, engineerCAfter, boatBefore, numThingsMoving);
		if (numThingsMoving < 0) {
			return false;
		}
		
		//Rule 4: Boat must move only 1 or 2 people. 
		if (numThingsMoving != MIN_PEOPLE_IN_BOAT && numThingsMoving != MAX_PEOPLE_IN_BOAT) {
			System.out.println("You must move one or two people!");
			return false;
		}
	
		//Rule 5: No manager can recruit another engineer.
		if ((managerAAfter == engineerBAfter  && engineerBAfter != managerBAfter) 
			|| (managerAAfter == engineerCAfter && 
			managerAAfter != boatAfter && engineerCAfter != managerCAfter)) {
			System.out.println("Manager A would try to recruit someone!");
			return false;
		}
		
		if ((managerBAfter == engineerAAfter && engineerAAfter != managerAAfter) 
				|| (managerBAfter == engineerCAfter 
				&& managerBAfter != boatAfter && engineerCAfter != managerCAfter)) {
				System.out.println("Manager B would try to recruit someone!");
				return false;
			}
		
		if ((managerCAfter == engineerAAfter &&  engineerAAfter != managerAAfter) 
				|| (managerCAfter == engineerBAfter 
				&& managerCAfter != boatAfter && engineerBAfter != managerBAfter)) {
				System.out.println("Manager C would try to recruit someone!");
				return false;
			}
		
		//Rule 6: No game violations means the puzzle is solved.
		if (managerAAfter == RIGHT && engineerAAfter == RIGHT
				&& managerBAfter == RIGHT && engineerBAfter == RIGHT
				&& managerCAfter  == RIGHT && engineerCAfter == RIGHT) {
			System.out.println("You solved the puzzle!");
		}
		
		//return True if no rules violated 
		return true;
	}
}
















