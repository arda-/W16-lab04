package edu.ucsb.cs56.w16.drawings.drewluo.advanced;

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
 * @author Phill Conrad
 * @author Andrew Luo 
 * @version for UCSB CS56, W16 
 */

public class AllMyDrawings
{
    /** Draw a picture with a few shields 
     */
    
    public static void drawPicture1(Graphics2D g2) {
	
	Shield s1 = new Shield(100,100,50,75);
	g2.setColor(Color.BLUE); g2.draw(s1);
	
	// Make a red shield that's 3/4 the size, 
	// and moved over 200 pixels in x direction
	
	Shape s2 = ShapeTransforms.scaledCopyOfLL(s1,0.75,0.75);
	s2 = ShapeTransforms.translatedCopyOf(s2,200,0);
	g2.setColor(Color.RED); g2.draw(s2);
	
	// Here's a black shield that's 4x as big (2x the original)
	// and moved over 150  pixels upward.
	Shape s3 = ShapeTransforms.scaledCopyOfLL(s2,4,4);
	s3 = ShapeTransforms.translatedCopyOf(s3,0,150);
	g2.setColor(Color.BLACK); g2.draw(s3);
	
	// We'll draw this with a thicker stroke
	Stroke thick = new BasicStroke (4.0f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL);       
	
	// for hex colors, see (e.g.) http://en.wikipedia.org/wiki/List_of_colors
	// #002FA7 is "International Klein Blue" according to Wikipedia
	// In HTML we use #, but in Java (and C/C++) its 0x
	
	Stroke orig=g2.getStroke();
	g2.setStroke(thick);
	g2.setColor(new Color(0x002FA7)); 
	g2.draw(s2); 
	
	// Draw two shields with emblems
	
	ShieldWithEmblem se1 = new ShieldWithEmblem(50,350,40,75);
	ShieldWithEmblem se2 = new ShieldWithEmblem(200,350,200,100);
	
	g2.draw(se1);
	g2.setColor(new Color(0x8F00FF)); g2.draw(se2);
	
	// @@@ FINALLY, SIGN AND LABEL YOUR DRAWING
	
	g2.setStroke(orig);
	g2.setColor(Color.BLACK); 
	g2.drawString("Choose a shield by Andrew Luo", 20,20);
    }
    
    
    /** Draw a picture with a few shields and
     */
    public static void drawPicture2(Graphics2D g2) {
	
	// Draw some coffee cups.
	
	Shield large = new Shield(100,50,225,150);
	Shield small = new Shield(20,50,40,30);
	Shield tallSkinny = new Shield(20,150,20,40);
	Shield shortFat = new Shield(20,250,40,20);
	
	g2.setColor(Color.RED);     g2.draw(large);
	g2.setColor(Color.GREEN);   g2.draw(small);
	g2.setColor(Color.BLUE);    g2.draw(tallSkinny);
	g2.setColor(Color.MAGENTA); g2.draw(shortFat);
	
	ShieldWithEmblem s1 = new ShieldWithEmblem(100,250,50,75);
	g2.setColor(Color.CYAN); g2.draw(s1);
	
	// Make a black shield that's half the size, 
	// and moved over 150 pixels in x direction
	Shape s2 = ShapeTransforms.scaledCopyOfLL(s1,0.5,0.5);
	s2 = ShapeTransforms.translatedCopyOf(s2,150,0);
	g2.setColor(Color.BLACK); g2.draw(s2);
	
	// Here's a shield that's 4x as big (2x the original)
	// and moved over 150 more pixels to right.
	s2 = ShapeTransforms.scaledCopyOfLL(s2,4,4);
	s2 = ShapeTransforms.translatedCopyOf(s2,150,0);
	
	// We'll draw this with a thicker stroke
	Stroke thick = new BasicStroke (4.0f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL);       
	
	// for hex colors, see (e.g.) http://en.wikipedia.org/wiki/List_of_colors
	// #002FA7 is "International Klein Blue" according to Wikipedia
	// In HTML we use #, but in Java (and C/C++) its 0x
	
	Stroke orig=g2.getStroke();
	g2.setStroke(thick);
	g2.setColor(new Color(0x002FA7)); 
	g2.draw(s2); 
	
	// Draw two shields with emblems
	ShieldWithEmblem se1 = new ShieldWithEmblem(50,350,40,75);
	ShieldWithEmblem se2 = new ShieldWithEmblem(200,350,300,100);
	
	g2.draw(se1);
	g2.setColor(new Color(0x8F00FF)); 
	
	// Rotate the second house 45 degrees around its center.
	Shape se3 = ShapeTransforms.rotatedCopyOf(se2, Math.PI/4.0);
	
	g2.draw(se3);
	
	// @@@ FINALLY, SIGN AND LABEL YOUR DRAWING
	
	g2.setStroke(orig);
	g2.setColor(Color.BLACK); 
	g2.drawString("Wow, more shields by Andrew Luo", 20,20);
    }
    
    /** Draw a different picture with a few houses and coffee cups
     */
    
    public static void drawPicture3(Graphics2D g2) {
	
	// label the drawing
	
	g2.drawString("2 shieldz by Andrew Luo", 20,20);
	
	
	// Draw some coffee cups.
	
	Shield large = new Shield(100,50,225,150);
	Shield small = new Shield(20,50,40,30);
	
	g2.setColor(Color.BLACK);     g2.draw(large);
	g2.setColor(Color.RED);   g2.draw(small);
	
    }       
}
