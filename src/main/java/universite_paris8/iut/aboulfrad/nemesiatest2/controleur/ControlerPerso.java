package universite_paris8.iut.aboulfrad.nemesiatest2.controleur;

import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;
import universite_paris8.iut.aboulfrad.nemesiatest2.model.Personnage;
import universite_paris8.iut.aboulfrad.nemesiatest2.vue.PersonnageVue;

/**
 * Gère les mouvements et collisions du personnage.
 */
public class ControlerPerso {

    private  Personnage perso;
    private  PersonnageVue personnageVue;
    private  Pane pane;

    public ControlerPerso(Personnage personnage, PersonnageVue vue, Pane pane) {
        this.perso = personnage;
        this.personnageVue = vue;
        this.pane = pane;

        directionTouche();
    }

    private void directionTouche() {
        pane.setFocusTraversable(true);
        pane.requestFocus();

        pane.setOnKeyPressed(event -> {
            if (event.getCode() == KeyCode.RIGHT) {
                perso.changerDirection('d');
            } else if (event.getCode() == KeyCode.LEFT) {
                perso.changerDirection('g');
            } else if (event.getCode() == KeyCode.UP) {
                perso.changerDirection('h');
            } else if (event.getCode() == KeyCode.DOWN) {
                perso.changerDirection('b');
            }
        });

        pane.setOnKeyReleased(event -> {
            if (event.getCode() == KeyCode.RIGHT || event.getCode() == KeyCode.LEFT || event.getCode() == KeyCode.UP || event.getCode() == KeyCode.DOWN) {
                perso.arreter();
            }
        });
    }



}

