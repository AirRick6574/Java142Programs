import java.awt.Color;

/**
 * Represents a circle with color, velocity, and bouncing behavior. 
 * @author Erick Ruiz and class
 */
public class ColorfulBouncingCircle extends ColorfulCircle {
	//Playing Field Width.
	private static double fieldWidth;
	//PLaying Field Height.
	private static double fieldHeight;
	//X axis velocity of this circle (per tick).
	private double xVelocity;
	//Y axis velocity of this circle (per tick).
	private double yVelocity;

	/**
	 * Create a colorful bouncing circle. 
	 * 
	 * @param radius radius of the new circle
	 * @param centerX the X-coordinate of the new circle
	 * @param centerY the y-coordinate of the new circle
	 * @param color the color of the new circle
	 * @param xVelocity the horizontial velocity component of the new circle 
	 * @param yVelocity the vertical velocity component of the new circle 
	 */
	public ColorfulBouncingCircle(
			final double radius, final double centerX, 
			final double centerY, final Color color,
			final double xVelocity, final double yVelocity) {
		
		super(radius, centerX, centerY, color);
		this.xVelocity = xVelocity;
		this.yVelocity = yVelocity;
	}
		
	/**
	 * Sets the width and height of the playing field.
	 * 
	 * @param newWidth The new width of the playing field.
	 * @param newHeight The new height of the playing field.
	 */
	public static void setPlayingFieldSize(final double newWidth, final double newHeight) {
		fieldWidth = newWidth;
		fieldHeight = newHeight;
	}
		
	/**
	 * Checks if circle is out of bounds and adjusts to maintain bounds
	 * Also updates movement per tick cycle. 
	 */
	public void tick() {
		//Calculate next position of circle by velocity
		double nextXPosition = getCenterX() + xVelocity;
		double nextYPosition = getCenterY() + yVelocity;
		
		//Check out of bounds
		boolean xOutOfBounds = nextXPosition < 0 || nextXPosition > fieldWidth;
		boolean yOutOfBounds = nextYPosition < 0 || nextYPosition > fieldHeight;
		
		// Calculate the new center coordinates (if we move the cirlce)
		// If center is off the left or right side of the field
		if (xOutOfBounds) {
			
			// Change sign of the horizontal velocity
			xVelocity = -xVelocity;
			
		}
		// If center is above the top or below the bottom of the board
		if (yOutOfBounds) {
			
			// Change sign of vertical velocity
			yVelocity = -yVelocity;
		}
		 // If the next position is within bounds, update the circle's center coordinates
		if (!xOutOfBounds && !yOutOfBounds) {
			setCenterCoordinates(nextXPosition, nextYPosition);
		}
		
		
	}
	
	
	/**
	 * Checks whether circle called bounces with "other" circle. If circle 
	 * makes contact with another circle, "bounce" circles away from each other
	 * @param otherCircle 
	 */
	@Override
	public boolean overlaps(final Circle otherCircle) {
		// Call the superclass method to determine if there is an actual overlap
		boolean overlaps = super.overlaps(otherCircle);
		
		
		if (overlaps) {
			if (getCenterX() != otherCircle.getCenterX()) {
				//if the center x coordinate of this circle is left or right of the other circle 
				//(if not equal) 
					//flip the sign of this circle's horizontal velocity. 
				xVelocity = -xVelocity;
			}
			
			//if center y-coordinate of this circle is above or below that of the other circle 
			//flip the sign of this circle's verical velocity. 
			if (getCenterY() != otherCircle.getCenterY()) {
				
				yVelocity = -yVelocity;
			}
		}	
		
		return overlaps;
	}
	
}

