/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jeu.classes;

import java.awt.Color;
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
// la sortie de maze
public class Sortie extends Entité {
    
         private BufferedImage image;
     protected final int LARGEURE = 25;
     protected final int HAUTEURE = 25;
    public Sortie(int x, int y, IDEntité id) throws IOException {
        super(x, y, id);
        if(JeuDeLabyrinrhe.tailleCaze == 12){
     image = ImageIO.read(new File("files/momo/finish-flag.png"));
    }else {
               image = ImageIO.read(new File("files/momo/finish-flag24.png"));
        }
    }
    @Override
    protected void update() {
        
             
    }

    @Override
    protected void render(Graphics g) {
   
      // g.setColor(Color.pink);
      // g.fillOval(x, y,LARGEURE, HAUTEURE);
          g.drawImage(image, x, y, null);
       
        
    }
      @Override
    protected Rectangle entourer() {
         return new Rectangle(x,y,LARGEURE ,HAUTEURE);
    }
    
}
