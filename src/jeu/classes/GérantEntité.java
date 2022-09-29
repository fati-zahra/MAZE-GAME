/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jeu.classes;

import java.awt.Graphics;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author Dell
 */

// le gétant des entité
public class GérantEntité {
    Random rand = new Random(); //position aléatoire de bonus
     private boolean haut, bas, gauche, droite , bfs, dfs,bonus, astar;
      public static int max_nb_bonus = 0;
      public static int max_bonus = 0;
        public static int max_nb_ennemies = 0;
         private ArrayList <Entité> entités = new ArrayList();   // table des entitées
        /**************getters and setters ************/
         
    public boolean isAstar() {
        return astar;
    }

    public void setAstar(boolean astar) {
        this.astar = astar;
    }
      
    public boolean isHaut() {
        return haut;
    }

    public boolean isBonus() {
        return bonus;
    }

    public void setBonus(boolean bonus) {
        this.bonus = bonus;
    }

    public boolean isBfs() {
        return bfs;
    }

    public void setBfs(boolean bfs) {
        this.bfs = bfs;
    }

    public boolean isDfs() {
        return dfs;
    }

    public void setDfs(boolean dfs) {
        this.dfs = dfs;
    }

    public void setHaut(boolean haut) {
        this.haut = haut;
    }

    public boolean isBas() {
        return bas;
    }

    public void setBas(boolean bas) {
        this.bas = bas;
    }

    public boolean isGauche() {
        return gauche;
    }

    public void setGauche(boolean gauche) {
        this.gauche = gauche;
    }

    public boolean isDroite() {
        return droite;
    }

    public void setDroite(boolean droite) {
        this.droite = droite;
    }

    public ArrayList<Entité> getEntités() {
        return entités;
    }

    public void setEntités(ArrayList<Entité> entités) {
        this.entités = entités;
    }
    
    // modification des entitées
    public void update(){
        for(int i=0;i<entités.size(); i++){
             Entité entité = entités.get(i);
            entité.update();
        }
        
    }
    // dessin de l'entité
    public  void  render(Graphics g) throws IOException{
        
            // vérifier le nb de bonus
              while(this.max_nb_bonus != max_bonus){
          
           System.out.println("hello in vérifie bonus" );
              int nombreAleatoire = rand.nextInt(442 + 1);
                         System.out.println(this.getEntités().size() );
                        
                                Entité entité = this.getEntités().get(nombreAleatoire);
                                
                         if(this.getEntités().get(nombreAleatoire).getId() == IDEntité.CHEMIN){
                             
                       this.max_nb_bonus++;
               Bonus  bn = new Bonus(this.getEntités().get(nombreAleatoire ).getX(),this.getEntités().get(nombreAleatoire ).getY(), IDEntité.BONUS);
               this.ajouterEntité(bn);
                     System.out.println(" x et y" +this.getEntités().get(nombreAleatoire ).getX() +" " +this.getEntités().get(nombreAleatoire ).getY());
                         
           }
          
      }
        
         for(int i=0;i<entités.size(); i++){
             Entité entité = entités.get(i);
             
            entité.render(g);
        }
    }
    // ajoute
     public void ajouterEntité(Entité entité){
          entités.add(entité);
    }
     // suppression
    public void supprimerEntité(Entité entité){
           entités.remove(entité);
    }
}
