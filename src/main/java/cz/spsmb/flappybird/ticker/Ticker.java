package cz.spsmb.flappybird.ticker;

public interface Ticker {

    void register(OnTick onTick);

    void start();
}
