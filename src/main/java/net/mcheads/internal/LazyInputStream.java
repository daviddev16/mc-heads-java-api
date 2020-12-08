package net.mcheads.internal;

import java.io.InputStream;

public class LazyInputStream {
	
	private volatile InputStream inputStream;
	
	public LazyInputStream(InputStream stream) {
		this.inputStream = stream;
	}
	
	public final void set(InputStream inputStream) {
		this.inputStream = inputStream;
	}
	
	public final InputStream get() {
		return this.inputStream;
	}

}
