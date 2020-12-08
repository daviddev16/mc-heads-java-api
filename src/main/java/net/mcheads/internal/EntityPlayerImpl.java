package net.mcheads.internal;

import java.io.IOException;
import java.io.InputStream;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.google.common.io.ByteStreams;

import net.mcheads.api.entities.IEntityPlayer;
import net.mcheads.api.history.INameHistory;
import net.mcheads.api.style.StyleOption;
import net.mcheads.internal.style.StyleRoutes;
import net.mcheads.internal.utils.Utilities;

public class EntityPlayerImpl implements IEntityPlayer {

	private static final String MOJANG_PLAYER_PROFILE = "https://mc-heads.net/minecraft/profile/%s";

	private String name;
	private String id;

	private INameHistory nameHistory;
	
	public EntityPlayerImpl(String id) {
		retrieveInfos(id);
	}

	private synchronized void retrieveInfos(String id) {
		
		try {
			
			nameHistory = new NameHistoryImpl();
			String url = String.format(MOJANG_PLAYER_PROFILE, id);
			JSONObject profile = new JSONObject(Utilities.readURL(url));
			JSONArray nameHistoryArray = profile.getJSONArray("name_history");

			this.id = id;
			name = profile.getString("name");
			((NameHistoryImpl)nameHistory).retrieveList(nameHistoryArray);

		} catch (JSONException | IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public String getUserId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public INameHistory getNameHistory() {
		return nameHistory;
	}

	public boolean isMHF() {
		return false;
	}

	public synchronized byte[] getFacing(StyleOption option, int size, boolean nohelm) {
		
		InputStream in = StyleRoutes.FACING_ROUTE.get(this, option, size, nohelm);
		
		if(in != null) {
			try {
				return ByteStreams.toByteArray(in);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		return null;
	}

}
