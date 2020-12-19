package net.mcheads.internal;

import java.util.Iterator;
import java.util.Vector;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import net.mcheads.api.history.INameHistory;
import net.mcheads.api.history.NameChangeProperty;

public class NameHistoryImpl implements INameHistory {

	private final Vector<NameChangeProperty> nameChangeHistory;

	public NameHistoryImpl() {
		nameChangeHistory = new Vector<NameChangeProperty>();
	}
	
	public void retrieve(JsonArray array) {
		getNameChangesHistory().clear();
		Iterator<JsonElement> arrayIterator = array.iterator();
		while (arrayIterator.hasNext()) {
			JsonObject nameChange = (JsonObject) arrayIterator.next();
			getNameChangesHistory().add(new NameChangeProperty(nameChange.get("name").getAsString(),
					(nameChange.has("date")) ? nameChange.get("data").getAsLong() : -1L));
		}
	}
	
	public Vector<NameChangeProperty> getNameChangesHistory() {
		return nameChangeHistory;
	}

}
