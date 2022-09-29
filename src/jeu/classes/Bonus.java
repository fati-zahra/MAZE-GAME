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

// class pour afficher les bonus et leur modification dans l'interface
public class Bonus extends Entité {
    
      private BufferedImage image;
     protected final int LARGEURE = JeuDeLabyrinrhe.tailleCaze;
     protected final int HAUTEURE = JeuDeLabyrinrhe.tailleCaze;
     public Dimension Loc = new Dimension();
    public Bonus(int x, int y, IDEntité id) throws IOException {
        super(x, y, id);
        this.Loc.width = x;
          this.Loc.height = y;
           this.setLocB(Loc);
           if(JeuDeLabyrinrhe.tailleCaze == 12){
              image = ImageIO.read(new File("files/momo/bonus.png"));
           }else{
               image = ImageIO.read(new File("files/momo/bonus22.png")); 
           }
    }
    //modification de bonus
    @Override
    protected void update() {
           this.Loc.width = x;
          this.Loc.height = y;
              this.setLocB(Loc);
    }
//dessiner le bonus
    @Override
    protected void render(Graphics g) {
   
      
      g.drawImage(image, x, y, null);
       
        
    }
      @Override
    protected Rectangle entourer() {
         return new Rectangle(x,y,LARGEURE ,HAUTEURE);
    }
    // determiner la location de bonus
      public  Dimension getLocB(){
     
        this.Loc.width = this.Loc.width /JeuDeLabyrinrhe.tailleCaze;
           this.Loc.height = this.Loc.height /JeuDeLabyrinrhe.tailleCaze;
       return this.Loc;
   }
     public  void setLocB(Dimension loc){
             this.Loc=loc;
          
   }
}
