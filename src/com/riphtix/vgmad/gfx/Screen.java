package com.riphtix.vgmad.gfx;

import com.riphtix.vgmad.level.tile.Tile;

import java.util.Random;

public class Screen {
	public int width;
	public int height;

	private final int MAP_WIDTH = 64;
	private final int MAP_HEIGHT = 64;
	private final int MAP_SIZE = MAP_WIDTH * MAP_HEIGHT;
	private final int TILE_WIDTH = 16;
	private final int TILE_WIDTH_SHIFT = 4;
	private final int TILE_HEIGHT = 16;
	private final int TILE_HEIGHT_SHIFT = 4;
	private final int TILE_SIZE = TILE_WIDTH * TILE_HEIGHT;

	public int xOffset;
	public int yOffset;

	public int[] pixels;
	public int[] tiles = new int[MAP_SIZE];

	private Random random = new Random();

	public Screen(int width, int height) {
		this.width = width;
		this.height = height;

		pixels = new int[width * height];

		for (int i = 0; i < MAP_SIZE; i++) {
			//use tiles[i] = 0x(hex code) to set a specific color
			tiles[i] = random.nextInt(0xffffff);
		}
		//tiles[0] = 0x000000;
	}

	public void clear() {
		for (int i = 0; i < pixels.length; i++) {
			pixels[i] = 0;
		}
	}

	public void renderTile(int xp, int yp, Tile tile) {
		xp -= xOffset;
		yp -= yOffset;
		for (int y = 0; y < tile.sprite.SIZE; y++) {
			int ya = y + yp;
			for (int x = 0; x < tile.sprite.SIZE; x++) {
				int xa = x + xp;
				if (xa < 0 || xa >= width || ya < 0 || ya >= height) break;
				pixels[xa + ya * width] = tile.sprite.pixels[x + y * tile.sprite.SIZE];
			}
		}
	}

	public void setOffset(int xOffset, int yOffset){
		this.xOffset = xOffset;
		this.yOffset = yOffset;
	}
}