import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.util.Base64;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.CipherInputStream;
import javax.crypto.CipherOutputStream;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.SecretKeySpec;


public class Crypto extends Image
{
	private BufferedImage newImage; 
	private KeyGenerator KG;
    private SecretKey Key;
    private Cipher cipher;
    private FileOutputStream fouts;
    private CipherInputStream cipherIn;
    private CipherOutputStream COS;
    
	public Crypto() throws NoSuchProviderException
	{
		try
		{
			//KG = KeyGenerator.getInstance("AES");
			//Key = KG.generateKey();
            
			cipher = Cipher.getInstance("AES/ECB/NoPadding", "DSA");
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
	public void encryptImage(String FilePath) throws NoSuchAlgorithmException, NoSuchPaddingException, IllegalBlockSizeException, BadPaddingException
	{
		try
		{
			cipher.init(cipher.ENCRYPT_MODE, Key);
			byte[] wrappedKey = cipher.doFinal(Key.getEncoded());
		} 
		catch (InvalidKeyException e)
		{
			e.printStackTrace();
		}
			
		cipherIn = new CipherInputStream(super.getNewFile(), cipher);
		
		try
		{
			fouts = new FileOutputStream(new File(FilePath));
			//COS = new CipherOutputStream(COS, cipher); I think we need this for decyrpt but didnt have time to figure it out at the moment...
		}
		catch (FileNotFoundException e)
		{
			e.printStackTrace();
		}
	}
	
	public void DecrytImage()
	{
		//cipher.init(Cipher.DECRYPT_MODE, Key);
		//Key key = new SecretKeySpec(cipher.doFinal(wrappedKey), "AES");
	}
	
	//not sure if we actually need these or not but at the moment I am leaving them we can talk about it after its done!
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
