package universite_paris8.iut.aboulfrad.nemesiatest2.model;

/*
    Cette classe stocke les données du personnage. C'est-à-dire quel
 */

public class Personnage {

    private int x; // colonne (horizontal)
    private int y; // ligne (vertical)

    public Personnage() {

    }

    public Personnage(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setPosition(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void déplacer(int dx, int dy){
        this.x += dx;
        this.y += dy;
    }
}
