package dot.sx;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class Draw extends JFrame {

	private static final long serialVersionUID = 1L;
	// Define constants
	//public static final int CANVAS_WIDTH  = 640;
	//public static final int CANVAS_HEIGHT = 480;

	// Declare an instance of the drawing canvas,
	// which is an inner class called DrawCanvas extending javax.swing.JPanel.
	private DrawCanvas canvas;
	
	private List<Double[]> dots;

	// Constructor to set up the GUI components and event handlers
	public Draw(List<Double[]> dots, int max) {
		canvas = new DrawCanvas();    // Construct the drawing canvas
		canvas.setPreferredSize(new Dimension(1000, 1000));
		this.dots = dots;

		// Set the Drawing JPanel as the JFrame's content-pane
		Container cp = getContentPane();
		cp.add(canvas);
		// or "setContentPane(canvas);"

		setDefaultCloseOperation(EXIT_ON_CLOSE);   // Handle the CLOSE button
		pack();              // Either pack() the components; or setSize()
		setTitle("......");  // "super" JFrame sets the title
		setVisible(true);    // "super" JFrame show
	}

	/**
	 * Define inner class DrawCanvas, which is a JPanel used for custom drawing.
	 */
	private class DrawCanvas extends JPanel {
		// Override paintComponent to perform your own painting
		@Override
		public void paintComponent(Graphics g) {
			super.paintComponent(g);     // paint parent's background
			setBackground(Color.BLACK);  // set background color for this JPanel

			// Your custom painting codes. For example,
			// Drawing primitive shapes
			g.setColor(Color.GREEN);    // set the drawing color
			int num = 0;
			Double[] pre = null;
			for (Double[] d : dots) {
				if (pre == null) {
					g.setFont(new Font("Monospaced", Font.PLAIN, 10));
					g.setColor(Color.RED);
					g.drawString("First", d[0].intValue(), d[1].intValue());
					g.setColor(Color.GREEN);
					pre = d;
					continue;
				}
				g.drawLine(pre[0].intValue(), pre[1].intValue(), d[0].intValue(), d[1].intValue());
				pre = d;
			}
			g.setColor(Color.RED);
			g.drawString("Last", pre[0].intValue(), pre[1].intValue());
			/*for (Line l : lines) {
				g.drawLine(l.getStart().getIntX() + 5, l.getStart().getIntY() + 5,
						l.getEnd().getIntX() + 5, l.getEnd().getIntY() + 5);
				g.setFont(new Font("Monospaced", Font.PLAIN, 10));
				g.drawString(String.valueOf(num++), l.getStart().getIntX() + 5, l.getStart().getIntY() + 5);
			}*/
			
			/*g.drawLine(30, 40, 100, 200);
			g.drawOval(150, 180, 10, 10);
			g.drawRect(200, 210, 20, 30);
			g.setColor(Color.RED);       // change the drawing color
			g.fillOval(300, 310, 30, 50);
			g.fillRect(400, 350, 60, 50);
			// Printing texts
			g.setColor(Color.WHITE);
			g.setFont(new Font("Monospaced", Font.PLAIN, 12));
			g.drawString("Testing custom drawing ...", 10, 20);*/
		}
	}
}