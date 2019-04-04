package com.bayanav.mariobros.utils;

import com.badlogic.gdx.maps.MapLayer;
import com.badlogic.gdx.maps.MapObject;
import com.badlogic.gdx.maps.objects.RectangleMapObject;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.objects.TiledMapTileMapObject;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.utils.Array;
import com.bayanav.mariobros.actors.enemies.Enemy;
import com.bayanav.mariobros.actors.enemies.Goomba;
import com.bayanav.mariobros.actors.enemies.Koopa;
import com.bayanav.mariobros.actors.maptiles.Brick;
import com.bayanav.mariobros.actors.maptiles.CoinBlock;
import com.bayanav.mariobros.actors.maptiles.Flagpole;
import com.bayanav.mariobros.actors.maptiles.InteractiveTileObject;
import com.bayanav.mariobros.actors.maptiles.Pipe;
import com.bayanav.mariobros.actors.maptiles.Rock;
import com.bayanav.mariobros.manager.GameManager;
import com.bayanav.mariobros.screens.PlayScreen;

public class WorldCreator {

    private Array<InteractiveTileObject> mapTileObjects;
    private Array<Enemy> enemies;

    private Vector2 startPosition;
    private Vector2 flagPosition;


    public WorldCreator(PlayScreen playScreen, TiledMap map) {

        flagPosition = new Vector2();
        startPosition = new Vector2(64.0f, 64.0f);

        mapTileObjects = new Array<InteractiveTileObject>();
        enemies = new Array<Enemy>();

        MapLayer mapLayer = map.getLayers().get("Rocks");
        if (mapLayer != null) {
            for (MapObject mapObject : mapLayer.getObjects()) {
                float x = ((TiledMapTileMapObject) mapObject).getX();
                float y = ((TiledMapTileMapObject) mapObject).getY();

                mapTileObjects.add(new Rock(playScreen, (x + 8) / GameManager.PPM, (y + 8) / GameManager.PPM, (TiledMapTileMapObject) mapObject));
            }
        }

        mapLayer = map.getLayers().get("MetalBlocks");
        if (mapLayer != null) {
            for (MapObject mapObject : mapLayer.getObjects()) {
                float x = ((TiledMapTileMapObject) mapObject).getX();
                float y = ((TiledMapTileMapObject) mapObject).getY();

                mapTileObjects.add(new Pipe(playScreen, (x + 8) / GameManager.PPM, (y + 8) / GameManager.PPM, (TiledMapTileMapObject) mapObject));
            }
        }

        mapLayer = map.getLayers().get("Pipes");
        if (mapLayer != null) {
            for (MapObject mapObject : mapLayer.getObjects()) {
                float x = ((TiledMapTileMapObject) mapObject).getX();
                float y = ((TiledMapTileMapObject) mapObject).getY();

                mapTileObjects.add(new Pipe(playScreen, (x + 8) / GameManager.PPM, (y + 8) / GameManager.PPM, (TiledMapTileMapObject) mapObject));
            }
        }

        mapLayer = map.getLayers().get("Bricks");
        if (mapLayer != null) {
            for (MapObject mapObject : mapLayer.getObjects()) {
                float x = ((TiledMapTileMapObject) mapObject).getX();
                float y = ((TiledMapTileMapObject) mapObject).getY();

                mapTileObjects.add(new Brick(playScreen, (x + 8) / GameManager.PPM, (y + 8) / GameManager.PPM, (TiledMapTileMapObject) mapObject));
            }
        }

        mapLayer = map.getLayers().get("CoinBlocks");
        if (mapLayer != null) {
            for (MapObject mapObject : mapLayer.getObjects()) {
                float x = ((TiledMapTileMapObject) mapObject).getX();
                float y = ((TiledMapTileMapObject) mapObject).getY();

                mapTileObjects.add(new CoinBlock(playScreen, (x + 8) / GameManager.PPM, (y + 8) / GameManager.PPM, (TiledMapTileMapObject) mapObject));
            }
        }

        mapLayer = map.getLayers().get("Goombas");
        if (mapLayer != null) {
            for (MapObject mapObject : mapLayer.getObjects()) {
                float x = ((TiledMapTileMapObject) mapObject).getX();
                float y = ((TiledMapTileMapObject) mapObject).getY();

                enemies.add(new Goomba(playScreen, (x + 8) / GameManager.PPM, (y + 8) / GameManager.PPM));
            }
        }

        mapLayer = map.getLayers().get("Koopas");
        if (mapLayer != null) {
            for (MapObject mapObject : mapLayer.getObjects()) {
                float x = ((TiledMapTileMapObject) mapObject).getX();
                float y = ((TiledMapTileMapObject) mapObject).getY();

                enemies.add(new Koopa(playScreen, (x + 8) / GameManager.PPM, (y + 8) / GameManager.PPM));
            }
        }

        mapLayer = map.getLayers().get("Flagpole");
        if (mapLayer != null) {
            for (MapObject mapObject : mapLayer.getObjects()) {
                float x = ((TiledMapTileMapObject) mapObject).getX();
                float y = ((TiledMapTileMapObject) mapObject).getY();

                mapTileObjects.add(new Flagpole(playScreen, (x + 8) / GameManager.PPM, (y + 8) / GameManager.PPM, (TiledMapTileMapObject) mapObject));
            }
        }


        flagPosition = new Vector2();

        mapLayer = map.getLayers().get("Flag");
        if (mapLayer != null) {
            if (mapLayer.getObjects().getCount() > 0) {
                float x = ((TiledMapTileMapObject) mapLayer.getObjects().get(0)).getX();
                float y = ((TiledMapTileMapObject) mapLayer.getObjects().get(0)).getY();

                flagPosition = new Vector2(x, y);
            }
        }


        startPosition = new Vector2(64.0f, 64.0f);

        mapLayer = map.getLayers().get("Start");
        if (mapLayer != null) {
            for (MapObject mapObject : mapLayer.getObjects()) {
                float x = ((TiledMapTileMapObject) mapLayer.getObjects().get(0)).getX();
                float y = ((TiledMapTileMapObject) mapLayer.getObjects().get(0)).getY();


            }
        }
    }

    public Vector2 getStartPosition() {
        return startPosition;
    }

    public Vector2 getFlagPosition() {
        return flagPosition;
    }

    public Array<InteractiveTileObject> getMapTileObject() {
        return mapTileObjects;
    }

    public Array<Enemy> getEnemies() {
        return enemies;
    }
}
