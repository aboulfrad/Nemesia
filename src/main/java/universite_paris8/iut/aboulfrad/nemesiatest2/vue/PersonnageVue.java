package universite_paris8.iut.aboulfrad.nemesiatest2.vue;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import universite_paris8.iut.aboulfrad.nemesiatest2.model.Personnage;

/**
 * Classe qui affiche le personnage à l'écran.
 */
public class PersonnageVue {

    private final ImageView imageView;
    private final Personnage personnage;
    private final Pane pane;
    private final int TAILLE_TUILE = 16;
    private Image imageSaut;

    public PersonnageVue(Personnage personnage, Pane pane) {
        this.personnage = personnage;
        this.pane = pane;
        imageSaut = new Image(getClass().getResource("/universite_paris8/iut/aboulfrad/nemesiatest2/image/persosaut.png").toExternalForm());
        Image image = new Image(getClass().getResource("/universite_paris8/iut/aboulfrad/nemesiatest2/image/JamesGosling.png").toExternalForm());
        imageView = new ImageView(image);
        imageView.setFitWidth(32);
        imageView.setFitHeight(32);

        pane.getChildren().add(imageView);
        mettreAJourAffichage();
    }

    public void mettreAJourAffichage() {
        if (personnage.estEnSaut()) {
            imageView.setImage(imageSaut); // image pendant le saut
        } else {
            imageView.setImage(new Image(getClass().getResource("/universite_paris8/iut/aboulfrad/nemesiatest2/image/JamesGosling.png").toExternalForm()));
        }

        imageView.setTranslateX(personnage.getX() * TAILLE_TUILE);
        imageView.setTranslateY(personnage.getY() * TAILLE_TUILE);
    }

}
