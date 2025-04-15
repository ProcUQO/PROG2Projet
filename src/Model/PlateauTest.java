package Model;
import org.junit.Assert;
import org.junit.Test;


public class PlateauTest {

    // Inspiré du TD cyclique et employé
    @Test
    public void testVictoireHorizontale() {
        Plateau plateau = new Plateau();
        Jeton jeton = new Jeton("Rouge"); // Je n'utilise pas directement l'héritage, mais c'est exceptionel (ce n'est qu'un test unitaire)

        // J'ajoute 4 jetons en ligne pour faire un connect 4. Je triche un peu, ils sont tous rouge.
        plateau.ajouterJeton(0, jeton);
        plateau.ajouterJeton(1, jeton);
        plateau.ajouterJeton(2, jeton);
        plateau.ajouterJeton(3, jeton);

        boolean victoire = plateau.verifierVictoire(3, 0);
        Assert.assertTrue(victoire); // Vérifie si c'est vrai, pour les booléens
    }

    @Test
    public void testVictoireVerticale() {
        Plateau plateau = new Plateau();
        Jeton jeton = new Jeton("Jaune");

        plateau.ajouterJeton(0, jeton);
        plateau.ajouterJeton(0, jeton);
        plateau.ajouterJeton(0, jeton);
        plateau.ajouterJeton(0, jeton);

        boolean victoire = plateau.verifierVictoire(0, 3);
        Assert.assertTrue(victoire);
    }

    @Test
    public void testVictoireDiagonale() {
        Plateau plateau = new Plateau();
        Jeton jetonRouge = new JetonRouge();
        Jeton jetonJaune = new JetonJaune();

        plateau.ajouterJeton(0, jetonRouge);
        plateau.ajouterJeton(1, jetonJaune);
        plateau.ajouterJeton(1, jetonRouge);
        plateau.ajouterJeton(2, jetonJaune);
        plateau.ajouterJeton(2, jetonJaune);
        plateau.ajouterJeton(2, jetonRouge);
        plateau.ajouterJeton(3, jetonJaune);
        plateau.ajouterJeton(3, jetonJaune);
        plateau.ajouterJeton(3, jetonJaune);
        plateau.ajouterJeton(3, jetonRouge);

        boolean victoire = plateau.verifierVictoire(3, 3);
        Assert.assertTrue(victoire);
    }

    @Test
    public void testPasFausseVictoire() {
        Plateau plateau = new Plateau();
        Jeton jetonRouge = new JetonRouge();
        Jeton jetonJaune = new JetonJaune();

        plateau.ajouterJeton(0, jetonRouge);
        plateau.ajouterJeton(1, jetonRouge);
        plateau.ajouterJeton(2, jetonRouge);
        plateau.ajouterJeton(3, jetonJaune);

        boolean victoire = plateau.verifierVictoire(3, 0);
        Assert.assertFalse(victoire); // On s'assure que le jeu ne nous invente pas des victoires.
    }

}
