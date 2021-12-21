package cz.spsmb.flappybird.logic.handler;

import cz.spsmb.flappybird.logic.FlappyBird;
import cz.spsmb.flappybird.model.GameState;
import cz.spsmb.flappybird.ticker.OnTick;

public abstract class AbstractAiHandler implements OnClickHandler, OnTick, OnGameOver {

    private ClickedMethod clickedMethod;
    private FlappyBird flappyBird;

    public AbstractAiHandler(FlappyBird flappyBird) {
        this.flappyBird = flappyBird;
    }

    @Override
    public void register(ClickedMethod clickedMethod) {
        if (this.clickedMethod == null) {
            this.clickedMethod = clickedMethod;
        } else {
            throw new IllegalArgumentException("ClickedMethod already set.");
        }
    }

    @Override
    public void tick() {
        GameState gameState = flappyBird.getGameState();
        if(gameState == GameState.READY || gameState == GameState.GAME_OVER) {
            fireClick();
        }

        if(gameState == GameState.PLAYING) {
            if(shouldGoUP()) {
                fireClick();
            }
        }
    }

    protected abstract boolean shouldGoUP();

    @Override
    public void gameOver() {

    }

    private void fireClick() {
        if(clickedMethod != null) {
            clickedMethod.clicked();
        }
    }
}
