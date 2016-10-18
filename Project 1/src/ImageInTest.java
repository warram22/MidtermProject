import java.awt.image.BufferedImage;
import java.awt.image.DataBuffer;
import java.awt.image.DataBufferInt;
import java.awt.image.Raster;
import java.awt.image.SinglePixelPackedSampleModel;
import java.awt.image.WritableRaster;


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
		
		
		//everything below this line I have been messing around with. Not workable yet.
		int[] pixels = Image.MakePixelArray(width, height);
		DataBufferInt buffer = new DataBufferInt(pixels, (width*height));
		int bitMask[] = new int[]{0xff0000, 0xff00, 0xff, 0xff000000};
		
		
		SinglePixelPackedSampleModel sample = new SinglePixelPackedSampleModel(DataBuffer.TYPE_INT, width,height, bitMask);
		
		WritableRaster newRaster = Raster.createWritableRaster(sample, buffer, null);
		
		EncryptImage encryption = new EncryptImage();
		
		encryption.encryptArray(pixels);
		
		
		/*String encodedString = Image.encodeImage();
		byte[] imageArray = Image.decodeImage();
		System.out.println(encodedString);
		System.out.println(imageArray);
		*/
		
    }	
}
