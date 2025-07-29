import java.awt.Color;
import java.awt.Graphics;

public class drawingCodeTest {
	public static final int DIVISOR_TO_SKIP_CIRCLES = 3;
	private static final int PANEL_WIDTH = 600; //600
	private static final int PANEL_HEIGHT = 400; //400
	private static final int DIAMETER_X = 50;
	private static final int DIAMETER_Y = 50;
	private static final int GAP = 10;
	public static final int SATURATION = 1;
	public static final int BRIGHTNESS = 1;
	
	public static DrawingPanel panel = new DrawingPanel(PANEL_WIDTH, PANEL_HEIGHT);
	public static Graphics pen = panel.getGraphics();
	


	public static void main(String[] args) {
		//pen.drawOval(100, 300, 100, 100);
		
		//circleLoop();
		//forClosedLoop();
		
		//forMultipleClosedLoop();
		//cornerDraw();
		//cornerDrawTest();
		//teachDraw();
		//skipCircles();
		//colorChange();
		//colorChange2();
		triangleOfCircles();
	}
	
	
	public static void circleLoop() {
		int x = 0;
		while (x + DIAMETER_X <= PANEL_WIDTH) {
			pen.drawOval(x, 0, DIAMETER_X, DIAMETER_Y);
			x += GAP;
			System.out.println(x + DIAMETER_X + ":" + PANEL_WIDTH);
		}
	}
	
	public static void forClosedLoop() {
		for(int x = 0; x + DIAMETER_X <= PANEL_WIDTH; x += GAP) {
			pen.drawOval(x, 0, DIAMETER_X, DIAMETER_Y);
			System.out.println(x + DIAMETER_X + ":" + PANEL_WIDTH);
		}
	}
	
	public static void forMultipleClosedLoop() {
		for (int y = 0; y + DIAMETER_Y <= PANEL_HEIGHT; y += DIAMETER_Y) {
			for(int x = 0; x + DIAMETER_X < PANEL_WIDTH; x += GAP) {
				pen.drawOval(x, y, DIAMETER_X, DIAMETER_Y);
				System.out.println(x + DIAMETER_X + ":" + PANEL_WIDTH);
			}
		}
	}
		
	public static void forMultipleStackClosedLoop() {
		for (int y = 0; y + DIAMETER_Y <= PANEL_HEIGHT; y += DIAMETER_Y) {
			for(int x = 0; x + DIAMETER_X < PANEL_WIDTH; x += GAP) {
				pen.drawOval(x, y, DIAMETER_X, DIAMETER_Y);
				System.out.println(x + DIAMETER_X + ":" + PANEL_WIDTH);
			}
		}
	}
	
	public static void cornerDraw() {
		for (int y = 0; y + DIAMETER_Y <= PANEL_HEIGHT; y += GAP) {
			// draw the left oval
			pen.drawOval(0, y, DIAMETER_X, DIAMETER_Y);
			// draw the right oval
			pen.drawOval(PANEL_WIDTH - DIAMETER_X, y, DIAMETER_X,
			DIAMETER_Y);
			}
	}
	
	public static void cornerDrawTest() {
		for(int x = 0; x + DIAMETER_X <= PANEL_WIDTH; x += GAP) {
			pen.drawOval(x, 0, DIAMETER_X, DIAMETER_Y);
			pen.drawOval(x, PANEL_HEIGHT - DIAMETER_Y, DIAMETER_X, DIAMETER_Y);
			System.out.println(x + DIAMETER_X + ":" + PANEL_WIDTH);
		}
	}
	
	public static void teachDraw() {
		for(int x = 0; x + DIAMETER_X <= PANEL_WIDTH; x+= GAP) {
			pen.drawOval(x, 0, DIAMETER_X, DIAMETER_Y);
			pen.drawOval(x, PANEL_HEIGHT - DIAMETER_Y, DIAMETER_X, DIAMETER_Y);
			//System.out.println(x + DIAMETER_X + ":" + PANEL_WIDTH);
		}
		
		for(int y = 0; y + DIAMETER_Y <= PANEL_HEIGHT; y += GAP) {
			pen.drawOval(0, y, DIAMETER_X, DIAMETER_Y);
			pen.drawOval(PANEL_WIDTH - DIAMETER_X, y, DIAMETER_X, DIAMETER_Y);
			//System.out.println(y + DIAMETER_X + ":" + PANEL_WIDTH);
		}	
	}
	
	public static void skipCircles() {
		for(int x = 0; x + DIAMETER_X <= PANEL_WIDTH; x+= GAP) {
			if (x % DIVISOR_TO_SKIP_CIRCLES == 0) {
				System.out.println("Skip Time at" + x);
				continue;
			}
			pen.drawOval(x, 0, DIAMETER_X, DIAMETER_Y);
			pen.drawOval(x, PANEL_HEIGHT - DIAMETER_Y, DIAMETER_X, DIAMETER_Y);
			//System.out.println(x + DIAMETER_X + ":" + PANEL_WIDTH);
		}
		
		for(int y = 0; y + DIAMETER_Y <= PANEL_HEIGHT; y += GAP) {
			if (y % DIVISOR_TO_SKIP_CIRCLES == 0) {
				System.out.println("Skip Time at" + y);
				continue;
			}
			pen.drawOval(0, y, DIAMETER_X, DIAMETER_Y);
			pen.drawOval(PANEL_WIDTH - DIAMETER_X, y, DIAMETER_X, DIAMETER_Y);
			//System.out.println(y + DIAMETER_X + ":" + PANEL_WIDTH);
		}	
	}
	
	public static void teachDraw2() {
		for(int x = 0; x + DIAMETER_X <= PANEL_WIDTH; x+= GAP) {
			pen.drawOval(x, 0, DIAMETER_X, DIAMETER_Y);
			pen.drawOval(x, PANEL_HEIGHT - DIAMETER_Y, DIAMETER_X, DIAMETER_Y);
			//System.out.println(x + DIAMETER_X + ":" + PANEL_WIDTH);
		}
		
		for(int y = 0; y + DIAMETER_Y <= PANEL_HEIGHT; y += GAP) {
			pen.drawOval(0, y, DIAMETER_X, DIAMETER_Y);
			pen.drawOval(PANEL_WIDTH - DIAMETER_X, y, DIAMETER_X, DIAMETER_Y);
			//System.out.println(y + DIAMETER_X + ":" + PANEL_WIDTH);
		}	
	}

	public static void colorChange() {
		float HUE_CHANGE = 1.0f / 64; // f for float
		float hue = 0;
		for (int x = 0; x + DIAMETER_X <= PANEL_WIDTH; x = x + DIAMETER_X) {
			for (int y = 0; y + DIAMETER_Y <= PANEL_HEIGHT; y = y + DIAMETER_Y) {
				pen.setColor(Color.getHSBColor(hue, SATURATION, BRIGHTNESS));
				pen.fillOval(x, y, DIAMETER_X, DIAMETER_Y);
				hue = hue + HUE_CHANGE; // increase hue
			}
		}

	}
	
	public static void colorChange2() {
		float HUE_CHANGE = 1.0f / 64; // f for float
		float hue = 0;
		for (int y = 0; y + DIAMETER_Y <= PANEL_WIDTH; y = y + DIAMETER_Y) {
			for (int x = 0; x + DIAMETER_X <= PANEL_HEIGHT; x = x + DIAMETER_X) {
				pen.setColor(Color.getHSBColor(hue, SATURATION, BRIGHTNESS));
				pen.fillOval(x, y, DIAMETER_X, DIAMETER_Y);
				hue = hue + HUE_CHANGE; // increase hue
			}
		}
	}
	
	public static void triangleOfCircles() {
		int diameter = 50;
		float HUE_CHANGE = 1.0f / 64; // f for float
		float hue = 0;
		for (int y = 0; y + diameter <= PANEL_HEIGHT; y = y + diameter) {
			for (int x = 0; x + diameter <= PANEL_WIDTH; x = x + diameter) {
				pen.setColor(Color.getHSBColor(hue, SATURATION, BRIGHTNESS));
				pen.fillOval(x, y, diameter, diameter);
				hue = hue + HUE_CHANGE;
				if (x >= y) {
					break;
				}
			}
		}
	}
		
}





