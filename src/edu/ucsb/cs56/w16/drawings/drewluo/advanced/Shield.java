package edu.ucsb.cs56.w16.drawings.drewluo.advanced;
import java.awt.geom.GeneralPath; // combinations of lines and curves
import java.awt.Shape; // general class for shapes

import java.awt.geom.Line2D; 
import java.awt.geom.Rectangle2D;

import edu.ucsb.cs56.w16.drawings.utilities.ShapeTransforms;
import edu.ucsb.cs56.w16.drawings.utilities.GeneralPathWrapper;

/**
   A vector drawing of a shield that implements
   the Shape interface, and so can be drawn, as well as
   rotated, scaled, etc.
      
   @author Andrew Luo 
   @version for CS56, W16, UCSB
   
*/
public class Shield extends GeneralPathWrapper implements Shape
{
    /**
       Constructor
       
       @param x x coord of top left corner of shield
       @param y y coord of top left corner of shield
       @param width width of shield
       @param height total height of shield
    */
    public Shield(double x, double y, double width, double height)
    {
	
        // Rather than having to scale at the end, we can just
        // draw things the right way to begin with, using the
        // x, y, width and height.   If you haven't already
        // hard coded a particular drawing, this may be an easier
        // way.
        
        double coreShieldHeight = .8 * height;
        double shieldPointHeight = height - coreShieldHeight;
        
        //make the top part of the shield

	
	Line2D.Double topOfShield =
	    new Line2D.Double ( x, y, x + width, y );

	Line2D.Double leftSide =
	    new Line2D.Double ( x, y, x, y + coreShieldHeight );

	Line2D.Double rightSide =
	    new Line2D.Double ( x + width, y, x+width, y + coreShieldHeight );
	
        // make the point of the shield.   Remember that y goes DOWN the page,
        // so we ADD to y to get a "lower" value on the screen
        
        Line2D.Double leftSideOfPoint  = 
            new Line2D.Double (x, y + coreShieldHeight,
                               x + width/2.0, y + height);
	
        Line2D.Double rightSideOfPoint =
            new Line2D.Double (x + width, y + coreShieldHeight,
                               x + width/2.0, y + height);
	
        // put the whole shield together
	
        GeneralPath wholeShield = this.get();
        wholeShield.append(topOfShield, false);
	wholeShield.append(leftSide, false);
	wholeShield.append(rightSide, false);
        wholeShield.append(leftSideOfPoint, false);
        wholeShield.append(rightSideOfPoint, false);    
    }
}
