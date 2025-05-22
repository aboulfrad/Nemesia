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
        Image sky = new Image(getClass().getResource("/universite_paris8/iut/aboulfrad/nemesiatest2/image/sky_dark.png").toExternalForm());
        Image grass = new Image(getClass().getResource("/universite_paris8/iut/aboulfrad/nemesiatest2/image/grass_dark.png").toExternalForm());
        Image dirt = new Image(getClass().getResource("/universite_paris8/iut/aboulfrad/nemesiatest2/image/dirt_dark.png").toExternalForm());
        Image imageBlack = new Image(getClass().getResource("/universite_paris8/iut/aboulfrad/nemesiatest2/image/noir.png").toExternalForm());
        Image imageWhiteLight = new Image(getClass().getResource("/universite_paris8/iut/aboulfrad/nemesiatest2/image/blanc.png").toExternalForm());
        Image imageWhiteDark = new Image(getClass().getResource("/universite_paris8/iut/aboulfrad/nemesiatest2/image/gris.png").toExternalForm());

        tilePane.setPrefSize(32 * terrain.hauteur(), 32 * terrain.largeur());

        for (int i = 0; i < terrain.largeur(); i++) {
            for (int j = 0; j < terrain.hauteur(); j++) {
                ImageView iv = new ImageView();
                int tuile = terrain.typeTuile(i, j);

                if (tuile == 1) {
                    iv.setImage(sky);
                } else if (tuile == 2) {
                    iv.setImage(grass);
                } else if (tuile == 3) {
                    iv.setImage(dirt);
                } else if (tuile == 4) {
                    iv.setImage(imageBlack);
                } else if (tuile == 5) {
                    iv.setImage(imageWhiteLight);
                } else if (tuile == 6) {
                    iv.setImage(imageWhiteDark);
                }

                iv.setFitWidth(32);
                iv.setFitHeight(32);
                tilePane.getChildren().add(iv);
            }
        }

    }
}
