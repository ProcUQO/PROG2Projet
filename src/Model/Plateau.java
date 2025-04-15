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

    // Retourne la ligne du jeton qui vient d'être placé
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

    // Fonction de détection, inspiré de ce forum : https://stackoverflow.com/questions/32770321/connect-4-check-for-a-win-algorithm
    // Utilise la ligne et la colonne du jeton qui vient d'être droppé
    public boolean verifierVictoire(int colonne, int ligneDuDernierJeton) { // nom un peu long, mais derniereLigne ou dernierJeton porte un peu à confusion

        // On va prendre la couleur, pour ne pas faire n'importe quoi
        String couleur = colonnes[colonne][ligneDuDernierJeton].getCouleur();

        // Vérification horizontale
        if(verifierDirection(colonne, ligneDuDernierJeton, couleur, 1, 0)) { // changement de colonne, même ligne
            return true;
        }
        // Vérification verticale
        if(verifierDirection(colonne, ligneDuDernierJeton, couleur, 0, 1)) { // changement de ligne, même colonne
            return true;
        }

        // Vérification diagonale
        if(verifierDirection(colonne, ligneDuDernierJeton, couleur, 1, 1)) { // vers le haut, à gauche
            return true;
        }

        // Vérification diagonale (inverse)
        if(verifierDirection(colonne, ligneDuDernierJeton, couleur, 1, -1)) { // vers bas, à gauche
            return true;
        }

        return false;
    }

    // Va être appelée 4 fois, vérifie les jetons dans une direction et dans la direction opposée.
    private boolean verifierDirection(int colonne, int ligneDuDernierJeton, String couleur, int colonneDelta, int ligneDelta) {
        int compteur = 1; // Le compteur du connect 4, qui commence à 1 parce qu'on compte le jeton qu'on vient de drop

        // On vérifie dans la première direction
        for(int i = 1; i < 4; i++){
            int newColonne = colonne + i * colonneDelta;
            int nouvelleLigne = ligneDuDernierJeton + i * ligneDelta;

            // Le jeu fonctionne sans cette vérification, mais ça apaise la console. En fait, on ne veut pas vérifier à l'extérieur de la grille, car ça ne sert à rien et n'existe pas.
            if(newColonne >= 0 && newColonne < NB_Colonnes && nouvelleLigne >= 0 && nouvelleLigne < NB_Lignes){
                // On vérfiei si c'est la même couleur de jeton ( ou s'il y a une couleur tout court)
                if (colonnes[newColonne][nouvelleLigne] != null && colonnes[newColonne][nouvelleLigne].getCouleur().equals(couleur)){
                    compteur++;
                } else {
                    break; // On arrête (quand ce n'est pas un jeton de la même couleur
                }
            }

        }

        // Même logique, dans la direction opposée.
        for(int i = 1; i < 4; i++){
            int newColonne = colonne - i * colonneDelta;
            int nouvelleLigne = ligneDuDernierJeton - i * ligneDelta;

            if(newColonne >= 0 && newColonne < NB_Colonnes && nouvelleLigne >= 0 && nouvelleLigne < NB_Lignes){
                if (colonnes[newColonne][nouvelleLigne] != null && colonnes[newColonne][nouvelleLigne].getCouleur().equals(couleur)){
                    compteur++;
                } else {
                    break;
                }
            }
        }

        return compteur >= 4;
    }

    public boolean estPlein() {
        // On regarde TOUTES les colonnes et lignes pour voir si un emplacement est vide
        for(int colonne = 0; colonne < NB_Colonnes; colonne++){
            for(int ligne=0; ligne < NB_Lignes; ligne++){
                if(colonnes[colonne][ligne] == null)
                    // Si on le trouve, c'est pas plein.
                    return false;
            }
        }
        return true; // Si ça se rend ici, c'est parce qu'on a trouvé aucun emplacement vide.
    }

}
