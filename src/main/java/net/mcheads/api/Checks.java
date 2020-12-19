package net.mcheads.api;

public class Checks {

	public static boolean checkIsometricSize(int size) {
		return (size >= Constants.ISOMETRIC_MIN_SIZE && size <= Constants.MAX_SIZE);
	}
	public static boolean checkAvatarSize(int size) {
		return (size >= Constants.AVATAR_MIN_SIZE && size <= Constants.MAX_SIZE);
	}
}
