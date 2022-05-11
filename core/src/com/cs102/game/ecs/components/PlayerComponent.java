package com.cs102.game.ecs.components;

import com.badlogic.ashley.core.Component;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Pool;


public class PlayerComponent implements Component, Pool.Poolable {

    public boolean hasAxe;

    public int health = 100;
    public int xp;
    public int itemCount;
    public Vector2 speed = new Vector2();
    public Vector2 position = new Vector2();

    @Override
    public void reset() {
        position.set(0,0);
        health = 0;
        xp = 0;
        itemCount = 0;
        speed.setZero();
    }
  
    //getter of the health and xp
    public int getHealth() {
        return health;
    }

    public int getXp() {
        return xp;
    }


}
