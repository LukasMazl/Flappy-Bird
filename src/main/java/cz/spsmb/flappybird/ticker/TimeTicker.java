package cz.spsmb.flappybird.ticker;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class TimeTicker extends AbstractTicker {

    private ScheduledExecutorService executorService;
    private int period;

    public TimeTicker(int period) {
        this.executorService = Executors.newScheduledThreadPool(1);
        this.period = 10;
    }

    @Override
    public void start() {
        executorService.scheduleAtFixedRate(super::fireTick, 0, period, TimeUnit.MILLISECONDS);
    }
}
