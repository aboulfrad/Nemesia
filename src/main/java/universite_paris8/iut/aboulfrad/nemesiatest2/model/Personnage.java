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

    private Terrain terrain;

    public Personnage(Terrain terrain) {
        this.x = new SimpleIntegerProperty(15);
        this.y = new SimpleIntegerProperty(15);
        this.terrain=terrain;
        this.direction = 'i';
    }

    public int getX() {
        return x.get();
    }

    public int getY() {
        return y.get();
    }


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
        int Fx = x.get(),Fy=y.get();
        switch (direction) {
            case 'd' -> Fx = x.get() + 1;
            case 'g' -> Fx = x.get() - 1;
            case 'h' -> Fy = y.get() - 1;
            case 'b' -> Fy = y.get() + 1;
        }
        if (terrain.estDansTerrain(Fx,Fy)) {
            x.set(Fx);
            y.set(Fy);
        }

    }

//    private boolean deplacementEstValide() { //TODO déplacer dans Personnage (FAIT)
//        int x = this.getX();
//        int y = this.getY();
//
//
//        if (this.getDirection() == 'd' && this.getFX() >= terrain.largeurEnPixels()) {
//            x--;
//            return false;// bord droit
//        }
//        if (this.getDirection() == 'g' && this.getFX() <= 0) {
//            x++;
//            return false;// bord gauche
//        }
//        if (this.getDirection() == 'h' && this.getFY() <= 0) {
//            y++;
//            return false;// trop haut
//        }
//        if (this.getDirection() == 'b' && this.getFY() > terrain.hauteurEnPixels()) {
//            y--;
//            return false;// trop bas
//        }
//        return true;
//    }

    public char getDirection() {
        return direction;
    }

    public IntegerProperty xProperty() {
        return x;
    }

    public IntegerProperty yProperty() {
        return y;
    }

    public void setTerrain(Terrain terrain) {
        this.terrain = terrain;
    }
}
