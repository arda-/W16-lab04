package edu.ucsb.cs56.w16.drawings.yukelele.advanced;
import java.awt.geom.GeneralPath;
import java.awt.Shape;

import java.awt.Graphics;
import java.awt.Graphics2D;

import java.awt.geom.Line2D;

import edu.ucsb.cs56.w16.drawings.utilities.ShapeTransforms;
import edu.ucsb.cs56.w16.drawings.utilities.GeneralPathWrapper;

/**
   Draw a Rubik's Cube using Cube as the basic figure (but only showing 3 faces) 

   @author Yuki Mano
   @version for CS56, W16, UCSB

*/

public class RubiksCube extends Cube implements Shape
{
    /**
       Constructor for objects of class RubiksCube
       @param x x coordinate at the center corner of the Rubik's Cube
       @param y y coordinate at the center corner of the Rubik's Cube
       @param side the length of each side of the cube
*/
    
    public RubiksCube(double x, double y, double side)
    {
	// construct the basic cube figure
	super(x,y,side);

	//get the GeneralPath that we are going to append stuff to
	GeneralPath gp = this.get();

	
	//Make nine equal square in each of the Cube's face (that user can see)
	double x1 = x;
	double y1 = y + side;

	double x2 = x;
	double y2 = y + 2*side;

	double x3 = x + 1.5*side;
	double y3 = y - 1.5*side + side;

	double x4 = x + 1.5*side;
	double y4 = y - 1.5*side + 2*side;

	double x5 = x - 1.5*side;
	double y5 = y - 1.5*side + side;

	double x6 = x - 1.5*side;
	double y6 = y - 1.5*side + 2*side;

	double x7 = x + .5*side;
	double y7 = y - .5*side;

	double x8 = x + side;
	double y8 = y - side;

	double x9 = x + .5*side;
	double y9 = y - .5*side + 3*side;

	double x10 = x + side;
	double y10 = y - side + 3*side;

	double x11 = x - .5*side;
	double y11 = y - .5*side;

	double x12 = x - side;
	double y12 = y - side;

	double x13 = x - .5*side;
	double y13 = y - .5*side + 3*side;

	double x14 = x - side;
	double y14 = y - side + 3*side; 

	double x15 = x + side;
	double y15 = y - 2*side;

	double x16 = x + .5*side;
	double y16 = y - 2.5*side;

	double x17 = x - side;
	double y17 = y - 2*side;

	double x18 = x - .5*side;
	double y18 = y - 2.5*side;
	
	Line2D.Double pt1ToPt3 =
	    new Line2D.Double(x1, y1, x3, y3);

	Line2D.Double pt2ToPt4 =
	    new Line2D.Double(x2, y2, x4, y4);

	Line2D.Double pt1ToPt5 =
	    new Line2D.Double(x1, y1, x5, y5);

	Line2D.Double pt2ToPt6 =
	    new Line2D.Double(x2, y2, x6, y6);

	Line2D.Double pt7ToPt9 =
	    new Line2D.Double(x7, y7, x9, y9);

	Line2D.Double pt8ToPt10 =
	    new Line2D.Double(x8, y8, x10, y10);

	Line2D.Double pt11ToPt13 =
	    new Line2D.Double(x11, y11, x13, y13);

	Line2D.Double pt12ToPt14 =
	    new Line2D.Double(x12, y12, x14, y14);

	Line2D.Double pt11ToPt15 =
	    new Line2D.Double(x11, y11, x15, y15);

	Line2D.Double pt12ToPt16 =
	    new Line2D.Double(x12, y12, x16, y16);

	Line2D.Double pt7ToPt17 =
	    new Line2D.Double(x7, y7, x17, y17);

	Line2D.Double pt8ToPt18 =
	    new Line2D.Double(x8, y8, x18, y18);



	//put the whole Rubik's Cube together
	GeneralPath wholeRubiksCube = this.get();
	wholeRubiksCube.append(pt1ToPt3, false);
	wholeRubiksCube.append(pt2ToPt4, false);
	wholeRubiksCube.append(pt1ToPt5, false);
	wholeRubiksCube.append(pt2ToPt6, false);
	wholeRubiksCube.append(pt7ToPt9, false);
	wholeRubiksCube.append(pt8ToPt10, false);
	wholeRubiksCube.append(pt11ToPt13, false);
	wholeRubiksCube.append(pt12ToPt14, false);
	wholeRubiksCube.append(pt11ToPt15, false);
	wholeRubiksCube.append(pt12ToPt16, false);
	wholeRubiksCube.append(pt7ToPt17, false);
	wholeRubiksCube.append(pt8ToPt18, false);
    }
}
