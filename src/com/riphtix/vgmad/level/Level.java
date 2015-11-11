package com.riphtix.vgmad.level;

import com.riphtix.vgmad.gfx.Screen;
import com.riphtix.vgmad.level.tile.Tile;

public class Level {

	protected int width;
	protected int height;
	protected int[] tilesInt;
	protected int[] tiles;

	public Level(int width, int height) {
		this.width = width;
		this.height = height;
		tilesInt = new int[width * height];
		generateLevel();
	}

	public Level(String path) {
		loadLevel(path);
		generateLevel();
	}

	protected void generateLevel() {

	}

	protected void loadLevel(String path) {

	}

	public void tick() {//public void update()

	}

	private void time() {

	}

	public void render(int xScroll, int yScroll, Screen screen) {
		screen.setOffset(xScroll, yScroll);
		int x0 = xScroll >> 4;
		int x1 = (xScroll + screen.width + 16) >> 4;
		int y0 = yScroll >> 4;
		int y1 = (yScroll + screen.height + 16) >> 4;

		for (int y = y0; y < y1; y++) {
			for (int x = x0; x < x1; x++) {
				getTile(x, y).render(x, y, screen);
			}
		}
	}

	//Grass = 0xff267f00
	//Dirt = 0xff7F3300
	//Stone = 0xff808080
	//Stone Brick Wall = 0xff404040
	//Wooden Planks = 0xffd3783b
	public Tile getTile(int x, int y) {
		if (x < 0 || y < 0 || x >= width || y >= height) return Tile.voidTile;
		if (tiles[x + y * width] == 0xff267f00) return Tile.grassTile;
		if (tiles[x + y * width] == 0xff7f3300) return Tile.dirtTile;
		if (tiles[x + y * width] == 0xff808080) return Tile.stoneTile;
		return Tile.voidTile;
	}
}
