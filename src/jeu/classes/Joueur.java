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
import java.util.Stack;
import javax.imageio.ImageIO;

/**
 *
 * @author Dell
 */
public class Joueur extends Entité {
    GérantEntité gérant;
        private BufferedImage image;
    private final int LARGEURJ =10;
     private final int HAUTEURJ = 10;
      public static int SCORE = 0;
        public static int f = 0;
          
     //pile pour stoké la derniere position
       Stack<Dimension>  pile=new Stack<Dimension>();
      public Dimension Loc = new Dimension();
           Dimension retour = new Dimension();
     Maze maze = new Maze(JeuDeLabyrinrhe.widthM, JeuDeLabyrinrhe.widthM);
 
      boolean bool = false;
    public Joueur(int x, int y, IDEntité id, GérantEntité gérant ) throws IOException {
        super(x, y, id);
        this.gérant = gérant;
             /*this.Loc.width = x;
          this.Loc.height = y;
         this.setLocJ(Loc);*/
        /*dx=1;
        dy=1;*/
        if(JeuDeLabyrinrhe.tailleCaze ==12){
     image = ImageIO.read(new File("files/momo/thinking2.png"));
    }else if (JeuDeLabyrinrhe.tailleCaze ==35){
             image = ImageIO.read(new File("files/momo/thinking24.png"));
        }else if (JeuDeLabyrinrhe.tailleCaze ==35){
             image = ImageIO.read(new File("files/momo/thinking24.png"));
        }else{
             image = ImageIO.read(new File("files/momo/thinking.png"));
        }
    }
    @Override
    protected void update() {
    
         dx=0;
         dy=0;
         
              this.Loc.width = x;
          this.Loc.height = y;
        this.setLocJ(Loc);
        pile.add(Loc);
         
       // System.out.println("xet y joueur " + x/25+"/ " +y/25);
        if(gérant.isHaut()) {
              dy =-1;
             bool= true;
          }
           if(gérant.isBas()) {
               dy =1;
                bool= true;
           }
            if(gérant.isGauche()){ 
                dx =-1;
               bool= true;
            }
             if(gérant.isDroite()) {
                 dx =1;
               bool= true;
             }
           
                  
              if(x<0) x=0;
              if(y<0) y=0;
              if(x>maze.getWidth()*JeuDeLabyrinrhe.tailleCaze ) x=maze.getWidth()*JeuDeLabyrinrhe.tailleCaze ;
              if(y>maze.getHeight()*JeuDeLabyrinrhe.tailleCaze) y=maze.getHeight()*JeuDeLabyrinrhe.tailleCaze;
             
          
             x+=dx;
             y+=dy;
           collision();
           // collisionEnemie(); 
          
    }

    @Override
    protected void render(Graphics g) {
          /* g.setColor(Color.blue);
           g.fillOval(x, y,LARGEURJ, HAUTEURJ);*/
             g.drawImage(image, x, y, null);
    }
      @Override
    protected Rectangle entourer() {
         return new Rectangle(x,y,LARGEURJ,HAUTEURJ);
    }

    private void collision() {
        for(int i =0; i<gérant.getEntités().size(); i++){
            Entité entité = gérant.getEntités().get(i);
            if(entité.getId() == IDEntité.OBSTACLE){
                  if(entourer().intersects(entité.entourer())){
                  
                        retour = pile.pop();
                        x=retour.width;
                        y=retour.height;
                      
                    }
                
            }
              if(entité.getId() == IDEntité.BONUS){
                  if(entourer().intersects(entité.entourer())){
                      gérant.supprimerEntité(entité);
                       SCORE =  SCORE + 5;
                       --gérant.max_nb_bonus;
                       System.out.println("score = "+SCORE);
                  }
              }
            if(entité.getId() == IDEntité.ENEMIE){
                  if(entourer().intersects(entité.entourer())){
                       if(SCORE > 1  ){
                           
                         gérant.supprimerEntité(entité);
                       SCORE = SCORE - 2;
                       
                       System.out.println("score = in ennemie  "+SCORE);
                  }
                      if(SCORE <2){
                           
                    retour = pile.pop();
                        x=retour.width;
                        y=retour.height;
                         System.out.println("joueur in  "+retour.width +"   eueudkdk" +retour.height);
                       }
                
                          
                  }
              }
                if(entité.getId() == IDEntité.SORTIE){
                  if(entourer().intersects(entité.entourer())){
                      gérant.supprimerEntité(entité);
                      JeuDeLabyrinrhe.minuteJeu = 1;
                     
                  }
              }
        }
    }
    /*  private void collisionEnemie() {
           
        for(int i =0; i<gérant.getEntités().size(); i++){
            Entité entité = gérant.getEntités().get(i);
                if(entité.getId() == IDEntité.ENEMIE){
                      
                      /*System.out.println("locccc"+entité.getLoc());
                          System.out.println("locccc"+this.getLocJ());*/
                    /* if(SCORE > 1 && this.getX() == entité.getX() && this.getY() == entité.getY() ){
                           
                         gérant.supprimerEntité(entité);
                       SCORE = SCORE - 2;
                       
                       System.out.println("score = in ennemie  "+SCORE);
                  }
                  }
            
    }
      }*/
      
        public  Dimension getLocJ(){
     
        this.Loc.width = this.Loc.width /JeuDeLabyrinrhe.tailleCaze;
           this.Loc.height = this.Loc.height /JeuDeLabyrinrhe.tailleCaze;
       return this.Loc;
   }
     public  void setLocJ(Dimension loc){
             this.Loc=loc;
          
   } 
      }
