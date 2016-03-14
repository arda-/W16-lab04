package edu.ucsb.cs56.w16.drawings.rockysikem.advanced;
import java.awt.geom.GeneralPath;
import java.awt.geom.Ellipse2D;
import java.awt.Shape; 
import java.awt.geom.Rectangle2D;

/**
   A Dinner Table, with plates
      
   @author Ishjot Walia
   @version for CS56, W16, UCSB
   
*/
public class DinnerTableWithPlates extends DinnerTable implements Shape
{
    /**
     * Constructor for objects of class CoffeeCup
     */
    public DinnerTableWithPlates(double x, double y, double width, double height)
    {
	// construct the basic table shell
	super(x,y,width,height);
	
	// get the GeneralPath that we are going to append stuff to
	GeneralPath gp = this.get();
	
	// Make four plates, centered on the edges of the table.
	
	double plateHeight = 0.20 * height;
	double plateWidth = 0.20 * width;
	
	Ellipse2D.Double plate1 =
	    new Ellipse2D.Double(x, y - (height/2) - 0.5*plateHeight, plateWidth, plateHeight);
	Ellipse2D.Double plate2 =
	    new Ellipse2D.Double(x + (width/2) - plateWidth/2, y - height, plateWidth, plateHeight);
	Ellipse2D.Double plate3 =
	    new Ellipse2D.Double(x + width - plateWidth, y - (height/2) - 0.5*plateHeight, plateWidth, plateHeight);
	Ellipse2D.Double plate4 =
	    new Ellipse2D.Double(x + (width/2) - plateWidth/2, y - plateHeight, plateWidth, plateHeight);
	
	// add the plates to the house
	
        GeneralPath wholeTable = this.get();
        wholeTable.append(plate1, false);
        wholeTable.append(plate2, false);
        wholeTable.append(plate3, false); 
	wholeTable.append(plate4, false);
    }    
}
