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
          g2.setColor(Color.white);
          g2.fillRect(0,0,this.getWidth(), this.getHeight());

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
	    
          g2.draw(rc);
       }
    }
    
    class Animation extends Thread {
      public void run() {
        try {
          while (true) {
            // Bounce off the walls

            if (x >= 400) { dx = -1; }
            if (x <= 50) { dx = 1; }

	    if(y >= 400) { dy = -1;}
	    if(y <= 50) { dy = 1;}
	    
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
