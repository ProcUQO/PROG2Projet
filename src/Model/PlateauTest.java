package Model;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class PlateauTest {

    // Inspiré du TD cyclique et employé
    @Test
    public void testVictoireHorizontale() {
        Plateau plateau = new Plateau();
        Jeton jeton = new Jeton("Rouge");

        // J'ajoute 4 jetons en ligne pour faire un connect 4. Je triche un peu, ils sont tous rouge.
        plateau.ajouterJeton(0, jeton);
        plateau.ajouterJeton(1, jeton);
        plateau.ajouterJeton(2, jeton);
        plateau.ajouterJeton(3, jeton);

        boolean victoire = plateau.verifierVictoire(3, 0);
        assertTrue(victoire); // Vérifie si c'est vrai, pour les booléens
    }

}
