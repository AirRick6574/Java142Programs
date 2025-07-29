
import java.awt.Color;
import java.awt.Graphics;

public class circleLoops {
    public static void main(String[] args) {
        DrawingPanel panel = new DrawingPanel(250, 250);
        Graphics pen = panel.getGraphics();
        
        pen.drawRect(10, 5, (20 * 9 + 50),(20 * 9 + 50));
        
        for (int i = 0; i < 10; i++) {
        	pen.setColor(Color.green);
            pen.fillOval(10 + (20 * i), 5 + (20 * i), 50, 50);
            pen.setColor(Color.black);
            pen.drawOval(10 + (20 * i), 5 + (20 * i), 50, 50);
        }
        
        //pen.drawRect(10, 5, 240 - 10, 240 - 5);
        pen.drawRect(10, 5, (20 * 9 + 50),(20 * 9 + 50));

    }
}