package cz.spsmb.flappybird.ticker;

import java.util.LinkedList;
import java.util.List;

public abstract class AbstractTicker implements Ticker {

    private List<OnTick> onTickList;

    public AbstractTicker() {
        this.onTickList = new LinkedList<>();
    }

    @Override
    public void register(OnTick onTick) {
        this.onTickList.add(onTick);
    }

    protected void fireTick() {
        try {
            for (OnTick onTick: onTickList) {
                onTick.tick();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
