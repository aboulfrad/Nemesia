package universite_paris8.iut.aboulfrad.nemesiatest2.vue;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import universite_paris8.iut.aboulfrad.nemesiatest2.model.Personnage;
import universite_paris8.iut.aboulfrad.nemesiatest2.model.Terrain;
import javafx.scene.layout.TilePane;

public class PersonnageVue {

    public PersonnageVue(Personnage perso, TilePane tilePane, Pane pane){
        this.tilePane=tilePane;
        this.pane=pane;
        deplacementPerso();
    }

    private TilePane tilePane;
    private Pane pane;
    private Personnage perso;
    private int posX = 57;
    private int posY = 30;
    private double vitesseJamesY = -8;
    private double force = 15;
    private ImageView ivp;
    private final int TUILE = 16;
    private Terrain terrain;

    public void afficherPerso() {
        Terrain terrain = new Terrain();
        new TerrainVue(terrain, tilePane);

        // Image du personnage
        Image james = new Image(getClass().getResource("/universite_paris8/iut/aboulfrad/nemesiatest2/image/JamesGosling.png").toExternalForm());
        ivp = new ImageView(james);
        ivp.setFitWidth(32);
        ivp.setFitHeight(32);
        pane.getChildren().add(ivp);
    }
    // Déplacer cette fonction dans le controller
    public void deplacementPerso(){
        afficherPerso();

        mouvementMAJ();

        pane.setFocusTraversable(true);
        pane.requestFocus();

        pane.setOnKeyPressed(event -> {
            switch (event.getCode()) {
                case RIGHT -> perso.changerDirectionDroite();
                case LEFT -> perso.changerDirectionGauche();
//                case UP -> posY-- ;
//                case DOWN -> posY++; //Pour descendre, ce qui est inutile pour la suite
            }
            if(mouvementEstPossible() == true)
                mouvementMAJ();
            });
    }

    /**
     * Cette fonction, permet de print l'image du personnage en fonction de ça position. ( ps : colision avec le sol(coordonnée : y = 31))
     */
    private boolean mouvementEstPossible() {
        if(posY > 30){
            System.out.println("Trop bas !");
            posY--;
            return false;
        }
        else if(posY < 0){
            System.out.println("Tu vas où ?!");
            posY++;
            return true;
        }
        else if(posX < 0) {
            System.out.println("Tu vas où ?!");
            posX++;
            return false;
        }
//         else if (posX >= this.terrain.largueur()) {
//             System.out.println("Trop à droite !");
//             posX--;
//             return false;
//         }
        return true;
    }

    private void mouvementMAJ() {
        ivp.setTranslateX(posX * TUILE);
        ivp.setTranslateY(posY * TUILE);
    }

    private boolean estAuSol(){
        return posY >= 30;
    }
}
