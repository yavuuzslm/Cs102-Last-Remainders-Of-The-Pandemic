package com.cs102.game;

import com.badlogic.gdx.backends.lwjgl3.Lwjgl3Application;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3ApplicationConfiguration;
import com.cs102.game.LastRemaindersOfThePandemic;

// Please note that on macOS your application needs to be started with the -XstartOnFirstThread JVM argument
public class DesktopLauncher {
	public static void main (String[] arg) {
		Lwjgl3ApplicationConfiguration config = new Lwjgl3ApplicationConfiguration();
		config.setForegroundFPS(60);
		config.setTitle("Last Remainders of the Pandemic");
		config.setWindowedMode(1280, 720);
		new Lwjgl3Application(new LastRemaindersOfThePandemic(), config);
	}
}
