package edu.ucsb.cs56.w16.drawings.rockysikem.advanced;
import java.awt.geom.GeneralPath; // combinations of lines and curves
import java.awt.Shape; // general class for shapes

import java.awt.geom.Line2D; 
import java.awt.geom.Rectangle2D;

import edu.ucsb.cs56.w16.drawings.utilities.ShapeTransforms;
import edu.ucsb.cs56.w16.drawings.utilities.GeneralPathWrapper;

/**
   A drawing of a Regular dinner table with no cutlery.
      
   @author Ishjot Walia
   @version for CS56, W16, UCSB
   
*/
public class DinnerTable extends GeneralPathWrapper implements Shape
{
    /**
       Constructor
       
       @param x x coord of lower left corner of table
       @param y y coord of lower left corner of table
       @param width width of the table
       @param height of table
    */
    public DinnerTable(double x, double y, double width, double height)
    {
	
        // Rather than having to scale at the end, we can just
        // draw things the right way to begin with, using the
        // x, y, width and height.   If you haven't already
        // hard coded a particular drawing, this may be an easier
        // way.
        
	double tableTopLeftY = y - height;
        
        Rectangle2D.Double plainTable = 
            new Rectangle2D.Double(x, tableTopLeftY ,
				   width, height);
	
        // put the whole table together
	
        GeneralPath wholeHouse = this.get();
        wholeHouse.append(plainTable, false);
    }
}
