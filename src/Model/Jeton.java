package Model;

public class Jeton {
    protected String couleur; // Rouge, bleu, peut-être même jaune ou vert, comme on veut

    public Jeton(String couleur){
        this.couleur = couleur;
    }

    public String getCouleur(){
        return couleur;
    }

    public void setCouleur(String couleur){
        this.couleur = couleur;
    }
}
