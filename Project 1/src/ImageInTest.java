import java.awt.image.BufferedImage;
import java.awt.image.DataBuffer;
import java.awt.image.DataBufferInt;
import java.awt.image.Raster;
import java.awt.image.SinglePixelPackedSampleModel;
import java.awt.image.WritableRaster;
import java.io.FileOutputStream;
import java.security.NoSuchAlgorithmException;

import javax.crypto.CipherInputStream;
import javax.crypto.NoSuchPaddingException;


public class ImageInTest
{
	public static void main(String[] args) 
	{
		BufferedImage image;
		int width = 500;
		int height = 500;
		String Path = "C:\\Users\\Thomas\\Pictures\\Project 1 Pics\\phoenix.png";//so that we can easily change the path name!
		String encryptedPath = "C:\\Users\\Thomas\\Pictures\\Project 1 Pics\\phoenix2.png";
		String decrytpedPath = "C:\\Users\\Thomas\\Pictures\\Project 1 Pics\\phoenix3.png";
		
		Image Image = new Image();
		image = Image.MakeImage(width, height, Path);
		
		PrintImage printIt = new PrintImage();
		printIt.printObject(image, width, height);
		
		Crypto encryption = new Crypto();
		try
		{
			encryption.encryptImage(encryptedPath);
		} 
		catch (NoSuchAlgorithmException e)
		{
			e.printStackTrace();
		} 
		catch (NoSuchPaddingException e)
		{
			e.printStackTrace();
		}
		
    }	
}
