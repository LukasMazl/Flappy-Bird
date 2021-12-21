package cz.spsmb.flappybird.model.view.bird;

import cz.spsmb.flappybird.logic.FlappyBird;
import cz.spsmb.flappybird.model.view.ViewHolder;
import cz.spsmb.flappybird.view.SceneManager;
import javafx.geometry.Rectangle2D;
import javafx.scene.image.Image;

public class Bird {

    public static final int UP_COUNT = 2;
    public static final int GRAVITY_SPEED = 10;
    public static final int SPEED = 15;

    private BirdState birdState;
    private BirdView birdView;
    private SceneManager sceneManager;

    private int counter;
    private int moveCounter;
    private int goUp;

    private int xCorr;
    private int yCorr;
    private int angle;

    public Bird(SceneManager sceneManager) {
        this.sceneManager = sceneManager;
        this.birdState = BirdState.MID;
        this.goUp = 0;
        this.counter = 0;
        this.moveCounter = 0;
        this.angle = 0;
        this.xCorr = (int) (FlappyBird.SCENE_WIDTH / 2) - (int) (ViewHolder.getInstance().getBirdUp().getWidth() / 2);
        this.yCorr = (int) (FlappyBird.SCENE_HEIGHT / 2);
    }

    public void goUp() {
        this.goUp += UP_COUNT;
        this.birdState = BirdState.UP;
    }

    public void draw() {
        this.birdView = ViewHolder.getInstance().getBirdMid();
        birdView.setX(xCorr);
        birdView.setY(yCorr);
        birdView.setRotate(angle);

        sceneManager.addBefore(ViewHolder.getInstance().getBaseGround(), birdView);
    }

    public void makeMove() {
        counter++;
        if(counter % 7 == 0) {
            if(this.goUp > 0) {
                this.yCorr -= SPEED * (1 + Math.log(goUp));
                this.goUp--;
                if(this.yCorr < 0) {
                    this.yCorr = 1;
                }
                this.angle = -45;
            } else {
                this.yCorr += GRAVITY_SPEED;
                this.angle = 0;
            }
            moveCounter++;
            if (moveCounter % 3 == 0) {
                this.birdState = BirdState.UP;
            } else if (moveCounter % 3 == 1) {
                this.birdState = BirdState.MID;
            } else {
                this.birdState = BirdState.DOWN;
            }

            switch (birdState) {
                case UP -> draw(ViewHolder.getInstance().getBirdUp().getImage());
                case DOWN -> draw(ViewHolder.getInstance().getBirdDown().getImage());
                case MID -> draw(ViewHolder.getInstance().getBirdMid().getImage());
            }
        }
    }

    private void draw(Image image) {
        birdView.setX(xCorr);
        birdView.setY(yCorr);
        birdView.setRotate(angle);
        birdView.setImage(image);
    }

    public boolean isIntersect(Rectangle2D rectangle2D) {
        if (this.birdView == null)
            return false;

        return this.birdView.getRectangle2D().intersects(rectangle2D);
    }

    public void restart() {
        this.birdState = BirdState.MID;
        this.goUp = 0;
        this.counter = 0;
        this.moveCounter = 0;
        this.angle = 0;
        this.xCorr = (int) (FlappyBird.SCENE_WIDTH / 2) - (int) (ViewHolder.getInstance().getBirdUp().getWidth() / 2);
        this.yCorr = (int) (FlappyBird.SCENE_HEIGHT / 2);
    }
}
