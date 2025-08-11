public class Point {
    private int x;   // Each Point object has
    private int y;   // an int x and y inside.

    // Constructor
    public Point(int initX, int initY) {
        this.x = initX;
        this.y = initY;
    }
    
    // These accessors return the Point's x and y coordinates.
    public int getX() {
        return x;
    }
    
    public int getY() {
        return y;
    }

    // Shifts this point's x/y by the given amounts.
    public void translate(int dx, int dy) {  
         x += dx;
         y += dy;
    }

    // Returns this point's distance from (0, 0).
    public double distanceFromOrigin() {
        return Math.sqrt(x * x + y * y);
    }
    
    // A string version of the Point that is suitable for printing.
    public String toString() {
        String teString = ("(" + x + ", " + y + ")");
        return teString;
    }
}