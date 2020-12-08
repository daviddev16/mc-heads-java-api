package net.mcheads.internal.routes;

import java.io.InputStream;

import net.mcheads.api.IEntity;
import net.mcheads.api.entities.IEntityMHF;
import net.mcheads.api.entities.IEntityPlayer;
import net.mcheads.api.style.StyleOption;

public class FacingRoute extends Route {

	public InputStream get(IEntity entity, StyleOption option, int size, boolean nohelm) {

		String identifier = (entity instanceof IEntityMHF) ? entity.getName() : ((IEntityPlayer)entity).getUserId();
		String url = null;

		switch (option) {
			case BODY: 
				url = String.format(option.getUrl(), identifier);
				break;
			case HEAD: 
				url = String.format(option.getUrl(), identifier, size);
				if(nohelm) url = url.concat("/nohelm.png");
				break;
		}

		return doRequest(url);
	}

}
