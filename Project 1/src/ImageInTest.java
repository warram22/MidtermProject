import java.io.IOException;

public class ImageInTest
{
	public static void main(String[] args)  
	{
		int width = 500;
		int height = 500;
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
		
		PrintImage printIt = new PrintImage();
		printIt.printObject(newEncryption.MakeImage(width, height, normalPath), width, height);
		printIt.printObject(newEncryption.MakeImage(width, height, encryptedPath), width, height);
		printIt.printObject(newEncryption.MakeImage(width, height, decryptedPath), width, height);
		
		
    }	
}
