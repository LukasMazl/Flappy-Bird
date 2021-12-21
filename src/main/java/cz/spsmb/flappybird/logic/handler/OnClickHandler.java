package cz.spsmb.flappybird.logic.handler;

public interface OnClickHandler {

    void register(ClickedMethod clickedMethod);

    interface ClickedMethod {
        void clicked();
    }
}
