
public class loopMysteryExam1 {
	public static int loopMysteryExam(int i, int j){
	    while (i != 0 && j != 0) {
	        i = i / j;
	        j = (j - 1) / 2;
	        System.out.print(i + " " + j + " ");
	    }
	    System.out.println(i);
	    return i + j;
	}
	
	public static void nestedStarsOutput() {
		for (int i = 1; i <= 10; i++) {
		    for (int j = 1; j <= i; j++) {
		        System.out.print("*");
		    }
		    for (int j = 1; j <= 20 - 2 * i; j++) {
		        System.out.print(" ");
		    }
		    for (int j = 1; j <= i; j++) {
		        System.out.print("*");
		    }
		    System.out.println();
		}
	}
	
	/*
	 *  sequenceOfNumbers
	 *  Complete a for loop to produce the following output:
	 *  8
	 *  11
	 *  14
	 *  17
	 * 20
	 * 23
	 */
	public static void sequenceOfNumbers() {
		for(int i = 8; i <= 23;) {
			System.out.println(i);
			i = i + 3;
		}
	}
	
	/*
	 * Write a method named sqrt that accepts an integer N as a parameter and returns the square root of N as an integer. 
	 * The challenge here is that you must not use Math.sqrt or Math.pow or other library methods to calculate the square root; 
	 * rather, you must compute it yourself. You should return the square root as a truncated integer; 
	 * for example, the square root of 7 is approximately 2.65, but your method should return 2. 
	 * You may assume that the value of N passed is a positive integer.
	 */
	
	public static int sqrt(int n) {
		int y = n;
		System.out.println(y);
		double z = (y + (n / y)) / 2;
		System.out.println(z);
		
		double j = z;
		double x = (j + (n / j)) / 2;
		System.out.println(x);
		
		return (int) x;
	}
	
	public static void whileLoopBasics() {
		int x = 1;
		System.out.print(x);
		while (x < 100) {
		    x = x + x;
		    System.out.print(", " + x);
		}
	}
	
	public static void main(String[] args) {
		System.out.println(loopMysteryExam(3, 2));
		System.out.println(loopMysteryExam(16, 5));
		System.out.println(loopMysteryExam(80, 9));
		System.out.println(loopMysteryExam(1600, 40));      
		System.out.println();       
		
		nestedStarsOutput();
		
		System.out.println();
		
		System.out.println(sqrt(2));
		System.out.println(sqrt(1));
		System.out.println(sqrt(6));
		System.out.println(sqrt(4));
		
		System.out.println();
		System.out.println(sqrt(9));
		
		System.out.println();
		System.out.println(sqrt(16));
		
		System.out.println();
		
		whileLoopBasics();
	}
}
