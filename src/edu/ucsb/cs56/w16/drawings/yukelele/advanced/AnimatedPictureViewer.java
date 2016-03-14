package edu.ucsb.cs56.w16.drawings.yukelele.advanced;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import edu.ucsb.cs56.w16.drawings.utilities.ShapeTransforms;
import edu.ucsb.cs56.w16.drawings.utilities.GeneralPathWrapper;

/**
 * A main class to view an animation of a Rubik's Cube
 *
 * @author Yuki Mano
 * @version for CS56, W16
 */


public class AnimatedPictureViewer {

    private DrawPanel panel = new DrawPanel();
    
    private RubiksCube rubiksCube = new RubiksCube(200, 300, 25);
    private RubiksCube rubiksCube1 = new RubiksCube(480, 180, 25);
    
    Thread anim;   
    
    private int x = 100;
    private int y = 100;
    
    private int dx = 5;
    private int dy = 5;

    public static void main (String[] args) {
      new AnimatedPictureViewer().go();
    }

    public void go() {
      JFrame frame = new JFrame();
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

      frame.getContentPane().add(panel);
      frame.setSize(640,480);
      frame.setVisible(true);
      
      frame.getContentPane().addMouseListener(new MouseAdapter() {
        public void mouseEntered(MouseEvent e){
        System.out.println("mouse entered");
          anim = new Animation();
          anim.start();
        }

        public void mouseExited(MouseEvent e){        
          System.out.println("Mouse exited");
          // Kill the animation thread
          anim.interrupt();
          while (anim.isAlive()){}
          anim = null;         
          panel.repaint();        
        }
      });
      
    } // go()

    class DrawPanel extends JPanel {
       public void paintComponent(Graphics g) {

        Graphics2D g2 = (Graphics2D) g;

         // Clear the panel first

	int r1 = (int) (Math.random()*x*y %256);
	int g1 = (int) (Math.random()*x*y %256);
	int b1 = (int) (Math.random()*x*y %256);
	Color randColor = new Color (r1, g1, b1);
	if(r1==0 && g1==0 && b1==0)
	    randColor = new Color (255,255,255);
	g2.setColor(randColor);
	g2.fillRect(0,0,this.getWidth()/2, this.getHeight()/2);
	g2.fillRect(this.getWidth()/2,this.getHeight()/2,
		    this.getWidth(),this.getHeight());

	int red2 = (int) (Math.random()*x*y %256);
	int green2 = (int) (Math.random()*x*y %256);
	int blue2 = (int) (Math.random()*x*y %256);
	Color randColor1 = new Color (red2,green2,blue2);
	if(red2==0 && green2==0 && blue2==0)
	    randColor1 = new Color (255,255,255);
	g2.setColor(randColor1);
	g2.fillRect(this.getWidth()/2, 0, this.getWidth(), this.getHeight()/2);
	g2.fillRect(0,this.getHeight()/2,this.getWidth()/2,this.getHeight());

	//signature on my animation
	g2.setColor(Color.BLACK);
	g2.drawString("An animation of a Rubik's Cube by Yuki Mano", 15 ,25);

          // Draw the Rubik's Cube
	  //         in a random color;
	  int red = (int) (Math.random()*x*y %256);
	  int green = (int) (Math.random()*x*y %256);
	  int blue = (int) (Math.random()*x*y %256);
	  Color randomColor = new Color (red, green, blue);
	  if(red==255 && green==255 && blue==255)
	      randomColor = new Color (0,0,0);
			  
	  g2.setColor(randomColor);
          RubiksCube rc = new RubiksCube(x, y, (25*x %26) + 1);
	  RubiksCube rc1 = new RubiksCube(680-x, 480-y, (25*x %26) +1);

	    
          g2.draw(rc);
	  g2.draw(rc1);
       }
    }
    
    class Animation extends Thread {
      public void run() {
        try {
          while (true) {
            // Bounce off the walls

            if (x >= 640) { dx = -5; }
            if (x <= 0) { dx = 5; }

	    if(y >= 480) { dy = -5;}
	    if(y <= 0) { dy = 5;}
	    
            x += dx;
	    y += dy;
            panel.repaint();
            Thread.sleep(20);
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
