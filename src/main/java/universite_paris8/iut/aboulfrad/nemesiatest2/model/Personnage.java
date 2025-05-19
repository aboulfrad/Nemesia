package universite_paris8.iut.aboulfrad.nemesiatest2.model;

/*
    Cette classe stocke les données du personnage. C'est-à-dire quel
 */

import javafx.beans.property.IntegerProperty;

public class Personnage {

    private IntegerProperty x; // colonne (horizontal)
    private IntegerProperty y; // ligne (vertical)

    private char direction; // 'i' = immobile

    public Personnage() {

    }

    public Personnage(int x, int y) {
        this.x.setValue(x);
        this.y.setValue(y);
        this.direction = 'i';
    }

    public int getX() {
        return this.x.get();
    }

    public int getY() {
        return this.y.get();
    }

    public void setPosition(int x, int y) {
        this.x.setValue(x);
        this.y.setValue(y);
    }
    // Utiliser un gameloop qui va appeler cette fonction en continue
    public void deplacer() {
        if (direction == 'd')
            this.x.setValue(x.getValue() + 2);
        else if (direction == 'g')
            this.x.setValue(x.getValue() - 2);
        else if (direction == 'h')
            this.x.setValue(y.getValue() - 2);
    }


    public void déplacer(int dx, int dy){
        this.x.setValue(x.getValue() + dx);
        this.y.setValue(y.getValue() + dy);
    }

    public void changerDirectionDroite() {
        this.direction = 'd';
    }

    public void changerDirectionGauche() {
        this.direction = 'g';
    }
    public void changerDirectionHaut() {
        this.direction = 'h';
    }

}
