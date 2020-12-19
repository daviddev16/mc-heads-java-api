package net.mcheads.internal.routes;

import java.io.InputStream;

import net.mcheads.api.IEntity;
import net.mcheads.api.style.IsometricStyle;
import net.mcheads.api.style.options.Direction;
import net.mcheads.api.style.options.StyleOption;

public class IsometricRoute extends Route {

	public InputStream get(IEntity entity, StyleOption option, int size, Direction direction) {
		String url = null;
		switch (option) {
			case BODY: 
				url = String.format(IsometricStyle.BODY_URL, entity.getUserId(), size, direction);
				break;
			case HEAD: 
				url = String.format(IsometricStyle.HEAD_URL, entity.getUserId(), size, direction);
				break;
		}
		return doRequest(url);
	}

}
