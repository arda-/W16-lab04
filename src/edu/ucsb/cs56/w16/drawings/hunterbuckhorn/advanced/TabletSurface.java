package edu.ucsb.cs56.w16.drawings.hunterbuckhorn.advanced;
import java.awt.geom.GeneralPath; // combinations of lines and curves
import java.awt.Shape; // general class for shapes

import java.awt.geom.Line2D; 
import java.awt.geom.Rectangle2D;

import edu.ucsb.cs56.w16.drawings.utilities.ShapeTransforms;
import edu.ucsb.cs56.w16.drawings.utilities.GeneralPathWrapper;

/**
   A vector drawing of a Tablet that implements
   the Shape interface, and so can be drawn, as well as
   rotated, scaled, etc.
      
   @author Hunter Buckhorn
   @version for CS56, W16, UCSB
   
*/
public class TabletSurface extends Tablet implements Shape
{

    public TabletSurface(double x, double y, double width, double height)
    {
	// call the superclass Tablet constructor
	super(x, y, width, height);
	
	// Get the general part that we add drawings to
	GeneralPath gp = this.get();
	
	// add a windows logo on the inside
	
	double x1 = x + width/2 - width/20 - 2;
	double y1 = y + height/2 - height/20 - 2;
	
	double x2 = x + width/2 + 2;
	double y2 = y + height/2 + 2;
	
	Rectangle2D.Double logo1 = new Rectangle2D.Double(x1, y1, width/20, height/20);
	Rectangle2D.Double logo2 = new Rectangle2D.Double(x2, y1, width/20, height/20);
	Rectangle2D.Double logo3 = new Rectangle2D.Double(x1, y2, width/20, height/20);
	Rectangle2D.Double logo4 = new Rectangle2D.Double(x2, y2, width/20, height/20);
	
	
	
	
        // put the whole tablet together
	
	GeneralPath wholeTablet = this.get();
	
	// add the windows logo
	wholeTablet.append(logo1, false);
	wholeTablet.append(logo2, false);
	wholeTablet.append(logo3, false);
	wholeTablet.append(logo4, false);
    }	
	
}
