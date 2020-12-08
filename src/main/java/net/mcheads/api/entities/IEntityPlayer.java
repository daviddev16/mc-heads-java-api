package net.mcheads.api.entities;

import net.mcheads.api.IEntity;
import net.mcheads.api.history.INameHistory;
import net.mcheads.api.style.FacingStyle;

public interface IEntityPlayer extends IEntity, FacingStyle {
	
	String getUserId();
	
	INameHistory getNameHistory();
	
	
}
