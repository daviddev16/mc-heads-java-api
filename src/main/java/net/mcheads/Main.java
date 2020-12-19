package net.mcheads;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import net.mcheads.api.IEntity;
import net.mcheads.api.MCHeadsAPI;
import net.mcheads.api.MHF;
import net.mcheads.api.exceptions.EntityOutOfBoundsException;
import net.mcheads.api.style.options.StyleOption;
import net.mcheads.internal.Options;

public class Main {

	public static void main(String[] args) throws IOException, EntityOutOfBoundsException {

		
		IEntity player = MCHeadsAPI.getEntity(MHF.MHF_ARROWLEFT, Options.DEFAULT);

	    System.out.println(player.getName());
	    System.out.println(player.getUserId());
	   // System.out.println(Arrays.toString(player.getNameHistory().getAllNames()));

		byte[] face = player.getIsometric(StyleOption.HEAD, 600);

		File imgFile = new File("img.png");
		if(!imgFile.exists()) {
			imgFile.createNewFile();
		}

		ByteArrayInputStream bis = new ByteArrayInputStream(face);
		BufferedImage bImage2 = ImageIO.read(bis);
		ImageIO.write(bImage2, "png", imgFile);

	}

}
