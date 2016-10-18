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
			newFile = new FileInputStream(new File("C:\\Users\\Public\\Pictures\\Sample Pictures\\index.png"));
			
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
	
	public int[] MakePixelArray(int width, int height)
	{
		int pixels[] = new int[width*height];
		PixelGrabber pixel = new PixelGrabber(newImage, 0, 0, width, height, pixels, 0 , width);
		
		try
		{
			pixel.grabPixels();
		}
		catch(InterruptedException e)
		{
			System.out.print("Error: " + e);
		}
		
		return pixels;
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
/* This stuff is not needed at the moment
 * public String encodeImage()

{
	ImageArray = new byte[getImageSize()];
	try
	{
		FileInputStream imageStream = new FileInputStream(newFile);
		imageStream.read(ImageArray);
		imageStream.close();
	}
	catch (FileNotFoundException e)
	{
		e.printStackTrace();
	}
	catch (IOException e)
	{
		e.getStackTrace();
	}
	
	imageAsString = Base64.getEncoder().encodeToString(ImageArray);
	
	return imageAsString;
}

public byte[] decodeImage()
{
	byte[] decodedImage = Base64.getDecoder().decode(imageAsString);
	return decodedImage;
}
*/