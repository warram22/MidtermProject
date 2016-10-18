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
		int width = 1200;
		int height = 1200;
		
		Image Image = new Image();
		image = Image.MakeImage(width, height);
		
		PrintImage printIt = new PrintImage();
		printIt.printObject(image, width, height);
		
		EncryptImage encryption = new EncryptImage();
		
		try
		{
			FileOutputStream FOUTS = encryption.encryptImage();
			CipherInputStream CIS = encryption.getCipherIn();
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
