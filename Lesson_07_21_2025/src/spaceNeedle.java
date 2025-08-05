//Separate Parts into regions
/*
 * Needle
 * Top Half
 * Top Bowl
 * Base Needle
 * Body
 * Base
 */



public class spaceNeedle {
	
	private static final int BASE_NEEDLE_DISTANCE_FROM_CENTER = 3;
	public static final int BASE_LENGTH = 16;
	private static final int TOP_HALF_LIMIT_OF_SEMI_COLONS = 10;
	public static final int LINE_SPACING_FROM_CENTER = 12;
	public static final int BASE_DISTANCE_FROM_TOP_HALF = 3; //this is a confusing variable name, meant to represent length of __/ which is 3
	public static final int BOTTOM_HALF_LENGTH_AT_TOP = 22; 
	public static final int BOTTOM_HALF_LENGTH_AT_BOTTOM = 10; //this is a confusing variable name, meant to represent length of __/ which is 3
	
	public static void Needle() {
		for (int i = 0; i < 4; i++) {
			for (int A = 0; A < LINE_SPACING_FROM_CENTER; A++) {
	            System.out.print(" ");
	        }
			System.out.println("||");
		}
	}
	
	public static void topHalfAndCenter() {
		for (int i = 0; i + 1 <= TOP_HALF_LIMIT_OF_SEMI_COLONS; i+= 3) {
			for (int j = 0; j < LINE_SPACING_FROM_CENTER - BASE_DISTANCE_FROM_TOP_HALF - i ; j++) {
	            System.out.print(" ");
			}
			printNeedleWallSide(1); //print left side
			for (int m = 0; m < i; m++) {
				System.out.print(":"); //print content of line
			}
			System.out.print("||"); //print center
			for (int m = 0; m < i; m++) {
				System.out.print(":");
			}
			printNeedleWallSide(2); //print left side
		}
		System.out.print("|");
		for (int k = 0; k < LINE_SPACING_FROM_CENTER * 2; k++) {
			System.out.print("\"");
		}
		System.out.print("|\n");
	}
	
	public static void bottomHalf() { //22 to 10
		for (int i = BOTTOM_HALF_LENGTH_AT_TOP; i >= BOTTOM_HALF_LENGTH_AT_BOTTOM; i-= 4) {
			for (int j = 0; j < (BOTTOM_HALF_LENGTH_AT_TOP - i) / 2; j++){
				System.out.print(" ");
			}
			System.out.print("\\_");
			for (int f = 0; f < i / 2; f++) {
				System.out.print("/\\");
			}
			System.out.print("_/\n");
		}
	}
	public static void printDoubleBar() {
		System.out.print("||");
	}
	
	public static void printNeedleWallSide(int side) {
		if (side == 1) {
			System.out.print("__/");
		}
		
		if (side == 2) {
			System.out.print("\\__\n");
		}
	}
	public static void printPillarPercentage() {
		for (int i = 0; i < BASE_LENGTH; i++) {
			for (int o = 0; o < LINE_SPACING_FROM_CENTER - BASE_NEEDLE_DISTANCE_FROM_CENTER  ; o++) {
	            System.out.print(" ");
	        }
			System.out.println("|%%||%%| ");
		}
	}
	
	public static void main(String[] Args) {
		Needle();
		topHalfAndCenter();
		bottomHalf();
		Needle();
		printPillarPercentage();
		topHalfAndCenter();
		
	}
	
	
}
