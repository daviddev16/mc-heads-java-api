# Java library for MCHeads API.
This library allows you to use all MCHeads API.

# How to Use it

```java

/* MHF Facing */
IEntity herobrine = MCHeadsAPI.getEntity(MHF.MHF_HEROBRINE, Options.FULL);

System.out.println(herobrine.getName());
System.out.println(herobrine.getUserId());
System.out.println(Arrays.toString(herobrine.getNameHistory().getAllNames()));

byte[] face = herobrine.getDefaultFacing();

/* Player isometric head */
IEntity herobrine = MCHeadsAPI.getEntity("Daviddev", Options.FULL);

System.out.println(herobrine.getName());
System.out.println(herobrine.getUserId());
System.out.println(Arrays.toString(herobrine.getNameHistory().getAllNames()));

byte[] isometricHead = herobrine.getIsometric(StyleOption.HEAD, 32);


```
All functions available:

![list](https://i.imgur.com/KNJvhSv.png)

# Updates

Alpha version, Several bugs need to bug fixed yet.
Several bugs are in there, Use on your own.

**Not documented yet**

![mcphoto](https://i.imgur.com/qrQ6KsZ.png)
