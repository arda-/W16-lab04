package edu.ucsb.cs56.w16.drawings.zzeng.advanced;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;

import edu.ucsb.cs56.w16.drawings.utilities.ShapeTransforms;
import edu.ucsb.cs56.w16.drawings.utilities.GeneralPathWrapper;

/**
 * A main class to view an animation
 *
 * @author Ziliang Zeng
 * @version CS56, W16
 */

public class AnimatedPictureViewer {

    private DrawPanel panel = new DrawPanel();
    
    Thread anim;
    
    private int x = 320;
    private int y = 200;
    private double angle = 0;
    
    private double theta = (Math.PI/64.0);
    private int dy = 5;
    private int dz = 5;
    private float dstroke = .000005f;
    private double dr = 0;
    
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
		public void mouseEntered(MouseEvent e) {
		    System.out.println("Mouse entered");
		    anim = new Animation();
		    anim.start();
		}
		
		public void mouseExited(MouseEvent e) {
		    System.out.println("Mouse exited");
		    
		    anim.interrupt();
		    while(anim.isAlive()){}
		    anim = null;
		    panel.repaint();
		}
	    });    
    }

    class DrawPanel extends JPanel {
	public void paintComponent(Graphics g) {
	    Graphics2D g2 = (Graphics2D) g;

	    g2.setColor(Color.white);
	    g2.fillRect(0,0,this.getWidth(),this.getHeight());

	    g2.setColor(Color.gray);
	    WaterBottle bottle = new WaterBottle(x,y,30,100,25,5,5.5);
	    Shape rotatedbottle = ShapeTransforms.rotatedCopyOf(bottle,angle);
	    g2.draw(rotatedbottle);
	    
	    if (angle == -Math.PI/2) {
		Circle puddle = new Circle(243,347,dr);
		g2.setColor(Color.BLUE);
		g2.draw(puddle);
		g2.fill(puddle);
		if (dz != 200) {
		    GeneralPath water = new GeneralPath();
		    water.moveTo(243,150+dz);
		    water.lineTo(243,147+dy);
		    Stroke thick = new BasicStroke (5.0f-dstroke, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL);
		    g2.setStroke(thick);
		    g2.setColor(Color.CYAN);
		    g2.draw(water);
		}
	    }
	}
    }

    class Animation extends Thread {
	public void run() {
	    try {
		while (true) {
		    if (angle>=0) {
			theta = -Math.PI/64.0;
		    }
		    if (angle <= -Math.PI/2)
			angle = -Math.PI/2;
		    else
			angle = angle + theta;

		    if (angle == -Math.PI/2){
			if (dy >= 200)
			    dy = 200;
			else
			    dy = dy + 5;
			if (dstroke >= 4.9)
			    dstroke = 4.9f;
			else
			    if (dy == 200)
				dstroke = dstroke + .1f;
			if (dy == 200) {
			    if (dr >= 90)
				dr = 90;
			    else
				dr = dr + 1;
			    if (dr >= 55)
				dz = dz + 5;
			    if (dz >= 200)
				dz = 200;
			}
			if(dr == 90) {
			    angle = 0;
			    dy = 5;
			    dz = 5;
			    dstroke = .000005f;
			    dr = 0;  
			}
		    }
		    panel.repaint();
		    Thread.sleep(50);
		}
	    }
	    catch (Exception ex) {
		if (ex instanceof InterruptedException) {

		} else {
		    ex.printStackTrace();
		    System.exit(1);
		}
	    }
	}
    }
}
