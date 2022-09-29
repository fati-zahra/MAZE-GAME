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
import static jeu.classes.Chronometer.hours;
import static jeu.classes.Chronometer.minutes;
import static jeu.classes.Chronometer.seconds;
import static jeu.classes.GérantEntité.max_bonus;
import static jeu.classes.JeuDeLabyrinrhe.HAUTEUR;
import static jeu.classes.JeuDeLabyrinrhe.LARGEUR;


/**
 *
 * @author Dell
 */
// class qui permet au joeur d'observé les options de l'aide
public class Aide extends JFrame{
   public static  int seconds, minutes, hours;
	public  Timer chronometer;
	private JButton runStop, restart;
	private JLabel time;
    public Aide(){
     
        this.setTitle("Help me :)");
		this.setSize(400, 200);
		//this.setDefaultCloseOperation(EXIT_ON_CLOSE);
                setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.getContentPane().setLayout(null);
		
		
	
		// option 
		JLabel a1 = new JLabel("Press the B key to view the path with BFS");
                a1.setForeground(new Color(13,144,178));
                this.add(a1);
                a1.setBounds(10, 10, 400, 100);
                JLabel a2 = new JLabel("Press the C key to view the path with DFS");
                a2.setForeground(new Color(13,144,178));
                this.add(a2);
                  a2.setBounds(10, 30, 400, 100);
             JLabel a3 = new JLabel("Press the Space key to view BOUNUS");
             a3.setForeground(new Color(13,144,178));
             this.add(a3);
               a3.setBounds(10, 50, 400, 100);
		JLabel a4 = new JLabel("Press the E key to view the path with ASTAR");
                a4.setForeground(new Color(13,144,178));
                   a4.setBounds(10, 70, 400, 100);
                this.add(a4);
		

		
             
	  
    }      
    
}
