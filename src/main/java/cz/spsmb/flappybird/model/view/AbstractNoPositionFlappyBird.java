package cz.spsmb.flappybird.model.view;

import cz.spsmb.flappybird.model.GraphicsEntity;
import cz.spsmb.flappybird.model.view.AbstractFlappyObject;

public abstract class AbstractNoPositionFlappyBird extends AbstractFlappyObject {

    public AbstractNoPositionFlappyBird(GraphicsEntity graphicsEntity) {
        super(graphicsEntity);
    }

    @Override
    protected void setPosition() {
        // do nothing
    }
}
