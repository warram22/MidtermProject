import java.awt.image.BufferedImage;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;


public class EncryptImage extends Image
{
	BufferedImage newImage = null; 
	KeyGenerator keyGenerator = null;
    SecretKey secretKey = null;
    Cipher cipher = null;
    
	public EncryptImage()
	{
		try
		{
			keyGenerator = KeyGenerator.getInstance("Blowfish");
            secretKey = keyGenerator.generateKey();
            
            cipher = Cipher.getInstance("Blowfish");
		}
		catch(NoSuchPaddingException ex) 
		{
            System.out.println(ex);
        }
		
		catch (NoSuchAlgorithmException ex) 
		{
			System.out.println(ex);
		}
	}
	
	public int[] encryptArray(int[] pixels)
	{
		int[] encryptedPixels = new int[pixels.length];
		
		return encryptedPixels;
	
	}
}
/*


public String encode(BufferedImage newImage)
	{
		byte[] byteArray = new byte[super.getImageSize()];
		String imageAsString = Base64.getEncoder().encodeToString(byteArray);
		return imageAsString;
	}
*/