package net.mcheads.api.style;

import net.mcheads.api.exceptions.EntityOutOfBoundsException;
import net.mcheads.api.style.options.StyleOption;

public interface FacingStyle {
	
	byte[] getFacing(StyleOption option, int size, boolean nohelm) throws EntityOutOfBoundsException;

	byte[] getFacing(StyleOption option, int size) throws EntityOutOfBoundsException;
	
	byte[] getFacing(StyleOption option);
	
	byte[] getDefaultFacing();
	

}
