package net.mcheads.api;

import net.mcheads.api.exceptions.EntityOutOfBoundsException;

public class Checks {

	public static boolean checkIsometricSize(int size) {
		return (size >= Constants.ISOMETRIC_MIN_SIZE && size <= Constants.MAX_SIZE);
	}

	public static boolean checkAvatarSize(int size) {
		return (size >= Constants.AVATAR_MIN_SIZE && size <= Constants.MAX_SIZE);
	}

	public static Object throwEntityOutOfBounds(String name, int min, int max) {
		try {
			throw new EntityOutOfBoundsException(name, min, max);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
