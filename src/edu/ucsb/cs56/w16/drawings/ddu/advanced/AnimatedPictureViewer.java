package edu.ucsb.cs56.w16.drawings.ddu.advanced;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

/**

 * Main class to view animation

 * @author David Du
 * @version for CS56, W16

 */

public class AnimatedPictureViewer {

    private DrawPanel panel = new DrawPanel();

    
    Thread anim;

    private double x = 100;
    private double y = 100;
    private double length = 100.0;
    private double dTheta = .025;
    
    public static void main(String[] args) {
	new AnimatedPictureViewer().start();
    }

    public void start() {
	JFrame window = new JFrame();

	window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	window.getContentPane().add(panel);
	window.setSize(800, 800);
	window.setVisible(true);

	//Credit for MouseAdapter goes to andrewberls
	window.getContentPane().addMouseListener(new MouseAdapter() {
		public void mouseEntered(MouseEvent e){
		    System.out.println("Mouse entered");
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
    }

    class DrawPanel extends JPanel {
	public void paintComponent(Graphics g) {
	    Graphics2D g2 = (Graphics2D) g;

	    //Clear panel
	    g2.setColor(Color.white);
	    g2.fillRect(0, 0, this.getWidth(), this.getHeight());

	    g2.setColor(Color.BLUE);
	    Star star = new Star(x, y, length);
	    g2.draw(star);

	}
    }

    class Animation extends Thread {
	public void run() {
	    try {
		while(true) {
		    if(x >= 150) {
			x -= 400;
			y -= 400;
		    }
		    x = x * Math.cos(dTheta) - y * Math.sin(dTheta);
		    y = y * Math.cos(dTheta) + x * Math.sin(dTheta);
		    x += 400;
		    y += 400;
		    panel.repaint();
		    Thread.sleep(50);
		}
	    }
	    catch(Exception ex) {
		if( ex instanceof InterruptedException) {
		    //Do nothing - expected on mouseExited
		}
		else {
		    ex.printStackTrace();
		    System.exit(1);
		}
	    }
	}
    }
    

}
