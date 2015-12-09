package com.riphtix.vgmad.util;

import com.riphtix.vgmad.gfx.Screen;

public class Debug {

	private Debug(){

	}

	public static void drawRect(Screen screen, int x, int y, int width, int height, boolean fixed){
		drawRect(screen, x, y, width, height, 0xff000000, fixed);
	}

	public static void drawRect(Screen screen, int x, int y, int width, int height, int color, boolean fixed){
		screen.drawRect(x, y, width, height, color, fixed);
	}
}
