package TurnBased;
import TurnBased.Turn;
import Vue.FenetreGUI;

import javax.swing.*;
import java.util.ArrayList;

public class Tableau {
    public int horizontal = 7;
    public int vertical = 6;
    public String[][] tab = new String[horizontal][vertical];
    private FenetreGUI fenetre;

    public int TabAddColor(int colonne, boolean tour) {
        int ligne = 0;
        for (int i = vertical - 1; i > -1; i --) {
            ligne = i;
            if (tab[colonne][i] == null && tour == true) {
                tab[colonne][i] = "Rouge";
                break;
            } else if (tab[colonne][i] == null && tour == false) {
                tab[colonne][i] = "Jaune";
                break;
            }
        }
        return ligne;
    }
    public void VerifierVictoire(int colonne, int ligne, boolean tour){
        VerifierDroite(colonne,ligne,tour);
        VerifierGauche(colonne,ligne,tour);
        VerifierHaut(colonne,ligne,tour);
        VerifierDiagonalHautD(colonne,ligne,tour);
        VerifierDiagonalBasD(colonne,ligne,tour);
        VerifierDiagonalBasG(colonne,ligne,tour);
        VerifierDiagonalHautG(colonne,ligne,tour);
    }
    public void Victoire(boolean tour){
        if(tour == true){
            JOptionPane.showMessageDialog(fenetre, "Victoire Pour ROUGE!");
        }else if(tour == false){
            JOptionPane.showMessageDialog(fenetre, "Victoire Pour JAUNE!");
        }
    }
    //------------------// Permet de regarder vers la droite //-----------------------//
    public void VerifierDroite(int colonne, int ligne, boolean tour){
        int compteurR = 0;
        int compteurJ = 0;
        int newColonne = 0;
        //voir à droite
        //tour joueur 1
        if(tour == true){
            for(int i = 0; i <= 3; i++){
                newColonne = colonne + i;
                if(newColonne >= horizontal){
                    break;
                }
                else if(tab[newColonne][ligne] == "Rouge"){
                    compteurR += 1;
                }
            }
            if(compteurR == 4){
                Victoire(tour);
            }
        }
        //tour joueur 2
        else if (tour == false) {
            for(int i = 0; i <= 3; i++){
                newColonne = colonne + i;
                if(newColonne >= horizontal){
                    break;
                }
                if(tab[newColonne][ligne] == "Jaune"){
                    compteurJ += 1;
                }
            }
            if(compteurJ == 4){
                Victoire(tour);
            }
        }
    }
    //------------------------------------------------------------------------------//
    //--------------------// Permet de regarder à gauche //-------------------------//
    public void VerifierGauche(int colonne, int ligne, boolean tour){
        int compteurR = 0;
        int compteurJ = 0;
        int newColonne = 0;
        //voir à droite
        //tour joueur 1
        if(tour == true){
            for(int i = 0; i <= 3; i++){
                newColonne = colonne - i;
                if(newColonne < 0){
                    break;
                }
                else if(tab[newColonne][ligne] == "Rouge"){
                    compteurR += 1;
                }
            }
            if(compteurR == 4){
                Victoire(tour);
            }
        }
        //tour joueur 2
        else if (tour == false) {
            for(int i = 0; i <= 3; i++){
                newColonne = colonne - i;
                if(newColonne < 0){
                    break;
                }
                if(tab[newColonne][ligne] == "Jaune"){
                    compteurJ += 1;
                }
            }
            if(compteurJ == 4){
                Victoire(tour);
            }
        }
    }
    //---------------------------------------------------------------------//
    //-----------------//Permet de regarder vers le haut//----------------//
    public void VerifierHaut(int colonne, int ligne, boolean tour){
        int compteurR = 0;
        int compteurJ = 0;
        int newLigne = 0;

        //tour joueur 1
        if(tour == true){
            for(int i = 0; i <= 3; i++){
                newLigne = ligne + i;
                if(newLigne >= vertical){
                    break;
                }
                else if(tab[colonne][newLigne] == "Rouge"){
                    compteurR += 1;
                }
            }
            if(compteurR == 4){
                Victoire(tour);
            }
        }
        //tour joueur 2
        else if (tour == false) {
            for(int i = 0; i <= 3; i++){
                newLigne = ligne + i;
                if(newLigne >= vertical){
                    break;
                }
                if(tab[colonne][newLigne] == "Jaune"){
                    compteurJ += 1;
                }
            }
            if(compteurJ == 4){
                Victoire(tour);
            }
        }
    }
    //----------------------------------------------------------------------//
    //--------------------------// Diagonal haut droite //-----------------------//
    public void VerifierDiagonalHautD(int colonne, int ligne, boolean tour){
        int compteurR = 0;
        int compteurJ = 0;
        int newLigne = 0;
        int newColonne = 0;

        //tour joueur 1
        if(tour == true){
            for(int i = 0; i <= 3; i++){
                newLigne = ligne - i;
                newColonne = colonne + i;
                if(newLigne < 0 || newColonne >= horizontal){
                    break;
                }
                else if(tab[newColonne][newLigne] == "Rouge"){
                    compteurR += 1;
                }
            }
            if(compteurR == 4){
                Victoire(tour);
            }
        }
        //tour joueur 2
        else if (tour == false) {
            for(int i = 0; i <= 3; i++){
                newLigne = ligne - i;
                newColonne = colonne + i;
                if(newLigne < 0 || newColonne >= horizontal){
                    break;
                }
                else if(tab[newColonne][newLigne] == "Jaune"){
                    compteurJ += 1;
                }
            }
            if(compteurJ == 4){
                Victoire(tour);
            }
        }
    }
    //----------------------------------------------------------------------------//
    //--------------------------// diagonal bas droite //------------------------//
    public void VerifierDiagonalBasD(int colonne, int ligne, boolean tour){
        int compteurR = 0;
        int compteurJ = 0;
        int newLigne = 0;
        int newColonne = 0;

        //tour joueur 1
        if(tour == true){
            for(int i = 0; i <= 3; i++){
                newLigne = ligne + i;
                newColonne = colonne + i;
                if(newLigne >= vertical || newColonne >= horizontal){
                    break;
                }
                else if(tab[newColonne][newLigne] == "Rouge"){
                    compteurR += 1;
                }
            }
            if(compteurR == 4){
                Victoire(tour);
            }
        }
        //tour joueur 2
        else if (tour == false) {
            for(int i = 0; i <= 3; i++){
                newLigne = ligne + i;
                newColonne = colonne + i;
                if(newLigne >= vertical || newColonne >= horizontal){
                    break;
                }
                else if(tab[newColonne][newLigne] == "Jaune"){
                    compteurJ += 1;
                }
            }
            if(compteurJ == 4){
                Victoire(tour);
            }
        }
    }
    //----------------------------------------------------------------------------------------//
    //------------------------// diagonal haut gauche //--------------------------------------//
    public void VerifierDiagonalHautG(int colonne, int ligne, boolean tour){
        int compteurR = 0;
        int compteurJ = 0;
        int newLigne = 0;
        int newColonne = 0;

        //tour joueur 1
        if(tour == true){
            for(int i = 0; i <= 3; i++){
                newLigne = ligne - i;
                newColonne = colonne - i;
                if(newLigne < 0 || newColonne < 0){
                    break;
                }
                else if(tab[newColonne][newLigne] == "Rouge"){
                    compteurR += 1;
                }
            }
            if(compteurR == 4){
                Victoire(tour);
            }
        }
        //tour joueur 2
        else if (tour == false) {
            for(int i = 0; i <= 3; i++){
                newLigne = ligne - i;
                newColonne = colonne - i;
                if(newLigne < 0 || newColonne < 0){
                    break;
                }
                else if(tab[newColonne][newLigne] == "Jaune"){
                    compteurJ += 1;
                }
            }
            if(compteurJ == 4){
                Victoire(tour);
            }
        }
    }
    //------------------------------------------------------------------------------------------//
    //------------------------------// diagonal bas gauche //-----------------------------------//
    public void VerifierDiagonalBasG(int colonne, int ligne, boolean tour){
        int compteurR = 0;
        int compteurJ = 0;
        int newLigne = 0;
        int newColonne = 0;

        //tour joueur 1
        if(tour == true){
            for(int i = 0; i <= 3; i++){
                newLigne = ligne + i;
                newColonne = colonne - i;
                if(newLigne >= vertical || newColonne < 0){
                    break;
                }
                else if(tab[newColonne][newLigne] == "Rouge"){
                    compteurR += 1;
                }
            }
            if(compteurR == 4){
                Victoire(tour);
            }
        }
        //tour joueur 2
        else if (tour == false) {
            for(int i = 0; i <= 3; i++){
                newLigne = ligne + i;
                newColonne = colonne - i;
                if(newLigne >= vertical || newColonne < 0){
                    break;
                }
                else if(tab[newColonne][newLigne] == "Jaune"){
                    compteurJ += 1;
                }
            }
            if(compteurJ == 4){
                Victoire(tour);
            }
        }
    }
}