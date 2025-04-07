package Vue;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FenetreGUI extends JFrame {
    private final JButton boutonAjouterColonne1;
    private final JButton boutonAjouterColonne2;
    private final JButton boutonAjouterColonne3;
    private final JButton boutonAjouterColonne4;
    private final JButton boutonAjouterColonne5;
    private final JButton boutonAjouterColonne6;
    private final JButton boutonAjouterColonne7;

    public FenetreGUI(){

        // valeurs reprisent de layout.java
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 200);
        setLocationRelativeTo(null);
        setLayout(new FlowLayout());


        // Initialisation des composants, bref des boutons, des attributs
        boutonAjouterColonne1 = new JButton("1");
        boutonAjouterColonne2 = new JButton("2");
        boutonAjouterColonne3 = new JButton("3");
        boutonAjouterColonne4 = new JButton("4");
        boutonAjouterColonne5 = new JButton("5");
        boutonAjouterColonne6 = new JButton("6");
        boutonAjouterColonne7 = new JButton("7");

        // Ajout des composants à la fenêtre, parce que c'dest bien initialiser mais ce n'est pas suffisant (notion du visuel, interaction, etc..)
        add(boutonAjouterColonne1);
        add(boutonAjouterColonne2);
        add(boutonAjouterColonne3);
        add(boutonAjouterColonne4);
        add(boutonAjouterColonne5);
        add(boutonAjouterColonne6);
        add(boutonAjouterColonne7);

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
