package edu.ucsb.cs56.w16.drawings.tmliew.advanced;
import java.awt.geom.GeneralPath; // combinations of lines and curves
import java.awt.Shape; // general class for shapes

import java.awt.geom.Line2D; 
import java.awt.geom.Rectangle2D;


import edu.ucsb.cs56.w16.drawings.utilities.ShapeTransforms;
import edu.ucsb.cs56.w16.drawings.utilities.GeneralPathWrapper;

/**
   A vector drawing of glasses that implements
   the Shape interface, and so can be drawn, as well as
   rotated, scaled, etc.
      
   @author Tim Liew
   @version for CS56, W16, UCSB
   
*/
public class Glasses extends GeneralPathWrapper implements Shape
{
    /**
       Constructor
       
       @param x x coord of left rim of glasses
       @param y y coord of left rim of glasses
       @param width width of the glasses
       @param height of the glasses (the legs)
    */
    public Glasses(double x, double y, double width, double height)
    {
	
        // Rather than having to scale at the end, we can just
        // draw things the right way to begin with, using the
        // x, y, width and height.   If you haven't already
        // hard coded a particular drawing, this may be an easier
        // way.
        
        double lensWidth = width*0.4;//same as height of lens
	double middleWidth = width*0.2;
        
        // Make the front of glasses (lens and middle bridge)
        
        Rectangle2D.Double leftLens = 
            new Rectangle2D.Double(x, y - lensWidth/2,
				   lensWidth, lensWidth);
	
        // make the bridge between the lens
        
        Line2D.Double bridge = 
            new Line2D.Double (x + lensWidth, y,
                               x + lensWidth+ middleWidth, y);
	
        Rectangle2D.Double rightLens =
            new Rectangle2D.Double (x + width*0.6, y - lensWidth/2,
                               lensWidth, lensWidth);

	//draw the legs of the frame
	Line2D.Double leftLeg =
	    new Line2D.Double (x, y,
			       x + width*0.4, y - height);
	Line2D.Double rightLeg =
	    new Line2D.Double (x + width, y,
			       x + width*1.4, y - height);
	
	
        // put the whole glasses together
	
        GeneralPath whole = this.get();
        whole.append(leftLens, false);
        whole.append(bridge, false);
        whole.append(rightLens, false);
	whole.append(leftLeg, false);
	whole.append(rightLeg, false);
	
    }
}
