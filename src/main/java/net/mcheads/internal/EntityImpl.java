package net.mcheads.internal;

import java.io.IOException;
import java.io.InputStream;
import com.google.common.io.ByteStreams;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
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

public final class EntityImpl implements IEntity {

	private static final String MOJANG_PLAYER_PROFILE = "https://mc-heads.net/minecraft/profile/%s";

	private INameHistory nameHistory;
	private UserData userData;
	private String nameOrId;

	public EntityImpl(String nameOrId, CacheOptions cacheOptions) {
		initEntity(nameOrId, cacheOptions);
	}

	public EntityImpl(MHF mhf, CacheOptions cacheOptions) {
		initEntity(mhf.getMhfId(), cacheOptions);
	}

	private void initEntity(String nameOrId, CacheOptions cacheOptions) {
		this.nameOrId = nameOrId;
		if (!cacheOptions.canRetrieveMonjangData() && !cacheOptions.canRetrieveNameHistory()) {
			return;
		}
		Utilities.doJsonGet(String.format(MOJANG_PLAYER_PROFILE, nameOrId), json -> {
			if (json instanceof JsonObject) {
				if (cacheOptions.canRetrieveNameHistory()) {
					JsonArray nameHistoryArray = ((JsonObject) json).getAsJsonArray("name_history");
					nameHistory = new NameHistoryImpl();
					((NameHistoryImpl) nameHistory).retrieve(nameHistoryArray);
				}
				userData = new UserData(((JsonObject) json).get("name").getAsString(),
						((JsonObject) json).get("id").getAsString());
			}
		});
		if (userData != null) {
			this.nameOrId = userData.getId();
		}
	}

	public synchronized byte[] getFacing(StyleOption option, int size, boolean nohelm)
			throws EntityOutOfBoundsException {

		if (!Checks.checkIsometricSize(size)) {
			throw new EntityOutOfBoundsException("Facing size out of bounds.", Constants.AVATAR_MIN_SIZE,
					Constants.MAX_SIZE);
		}
		return internalFacing(option, size, nohelm);
	}

	public byte[] getFacing(StyleOption option, int size) throws EntityOutOfBoundsException {

		if (!Checks.checkIsometricSize(size)) {
			throw new EntityOutOfBoundsException("Facing size out of bounds.", Constants.AVATAR_MIN_SIZE,
					Constants.MAX_SIZE);
		}
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

	public byte[] getIsometric(StyleOption option, int size) throws EntityOutOfBoundsException {

		if (!Checks.checkIsometricSize(size)) {
			throw new EntityOutOfBoundsException("Isometric size out of bounds.", Constants.ISOMETRIC_MIN_SIZE,
					Constants.MAX_SIZE);
		}
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
		return convertToByteArray(source == Source.FACING ? StyleRoutes.FACING_ROUTE.get(this, option, size, nohelm)
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

	public INameHistory getNameHistory() {
		if (nameHistory == null)
			throw new NullPointerException("Names history was not requested.");
		return nameHistory;
	}

	public String getUserId() {
		return (userData != null) ? userData.getId() : null;
	}

	public String getName() {
		return (userData != null) ? userData.getName() : null;
	}

	public boolean isMHF() {
		return getNameOrId().startsWith(MHF.MHF_NAME_PREFIX);
	}

	public String getNameOrId() {
		return nameOrId;
	}
}
