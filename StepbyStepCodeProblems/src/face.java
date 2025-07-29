import java.awt.Color;
import java.awt.Graphics;

public class face {
	public static int PANEL_WIDTH = 220;
	public static int PANEL_HEIGHT = 150;
	public static int FACE_DIAMETER = 100;
	
	public static DrawingPanel panel = new DrawingPanel(PANEL_WIDTH,PANEL_HEIGHT);
	public static Graphics pen = panel.getGraphics();
	
	
	public static void main(String[] args) {
		pen.drawOval(10, 30, FACE_DIAMETER, FACE_DIAMETER);
		
		pen.setColor(Color.BLUE);

		pen.fillOval(30, 60, 20, 20);
		pen.fillOval(70, 60, 20, 20);
		
		pen.setColor(Color.RED);
		
		pen.drawLine(40, 100, 80, 100);
		
	}
}
