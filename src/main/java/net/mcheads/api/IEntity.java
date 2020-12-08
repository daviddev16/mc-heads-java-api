package net.mcheads.api;

import net.mcheads.api.history.INameHistory;
import net.mcheads.api.style.FacingStyle;
import net.mcheads.api.style.IsometricStyle;

public interface IEntity extends FacingStyle, IsometricStyle {

	String getUserId();
	
	String getName();
	
	INameHistory getNameHistory();
	
	boolean isMHF();
	
}
