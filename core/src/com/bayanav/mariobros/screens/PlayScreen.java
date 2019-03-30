package com.bayanav.mariobros.screens;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
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

    public PlayScreen(MarioBros game) {
        this.game = game;

        gameCam = new OrthographicCamera();
        gamePort = new FitViewport(GameManager.V_WIDTH,GameManager.V_HEIGHT,gameCam);
        hub = new Hub(game.batch);


    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0,0,0,1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        game.batch.setProjectionMatrix(hub.stage.getCamera().combined );//what gonna be shown via our camera
        hub.stage.draw();

        game.batch.setProjectionMatrix(gameCam.combined);//telling our game batch to recognize where the camera is in our game world and only render what the camera can see
        game.batch.begin();

        game.batch.end();

    }

    @Override
    // when the screen size changes the viewPort gets adjusted to know what the actual screen size is
    public void resize(int width, int height) {
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
