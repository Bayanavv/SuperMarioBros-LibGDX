package com.bayanav.mariobros.hub;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.bayanav.mariobros.manager.GameManager;

public class Hub {
    /**
     * we are doing this because when our game world moves we want the head to stay the same so we are going to use
    a new camera and new viewPort specifically for our Hub so its stays locked there and only render that part of the screen
    and then the world can move around independently on its own

    stage: stage is basically an empty box, if we just tried to put widgets in there they fall they wouldn't
     have any kind of organization so in order to provide some sort of organization we are going to create a table
     inside of our stage then we can lay out that table in a way to organize our lables in a certain position inside
     of our stage
     */
    public Stage stage;
    private Viewport viewport;

    private Integer worldTimer;
    private float timeCount;
    private Integer score;

    //creating "widgets" which seen 2D called label
    Label countdownLabel;
    Label scoreLabel;
    Label timeLabel;
    Label levelLabel;
    Label worldLabel;
    Label marioLabel;

    //Constructor:
    public Hub(SpriteBatch sb){
        worldTimer = 300;
        timeCount = 0;
        score = 0;
        viewport = new FitViewport(GameManager.V_WIDTH,GameManager.V_HEIGHT,new OrthographicCamera());
        stage = new Stage(viewport, sb);

        Table table = new Table();//calling table

        //defaulting: line in the center top and width and height so right in the center of your stage.
        table.top();//now it will put it in the top of our stage.
        table.setFillParent(true);//now our table is the size of our stage.

        countdownLabel = new Label(String.format("%03d", worldTimer), new Label.LabelStyle(new BitmapFont(), Color.WHITE));
        scoreLabel = new Label(String.format("%06d", score), new Label.LabelStyle(new BitmapFont(), Color.WHITE));
        timeLabel = new Label("TIME", new Label.LabelStyle(new BitmapFont(), Color.WHITE));
        levelLabel = new Label("1-1", new Label.LabelStyle(new BitmapFont(), Color.WHITE));
        worldLabel = new Label("WORLD", new Label.LabelStyle(new BitmapFont(), Color.WHITE));
        marioLabel = new Label("MARIO", new Label.LabelStyle(new BitmapFont(), Color.WHITE));

        //adding the labels to the table.

        //expandX(). expend table length of our screen, but if we have multiple things in a single row they all share an equal portion of screen
        table.add(marioLabel).expandX().padTop(10);
        table.add(worldLabel).expandX().padTop(10);
        table.add(timeLabel).expandX().padTop(10);
        table.row();//going a row line down ending the privies and going down...
        table.add(scoreLabel).expandX();
        table.add(levelLabel).expandX();
        table.add(countdownLabel).expandX();

        stage.addActor(table);//adding the table to the stage
    }
}
