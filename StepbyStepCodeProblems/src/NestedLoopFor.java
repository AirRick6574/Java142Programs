
public class NestedLoopFor {
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

	
	public static void numberLoops1(int k){ 
		int count = 1;
		for(int i = 0; i < k; i++) {
			for (int j = 0; j <= i; j++) {
				System.out.print(count + " ");
				
			}
			System.out.println();
			count++;  
		}
	}
	//3 spaces for 1 character number 
	//2 spaces for 2 character number 
	//1 psace for 3 character 
	public static void test() {
		for (int i = 1; i <= 10; i++) {
		    for (int j = 1; j <= 10; j++) {
		        System.out.print(i * j + "\t");
		    }
		    System.out.println();
		}
	}
		
	public static void main(String[] args) {
			numberLoops1(5);
			System.out.println();
			test();
	}
}




