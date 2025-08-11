
public class objCircles {
	
	private double circumference; 
	private double area;
	private double radius;
	private double diameter;
	
	public objCircles(double r) {
		this.radius = r;
		
	}
	
	public double area() {
		return Math.PI * (radius * radius);
	}
	
	public double diameter() {
		return radius * 2;
	}
	
	public double circumference() {
		return radius * 2 * Math.PI;
	}
	
	
	public double getRadius() {
		return radius; 
	}
	
	public String toString() {
		return "Circle{Radius=" + radius + "}";

	}
	
	
}
