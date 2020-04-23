package Scripts;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

public class Hab09 {
Game game;
    Wall walls[]= new Wall[31];
    Floor FloorHab01[][]= new Floor[7][6];
    Puerta puertas[] = new Puerta[2];
    
    Floor f1;
    
    Bloque2 bloques[]=new Bloque2[3];
    
    Bloque2 bo1;
    Bloque2 bo2;
    Bloque2 bo3;
    
    Hab09(Game _game){
        game = _game;
        generar();
    }
    
     private void generar(){
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6; j++) {
                FloorHab01[i][j]= new Floor(game,j*128+2816,i*(128)-3456,8);
            }    
        }
        
        for (int i = 0; i < 5; i++) {
            walls[i]= new Wall(game,i*(128)+2816,-2816,8,5);
        }
        for (int i = 5; i < 10; i++) {
            walls[i]= new Wall(game,2688,(i-5)*(-128)-2944,8,7);
        }
        for (int i = 10; i < 15; i++) {
            walls[i]= new Wall(game,3456,(i-10)*(-128)-2944,8,3);
        }
        for (int i = 15; i < 20; i++) {
            walls[i]= new Wall(game,(i-15)*(128)+2816,-3584,8,1);
        }
        walls[2]=walls[1];
        walls[7]=walls[1];
        
        walls[20]= new Wall(game,3456,-2816,8,4);
        walls[21]= new Wall(game,2688,-2816,8,6);
        walls[22]= new Wall(game,3456,-3584,8,2);
        walls[23]= new Wall(game,2688,-3584,8,8);
       
        walls[24]= new Wall(game,2944,-3200,8,1);
        walls[25]= new Wall(game,2944,-2944,8,1);
        walls[26]= new Wall(game,3072,-3328,8,1);
        walls[27]= new Wall(game,3072,-3200,8,1);
        walls[28]= new Wall(game,3200,-3072,8,1);
        
        walls[29]= new Wall(game,2944,-2688,8,7);
        walls[30]= new Wall(game,3200,-2688,8,3);
        
        f1 = new Floor(game,3072,-2688,8);
        
        puertas[0] = new Puerta(game,2688,-3200,8,4,true);
        puertas[1] = new Puerta(game,3072,-2816,8,3,true);
        
        bloques[0] = new Bloque2(game,2816,-3328,8);
        bloques[1] = new Bloque2(game,2944,-3072,8);
        bloques[2] = new Bloque2(game,3072,-3456,8);
    }
    
    public void paint(Graphics g){
        Graphics2D g2d = (Graphics2D) g;
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6; j++) {
                FloorHab01[i][j].paint(g2d);
            }    
        }
        
        f1.paint(g);
        for (int i = 0; i < walls.length; i++) {
            walls[i].paint(g2d);
        }
        
        for (int i = 0; i < puertas.length; i++) {
            puertas[i].paintDoor(g2d);
            puertas[i].paintTop(g2d);
        }
        for (int i = 0; i < bloques.length; i++) {
            bloques[i].paint(g2d);
        }
      
    }
    
    public void checkCollision(){
        for (int i = 0; i < walls.length; i++) {
            walls[i].checkCollision();
        }
        for (int i = 0; i < puertas.length; i++) {
            puertas[i].checkCollision();
        }
        for (int i = 0; i < bloques.length; i++) {
            bloques[i].checkCollision();
        }
    }
    
    public void checkWallCollision(){
        for (int i = 0; i < walls.length; i++) {
            walls[i].enemyWall();
        
        }
        for (int i = 0; i <puertas.length; i++) {
            puertas[i].enemyWall();
        
        }
        for (int i = 0; i < bloques.length; i++) {
            bloques[i].enemyWall();
        }
    }
    
    public void collisionBlock(){
        for (int i = 0; i < puertas.length; i++) {
            puertas[i].collBloque();
        }
        for (int i = 0; i < walls.length; i++) {
             walls[i].collBloque();
        }
        for (int i = 0; i < bloques.length; i++) {
            bloques[i].collBloque();
        }

    }
    
    public void gameOver(){
        for (int i = 0; i < bloques.length; i++) {
            bloques[i].gameOver();
        }
    }
    
    public void reiniciar(){
        for (int i = 0; i < bloques.length; i++) {
            bloques[i].gameOver();
        }
    }
    
    public Rectangle room9(){
        return new Rectangle(2816-game.CamX, -3456-game.CamY, 5*128, 5*128);
    }
}