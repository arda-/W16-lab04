package edu.ucsb.cs56.w16.drawings.josue.advanced;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**                                                                                      * A main class to view an animation                                                     *                                                                                                                                                                            
 * @author Josue Montenegro                                                             
 * @version for CS56, W14                                                               
 */


public class AnimatedPictureViewer {

    private DrawPanel panel = new DrawPanel();

    Thread anim;

    private int x = 100;
    private int y = 150;

    private int dx = 5;
    private int dy = 5;
    
    public static void main (String[] args) {
	new AnimatedPictureViewer().go();
    }

    public void go() {
	JFrame frame = new JFrame();
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	frame.getContentPane().add(panel);
	frame.setSize(640,640);
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
	    
	    int red = (int) (Math.random() *255);
	    int green = (int) (Math.random() *255);
	    int blue = (int) (Math.random()*255);
	    
	    Color randomColor1 = new Color (red,green,blue);
	    
	    // Clear the panel first
	    g2.setColor(randomColor1);
	    g2.fillRect(0,0,this.getWidth(), this.getHeight());
	    
	    // Draw the PineTree
	    int red1 = (int) (Math.random() *255);
	    int green1 = (int) (Math.random() *255);
	    int blue1 = (int) (Math.random()*255);
	    
	    Color randomColor2 = new Color (red1,green1,blue1);
	    
	    g2.setColor(randomColor2);
	    PineTree trippyTree = new PineTree(x, y, 100,100);

	    g2.draw(trippyTree);
	    g2.drawString("'A psychedelic tree trying to escape reality'- Josue Montenegro", 20,20);

	}
    }

    class Animation extends Thread {
	public void run() {
	    try {
		while (true) {
		    // The tree will bounce diagonally of the walls

		    if (x >= 525) { dx = -5; }
		    if (x <= 10) { dx = 5; }

		    if (y >= 450) {dy = -5;}
		    if (y <= 100) {dy = 5;}

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


