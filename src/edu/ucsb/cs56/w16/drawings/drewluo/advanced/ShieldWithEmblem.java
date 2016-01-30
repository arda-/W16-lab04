package edu.ucsb.cs56.w16.drawings.drewluo.advanced;
import java.awt.geom.GeneralPath;  
import java.awt.Shape; 
import java.awt.geom.Rectangle2D;

import edu.ucsb.cs56.w16.drawings.utilities.ShapeTransforms;
/**
   A Shield with a DIAMOND emblem
      
   @author Andrew Luo 
   @version for CS56, W16, UCSB
   
*/
public class ShieldWithEmblem extends Shield implements Shape
{
    /**
     * Constructor for objects of class ShieldWithEmblem
     */
    public ShieldWithEmblem(double x, double y, double width, double height)
    {
	// construct the basic shield shell
	super(x,y,width,height);
	
	// get the GeneralPath that we are going to append stuff to
	GeneralPath gp = this.get();
	
	// Make a diamond (a rotated square) in the center
	// of the shield. The center is considered to be at
	// x=width/2 and y = height/2. The length of the edges
	// of the diamond are the smaller of width/2.0 and
	// height/2.0
	
	double emblemX = 0.25 * width;
	double emblemY = 0.25 * height;
	double emblemLngth = 0.0;
	if(width < height)
	    emblemLngth =  0.5 * width;
	else { 
	    emblemLngth = 0.5 * height;
	    emblemX = (width - emblemLngth)/2.0;
	}
	
	Rectangle2D.Double square =
	    new Rectangle2D.Double(x + emblemX,
				   y + emblemY,
				   emblemLngth,
				   emblemLngth);
	//Rotate 45 degrees to get diamond shape
	Shape emblem = ShapeTransforms.rotatedCopyOf(square, Math.PI/4.0);
	
	// add the emblem to the shield
	// Look up the meaning of the second parameter of append
	// (Hint--is a method of "GeneralPath")
	
        GeneralPath wholeShield = this.get();
        wholeShield.append(emblem, false); 
    }    
}
