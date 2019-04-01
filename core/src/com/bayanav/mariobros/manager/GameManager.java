package com.bayanav.mariobros.manager;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Disposable;

public class GameManager implements Disposable {

    public static GameManager instance;

    public static final float PPM = 16;

    public static final int WINDOW_WIDTH = Gdx.graphics.getWidth();
    public static final int WINDOW_HEIGHT = Gdx.graphics.getHeight();
    
    //these will be our virtual width and height
    public static final float V_WIDTH = 20.0f;
    public static final float V_HEIGHT = 15.0f;

    public static final Vector2 GRAVITY = new Vector2(0.0f, -9.8f * 4);

    public static final float STEP = 1 / 60.0f;

    public static final short NOTHING_BIT = 0;
    public static final short GROUND_BIT = 1;
    public static final short MARIO_BIT = 1 << 1;
    public static final short MARIO_HEAD_BIT = 1 << 2;
    public static final short ENEMY_LETHAL_BIT = 1 << 3;
    public static final short ENEMY_WEAKNESS_BIT = 1 << 4;
    public static final short ENEMY_INTERACT_BIT = 1 << 5;
    public static final short ITEM_BIT = 1 << 6;
    public static final short WEAPON_BIT = 1 << 7;
    public static final short FLAGPOLE_BIT = 1 << 8;

    public static final String musicPath = "audio/music/";

    private AssetManager assetManager;

    private int score;
    private int coins;

    public static float timeScale = 1;

    @Override
    public void dispose() {

    }
}
