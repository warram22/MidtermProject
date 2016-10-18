import java.awt.image.BufferedImage;
import java.awt.image.PixelGrabber;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
//import java.util.Base64;

import javax.imageio.ImageIO;

public class Image
{ 
	BufferedImage newImage = null;
	FileInputStream newFile = null;
	
	public Image()
	{
		
	}

	public BufferedImage MakeImage(int width, int height)
	{
		try
		{
			newFile = new FileInputStream(new File("C:\\Users\\Public\\Pictures\\Sample Pictures\\phoenix.png"));//make this a string that is passed from tester
			
		} 
		catch (FileNotFoundException e1)
		{
			e1.printStackTrace();
		}
		
		
		newImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
		
		try
		{
			newImage = ImageIO.read(newFile);
		} 
		catch (IOException e2)
		{
			e2.getStackTrace();
		}
		return newImage;
	}
	
	public BufferedImage getNewImage()
	{
		return newImage;
	}
	
	public FileInputStream getNewFile()
	{
		return newFile;
	}

	public void setNewFile(FileInputStream newFile) 
	{
		this.newFile = newFile;
	}
}
