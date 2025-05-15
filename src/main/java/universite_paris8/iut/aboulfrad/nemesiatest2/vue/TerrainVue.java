package universite_paris8.iut.aboulfrad.nemesiatest2.vue;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.TilePane;
import universite_paris8.iut.aboulfrad.nemesiatest2.model.Terrain;

public class TerrainVue {

    private Terrain terrain;
    private TilePane tilePane;

    public TerrainVue(Terrain terrain, TilePane tilePane) {
        this.terrain = terrain;
        this.tilePane = tilePane;
        this.afficherTerrain();
    }

    public void afficherTerrain () {
        Image imagedirt = new Image(getClass().getResource("/universite_paris8/iut/aboulfrad/nemesiatest2/image/dirt.png").toExternalForm());
        Image imagegrass = new Image(getClass().getResource("/universite_paris8/iut/aboulfrad/nemesiatest2/image/grass.png").toExternalForm());
        Image imagesky = new Image(getClass().getResource("/universite_paris8/iut/aboulfrad/nemesiatest2/image/sky.png").toExternalForm());
        tilePane.setPrefSize(64 * terrain.hauteur(),64 * terrain.largueur());
        for (int i = 0; i < terrain.largueur(); i++) {
            for (int j = 0; j < terrain.hauteur(); j++) {
                ImageView iv = new ImageView();
                if (terrain.typeTuile(i,j) == 1) {
                    iv.setImage(imagesky);
                } else if (terrain.typeTuile(i,j) == 2) {
                    iv.setImage(imagegrass);
                } else if (terrain.typeTuile(i,j) == 3) {
                    iv.setImage(imagedirt);
                }
                tilePane.getChildren().add(iv);
                iv.setFitHeight(32);
                iv.setFitWidth(32);
            }
        }
    }
}
