import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import javax.imageio.ImageIO;
import java.io.FileOutputStream;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import javax.crypto.Cipher;
import javax.crypto.CipherInputStream;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;

public class ImageEncryption
{ 
	private BufferedImage newImage;
	private KeyGenerator KG;
    private SecretKey Key;
    private Cipher EncryptCipher;
    private Cipher DecryptCipher;
    private FileOutputStream EFOS;
    private FileOutputStream DFOS;
    private CipherInputStream ECI;
    private CipherInputStream DCI;
    
	public ImageEncryption()
	{
		newImage = null;
		try
		{
			KG = KeyGenerator.getInstance("AES");
		}
		
		catch (NoSuchAlgorithmException e)
		{
			e.printStackTrace();
		}
		Key = KG.generateKey();
	}

	public BufferedImage MakeImage(int width, int height, String FilePath)
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
			EncryptCipher.init(EncryptCipher.ENCRYPT_MODE, Key);
			ECI = new CipherInputStream(new FileInputStream(new File(FilePath)), EncryptCipher);
			EFOS = new FileOutputStream(new File(EncryptedPath));
			
			int i; 
			while((i = ECI.read())!=-1)//this reads from the cipher
			{
				EFOS.write(i);//this writes the bytes(stored in i) to the newly created file
			}
			EFOS.flush();
			
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
	
	public void DecryptImage(String EncryptedPath, String DecryptedPath) throws IOException
	{
		try
		{
			
			DecryptCipher = Cipher.getInstance("AES");
			DecryptCipher.init(DecryptCipher.DECRYPT_MODE, Key);
			DCI = new CipherInputStream(new FileInputStream(new File(EncryptedPath)), DecryptCipher);
			DFOS = new FileOutputStream(new File(DecryptedPath));
			
			int i; 
			while((i = DCI.read())!= -1)//reads bytes from the cipher which is using an input stream with the encrypted Path 
			{
				DFOS.write(i);//writes the bytes (stored in i) to the output stream to the decrypted path
			}
			DFOS.flush();
			DFOS.flush();
		} 
		catch (InvalidKeyException e)
		{
			e.printStackTrace();
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
