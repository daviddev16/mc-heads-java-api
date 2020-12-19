package net.mcheads.internal;

public final class CacheOptions {

	private boolean retrieveNameHistory;
	
	private boolean retrieveMonjangData;

	public CacheOptions(boolean retrieveNameHistory, boolean retrieveMonjangData) {
		this.retrieveNameHistory = retrieveNameHistory;
		this.retrieveMonjangData = retrieveMonjangData;
	}

	public boolean canRetrieveNameHistory() {
		return retrieveNameHistory;
	}

	public boolean canRetrieveMonjangData() {
		return retrieveMonjangData;
	}
	
	public static CacheOptions createOptions(boolean retrieveNameHistory, boolean retrieveMonjangData) {
		return new CacheOptions(retrieveNameHistory, retrieveMonjangData);
	}

	
	
	
}
