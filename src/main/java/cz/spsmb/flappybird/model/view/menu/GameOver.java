package cz.spsmb.flappybird.model.view.menu;

import cz.spsmb.flappybird.logic.FlappyBird;
import cz.spsmb.flappybird.model.GraphicsEntity;
import cz.spsmb.flappybird.model.view.AbstractCentredFlappyObject;
import cz.spsmb.flappybird.model.view.AbstractFlappyObject;

public class GameOver extends AbstractCentredFlappyObject {

    public GameOver() {
        super(GraphicsEntity.GAME_OVER);
    }
}
