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
    
    private ShieldWithEmblem shield = new ShieldWithEmblem(100, 100, 100, 100);
    
    Thread anim;   
    
    private int x = 100;
    private int y = 100;
    
    private int dx = 0;
    private int dy = 5;
    
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

	   // Draw the Shield
	   g2.setColor(Color.BLUE);
	   ShieldWithEmblem shield2 = new ShieldWithEmblem(x, y, 100, 100);
	   g2.draw(shield2);
       }
    }
    
    class Animate extends Thread {

	public void run() {
	    try {
		while (true) {
		    // Move in a square

		    if (y >= 200 && x <=200){
			dx = 5;
			dy = 0;
		    }
		    if (y >= 200 && x>= 200){
			dy = -5;
			dx = 0;
		    }
		    if(y <=100 && x>=200){
			dx = -5;
			dy = 0;
		    }
		    if(y<=100 && x<=100){
			dx = 0;
			dy = 5;
		    }
            
		    x += dx;
		    y += dy;
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
