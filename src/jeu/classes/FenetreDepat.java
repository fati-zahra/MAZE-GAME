package jeu.classes;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.Timer;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import static jeu.classes.GérantEntité.max_bonus;
import static jeu.classes.JeuDeLabyrinrhe.HAUTEUR;
import static jeu.classes.JeuDeLabyrinrhe.LARGEUR;
import java.awt.event.*;

//Affichage de cette interface pendant 6 seconds
public class FenetreDepat extends JFrame {

    private JLabel label;
    private Timer timer;
    private int count = 0;

    public FenetreDepat(String titre, int largeur, int hauteur) {
        System.out.println("Maze Game");

        JFrame frame = new JFrame(titre);
        frame.setLayout(new BorderLayout());

        frame.setPreferredSize(new Dimension(largeur, hauteur));
        frame.setMaximumSize(new Dimension(largeur, hauteur));
        frame.setMinimumSize(new Dimension(largeur, hauteur));
    
        frame.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setBackground(new Color(255, 105, 180));
        panel.setBounds(0, 0, largeur, hauteur);
        frame.getContentPane().add(panel);
        frame.add(new Test.TestPane());

        timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                count++;
                if (count <= 6) {
                    frame.setVisible(true);

                } else {
                    ((Timer) (e.getSource())).stop();
                    frame.setVisible(false);

                }
            }
        });
        timer.setInitialDelay(0);
        timer.start();

    }
}
