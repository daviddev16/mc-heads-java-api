package net.mcheads;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;

import javax.imageio.ImageIO;

import net.mcheads.api.entities.IEntityPlayer;
import net.mcheads.api.style.StyleOption;
import net.mcheads.internal.EntityPlayerImpl;

public class Main {

	public static void main(String[] args) throws IOException {

		IEntityPlayer player = new EntityPlayerImpl("88eeb349483c42798361ec8bbbb60afd");

		System.out.println(player.getName());
		System.out.println(player.getUserId());
		System.out.println(Arrays.toString(player.getNameHistory().getAllNames()));

		byte[] face = player.getFacing(StyleOption.BODY, 192, true);

		File imgFile = new File("img.png");
		if(!imgFile.exists()) {
			imgFile.createNewFile();
		}

		ByteArrayInputStream bis = new ByteArrayInputStream(face);
		BufferedImage bImage2 = ImageIO.read(bis);
		ImageIO.write(bImage2, "png", imgFile);


	}

}
