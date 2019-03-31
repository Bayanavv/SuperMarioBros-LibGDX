package com.bayanav.mariobros.screens;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
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

    private TmxMapLoader maploader;
    private TiledMap map;
    private OrthogonalTiledMapRenderer renderer;

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
        gameCam.position.set(gamePort.getWorldWidth()/2,gamePort.getWorldHeight()/2,0);

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
        update(delta);
        renderer.setView(gameCam);

        //clear the game screen with black
        Gdx.gl.glClearColor(0,0,0,1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        renderer.render();

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
