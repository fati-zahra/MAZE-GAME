package jeu.classes;

import java.awt.Color;
import java.awt.Dimension;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Class Maze - private class for representing search space as a two-dimensional maze
 */
public class Maze {
    public static short OBSTICLE = -1;
     
    public static short START_LOC_VALUE = -2;
    public static short GOAL_LOC_VALUE = -3;
    private int width = 0;
    private int height = 0;
    public final Dimension startLoc = new Dimension();
    public final Dimension goalLoc  = new Dimension();
      Path path;
    
    /**
     * The maze (or search space) data is stored as a short integer rather than
     * as a boolean so that bread-first style searches can use the array to store
     * search depth. A value of -1 indicates a barrier in the maze.
     */;
    public final short[][] maze;
    public Maze(int width, int height) {
        System.out.println("New maze of size " + width + " by " + height);
        this.width = width;
        this.height = height;
        maze = new short[width+2][height+2];
        for (int i=0; i<width+2; i++) {
            for (int j=0; j<height+2; j++) {
                maze[i][j] = 0;
            }
        }
     
        /**
         * Randomize the maze by putting up arbitray obsticals
         */
    
          for (int i=0; i<height+2; i++) {
            maze[0][i] = maze[width+1][i] = OBSTICLE;
        }
        for (int i=0; i<width+2; i++) {
            maze[i][0] = maze[i][height+1] = OBSTICLE;
        }
        //41 41
        if(JeuDeLabyrinrhe.widthM == 41 && JeuDeLabyrinrhe.widthM == 41 ){
         path = (Path) Paths.get("files/momo/LABY_41x41.txt");
        }
          //61 61
        if(JeuDeLabyrinrhe.widthM == 61 && JeuDeLabyrinrhe.widthM == 61 ){
         path = (Path) Paths.get("files/momo/LABY_61x61.txt");
        }
          //81 81
        if(JeuDeLabyrinrhe.widthM == 81 && JeuDeLabyrinrhe.widthM == 81 ){
         path = (Path) Paths.get("files/momo/LABY_81x81.txt");
        }
        // 21/21
          if(JeuDeLabyrinrhe.widthM == 21 && JeuDeLabyrinrhe.widthM == 21 ){
        path = (Path) Paths.get("files/momo/LABY_21x21.txt");
       
        }
          java.util.List <String>lignes = null;
      
        try {
            lignes = Files.readAllLines(path);
        } catch (IOException ex) {
            Logger.getLogger(Maze.class.getName()).log(Level.SEVERE, null, ex);
        }
          int x=0;
      
        for(String ligne: lignes ){
             //System.out.println(ligne.length());
             if(ligne.length() == width -1){
                     //System.out.println("hello");
             for(int y = 0; y<width -1 ;y++){
                 char l= ligne.charAt(y);
                 if(l!=' '){
               
                  maze[x+1][y+1] = OBSTICLE;
                    // System.out.println("hello" +OBSTICLE);
                     }
                 
                   
                    //System.out.println("le char" + l);
             }}else{
                for(int y =0; y<width;y++){
                 char l= ligne.charAt(y);
                  if(l!=' '){
               
                  maze[x+1][y+1] = OBSTICLE;
                     //System.out.println("hello" +OBSTICLE);
                     }
             } 
             }
             x++;
             if(x ==width)break;
        }
        
        /**
         * Specify the starting location
         */
         startLoc.width = 0;
         startLoc.height = 0;
         maze[1][1] = START_LOC_VALUE;
        /**
         * Specify the goal location
         */
        goalLoc.width = width - 1;
        goalLoc.height =height - 1;
        maze[width][height] = GOAL_LOC_VALUE;
        
    }
    synchronized public short getValue(int x, int y) { return maze[x+1][y+1]; }
    synchronized public void setValue(int x, int y, short value) { maze[x+1][y+1] = value; }
    public int getWidth() { return width; }
    public int getHeight() { return height; }
}
