package Controller;

import Model.JetonRouge;
import Model.JetonBleu;
import Model.Plateau;
import Vue.FenetreGUI;
import Model.Jeton;

import javax.swing.*;
import TurnBased.Turn;

public class Connect4Controller {
    private Plateau plateau;
    private FenetreGUI fenetre;
    Turn tour = new Turn();
    // constructeur
    public Connect4Controller(Plateau plateau, FenetreGUI fenetre){
        this.plateau = plateau;
        this.fenetre = fenetre;

        // On lie les boutons de fenetreGUI au controlleur
        // temporaire
        fenetre.lierControlleur(this);

    }

    // Sert pour mettre à jour et vérifier la victoire.
    public void ajoutJetonColonne(int colonne){
        if(tour.tourJoueur1 == true){
            int ligne = plateau.ajouterJeton(colonne, new Jeton("Rouge")); // On va immédiatemment réutiliser la ligne pour vérifier la condition de victoire.

            if(ligne != Plateau.MOUVEMENT_INVALIDE){
                fenetre.mettreAJourGrille(); // On le met seulemenent à jour après un mouvement valide, après tout
                if(plateau.verifierVictoire(colonne, ligne)){ // On part vérifier s'il y a une ligne de 4
                    JOptionPane.showMessageDialog(fenetre, "Victoire !");
                }
            }
        } else if (tour.tourJoueur1 == false) {
            int ligne = plateau.ajouterJeton(colonne, new Jeton("Rouge"));

            if(ligne != Plateau.MOUVEMENT_INVALIDE){
                fenetre.mettreAJourGrille(); // On le met seulemenent à jour après un mouvement valide, après tout
                if(plateau.verifierVictoire(colonne, ligne)){ // On part vérifier s'il y a une ligne de 4
                    JOptionPane.showMessageDialog(fenetre, "Victoire !");
                }
            }
        }

    }
}
