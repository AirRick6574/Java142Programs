
public class Test1234 {
	public static void referenceMystery(int x, int[] a) {
	    x = 3;
	    a[0] = 4;
	}
	 
	public static void main(String[] args) {
	    int x = 1, y = 2;
	    int[] a = new int[1];
	    int[] b = new int[1];
	    referenceMystery(y, b);
	    System.out.println(x + " " + a[0]);
	}
	
}
