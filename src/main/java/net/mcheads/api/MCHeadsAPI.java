package net.mcheads.api;

import java.util.Objects;

public class MCHeadsAPI {


	
	public static IEntity getEntity(String name) {

		Objects.requireNonNull(name, "Entity name cannot be null.");
		
		if(name.startsWith(Names.MHF_PREFIX)) {
			
		}
		return null;
	}
	
}
