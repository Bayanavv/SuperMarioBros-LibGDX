package com.bayanav.mariobros.screens;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.maps.MapObject;
import com.badlogic.gdx.maps.objects.RectangleMapObject;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.bayanav.mariobros.MarioBros;
import com.bayanav.mariobros.hub.Hub;
import com.bayanav.mariobros.manager.GameManager;

public class PlayScreen implements Screen {
    private MarioBros game;
    private OrthographicCamera gameCam;//what follow along our game world and what the viewPort actually displays
    private Viewport gamePort;
    private Hub hub;

    //Tiled map variables
    private TmxMapLoader maploader;
    private TiledMap map;
    private OrthogonalTiledMapRenderer renderer;

    //Box2D variables
    private World world;
    private Box2DDebugRenderer b2dr;//gives us a graphical representation of our fixtures and bodies inside of our box2d world

    public PlayScreen(MarioBros game) {
        this.game = game;

        //create cam used to follow mario through cam world
        gameCam = new OrthographicCamera();

        //create FitViewport to maintain virtual aspect ratio despite
        gamePort = new FitViewport(GameManager.V_WIDTH,GameManager.V_HEIGHT,gameCam);

        //create our game HUB for scores/timers/level info
        hub = new Hub(game.batch);

        //lead our map and setup our map renderer
        maploader = new TmxMapLoader();
        map = maploader.load("maps/level1.tmx");
        renderer = new OrthogonalTiledMapRenderer(map);

        //initially set our gamCam to be centered correctly at the start of of
        gameCam.position.set(gamePort.getWorldWidth()/2,gamePort.getWorldHeight()/2,0);

        world = new World(new Vector2(0,0), true);//no gravity for now we change it in the feature, second parameter is do we want to sleep object that are at rest
        //box2d doesn't calculate inside its physics simulation bodies they are at rest so is save some time when it's doing those calculations , you can always wake up an object by commanding it to do any activity
        b2dr = new Box2DDebugRenderer();

        BodyDef bdef = new BodyDef();
        PolygonShape shape = new PolygonShape();
        FixtureDef fdef = new FixtureDef();//need have before you can create a fixture likewise you need to define that fixture first and then add it to the body
        Body body;

        //create ground bodies/ fixtures
        for (MapObject object : map.getLayers().get(2).getObjects().getByType(RectangleMapObject.class)){
            Rectangle rect = ((RectangleMapObject) object).getRectangle();

            bdef.type = BodyDef.BodyType.StaticBody;
            bdef.position.set(rect.getX() + rect.getWidth() / 2, rect.getY() + rect.getHeight() / 2);


            body = world.createBody(bdef);

            shape.setAsBox(rect.getWidth() / 2,rect.getHeight() / 2);
            fdef.shape = shape;
            body.createFixture(fdef);
        }

        for (MapObject object : map.getLayers().get(3).getObjects().getByType(RectangleMapObject.class)){
            Rectangle rect = ((RectangleMapObject) object).getRectangle();

            bdef.type = BodyDef.BodyType.StaticBody;
            bdef.position.set(rect.getX() + rect.getWidth() / 2, rect.getY() + rect.getHeight() / 2);


            body = world.createBody(bdef);

            shape.setAsBox(rect.getWidth() / 2,rect.getHeight() / 2);
            fdef.shape = shape;
            body.createFixture(fdef);
        }

        for (MapObject object : map.getLayers().get(4).getObjects().getByType(RectangleMapObject.class)){
            Rectangle rect = ((RectangleMapObject) object).getRectangle();

            bdef.type = BodyDef.BodyType.StaticBody;
            bdef.position.set(rect.getX() + rect.getWidth() / 2, rect.getY() + rect.getHeight() / 2);


            body = world.createBody(bdef);

            shape.setAsBox(rect.getWidth() / 2,rect.getHeight() / 2);
            fdef.shape = shape;
            body.createFixture(fdef);
        }

        for (MapObject object : map.getLayers().get(5).getObjects().getByType(RectangleMapObject.class)){
            Rectangle rect = ((RectangleMapObject) object).getRectangle();

            bdef.type = BodyDef.BodyType.StaticBody;
            bdef.position.set(rect.getX() + rect.getWidth() / 2, rect.getY() + rect.getHeight() / 2);


            body = world.createBody(bdef);

            shape.setAsBox(rect.getWidth() / 2,rect.getHeight() / 2);
            fdef.shape = shape;
            body.createFixture(fdef);
        }


    }

    @Override
    public void show() {

    }

    public void handleInput(float dt){
        if (Gdx.input.isTouched())
            gameCam.position.x += 100 * dt;
    }

    public void update(float dt){
        handleInput(dt);
        gameCam.update();
    }

    @Override
    public void render(float delta) {

        //separate our update logic from render
        update(delta);


        renderer.setView(gameCam);

        //clear the game screen with black
        Gdx.gl.glClearColor(0,0,0,1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        //render our game map
        renderer.render();

        //renderer our box2DDebugLines
        b2dr.render(world, gameCam.combined);

        //Set our batch to now draw what HUb camera sees.
        game.batch.setProjectionMatrix(hub.stage.getCamera().combined );//what gonna be shown via our camera
        hub.stage.draw();

        game.batch.setProjectionMatrix(gameCam.combined);//telling our game batch to recognize where the camera is in our game world and only render what the camera can see
        game.batch.begin();

        game.batch.end();

    }

    @Override
    // when the screen size changes the viewPort gets adjusted to know what the actual screen size is
    public void resize(int width, int height) {

        //updated our game viewPort
        gamePort.update(width,height);

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {

    }
}
