package net.mcheads.internal;

import java.io.IOException;
import java.io.InputStream;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import com.google.common.io.ByteStreams;
import net.mcheads.api.Checks;
import net.mcheads.api.Constants;
import net.mcheads.api.IEntity;
import net.mcheads.api.MHF;
import net.mcheads.api.history.INameHistory;
import net.mcheads.api.style.miscs.Direction;
import net.mcheads.api.style.miscs.StyleOption;
import net.mcheads.internal.style.StyleRoutes;
import net.mcheads.internal.utils.Utilities;

public class EntityImpl implements IEntity {

	private static final String MOJANG_PLAYER_PROFILE = "https://mc-heads.net/minecraft/profile/%s";

	private String name;
	private String id;

	private INameHistory nameHistory;

	public EntityImpl(String nameOrId) {
		retrieveInfos(nameOrId);
	}

	public EntityImpl(MHF mhf) {
		retrieveInfos(mhf.getMhfId());
	}

	private synchronized void retrieveInfos(String nameOrId) {
		try {
			nameHistory = new NameHistoryImpl();
			String url = String.format(MOJANG_PLAYER_PROFILE, nameOrId);
			JSONObject profile = new JSONObject(Utilities.readURL(url));
			JSONArray nameHistoryArray = profile.getJSONArray("name_history");
			id = profile.getString("id");
			name = profile.getString("name");
			((NameHistoryImpl)nameHistory).retrieveList(nameHistoryArray);
		} catch (JSONException | IOException e) {
			e.printStackTrace();
		}
	}

	public synchronized byte[] getFacing(StyleOption option, int size, boolean nohelm) {
		if(!Checks.checkAvatarSize(size)) {
			Checks.throwEntityOutOfBounds("Facing size out of bounds.", Constants.AVATAR_MIN_SIZE, Constants.MAX_SIZE);
			return null;
		}
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

	public byte[] getFacing(StyleOption option, int size) {
		return getFacing(option, size, false);
	}

	public byte[] getFacing(StyleOption option) {
		return getFacing(option, Constants.AVATAR_MIN_SIZE, false);
	}

	public synchronized byte[] getIsometric(StyleOption option, int size, Direction direction) {
		if(!Checks.checkIsometricSize(size)) {
			Checks.throwEntityOutOfBounds("Isometric size out of bounds.", Constants.ISOMETRIC_MIN_SIZE, Constants.MAX_SIZE);
			return null;
		}
		InputStream in = StyleRoutes.ISOMETRIC_ROUTE.get(this, option, size, direction);
		if(in != null) {
			try {
				return ByteStreams.toByteArray(in);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	public byte[] getDefaultFacing() {
		return getFacing(StyleOption.HEAD, Constants.AVATAR_MIN_SIZE, false);
	}

	public byte[] getIsometric(StyleOption option, int size)  {
		return getIsometric(option, size, Direction.RIGHT);
	}

	public byte[] getIsometric(StyleOption option) {
		return getIsometric(option, Constants.ISOMETRIC_MIN_SIZE, Direction.RIGHT);
	}

	public byte[] getDefaultIsometric() {
		return getIsometric(StyleOption.BODY, Constants.ISOMETRIC_MIN_SIZE, Direction.RIGHT);
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
		return name.startsWith(MHF.MHF_NAME_PREFIX);
	}
}
