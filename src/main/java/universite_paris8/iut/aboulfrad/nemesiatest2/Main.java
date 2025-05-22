package universite_paris8.iut.aboulfrad.nemesiatest2;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("hello-view.fxml"));
        Scene jeu = new Scene(fxmlLoader.load(), 960, 704);
        stage.setTitle("");
        stage.setResizable(true);
        stage.setScene(jeu);
        stage.setResizable(false);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}