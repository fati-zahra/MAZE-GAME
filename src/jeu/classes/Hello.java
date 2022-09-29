/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jeu.classes;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import static jeu.classes.Chronometer.hours;
import static jeu.classes.Chronometer.minutes;
import static jeu.classes.Chronometer.seconds;
import static jeu.classes.GérantEntité.max_bonus;
import static jeu.classes.JeuDeLabyrinrhe.HAUTEUR;
import static jeu.classes.JeuDeLabyrinrhe.LARGEUR;


// fennaitre aprées la fennaitre de d^part pour choisir la labyrinthe
public class Hello extends JFrame{
    public static JRadioButton un;
    public  static JRadioButton deux;
     public static JRadioButton trois;
      public static JRadioButton quatre;
     public static int status = 0;
    public Hello(String titre,  int largeur, int hauteur){
        System.out.println("hello");
     
     
        JFrame frame = new JFrame(titre);
        frame.setLayout(new BorderLayout());
           //JButton btn= new JButton("btn
             JPanel pan1 = new JPanel();
		
		pan1.setPreferredSize(new Dimension( largeur,hauteur));
		pan1.setBackground(new Color(255,192,203));
           
                   pan1.setLayout(null);
                  frame.getContentPane().add(pan1, BorderLayout.CENTER);  
                  
          JPanel zone = new JPanel(new GridLayout(3,2));
        LineBorder linedBorder = new LineBorder(Color.black);
        TitledBorder titledBorder = BorderFactory.createTitledBorder(linedBorder, "Maze size");
       
        zone.setBorder(titledBorder);
        zone.setBounds(200, 80, 400,140);
        zone.setBackground(new Color(255,192,203));
        pan1.add(zone);
        
        //JButtonGroupe
        ButtonGroup btngroupe= new ButtonGroup();
          un = new JRadioButton();
        un.setText("MAZE 21*21");
        btngroupe.add(un);
        zone.add(un);
        
        deux= new JRadioButton();
        deux.setText("MAZE 41*41");
        btngroupe.add(deux);
        zone.add(deux);
        
        trois = new JRadioButton();
        trois.setText("MAZE 61*61");
        btngroupe.add(trois);
        zone.add(trois);
        
         quatre = new JRadioButton();
        quatre.setText("MAZE 81*81");
        btngroupe.add(quatre);
        zone.add(quatre);
        JLabel lb = new JLabel("During the game, please click the A key if you want help ;)");
        lb.setFont(new Font("Serif", Font.BOLD, 19));
        lb.setForeground(new Color(13,144,178));
              
                lb.setBounds(200,200,500,300);
                pan1.add(lb);
        frame.setPreferredSize(new Dimension(largeur, hauteur));
        frame.setMaximumSize(new Dimension(largeur, hauteur));
        frame.setMinimumSize(new Dimension(largeur, hauteur));
       //frame.add(jeu);
        frame.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
    
  frame.setVisible(true);
       // listerner de choix de taille de labyrinthe
     un.addItemListener(new ItemListener() {
    			public void itemStateChanged(ItemEvent event) {
    				  if (event.getStateChange() == ItemEvent.SELECTED) {
    				         	System.out.println("hello");
                                                JeuDeLabyrinrhe.widthM = 21;
                                                 JeuDeLabyrinrhe.hiegthM = 21;
                                                    JeuDeLabyrinrhe.verif = 1;
                                                      JeuDeLabyrinrhe.tailleCaze = 35;
                                                     JeuDeLabyrinrhe.secondeOver = 0;
                                                      JeuDeLabyrinrhe.minuteOver = 1;
                                                    GérantEntité.max_nb_bonus=4;
                                                         GérantEntité.max_bonus=4;
                                                          GérantEntité.max_nb_ennemies =4; 
                                                   //JeuDeTire jeu = new JeuDeLabyrinrhe();
                                                    //jeu.boucleDuJeu();
                                                      frame.setVisible(false);
                                                      
    				  }
    				  }
       });   
         deux.addItemListener(new ItemListener() {
    			public void itemStateChanged(ItemEvent event) {
    				  if (event.getStateChange() == ItemEvent.SELECTED) {
    				         	System.out.println("hello");
                                                JeuDeLabyrinrhe.widthM = 41;
                                                 JeuDeLabyrinrhe.hiegthM = 41;
                                                    JeuDeLabyrinrhe.verif = 1;
                                                     JeuDeLabyrinrhe.tailleCaze = 23;
                                                     JeuDeLabyrinrhe.minuteOver = 1;
                                                         JeuDeLabyrinrhe.secondeOver =30;
                                                     GérantEntité.max_nb_bonus=5;
                                                      GérantEntité.max_bonus=5;
                                                      GérantEntité.max_nb_ennemies =8; 
                                                 
                                                      frame.setVisible(false);
                                                      
    				  }
    				  }
       });
               trois.addItemListener(new ItemListener() {
    			public void itemStateChanged(ItemEvent event) {
    				  if (event.getStateChange() == ItemEvent.SELECTED) {
    				         	System.out.println("hello");
                                                JeuDeLabyrinrhe.widthM = 61;
                                                 JeuDeLabyrinrhe.hiegthM = 61;
                                                    JeuDeLabyrinrhe.verif = 1;
                                                     JeuDeLabyrinrhe.tailleCaze = 16;
                                                    GérantEntité.max_nb_ennemies =12; 
                                                      GérantEntité.max_nb_bonus=9;
                                                      GérantEntité.max_bonus=9;
                                                         JeuDeLabyrinrhe.minuteOver = 1;
                                                         JeuDeLabyrinrhe.secondeOver = 50;
                                                 
                                                      frame.setVisible(false);
                                                      
    				  }
    				  }
       });
      quatre.addItemListener(new ItemListener() {
    			public void itemStateChanged(ItemEvent event) {
    				  if (event.getStateChange() == ItemEvent.SELECTED) {
    				         	System.out.println("hello");
                                                JeuDeLabyrinrhe.widthM = 81;
                                                 JeuDeLabyrinrhe.hiegthM = 81;
                                                    JeuDeLabyrinrhe.verif = 1;
                                                  JeuDeLabyrinrhe.tailleCaze = 12;
                                                  GérantEntité.max_nb_ennemies =16; 
                                                      GérantEntité.max_nb_bonus=13;
                                                      GérantEntité.max_bonus=13;
                                                      JeuDeLabyrinrhe.minuteOver = 3;
                                                        JeuDeLabyrinrhe.secondeOver = 0;
                                                  
                                                      frame.setVisible(false);
                                                      
    				  }
    				  }
       });

    }      
    public int getStatus(){
            
                System.out.println("hello in fenaitrestatus" +this.status);
                return this.status;
           }
}
