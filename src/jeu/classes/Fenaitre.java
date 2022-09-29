/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jeu.classes;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JViewport;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import static jeu.classes.Fenaitre.BFS;


//Fennaitre principale
public class Fenaitre extends JFrame{
    public static JRadioButton BFS;
    public  static JRadioButton DFS;
     public static JRadioButton AStar;
     static JFrame frame = new JFrame("LSI MAZE GAME ");
     public static int status = 0;
    public Fenaitre(String titre,  JeuDeLabyrinrhe jeu, int largeur, int hauteur){
        
       
 
             JPanel pan1 = new JPanel();
		
		pan1.setPreferredSize(new Dimension( largeur,hauteur));
		
                  
                  frame.setLayout(new BorderLayout());
              
               frame.add(jeu);
                 
                
       frame.setPreferredSize(new Dimension(largeur, hauteur));
        frame.setMaximumSize(new Dimension(largeur, hauteur));
        frame.setMinimumSize(new Dimension(largeur, hauteur));
     frame.setSize(largeur, hauteur);
        
        frame.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
    frame.setVisible(true);
            
	 
    }
          

   
}
