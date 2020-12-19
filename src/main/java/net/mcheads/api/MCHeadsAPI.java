package net.mcheads.api;

import java.util.Objects;
import net.mcheads.internal.EntityImpl;

public class MCHeadsAPI {
	

	public static synchronized IEntity getEntity(String nameOrId) {
		Objects.requireNonNull(nameOrId, "Entity name/id cannot be null.");
		return new EntityImpl(nameOrId);
	}

	public static synchronized IEntity getEntity(MHF mhf) {
		Objects.requireNonNull(mhf, "MHF object cannot be null.");
		return new EntityImpl(mhf);
	}
	
}
