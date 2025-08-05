
public class tESTCOUNTER {
	public static int numUnique(int num1, int num2, int num3) {
		if (num1 == num2 && num2 == num3) {
			return 1;
		} else if (num1 == num2 || num1 == num3 || num2 == num3) {
			return 2;
		} else {
			return 3;
		}
	}
	
	public static void main(String[] arg) {
		System.out.println(numUnique(2,3,7));	
	}
}

