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

    public void deplacementPerso(){
        afficherPerso();

        mouvementMAJ();

        pane.setFocusTraversable(true);
        pane.requestFocus();

        pane.setOnKeyPressed(event -> {
            switch (event.getCode()) {
                case RIGHT -> posX++; //perso.deplacerDroite();
                case LEFT -> posX--;
                case SPACE -> posY-- ;
//              case DOWN -> posY++; Pour descendre, ce qui est inutile pour la suite
            }

            mouvementMAJ();
        });
    }

    private void mouvementMAJ() {
        ivp.setTranslateX(posX * TUILE);
        ivp.setTranslateY(posY * TUILE);
    }

    private boolean estAuSol(){
        return posY >= 30;
    }
}
