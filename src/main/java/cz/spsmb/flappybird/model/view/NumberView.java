package cz.spsmb.flappybird.model.view;

import cz.spsmb.flappybird.view.SceneManager;

import java.util.List;

public class NumberView {
    private int value;
    private List<AbstractNoPositionFlappyBird> numberList;
    private SceneManager sceneManager;

    public NumberView(SceneManager sceneManager) {
        this.sceneManager = sceneManager;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
