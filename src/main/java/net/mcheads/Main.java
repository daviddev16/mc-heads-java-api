package net.mcheads;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import net.mcheads.api.IEntity;
import net.mcheads.api.MCHeadsAPI;
import net.mcheads.api.exceptions.EntityOutOfBoundsException;
import net.mcheads.api.style.options.StyleOption;
import net.mcheads.internal.Options;

public class Main {

	public static void main(String[] args) throws IOException, EntityOutOfBoundsException {

		
		IEntity herobrine = MCHeadsAPI.getEntity("Daviddev", Options.FULL);

	   // System.out.println(herobrine.getName());
	    //System.out.println(herobrine.getUserId());
	    //System.out.println(Arrays.toString(herobrine.getNameHistory().getAllNames()));

		byte[] isometricHead = herobrine.getIsometric(StyleOption.HEAD, 64); /*the raw byte array of the image*/

		File imgFile = new File("img.png");
		if(!imgFile.exists()) {
			imgFile.createNewFile();
		}

		ByteArrayInputStream bis = new ByteArrayInputStream(isometricHead);
		BufferedImage bImage2 = ImageIO.read(bis);
		ImageIO.write(bImage2, "png", imgFile);

	}

}
