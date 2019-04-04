package com.bayanav.mariobros.actors.effects;

import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.bayanav.mariobros.actors.RigidBody;
import com.bayanav.mariobros.screens.PlayScreen;

public abstract class Effect extends RigidBody {

    protected TextureAtlas textureAtlas;

    public Effect(PlayScreen playScreen, float x, float y) {
        super(playScreen, x, y);
        this.textureAtlas = playScreen.getTextureAtlas();

    }
}
