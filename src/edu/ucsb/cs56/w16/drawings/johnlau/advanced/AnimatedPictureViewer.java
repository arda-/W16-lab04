package edu.ucsb.cs56.w16.drawings.johnlau.advanced;

import java.awt.Shape;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import edu.ucsb.cs56.w16.drawings.utilities.ShapeTransforms;

/**
 * A main class to view an animation
 *
 * John Lau's animation, based off of Andrewberl's example
 *
 * @author John Lau
 * @version for CS56, W16
 */


public class AnimatedPictureViewer {

    private DrawPanel panel = new DrawPanel();
    
    Thread anim;   
    private int rad = 200;
    private int x = 100;
    private int y = 100;
    private int width = 100;
    private int height = 200;
    private int speed = 1;
    private double rotate = 1;
    private double theta = 0;
    private int degreeRed = 0;
    private int degreeGreen = 0;
    private int degreeBlue = 0;

    public static void main (String[] args) {
      new AnimatedPictureViewer().go();
    }

    public void go() {
      JFrame frame = new JFrame();
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.getContentPane().add(panel);
      frame.setSize(640,480);
      frame.setTitle("John Lau's Spinning Rainbow Pizza");
      frame.setVisible(true);
      frame.getContentPane().addMouseListener(new MouseAdapter() {
        public void mouseEntered(MouseEvent e){
        System.out.println("Move");
          anim = new Animation();
          anim.start();
        }

        public void mouseExited(MouseEvent e){        
          System.out.println("Stop");
          // Kill the animation thread
          anim.interrupt();
          while (anim.isAlive()){}
          anim = null;         
          panel.repaint();        
        }
     
      public void mouseClicked(MouseEvent e){
	  // increase speed of spin, up to 6 levels
	  if(speed >=6){
	      speed = 0;
	  }
	  speed++;
	  System.out.print(speed);
	  System.out.println("x speed");
      }

     }); 
    } // go()

    class DrawPanel extends JPanel {
       public void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
         // Clear the panel first
          g2.setColor(Color.white);
          g2.fillRect(0,0,this.getWidth(), this.getHeight());
	  // Create Pizza
	  Color pizzaColor = new Color(degreeRed,degreeGreen,degreeBlue);
          g2.setColor(pizzaColor);
          PizzaWithToppings test = new PizzaWithToppings(x, y, width, height);
	  Shape a = ShapeTransforms.rotatedCopyOf(test,rotate);
	  g2.draw(a);
       }
    }
    
    class Animation extends Thread {
	public void run() {
	    try {
		while (true) {
		    // Randomize colors
		    degreeRed += 1;
		    if(degreeRed >= 256)
			degreeRed = 0;
		    degreeGreen += 3;
		    if(degreeGreen >= 256)
			degreeGreen = 0;
		    degreeBlue += 6;
		    if(degreeBlue >= 256)
			degreeBlue = 0;
		    // Make Pizza move in circle
		    theta += Math.toRadians(0.5*speed);
		    x = (int)(200 + 100*Math.sin(theta));
		    y = (int)(200 + 100*Math.cos(theta));
		    rad -= 1;
		    // Rotate Pizza itself
		    rotate += Math.toRadians(2*speed);
		    panel.repaint();
		    Thread.sleep(30);
		}
	    } catch(Exception ex) {
		if (ex instanceof InterruptedException) {
		    // Do nothing - expected on mouseExited
		} else {
		    ex.printStackTrace();
		    System.exit(1);
		}
	    }
	}
    }
    
}
