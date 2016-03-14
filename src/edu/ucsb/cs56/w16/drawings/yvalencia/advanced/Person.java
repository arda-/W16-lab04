package edu.ucsb.cs56.w16.drawings.yvalencia.advanced;
import java.awt.geom.GeneralPath; // combinations of lines and curves
import java.awt.Shape; // general class for shapes

import java.awt.geom.Line2D; 
import java.awt.geom.Rectangle2D;
import java.awt.geom.Ellipse2D; 
import edu.ucsb.cs56.w16.drawings.utilities.ShapeTransforms;
import edu.ucsb.cs56.w16.drawings.utilities.GeneralPathWrapper;

/**
   A vector drawing of a house that implements
   the Shape interface, and so can be drawn, as well as
   rotated, scaled, etc.
      
   @author Phill Conrad 
   @version for CS56, W16, UCSB
   
*/
public class Person extends GeneralPathWrapper implements Shape
{
    /**
       Constructor
       
       @param height; length of legs, arms and radius of head will come from here to keep person shape proportionate. 
    */
    public Person(double x, double y, double height)
    {
	
        // Rather than having to scale at the end, we can just
        // draw things the right way to begin with, using the
        // x, y, width and height.   If you haven't already
        // hard coded a particular drawing, this may be an easier
        // way.
        
        double headRadius = height/3;
	Line2D.Double neck = new Line2D.Double (x + headRadius, y + (headRadius * 2), x + headRadius, y + (headRadius * 3)); 
	Line2D.Double arm1 = new Line2D.Double (x + headRadius, y + (headRadius * 3), x + (headRadius * 2), y + (headRadius * 2)); 
	Line2D.Double arm2 = new Line2D.Double (x + headRadius, y + (headRadius * 3), x, (y + headRadius * 2)); 
	Line2D.Double leg1 = new Line2D.Double (x + headRadius, y + (headRadius * 5), x + (headRadius * 2), y + (headRadius * 6));
	Line2D.Double leg2 = new Line2D.Double (x + headRadius, y + (headRadius * 5), x, y + (headRadius * 6)); 
	Ellipse2D.Double head = new Ellipse2D.Double (x, y, (headRadius * 2), (headRadius * 2)); 
	
        Line2D.Double spine =
            new Line2D.Double (x + headRadius, y + headRadius * 2,
                               x + headRadius, y + headRadius * 2 + height);
	
        // put the whole house together
	
        GeneralPath wholePerson = this.get();
        wholePerson.append(neck, false);
        wholePerson.append(head, false);
        wholePerson.append(spine, false);
	wholePerson.append(leg1, false); 
	wholePerson.append(leg2, false); 
	wholePerson.append(arm1, false); 
	wholePerson.append(arm2, false);
    }
}
