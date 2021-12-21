package cz.spsmb.flappybird.model.view;

import cz.spsmb.flappybird.logic.FlappyBird;
import cz.spsmb.flappybird.model.GraphicsEntity;

public abstract class AbstractCentredFlappyObject extends AbstractFlappyObject {

    public AbstractCentredFlappyObject(GraphicsEntity graphicsEntity) {
        super(graphicsEntity);
    }

    public AbstractCentredFlappyObject(GraphicsEntity graphicsEntity, double width, double height) {
        super(graphicsEntity, width, height);
    }

    @Override
    protected void setPosition() {
        double centerX = (FlappyBird.SCENE_WIDTH / 2) - (super.getWidth() / 2);
        double centerY = (FlappyBird.SCENE_HEIGHT / 2) - (super.getHeight() / 2);

        super.setX(centerX);
        super.setY(centerY);
    }
}
