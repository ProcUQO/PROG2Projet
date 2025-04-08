package Model;

public class Plateau {
    private Jeton[][] colonnes; // Le jeu est habituellement en format 7 x 6.
    public static final int NB_Lignes = 6;
    public static final int NB_Colonnes = 7;

    // Constructeur
    public Plateau(){
        colonnes = new Jeton[NB_Colonnes][NB_Lignes];
    }

    public void ajouterJeton(int colonne, Jeton jeton){
        if(colonne >= NB_Colonnes){
            return; // parce que logiquement, on veut que la colonne existe.
        }
        // on va parcourir l'array jusqu'à ce qu'on trouve un trou vide
        for(int ligne = 0; ligne < NB_Lignes; ligne++){
            if (colonnes[colonne][ligne] == null){ // si le slot est libre..
                colonnes[colonne][ligne] = jeton; // on dépose le jeton !
                return;
            }
        return; // Quand la colonne est pleine.
        }
    }
}
