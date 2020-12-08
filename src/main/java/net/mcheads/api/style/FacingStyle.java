package net.mcheads.api.style;

import net.mcheads.api.style.miscs.StyleOption;

public interface FacingStyle {
	
	static final String BODY_URL = "https://mc-heads.net/player/%s/%d";
	static final String HEAD_URL = "https://mc-heads.net/avatar/%s/%d";
	
	byte[] getFacing(StyleOption option, int size, boolean nohelm);

	byte[] getFacing(StyleOption option, int size);
	
	byte[] getFacing(StyleOption option);
	
	byte[] getDefaultFacing();
	

}
