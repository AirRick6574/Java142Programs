import java.security.PublicKey;

public class lesson_07_08_25 {
	
	//created using retractor
	public static final int A_REGULAR_DOZEN = 12;
	public static final int A_BAKERS_DOZEN = 12;

	public static void main(String[] arg) {
		boolean isGrassgreen = true;
		boolean isSnowOrange = false;
		
		boolean areBothTrue = isGrassgreen && isSnowOrange; //AND operator checks if both true
		System.out.println("Is both true??: " + areBothTrue);
		
		System.out.println("\nisSnowOrange == false??: " + (isSnowOrange == false)); //Equivalent
		System.out.println("! is snow orange: " + !isSnowOrange); //Equivalent
		
		System.out.println("\nisSnowOrange == True: " + (isSnowOrange == true));
		System.out.println("!isSnowOrange : " + (isSnowOrange));
		
		//Whoops, single "="
		System.out.println("\nsingle equals: " + (isSnowOrange = true));
		
		
		isSnowOrange = true; // delete type for re-declarations
		
		
		System.out.println("\nIs true now??: " + areBothTrue); //No since arebothTrue Variable has not been reassigned
		
		areBothTrue = isGrassgreen && isSnowOrange; //AND operator checks if both true
		System.out.println("How about now??: " + areBothTrue);
		
		int bobsCents = 192;
		int aliceCents = 192;
		
		System.out.println("\nAlive > Bob " + (aliceCents > bobsCents));
		
		bobsCents = 222;
		
		boolean aliceHasMore = aliceCents > bobsCents;
		
		System.out.println("Alice > Bob " + aliceHasMore);
		System.out.println("Alice > Bob" + (aliceCents > bobsCents)); // ! is NOT OPERATOR
		
		System.out.println("\nIs 13 a dozen??: " + isDozen(13)); //false
		System.out.println("Is 12 a dozen??: " + isDozen(12)); //true
		
		System.out.println("\n" + (aliceHasMore || isGrassgreen && isSnowOrange)); // || OR OPERATOR //can use refractor to rename vars
		System.out.println(aliceHasMore || isGrassgreen && !isSnowOrange);//true (true, false) will output true due to OR operator
		System.out.println((aliceHasMore || isGrassgreen) && !isSnowOrange); //(true or true) = true && false == false
		
		System.out.println("Dog happy?? " + (dogIsHappy(true, true, true))); //true
		System.out.println("Dog happy?? " + (dogIsHappy(true, true, false))); //true
		System.out.println("Dog happy?? " + (dogIsHappy(true, false, true))); //true
		System.out.println("Dog happy?? " + (dogIsHappy(true, false, false))); //false
		System.out.println("Dog happy?? " + (dogIsHappy(false, true, true))); //false
		System.out.println("Dog happy?? " + (dogIsHappy(false, true, false))); //false
		System.out.println("Dog happy?? " + (dogIsHappy(false, false, true))); //false
		System.out.println("Dog happy?? " + (dogIsHappy(false, false, false))); //false
		System.out.println("Dog happy?? " + (dogIsHappy(false, false, true))); //false
		
		ifElseMystery1(3, 20);
		
		System.out.println("In Square?? " + (isInSquare(5, 5))); //true
		System.out.println("In Square?? " + (isInSquare(0, 5))); //true
		System.out.println("In Square?? " + (isInSquare(-1, 5))); //false
		System.out.println("In Square?? " + (isInSquare(0, 15))); //false
		System.out.println("In Square?? " + (isInSquare(20, 15))); //false
		System.out.println("In Square?? " + (isInSquare(10, 10))); //true
	}
	
	public static boolean isDozen(int amount) {
		//Write a return statement here
		//It will look like: return [Something] [comparison operator] [something else];
		//replace [[something] and [something else] with a numerical expression (literal or variable)
		//Replace [comparison operator] with one of the operators on the previous page
		//return amount == A_DOZEN;
		
		//amount == A_Regular_dozen  amount == A_Bakers_Dozen amount == A_Regular_Dozen || amount == a bakers dozen
		//true						true										true
		//true						false										true
		//false						true										true
		//false						false										false
		
		return amount == A_REGULAR_DOZEN || amount == A_BAKERS_DOZEN;
	}
		
	public static boolean dogIsHappy(boolean fed, boolean walked, boolean playedWith) {
		return fed && (walked || playedWith);
	}
		
	public static void ifElseMystery1(int x, int y) {
	    int z = 4;
	    if (z <= x) { 
	        z = x + 1; 
	    } else { 
	        z = z + 9; 
	    } 
	    if (z <= y) { 
	        y++; 
	    } 
	    System.out.println(z + " " + y); 
	}
	
	/**
	 * Determines whether given variables are within square (0 => x <= 10, 0 => y <= 10)
	 * Return true if within square, false if out of square 
	 * @param x
	 * @param y
	 * @return
	 */
	
	public static boolean isInSquare(int x, int y) {
		return ((x >= 0 && x <= 10) && (y >= 0 && y <= 10)) == true;
		
	}
	
}
