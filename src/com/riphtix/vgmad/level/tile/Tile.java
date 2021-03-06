package com.riphtix.vgmad.level.tile;

import com.riphtix.vgmad.gfx.Screen;
import com.riphtix.vgmad.gfx.Sprite;

public class Tile {

	public Sprite sprite;
	public boolean locked;
	public int x, y;
	public Screen screen;

	public static Tile grassTile = new GrassTile(Sprite.grassSprite);
	public static Tile dirtTile = new DirtTile(Sprite.dirtSprite);
	public static Tile stoneWallTile = new StoneWallTile(Sprite.stoneWallSprite);
	public static Tile stoneBrickTile = new StoneBrickTile(Sprite.stoneBrickSprite);
	public static Tile woodenPlankTile = new WoodenPlankTile(Sprite.woodenPlankSprite);
	public static Tile ironGateLockedTile = new GateTile(Sprite.lockedGateSprite, true);
	public static Tile ironGateUnlockedTile = new GateTile(Sprite.unlockedGateSprite, false);
	public static Tile ironBarTile = new IronBarTile(Sprite.ironBarsSprite);
	public static Tile volcanicFloorTile = new VolcanicFloorTile(Sprite.volcanicFloorSprite);
	public static Tile lavaTile = new LavaTile(Sprite.lavaSprite);
	public static Tile volcanicBrickWallTile = new VolcanicBrickWallTile(Sprite.volcanicBrickWallSprite);
	public static Tile stoneFloorTile = new StoneFloorTile(Sprite.stoneFloorSprite);
	public static Tile voidTile = new VoidTile(Sprite.voidSprite);

	public static final int colorGrass = 0xff267f00;
	public static final int colorDirt = 0xff7F3300;
	public static final int colorStoneWall = 0xff808080;
	public static final int colorStoneBrick = 0xff404040;
	public static final int colorWoodenPlank = 0xffd3783b;
	public static final int colorIronGateLocked = 0xffa8a8a8;
	public static final int colorIronGateUnlocked = 0xff636363;
	public static final int colorIronBars = 0xff8c8c8c;
	public static final int colorVolcanicFloor = 0xff020202;
	public static final int colorLava = 0xffff6a00;
	public static final int colorVolcanicBrickWall = 0xff333333;
	public static final int colorStoneFloor = 0xffd3d3d3;

	public Tile(Sprite sprite) {
		this.sprite = sprite;
	}

	public void render(int x, int y, Screen screen) {
		this.x = x;
		this.y = y;
		this.screen = screen;
	}

	public void tick(){

	}

	public boolean isSolid() {//public boolean solid()
		return false;
	}

	public boolean hasBuff() {
		return false;
	}

	public boolean isDoorway(){
		return false;
	}

	public boolean isLocked(){
		return locked;
	}

	public void setLocked(boolean locked){
		this.locked = locked;
	}
}
