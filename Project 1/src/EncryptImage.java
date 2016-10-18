import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

import javax.crypto.Cipher;
import javax.crypto.CipherInputStream;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;


public class EncryptImage extends Image
{
	private BufferedImage newImage = null; 
	private KeyGenerator KG = null;
    private SecretKey Key = null;
    private Cipher cipher = null;
    private FileOutputStream fouts = null;
    private CipherInputStream cipherIn = null;
    
	public EncryptImage()
	{
//		try
//		{
//			keyGenerator = KeyGenerator.getInstance("AES");
//            secretKey = keyGenerator.generateKey();
//            
//            cipher = Cipher.getInstance("AES");
//		}
//		catch(NoSuchPaddingException ex) 
//		{
//            System.out.println(ex);
//        }
//		
//		catch (NoSuchAlgorithmException ex) 
//		{
//			System.out.println(ex);
//		}
	}
	public FileOutputStream encryptImage() throws NoSuchAlgorithmException, NoSuchPaddingException
	{
		cipher = Cipher.getInstance("AES");
		KG = KeyGenerator.getInstance("AES");
		Key = KG.generateKey();
		
		try
		{
			cipher.init(cipher.ENCRYPT_MODE, Key);
		} 
		catch (InvalidKeyException e)
		{
			e.printStackTrace();
		}
			cipherIn = new CipherInputStream(super.getNewFile(), cipher);
		try
		{
			fouts = new FileOutputStream(new File("C:\\Users\\Public\\Pictures\\Sample Pictures\\index.png"));
		}
		catch (FileNotFoundException e)
		{
			e.printStackTrace();
		}
		return fouts;
	}
	public FileOutputStream getFouts()
	{
		return fouts;
	}
	public void setFouts(FileOutputStream fouts) 
	{
		this.fouts = fouts;
	}
	public KeyGenerator getKG()
	{
		return KG;
	}
	public SecretKey getKey()
	{
		return Key;
	}
	public CipherInputStream getCipherIn()
	{
		return cipherIn;
	}
	public void setKG(KeyGenerator kG)
	{
		this.KG = kG;
	}
	public void setKey(SecretKey key)
	{
		this.Key = key;
	}
	public void setCipherIn(CipherInputStream cipherIn) 
	{
		this.cipherIn = cipherIn;
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