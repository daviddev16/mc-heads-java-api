package net.mcheads.internal.routes;

import java.io.InputStream;
import net.mcheads.internal.LazyInputStream;
import net.mcheads.internal.utils.Utilities;

public abstract class Route {

	protected static final String FACING_BODY_URL = "https://mc-heads.net/player/%s/%d";
	protected static final String FACING_HEAD_URL = "https://mc-heads.net/avatar/%s/%d";
	protected static final String ISOMETRIC_BODY_URL = "https://mc-heads.net/body/%s/%d/%s";
	protected static final String ISOMETRIC_HEAD_URL = "https://mc-heads.net/head/%s/%d/%s";

	public synchronized InputStream doRequest(String urlFormat) {
		LazyInputStream lazyInputStream = new LazyInputStream(null);
		Utilities.doGet(urlFormat, inStream -> lazyInputStream.set(inStream), "image/png");
		return lazyInputStream.get();
	}
}
