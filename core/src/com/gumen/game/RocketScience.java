package com.gumen.game;

import com.badlogic.gdx.Game;

import screen.MenuScreen;


public class RocketScience extends Game {


	@Override
	public void create () {
		setScreen(new MenuScreen());
	}


}
