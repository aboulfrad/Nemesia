package universite_paris8.iut.aboulfrad.nemesiatest2;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene jeu = new Scene(fxmlLoader.load(), 1920, 1080);
        stage.setTitle("");
        stage.setResizable(true);
        stage.setScene(jeu);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}