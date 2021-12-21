package cz.spsmb.flappybird.model.view;

import cz.spsmb.flappybird.model.view.background.Background;
import cz.spsmb.flappybird.model.view.background.BackgroundDay;
import cz.spsmb.flappybird.model.view.background.BackgroundNight;
import cz.spsmb.flappybird.model.view.background.BaseGround;
import cz.spsmb.flappybird.model.view.bird.BirdDownView;
import cz.spsmb.flappybird.model.view.bird.BirdMidView;
import cz.spsmb.flappybird.model.view.bird.BirdUpView;
import cz.spsmb.flappybird.model.view.bird.BirdView;
import cz.spsmb.flappybird.model.view.menu.GameOver;
import cz.spsmb.flappybird.model.view.menu.WelcomeMessage;

public final class ViewHolder {

    private static final ViewHolder INSTANCE = new ViewHolder();

    // BACKGROUND
    private final Background backgroundDay;
    private final Background backgroundNight;
    private final BaseGround baseGround;

    // Menu
    private final WelcomeMessage welcomeMessage;
    private final GameOver gameOver;

    // Bird
    private final BirdView birdMid;
    private final BirdView birdUp;
    private final BirdView birdDown;

    // Instance init
    {
        backgroundDay = new BackgroundDay();
        backgroundNight = new BackgroundNight();
        baseGround = new BaseGround();

        welcomeMessage = new WelcomeMessage();
        gameOver = new GameOver();

        birdMid = new BirdMidView();
        birdUp = new BirdUpView();
        birdDown = new BirdDownView();
    }

    private ViewHolder() {
    }

    public Background getBackgroundDay() {
        return backgroundDay;
    }

    public Background getBackgroundNight() {
        return backgroundNight;
    }

    public BaseGround getBaseGround() {
        return baseGround;
    }

    public WelcomeMessage getWelcomeMessage() {
        return welcomeMessage;
    }

    public GameOver getGameOver() {
        return gameOver;
    }

    public BirdView getBirdMid() {
        return birdMid;
    }

    public BirdView getBirdUp() {
        return birdUp;
    }

    public BirdView getBirdDown() {
        return birdDown;
    }

    public static ViewHolder getInstance() {
        return INSTANCE;
    }
}
