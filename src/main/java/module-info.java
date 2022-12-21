module elo.demo {
    requires javafx.controls;
    requires javafx.fxml;


    opens elo.demo to javafx.fxml;
    exports elo.demo;
}