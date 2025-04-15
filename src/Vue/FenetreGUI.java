package Vue;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import TurnBased.Turn;
import TurnBased.Tableau;
import Controller.Connect4Controller;
import Model.Plateau;

public class FenetreGUI extends JFrame {
    private final JButton boutonAjouterColonne1;
    private final JButton boutonAjouterColonne2;
    private final JButton boutonAjouterColonne3;
    private final JButton boutonAjouterColonne4;
    private final JButton boutonAjouterColonne5;
    private final JButton boutonAjouterColonne6;
    private final JButton boutonAjouterColonne7;
    private JPanel panelGrille;
    private JPanel panelBoutons;
    private JLabel[][] cellulesGrille; // Inspiré de cette vidéo : https://www.youtube.com/watch?v=impJtkTcQ94
    private Connect4Controller controller; // Pour la partie controller, avec l'ajout de jeton au visuel
    Turn tour = new Turn();
    Tableau tableau = new Tableau();
    private int ligne;

    // Constructeur
    public FenetreGUI(){

        // valeurs reprisent de layout.java
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(700, 600);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout()); // Pour mieux structurer la GUI
        // Le choix de borderlayout est inspiré de https://www.youtube.com/watch?v=1G4lBJW1vfM. On peut facilement assigner des directions.

        // On fait un panneau séparé pour les boutons, c'est plus facile de les réorganiser comme ça.
        JPanel panelBoutons = new JPanel(new GridLayout(1, 7)); // 1,7 car les boutons sont tous sur la même ligne
        boutonAjouterColonne1 = new JButton("1");
        boutonAjouterColonne2 = new JButton("2");
        boutonAjouterColonne3 = new JButton("3");
        boutonAjouterColonne4 = new JButton("4");
        boutonAjouterColonne5 = new JButton("5");
        boutonAjouterColonne6 = new JButton("6");
        boutonAjouterColonne7 = new JButton("7");

        // Ajout des composants à la fenêtre, parce que c'dest bien initialiser mais ce n'est pas suffisant (notion du visuel, interaction, etc..)
        panelBoutons.add(boutonAjouterColonne1);
        panelBoutons.add(boutonAjouterColonne2);
        panelBoutons.add(boutonAjouterColonne3);
        panelBoutons.add(boutonAjouterColonne4);
        panelBoutons.add(boutonAjouterColonne5);
        panelBoutons.add(boutonAjouterColonne6);
        panelBoutons.add(boutonAjouterColonne7);

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

        //------------// Ajout des écouteurs d'événements //------------//

        boutonAjouterColonne1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ligne = tableau.TabAddColor(0, tour.tourJoueur1);
                //tableau.SetTableau();
                mettreAJourGrille();
                tableau.VerifierVictoire(0, ligne, tour.tourJoueur1);
                tour.ChangeTurn();
            }
        });
        boutonAjouterColonne2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ligne = tableau.TabAddColor(1, tour.tourJoueur1);
                //tableau.SetTableau();
                mettreAJourGrille();
                tableau.VerifierVictoire(1, ligne, tour.tourJoueur1);
                tour.ChangeTurn();
            }
        });
        boutonAjouterColonne3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ligne = tableau.TabAddColor(2, tour.tourJoueur1);
                //tableau.SetTableau();
                mettreAJourGrille();
                tableau.VerifierVictoire(2, ligne, tour.tourJoueur1);
                tour.ChangeTurn();
            }
        });
        boutonAjouterColonne4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ligne = tableau.TabAddColor(3, tour.tourJoueur1);
                //tableau.SetTableau();
                mettreAJourGrille();
                tableau.VerifierVictoire(3, ligne, tour.tourJoueur1);
                tour.ChangeTurn();
            }
        });
        boutonAjouterColonne5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ligne = tableau.TabAddColor(4, tour.tourJoueur1);
                //tableau.SetTableau();
                mettreAJourGrille();
                tableau.VerifierVictoire(4, ligne, tour.tourJoueur1);
                tour.ChangeTurn();
            }
        });
        boutonAjouterColonne6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ligne = tableau.TabAddColor(5, tour.tourJoueur1);
                //tableau.SetTableau();
                mettreAJourGrille();
                tableau.VerifierVictoire(5, ligne, tour.tourJoueur1);
                tour.ChangeTurn();
            }
        });
        boutonAjouterColonne7.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ligne = tableau.TabAddColor(6, tour.tourJoueur1);
                //tableau.SetTableau();
                mettreAJourGrille();
                tableau.VerifierVictoire(6, ligne, tour.tourJoueur1);
                tour.ChangeTurn();
            }
        });

        //------------------------------------------------------------//
    }

    public void mettreAJourGrille() {
        // Logique similaire au loop précédent mais pour ajouter les icônes, faire tomber le jeton
        // Temporaire, vu que j'utilise juste les jetons rouge en ce moment, déso William
        // Il faut retraverser le tableau pour voir quelle case est occupée
        for(int i = 0; i < tableau.horizontal; i++){
            for(int j = tableau.vertical - 1; j > -1; j --){
                if(tableau.tab[i][j] != null) {
                    if(tableau.tab[i][j] == "Jaune")
                        cellulesGrille[j][i].setBackground(Color.YELLOW);
                    if(tableau.tab[i][j] == "Rouge"){
                        cellulesGrille[j][i].setBackground(Color.RED);
                    }
                }
            }
        }
    }

    public void lierControlleur(Connect4Controller controller) {
        // Beeeennn des listener, vu qu'il y en a plusieurs
        this.controller = controller;

        boutonAjouterColonne1.addActionListener(e -> controller.ajoutJetonColonne(0));
        boutonAjouterColonne2.addActionListener(e -> controller.ajoutJetonColonne(1));
        boutonAjouterColonne3.addActionListener(e -> controller.ajoutJetonColonne(2));
        boutonAjouterColonne4.addActionListener(e -> controller.ajoutJetonColonne(3));
        boutonAjouterColonne5.addActionListener(e -> controller.ajoutJetonColonne(4));
        boutonAjouterColonne6.addActionListener(e -> controller.ajoutJetonColonne(5));
        boutonAjouterColonne7.addActionListener(e -> controller.ajoutJetonColonne(6));


    }
}
