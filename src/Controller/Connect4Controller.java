package Controller;

import Model.JetonRouge;
import Model.Plateau;
import Vue.FenetreGUI;

public class Connect4Controller {
    private Plateau plateau;
    private FenetreGUI fenetre;

    // constructeur
    public Connect4Controller(Plateau plateau, FenetreGUI fenetre){
        this.plateau = plateau;
        this.fenetre = fenetre;

        // On lie les boutons de fenetreGUI au controlleur
        // temporaire
        fenetre.lierControlleur(this);

    }

    public void ajoutJetonColonne(int colonne){
        plateau.ajouterJeton(colonne, new JetonRouge());
        fenetre.mettreAJourGrille(plateau);
    }
}
