package Controller;

import Model.Jeton;
import Model.JetonJaune;
import Model.JetonRouge;
import Model.Plateau;
import Vue.FenetreGUI;

import javax.swing.*;

public class Connect4Controller {
    private Plateau plateau;
    private FenetreGUI fenetre;
    private boolean tourDuJoueurRouge = true; // Rouge commence


    // constructeur
    public Connect4Controller(Plateau plateau, FenetreGUI fenetre){
        this.plateau = plateau;
        this.fenetre = fenetre;

        // On lie les boutons de fenetreGUI au controlleur
        fenetre.lierControlleur(this);

    }

    // Sert pour mettre à jour et vérifier la victoire.
    public void ajoutJetonColonne(int colonne){
        Jeton jeton = tourDuJoueurRouge ? new JetonRouge() : new JetonJaune(); // On crée le jeton selon le joueur
        int ligne = plateau.ajouterJeton(colonne, jeton); // On va immédiatemment réutiliser la ligne pour vérifier la condition de victoire.
        if(ligne != Plateau.MOUVEMENT_INVALIDE){
            fenetre.mettreAJourGrille(plateau); // On le met seulemenent à jour après un mouvement valide, après tout

            if (plateau.verifierVictoire(colonne, ligne)) {
                String couleurGagnante = jeton.getCouleur().equals("rouge") ? "Rouge" : "Jaune";
                JOptionPane.showMessageDialog(fenetre, "Victoire du joueur " + couleurGagnante + " !");
                resetJeu();
            }

            // et on change le tour :)
            tourDuJoueurRouge = !tourDuJoueurRouge;
        }
    }

    // Petit ajout de dernière minute, recrée le plateau à chaque victoire :)
    private void resetJeu(){
        plateau = new Plateau();
        fenetre.mettreAJourGrille(plateau); // Pour remettre l'affichage de base
        tourDuJoueurRouge = false; // Pas obligatoire, mais apprécié
    }
}
