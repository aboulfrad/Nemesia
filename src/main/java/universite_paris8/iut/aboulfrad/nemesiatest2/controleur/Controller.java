package universite_paris8.iut.aboulfrad.nemesiatest2.controleur;

import javafx.animation.AnimationTimer;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.Pane;
import javafx.scene.layout.TilePane;
import universite_paris8.iut.aboulfrad.nemesiatest2.model.Personnage;
import universite_paris8.iut.aboulfrad.nemesiatest2.model.Terrain;
import universite_paris8.iut.aboulfrad.nemesiatest2.vue.PersonnageVue;
import universite_paris8.iut.aboulfrad.nemesiatest2.vue.TerrainVue;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.util.Duration;


import java.net.URL;
import java.util.ResourceBundle;
/**
 * Contrôleur général : initialise la scène.
 */
public class Controller implements Initializable {

    @FXML
    private TilePane tilePane;
    @FXML
    private Pane pane;
    private Personnage personnage;
    private PersonnageVue pVue;
    private Timeline gameLoop;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Terrain terrain = new Terrain();
        new TerrainVue(terrain, tilePane);

        personnage = new Personnage(terrain);
        pVue = new PersonnageVue(personnage, pane);
        new ControlerPerso(personnage, pVue, pane);

        boucleMouvement();
        gameLoop.play();
    }

    private void boucleMouvement() {
        gameLoop = new Timeline();
        gameLoop.setCycleCount(Timeline.INDEFINITE);

        KeyFrame keyFrame = new KeyFrame(
                Duration.seconds(0.05),
                ev -> {
                    personnage.deplacer();
                    pVue.mettreAJourAffichage(); // TODO : remplacer par du binding plus tard
                }
        );

        gameLoop.getKeyFrames().add(keyFrame);
    }
}
