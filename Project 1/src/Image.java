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
	BufferedImage newImage;
	FileInputStream newFile;
	
	public Image()
	{
		//some or most of the Make image could move here???? IDK
	}

	public BufferedImage MakeImage(int width, int height, String FilePath)
	{
		try
		{
			newFile = new FileInputStream(new File(FilePath));
			
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
