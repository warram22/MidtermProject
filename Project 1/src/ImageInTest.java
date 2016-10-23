//import java.awt.image.BufferedImage;
import java.io.IOException;

public class ImageInTest
{
	public static void main(String[] args)  
	{
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
		
		/*So I tried to make it so that we could get the images to print with the JFrame by using the images actual size
		 * But as soon as I did that it started to only print the decrypted object every now and then
		 * I'll leave it up to you if we want to keep it this way (it is commented out as of now)
		 * It always decrypts properly though (YAY!) but sometimes you have to close the JFrame before it will register in the file
		 * I'm thinking the JFrame isn't useful anymore so its okay if we want to get rid of that class. 
		 * I'm sure I'll find a use for it some day later in life haha 
		 * 
		 *  I also learned that if we don't do it by separating the pixels into byte arrays 
		 *  the code works for jpg and png! so I definitely think this is the way to go 
		 *  we can talk about that portion of that in the presentation as well
		*/
    }	
}
