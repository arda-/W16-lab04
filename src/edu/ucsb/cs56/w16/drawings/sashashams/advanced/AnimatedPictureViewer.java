package edu.ucsb.cs56.w16.drawings.sashashams.advanced;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.Shape;
import edu.ucsb.cs56.w16.drawings.utilities.ShapeTransforms;

/**
 * A main class to view an animation
 *
 * @author Sasha Shams
 * @version for CS56, W16
 */

public class AnimatedPictureViewer {

    private DrawPanel panel = new DrawPanel();
    
    // private CaterpillarWithFeet MrBugs = new CaterpillarWithFeet(50,50, 250,100);
    
    Thread anim;   
    
    private int x = 100;
    private int y = 100;
    private int xMouse;
    private int yMouse;
    private int dx = 5;
    private int dy = 5;
    private int shouldFlip = 0;
    Color color = Color.RED;
    public static void main (String[] args) {
      new AnimatedPictureViewer().go();
    }

    public void go() {
      JFrame frame = new JFrame();
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

      frame.getContentPane().add(panel);
      frame.setSize(680,480);
      frame.setVisible(true);
      //  Color color = Color.RED;
      frame.getContentPane().addMouseListener(new MouseAdapter() {
        public void mouseEntered(MouseEvent e){
        System.out.println("mouse entered");
          anim = new Animation();
          anim.start();
        }
        public void mouseClicked(MouseEvent e){
	    //Generate random color on mouseclick
	    int r = (int)(Math.random()*256);
	    int g = (int)(Math.random()*256);
	    int b = (int)(Math.random()*256);
	    Color randomColor = new Color(r,g,b);
	    //Flip bug upside down
	    if(shouldFlip == 0){
		shouldFlip = 1;
	    }else{
		shouldFlip = 0;
	    }
	    System.out.println("Mouse clicked");
	    color = randomColor;
	    panel.repaint();
	}

        public void mouseExited(MouseEvent e){        
          System.out.println("Mouse has entered frame");
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
	  Stroke thick = new BasicStroke(3.0f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL);
	  g2.setStroke(thick);
	  // Draw the bug
          g2.setColor(color);
          CaterpillarWithFeet mrBug = new CaterpillarWithFeet(x,y,250,100);
	  if(shouldFlip == 1){
	      Shape mrBug1 = ShapeTransforms.rotatedCopyOf(mrBug,Math.PI);
	      g2.draw(mrBug1);
	  }else{
          g2.draw(mrBug);
	  }
       }
    }
    
    class Animation extends Thread {
      public void run() {
        try {
          while (true) {
	    // Bounce off the walls

            if (y >= 340) { dy = -5; }
            if (y <= 0) { dy = 5; }
            if(x >= 430){ dx = -5; }
	    if(x <= 0){	dx = 5;}
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
