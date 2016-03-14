package edu.ucsb.cs56.w16.drawings.tmliew.advanced;
import java.awt.geom.GeneralPath; // combinations of lines and curves
import java.awt.Shape; // general class for shapes

import java.awt.geom.Line2D; 
import java.awt.geom.Rectangle2D;
import java.awt.geom.Ellipse2D;

import edu.ucsb.cs56.w16.drawings.utilities.ShapeTransforms;
import edu.ucsb.cs56.w16.drawings.utilities.GeneralPathWrapper;

/**
   A vector drawing of Sunglasses that extends Glasses, implements
   the Shape interface, and so can be drawn, as well as
   rotated, scaled, etc.
      
   @author Tim Liew
   @version for CS56, W16, UCSB
   
*/
public class Sunglasses extends Glasses implements Shape
{
    /**
       Constructor
       
       @param x x coord of left rim of glasses
       @param y y coord of left rim of glasses
       @param width width of the glasses
       @param height of the glasses (height of the legs)
    */
    public Sunglasses(double x, double y, double width, double height)
    {
	        	
        //call super constructor      
	super(x, y, width, height);
	
       	GeneralPath gp = this.get();
	double lensWidth = width * 0.4;
	double yOffset = lensWidth*0.2;
	double lensBridgeWidth = lensWidth + width*0.2;
	
	//draw shades on left lens
	Line2D.Double left1 =
	    new Line2D.Double (x, y - yOffset*2,
			       x + lensWidth, y - yOffset*2);
        Line2D.Double left2 =
            new Line2D.Double (x, y - yOffset,
                               x + lensWidth, y - yOffset);
        Line2D.Double leftm =
            new Line2D.Double (x, y,
                               x + lensWidth, y);
        Line2D.Double left3 =
            new Line2D.Double (x, y + yOffset*2,
                               x + lensWidth, y + yOffset*2);
        Line2D.Double left4 =
            new Line2D.Double (x, y + yOffset,
                               x + lensWidth, y + yOffset);
	//draw on the right lens

        Line2D.Double right1 =
            new Line2D.Double (x + lensBridgeWidth, y - yOffset*2,
                               x + lensBridgeWidth + lensWidth, y - yOffset*2);
        Line2D.Double right2 =
            new Line2D.Double (x + lensBridgeWidth, y - yOffset,
                               x + lensBridgeWidth + lensWidth , y - yOffset);
        Line2D.Double rightm =
            new Line2D.Double (x + lensBridgeWidth, y,
                               x + lensBridgeWidth + lensWidth, y);
        Line2D.Double right3 =
            new Line2D.Double (x + lensBridgeWidth, y + yOffset*2,
                               x + lensBridgeWidth + lensWidth, y + yOffset*2);
        Line2D.Double right4 =
            new Line2D.Double (x + lensBridgeWidth, y + yOffset,
                               x + +lensBridgeWidth + lensWidth, y + yOffset);

		
        GeneralPath whole = this.get();
	
	whole.append(left1, false);
	whole.append(left2, false);
	whole.append(left3, false);
	whole.append(left4, false);
        whole.append(leftm, false);
        whole.append(right1, false);
	whole.append(right2, false);
        whole.append(right3, false);
        whole.append(right4, false);
	whole.append(rightm, false);
       

	
    }
}
