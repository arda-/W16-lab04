package edu.ucsb.cs56.w16.drawings.yvalencia.advanced;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;
import javax.swing.JComponent;

// the four tools things we'll use to draw

import java.awt.geom.Line2D;  // single lines
import java.awt.geom.Ellipse2D;  // ellipses and circles
import java.awt.Rectangle;  // squares and rectangles
import java.awt.geom.GeneralPath; // combinations of lines and curves


import java.awt.geom.Rectangle2D; // for rectangles drawing with Doubles

import java.awt.Color; // class for Colors
import java.awt.Shape; // Shape interface
import java.awt.Stroke; // Stroke interface
import java.awt.BasicStroke; // class that implements stroke

import edu.ucsb.cs56.w16.drawings.utilities.ShapeTransforms;
import edu.ucsb.cs56.w16.drawings.utilities.GeneralPathWrapper;


/**
   A component that draws an animated picture by Yessenia Valencia
   
   @author Yessenia Valencia
   @version CS56, W16
   
*/


public class AnimatedPictureComponent extends JComponent
{  
    private Shape person;
    private double PersonHeight;
    private double wobbleSpeed;
    private double amplitude = 3.2;
    private double travelSpeed;
    private double xTravel = 0;
    private double startingPosition;
    private double startingX;
    private double xPos;
    private double startingY;
    private double startingSpineHeight;
    private double t;
    private double angle = 1.75*Math.PI;
    private double travelDistance;


    // starting length: 150
    /** Constructs an AnimatedPictureComponent with specific properties.
	This animated picture depicts a person writing across the screen
	@param startingX the starting x position of the person
	@param startingY the starting y position of the person
	@param travelSpeed the speed at which the person will move
	across the screen
	@param travelDistance the number of pixels the person will move
	across the screen before stopping
	@param wobbleSpeed the speed at which the person wobbles (walks) back and forth
	@param startingSpineHeight the starting spine height (half the height of the person) of the person in pixels
    */
    public AnimatedPictureComponent(double startingX, double startingY, double travelSpeed, double travelDistance, double wobbleSpeed, double startingSpineHeight) {
	this.startingX = startingX;
	this.startingY = startingY;
	this.xPos = startingX;
	this.travelSpeed = travelSpeed;
	this.travelDistance = travelDistance;
	this.wobbleSpeed = wobbleSpeed;
	this.startingSpineHeight = startingSpineHeight;

	person = new PersonWithCube(this.xPos, this.startingY,  this.startingSpineHeight);
	PersonHeight = 2*startingSpineHeight;
    }

    /** The paintComponent method is orverriden to display
	out animation. Each time this method is called, the
	position of the person is updated
    */
    
    public void paintComponent(Graphics g)
    {  
	Graphics2D g2 = (Graphics2D) g;
	//g2.draw(new Rectangle(0, 0, 
	if (xPos >= startingX + travelDistance) {
	    this.xPos = startingX;
	    this.t = 0;
	    this.xTravel = 0;
	    return;
	}
	else
	    g2.setColor(Color.BLACK); g2.draw(person);

	t += wobbleSpeed;
	xTravel += travelSpeed;
	xPos = xTravel + startingX;
	double wobble = amplitude*(1/wobbleSpeed)*Math.sin(t) + amplitude*0.8*(1/wobbleSpeed)*Math.sin(0.8*t+1.5);
	xPos += wobble;
	double length = (1 - (xTravel/travelDistance))*(startingSpineHeight - PersonHeight) + PersonHeight;
	double yPos = startingY + (startingSpineHeight - length);
       
	person = ShapeTransforms.rotatedCopyOf(new PersonWithCube(xPos, yPos, length), 0.015*wobble);
    }    
  
}
