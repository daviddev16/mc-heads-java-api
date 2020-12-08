package net.mcheads.api.history;

public class NameChangeProperty {

	private String name;
	
	private long date;
	
	public NameChangeProperty(String name, long date) {
		this.name = name;
		this.date = date;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getDate() {
		return date;
	}

	public void setDate(long date) {
		this.date = date;
	}
	
	
	
}
