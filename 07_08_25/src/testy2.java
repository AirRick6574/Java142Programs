
public class testy2 {
	
	public static int quadrant(Double x, Double y) {
		if ((x > 0.0) && (y > 0.0)) {
			return 1;
		} else if ((x < 0.0) && (y > 0.0)) {
			return 2;
		} else if ((x < 0.0) && (y < 0.0)) {
			return 3;
		} else if ((x > 0.0) && (y < 0.0)) {
			return 4;
		} else {
			return 0;
		}
	}
	
	public static void main(String[] args) {
		System.out.println(quadrant(12.4, 17.8));
		System.out.println(quadrant(-2.3, 3.5));
		System.out.println(quadrant(-15.2, -3.1));
		System.out.println(quadrant(4.5, -42.0));
		System.out.println(quadrant(0.0, 3.14));
	}
	
}
