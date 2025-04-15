package Controller;
import Model.Jeton;
import Model.JetonRouge;
import Model.JetonJaune;
import Model.Plateau;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class Connect4ControllerTest {

    @Test
    public void testEstPlein() {
        Plateau plateau = new Plateau();

        // Test très simple, un peu de la triche, mais on remplit le tout de rouge et on regarde si le tableau et plein
        for(int colonne = 0; colonne < Plateau.NB_Colonnes; colonne++){
            for(int ligne = 0; ligne < Plateau.NB_Lignes; ligne++){
                plateau.ajouterJeton(colonne, new JetonRouge());
            }
        }
        // On regarde si le jeu comprend qu'il est plein.
        assertTrue(plateau.estPlein());
    }

    @Test
    public void testEstPasPlein() { // On regarde si le jeu comprend qu'il n'est pas toujours plein.
        Plateau plateau = new Plateau();

        // J'ajoute deux jetons, pour qu'il ne soit pas vide non plus.
        plateau.ajouterJeton(0, new JetonRouge());
        plateau.ajouterJeton(0, new JetonJaune());

        // Le jeu ne devrait pas être plein.
        assertFalse(plateau.estPlein());
    }
}
