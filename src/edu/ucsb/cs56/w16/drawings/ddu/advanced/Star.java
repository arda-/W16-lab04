package edu.ucsb.cs56.w16.drawings.ddu.advanced;

import java.awt.*;
import java.awt.geom.*;

import edu.ucsb.cs56.w16.drawings.utilities.ShapeTransforms;
import edu.ucsb.cs56.w16.drawings.utilities.GeneralPathWrapper;

public class Star extends GeneralPathWrapper implements Shape {

    private double length;

    /**
       Constructor

       @param x coordinate of tip of center triangle
       @param y coordinate of tip of center triangle
       @param length of triangle edge on star

    */
    
    public Star(double x, double y, double length)
    {
	this.length = length;
	double degree1 = 1.25664;
	double degree2 = 0.628319;
	double degree3 = degree2 + 1.5708;
	double point1x = x + length * Math.cos(-degree1);
	double point1y = y - length * Math.sin(-degree1);
	
	Line2D.Double edge1 =
	    new Line2D.Double(x, y, point1x, point1y);

	double point2x = x - length * Math.cos(degree1);
	double point2y = point1y;
	
	Line2D.Double edge2 =
	    new Line2D.Double(x, y, point2x, point2y);

	double point3x = point1x - length * Math.cos(degree2);
	double point3y = point1y - length * Math.sin(degree2);
	
	Line2D.Double edge3 =
	    new Line2D.Double(point1x, point1y, point3x, point3y);

	double point4x = point2x + length * Math.cos(degree2);
	double point4y = point2y - length * Math.sin(degree2);

	Line2D.Double edge4 =
	    new Line2D.Double(point2x, point2y, point4x, point4y);

	Line2D.Double edge5 =
	    new Line2D.Double(point3x, point3y, point4x, point4y);

	
	

	GeneralPath starPath = this.get();
	starPath.append(edge1, false);
	starPath.append(edge2, false);
	starPath.append(edge3, false);
	starPath.append(edge4, false);
	starPath.append(edge5, false);
	
    }
	
    
}
