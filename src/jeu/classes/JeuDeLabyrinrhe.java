/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jeu.classes;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferStrategy;
import java.io.IOException;
import java.nio.file.Files;

import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.Logger;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import static jeu.classes.Test.TestPane;


// class pour lancer le jeu
public class JeuDeLabyrinrhe extends Canvas  {

  
    
    public static int  widthM = 0; //width de maze
    public static int  hiegthM = 0;  // hiegth de maze
     AStarSearchEngine   cSearchEngineASTAR= null; 
   BreadthFirstSearchEngine currentSearchEngineBFS = null;
   DepthFirstSearchEngine  currentSearchEngineDFS = null;
    
   public static final int LARGEUR = 1400; // largeur de fennaitre
   public static final int HAUTEUR=2000;   // hauteur de fennaitre
   //entitées de jeu
   GérantEntité gérant;
   Joueur joueur ;
   Score score ;
    Bonus bn ;
    Sortie sortie;
    Trajectoire trajectoire;
    
    
    public static int  val =0;
    // arraylist des entitées
    public static ArrayList<Bonus>  bonus= new ArrayList<>();
    ArrayList<Chemin> chemins = new ArrayList<>();
    ArrayList<Obstacle> obstacles = new ArrayList<>();
    ArrayList<Trajectoire> trajectoires = new ArrayList<>();
     ArrayList<Dimension> locEnnemie = new ArrayList<>();
      ArrayList<Enemie> enemies= new ArrayList<>();
      // taille de la case de labyrinthe
     public static int tailleCaze = 16 ;
      int k = 1;
      public static int verif = 0; //pour vérification 
       public Random randomGenerator;  // pour les nombres alétoire de bonus 
      Random rand = new Random(); 
      
     public Dimension loc; // variable pour les location
  
     public static int s=0;  // pour le temps de visialisation
     public static int n =0;
     // variable d'initiation pour le temps de jeu
       
            public static int  minuteJeu =0;  
            public static int  minuteOver = 0;
            public static int  secondeOver = 0;
            //maze
             Maze maze =null;
             
             // constructeur
   public  JeuDeLabyrinrhe() throws IOException{
         
      
                         
        Fenaitre fenaitre = new Fenaitre("LSI MAZE GAME ",this, LARGEUR, HAUTEUR);
        
       loc = new Dimension();
            
          gérant = new GérantEntité();
       
            System.out.println("selected"+hiegthM + widthM);
          
           
         // maze        
         drawMaze();
     
         //ajouter Bonus
         ajouterBonus();
         //ajouter Enemies
          ajouterEnemies();
         
              //  }
       this.addKeyListener(new Clavier(gérant));
    }
 
    public static void main(String[] args) throws IOException {
       
        
        FenetreDepat fen = new FenetreDepat("LSI MAZE GAME ", 700, 600);
        
         Hello hell = new Hello("LSI MAZE GAME ", 700, 600);
         
           System.out.println("selected"+hiegthM + widthM);
           do{
                System.out.println("selected"+hiegthM + widthM);
           if(widthM != 0 && hiegthM != 0) {                                         
      JeuDeLabyrinrhe jeu = new JeuDeLabyrinrhe();
        
           Chronometer chronometer = new Chronometer();
               
		chronometer.setVisible(true);
                
            jeu.boucleDuJeu();
             
    }
           }while(verif == 0);
      
         
    }
    /***********************drawe maze******************/
    private void drawMaze() throws IOException{
         this.maze =  new Maze(widthM,hiegthM);
         maze.setValue(0, 0, Maze.START_LOC_VALUE);
        for (int x=0; x<maze.getHeight(); x++) {
            for (int y=0; y<maze.getWidth(); y++) {
                short val = maze.getValue(x,y);
                 if(val == Maze.START_LOC_VALUE) {          
                       
                           joueur = new Joueur(0,0, IDEntité.JOUEUR, gérant);
                          
                      }
   
                if(val == Maze.GOAL_LOC_VALUE) {          
                       
                          sortie =new Sortie(x*tailleCaze,y*tailleCaze, IDEntité.SORTIE);
                          
                      }
                else if(val == Maze.OBSTICLE){
                        obstacles.add( new Obstacle(x*tailleCaze,y*tailleCaze,IDEntité.OBSTACLE));
                    
                }else{
                     chemins.add( new Chemin(x*tailleCaze,y*tailleCaze,IDEntité.CHEMIN));
                }
             }
        }
        //fin mize
          for(Chemin chemin:chemins){
             gérant.ajouterEntité(chemin);
         }
              
            for(Obstacle obstacle:obstacles){
             gérant.ajouterEntité(obstacle);
         }
       gérant.ajouterEntité(joueur);
         gérant.ajouterEntité(sortie);
    }
    /*****************************************boucle de jeu*************************************/
    public void boucleDuJeu() throws IOException{
      
        boolean running = true;
        long lastTime = System.nanoTime();
        double amountOfTicks = 60.0;
        double ns = 1000000000 / amountOfTicks;
        double delta = 0;
        long timer = System.currentTimeMillis();
        int updates = 0;
        int frames = 0;
        
        while(running){
            long now = System.nanoTime();
            delta +=(now -lastTime) / ns;
            lastTime = now;
            while(delta >= 1){
                update();
                updates++;
                delta--;
            }
       
        render();
        frames ++;
        if(System.currentTimeMillis() - timer >1000 ){
            timer += 1000;
            System.out.println("FPS" + frames +"TICKS" +updates);
            frames = 0;
            updates = 0;
        }
        }
        
    }
    
    //modification au cours de jeu
    private void update(){
             
        if(minuteJeu == 1){
            
            gérant.supprimerEntité(joueur);
             JFrame frame = new JFrame();
             minuteJeu = 0;
    JOptionPane.showMessageDialog(frame,"FIN DE JEU");
        }
         gérant.update();
             if( gérant.isBfs()){
            trajetBFS();
   
         
           
        }
                    if( gérant.isDfs()){
            trajetDFS();
        
        
            
        }
                  
         if(gérant.isBonus()){
               System.out.println("slectedbonus *************************************************************");
               int nombreAleatoire;
                 Entité entité ;
                 do{
                  nombreAleatoire = rand.nextInt(gérant.getEntités().size()-1 + 1);
                        // System.out.println(gérant.getEntités().size() );
                        
                                entité = gérant.getEntités().get(nombreAleatoire);
                                
                       
              
                        }while(gérant.getEntités().get(nombreAleatoire ).getId() != IDEntité.BONUS);
                                  Dimension lc = new Dimension();
                                  lc.width=entité.getX()/tailleCaze;
                                   lc.height=entité.getY()/tailleCaze;
                           trajetAstarBonus(lc);
                           gérant.setBonus(false);
                        }
               if( gérant.isAstar()){
                trajetASTAR();
        
        }
          
    }
    
    // dessin de le maze
    private void render() throws IOException{
        BufferStrategy buffer = this.getBufferStrategy();
        if(buffer == null){
            this.createBufferStrategy(3);
            return ;
        }
        Graphics g = (Graphics2D)buffer.getDrawGraphics();
        //Dessiner ici
        g.setColor(Color.red);
     
     
        g.fillRect(0,0,widthM*tailleCaze,hiegthM*tailleCaze);
     
               // case blanc pour ecrire le score
               gérant.ajouterEntité(new Chemin(1340,200,IDEntité.CHEMIN));
                gérant.ajouterEntité(new Chemin(1353,200,IDEntité.CHEMIN));
                gérant.ajouterEntité(new Chemin(1366,200,IDEntité.CHEMIN));
                //ecrire le score
               score = new Score(1340, 215, IDEntité.SCORE);
               gérant.ajouterEntité(score);
                  
            
        gérant.render(g);
        
        //fin de dessin
        g.dispose();
        buffer.show();
    }
    /************************ajouter bonus*************************/
    private void ajouterBonus() throws IOException{
         while(k <= gérant.max_nb_bonus){
            System.out.println("max bonus"+ gérant.max_nb_bonus );
        int nombreAleatoire = rand.nextInt(gérant.getEntités().size()-1 + 1);
                         System.out.println("size entitées"+ gérant.getEntités().size() );
                        
                                Entité entité = gérant.getEntités().get(nombreAleatoire);
                                
                         if(gérant.getEntités().get(nombreAleatoire ).getId() == IDEntité.CHEMIN){
                             
                       k++;
                 bonus.add( new Bonus(gérant.getEntités().get(nombreAleatoire ).getX(),gérant.getEntités().get(nombreAleatoire ).getY(), IDEntité.BONUS));
                     //System.out.println(" x et y" +gérant.getEntités().get(nombreAleatoire ).getX() +" " +gérant.getEntités().get(nombreAleatoire ).getY());
                         
           }
           }
                          
               for(Bonus bns:bonus){
             gérant.ajouterEntité(bns);
              }       
    }
    
    /*********************************ajouter des ennemies*********************************/
    private void ajouterEnemies() throws IOException{
         /*********************** path************************************/ 
    
      
         currentSearchEngineDFS = new DepthFirstSearchEngine(maze.getWidth(),maze.getHeight(),joueur.getLoc());
               if (currentSearchEngineDFS == null) return; 
     
          
                //affichage des enemies  
         
          
      Dimension [] path = currentSearchEngineDFS.getPath();
        for (int i=1; i< (path.length-1); i++) {
          int x = path[i].width;
          int y = path[i].height;
          locEnnemie.add(path[i]);
     
        
        } 
          System.out.println("loc de ennemie" +locEnnemie.size());
        for(int n = 0; n<GérantEntité.max_nb_ennemies;n++){
            int nb = rand.nextInt(locEnnemie.size()-20 -1 -1)+1;
             System.out.println("aliatoire" +nb);
             enemies.add( new Enemie(locEnnemie.get(nb).width*tailleCaze ,locEnnemie.get(nb).height*tailleCaze, IDEntité.ENEMIE));
                  System.out.println("Ennemie in "+locEnnemie.get(nb).width*tailleCaze +" fkfkfk"+ locEnnemie.get(nb).height*tailleCaze);
          
   }         
              for(Enemie enm:enemies){
             gérant.ajouterEntité(enm);
              }
              //fin enemies
    }
    
    /*****************visualisation***********************/
    
    /*****************avec bfs***********************/
    public  void trajetBFS(){
      System.out.println("in trajet bfs" );
      System.out.println("in trajet bfs" );
         currentSearchEngineBFS = new BreadthFirstSearchEngine(maze.getWidth(),maze.getWidth(),joueur.getLocJ(),maze.goalLoc);
              if (currentSearchEngineBFS == null) return;
                            Timer t = new Timer();
           
      TimerTask  tt = new TimerTask() {
           @Override
           public void run() {
               s++;
               System.err.println("le temps passe est :" + s);
               //do something
              if(s<18) {
            Dimension [] path = currentSearchEngineBFS.getPath();
        for (int i=1; i< (path.length-1); i++) {
          int x = path[i].width;
          int y = path[i].height;
          short val = maze.getValue(x,y);
           trajectoires.add (new Trajectoire(">", x, y, IDEntité.TRAJECTOIRE, gérant));
        }
          for(Trajectoire trajectoire:trajectoires){
              gérant.ajouterEntité(trajectoire);
         }
             trajectoires.clear();
               }
              else if(s>8){
                 // supression de trajet  
                 Dimension [] path1 = currentSearchEngineBFS.getPath();
               for (int i=1; i< (path1.length-1); i++) {
                   int x = path1[i].width;
                   int y = path1[i].height;
                   short val = maze.getValue(x,y);
                     for(Trajectoire trajectoire:trajectoires){
                   gérant.supprimerEntité(trajectoire);
               }
                 
                       for(int p =0; p<gérant.getEntités().size(); p++){
                          Entité entité = gérant.getEntités().get(p);
                          if(entité.getId() == IDEntité.TRAJECTOIRE){
                             gérant.supprimerEntité( entité);
            }
           }
               }
          
                 trajectoires.clear();
              System.out.println("trajet" +trajectoires);
               //trajectoires.clear();
                trajectoires.clear(); 
                t.cancel();
               
      
               }
           } ;
          
       };
                    
  
t.schedule(tt,0,1000); 
         
       System.out.println("fin task");
             
    }
         
         
        
 
    
      /******************************avec dfs*****************************/
 
     public  void trajetDFS(){
        Dimension lc = new Dimension();
        lc.width=joueur.getX()/tailleCaze;
        lc.height=joueur.getY()/tailleCaze;
         currentSearchEngineDFS = new DepthFirstSearchEngine(maze.getWidth(), maze.getHeight(),lc);
               if (currentSearchEngineDFS == null) return; 
                      Timer t = new Timer();
           
      TimerTask  tt = new TimerTask() {
           @Override
           public void run() {
               s++;
               System.err.println("le temps passe est :" + s);
               //do something
              if(s<18) {
                     
              Dimension [] path = currentSearchEngineDFS.getPath();
               for (int i=1; i< (path.length-1); i++) {
                   int x = path[i].width;
                   int y = path[i].height;
                   short val = maze.getValue(x,y);
                   System.out.println("path dfs"+ ( path.length-1));
                   trajectoires.add (new Trajectoire(">", x, y, IDEntité.TRAJECTOIRE,gérant));
               }
               
              for(Trajectoire trajectoire:trajectoires){
                   gérant.ajouterEntité(trajectoire);
               }
               
              trajectoires.clear();
             
              }
              else if(s>8){
                           // supression de trajet 
                 Dimension [] path1 = currentSearchEngineDFS.getPath();
               for (int i=1; i< (path1.length-1); i++) {
                   int x = path1[i].width;
                   int y = path1[i].height;
                   short val = maze.getValue(x,y);
                     for(Trajectoire trajectoire:trajectoires){
                   gérant.supprimerEntité(trajectoire);
               }
                 
                       for(int p =0; p<gérant.getEntités().size(); p++){
                          Entité entité = gérant.getEntités().get(p);
                          if(entité.getId() == IDEntité.TRAJECTOIRE){
                             gérant.supprimerEntité( entité);
            }
           }
               }
              
                 trajectoires.clear();
              System.out.println("trajet" +trajectoires);
               //trajectoires.clear();
                trajectoires.clear(); 
                t.cancel();
               
      
               }
           } ;
          
       };
                    
  
t.schedule(tt,0,1000); 
         
       System.out.println("fin task");
     } 
     /****************************************avec astar***************************/
         public  void trajetASTAR(){
            
        System.out.println("in trajet bfs" );
         currentSearchEngineBFS = new BreadthFirstSearchEngine(maze.getWidth(),maze.getWidth(),joueur.getLocJ(),maze.goalLoc);
              if (currentSearchEngineBFS == null) return;
                            Timer t = new Timer();
           
      TimerTask  tt = new TimerTask() {
           @Override
           public void run() {
               s++;
               System.err.println("le temps passe est :" + s);
               //do something
              if(s<18) {
            Dimension [] path = currentSearchEngineBFS.getPath();
        for (int i=1; i< (path.length-1); i++) {
          int x = path[i].width;
          int y = path[i].height;
          short val = maze.getValue(x,y);
           trajectoires.add (new Trajectoire(">", x, y, IDEntité.TRAJECTOIRE, gérant));
        }
          for(Trajectoire trajectoire:trajectoires){
              gérant.ajouterEntité(trajectoire);
         }
             trajectoires.clear();
               }
              else if(s>8){
                           // supression de trajet 
                 Dimension [] path1 = currentSearchEngineBFS.getPath();
               for (int i=1; i< (path1.length-1); i++) {
                   int x = path1[i].width;
                   int y = path1[i].height;
                   short val = maze.getValue(x,y);
                     for(Trajectoire trajectoire:trajectoires){
                   gérant.supprimerEntité(trajectoire);
               }
                 
                       for(int p =0; p<gérant.getEntités().size(); p++){
                          Entité entité = gérant.getEntités().get(p);
                          if(entité.getId() == IDEntité.TRAJECTOIRE){
                             gérant.supprimerEntité( entité);
            }
           }
               }
          
                 trajectoires.clear();
              System.out.println("trajet" +trajectoires);
               //trajectoires.clear();
                trajectoires.clear(); 
                t.cancel();
               
      
               }
           } ;
          
       };
                    
  
t.schedule(tt,0,1000); 
         
       System.out.println("fin task");
             
    }
         
         
        
 /***********************trajet de bonus********************************/
     public  void trajetAstarBonus(Dimension LBonus){
          
         
         cSearchEngineASTAR = new AStarSearchEngine(maze.getWidth(), maze.getHeight(),joueur.getLocJ(), LBonus);
             
              if (  cSearchEngineASTAR == null) return;
              
              Timer t = new Timer();
           
      TimerTask  tt = new TimerTask() {
           @Override
           public void run() {
               s++;
               System.err.println("le temps passe est :" + s);
               //do something
              if(s<6) {  
            Dimension [] path =   cSearchEngineASTAR.getPath();
        for (int i=1; i< (path.length-1); i++) {
          int x = path[i].width;
          int y = path[i].height;
          short val = maze.getValue(x,y);
           trajectoires.add (new Trajectoire(">", x, y, IDEntité.TRAJECTOIRE, gérant));
        }
          for(Trajectoire trajectoire:trajectoires){
              gérant.ajouterEntité(trajectoire);
         }
          trajectoires.clear();
             
              }
              else if(s>8){
                           // supression de trajet 
                 Dimension [] path1 = cSearchEngineASTAR.getPath();
               for (int i=1; i< (path1.length-1); i++) {
                   int x = path1[i].width;
                   int y = path1[i].height;
                   short val = maze.getValue(x,y);
                     for(Trajectoire trajectoire:trajectoires){
                   gérant.supprimerEntité(trajectoire);
               }
                 
                       for(int p =0; p<gérant.getEntités().size(); p++){
                          Entité entité = gérant.getEntités().get(p);
                          if(entité.getId() == IDEntité.TRAJECTOIRE){
                             gérant.supprimerEntité( entité);
            }
           }
               }
              
                 trajectoires.clear();
              System.out.println("trajet" +trajectoires);
               //trajectoires.clear();
                trajectoires.clear(); 
                t.cancel();
               
      
               }
           } ;
          
       };
                    
  
t.schedule(tt,0,1000); 
         
     
       System.out.println("fin task");
             
    }

   
}
