package universite_paris8.iut.aboulfrad.nemesiatest2.controleur;

import javafx.animation.AnimationTimer;
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

    private long dernierDeplacement = 0;
    private final long delai = 15_000_000; // 150 ms

    public ControlerPerso(Personnage personnage,  PersonnageVue vue, Pane pane) {
        this.perso = personnage;
        this.personnageVue = vue;
        this.pane = pane;

        directionTouche();
        boucleMouvement();
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
            }else if (event.getCode() == KeyCode.DOWN) {
                perso.changerDirection('b');
            }
        });

        pane.setOnKeyReleased(event -> {
            if (event.getCode() == KeyCode.RIGHT || event.getCode() == KeyCode.LEFT || event.getCode() == KeyCode.UP || event.getCode() == KeyCode.DOWN) {
                perso.arreter();
            }
        });
    }

    private void boucleMouvement() {
        AnimationTimer gameloop = new AnimationTimer() {
            @Override
            public void handle(long deplacementPresent) {
                if (deplacementPresent - dernierDeplacement > delai) {
                    if (deplacementEstValide()) {
                        perso.deplacer();
                        personnageVue.mettreAJourAffichage();
                    }
                    dernierDeplacement = deplacementPresent;
                }
            }
        };
        gameloop.start();
    }

    private boolean deplacementEstValide() {
        int x = perso.getX();
        int y = perso.getY();


        if (perso.getDirection() == 'd' && perso.getX() >= 114) {
            x--;
            return false;// bord droit
        }
        if (perso.getDirection() == 'g' && perso.getX() <= 0) {
            x++;
            return false;// bord gauche
        }
        if (perso.getDirection() == 'h' && perso.getY() <= 0) {
            y++;
            return false;// trop haut
        }
        if (perso.getDirection() == 'b' && perso.getY() > 29) {
            y--;
            return false;// trop bas
        }
        return true;
    }
}

