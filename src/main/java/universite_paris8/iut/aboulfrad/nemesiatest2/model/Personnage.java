package universite_paris8.iut.aboulfrad.nemesiatest2.model;

/*
    Cette classe stocke les données du personnage. C'est-à-dire quel
 */

import javafx.beans.property.IntegerProperty;

public class Personnage {

    private IntegerProperty x; // colonne (horizontal)
    private IntegerProperty y; // ligne (vertical)

    public Personnage() {

    }

    public Personnage(int x, int y) {
        this.x.setValue(x);
        this.y.setValue(y);
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

    public void déplacer(int dx, int dy){
        this.x.setValue(x.getValue() + dx);
        this.y.setValue(y.getValue() + dy);
    }
}
