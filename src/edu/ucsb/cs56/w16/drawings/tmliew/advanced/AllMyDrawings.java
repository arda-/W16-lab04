package edu.ucsb.cs56.w16.drawings.tmliew.advanced;

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
 * @author Phill Conrad, Tim Liew 
 * @version for UCSB CS56, W16 
 */

public class AllMyDrawings
{
    /** Draw a picture with a few different glasses 
     */
    
    public static void drawPicture1(Graphics2D g2) {
	
	Glasses gl1 = new Glasses(100,250,50,75);
	g2.setColor(Color.CYAN); g2.draw(gl1);
	
	// Make black glasses that's half the size, 
	// and moved over 150 pixels in x direction
	
	Shape gl2 = ShapeTransforms.scaledCopyOfLL(gl1,0.5,0.5);
	gl2 = ShapeTransforms.translatedCopyOf(gl2,150,0);
	g2.setColor(Color.BLACK); g2.draw(gl2);
	
	// Here's glasses that's 4x as big (2x the original)
	// and moved over 150 more pixels to right.
	gl2 = ShapeTransforms.scaledCopyOfLL(gl2,4,4);
	gl2 = ShapeTransforms.translatedCopyOf(gl2,150,0);
	
	// We'll draw this with a thicker stroke
	Stroke thick = new BasicStroke (2.0f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL);       
	
	// for hex colors, see (e.g.) http://en.wikipedia.org/wiki/List_of_colors
	// #002FA7 is "International Klein Blue" according to Wikipedia
	// In HTML we use #, but in Java (and C/C++) its 0x
	
	Stroke orig=g2.getStroke();
	g2.setStroke(thick);
	g2.setColor(new Color(0x002FA7)); 
	g2.draw(gl2); 
	
	// Draw two Sunglasses
	
	Sunglasses sg1 = new Sunglasses(50,350,40,75);
	Sunglasses sg2 = new Sunglasses(200,350,200,100);
	
	g2.draw(sg1);
	g2.setColor(new Color(0x8F00FF)); g2.draw(sg2);
	
	// @@@ FINALLY, SIGN AND LABEL YOUR DRAWING
	
	g2.setStroke(orig);
	g2.setColor(Color.BLACK); 
	g2.drawString("Some glasses and sunglasses by Tim Liew", 20,20);
    }
    
    
    /** Draw a picture with different colors and sizes of glasses and sunglasses
     */
    public static void drawPicture2(Graphics2D g2) {
	
	// Draw some sunglasses and glasses in different colors
	
	Sunglasses large = new Sunglasses(180,200,225,150);
	Glasses  small = new Glasses(20,50,40,30);
	Glasses long1 = new Glasses(20,150,65,30);
	Glasses tall = new Glasses(20,250,40,75);
	
	g2.setColor(Color.RED);     
	g2.draw(large);
	g2.setColor(Color.GREEN);   
	g2.draw(small);
	g2.setColor(Color.BLUE);    
	g2.draw(tall);
	g2.setColor(Color.MAGENTA); g2.draw(long1);
	
	Glasses gl1 = new Glasses(100,250,50,75);
        g2.setColor(Color.CYAN); 
	g2.draw(gl1);

        // Make black glasses that's half the size,                                                        
        // and moved over 150 pixels in x direction                                                        

        Shape gl2 = ShapeTransforms.scaledCopyOfLL(gl1,0.5,0.5);
        gl2 = ShapeTransforms.translatedCopyOf(gl2,150,0);
        g2.setColor(Color.BLACK); g2.draw(gl2);

        // Here's glasses that's 4x as big (2x the original)                                               
        // and moved over 150 more pixels to right.                                                        
        gl2 = ShapeTransforms.scaledCopyOfLL(gl2,4,4);
        gl2 = ShapeTransforms.translatedCopyOf(gl2,150,0);

        // We'll draw this with a thicker stroke                                                           
        Stroke thick = new BasicStroke (4.0f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL);

        // for hex colors, see (e.g.) http://en.wikipedia.org/wiki/List_of_colors                          
        // In HTML we use #, but in Java (and C/C++) its 0x                                                

        Stroke orig=g2.getStroke();
        g2.setStroke(thick);
        g2.setColor(new Color(0x002AB8));
        g2.draw(gl2);

        // Draw two sunglasses

        Sunglasses sg1 = new Sunglasses(50,350,40,75);
        Sunglasses sg2 = new Sunglasses(200,350,200,100);

        g2.draw(sg1);
        g2.setColor(new Color(0x8F00FF)); g2.draw(sg2);
	
	// @@@ FINALLY, SIGN AND LABEL YOUR DRAWING
	
	g2.setStroke(orig);
	g2.setColor(Color.BLACK); 
	g2.drawString("A bunch of Sunglasses and glasses by Tim Liew", 20,20);
    }
    
    /** Draw a different picture with Sunglasses
     */
    
    public static void drawPicture3(Graphics2D g2) {
	
	// label the drawing
	
	g2.drawString("A bunch of Sunglasses by Tim Liew", 20,20);
	
	
	// Draw some Sunglasses.
	
	Sunglasses large = new Sunglasses(220,200,225,150);
	Sunglasses small = new Sunglasses(20,50,40,30);
	
	g2.setColor(Color.RED);     
	g2.draw(large);
	g2.setColor(Color.GREEN);   
	g2.draw(small);
	
    }       
}
