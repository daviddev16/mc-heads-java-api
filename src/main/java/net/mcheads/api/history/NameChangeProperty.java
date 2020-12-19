package net.mcheads.api.history;

public final class NameChangeProperty {

	private String name;
	private long date;
	
	public NameChangeProperty(String name, long date) {
		this.name = name;
		this.date = date;
	}

	public String getName() {
		return name;
	}

	public long getDate() {
		return date;
	}
	
}
