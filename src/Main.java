import Controller.Connect4Controller;
import Model.Plateau;
import Vue.FenetreGUI;
import TurnBased.Tableau;

// Le main sert seulement à initialiser notre vue/contrôleur/modèle (MVC)
public class Main {
    public static void main(String[] args) {
        //Plateau model = new Plateau(); // Modèle
        FenetreGUI view = new FenetreGUI(); // view, nous allons peut-être changer le nom, plus tard.
        //Connect4Controller controller = new Connect4Controller(model, view); // et notre contrôleur, qui devra avoir accès au modèle et à la vue
        Tableau tab = new Tableau();
    }
}