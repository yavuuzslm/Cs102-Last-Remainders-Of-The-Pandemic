package com.cs102.game.ui;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.ui.ProgressBar;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.cs102.game.LastRemaindersOfThePandemic;
import com.cs102.game.input.GameKeys;

public class LoadingUI extends Table {
    private final TextButton textButton;

    private final TextButton pressToPlay;
    public LoadingUI(final LastRemaindersOfThePandemic game) {
        super(game.getSkin());
        this.setFillParent(true);

        // create text button
        textButton = new TextButton("Loading...", game.getSkin());
        textButton.getLabel().setWrap(true);

        pressToPlay = new TextButton("Press Any Key", game.getSkin());
        pressToPlay.getLabel().setWrap(true); // set wrap true to allow text to be longer than the button
        pressToPlay.setVisible(false);
        pressToPlay.addListener(new InputListener() {
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                game.getInputManager().onKeyDown(GameKeys.SELECT);
                return true;
            }
        });
        pressToPlay.addListener(new InputListener() {
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                game.getInputManager().onKeyDown(GameKeys.SELECT);
                return true;
            }
                                }
        );
        add(pressToPlay).expand().fill().center().row();
        add(textButton).expand().fill().bottom().row();
        bottom();
    }


    public void setProgress(float progress) {
        textButton.setText("Loading... " + (int) (progress * 100) + "%");
        textButton.pack();
        pressToPlay.setVisible(progress == 1);
    }
}
