package net.mcheads.internal.routes;

import java.io.InputStream;
import net.mcheads.api.IEntity;
import net.mcheads.api.style.options.Direction;
import net.mcheads.api.style.options.StyleOption;

public class IsometricRoute extends Route {

	public InputStream get(IEntity entity, StyleOption option, int size, Direction direction) {
		switch (option) 
		{
		case BODY: return doRequest(String.format(ISOMETRIC_BODY_URL, entity.getUserId(), size, direction));
		case HEAD: return doRequest(String.format(ISOMETRIC_HEAD_URL, entity.getUserId(), size, direction));
		}
		return null;
	}

}
