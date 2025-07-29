import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;

// Please put a class Javadoc comment here, including an author tag.  
// As always, include a Javadoc comment for every public class, method, and constant.
public class StarsAndStripes {

    public static void drawFlag(int numStars, int numStripes, Graphics pen, int flagLeftX,
            int flagTopY, int flagWidth, int flagHeight) {
    	
    	pen.fillRect(flagLeftX, flagTopY, 15, 20);
        // Fill this in according to the assignment!
    }

    public static void drawStar(Graphics pen, int starLeftX, int starTopY, int starSize) {

        // Fill this in according to the assignment!
    }

    /*
     * You don't need to change this, but you can alter the "drawFlag" part of the
     * paintComponent code below to call it in different ways. You can also test
     * drawing multiple flags at once. Do not change anything else.
     */
    public static void main(String[] args) {

        JFrame window = new JFrame("Graphics window");
        window.setLocationByPlatform(true);
        final JLabel coords = new JLabel(" ");
        @SuppressWarnings("serial")
        final JPanel panel = new JPanel() {

            protected void paintComponent(Graphics gx) {
                coords.setText(" ");
                Graphics2D pen = (Graphics2D) gx;
                int width = getWidth();
                int height = getHeight();
                pen.setBackground(Color.CYAN); // To make sure you cover the base rectangle!
                pen.clearRect(0, 0, width, height);
                pen.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                        RenderingHints.VALUE_ANTIALIAS_ON);
                pen.setColor(Color.BLACK);

                // You could alter this code to try different flags!
                drawFlag(48, 16, pen, width / 2, height / 2, width / 2, height / 2);
                drawFlag(24, 15, pen, 0, height / 2, width / 2, height / 2);
                drawFlag(20, 14, pen, width / 2, 0, width / 2, height / 2);
                drawFlag(15, 13, pen, 0, 0, width / 2, height / 2);
            }
        };
        panel.addMouseMotionListener(new MouseMotionListener() {

            @Override
            public void mouseDragged(MouseEvent e) {
            }

            @Override
            public void mouseMoved(MouseEvent e) {
                coords.setText(e.getX() + ", " + e.getY());
            }
        });
        window.setLayout(new BorderLayout());
        Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
        window.setSize(d.width / 2, d.height / 2);

        JPanel coordPanel = new JPanel();
        coordPanel.setLayout(new BorderLayout());
        coordPanel.setBorder(new BevelBorder(BevelBorder.LOWERED));
        window.add(coordPanel, BorderLayout.SOUTH);
        coordPanel.add(coords, BorderLayout.WEST);

        window.setBackground(Color.WHITE); // To make sure you cover the base rectangle!
        panel.setBackground(Color.BLACK);
        window.add(panel, BorderLayout.CENTER);
        // window.setContentPane(panel);
        window.setVisible(true);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
