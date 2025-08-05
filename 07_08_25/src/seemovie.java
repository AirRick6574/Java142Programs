
public class seemovie {
	
	public static void seeMovie(double ticketCost, int starRatings) {
		if (ticketCost < 5.0){
			System.out.println("very interested");
		} else if (ticketCost >= 12.0) {
			if (starRatings == 5) {
				System.out.println("sort-of interested");
			} else {
				System.out.println("not interested");
			}
		} else if (starRatings == 5 && ticketCost < 12.0) {
			System.out.println("very interested");
		} else if (ticketCost >= 5.00 && ticketCost <= 11.99 && starRatings >= 2 && starRatings <= 4) {
			System.out.println("sort-of interested");
		} else {
			System.out.println("not interested");
		}
		
	}
}
