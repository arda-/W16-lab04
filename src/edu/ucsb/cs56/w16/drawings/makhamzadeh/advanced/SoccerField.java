package edu.ucsb.cs56.w16.drawings.makhamzadeh.advanced;
import java.awt.geom.GeneralPath; // combinations of lines and curves
import java.awt.Shape; // general class for shapes

import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;
import java.awt.geom.Ellipse2D;

import edu.ucsb.cs56.w16.drawings.utilities.ShapeTransforms;
import edu.ucsb.cs56.w16.drawings.utilities.GeneralPathWrapper;

/**
   A Soccer Field (wrapper around a General Path, implements Shape)

   This provides an example of how you can start with the coordinates
   of a hard coded object, and end up with an object that can be
   drawn anywhere, with any width or height.   
      
   @author Phill Conrad 
   @author Matin Akhamzadeh
   @version for CS56, W16, UCSB
   
*/
public class SoccerField extends Field implements Shape
{   
    /**
     * Constructor for objects of class SoccerField
     @param x x coordinate is the top left corner of the field (with y coordinate)
     @param y y coordinate is the top left corner of the field (with x coordinate)
     @param width width is the length of the width of the soccer field created 
     */
    public SoccerField(double x, double y, double width)
    {

	super(x,y,width);

	double fieldHeight = 0.5 * width;
	double fieldLength = width;

	GeneralPath field = this.get();

	//draw lines that go on field representing goal
	
	GeneralPath leftGoal = new GeneralPath();
	leftGoal.moveTo(x,y+(fieldHeight/3));
	leftGoal.lineTo(x-(fieldLength/15),y+(fieldHeight/3));
	leftGoal.lineTo(x-(fieldLength/15),y+(fieldHeight/3)+(fieldHeight/4));
	leftGoal.lineTo(x,y+(fieldHeight/3)+(fieldHeight/4));
   
	GeneralPath rightGoal = new GeneralPath();
	rightGoal.moveTo(x+fieldLength,y+(fieldHeight/3));
	rightGoal.lineTo(x+fieldLength+(fieldLength/15),y+(fieldHeight/3));
	rightGoal.lineTo(x+fieldLength+(fieldLength/15),y+(fieldHeight/3)+(fieldHeight/4));
	rightGoal.lineTo(x+fieldLength,y+(fieldHeight/3)+(fieldHeight/4));
	
	//draw half court line on field and middle circle
	
	GeneralPath middleLine = new GeneralPath();
	middleLine.moveTo(x+(fieldLength/2),y);
	middleLine.lineTo(x+(fieldLength/2),y+fieldHeight);

	//create middle circle of field
	Ellipse2D.Double midCircle = new Ellipse2D.Double(x+(fieldLength/2.25),y+(fieldHeight/3.15),fieldHeight/4,fieldHeight/4);
	
	
	//draw penalty area

	GeneralPath leftPenaltyArea = new GeneralPath();
	leftPenaltyArea.moveTo(x,y+(fieldHeight/2)-(fieldHeight/3));
	leftPenaltyArea.lineTo(x+(fieldLength/3.75),y+(fieldHeight/2)-(fieldHeight/3.5));
	leftPenaltyArea.lineTo(x+(fieldLength/3.75),y+(fieldHeight/2)-(fieldHeight/3.5)+(fieldHeight/2));
	leftPenaltyArea.lineTo(x,y+(fieldHeight/2)-(fieldHeight/3.75)+(fieldHeight/2));
	
	GeneralPath rightPenaltyArea = new GeneralPath();
	rightPenaltyArea.moveTo(x+fieldLength,y+(fieldHeight/2)-(fieldHeight/3));
	rightPenaltyArea.lineTo(x+fieldLength-(fieldLength/3.75),y+(fieldHeight/2)-(fieldHeight/3.5));
	rightPenaltyArea.lineTo(x+fieldLength-(fieldLength/3.75),y+(fieldHeight/2)-(fieldHeight/3.5)+(fieldHeight/2));
	rightPenaltyArea.lineTo(x+fieldLength,y+(fieldHeight/2)-(fieldHeight/3.75)+(fieldHeight/2));
			    
	
	//put whole soccer field together
       
	GeneralPath wholeSoccerField = this.get();
	wholeSoccerField.append(leftGoal, false);
	wholeSoccerField.append(rightGoal, false);
	wholeSoccerField.append(middleLine, false);
	wholeSoccerField.append(midCircle, false);
	wholeSoccerField.append(leftPenaltyArea, false);
	wholeSoccerField.append(rightPenaltyArea, false);
	

	
    }

}
	
