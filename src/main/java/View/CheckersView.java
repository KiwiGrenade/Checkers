package View;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Klasa bezposrednio odpowiedzialna za wyswietlenie GUI u klienta
 */
public class CheckersView extends Application {

    /**
     * Metoda startowa
     * @param stage Calosc GUI
     * @throws IOException IOException
     */
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(CheckersView.class.getResource("setView.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), CheckersController.TILE_SIZE*8, CheckersController.TILE_SIZE*8);
        stage.setTitle("Checkers");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }

    /**
     * Metoda glowna
     * @param args Argumenty startowe
     */
    public static void main(String[] args) {
        launch();
    }
}