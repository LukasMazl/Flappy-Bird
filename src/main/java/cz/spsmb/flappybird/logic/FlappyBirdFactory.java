package cz.spsmb.flappybird.logic;

import cz.spsmb.flappybird.logic.handler.AbstractAiHandler;
import cz.spsmb.flappybird.logic.handler.MouseOnClickHandler;
import cz.spsmb.flappybird.logic.handler.NeuroneNetworkAi;
import cz.spsmb.flappybird.ticker.TimeTicker;
import cz.spsmb.flappybird.view.SceneManager;
import cz.spsmb.flappybird.view.SimpleViewManager;

public class FlappyBirdFactory {

    public static SceneManager getSceneManager() {
        return new SimpleViewManager();
    }

    public static FlappyBird standardPlayer() {
        FlappyBird flappyBird = new FlappyBird(getSceneManager());
        flappyBird.setTicker(new TimeTicker(10));
        flappyBird.setOnClickHandler(new MouseOnClickHandler(flappyBird));

        return flappyBird;
    }

    public static FlappyBird aiPlayer() {
        FlappyBird flappyBird = new FlappyBird(getSceneManager());
        AbstractAiHandler aiHandler = new NeuroneNetworkAi(flappyBird);
        flappyBird.setTicker(new TimeTicker(10));
        flappyBird.setOnClickHandler(aiHandler);
        flappyBird.addOnTickHandler(aiHandler);
        flappyBird.setOnGameOver(aiHandler);

        return flappyBird;
    }
}
