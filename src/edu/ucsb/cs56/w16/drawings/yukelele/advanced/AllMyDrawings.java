package edu.ucsb.cs56.w16.drawings.yukelele.advanced;

import java.awt.Graphics2D;
import java.awt.Shape; // general class for shapes
import java.awt.Color; // class for Colors
import java.awt.Stroke;
import java.awt.BasicStroke;

import edu.ucsb.cs56.w16.drawings.utilities.ShapeTransforms;
import edu.ucsb.cs56.w16.drawings.utilities.GeneralPathWrapper;

/**
 * A class with static methods for drawing various pictures
 * 
 * @author Yuki Mano 
 * @version for UCSB CS56, W16 
 */

public class AllMyDrawings
{
    /** Draw a picture with a few cubes and Rubik's Cube
     */
    
    public static void drawPicture1(Graphics2D g2) {

	
	//Make a red cube
	Cube c1 = new Cube(200,200,20);
	g2.setColor(Color.RED); g2.draw(c1);

	// Make a blue cube that's 1.5x bigger than the original, 
	// and moved over 250 pixels in x & y direction 
	
	Shape c2 = ShapeTransforms.scaledCopyOfLL(c1,1.5,1.5);
	c2 = ShapeTransforms.translatedCopyOf(c2,250,250);
	g2.setColor(Color.BLUE); g2.draw(c2);
	
	// Here's a cube that's 3x as big (3x the original)
	// and moved over 300 more pixels to the right
	// and 300 more pixels to the bottom
	c2 = ShapeTransforms.scaledCopyOfLL(c2,3,3);
	c2 = ShapeTransforms.translatedCopyOf(c2,300,300);
	
	
	// We'll draw this with a thicker stroke
	Stroke thick = new BasicStroke (4.0f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL);       
	
	// for hex colors, see (e.g.) http://en.wikipedia.org/wiki/List_of_colors
	// #002FA7 is "International Klein Blue" according to Wikipedia
	// In HTML we use #, but in Java (and C/C++) its 0x
	
	Stroke orig=g2.getStroke();
	g2.setStroke(thick);
	g2.setColor(new Color(0x56EBA9)); 
	g2.draw(c2); 
	
	// Draw the Rubik's Cube along the basic Cube figures
	
	RubiksCube rc1 = new RubiksCube(400,200,25);
	RubiksCube rc2 = new RubiksCube(250,400,55);
	RubiksCube rc3 = new RubiksCube(650,225,70);
	
	g2.draw(rc1);
	g2.setColor(new Color(0x8F00FF)); g2.draw(rc2);
	g2.setColor(new Color(0x7F2B5C)); g2.draw(rc3);
	
	// @@@ FINALLY, SIGN AND LABEL YOUR DRAWING
	
	g2.setStroke(orig);
	g2.setColor(Color.BLACK); 
	g2.drawString("A few cubes and Rubik's Cubes by Yuki Mano", 100,100);
    }
    
    
    /** Draw a picture with a Cubes and Rubik's Cubes
     */
    public static void drawPicture2(Graphics2D g2) {
	
	// Draw a couple of cubes.
	Cube c1 = new Cube(323, 212, 42);
	Cube c2 = new Cube(145, 198, 56);
	Cube c3 = new Cube(305, 53, 12);
	Cube c4 = new Cube(156, 156, 34);

	g2.setColor(Color.YELLOW); g2.draw(c1);
	g2.setColor(Color.GRAY); g2.draw(c2);
	g2.setColor(Color.ORANGE); g2.draw(c3);
	g2.setColor(Color.CYAN); g2.draw(c4);

	RubiksCube rc1 = new RubiksCube(200, 300, 12);
	g2.setColor(Color.DARK_GRAY); g2.draw(rc1);

	//Make a red Rubik's Cube that's double the size,
	//and moved over -200 pixels in x directin 
	//and 200 pixels in y direction
	Shape rc2 = ShapeTransforms.scaledCopyOfLL(rc1, 2, 2);
	rc2 = ShapeTransforms.translatedCopyOf(rc2, -150, 200);
	g2.setColor(Color.RED); g2.draw(rc2);
	
	// Here's a Rubik's Cube that's 1.5x as big (1.5x the original)
	// and moved over 350 more pixels to right.
	rc2 = ShapeTransforms.scaledCopyOfLL(rc2,1.5,1.5);
	rc2 = ShapeTransforms.translatedCopyOf(rc2,350,0);
	
	// We'll draw this with a thicker stroke
	Stroke thick = new BasicStroke (4.0f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL);       
        
	Stroke orig=g2.getStroke();
	g2.setStroke(thick);
	g2.setColor(new Color(0x7B32A7)); 
	g2.draw(rc2);

	

	// Rotate one of the Rubik's Cube by  45 degrees around its center.
	Shape rc3 = ShapeTransforms.rotatedCopyOf(rc1, Math.PI/4.0);
	rc3 = ShapeTransforms.scaledCopyOfLL(rc3, 2, 2);
	rc3 = ShapeTransforms.translatedCopyOf(rc3, 300, -150);
	g2.setColor(Color.GREEN);
	g2.draw(rc3);
	
	// @@@ FINALLY, SIGN AND LABEL YOUR DRAWING
	
	g2.setStroke(orig);
	g2.setColor(Color.BLACK); 
	g2.drawString("A bunch of Cubes and Rubik's Cube by Yuki Mano", 15,25);
    }
    
    /** Draw a different picture with a few Rubik's Cubes     */
    
    public static void drawPicture3(Graphics2D g2) {
	
	// label the drawing
	
	g2.drawString("A mutiple of Rubik's Cubes by Yuki Mano", 20,20);
	
	
	// Draw some Rubik's Cube

	RubiksCube rc1 = new RubiksCube(300,150, 35);
	g2.setColor(Color.BLUE); g2.draw(rc1);

	// Rotate the Rubik's Cube by 45 degrees around its center.
	Shape rc2 = ShapeTransforms.rotatedCopyOf(rc1, Math.PI/4.0);
	rc2 = ShapeTransforms.scaledCopyOfLL(rc2, 1.5, 1.5);
	rc2 = ShapeTransforms.translatedCopyOf(rc2, 150, 150);
	g2.setColor(Color.GREEN);
	g2.draw(rc2);

	//Rotate the Rubik's Cube by 90 degrees around its center.
	Shape rc3 = ShapeTransforms.rotatedCopyOf(rc1, Math.PI/2.0);
	rc3 = ShapeTransforms.scaledCopyOfLL(rc3, .5, .5);
	rc3 = ShapeTransforms.translatedCopyOf(rc3, 50, 175);
	
	// We'll draw this with a thicker stroke
	Stroke thick = new BasicStroke (4.0f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL);       

	Stroke orig=g2.getStroke();
	g2.setStroke(thick);
	g2.setColor(new Color(0x0D0200)); 
	g2.draw(rc3);

	//Rotate the Rubik's Cube by -45 degree around its center.
	Shape rc4 = ShapeTransforms.rotatedCopyOf(rc1, -Math.PI/4.0);
	rc4 = ShapeTransforms.scaledCopyOfLL(rc4, 1.3, 1.3);
	rc4 = ShapeTransforms.translatedCopyOf(rc4, -200, 200);

	//Draw this with a thicker stroke
	Stroke orig1 = g2.getStroke();
	g2.setStroke(thick);
	g2.setColor(new Color(0xABCDEF));
	g2.draw(rc4);
	
	
    }       
}
