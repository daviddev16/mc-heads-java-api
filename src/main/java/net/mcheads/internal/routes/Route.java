package net.mcheads.internal.routes;

import java.io.IOException;
import java.io.InputStream;

import net.mcheads.internal.LazyInputStream;
import net.mcheads.internal.utils.Utilities;

public abstract class Route {

	public synchronized InputStream doRequest(String urlFormat) {

		LazyInputStream lazyInputStream = new LazyInputStream(null);
		
		try {
			Utilities.doGet(urlFormat, (entity, client) -> 
			{
				try {
					lazyInputStream.set(entity.getContent());
				} catch (UnsupportedOperationException | IOException e) {
					e.printStackTrace();
				}
			});
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return lazyInputStream.get();
	}


}
