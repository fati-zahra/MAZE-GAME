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
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 *
 * @author Dell
 */
//classe pour représenté ennemie de joueur
public class Enemie extends Entité {
   
     protected final int LARGEURE = JeuDeLabyrinrhe.tailleCaze;
     protected final int HAUTEURE = JeuDeLabyrinrhe.tailleCaze;
        private BufferedImage image;
      Dimension Loc = new Dimension();
    public Enemie(int x, int y, IDEntité id) throws IOException {
        super(x, y, id);
             this.Loc.width = x;
          this.Loc.height = y;
        this.setLocE(Loc);
        if(JeuDeLabyrinrhe.tailleCaze == 12){
        image = ImageIO.read(new File("files/momo/ennemi.png"));
        }else{
           image = ImageIO.read(new File("files/momo/ennemi24.png"));  
        }
    }
    
    // modification de l'ennemie dans le maze
    @Override
    protected void update() {
             this.Loc.width = x;
          this.Loc.height = y;
        this.setLocE(Loc);
             
    }
    //dessin de l'ennemie
    @Override
    protected void render(Graphics g) {
       // g.setColor(Color.pink);
        //g.fillRect(x,y,LARGEURE ,HAUTEURE);
       // g.fillOval(x, y,LARGEURE, HAUTEURE);
         g.drawImage(image, x, y, null);
    }
    // methode pour les collision avec les autres ebtitées
      @Override
    protected Rectangle entourer() {
         return new Rectangle(x,y,LARGEURE ,HAUTEURE);
    }
    
    // getter et setter pour la location de l'ennemie
    public  Dimension getLocE(){
     
        this.Loc.width = this.Loc.width /JeuDeLabyrinrhe.tailleCaze;
           this.Loc.height = this.Loc.height /JeuDeLabyrinrhe.tailleCaze;
       return this.Loc;
   }
     public  void setLocE(Dimension loc){
             this.Loc=loc;
          
   } 
}
