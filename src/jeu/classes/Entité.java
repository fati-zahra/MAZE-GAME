
package jeu.classes;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Rectangle;


// Entités de jeu
public abstract class Entité {
    protected int x, y; //position
    protected int dx, dy; // déplacement
    protected IDEntité id; // id de l'entité qui permet de déférencié entre les entités
    public Dimension Loc = new Dimension();
    
 //constructor
    public Entité(int x, int y, IDEntité id){
        this.x = x;
        this.y = y;
        this.id= id;
        dx = 0;
        dy = 0;
        
    }
     /***********getter and setters *****************/
    public IDEntité getId() {
        return id;
    }

    public void setId(IDEntité id) {
        this.id = id;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public float getDx() {
        return dx;
    }

    public void setDx(int dx) {
        this.dx = dx;
    }

    public float getDy() {
        return dy;
    }

    public void setDy(int dy) {
        this.dy = dy;
    }

    
   public  Dimension getLoc(){
     
        this.Loc.width = this.Loc.width /JeuDeLabyrinrhe.tailleCaze;
           this.Loc.height = this.Loc.height /JeuDeLabyrinrhe.tailleCaze;
       return this.Loc;
   }
     public  void setLoc(Dimension loc){
             this.Loc=loc;
          
   } 
      //modification de l'entité
    protected abstract void update();
    //dessin de l'entité
    protected abstract void render(Graphics g);
    
    //mothéde pour difir les collisions
    protected abstract Rectangle entourer();
    
}
