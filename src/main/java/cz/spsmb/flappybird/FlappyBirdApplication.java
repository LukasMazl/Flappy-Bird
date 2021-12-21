package cz.spsmb.flappybird;

import cz.spsmb.flappybird.logic.FlappyBird;
import cz.spsmb.flappybird.logic.FlappyBirdFactory;
import javafx.application.Application;
import javafx.stage.Stage;

public class FlappyBirdApplication extends Application {
    @Override
    public void start(Stage stage) {
        FlappyBird flappyBird = FlappyBirdFactory.aiPlayer();
        stage.setTitle("Angry Birds");
        stage.setScene(flappyBird);
        stage.setResizable(false);
        stage.show();

        flappyBird.start();
    }

    public static void main(String[] args) {
        launch();
    }
}