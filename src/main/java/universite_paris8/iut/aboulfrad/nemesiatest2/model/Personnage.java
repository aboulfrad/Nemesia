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

    public Personnage() {
        this.x = new SimpleIntegerProperty(57);
        this.y = new SimpleIntegerProperty(30);
        this.direction = 'i';
    }

    public int getX() {return x.get();}

    public int getY() {return y.get();}

    public void setPosition(int x, int y) {
        this.x.set(x);
        this.y.set(y);
    }

    public void changerDirection(char dir) {
        this.direction = dir;
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
