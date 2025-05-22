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

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Terrain terrain = new Terrain();
        new TerrainVue(terrain, tilePane);

        personnage = new Personnage(terrain);
        pVue = new PersonnageVue(personnage, pane);
        new ControlerPerso(personnage, pVue, pane);

        boucleMouvement();
    }

    private void boucleMouvement() {
        AnimationTimer gameloop = new AnimationTimer() {
            @Override
            public void handle(long deplacementPresent) {
                        personnage.deplacer();
                        pVue.mettreAJourAffichage(); //TODO remplacer par des bind
            }
        };
        gameloop.start();
    }
}
