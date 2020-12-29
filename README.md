# Java library for MCHeads API.
with this library you can use 99% of the mcheads web api: isometric, face, body, player information and *MHF* heads.

# How to Use it

```java

/* MHF Facing */
IEntity herobrine = MCHeadsAPI.getEntity(MHF.MHF_HEROBRINE, Options.FULL);

System.out.println(herobrine.getName());
System.out.println(herobrine.getUserId());
System.out.println(Arrays.toString(herobrine.getNameHistory().getAllNames()));

byte[] face = herobrine.getDefaultFacing(); /*the raw byte array of the image*/


/* Player isometric head */
IEntity herobrine = MCHeadsAPI.getEntity(MHF.MHF_HEROBRINE, Options.FULL);

System.out.println(herobrine.getName());
System.out.println(herobrine.getUserId());
System.out.println(Arrays.toString(herobrine.getNameHistory().getAllNames()));

byte[] isometricHead = herobrine.getIsometric(StyleOption.HEAD, 32); /*the raw byte array of the image*/


```
All functions available:

![list](https://i.imgur.com/KNJvhSv.png)

# Updates

Alpha version, Several bugs need to bug fixed yet.
Several bugs are in there, Use on your own.

**Not documented yet**

![mcphoto](https://i.imgur.com/qrQ6KsZ.png)
