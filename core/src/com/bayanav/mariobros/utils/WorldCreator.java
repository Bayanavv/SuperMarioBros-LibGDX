package com.bayanav.mariobros.utils;

import com.badlogic.gdx.maps.MapObject;
import com.badlogic.gdx.maps.objects.RectangleMapObject;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.physics.box2d.World;
import com.bayanav.mariobros.actors.maptiles.Brick;
import com.bayanav.mariobros.actors.maptiles.CoinBlock;
import com.bayanav.mariobros.manager.GameManager;

public class WorldCreator {
    public WorldCreator(World world, TiledMap map) {
        BodyDef bdef = new BodyDef();
        PolygonShape shape = new PolygonShape();
        FixtureDef fdef = new FixtureDef();//need have before you can create a fixture likewise you need to define that fixture first and then add it to the body
        Body body;

        //create ground bodies/ fixtures
        for (MapObject object : map.getLayers().get(2).getObjects().getByType(RectangleMapObject.class)){
            Rectangle rect = ((RectangleMapObject) object).getRectangle();

            bdef.type = BodyDef.BodyType.StaticBody;
            bdef.position.set((rect.getX() + rect.getWidth() / 2) / GameManager.PPM, (rect.getY() + rect.getHeight() / 2) / GameManager.PPM);

            body = world.createBody(bdef);

            shape.setAsBox(rect.getWidth() / 2 / GameManager.PPM,rect.getHeight() / 2 / GameManager.PPM);
            fdef.shape = shape;
            body.createFixture(fdef);
        }


        for (MapObject object : map.getLayers().get(3).getObjects().getByType(RectangleMapObject.class)){
            Rectangle rect = ((RectangleMapObject) object).getRectangle();
            bdef.type = BodyDef.BodyType.StaticBody;
            bdef.position.set((rect.getX() + rect.getWidth() / 2) / GameManager.PPM, (rect.getY() + rect.getHeight() / 2) / GameManager.PPM);
            body = world.createBody(bdef);
            shape.setAsBox(rect.getWidth() / 2 / GameManager.PPM,rect.getHeight() / 2 / GameManager.PPM);
            fdef.shape = shape;
            body.createFixture(fdef);
        }

        for (MapObject object : map.getLayers().get(4).getObjects().getByType(RectangleMapObject.class)){
            Rectangle rect = ((RectangleMapObject) object).getRectangle();

            new CoinBlock(world, map, rect);

        }

        for (MapObject object : map.getLayers().get(5).getObjects().getByType(RectangleMapObject.class)){
            Rectangle rect = ((RectangleMapObject) object).getRectangle();

            new Brick(world, map, rect);
        }


    }
}
