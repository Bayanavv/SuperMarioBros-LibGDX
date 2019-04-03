package com.bayanav.mariobros.actors;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.CircleShape;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.World;
import com.bayanav.mariobros.manager.GameManager;
import com.bayanav.mariobros.screens.PlayScreen;

public class Mario extends RigidBody {
    public World world;
    public Body b2body;

    public Mario(PlayScreen playScreen, float x, float y){
       super(playScreen, x,y);
    }

    @Override
    protected void defBody() {

    }


}
