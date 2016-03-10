package edu.ucsb.cs56.w16.drawings.sashashams.advanced;
import java.awt.geom.GeneralPath; // combinations of lines and curves
import java.awt.Shape; // general class for shapes

import java.awt.geom.Line2D; 
import java.awt.geom.Rectangle2D;
import java.awt.geom.Ellipse2D;

import edu.ucsb.cs56.w16.drawings.utilities.ShapeTransforms;
import edu.ucsb.cs56.w16.drawings.utilities.GeneralPathWrapper;

/**
   A vector drawing of Caterpillar, Shape is implemented to allow scaling, rotation, etc
      
   @author Sasha Shams
   @version for CS56, W16, UCSB
   
*/
public class Caterpillar extends GeneralPathWrapper implements Shape
{
    /**
       Constructor
       
       @param x x coord of top left corner of caterpillar (caterpillar scales as one unit)
       @param y y coord of top left corner of caterpillar
       @param width width of the caterpillar
       @param height of the caterpillar drawing
    */
    public Caterpillar(double x, double y, double width, double height)
    {
	
        // Rather than having to scale at the end, we can just
        // draw things the right way to begin with, using the
        // x, y, width and height.   If you haven't already
        // hard coded a particular drawing, this may be an easier
        // way.'
	double headHeight = .75 * height;
	double headWidth = .25 * width;
	double bodyHeight = .5 * height;
	double bodyWidth = .15 * width;
	double leftEyeOrigX = x+.875*width;
	double leftEyeOrigY = y + .5*height;
	double rightEyeOrigY = y + .5*height;
	double rightEyeOrigX = x + .9375*width;
        double eyeHeight = .1 * height;
	double eyeWidth = .0625 * width;
	// Create head
	double headOrigX = x + .75*width;
	double headOrigY = y + .25*height;
	Ellipse2D.Double head = new Ellipse2D.Double(headOrigX,headOrigY,headWidth,headHeight);
	//
	Ellipse2D.Double body1 = new Ellipse2D.Double(x,y+height*.35,bodyWidth,bodyHeight);
	Ellipse2D.Double body2 = new Ellipse2D.Double(x+.15*width,y+height*.35,bodyWidth,bodyHeight);
   	Ellipse2D.Double body3 = new Ellipse2D.Double(x+.30*width,y+height*.35,bodyWidth,bodyHeight);
	Ellipse2D.Double body4 = new Ellipse2D.Double(x+.45*width,y+height*.35,bodyWidth,bodyHeight);
	Ellipse2D.Double body5 = new Ellipse2D.Double(x+.60*width,y+height*.35,bodyWidth,bodyHeight);
	Ellipse2D.Double leftEye = new Ellipse2D.Double(leftEyeOrigX,leftEyeOrigY,eyeWidth,eyeHeight);
	Ellipse2D.Double rightEye = new Ellipse2D.Double(rightEyeOrigX,rightEyeOrigY,eyeWidth,eyeHeight);
	Line2D.Double leftAntler = new Line2D.Double(x+.75*width,y,x+.875*width,y+.25*height);
        Line2D.Double rightAntler = new Line2D.Double(x+.875*width,y+.25*height,x+width,y);
	GeneralPath wholeBug = this.get();
	wholeBug.append(leftAntler,false);
	wholeBug.append(rightAntler,false);
	wholeBug.append(leftEye,false);
	wholeBug.append(rightEye,false);
	wholeBug.append(head,false);
	wholeBug.append(body1,false);
	wholeBug.append(body2,false);
	wholeBug.append(body3,false);
	wholeBug.append(body4,false);
	wholeBug.append(body5,false);

    }
}
