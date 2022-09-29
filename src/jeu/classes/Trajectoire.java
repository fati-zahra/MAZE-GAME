/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jeu.classes;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;
import static jeu.classes.JeuDeLabyrinrhe.HAUTEUR;
import static jeu.classes.JeuDeLabyrinrhe.LARGEUR;
import static jeu.classes.JeuDeLabyrinrhe.HAUTEUR;

/**
 *
 * @author Dell
 */

// dissiner des fléches lors de demande de l'aide
public class Trajectoire extends Entité {

   GérantEntité gérant;
     protected final int LARGEURE = 6;
     protected final int HAUTEURE = 6;
     public Dimension path;
     public static String i;
    public Trajectoire(String i,int x, int y, IDEntité id, GérantEntité gérant) {
        super(x, y, id);
        this.i =i;
        this.gérant = gérant;
    }

    @Override
    protected void update() {
    
              
    }

    @Override
    protected void render(Graphics g) {
      g.setFont(new Font("TimesRoman", Font.PLAIN, 17)); 
      g.setColor(Color.red);
       
          g.drawString(""+i, 3 + x * JeuDeLabyrinrhe.tailleCaze,10+  y * JeuDeLabyrinrhe.tailleCaze);
 
       
        
    }
      @Override
    protected Rectangle entourer() {
         return new Rectangle(x,y,LARGEURE ,HAUTEURE);
    }
    
}
