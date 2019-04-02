package com.bayanav.mariobros.actors.maptiles;

import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapTile;
import com.badlogic.gdx.maps.tiled.objects.TiledMapTileMapObject;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.World;
import com.bayanav.mariobros.actors.RigidBody;
import com.bayanav.mariobros.manager.GameManager;
import com.bayanav.mariobros.screens.PlayScreen;

public abstract class InteractiveTileObject  extends RigidBody {

    protected TiledMapTileMapObject mapObject;

    public InteractiveTileObject(PlayScreen playScreen, float x, float y, TiledMapTileMapObject mapObject) {
        super(playScreen,x,y);

        this.mapObject = mapObject;

        float width = 16 / GameManager.PPM;
        float height = 16 / GameManager.PPM;

        //(x - width / 2, y - height / 2, width, height);
    }

    @Override
    public void update(float delta) {

    }


}
