package edu.ucsb.cs56.w16.drawings.yukelele.advanced;
import java.awt.geom.GeneralPath;
import java.awt.Shape;

import java.awt.Graphics;
import java.awt.Graphics2D;

import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;

import edu.ucsb.cs56.w16.drawings.utilities.ShapeTransforms;
import edu.ucsb.cs56.w16.drawings.utilities.GeneralPathWrapper;

/**
   A vector drawing of a cube that implements the Shape interface, and so can be drawn, as well as rotated, scaled, etc. 

   @author Yuki Mano
   @version for CS56, W16, UCSB

*/

public class Cube extends GeneralPathWrapper implements Shape
{
    /**
       Constructor 

       @param x x coord of the center corner of the cube (in user's perspective)
       @param y y coord of the center corner of the cube (in user's perspective)
       @param side the length of each side of the Cube
       
    */

    public Cube(double x, double y, double side)
    {
	//initialized each corner/point of the cube
	//(that can only be seen in 2D or in user's perspective)

	double xPoint1 = x + 1.5*side;
	double yPoint1 = y - 1.5*side;

	double xPoint2 = x;
	double yPoint2 = y - 3*side;

	double xPoint3 = x - 1.5*side;
	double yPoint3 = y - 1.5*side;

	double xPoint4 = x - 1.5*side;
	double yPoint4 = y + 1.5*side;

	double xPoint5 = x;
	double yPoint5 = y + 3*side;

	double xPoint6 = x + 1.5*side;
	double yPoint6 = y + 1.5*side; 

	
	//draw each side of the cube by connecting each corner/point
	
	Line2D.Double originToPoint1 =
	    new Line2D.Double(x, y, xPoint1, yPoint1);
	
	Line2D.Double point1ToPoint2 =
	    new Line2D.Double(xPoint1, yPoint1, xPoint2, yPoint2);

	Line2D.Double point2ToPoint3 =
	    new Line2D.Double(xPoint2, yPoint2, xPoint3, yPoint3);

	Line2D.Double point3ToPoint4 =
	    new Line2D.Double(xPoint3, yPoint3, xPoint4, yPoint4);

       	Line2D.Double point4ToPoint5 =
	    new Line2D.Double(xPoint4, yPoint4, xPoint5, yPoint5);

 	Line2D.Double point5ToPoint6 =
	    new Line2D.Double(xPoint5, yPoint5, xPoint6, yPoint6);

	Line2D.Double point6ToPoint1 =
	    new Line2D.Double(xPoint6, yPoint6, xPoint1, yPoint1);

	Line2D.Double originToPoint3 =
	    new Line2D.Double(x, y, xPoint3, yPoint3);
	
	Line2D.Double originToPoint5=
	    new Line2D.Double(x, y, xPoint5, yPoint5);

	
	//put the whole cube together

	GeneralPath wholeCube = this.get();
	wholeCube.append(originToPoint1, false);
	wholeCube.append(point1ToPoint2, false);
	wholeCube.append(point2ToPoint3, false);
	wholeCube.append(point3ToPoint4, false);
	wholeCube.append(point4ToPoint5, false);
	wholeCube.append(point5ToPoint6, false);
	wholeCube.append(point6ToPoint1, false);
	wholeCube.append(originToPoint3, false);
	wholeCube.append(originToPoint5, false);	
    }
}
