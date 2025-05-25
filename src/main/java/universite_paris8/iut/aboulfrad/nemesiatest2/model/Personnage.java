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
    private boolean parTerre = true;
    private int vitesseY = 0;
    private final int GRAVITE = 1;
    private final int SAUT_FORCE = -15;
    private Terrain terrain;

    public Personnage(Terrain terrain) {
        this.x = new SimpleIntegerProperty(300);
        this.y = new SimpleIntegerProperty(478);
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
/*
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
                parTerre = true;
            }
        }  // Je retirr caron utuilise plus
*/
    }

    public void appliquerGravite() {
        if (!parTerre) {
            vitesseY += GRAVITE;
            int newY = (int) (y.get() + vitesseY);

            int milieuX = x.get() + 16;
            int basY = newY + 32;

            if (terrain.estBloquer(milieuX, basY) || !terrain.estDansTerrain(milieuX, basY)) {
                // Collision sol
                parTerre = true;
                vitesseY = 0;
                y.set((basY / 32 - 1) * 32); // aligne sur la case juste avant le sol
            } else {
                y.set(newY);
            }
        }
    }

    //Nouveau
    public void sauter() {  //Modifier laje dis que je fais sauer le psg SSI il est au sol
        if (parTerre) {
            parTerre = false;   // Empeche un double saut
            vitesseY = SAUT_FORCE;
        }
    }

    public char getDirection() {
        return direction; }

    public IntegerProperty xProperty() {
        return x; }

    public IntegerProperty yProperty() {
        return y; }

    public void setTerrain(Terrain terrain) {
        this.terrain = terrain; }
}
