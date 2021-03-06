package com.riphtix.vgmad.entity;

import com.riphtix.vgmad.entity.items.Item;
import com.riphtix.vgmad.entity.items.weapons.Weapon;
import com.riphtix.vgmad.gfx.Screen;
import com.riphtix.vgmad.gfx.Sprite;
import com.riphtix.vgmad.level.Level;
import com.riphtix.vgmad.level.tile.hitbox.ItemHitbox;
import com.riphtix.vgmad.level.tile.hitbox.MobHitbox;
import com.riphtix.vgmad.level.tile.hitbox.PlayerHitbox;
import com.riphtix.vgmad.level.tile.hitbox.ProjectileHitbox;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Entity {
	protected double x, y;
	protected Sprite sprite;
	protected int time;
	private boolean removed = false;
	protected static Level level;
	protected final Random random = new Random();
	public int range;
	public MobHitbox hitbox;
	public Weapon weapon;

	private List<Item> items = new ArrayList<Item>();

	public Entity() {

	}

	public Entity(int x, int y, Sprite sprite) {
		this.x = x;
		this.y = y;
		this.sprite = sprite;
	}

	public void tick() {//public void update()

	}

	public void render(Screen screen) {
		if (sprite != null) screen.renderSprite((int) x, (int) y, sprite, true);
	}

	public void remove() {
		//remove from level
		removed = true;
	}

	public double getX() {
		return x;
	}

	public double getY() {
		return y;
	}

	public boolean isRemoved() {
		return removed;
	}

	public void init(Level level) {
		this.level = level;
	}

	protected boolean mobHitboxCollision(MobHitbox mobHitbox, ProjectileHitbox projectileHitbox) {
		return projectileHitbox.intersects(mobHitbox);
	}

	protected boolean playerHitboxCollision(PlayerHitbox playerHitbox, ProjectileHitbox projectileHitbox) {
		return projectileHitbox.intersects(playerHitbox);
	}

	protected boolean itemCollision(ItemHitbox itemHitbox, PlayerHitbox playerHitbox){
		return playerHitbox.intersects(itemHitbox);
	}

	protected boolean isCollision(double xa, int leftXOffset, int rightXOffset, double ya, int topYOffset, int bottomYOffset) {
		boolean solid = false;
		int xt0 = hitboxX(xa, leftXOffset);
		int xt1 = hitboxX(xa, rightXOffset);
		int xt2 = hitboxX(xa, 0);
		int yt0 = hitboxY(ya, topYOffset);
		int yt1 = hitboxY(ya, bottomYOffset);
		int yt2 = hitboxY(ya, 0);
		for (int c = 0; c < 4; c++) {
			if (level.getTile(xt0, yt0).isSolid()
					|| level.getTile(xt0, yt1).isSolid()
					|| level.getTile(xt0, yt2).isSolid()
					|| level.getTile(xt1, yt0).isSolid()
					|| level.getTile(xt1, yt1).isSolid()
					|| level.getTile(xt1, yt2).isSolid()
					|| level.getTile(xt2, yt0).isSolid()
					|| level.getTile(xt2, yt1).isSolid()) {
				solid = true;
			}
		}
		return solid;
	}

	protected int hitboxX(double xa, int width) {
		int hor = 0;
		for (int c = 0; c < 4; c++) {
			double xt = ((x + xa) - c % 2 * 15 + width) / 16;
			hor = (int) Math.ceil(xt);
			if (c % 2 == 0) {
				hor = (int) Math.floor(xt);
			}
		}
		return hor;
	}


	protected int hitboxY(double ya, int height) {
		int vert = 0;
		for (int c = 0; c < 4; c++) {
			double yt = ((y + ya) - c / 2 * 15 + height) / 16;
			vert = (int) Math.ceil(yt);
			if (c / 2 == 0) {
				vert = (int) Math.floor(yt);
			}
		}
		return vert;
	}
}