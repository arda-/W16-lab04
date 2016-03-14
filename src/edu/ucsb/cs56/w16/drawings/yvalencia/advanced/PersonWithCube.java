package edu.ucsb.cs56.w16.drawings.yvalencia.advanced;
import java.awt.geom.GeneralPath;  
import java.awt.Shape; 
import java.awt.geom.Rectangle2D;
import java.awt.geom.Line2D;

/**
   A Person
   
   @author Yessenia Valencia 
   @version for CS56, W16, UCSB
   
*/
public class PersonWithCube extends Person implements Shape
{
    public PersonWithCube(double x, double y, double height)
    {
	super(x,y,height);
	
	// get the GeneralPath that we are going to append stuff to
	GeneralPath gp = this.get();
	
	double sizeOfCube = (.33*height);
	double sizeOfSide = (.5 * sizeOfCube); 
	double cubeX = x + (.67*height); 
	double cubeY = y + (height *.67); 
	
	Rectangle2D.Double faceOfCube =
	    new Rectangle2D.Double(cubeX-sizeOfSide,cubeY-sizeOfCube, sizeOfCube, sizeOfCube);
	Line2D.Double line1 =
	    new Line2D.Double(cubeX + sizeOfCube-sizeOfSide, cubeY, cubeX+sizeOfCube, cubeY-sizeOfSide); ;
	Line2D.Double line2 =
	    new Line2D.Double(cubeX+sizeOfCube-sizeOfSide,cubeY-sizeOfCube, cubeX+sizeOfCube, cubeY-sizeOfCube-sizeOfSide);
	Line2D.Double line3 =
	    new Line2D.Double(cubeX-sizeOfSide, cubeY -sizeOfCube, cubeX , cubeY -sizeOfCube -sizeOfSide);
	Line2D.Double line4 =
	    new Line2D.Double (cubeX, cubeY-sizeOfCube-sizeOfSide, cubeX + sizeOfCube, cubeY-sizeOfCube-sizeOfSide);
	Line2D.Double line5 =
	    new Line2D.Double (cubeX + sizeOfCube, cubeY-sizeOfSide, cubeX + sizeOfCube, cubeY - sizeOfCube - sizeOfSide); 
	
	GeneralPath  wholePerson = this.get(); 
	wholePerson.append(faceOfCube, false);
        wholePerson.append(line1, false);
        wholePerson.append(line2, false);
	wholePerson.append(line3, false);
	wholePerson.append(line4, false);
	wholePerson.append(line5, false);
    }    
}
