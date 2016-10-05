import java.io.IOException;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.*;
import java.awt.image.BufferedImage;


public class ImageInTest extends JPanel
{

	private BufferedImage image;

	public static void main(String[] args) 
	{
		ImageInTest test = new ImageInTest();
		
    }
	public ImageInTest()
	{
		int width = 1500;
		int height = 1000;
		
		File file = null;
		JFrame frame = new JFrame();
		
		try
		{
			file = new File("C:\\Users\\Public\\Pictures\\Sample Pictures\\Koala.jpg");
			image = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
			image = ImageIO.read(file);
			System.out.print(image);
			frame.setSize(width, height);
			frame.setVisible(true);
			frame.getContentPane().add(this);
	        this.setBackground(Color.WHITE);
	        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			
		}
		catch(IOException e)
		{
			System.out.println("Error: "+e);
		}
	
	}
		@Override
		protected void paintComponent(Graphics g) {
		    super.paintComponent(g);
		    g.drawImage(image, 0, 0, null); // see javadoc for more info on the
		} 
// parameters
}
