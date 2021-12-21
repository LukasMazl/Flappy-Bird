package cz.spsmb.flappybird.ticker;

import cz.spsmb.flappybird.logic.FlappyBird;

public class BoardTicker extends AbstractTicker {

    private FlappyBird flappyBird;

    public BoardTicker(FlappyBird flappyBird) {
        this.flappyBird = flappyBird;
    }

    @Override
    public void start() {
        this.flappyBird.setOnKeyPressed(keyEvent -> {
            if(keyEvent.getText().compareTo(" ") == 0) {
                fireTick();
            }
        });
    }

}
