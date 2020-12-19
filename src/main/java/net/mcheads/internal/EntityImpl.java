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
import net.mcheads.api.exceptions.EntityOutOfBoundsException;
import net.mcheads.api.history.INameHistory;
import net.mcheads.api.style.options.Direction;
import net.mcheads.api.style.options.StyleOption;
import net.mcheads.internal.routes.StyleRoutes;
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
			((NameHistoryImpl) nameHistory).retrieveList(nameHistoryArray);
		} catch (JSONException | IOException e) {
			e.printStackTrace();
		}
	}

	public synchronized byte[] getFacing(StyleOption option, int size, boolean nohelm)
			throws EntityOutOfBoundsException {

		if (!Checks.checkIsometricSize(size)) {
			throw new EntityOutOfBoundsException("Isometric size out of bounds.", Constants.ISOMETRIC_MIN_SIZE,
					Constants.MAX_SIZE);
		}
		return internalFacing(option, size, nohelm);
	}

	public byte[] getFacing(StyleOption option, int size) {
		return internalFacing(option, size, false);
	}

	public byte[] getFacing(StyleOption option) {
		return internalFacing(option, Constants.AVATAR_MIN_SIZE, false);
	}

	public byte[] getDefaultFacing() {
		return internalFacing(StyleOption.HEAD, Constants.AVATAR_MIN_SIZE, false);
	}

	public synchronized byte[] getIsometric(StyleOption option, int size, Direction direction)
			throws EntityOutOfBoundsException {

		if (!Checks.checkIsometricSize(size)) {
			throw new EntityOutOfBoundsException("Isometric size out of bounds.", Constants.ISOMETRIC_MIN_SIZE,
					Constants.MAX_SIZE);
		}
		return internalIsometric(option, size, direction);
	}

	public byte[] getIsometric(StyleOption option, int size) {
		return internalIsometric(option, size, Direction.RIGHT);
	}

	public byte[] getIsometric(StyleOption option) {
		return internalIsometric(option, Constants.ISOMETRIC_MIN_SIZE, Direction.RIGHT);
	}

	public byte[] getDefaultIsometric() {
		return internalIsometric(StyleOption.BODY, Constants.ISOMETRIC_MIN_SIZE, Direction.RIGHT);
	}

	private byte[] internalFacing(StyleOption option, int size, boolean nohelm) {
		return internalRequest(Source.FACING, option, size, null, nohelm);
	}

	private byte[] internalIsometric(StyleOption option, int size, Direction direction) {
		return internalRequest(Source.ISOMETRIC, option, size, direction, false);
	}

	private byte[] internalRequest(Source source, StyleOption option, int size, Direction direction, boolean nohelm) {
		return convertToByteArray(source == Source.FACING 
				? StyleRoutes.FACING_ROUTE.get(this, option, size, nohelm)
				: StyleRoutes.ISOMETRIC_ROUTE.get(this, option, size, direction));
	}

	private byte[] convertToByteArray(InputStream inputStream) {
		try {
			return ByteStreams.toByteArray(inputStream);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
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
