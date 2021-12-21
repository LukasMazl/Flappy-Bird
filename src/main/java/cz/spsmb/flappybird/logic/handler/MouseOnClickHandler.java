package cz.spsmb.flappybird.logic.handler;

import cz.spsmb.flappybird.logic.FlappyBird;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

import java.util.LinkedList;
import java.util.List;

public class MouseOnClickHandler implements OnClickHandler, EventHandler<MouseEvent> {

    private FlappyBird flappyBird;
    private List<ClickedMethod> clickedMethodList;

    public MouseOnClickHandler(FlappyBird flappyBird) {
        this.flappyBird = flappyBird;
        this.clickedMethodList = new LinkedList<>();
        initHandler();
    }

    private void initHandler() {
        this.flappyBird.setOnMouseClicked(this);
    }

    @Override
    public void register(ClickedMethod clickedMethod) {
        this.clickedMethodList.add(clickedMethod);
    }

    @Override
    public void handle(MouseEvent mouseEvent) {
        try {
            for (ClickedMethod clickedMethod : clickedMethodList) {
                clickedMethod.clicked();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
