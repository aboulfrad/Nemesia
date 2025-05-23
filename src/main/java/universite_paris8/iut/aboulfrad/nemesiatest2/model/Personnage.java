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
        this.x = new SimpleIntegerProperty(29);
        this.y = new SimpleIntegerProperty(30);
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
            case 'd' -> Fx = x.get() + 2;
            case 'g' -> Fx = x.get() - 2;
            case 'h' -> Fy = y.get() - 2;
            case 'b' -> Fy = y.get() + 2;
        }
        if (terrain.estDansTerrain(Fx,Fy) && !terrain.estBloquer(Fx,Fy)) {
            x.set(Fx);
            y.set(Fy);
            System.out.println(!terrain.estBloquer(Fx,Fy));
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

    public void setTerrain(Terrain terrain) {
        this.terrain = terrain;
    }
}
