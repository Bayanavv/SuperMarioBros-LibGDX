package com.bayanav.mariobros.actors.items;


import com.bayanav.mariobros.actors.RigidBody;
import com.bayanav.mariobros.screens.PlayScreen;

public abstract class Item extends RigidBody {

    protected String name = "item";

    public Item(PlayScreen playScreen, float x, float y) {
        super(playScreen, x, y);
    }

    public String getName() {
        return name;
    }

    public abstract void use();
}