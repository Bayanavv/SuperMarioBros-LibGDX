package com.bayanav.mariobros.actors;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapTile;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.World;
import com.bayanav.mariobros.screens.PlayScreen;

public class RigidBody extends Sprite {
    protected PlayScreen playScreen;
    protected World world;
    protected Body body;

    protected boolean toBeDestroyed;
    protected boolean destroyed;

    public RigidBody(PlayScreen playScreen, float x, float y){
        this.playScreen = playScreen;
        this.world = playScreen.world;
        defBody();
    }


    protected void defBody() {

    }

    public void update(float delta) {

    }


}


