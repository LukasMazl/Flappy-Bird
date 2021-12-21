package cz.spsmb.flappybird.model.view.background;

import cz.spsmb.flappybird.logic.FlappyBird;
import cz.spsmb.flappybird.model.GraphicsEntity;
import cz.spsmb.flappybird.model.view.AbstractFlappyObject;

public class BaseGround extends AbstractFlappyObject {

    public BaseGround() {
        super(GraphicsEntity.BASE);
    }

    @Override
    protected void setPosition() {
        double height = FlappyBird.SCENE_HEIGHT - getHeight();
        super.setY(height);
    }
}
