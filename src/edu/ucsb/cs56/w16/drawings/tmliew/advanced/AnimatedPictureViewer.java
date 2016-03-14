package edu.ucsb.cs56.w16.drawings.tmliew.advanced;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * A main class to view an animation
 *
 * @author Tim Liew
 * @version for CS56, W16
 */


public class AnimatedPictureViewer {

    private DrawPanel panel = new DrawPanel();
    
    private Sunglasses sunglasses = new Sunglasses(100, 100, 100, 100);
    
    Thread anim;   
    
    private int x = panel.getWidth()/2;
    private int y = 0;
    
    private int x1 = 0;
    private int y1 = 0;

    private int x2 = 0;
    private int y2 = 0;

    private int dx = 1;
    private int dy = 14;

    private int swidth = 700;
    private int sheight = 700;
    private int resize = 1
	;
    public static void main (String[] args) {
      new AnimatedPictureViewer().go();
    }

    public void go() {
      JFrame frame = new JFrame();
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

      frame.getContentPane().add(panel);
      frame.setSize(640,480);
      frame.setVisible(true);
      x2 = panel.getWidth();
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

          // Draw the Sunglasses
          g2.setColor(Color.BLACK);
          Sunglasses s = new Sunglasses( x , y, swidth, sheight);
          Sunglasses s1 = new Sunglasses( x1 , y1, swidth, sheight);
          Sunglasses s2 = new Sunglasses( x2 , y2, swidth, sheight);
    
	  Stroke thicker = new BasicStroke (1.6f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL);

	  g2.setStroke(thicker);
	  g2.draw(s);
	  g2.setColor(Color.RED);
	  g2.draw(s1);
	  g2.setColor(Color.BLUE);
	  g2.draw(s2);
       }
    }
    
    class Animation extends Thread {
	public void run() {
	  try {
	      double r = 50;
	      int f =0;
          while (true) {
	      
	      if(y <= panel.getHeight()/2)
		  {
		      if(dy > 1)
			  dy--;
		      x = panel.getWidth()/2;
		      y += dy;
		    
		  }
	      if(x1 <= panel.getWidth()/2)
		  {
		      y1 = panel.getHeight()/2;
		      x1 += 2;
		    
		      
		  }
	      if(x2 >= panel.getWidth()/2)
		  {
		      y2 = panel.getHeight()/2;
		      x2 -= 2;
		    		      
		  }
	      if( resize == 1 && sheight >= 100 && swidth >= 100)
		  {
		      swidth -= 5;
		      sheight -= 5;
		      if ( sheight <= 100 && swidth <= 100)
			  {
			      resize =0;
			  }
		  }
	      if( resize == 0 && sheight <= 600 && swidth <= 600)
		  {
		      swidth += 5;
		      sheight += 5;
		      if (sheight >= 600 && swidth >= 600)
			  {
			      resize = 1;
			  }
		  }
		 
	      /*if(y == panel.getHeight()/2)
		  {
		      if(f < 360)
			  {
			      x = (int)(Math.sin(Math.toRadians((double)f)) * r);
			      y = (int)(Math.cos(Math.toRadians((double)f)) * r);
			      f++; 
			  }
			  }*/

	      panel.repaint();
	      Thread.sleep(50);
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
