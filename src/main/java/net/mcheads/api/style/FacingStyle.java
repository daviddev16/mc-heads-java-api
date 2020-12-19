package net.mcheads.api.style;

import net.mcheads.api.exceptions.EntityOutOfBoundsException;
import net.mcheads.api.style.options.StyleOption;

public interface FacingStyle {
	
	static final String BODY_URL = "https://mc-heads.net/player/%s/%d";
	static final String HEAD_URL = "https://mc-heads.net/avatar/%s/%d";
	
	byte[] getFacing(StyleOption option, int size, boolean nohelm) throws EntityOutOfBoundsException;

	byte[] getFacing(StyleOption option, int size) throws EntityOutOfBoundsException;
	
	byte[] getFacing(StyleOption option);
	
	byte[] getDefaultFacing();
	

}
