module cz.spsmb.flappybird {
    requires javafx.controls;
    requires javafx.fxml;


    opens cz.spsmb.flappybird to javafx.fxml;
    exports cz.spsmb.flappybird;
    exports cz.spsmb.flappybird.logic;
    opens cz.spsmb.flappybird.logic to javafx.fxml;
}