package net.mcheads.api.style;
import net.mcheads.api.style.miscs.Direction;
import net.mcheads.api.style.miscs.StyleOption;

public interface IsometricStyle {

	static final String BODY_URL = "https://mc-heads.net/body/%s/%d/%s";
	static final String HEAD_URL = "https://mc-heads.net/head/%s/%d/%s";

	byte[] getIsometric(StyleOption option, int size, Direction direction);
	
	byte[] getIsometric(StyleOption option, int size);
	
	byte[] getIsometric(StyleOption option);
	
	byte[] getDefaultIsometric();
	
}
