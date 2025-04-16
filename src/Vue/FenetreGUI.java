package Vue;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Controller.Connect4Controller;
import Model.Jeton;
import Model.Plateau;

public class FenetreGUI extends JFrame {
    private JButton[] boutonsAjouterColonne;
    private JPanel panelGrille;
    private JPanel panelBoutons;
    private JLabel[][] cellulesGrille; // Inspiré de cette vidéo : https://www.youtube.com/watch?v=impJtkTcQ94
    private Connect4Controller controller; // Pour la partie controller, avec l'ajout de jeton au visuel

    // Constructeur
    public FenetreGUI(){

        // valeurs reprisent de layout.java
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(700, 600);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout()); // Pour mieux structurer la GUI
        // Le choix de borderlayout est inspiré de https://www.youtube.com/watch?v=1G4lBJW1vfM. On peut facilement assigner des directions.

        // On fait un panneau séparé pour les boutons, c'est plus facile de les réorganiser comme ça.
        JPanel panelBoutons = new JPanel(new GridLayout(1, Plateau.NB_Colonnes)); // 1,7 car les boutons sont tous sur la même ligne
        boutonsAjouterColonne = new JButton[Plateau.NB_Colonnes];
        for(int i = 0; i < Plateau.NB_Colonnes; i++){
            boutonsAjouterColonne[i] = new JButton(String.valueOf(i + 1));
            panelBoutons.add(boutonsAjouterColonne[i]);  // Ajout des composants à la fenêtre, parce que c'dest bien initialiser mais ce n'est pas suffisant (notion du visuel, interaction, etc..)

        }

        // l'ajout final
        add(panelBoutons, BorderLayout.NORTH);

        // Panneau principal de la grille
        panelGrille = new JPanel(new GridLayout(Plateau.NB_Lignes, Plateau.NB_Colonnes));
        cellulesGrille = new JLabel[Plateau.NB_Lignes][Plateau.NB_Colonnes];

        // Pour ajouter la grille, il faut traverser toute la vraie grille
        for(int ligne = 0; ligne < Plateau.NB_Lignes; ligne++){
            for(int col = 0; col < Plateau.NB_Colonnes; col++){
                cellulesGrille[ligne][col] = new JLabel();
                cellulesGrille[ligne][col].setBorder(BorderFactory.createLineBorder(Color.BLACK));
                cellulesGrille[ligne][col].setOpaque(true);
                /* Apparemment, pour changer la couleur pour JLabel, il faut rendre le background opaque (il ne l'est pas par défaut).
                Merci à ce forum : https://stackoverflow.com/questions/2380314/how-do-i-set-a-jlabels-background-color/2380328 */
                cellulesGrille[ligne][col].setBackground(Color.WHITE);
                panelGrille.add(cellulesGrille[ligne][col]);
            }
        }

        add(panelGrille, BorderLayout.CENTER);

        setVisible(true);

    }

    public void mettreAJourGrille(Plateau plateau) {
        // Logique similaire au loop précédent mais pour ajouter les icônes, faire tomber le jeton
        // Il faut retraverser le tableau pour voir quelle case est occupée
        for(int ligne = 0; ligne < Plateau.NB_Lignes; ligne++){
            for(int col = 0; col < Plateau.NB_Colonnes; col++){
                Jeton jeton = plateau.getJeton(col, ligne); // Pour la gestion d'autre jetons que rouge
                if (jeton != null) {
                    String couleur = jeton.getCouleur();
                    if (couleur.equals("rouge")) {
                        cellulesGrille[Plateau.NB_Lignes - ligne - 1][col].setBackground(Color.RED);
                    } else if (couleur.equals("jaune")) {
                        cellulesGrille[Plateau.NB_Lignes - ligne - 1][col].setBackground(Color.YELLOW);
                    }
                } else {
                    cellulesGrille[Plateau.NB_Lignes - ligne - 1][col].setBackground(Color.WHITE);
                }
            }
        }
    }

    public void lierControlleur(Connect4Controller controller) {
        // On traverse des listener, vu qu'il y en a plusieurs
        this.controller = controller;

        for (int i = 0; i < boutonsAjouterColonne.length; i++) {
            int colonne = i;
            boutonsAjouterColonne[i].addActionListener(e -> controller.ajoutJetonColonne(colonne));
        }
    }
}
