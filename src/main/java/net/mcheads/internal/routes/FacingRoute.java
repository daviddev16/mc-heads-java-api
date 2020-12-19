package net.mcheads.internal.routes;

import java.io.InputStream;

import net.mcheads.api.IEntity;
import net.mcheads.api.style.FacingStyle;
import net.mcheads.api.style.miscs.StyleOption;

public class FacingRoute extends Route {

	public InputStream get(IEntity entity, StyleOption option, int size, boolean nohelm) {

		String url = null;
		switch (option) {
			case BODY: 
				url = String.format(FacingStyle.BODY_URL, entity.getUserId(), size);
				break;
			case HEAD: 
				url = String.format(FacingStyle.HEAD_URL, entity.getUserId(), size);
				if (nohelm) url = url.concat("/nohelm.png");
				break;
		}
		return doRequest(url);
	}

}
