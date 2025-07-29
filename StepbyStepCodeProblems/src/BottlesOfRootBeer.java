
public class BottlesOfRootBeer {
/*
 * Write a for loop to produce the following output:

10 bottles of root beer on the wall
10 bottles of root beer
Take one down, pass it around
9 bottles of root beer on the wall

9 bottles of root beer on the wall
9 bottles of root beer
Take one down, pass it around
8 bottles of root beer on the wall

... (output continues in the same pattern) ...

1 bottles of root beer on the wall
1 bottles of root beer
Take one down, pass it around
0 bottles of root beer on the wall
(For this problem you should say "1 bottles" rather than "1 bottle" in your output, even though this is gramatically incorrect.)
 */
	public static void main(String[] agrs) {
		for (int i = 10; i > 0; i--) {
			System.out.println(i + " bottles of root beer on the wall");
			System.out.println(i + " bottles of root beer");
			System.out.println("Take one down, pass it around");
			System.out.println(i-1 + " bottles of root beer on the wall\n");
		}
	}
	
}
