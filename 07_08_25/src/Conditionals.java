
public class Conditionals {
	
	static {
		System.out.println("hi"); //created instant that will run once loaded, static will cause program to run right away
		//will always run first
	}

	public static void main(String[] args) {
		double usdInPocket = 0.75; //example
		double costOfCandyBarUsd = 0.75; //example
		
		if (usdInPocket >= costOfCandyBarUsd) {
			System.out.println("Bought candy bar");
			System.out.println("Was delicious too");
		}
		
		//if (usdInPocket >= costOfCandyBarUsd)
	}
}
