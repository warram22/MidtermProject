
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

public class ImageInTest
{
	public static void main(String[] args) throws InvalidKeyException, NoSuchProviderException, NoSuchPaddingException, IllegalBlockSizeException, BadPaddingException, NoSuchAlgorithmException  
	{
		//Make sure you change the file paths to where you want to pull from and write to. 
		String normalPath = "C:\\Users\\Thomas\\Pictures\\Project 1 Pics\\phoenix.png";
		String encryptedPath = "C:\\Users\\Thomas\\Pictures\\Project 1 Pics\\Encrypted.png";
		String decryptedPath = "C:\\Users\\Thomas\\Pictures\\Project 1 Pics\\Decrypted.png";
		
		ImageEncryption newEncryption = new ImageEncryption();
		try
		{
			newEncryption.encryptImage(normalPath, encryptedPath);
			newEncryption.DecryptImage(encryptedPath, decryptedPath);	
		}
		
		catch (IOException e)
		{
			e.printStackTrace();
		}
		
		//BufferedImage Image = newEncryption.MakeImage(normalPath);
		//int height = Image.getHeight();
		//int width = Image.getWidth();
		
		//PrintImage printIt = new PrintImage();
		//printIt.printObject(Image, width, height);
		//printIt.printObject(newEncryption.MakeImage(encryptedPath), width, height);
		//printIt.printObject(newEncryption.MakeImage(decryptedPath), width, height);
		
		/*
		 * Initially we wanted to use the commented out code to show the file contents but it soon became clear that it would
		 * make more sense to just save the files to an actual file location somewhere in the HDD
		 */
    }	
}
