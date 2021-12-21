package cz.spsmb.flappybird.model;

public enum GraphicsEntity {

    BACKGROUND_DAY("sprites/background-day.png"),
    BACKGROUND_NIGHT("sprites/background-night.png"),
    BASE("sprites/base.png"),
    GAME_OVER("sprites/gameover.png"),
    GET_READY_MESSAGE("sprites/message.png"),
    NUMBER_0("sprites/0.png"),
    NUMBER_1("sprites/1.png"),
    NUMBER_2("sprites/2.png"),
    NUMBER_3("sprites/3.png"),
    NUMBER_4("sprites/4.png"),
    NUMBER_5("sprites/5.png"),
    NUMBER_6("sprites/6.png"),
    NUMBER_7("sprites/7.png"),
    NUMBER_8("sprites/8.png"),
    NUMBER_9("sprites/9.png"),
    PIPE_RED("sprites/pipe-red.png"),
    PIPE_RED_FLIPPED("sprites/pipe-red-flipped.png"),
    PIPE_GREEN("sprites/pipe-green.png"),
    PIPE_GREEN_FLIPPED("sprites/pipe-green-flipped.png"),
    REDBIRD_DOWN_FLAP("sprites/redbird-downflap.png"),
    REDBIRD_MID_FLAP("sprites/redbird-midflap.png"),
    REDBIRD_UP_FLAP("sprites/redbird-upflap.png"),
    BLUEBIRD_DOWN_FLAP("sprites/bluebird-downflap.png"),
    BLUEBIRD_MID_FLAP("sprites/bluebird-midflap.png"),
    BLUEBIRD_UP_FLAP("sprites/bluebird-upflap.png"),
    YELLOWBIRD_DOWN_FLAP("sprites/yellowbird-downflap.png"),
    YELLOWBIRD_MID_FLAP("sprites/yellowbird-midflap.png"),
    YELLOWBIRD_UP_FLAP("sprites/yellowbird-upflap.png");

    private String imagePath;

    GraphicsEntity(String imagePath) {
        this.imagePath = imagePath;
    }

    public String getImagePath() {
        return imagePath;
    }

    @Override
    public String toString() {
        return "GraphicsEntity{" +
                "imagePath='" + imagePath + '\'' +
                '}';
    }
}
