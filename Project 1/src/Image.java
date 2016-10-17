import java.awt.image.BufferedImage;
import java.awt.image.PixelGrabber;
import java.io.File;
import java.io.IOException;
//import java.util.Base64;

import javax.imageio.ImageIO;

public class Image
{ 
	BufferedImage newImage = null;
	File newFile = null;
	//private byte[] ImageArray;
	//private String imageAsString;
	private int imageSize;
	
	public Image()
	{
		
	}
	
	public BufferedImage MakeImage(int width, int height)
	{
		newFile = new File("C:\\Users\\Thomas\\Pictures\\phoenix.jpg");
		setImageSize((int) newFile.length());
		newImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
		try
		{
			newImage = ImageIO.read(newFile);
		} 
		catch (IOException e)
		{
			e.getStackTrace();
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
	
	public BufferedImage reMakeImage()
	{
		return newImage;
	}
	
	public int getImageSize()
	{
		return imageSize;
	}

	public void setImageSize(int imageSize) 
	{
		this.imageSize = imageSize;
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