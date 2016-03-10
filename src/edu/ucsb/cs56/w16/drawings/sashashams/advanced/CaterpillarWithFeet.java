package edu.ucsb.cs56.w16.drawings.sashashams.advanced;
import java.awt.geom.GeneralPath; // combinations of lines and curves
import java.awt.Shape; // general class for shapes

import java.awt.geom.Line2D; 
import java.awt.geom.Rectangle2D;
import java.awt.geom.Ellipse2D;

import edu.ucsb.cs56.w16.drawings.utilities.ShapeTransforms;
import edu.ucsb.cs56.w16.drawings.utilities.GeneralPathWrapper;

/**
   A vector drawing of Caterpillar WITH FEET, Shape is implemented to allow scaling, rotation, etc
      
   @author Sasha Shams
   @version for CS56, W16, UCSB
   
*/
public class CaterpillarWithFeet extends Caterpillar implements Shape
{
    /**
       Constructor
       
       @param x x coord of top left corner of caterpillar (caterpillar scales as one unit)
       @param y y coord of top left corner of caterpillar
       @param width width of the caterpillar
       @param height of the caterpillar drawing
    */
    public CaterpillarWithFeet(double x, double y, double width, double height)
    {
	super(x,y, width, height);
	double tempx = x;
	double tempy = y;
	double tempw = width;
	double temph = height;

        // Rather than having to scale at the end, we can just
        // draw things the right way to begin with, using the
        // x, y, width and height.   If you haven't already
        // hard coded a particular drawing, this may be an easier
        // way.
	//set y coordinate of the height of the legs(bottom of the body part ellipses)
    double y1 = .85*height + y;
    GeneralPath wholeBug = this.get();
    //Declare the x coordinate of the joining point of both legs for each body part.
    //Each body part is spaced .15*width apart from eachother, .075*width gives us the center of the body part. 
    //center point is at the bottom end of the major axis of the ellipse
    double x1 = x + .075*width;
    double x2 = x + .225*width;
    double x3 = x + .375*width;
    double x4 = x + .525*width;
    double x5 = x + .675*width;
    //body part 1
	Line2D.Double body1FirstLeg1 = new Line2D.Double(x1-.075*width,y+height,x1,y1);
	Line2D.Double body1FirstLeg2 = new Line2D.Double(x1-.075*width,y+height, x1-.0325*width,y+height);
	Line2D.Double body1SecondLeg1 = new Line2D.Double(x1,y1,x1,y+height);
	Line2D.Double body1SecondLeg2 = new Line2D.Double(x1,y+height, x1 + .0325*width, y+height);
	wholeBug.append(body1FirstLeg1,false);
	wholeBug.append(body1FirstLeg2,false);
	wholeBug.append(body1SecondLeg1,false);
	wholeBug.append(body1SecondLeg2,false);
	// body part 2
	Line2D.Double body2FirstLeg1 = new Line2D.Double(x2-.075*width,y+height,x2,y1);
	Line2D.Double body2FirstLeg2 = new Line2D.Double(x2-.075*width,y+height, x2-.0325*width,y+height);
	Line2D.Double body2SecondLeg1 = new Line2D.Double(x2,y1,x2,y+height);
	Line2D.Double body2SecondLeg2 = new Line2D.Double(x2,y+height, x2 + .0325*width, y+height);
	wholeBug.append(body2FirstLeg1,false);
	wholeBug.append(body2FirstLeg2,false);
	wholeBug.append(body2SecondLeg1,false);
	wholeBug.append(body2SecondLeg2,false);
	//body part 3
	Line2D.Double body3FirstLeg1 = new Line2D.Double(x3-.075*width,y+height,x3,y1);
	Line2D.Double body3FirstLeg2 = new Line2D.Double(x3-.075*width,y+height, x3-.0325*width,y+height);
	Line2D.Double body3SecondLeg1 = new Line2D.Double(x3,y1,x3,y+height);
	Line2D.Double body3SecondLeg2 = new Line2D.Double(x3,y+height, x3 + .0325*width, y+height);
	wholeBug.append(body3FirstLeg1,false);
	wholeBug.append(body3FirstLeg2,false);
	wholeBug.append(body3SecondLeg1,false);
	wholeBug.append(body3SecondLeg2,false);
	//body part 4
	Line2D.Double body4FirstLeg1 = new Line2D.Double(x4-.075*width,y+height,x4,y1);
	Line2D.Double body4FirstLeg2 = new Line2D.Double(x4-.075*width,y+height, x4-.0325*width,y+height);
	Line2D.Double body4SecondLeg1 = new Line2D.Double(x4,y1,x4,y+height);
	Line2D.Double body4SecondLeg2 = new Line2D.Double(x4,y+height, x4 + .0325*width, y+height);
	wholeBug.append(body4FirstLeg1,false);
	wholeBug.append(body4FirstLeg2,false);
	wholeBug.append(body4SecondLeg1,false);
	wholeBug.append(body4SecondLeg2,false);	
	//body part 5
    Line2D.Double body5FirstLeg1 = new Line2D.Double(x5-.075*width,y+height,x5,y1);
	Line2D.Double body5FirstLeg2 = new Line2D.Double(x5-.075*width,y+height, x5-.0325*width,y+height);
	Line2D.Double body5SecondLeg1 = new Line2D.Double(x5,y1,x5,y+height);
	Line2D.Double body5SecondLeg2 = new Line2D.Double(x5,y+height, x5 + .0325*width, y+height);
	wholeBug.append(body5FirstLeg1,false);
	wholeBug.append(body5FirstLeg2,false);
	wholeBug.append(body5SecondLeg1,false);
	wholeBug.append(body5SecondLeg2,false);

    }
}





/*
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
	wholeBug.append(body5,false);*/
