package cz.spsmb.flappybird.model.view.pipe;

import cz.spsmb.flappybird.model.view.ViewHolder;
import cz.spsmb.flappybird.model.view.bird.Bird;
import cz.spsmb.flappybird.view.SceneManager;
import javafx.application.Platform;

public class PipeWrapper {

    public static final double SPACE = 90;

    private AbstractPipe upper;
    private AbstractPipe down;

    private double xValue;
    private double height;

    private int count;

    private SceneManager sceneManager;

    public PipeWrapper(SceneManager sceneManager, double xValue, double height) {
        this.sceneManager = sceneManager;
        this.xValue = xValue;
        this.height = height;
        this.count = 0;
        initPipes();
    }

    private void initPipes() {
        upper = new GreenPipeFlipped();
        upper.setX(xValue);
        upper.setY(-upper.getHeight() + (height - (SPACE / 2)));

        down = new GreenPipe();
        down.setX(xValue);
        down.setY(height + (SPACE / 2));
        sceneManager.addBefore(ViewHolder.getInstance().getBaseGround(), upper, down);
    }

    public void move(double movement) {
        if(count % 12 == 0) {
            this.xValue = this.xValue - movement;

            upper.setX(this.xValue);
            down.setX(this.xValue);
        }
        count++;
    }

    public boolean isIntersect(Bird bird) {
        return bird.isIntersect(upper.getRectangle2D()) || bird.isIntersect(down.getRectangle2D());
    }

    public boolean isOutOfScene() {
        return xValue + down.getWidth() < 0;
    }
}
