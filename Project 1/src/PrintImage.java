import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import javax.swing.JFrame;
import javax.swing.JPanel;


public class PrintImage extends JPanel
{
	private BufferedImage image;
	public void printObject(BufferedImage image, int width, int height)
	{
		this.image = image;
		JFrame frame = new JFrame();
		frame.setSize(width + 100, height + 100);
		frame.setVisible(true);
		frame.getContentPane().add(this);
	    this.setBackground(Color.WHITE);
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
	}
	  @Override
		protected void paintComponent(Graphics g)
		{
			Graphics2D graphics2D = (Graphics2D) g;
			graphics2D.drawImage(image, 0, 0, null);
			super.paintComponents(g);
		}
}
