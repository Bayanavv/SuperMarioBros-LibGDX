package com.bayanav.mariobros;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.bayanav.mariobros.screens.PlayScreen;

public class MarioBros extends Game {
	/**
	 spriteBatch is basically a container that holds all of our images or textures and stuff like
	that in when we are ready to render them to the screen the sprite batch basically spills them
	out and says okay we are going to draw everything.

	 spriteBatch is very memory intensive so we only have to have one in our game we don't want
	 to be creating new spriteBatches all the time
	 */
	public SpriteBatch batch;
	
	@Override
	public void create () {
		batch = new SpriteBatch();
		setScreen(new PlayScreen(this));//passing the game it self

	}


	@Override
	public void render() {
		super.render();
	}
}
