package edu.ucsb.cs56.w16.drawings.drewluo.advanced;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * A main class to view an animation
 *
 * @author Andrew Luo
 * @version for CS56, W16
 */


public class AnimatedPictureViewer {

    private DrawPanel panel = new DrawPanel();
    
    Thread anim;   
    
    private int x = 100;
    private int y = 100;
    private int h = 100;
    private int w = 100;
    private float strokeSize = 1f;
    
    private int dx = 0;
    private int dy = 5;
    private int dh = 0;
    private int dw = 0;
    private float ds = 0f;
    
    public static void main (String[] args) {
      new AnimatedPictureViewer().go();
    }

    public void go() {
      JFrame frame = new JFrame();

      frame.getContentPane().add(panel);
      frame.setSize(640,480);
      frame.setTitle("Andrew Luo's Animated Drawing");
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setVisible(true);
      
      frame.getContentPane().addMouseListener(new MouseAdapter() {
        public void mouseEntered(MouseEvent e){
        System.out.println("mouse entered");
          anim = new Animate();
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
      
    }

    class DrawPanel extends JPanel {
	public void paintComponent(Graphics g){

	   Graphics2D g2 = (Graphics2D) g;
	   
	   // Clear the panel first
	   g2.setColor(Color.white);
	   g2.fillRect(0,0,this.getWidth(), this.getHeight());

	   //Title of animation
	   g2.setColor(Color.BLACK);
	   g2.drawString("CRAZY SHIELD by Andrew Luo", 20,20);
	   
	   //Make random colors each time
	   int red = (int)(Math.random()*255);
	   int green = (int)(Math.random()*255);
	   int blue = (int)(Math.random()*255);
	   Color color = new Color(red, green, blue);
	   g2.setColor(color);

	   //Change the stroke size over time
	   g2.setStroke(new BasicStroke(strokeSize));
	   
	   //Draw the shield
	   ShieldWithEmblem shield = new ShieldWithEmblem(x, y, h, w);
	   g2.draw(shield);
       }
    }
    
    class Animate extends Thread {

	public void run() {
	    try {
		while (true) {

		    // Move in a square
		    //Going down on left side
		    if (y >= 200 && x <=200){
			dx = 5;
			dy = 0;
			dh = 5;
			dw = 5;
			ds = 0.5f;
		    }

		    //Going right along bottom
		    if (y >= 200 && x>= 200){
			dy = -5;
			dx = 0;
		    }

		    //Going up right side
		    if(y <=100 && x>=200){
			dx = -5;
			dy = 0;
			dh = -5;
			dw = -5;
			ds = -0.5f;
		    }

		    //Going left along top
		    if(y<=100 && x<=100){
			dx = 0;
			dy = 5;
		    }
            
		    x += dx;
		    y += dy;
		    h += dh;
		    w += dw;
		    strokeSize += ds;
		    panel.repaint();
		    Thread.sleep(25);
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
