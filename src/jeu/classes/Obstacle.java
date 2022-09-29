/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jeu.classes;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

/**
 *
 * @author Dell
 */
//représenter les obstacles càd les murs de maze
public class Obstacle extends Entité {
   
     protected final int LARGEURE = JeuDeLabyrinrhe.tailleCaze;
     protected final int HAUTEURE = JeuDeLabyrinrhe.tailleCaze;
    public Obstacle(int x, int y, IDEntité id) {
        super(x, y, id);
     
    }

    @Override
    protected void update() {
        
             
    }

    @Override
    protected void render(Graphics g) {
   
       g.setColor(new Color(13,144,178));
       g.fillRect( x,  y ,LARGEURE, HAUTEURE);
     
       
        
    }
      @Override
    protected Rectangle entourer() {
         return new Rectangle(x,y,LARGEURE ,HAUTEURE);
    }
    
}
