package edu.ucsb.cs56.w16.drawings.sashashams.advanced;

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
 * @author Sasha Shams 
 * @version for UCSB CS56, W16 
 */

public class AllMyDrawings
{
    /** Draw a picture with a few Caterpillars, some caterpillars have feet.
     */
    
    public static void drawPicture1(Graphics2D g2) {
   	//Draw Bug 1
	//Create a bug at x 100, y 250 with width 250 and height 100
   	//Make bug red. 
	Caterpillar bug1 = new Caterpillar(50,100,250,100);
	g2.setColor(Color.RED);
	g2.draw(bug1);
	//Draw Bug 2
	//Create another caterpillar that is half the size and 100 pixels below the original caterpillar.
	//Make bug BlUE
	Shape bug2 = ShapeTransforms.scaledCopyOfLL(bug1, .50,.50);
	bug2 = ShapeTransforms.translatedCopyOf(bug2,0, 50);
	g2.setColor(Color.BLUE);
	g2.draw(bug2);
	
	//Draw Bug 3
	//Make bug a random color
	int red = (int)(Math.random()*256);
	int green = (int)(Math.random()*256);
	int blue = (int)(Math.random()*256);
	Color randomColor = new Color(red,green,blue);
	g2.setColor(randomColor);
	//Make a bug that has a larger 3X larger than the original caterpillar
	bug2 = ShapeTransforms.scaledCopyOfLL(bug2,3,3);
	//Draw the bug 100 pixels below the last bug.
	bug2 = ShapeTransforms.translatedCopyOf(bug2,0,100);
	//Draw this bug with a larger stroke
	Stroke thick = new BasicStroke(3.0f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL);
	Stroke originalStroke = g2.getStroke();
	g2.setStroke(thick);
	g2.draw(bug2);

	//Draw bug 4
	//Draw Bug with Feet
	//Put bug at x = 50, y = 350
	//make bug with feet of size width = 250, height = 100; (same as first bug)
	CaterpillarWithFeet bug4 = new CaterpillarWithFeet(50,350,250,100);
	//make bug black
	g2.setColor(Color.BLACK);
	//set original stroke size
	g2.setStroke(originalStroke);
	g2.draw(bug4);

	//Draw bug 5
	//Make bug5 twice the size of bug 4
	Shape bug5 = ShapeTransforms.scaledCopyOf(bug4,2,2);
	//Draw a bug with feet that is 300 pixels to the right of bug 4
	bug5 = ShapeTransforms.translatedCopyOf(bug5,300,0);
	//Make bug green
	g2.setColor(Color.GREEN);
	g2.draw(bug5);
	
	//signing drawing
	g2.setStroke(originalStroke);
	g2.setColor(Color.BLACK); 
	g2.drawString("A few drawings of a lonely Caterpillar by Sasha Shams, some Caterpillar's have had their legs amputated", 20,20);
    }
    
    
    /** Draw a picture of different sized Caterpillars, some Caterpillar's will have Feet, some Caterpillar's are oriented differently.
     */
    public static void drawPicture2(Graphics2D g2) {
	
	
    //Draw more bugs of different aspect ratios without feet
    Caterpillar bigBug = new Caterpillar(50,100,250,100);
    Caterpillar tinyBug = new Caterpillar(50,200,83.33,33.33);
    Caterpillar tallBug = new Caterpillar(300,100, 150, 250);
    Caterpillar fatBug = new Caterpillar(300,300,500,150);
    //Make bigBug red and draw;
    g2.setColor(Color.RED); g2.draw(bigBug);
    //Make tinyBug blue and draw;
    g2.setColor(Color.BLUE); g2.draw(tinyBug);
    //Make tall bug Black and draw;
    g2.setColor(Color.BLACK); g2.draw(tallBug);
    //make fat bug green and draw;
    g2.setColor(Color.GREEN); g2.draw(fatBug);
	
	//Draw bug 5
	//Make a bug with feet upside down about it's origin.
	CaterpillarWithFeet rightSideUpBug = new CaterpillarWithFeet(50,500, 250, 150);
	Shape upsideDownBug = ShapeTransforms.rotatedCopyOf(rightSideUpBug,Math.PI);
	//make bug black and draw it
	g2.setColor(Color.BLACK); g2.draw(upsideDownBug);
	//Draw bug 6
	//This bug does not it's orientation and is rotated randomly, this bug is 200pixels below and 200 pixels to the right of bug 5
	double randomOrient = Math.random()*360;
	Shape dizzyBug = ShapeTransforms.translatedCopyOf(rightSideUpBug,200,200);
	dizzyBug = ShapeTransforms.rotatedCopyOf(dizzyBug,randomOrient);
	//make dizzy bug blue and draw
	g2.setColor(Color.BLUE);g2.draw(dizzyBug);

	g2.setColor(Color.BLACK); 
	g2.drawString("A bunch of Bugs, some bugs have feet, some bugs are different sizes, some bugs are disoriented", 20,20);
    }
    
    /** Draw a picture of the story of Mr.Bug (it is a sad story)
     */
    	
    public static void drawPicture3(Graphics2D g2) {
	
	// label the drawing
	
	g2.drawString("This is the life of Mr.Bug and Mrs.Bug: They have met back in '89, and now have a wonderful family of 4 baby bugs",20,20);
	g2.drawString("Unfortunately after the children came, Mr.Bug lost his legs in a freak pesticide accident", 20,40);
	g2.drawString("He later succumbed to his wounds and passed away", 20,60);


	//Draw mrBug and mrsBug, they don't know eachother yet but they are about to meet.
	CaterpillarWithFeet mrBug = new CaterpillarWithFeet(100,100,250,150);
	Shape mrsBug = ShapeTransforms.horizontallyFlippedCopyOf(mrBug);
	mrsBug= ShapeTransforms.translatedCopyOf(mrsBug,750,0);
	g2.setColor(Color.BLUE);g2.draw(mrBug);
	g2.setColor(Color.MAGENTA);g2.draw(mrsBug);
	//Draw mrBbug and mrsBug
	//The First Kiss
	Shape mrBug2 = ShapeTransforms.translatedCopyOf(mrBug,125,200);
	g2.setColor(Color.BLUE);g2.draw(mrBug2);
	mrsBug = ShapeTransforms.translatedCopyOf(mrsBug, -125, 200);
	g2.setColor(Color.MAGENTA);g2.draw(mrsBug);
	//Love at first sight, mrBug and mrsBug had 4 baby children
	//Each child is at 1/4 scale of their parents
	Shape child1 = ShapeTransforms.scaledCopyOfLL(mrBug2,.25,.25);
	child1 = ShapeTransforms.translatedCopyOf(child1,0,50);
	Shape child2 = ShapeTransforms.translatedCopyOf(child1,100,0);
	Shape child3 = ShapeTransforms.scaledCopyOfLL(mrsBug,.25,.25);
	child3 = ShapeTransforms.translatedCopyOf(child3,175,50);
	Shape child4 = ShapeTransforms.translatedCopyOf(child3,-100,0);
//Draw the boy children (Sorry that the gender colors are not "Politically Correct")
	g2.setColor(Color.BLUE);g2.draw(child1);g2.draw(child2);
	g2.setColor(Color.MAGENTA);g2.draw(child3);g2.draw(child4);
	// Draw mrBug without legs( use the original Caterpillar class)
	Caterpillar mrBugNoLegs = new Caterpillar(250,600,250,150);
	g2.setColor(Color.BLUE);g2.draw(mrBugNoLegs);
	//Draw mrBug after he has passed away (upside down);
	Shape mrBugsNoLegs2 = ShapeTransforms.translatedCopyOf(mrBugNoLegs,0,350);
	mrBugsNoLegs2 = ShapeTransforms.verticallyFlippedCopyOf(mrBugsNoLegs2);
	g2.draw(mrBugsNoLegs2);
	g2.setColor(Color.BLACK);
	g2.drawString("RIP Mr.Bug", 550, 850);
    }       
}
