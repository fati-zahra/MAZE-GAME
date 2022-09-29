/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jeu.classes;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;

/**
 *
 * @author Dell
 */
//représente le score de joueur
public class Score extends Entité {
     GérantEntité gérant;
   
     protected final int LARGEURE = 1300;
     protected final int HAUTEURE = 240;
    public Score(int x, int y, IDEntité id) {
        super(x, y, id);
     
    }

    @Override
    protected void update() {
        
             
    }

    @Override
    protected void render(Graphics g) {
          g.setFont(new Font("TimesRoman", Font.PLAIN, 22)); 
           g.setColor(Color.black);
              g.drawString("SCORE" , x-40, y-30);
            g.setColor(Color.black);
      g.drawString("   "+Joueur.SCORE , x, y);
     
 
         
    }
    
      @Override
    protected Rectangle entourer() {
         return new Rectangle(x,y,LARGEURE ,HAUTEURE);
    }
    
}
