package universite_paris8.iut.aboulfrad.nemesiatest2.vue;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import universite_paris8.iut.aboulfrad.nemesiatest2.model.Personnage;

/**
 * Classe qui affiche le personnage à l'écran.
 */
public class PersonnageVue {

    private  ImageView imageView;

    private  Personnage personnage;

    private  Pane pane;


    public PersonnageVue(Personnage personnage, Pane pane) {
        this.personnage = personnage;
        this.pane = pane;

        Image image = new Image(getClass().getResource("/universite_paris8/iut/aboulfrad/nemesiatest2/image/JamesGosling_32x32.png").toExternalForm());
        imageView = new ImageView(image);

        pane.getChildren().add(imageView);

        imageView.translateXProperty().bind(personnage.xProperty());
        imageView.translateYProperty().bind(personnage.yProperty());


    }

}
