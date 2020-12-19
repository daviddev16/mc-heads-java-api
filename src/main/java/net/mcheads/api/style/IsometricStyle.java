package net.mcheads.api.style;
import net.mcheads.api.exceptions.EntityOutOfBoundsException;
import net.mcheads.api.style.options.Direction;
import net.mcheads.api.style.options.StyleOption;

public interface IsometricStyle {

	static final String BODY_URL = "https://mc-heads.net/body/%s/%d/%s";
	static final String HEAD_URL = "https://mc-heads.net/head/%s/%d/%s";

	byte[] getIsometric(StyleOption option, int size, Direction direction) throws EntityOutOfBoundsException;
	
	byte[] getIsometric(StyleOption option, int size) throws EntityOutOfBoundsException;
	
	byte[] getIsometric(StyleOption option);
	
	byte[] getDefaultIsometric();
	
}
