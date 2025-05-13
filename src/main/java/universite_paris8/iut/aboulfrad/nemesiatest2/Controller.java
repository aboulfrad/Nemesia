package universite_paris8.iut.aboulfrad.nemesiatest2;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.TilePane;
import universite_paris8.iut.aboulfrad.nemesiatest2.model.Terrain;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    @FXML
    private TilePane tilePane;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Terrain terrain = new Terrain();

        Image imagedirt = new Image(getClass().getResource("/universite_paris8/iut/aboulfrad/nemesiatest2/image/dirt.png").toExternalForm());
        Image imagegrass = new Image(getClass().getResource("/universite_paris8/iut/aboulfrad/nemesiatest2/image/grass.png").toExternalForm());
        Image imagesky = new Image(getClass().getResource("/universite_paris8/iut/aboulfrad/nemesiatest2/image/sky.png").toExternalForm());

        int[][] terrainTab = terrain.getTerrain();

        for (int i = 0; i < terrainTab.length; i++) {
            for (int j = 0; j < terrainTab[i].length; j++) {
                ImageView iv = new ImageView();
                if (terrainTab[i][j] == 1) {
                    iv.setImage(imagesky);
                } else if (terrainTab[i][j] == 2) {
                    iv.setImage(imagegrass);
                } else if (terrainTab[i][j] == 3) {
                    iv.setImage(imagedirt);
                }

                tilePane.getChildren().add(iv);
                iv.setFitHeight(32);
                iv.setFitWidth(32);
            }
        }

        System.out.println("Nous avons réussi notre git push et git pull !");
    }



}



