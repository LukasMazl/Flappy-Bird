package cz.spsmb.flappybird.model.view.menu;

import cz.spsmb.flappybird.logic.FlappyBird;
import cz.spsmb.flappybird.model.GraphicsEntity;
import cz.spsmb.flappybird.model.view.AbstractCentredFlappyObject;
import cz.spsmb.flappybird.model.view.AbstractFlappyObject;

public class WelcomeMessage extends AbstractCentredFlappyObject {

    public WelcomeMessage() {
        super(GraphicsEntity.GET_READY_MESSAGE);
    }


}
