package net.mcheads.api.style;

public enum StyleOption {

	BODY("https://mc-heads.net/player/%s"),
	HEAD("https://mc-heads.net/avatar/%s/%d");
	
	private String url;
	
	private StyleOption(String url) {
		this.url = url;
	}
	
	public String getUrl() {
		return url;
	}
	
}
