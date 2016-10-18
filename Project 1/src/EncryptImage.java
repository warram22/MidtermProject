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
	private BufferedImage newImage; 
	private KeyGenerator KG;
    private SecretKey Key;
    private Cipher cipher;
    private FileOutputStream fouts;
    private CipherInputStream cipherIn;
    
	public EncryptImage()
	{
		try
		{
			KG = KeyGenerator.getInstance("AES");
			Key = KG.generateKey();
            
			cipher = Cipher.getInstance("AES");
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
	public FileOutputStream encryptImage() throws NoSuchAlgorithmException, NoSuchPaddingException
	{
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
			fouts = new FileOutputStream(new File("C:\\Users\\Public\\Pictures\\Sample Pictures\\phoenix2.png"));//string of some sort from tester
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
	public void setKG(KeyGenerator KG)
	{
		this.KG = KG;
	}
	public void setKey(SecretKey Key)
	{
		this.Key = Key;
	}
	public void setCipherIn(CipherInputStream cipherIn) 
	{
		this.cipherIn = cipherIn;
	}
	
	
}
