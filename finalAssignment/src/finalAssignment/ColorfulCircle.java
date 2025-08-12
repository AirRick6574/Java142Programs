package finalAssignment;

import java.awt.Color;
import java.awt.Graphics2D;

/**
 * Represents a circle with color in Java graphics.
 * 
 * @author Martin Hock, Matt Parker
 */
public class ColorfulCircle extends Circle {

    private Color color;

    /**
     * Creates a circle with the specified center, radius, and color.
     * 
     * @param radius  The distance form the center of the circle to the edge, in
     *                pixels.
     * @param centerX The horizontal coordinate of the center of the circle.
     * @param centerY The vertical coordinate of the center of the circle.
     * @param color   The color for the new circle.
     */
    public ColorfulCircle(double radius, double centerX, double centerY, Color color) {
        // This calls the superclass (Circle) constructor
        super(radius, centerX, centerY);
        this.color = color;
    }

    /**
     * Overrides the Circle's draw method to set the color before drawing and set it
     * back to its previous value after.
     * 
     * @param pen A graphics tool.
     */
    // This "annotation" is highly recommended whenever overriding an inherited method.
    // It ensures you are actually overriding; otherwise it causes a compiler error.
    @Override     
    public void draw(Graphics2D pen) {
        // Save the current pen color
        Color oldColor = pen.getColor();
        // Set the pen color to the color of this circle
        pen.setColor(this.color);
        // This calls the superclass (Circle) draw method
        super.draw(pen);
        // Set the color back to what it was
        pen.setColor(oldColor);
    }
}
