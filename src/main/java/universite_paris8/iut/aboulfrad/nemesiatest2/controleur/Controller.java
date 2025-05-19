package universite_paris8.iut.aboulfrad.nemesiatest2.controleur;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.TilePane;
import javafx.scene.layout.Pane;
import universite_paris8.iut.aboulfrad.nemesiatest2.model.Personnage;
import universite_paris8.iut.aboulfrad.nemesiatest2.model.Terrain;
import universite_paris8.iut.aboulfrad.nemesiatest2.vue.PersonnageVue;
import universite_paris8.iut.aboulfrad.nemesiatest2.vue.TerrainVue;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    @FXML
    private TilePane tilePane;
    @FXML
    private Pane pane;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        Terrain terrain = new Terrain();
        TerrainVue terrainVue = new TerrainVue(terrain,tilePane);
        Personnage James = new Personnage();
        PersonnageVue JamesVu = new PersonnageVue(James,tilePane,pane);
        ImageView ivp = new ImageView();




    }
}

