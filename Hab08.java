package Scripts;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

public class Hab08 {
    Game game;
    Wall walls[]= new Wall[29];
    Floor FloorHab01[][]= new Floor[7][6];
    Puerta puertas[] = new Puerta[3];
    
    Floor f1;
    
    Bloque2 bloques[]=new Bloque2[3];
    
    Bloque2 bo1;
    Bloque2 bo2;
    Bloque2 bo3;
    
    Hab08(Game _game){
        game = _game;
        generar();
    }
    
     private void generar(){
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6; j++) {
                FloorHab01[i][j]= new Floor(game,j*128+1792,i*(128)-3456,7);
            }    
        }
        
        for (int i = 0; i < 5; i++) {
            walls[i]= new Wall(game,i*(128)+1792,-2816,7,5);
        }
        for (int i = 5; i < 10; i++) {
            walls[i]= new Wall(game,1664,(i-5)*(-128)-2944,7,7);
        }
        for (int i = 10; i < 15; i++) {
            walls[i]= new Wall(game,2432,(i-10)*(-128)-2944,7,3);
        }
        for (int i = 15; i < 20; i++) {
            walls[i]= new Wall(game,(i-15)*(128)+1792,-3584,7,1);
        }
        walls[6]=walls[1];
        walls[8]=walls[1];
        walls[12]=walls[1];
        
        walls[20]= new Wall(game,2432,-2816,7,4);
        walls[21]= new Wall(game,1664,-2816,7,6);
        walls[22]= new Wall(game,2432,-3584,7,2);
        walls[23]= new Wall(game,1664,-3584,7,8);
       
        walls[24]= new Wall(game,1920,-3072,7,1);
        walls[25]= new Wall(game,1920,-3328,7,1);
        walls[26]= new Wall(game,2176,-3200,7,1);
        
         walls[27]= new Wall(game,2560,-3328,7,1);
        walls[28]= new Wall(game,2560,-3072,7,5);
        
        f1 = new Floor(game,2560,-3200,5);
        
        puertas[0] = new Puerta(game,1664,-3328,7,4,true);
        puertas[1] = new Puerta(game,1664,-3072,7,4,true);
        puertas[2] = new Puerta(game,2432,-3200,7,2,true);
        
        bloques[0] = new Bloque2(game,2048,-3456,7);
        bloques[1] = new Bloque2(game,1920,-3200,7);
        bloques[2] = new Bloque2(game,2048,-2944,7);
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
    
    public Rectangle room8(){
        return new Rectangle(1792-game.CamX, -3456-game.CamY, 5*128, 5*128);
    }
}


