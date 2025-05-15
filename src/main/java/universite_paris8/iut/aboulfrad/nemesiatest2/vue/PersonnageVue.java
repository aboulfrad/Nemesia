package universite_paris8.iut.aboulfrad.nemesiatest2.vue;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import universite_paris8.iut.aboulfrad.nemesiatest2.model.Personnage;
import universite_paris8.iut.aboulfrad.nemesiatest2.model.Terrain;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.TilePane;
import javafx.scene.layout.Pane;
import universite_paris8.iut.aboulfrad.nemesiatest2.model.Terrain;
import universite_paris8.iut.aboulfrad.nemesiatest2.vue.TerrainVue;

import java.net.URL;
import java.util.ResourceBundle;

public class PersonnageVue {

    public PersonnageVue(Personnage perso, TilePane tilePane, Pane pane){
        this.tilePane=tilePane;
        this.pane=pane;
        deplacementPerso();
    }

    private TilePane tilePane;
    private Pane pane;
    private Personnage perso;
    private int posX = 5;
    private int posY = 20;
    private ImageView ivp;
    private final int TUILE = 16;

    public void afficherPerso() {
        Terrain terrain = new Terrain();
        new TerrainVue(terrain, tilePane);

        // Image du personnage
        Image james = new Image(getClass().getResource("/universite_paris8/iut/aboulfrad/nemesiatest2/image/JamesGosling.png").toExternalForm());
        ivp = new ImageView(james);
        ivp.setFitWidth(32);
        ivp.setFitHeight(32);
        pane.getChildren().add(ivp);
    }
    public void deplacementPerso(){
        afficherPerso();

        // Position initiale
        updatePosition();

        // Rendre le pane focusable et écouter les touches
        pane.setFocusTraversable(true);
        pane.requestFocus();

        pane.setOnKeyPressed(event -> {
            switch (event.getCode()) {
                case RIGHT -> posX++;
                case LEFT -> posX--;
                case UP -> posY--;
                case DOWN -> posY++;
            }

            updatePosition();
        });
    }

    private void updatePosition() {
        ivp.setTranslateX(posX * TUILE);
        ivp.setTranslateY(posY * TUILE);
    }
}
