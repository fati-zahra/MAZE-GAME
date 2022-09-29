/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jeu.classes;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Rectangle;

/**
 *
 * @author Dell
 */
//classe qui permet la représentation des chemins dans maze
public class Chemin extends Entité {
   
     protected final int LARGEURE = 6;
     protected final int HAUTEURE = 6;
    //constructeur
    public Chemin(int x, int y, IDEntité id) {
        super(x, y, id);
     
    }
    //modification de chemin 
    @Override
    protected void update() {
        
             
    }
    //dessin de chemin avec une caze  de taille JeuDeLabyrinrhe.tailleCaze
    @Override
    protected void render(Graphics g) {
    
      g.setColor(Color.white);
      g.fillRect( x ,  y, JeuDeLabyrinrhe.tailleCaze, JeuDeLabyrinrhe.tailleCaze);
 
       
        
    }
    // methode implementer pour les intersections
      @Override
    protected Rectangle entourer() {
         return new Rectangle(x,y,LARGEURE ,HAUTEURE);
    }
    
}
