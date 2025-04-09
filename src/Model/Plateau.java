package Model;

public class Plateau {
    public static final int MOUVEMENT_INVALIDE = -1; // Simplement une valeur qui sera toujours refusée. Pour la lisibilité.
    private Jeton[][] colonnes; // Le jeu est habituellement en format 7 x 6.
    public static final int NB_Lignes = 6;
    public static final int NB_Colonnes = 7;

    // Constructeur
    public Plateau(){
        colonnes = new Jeton[NB_Colonnes][NB_Lignes];
    }

    public int ajouterJeton(int colonne, Jeton jeton){
        if(colonne >= NB_Colonnes){
            return MOUVEMENT_INVALIDE; // Parce qu'il faut retourner quelque chose
        }
        // on va parcourir l'array jusqu'à ce qu'on trouve un trou vide
        for(int ligne = 0; ligne < NB_Lignes; ligne++){
            if (colonnes[colonne][ligne] == null){ // si le slot est libre..
                colonnes[colonne][ligne] = jeton; // on dépose le jeton!
                return ligne; // Il faut connaître la ligne où le jeton est tombé-- on connaît déjà la colonne, mais pas la ligne sinon
            }
        }
        return MOUVEMENT_INVALIDE; // Quand la colonne est pleine
    }

    // Va être appelé depuis mettreAJourGrille pour vérifier le contenu de la grille
    public Jeton getJeton(int colonne, int ligne){
        return colonnes[colonne][ligne];
    }

    public boolean verifierVictoire(int colonne, int ligneDuDernierJeton) { // nom un peu long, mais derniereLigne ou dernierJeton porte un peu à confusion

        return false;
    }
}
