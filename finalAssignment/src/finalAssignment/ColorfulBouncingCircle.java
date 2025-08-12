package finalAssignment;

import java.awt.Color;

/**
 * Represents a circle with color, velocity, and bouncing behavior. 
 * @author Anthony and class
 */
public class ColorfulBouncingCircle extends ColorfulCircle {
	
	private static double fieldWidth;
	private static double fieldHeight;
	
	private static double centerX;
	private static double centerY;

	private double xVelocity;
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
	public ColorfulBouncingCircle(final double radius, final double centerX, final double centerY, final Color color,
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
	 * 
	 */
	public void tick() {
		
		boolean xOutOfBounds = getCenterX() < 0 ||getCenterX() > fieldWidth;
		boolean yOutOfBounds = getCenterY() < 0 ||getCenterY() > fieldHeight;
		
		// Calculate the new center coordinates (if we move the cirlce)
		// If center is off the left or right side of the field
		if (xOutOfBounds) {
			
			// Change sign of the horizontal velocity
			xVelocity = xVelocity - (xVelocity * 2);
		}
		// If center is above the top or below the bottom of the board
		if (yOutOfBounds) {
			
			// Change sign of vertical velocity
			yVelocity = yVelocity - (yVelocity * 2);
		}
			
		// In either case (or if both are true) 
		else if (yOutOfBounds && xOutOfBounds) {
			// DO NOT CHANGE CENTER
			
		// Otherwise
		} else {
			
			// Add the x-velocity to the x- coordinate and
			// Add the y-velocity to the y-coordinate
			centerX = xVelocity + getCenterX();
			centerY = yVelocity + getCenterY();
			setCenterCoordinates(centerX, centerY);
		}
			
		
			
		
	}
	
	/**
	 * @param otherCircle 
	 * 
	 * 
	 */
	@Override
	public boolean overlaps(final Circle otherCircle) {
		boolean overlaps = super.overlaps(otherCircle);
		
		if (overlaps) {
			if (getCenterX() != otherCircle.getCenterX()) {
				
				//if the center x coordinate of this circle is left or right of the other circle 
				//(if not equal) 
					//flip the sign of this circle's horizontial velocity. 
				xVelocity = xVelocity - (xVelocity * 2);
			}
			
			//if center y-coordinate of this circle is above or below that of the other circle 
			//flip the sign of this circle's verical velocity. 
			if (getCenterY() != otherCircle.getCenterY()) {
				yVelocity = yVelocity - (yVelocity * 2);
			}
		}		
		//return correct 
		
		return true;
	}
	
}

