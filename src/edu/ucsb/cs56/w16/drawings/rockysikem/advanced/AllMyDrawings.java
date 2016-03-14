package edu.ucsb.cs56.w16.drawings.rockysikem.advanced;

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
 * @author Ishjot Walia 
 * @version for UCSB CS56, W16 
 */

public class AllMyDrawings
{
    /** Draw a picture with a few tables 
     */
    
    public static void drawPicture1(Graphics2D g2) {
	
	DinnerTable h1 = new DinnerTable(100,250,50,75);
	g2.setColor(Color.RED); g2.draw(h1);
	
	Shape h2 = ShapeTransforms.scaledCopyOfLL(h1,0.5,0.5);
	h2 = ShapeTransforms.translatedCopyOf(h2,150,0);
	g2.setColor(Color.BLUE); g2.draw(h2);
	
	h2 = ShapeTransforms.scaledCopyOfLL(h2,4,4);
	h2 = ShapeTransforms.translatedCopyOf(h2,150,0);
	
	Stroke thick = new BasicStroke (4.0f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL);       
	
	Stroke orig=g2.getStroke();
	g2.setStroke(thick);
	g2.setColor(new Color(0x002FA7)); 
	g2.draw(h2); 
	
	
	DinnerTableWithPlates hw1 = new DinnerTableWithPlates(50,350,40,75);
	DinnerTableWithPlates hw2 = new DinnerTableWithPlates(200,350,200,100);
	
	g2.draw(hw1);
	g2.setColor(new Color(0x8F00FF)); g2.draw(hw2);
	
	g2.setStroke(orig);
	g2.setColor(Color.BLACK); 
	g2.drawString("A few dinner tables by Ishjot Walia", 20,20);
    }
    
    
    /** Draw a picture with a more tables
     */
    public static void drawPicture2(Graphics2D g2) {
	
	// Draw some tables, with and without plates.
	
	DinnerTable large = new DinnerTable(375,150,250,150);
	DinnerTable smallCC = new DinnerTable(20,100,40,40);
	DinnerTable tallSkinny = new DinnerTable(20,200,20,100);
	DinnerTable shortFat = new DinnerTable(20,90,70,20);
	
	g2.setColor(Color.YELLOW);     g2.draw(large);
	g2.setColor(Color.CYAN);   g2.draw(smallCC);
	g2.setColor(Color.GREEN);    g2.draw(tallSkinny);
	g2.setColor(Color.MAGENTA); g2.draw(shortFat);
	
	DinnerTableWithPlates h1 = new DinnerTableWithPlates(100,250,50,75);
	g2.setColor(Color.RED); g2.draw(h1);
	
	Shape h2 = ShapeTransforms.scaledCopyOfLL(h1,0.5,0.5);
	h2 = ShapeTransforms.translatedCopyOf(h2,100,0);
	g2.setColor(Color.YELLOW); g2.draw(h2);
	
	h2 = ShapeTransforms.scaledCopyOfLL(h1,2,2);
	h2 = ShapeTransforms.translatedCopyOf(h1,200,0);
	
	Stroke thick = new BasicStroke (4.0f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL);       
	
	
	Stroke orig=g2.getStroke();
	g2.setStroke(thick);
	g2.setColor(new Color(0x0048BA)); 
	g2.draw(h2); 
	
	
	DinnerTableWithPlates dt1 = new DinnerTableWithPlates(50,350,40,75);
	DinnerTableWithPlates dt2 = new DinnerTableWithPlates(200,350,200,100);
	
	g2.draw(dt1);
	g2.setColor(new Color(0x8F00FF)); 
	
	Shape dt3 = ShapeTransforms.rotatedCopyOf(dt2, Math.PI/4.0);
	
	g2.draw(dt3);
	
	g2.setStroke(orig);
	g2.setColor(Color.RED);
	g2.drawString("Dinner tables with and without plates, by Ishjot Walia", 20,20);
    }
    
    /** Drawing some more DinnerTables
     */
    
    public static void drawPicture3(Graphics2D g2) {
	
	g2.drawString("Two DinnerTableWithPlates, side by side", 20,20);
	
	
	// Draw some coffee cups.
	
	DinnerTableWithPlates big = new DinnerTableWithPlates(50,300,225,150);
	DinnerTableWithPlates small = new DinnerTableWithPlates(300,300,40,30);
	
	g2.setColor(Color.YELLOW);     g2.draw(big);
	g2.setColor(Color.CYAN);   g2.draw(small);
	
    }       
}
