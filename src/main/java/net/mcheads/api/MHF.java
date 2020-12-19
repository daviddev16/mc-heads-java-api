package net.mcheads.api;

/**
 * MHF
 *  
 * Mojang has created several accounts with guaranteed static
 * skins to help map makers visualize their creations with said account's heads.
 * This endpoint attempts to list all of the known and verified MHF UUIDs and their MHF.
 *
 */
public final class MHF {

	public static final String MHF_NAME_PREFIX = "MHF_";
	
	public static final MHF MHF_CHEST = new MHF("73d4e0683a6d4c8b8f853323546955c4");
	public static final MHF MHF_WITHER = new MHF("39af684468094d2f8ba47e92d087be18");
	public static final MHF MHF_PRESENT2 = new MHF("f1eb7cade2c04e9e8aad1eae21d5fd95");
	public static final MHF MHF_BLAZE = new MHF("4c38ed11596a4fd4ab1d26f386c1cbac");
	public static final MHF MHF_MUSHROOMCOW = new MHF("a46817d673c54f3fb712af6b3ff47b96");
	public static final MHF MHF_GHAST = new MHF("063085a6797f4785be1a21cd7580f752");
	public static final MHF MHF_SKELETON = new MHF("a3f427a818c549c5a4fb64c6e0e1e0a8");
	public static final MHF MHF_COW = new MHF("f159b274c22e4340b7c152abde147713");
	public static final MHF MHF_VEX = new MHF("f5f20997217f44268ab9c6db6cce023f");
	public static final MHF MHF_CREEPER = new MHF("057b1c4713214863a6fe8887f9ec265f");
	public static final MHF MHF_APPLE = new MHF("57f8712e1ccf4da8b08faddae6642c3d");
	public static final MHF MHF_ALEX = new MHF("6ab4317889fd490597f60f67d9d76fd9");
	public static final MHF MHF_COCONUTB = new MHF("62efa973f6264092aede57ffbe84ff2b");
	public static final MHF MHF_SPIDER = new MHF("5ad55f3441b64bd29c3218983c635936");
	public static final MHF MHF_CAKE = new MHF("afb489c49fc848a498f2dd7bea414c9a");
	public static final MHF MHF_ARROWDOWN = new MHF("68f59b9b5b0b4b05a9f2e1d1405aa348");
	public static final MHF MHF_MELON = new MHF("1c7d978447ea4bf3bc23acf260b436e6");
	public static final MHF MHF_ARROWUP = new MHF("fef039efe6cd49879c8426a3e6134277");
	public static final MHF MHF_TNT2 = new MHF("55e73380a9734a529bb51efa5256125c");
	public static final MHF MHF_GOLEM = new MHF("757f90b223444b8d8dac824232e2cece");
	public static final MHF MHF_WITCH = new MHF("fef85c492fdf47f89132552046243223");
	public static final MHF MHF_WSKELETON = new MHF("7ed571a59fb8416c8b9dfb2f446ab5b2");
	public static final MHF MHF_OCELOT = new MHF("1bee9df54f7142a2bf52d97970d3fea3");
	public static final MHF MHF_ARROWLEFT = new MHF("a68f0b648d144000a95f4b9ba14f8df9");
	public static final MHF MHF_PRESENT1 = new MHF("156b251b12e04829a130a61b53ba7720");
	public static final MHF MHF_SHEEP = new MHF("dfaad5514e7e45a1a6f7c6fc5ec823ac");
	public static final MHF MHF_PUMPKIN = new MHF("f44d355bb6ae4ba88e62ae6441854785");
	public static final MHF MHF_ARROWRIGHT = new MHF("50c8510b5ea04d60be9a7d542d6cd156");
	public static final MHF MHF_FACEBOOK = new MHF("90e547bf8bbc4a3a86629055d9746077");
	public static final MHF MHF_OAKLOG = new MHF("e224e5ece2994005ae223b0f77a57714");
	public static final MHF MHF_COCONUTG = new MHF("74556fea28ed44588db29a8220da0c12");
	public static final MHF MHF_PIG = new MHF("8b57078bf1bd45df83c4d88d16768fbe");
	public static final MHF MHF_STRAY = new MHF("ed33403bbe7f4a38915cabea93ebc9bc");
	public static final MHF MHF_EXCLAMATION = new MHF("d3c47f6fae3a45c1ad7ce2c762b03ae6");
	public static final MHF MHF_WOLF = new MHF("8d2d1d6d80344c89bd86809a31fd5193");
	public static final MHF MHF_TNT = new MHF("d43af93cc3304a3dbab8ee74234a011a");
	public static final MHF MHF_HEROBRINE = new MHF("9586e5ab157a4658ad80b07552a9ca63");
	public static final MHF MHF_ZOMBIE = new MHF("daca2c3d719b41f5b624e4039e6c04bd");
	public static final MHF MHF_CHICKEN = new MHF("92deafa9430742d9b00388601598d6c0");
	public static final MHF MHF_STEVE = new MHF("c06f89064c8a49119c29ea1dbd1aab82");
	public static final MHF MHF_SHULKER = new MHF("160f7d8ac6b04fc889259e9d6c9c57d5");
	public static final MHF MHF_CAVESPIDER = new MHF("cab28771f0cd4fe7b12902c69eba79a5");
	public static final MHF MHF_ILLAGER = new MHF("d91da370bbfe421fab92bd327b1d67d6");
	public static final MHF MHF_SQUID = new MHF("72e64683e3134c36a408c66b64e94af5");
	public static final MHF MHF_PIGZOMBIE = new MHF("18a2bb50334a408491842c380251a24b");
	public static final MHF MHF_QUESTION = new MHF("606e2ff0ed7748429d6ce1d3321c7838");
	public static final MHF MHF_LAVASLIME = new MHF("0972bdd14b8649fb9ecca353f8491a51");
	public static final MHF MHF_SLIME = new MHF("870aba9340e848b389c532ece00d6630");
	public static final MHF MHF_CACTUS = new MHF("1d9048dbe8364b9aa10855014922f1ae");
	public static final MHF MHF_VILLAGER = new MHF("bd482739767c45dca1f8c33c40530952");
	public static final MHF MHF_ENDERMAN = new MHF("40ffb37212f64678b3f22176bf56dd4b");

	private String mhfId;
	
	public MHF(String mhfId) {
		this.mhfId = mhfId;
	}
	
	public String getMhfId() {
		return mhfId;
	}
	

}
