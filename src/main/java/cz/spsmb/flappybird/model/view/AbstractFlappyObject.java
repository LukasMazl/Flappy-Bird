package cz.spsmb.flappybird.model.view;

import cz.spsmb.flappybird.model.GraphicsEntity;
import javafx.geometry.Rectangle2D;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.FileInputStream;

public abstract class AbstractFlappyObject extends ImageView {

    private GraphicsEntity graphicsEntity;
    private double width;
    private double height;
    private boolean isInit;

    public AbstractFlappyObject(GraphicsEntity graphicsEntity) {
        this.graphicsEntity = graphicsEntity;
        this.isInit = false;
        init();
    }

    public AbstractFlappyObject(GraphicsEntity graphicsEntity, double width, double height) {
        this.graphicsEntity = graphicsEntity;
        this.width = width;
        this.height = height;
        this.isInit = true;
        init();
    }

    protected void init() {
        try {
            Image image = new Image(new FileInputStream("./src/main/resources/" + graphicsEntity.getImagePath()));
            super.setImage(image);
            if(!isInit) {
                this.width = image.getWidth();
                this.height = image.getHeight();
                this.isInit = true;
            }
            super.setFitWidth(this.width);
            super.setFitHeight(this.height);

            setPosition();
        } catch (Exception e) {
            throw new IllegalArgumentException("Graphic object could not be load, because of: " + e.getLocalizedMessage());
        }
    }

    public Rectangle2D getRectangle2D() {
        return new Rectangle2D(getX(), getY(), getWidth(), getHeight());
    }

    public GraphicsEntity getGraphicsEntity() {
        return graphicsEntity;
    }

    public void setGraphicsEntity(GraphicsEntity graphicsEntity) {
        this.graphicsEntity = graphicsEntity;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public boolean isInit() {
        return isInit;
    }

    public void setInit(boolean init) {
        isInit = init;
    }

    protected abstract void setPosition();
}
