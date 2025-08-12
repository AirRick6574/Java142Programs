package finalAssignment;

import java.awt.Graphics2D;

/**
 * Represents a circle in the Java coordinate system, with methods to access its center coordinates
 * and radius, draw it, and determine whether it overlaps another circle.
 * 
 * @author Martin Hock, Matt Parker, possibly David Anderson
 *
 */
public class Circle {
   
    private double radius;
    // X and Y are in Java graphics coordinate system
    // (0, 0 in upper left corner)
    private double centerX; 
    private double centerY;

    /**
     * Creates a circle.
     * 
     * @param radius The distance from the center to the edge of the circle.
     * @param centerX The horizontal coordinate of the circle (increasing to the right).
     * @param centerY The vertical coordinate of the circle (increasing downwards).
     */
    public Circle(double radius, double centerX, double centerY) {
        
        if (radius < 0) {
            // This crashes the program; "fail early"!
            throw new IllegalArgumentException();
        }
        this.radius = radius;
        this.centerX = centerX;
        this.centerY = centerY;
    }

    /**
     * Returns the radius.
     * @return The radius of this circle. 
     */
    public double getRadius() {
        return radius;
    }

    /**
     * Returns the horizontal coordinate of the center.
     * 
     * @return The horizontal coordinate of the center of this circle.
     */
    public double getCenterX() {
        return centerX;
    }

    /**
     * Returns the vertical coordinate of the center.
     * 
     * @return The vertical coordinate of the center of this circle.
     */
    public double getCenterY() {
        return centerY;
    }

    /**
     * Sets the radius.
     * 
     * @param radius The new radius for this circle.
     */
    public void setRadius(double radius) {
        if (radius < 0) {
            throw new IllegalArgumentException();
        }
        this.radius = radius;
    }

    /**
     * Sets the center coordinates.
     * 
     * @param centerX The new horizontal coordinate for the center of this circle.
     * @param centerY The new vertical coordinate for the center of this circle.
     */
    public void setCenterCoordinates(double centerX, double centerY) {
        this.centerX = centerX;
        this.centerY = centerY;
    }

    /**
     * Returns the area.
     * 
     * @return The area of this circle.
     */
    public double area() {
        // Area = PI(r squared)
        return Math.PI * radius * radius;
    }

    /**
     * Determines whether this circle overlap
     * @param otherCircle
     * @return
     */
    public boolean overlaps(Circle otherCircle) {
        // First, calculate distance
        double xDifference = this.centerX - otherCircle.centerX;
        double yDifference = this.centerY - otherCircle.centerY;
        // Euclidean distance formula (Pythagorean theorem)
        double distance = Math.sqrt(xDifference * xDifference + yDifference * yDifference);
        return distance <= this.radius + otherCircle.radius;
    }

    /**
     * Draws the circle in a graphics window.  
     * 
     * @param pen A graphics tool.
     */
    public void draw(Graphics2D pen) {
        pen.fillOval((int) (centerX - radius), (int) (centerY - radius), (int) (2 * radius),
                (int) (2 * radius));

    }
}
