package com.bayanav.mariobros.actors.maptiles;

import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.physics.box2d.World;
import com.bayanav.mariobros.manager.GameManager;

public class CoinBlock extends InteractiveTileObject {
    public CoinBlock(World world, TiledMap map, Rectangle bounds) {
        super(world, map, bounds);

        BodyDef bdef = new BodyDef();
        FixtureDef fdef = new FixtureDef();
        PolygonShape shape = new PolygonShape();

        bdef.type = BodyDef.BodyType.StaticBody;
        bdef.position.set((bounds.getX() + bounds.getWidth() / 2) / GameManager.PPM, (bounds.getY() + bounds.getHeight() / 2) / GameManager.PPM);
        body = world.createBody(bdef);
        shape.setAsBox(bounds.getWidth() / 2 / GameManager.PPM,bounds.getHeight() / 2 / GameManager.PPM);
        fdef.shape = shape;
        body.createFixture(fdef);
    }
}
