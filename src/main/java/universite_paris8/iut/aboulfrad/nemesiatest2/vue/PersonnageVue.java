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

        Image image = new Image(getClass().getResource("/universite_paris8/iut/aboulfrad/nemesiatest2/image/JamesGosling.png").toExternalForm());
        imageView = new ImageView(image);
        imageView.setFitWidth(32);
        imageView.setFitHeight(32);

        // TODO ajouter ici les bind

        pane.getChildren().add(imageView);
        mettreAJourAffichage();
    }

    public void mettreAJourAffichage() {
        imageView.setTranslateX(personnage.getX()*16);

        imageView.setTranslateY(personnage.getY()*16);// BIND
    }
}
