package com.bayanav.mariobros.actors.maptiles;


import com.badlogic.gdx.maps.tiled.objects.TiledMapTileMapObject;
import com.bayanav.mariobros.actors.RigidBody;
import com.bayanav.mariobros.manager.GameManager;
import com.bayanav.mariobros.screens.PlayScreen;

public abstract class InteractiveTileObject  extends RigidBody {

    protected TiledMapTileMapObject mapObject;

    public InteractiveTileObject(PlayScreen playScreen, float x, float y, TiledMapTileMapObject mapObject) {
        super(playScreen, x, y);

        this.mapObject = mapObject;



        float width = 16 / GameManager.PPM;
        float height = 16 / GameManager.PPM;

        setBounds(x - width / 2, y - height / 2, width, height);
    }

    @Override
    public void update(float delta) {

    }


}
