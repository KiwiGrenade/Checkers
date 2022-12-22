package elo.demo;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

//baza pod widok
public class CheckersView extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        Scene scene = new Scene(new AnchorPane(), 320, 240);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}