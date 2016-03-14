package edu.ucsb.cs56.w16.drawings.hunterbuckhorn.advanced;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


/**
   @author Hunter Buckhorn
   @version for CS56, W16, UCSB  
 */

public class AnimatedPictureViewer {

    private DrawPanel panel = new DrawPanel();

    private TabletSurface tablet = new TabletSurface(100, 100, 100, 100);

    Thread animation;

    private int x = 100;
    private int y = 100;

    private int dx = 2;
    private int dy = 2;

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
		    System.out.println("Mouse entered");
		    animation = new Animation();
		    animation.start();
		}

		public void mouseExited(MouseEvent e){
		    System.out.println("Mouse exited");
		    // Kill the animation thread                                          
		    animation.interrupt();
		    while (animation.isAlive()){}
		    animation = null;
		    panel.repaint();
		}
	    });

    } // go() 



    class DrawPanel extends JPanel {
	public void paintComponent(Graphics g) {
	    Graphics2D g2 = (Graphics2D) g;

	    // no smearing
	    g2.setColor(Color.white);
	    g2.fillRect(0, 0, this.getWidth(), this.getHeight());

	    // Draw the TabletSurface
	    g2.setColor(Color.BLUE);
	    TabletSurface tablet = new TabletSurface(x, y, 100, 100);
	    g2.draw(tablet);
	} 
    }

    class Animation extends Thread {
	public void run() {
	    try {
		while (true) {
		    // bounce off the walls

		    if (x <= 0 || x >= 520) { dx = -1 * dx; }
		    if (y <= 0 || y >= 340) { dy = -1 * dy; }
		    
		    x += dx;
		    y += dy;
		    panel.repaint();
		    Thread.sleep(30);

		}
	    } catch(Exception ex) {
		if (ex instanceof InterruptedException) {
		    // Pause on Mouse Out
		} else {
		    ex.printStackTrace();
		    System.exit(1);
		}
	    } // end try/catch
	} // end run()
    } // end Animation Class


}
