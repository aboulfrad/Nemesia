package universite_paris8.iut.aboulfrad.nemesiatest2.model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

/**
 * Modèle du personnage : position et direction.
 */
public class Personnage {

    private  IntegerProperty x;
    private  IntegerProperty y;
    private char direction; // 'i' = immobile
    private boolean enSaut = false;
    private int vitesseY = 0;
    private final int GRAVITE = 1;
    private final int SAUT_FORCE = -5;


    public Personnage() {
        this.x = new SimpleIntegerProperty(57);
        this.y = new SimpleIntegerProperty(30);
        this.direction = 'i';
    }

    public boolean estEnSaut() {
        return enSaut;
    }

    public int getX() {return x.get();}

    public int getY() {return y.get();}

    public void setPosition(int x, int y) {
        this.x.set(x);
        this.y.set(y);
    }

    public void changerDirection(char dir) {
        this.direction = dir;
        if (dir == 'h' && !enSaut) {
            vitesseY = SAUT_FORCE;
            enSaut = true;
        }
    }

    public void arreter() {
        this.direction = 'i';
    }

    public void deplacer() {
        switch (direction) {
            case 'd' -> x.set(x.get() + 1);
            case 'g' -> x.set(x.get() - 1);
            case 'h' -> y.set(y.get() - 1);
            case 'b' -> y.set(y.get() + 1);
        }
        if (enSaut) {
            vitesseY += GRAVITE;
            y.set(y.get() + vitesseY / 2); // ajustement
            if (y.get() >= 30) { // sol
                y.set(30);
                enSaut = false;
                vitesseY = 0;
            }
        }
    }

    public char getDirection() {
        return direction;
    }

    public IntegerProperty xProperty() {
        return x;
    }

    public IntegerProperty yProperty() {
        return y;
    }
}
