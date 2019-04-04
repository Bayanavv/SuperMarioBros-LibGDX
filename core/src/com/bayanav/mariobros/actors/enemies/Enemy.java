package com.bayanav.mariobros.actors.enemies;

import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.bayanav.mariobros.actors.Mario;
import com.bayanav.mariobros.actors.RigidBody;
import com.bayanav.mariobros.screens.PlayScreen;

public abstract class Enemy extends RigidBody {

    protected TextureAtlas textureAtlas;

    protected boolean active = false;

    public Enemy(PlayScreen playScreen, float x, float y) {
        super(playScreen, x, y);
        this.textureAtlas = playScreen.getTextureAtlas();
    }

    public abstract void getDamage(int damage);

    public void interact(Mario mario) {

    }

}
