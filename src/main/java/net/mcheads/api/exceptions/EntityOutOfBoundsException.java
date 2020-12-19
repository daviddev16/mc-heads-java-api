package net.mcheads.api.exceptions;

public class EntityOutOfBoundsException extends Exception {

	private static final long serialVersionUID = 6488771785060871625L;

	private static final String bounds = "[min=%d, max=%d]";
	
	public EntityOutOfBoundsException(String message, int minSize, int maxSize) {
		super(message + String.format(bounds, minSize, maxSize));
	}
	
	
}
