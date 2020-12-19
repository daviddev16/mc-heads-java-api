package net.mcheads.internal;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

import net.mcheads.api.history.INameHistory;
import net.mcheads.api.history.NameChangeProperty;

public class NameHistoryImpl implements INameHistory {

	private final List<NameChangeProperty> nameChangeHistory;

	public NameHistoryImpl() {
		nameChangeHistory = new ArrayList<NameChangeProperty>();
	}

	public void retrieveList(JSONArray array) {
		
		getNameChangesHistory().clear();
		
		for(int i = 0; i < array.length(); i++) {
			JSONObject nameChange = array.getJSONObject(i);
			long date = (nameChange.has("date")) ? nameChange.getLong("date") : -1L;
			getNameChangesHistory().add(new NameChangeProperty(nameChange.getString("name"), date));
		}
		
	}

	public List<NameChangeProperty> getNameChangesHistory() {
		return nameChangeHistory;
	}


}
