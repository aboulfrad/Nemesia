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
    private boolean auSol = true;

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
        int Fx = x.get();
        int Fy = y.get();

        int width = 32;
        int height = 32;

        if (direction == 'd') {
            int posFx = Fx + 2 + width;
            int posFy = Fy + height / 2;
            if (!terrain.estBloquer(posFx, posFy) && terrain.estDansTerrain(Fx + 2, Fy)) {
                x.set(Fx + 2);
            }
        }

        if (direction == 'g') {
            int testX = Fx - 2;
            int testY = Fy + height / 2;
            if (!terrain.estBloquer(testX, testY) && terrain.estDansTerrain(Fx - 2, Fy)) {
                x.set(Fx - 2);
            }
        }

        if (direction == 'h') {
            int testX = Fx + width / 2;
            int testY = Fy - 2;
            if (!terrain.estBloquer(testX, testY) && terrain.estDansTerrain(Fx, Fy - 2)) {
                y.set(Fy - 2);
            }
        }

        if (direction == 'b') {
            int testX = Fx + width / 2;
            int testY = Fy + height + 2;
            if (!terrain.estBloquer(testX, testY) && terrain.estDansTerrain(Fx, Fy + 2)) {
                y.set(Fy + 2);
                auSol = true;
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

    public void setTerrain(Terrain terrain) {
        this.terrain = terrain;
    }
}
