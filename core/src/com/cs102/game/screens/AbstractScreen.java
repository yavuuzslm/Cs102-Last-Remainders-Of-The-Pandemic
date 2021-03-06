package com.cs102.game.screens;

import box2dLight.RayHandler;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputMultiplexer;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.cs102.game.LastRemaindersOfThePandemic;
import com.cs102.game.audio.AudioManager;
import com.cs102.game.input.InputListener;
import com.cs102.game.input.InputManager;

public abstract class AbstractScreen<T extends Table> implements Screen, InputListener {
    protected final Viewport viewport;
    protected final LastRemaindersOfThePandemic mainGame;
    protected final World world;
    protected final Box2DDebugRenderer b2DDebugRenderer;

    protected final RayHandler rayHandler;
    protected final Stage stage;
    protected final T screenUI;
    protected final InputManager inputManager;
    protected final AudioManager audioManager;

    public AbstractScreen( final LastRemaindersOfThePandemic mainGame) {
        this.mainGame = mainGame;
        viewport = mainGame.getViewport();
        this.world = mainGame.getWorld();
        rayHandler = mainGame.getRayHandler();
        this.b2DDebugRenderer = mainGame.getB2dDebugRenderer();
        inputManager = mainGame.getInputManager();
        stage = mainGame.getStage();
        screenUI = getScreenUI(mainGame);

        Gdx.input.setInputProcessor(new InputMultiplexer(inputManager, stage));
        audioManager = mainGame.getAudioManager();
    }

    @Override
    public void render(float delta) {
        stage.act(delta);
        stage.draw();
    }

    @Override
    public void resize(final int width,final int height) {
        viewport.update(width, height);
        stage.getViewport().update(width, height, true);
        rayHandler.useCustomViewport(viewport.getScreenX(), viewport.getScreenY(), viewport.getScreenWidth(), viewport.getScreenHeight());

    }

    @Override
    public void hide() {
        stage.getRoot().removeActor(screenUI);
        inputManager.removeListener(this);
    }
    @Override
    public void show() {
        inputManager.addInputListener(this);
        stage.addActor(screenUI);
    }

    protected abstract T getScreenUI(final LastRemaindersOfThePandemic mainGame);

    @Override
    public void dispose() {

    }
}
