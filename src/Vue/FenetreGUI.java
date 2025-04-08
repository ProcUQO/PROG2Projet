package Vue;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
                panelGrille.add(cellulesGrille[ligne][col]);
            }
        }

        add(panelGrille, BorderLayout.CENTER);

        setVisible(true);

        // Ajout des écouteurs d'événements
        /*
        boutonAjouterColonne1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ...();
            }
        }); */
    }
}
