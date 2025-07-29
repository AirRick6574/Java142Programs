/*
 * Write a method named floydsTriangle that accepts an integer k as a parameter and prints a k-row version of Floyd's triangle. 
 * Floyd's triangle is a sequence of increasing numbers, starting with 1,
 *  where each Nth row of numbers displays the next N numbers in the sequence. 
 * For example, the call of floydsTriangle(5); should print the following console output:


 * 
 * 1
 * 2 3
 * 4 5 6
 * 7 8 9 10
 * 11 12 13 14 15
 */

public class floydsTriangle {
	public static void floydTriangle(int k){ 
		int count = 1;
		for(int i = 0; i < k; i++) {
			for (int j = 0; j <= i; j++) {
				System.out.print(count + " ");
				count++;
			}
			System.out.println();
		}
	}
	
	public static void main(String[] args) {
		floydTriangle(15);
	}
}


