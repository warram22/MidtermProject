import java.awt.RenderingHints.Key;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import javax.imageio.ImageIO;
import java.io.FileOutputStream;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.Security;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.CipherInputStream;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import org.bouncycastle.jce.provider.BouncyCastleProvider;


//there are 14 libraries lol
public class ImageEncryption
{ 
	private BufferedImage newImage;
	private KeyGenerator generator;
    private SecretKey Key;
    private Cipher EncryptCipher;
    private Cipher DecryptCipher;
    private FileOutputStream EFOS;
    private FileOutputStream DFOS;
    private CipherInputStream ECI;
    private CipherInputStream DCI;
    
	public ImageEncryption() throws NoSuchProviderException, NoSuchPaddingException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException
	{
		newImage = null;
		try
		{
			generator = KeyGenerator.getInstance("AES");
		    Security.addProvider(new org.bouncycastle.jce.provider.BouncyCastleProvider());    
		    KeyGenerator generator = KeyGenerator.getInstance("AES", "BC");
		    generator.init(128);
		    SecretKey keyToBeWrapped = generator.generateKey();
		    System.out.println("input    : " + new String(keyToBeWrapped.getEncoded()));

		    // create a wrapper and do the wrapping
		    Cipher cipher = Cipher.getInstance("AES/ECB/NoPadding", "BC");
		    KeyGenerator keyGen = KeyGenerator.getInstance("AES",  "BC");
		    keyGen.init(256);
		    SecretKey wrapKey = keyGen.generateKey();
		    cipher.init(Cipher.ENCRYPT_MODE, wrapKey);
		    byte[] wrappedKey = cipher.doFinal(keyToBeWrapped.getEncoded());
		    System.out.println("wrapped  : " + new String(wrappedKey));

		    // unwrap the wrapped key
		    cipher.init(Cipher.DECRYPT_MODE, wrapKey);
		    SecretKeySpec key = new SecretKeySpec(cipher.doFinal(wrappedKey), "AES");
		    System.out.println("unwrapped: " + new String(key.getEncoded()));
		}
		
		catch (NoSuchAlgorithmException e)
		{
			e.printStackTrace();
		}
		Key = generator.generateKey();
	}

	public BufferedImage MakeImage(String FilePath)
	{
		
		try
		{
			newImage = ImageIO.read(new FileInputStream(new File (FilePath)));
		} 
		catch (FileNotFoundException e1)
		{
			e1.printStackTrace();
		}
		catch (IOException e2)
		{
			e2.getStackTrace();
		}
		
		return newImage;
	}
	
	public void encryptImage(String FilePath, String EncryptedPath)
	{
		try
		{
			EncryptCipher = Cipher.getInstance("AES");
			EncryptCipher.init(Cipher.ENCRYPT_MODE, Key);
			ECI = new CipherInputStream(new FileInputStream(new File(FilePath)), EncryptCipher);
			EFOS = new FileOutputStream(new File(EncryptedPath));//creates new location for encrypted file
			
			int i; 
			while((i = ECI.read())!=-1)//this reads from the cipher
			{
				EFOS.write(i);//this writes the bytes(stored in i) to the newly created file
			}
			
			EFOS.flush();
			ECI.close();
			EFOS.close();
		}
		catch(NoSuchPaddingException ex) 
		{
            System.out.println(ex);
        }
		catch (NoSuchAlgorithmException ex) 
		{
			System.out.println(ex);
		}
		catch (InvalidKeyException e)
		{
			e.printStackTrace();
		}
		catch (FileNotFoundException e)
		{
			e.printStackTrace();
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}
	
	public void DecryptImage(String EncryptedPath, String DecryptedPath) throws IOException, NoSuchAlgorithmException, NoSuchPaddingException
	{
		try
		{
			DecryptCipher = Cipher.getInstance("AES");
			DecryptCipher.init(Cipher.DECRYPT_MODE, Key);
			DCI = new CipherInputStream(new FileInputStream(new File(EncryptedPath)), DecryptCipher);
			DFOS = new FileOutputStream(new File(DecryptedPath));//creates new location for decrypted file
			
			int i; 
			while((i = DCI.read())!= -1)//reads bytes from the cipher which is using an input stream with the encrypted Path 
			{
				DFOS.write(i);//writes the bytes (stored in i) to the output stream to the decrypted path
			}
			DFOS.flush();
			DCI.close();
			DFOS.close();
		} 
		catch (InvalidKeyException e)
		{
			e.printStackTrace();
		}	
	}
}
