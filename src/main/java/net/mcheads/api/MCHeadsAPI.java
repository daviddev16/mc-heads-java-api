package net.mcheads.api;

import java.util.Objects;
import net.mcheads.internal.EntityImpl;

public class MCHeadsAPI {
	
	public static final int MAX_SIZE = 600;
	
	public static final int AVATAR_MIN_SIZE = 8;
	
	public static final int ISOMETRIC_MIN_SIZE = 32;
	
	public static IEntity getEntity(String nameOrId) {
		Objects.requireNonNull(nameOrId, "Entity name/id cannot be null.");
		return new EntityImpl(nameOrId, nameOrId.startsWith(Names.MHF_PREFIX));
	}

}
