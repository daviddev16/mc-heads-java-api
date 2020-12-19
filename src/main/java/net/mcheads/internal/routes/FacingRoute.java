package net.mcheads.internal.routes;

import java.io.InputStream;
import net.mcheads.api.IEntity;
import net.mcheads.api.style.options.StyleOption;

public class FacingRoute extends Route {

	public InputStream get(IEntity entity, StyleOption option, int size, boolean nohelm) {
		switch (option) 
		{
		case BODY: return doRequest(String.format(FACING_BODY_URL, entity.getUserId(), size));
		case HEAD: return doRequest(String.format(FACING_HEAD_URL, entity.getUserId(), size)
				.concat(nohelm ? "/nohelm.png" : ""));
		}
		return null;
	}

}
