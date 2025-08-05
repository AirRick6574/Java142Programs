import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

import javax.management.openmbean.OpenMBeanAttributeInfo;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;

/**
 * Class Stars and Stripes will create 4 individual flags based on custom parameters. 
 * These flags have been calculated based on sizing, width height, number of stripes 
 * and number of stars with proper spacing and alignment. 
 * Contains 3 methods, main, drawFlag and drawStar. 
 * 
 * @author Erick Ruiz
 */
public class StarsAndStripes {
	
	/**
	 * Constant Used to represent odd Stripes (White Stripes)
	 */
	public static final int ODD_STRIPES = 2;
	/**
	 * Constant used for half of 5x5 grid
	 */
	public static final int HALF_OF_GRID = 2;
	/**
	 * Constant Used to represent 4/5 of the 5x5 grid
	 */
	public static final int FOUR_FIFTHS_OF_GRID = 4;
	/**
	 * Constant Used to Represent Grid size (5x5(
	 */
	public static final int STAR_GRID = 5;
	/**
	 * Constant is used to determine Stripes Skips, Used for Creating Red Stripes
	 */
	public static final int STRIPE_SKIP_COUNT = 2; 
	/**
	 * Calculation Constant used for finding the center of the Star Field
	 */
	public static final int STAR_FIELD_CENTER = 2; 

	/**
	 * Method that will perform calculators for stripes, stripes height, Star Field Sizing, 
	 * Star Sizing and orientation and will draw the graphics for the flag once calculations
	 * are completed. Will call drawStar to perform graphics of individual stars.  
	 * @param numStars Number of Stars in Flag
	 * @param numStripes Number of Stripes flag will have
	 * @param pen Graphic object used for creating the flag components and graphics
	 * @param flagLeftX Left Side on X axis of the Flag, Used for creating flag size
	 * @param flagTopY Top of Y Axis of the flag, also used for creating the flag
	 * @param flagWidth Overall width of the flag, 
	 * @param flagHeight Overall height of the flag
	 */
    public static void drawFlag(int numStars, int numStripes, Graphics pen, int flagLeftX,
            int flagTopY, int flagWidth, int flagHeight) {
    	
    	//Base White Draw
    	pen.setColor(Color.WHITE);
    	pen.fillRect(flagLeftX, flagTopY, flagWidth, flagHeight);
    	
    	//Calculations for Red Stripe
    	int stripesHeight = flagHeight / numStripes;
    	int numRedStripes = (numStripes + 1) / STRIPE_SKIP_COUNT;
    	
    	//Red Stripe Draw
    	pen.setColor(Color.red);
    	for (int i = 0; i < numRedStripes; i++) { 
    		int redStripStartHeight = flagTopY + (i * STRIPE_SKIP_COUNT * stripesHeight);
    		
    		//If at last red Stripe, draw stripe from start height to end of flag
    		if (numStripes % ODD_STRIPES == 1 && i == numRedStripes - 1) {
    			int bottomYHeight =  flagTopY + flagHeight; 
    			int heightToBottom = bottomYHeight - redStripStartHeight;
    			pen.fillRect(flagLeftX, redStripStartHeight, flagWidth, heightToBottom);
    			continue;
    		}
    		pen.fillRect(flagLeftX, redStripStartHeight, flagWidth, stripesHeight);	
    	}
    	//Draw Blue Star Field
		int starFieldYDistance = stripesHeight * numRedStripes;
		int starFieldXDistance = starFieldYDistance * flagWidth / flagHeight;
		
		pen.setColor(Color.BLUE);
		pen.fillRect(flagLeftX, flagTopY, starFieldXDistance, starFieldYDistance);	
    	
    	//Best Column and Row Calculator:
    	int bestRows = 0;
    	int bestColumns = 0;
    	
    	//Find optimal layout where stars are in more columns than rows, but not excessively wide
    	for (int rows = 1; rows <= numStars; rows++) {
    		if (numStars % rows != 0) {
    			continue;
    		}
    		
    		int columns = numStars / rows;
    		if(columns > rows && columns < 2 * rows) {
    			bestRows = rows;
        		bestColumns = columns;
    		}
    	}
    	
    	//Find Sizing
    	int maxStarWidth = starFieldXDistance / bestColumns;
    	int maxStarHeight = starFieldYDistance / bestRows;
    	    
    	//Determines Star Size based on if Width or Height is greater
    	int starSize = 0;
    	if (maxStarWidth < maxStarHeight) {
    		starSize = maxStarWidth;
    	} else {
    		starSize = maxStarHeight;
    	}
    	
    	//Finds width/Height and offsets. 
    	int totalStarFieldWidth = starSize * bestColumns;
    	int totalStarFieldHeight = starSize * bestRows;
    	int xStarFieldOffset = flagLeftX 
    			+ (starFieldXDistance - totalStarFieldWidth) 
    			/ STAR_FIELD_CENTER;
    	int yStarFieldOffset = flagTopY 
    			+ (starFieldYDistance - totalStarFieldHeight) 
    			/ STAR_FIELD_CENTER;
    	
    	//Draw Stars
    	for (int starFieldRow = 0; starFieldRow < bestRows; starFieldRow++) {
    	    for (int columnsInForLoop = 0; columnsInForLoop < bestColumns; columnsInForLoop++) {
    	        int starXPosition = xStarFieldOffset + columnsInForLoop * starSize;
    	        int starYPosition = yStarFieldOffset + starFieldRow * starSize;
    	        drawStar(pen, starXPosition, starYPosition, starSize);
    	    }
    	}
    }
    
    /**
     * Helper Method Used to create an individual Star, will calculate sizing and points first. 
     * Once points have been made, method will draw star. 
     * @param pen Graphic object used for creating the flag components and graphics
     * @param starLeftX Left Side of X axis of 5x5 grid used to make the star. 
     * @param starTopY Top Side of Y axis of 5x5 grid used to make the star. 
     * @param starSize int variable containing size of the star
     */
    public static void drawStar(Graphics pen, int starLeftX, int starTopY, int starSize) {
    	int starStartAndEndXPoint = starLeftX + (starSize / STAR_GRID) ; 
    	int starStartAndEndYPoint = starTopY + starSize; 
    	int starTopVerticeXPoint = (starSize / HALF_OF_GRID) + starLeftX; 
    	int starTopVerticeYPoint = starTopY; 
    	int starBottomRightVerticeXPoint = starLeftX + ((starSize / STAR_GRID) * FOUR_FIFTHS_OF_GRID); 
    	int starBottomRightVerticeYPoint = starTopY + starSize; 
    	int starMiddleLeftVerticeXPoint = starLeftX;
    	int starMiddleLeftVerticeYPoint = starTopY + ((starSize / STAR_GRID) * HALF_OF_GRID); 
    	int starMiddleRightVerticeXPoint = starLeftX + starSize;
    	int starMiddleRightVerticeYPoint = starTopY + ((starSize / STAR_GRID) * HALF_OF_GRID); 

    	pen.setColor(Color.WHITE);
    	pen.drawLine(starStartAndEndXPoint , starStartAndEndYPoint, 
    			starTopVerticeXPoint, starTopVerticeYPoint);
    	pen.drawLine(starTopVerticeXPoint , starTopVerticeYPoint, 
    			starBottomRightVerticeXPoint, starBottomRightVerticeYPoint);
    	pen.drawLine(starBottomRightVerticeXPoint , starBottomRightVerticeYPoint, 
    			starMiddleLeftVerticeXPoint, starMiddleLeftVerticeYPoint);
    	pen.drawLine(starMiddleLeftVerticeXPoint , starMiddleLeftVerticeYPoint, 
    			starMiddleRightVerticeXPoint, starMiddleRightVerticeYPoint);
    	pen.drawLine(starMiddleRightVerticeXPoint , starMiddleRightVerticeYPoint, 
    			starStartAndEndXPoint, starStartAndEndYPoint);
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
