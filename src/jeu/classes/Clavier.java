
package jeu.classes;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Iterator;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import static jeu.classes.Fenaitre.BFS;
import static jeu.classes.Fenaitre.DFS;
import static jeu.classes.JeuDeLabyrinrhe.HAUTEUR;
import static jeu.classes.JeuDeLabyrinrhe.LARGEUR;

//la classe clavier qui permet d'écouter les évene,et de clavier
public class Clavier implements KeyListener{
 
    GérantEntité gérant;
     
    public Clavier(GérantEntité gérant){
        this.gérant = gérant;
    }
    @Override
    public void keyTyped(KeyEvent e) {
       
    }
    // on tape sur la touche
    @Override
    public void keyPressed(KeyEvent e) {
      int touche = e.getKeyCode();
      for(int i =0; i< gérant.getEntités().size(); i++){
          Entité entité = gérant.getEntités().get(i);
          if(entité.getId() ==IDEntité.JOUEUR){
                 if(touche == KeyEvent.VK_UP) gérant.setHaut(true);
                 if(touche == KeyEvent.VK_DOWN) gérant.setBas(true);     
                 if(touche == KeyEvent.VK_LEFT) gérant.setGauche(true);
                 if(touche == KeyEvent.VK_RIGHT) gérant.setDroite(true);
                 if(touche == KeyEvent.VK_A){ Aide aide = new Aide();  
                                                  aide.setVisible(true);
                                            }
                  if( Joueur.SCORE>=2){
                 if(touche == KeyEvent.VK_B) {
                     
                     gérant.setBfs(true);
                        JeuDeLabyrinrhe.s = 0;
                       Joueur.SCORE=Joueur.SCORE-2;
                 }}
                 if( Joueur.SCORE>=1){
                   if(touche == KeyEvent.VK_C){ 
                       gérant.setDfs(true);
                            JeuDeLabyrinrhe.s = 0;
                           Joueur.SCORE=Joueur.SCORE-1;
                   }}
      if( Joueur.SCORE>=1){
                    if(touche == KeyEvent.VK_SPACE){ 
                         gérant.setBonus(true);
                         System.out.println("bonus selectioné");
                        JeuDeLabyrinrhe.s = 0; 
                   
                       Joueur.SCORE=Joueur.SCORE-1;
                    }}
      if( Joueur.SCORE>=3){
                  if(touche == KeyEvent.VK_E){   
                      JeuDeLabyrinrhe.s = 0; 
                   Joueur.SCORE = Joueur.SCORE-3;
                   gérant.setAstar(true);
                  }
          } 
          
          if(touche == KeyEvent.VK_E && Joueur.SCORE<3){
              JFrame frame = new JFrame();
    JOptionPane.showMessageDialog(frame,"vous devez avoir au moin 3");
          }
          if(touche == KeyEvent.VK_SPACE&& Joueur.SCORE<1){
              JFrame frame = new JFrame();
    JOptionPane.showMessageDialog(frame,"vous devez avoir au moin 1");
          } if(touche == KeyEvent.VK_C && Joueur.SCORE<1){
              JFrame frame = new JFrame();
    JOptionPane.showMessageDialog(frame,"vous devez avoir au moin 1");
          } if(touche == KeyEvent.VK_B && Joueur.SCORE<2){
              JFrame frame = new JFrame();
    JOptionPane.showMessageDialog(frame,"vous devez avoir au moin 2  ");
          }
          }
          
      }
    }
//la touche est laché
    @Override
    public void keyReleased(KeyEvent e) {
         int touche = e.getKeyCode();
         gérant.getEntités().stream().filter((entité) -> (entité.getId() == IDEntité.JOUEUR)).map((_item) -> {
             if(touche == KeyEvent.VK_UP) gérant.setHaut(false);
            return _item;
        }).map((_item) -> {
            if(touche == KeyEvent.VK_DOWN) gérant.setBas(false);
            return _item;
        }).map((_item) -> {
            if(touche == KeyEvent.VK_LEFT) gérant.setGauche(false);
            return _item;
        }).map((_item) -> {
            if(touche == KeyEvent.VK_RIGHT) gérant.setDroite(false);
            return _item;
        }).map((_item) -> {
            if(touche == KeyEvent.VK_B) gérant.setBfs(false);
            return _item;
        }).map((_item) -> {
            if(touche == KeyEvent.VK_C) gérant.setDfs(false);
            return _item;
        }).map((_item) -> {
            if(touche == KeyEvent.VK_SPACE) gérant.setBonus(false);
            return _item;
        }).filter((_item) -> (touche == KeyEvent.VK_E)).forEachOrdered((_item) -> {
            gérant.setAstar(false);
        });
    }
    
}
