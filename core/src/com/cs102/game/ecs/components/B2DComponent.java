package com.cs102.game.ecs.components;

import com.badlogic.ashley.core.Component;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.utils.Pool;

public class B2DComponent implements Component, Pool.Poolable {
    public Body body;
    public float width;
    public float height;
    public Vector2 renderPosition = new Vector2();

    @Override
    public void reset() {
        if (body != null) {
            body.getWorld().destroyBody(body);
            body = null;
        }

        width = height = 0;
        renderPosition.set(0, 0);
    }
}
