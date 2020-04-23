package Scripts;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

public class Hab06 {
     Game game;
    Wall walls[]= new Wall[34];
    Floor FloorHab01[][]= new Floor[7][6];
    Enemy enemies[] = new Enemy[2];
    Puerta puertas[] = new Puerta[4];
    
    Floor f1;
    Floor f2;
    Floor f3;
    
    Hab06(Game _game){
        game = _game;
        generar();
    }
    
     private void generar(){
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6; j++) {
                FloorHab01[i][j]= new Floor(game,j*128+768,i*(128)-3456,5);
            }    
        }
        
        for (int i = 0; i < 5; i++) {
            walls[i]= new Wall(game,i*(128)+768,-2816,5,5);
        }
        for (int i = 5; i < 10; i++) {
            walls[i]= new Wall(game,640,(i-5)*(-128)-2944,5,7);
        }
        for (int i = 10; i < 15; i++) {
            walls[i]= new Wall(game,1408,(i-10)*(-128)-2944,5,3);
        }
        for (int i = 15; i < 20; i++) {
            walls[i]= new Wall(game,(i-15)*(128)+768,-3584,5,1);
        }
        walls[7]=walls[1];
        walls[2]=walls[1];
        walls[11]=walls[1];
        walls[13]=walls[1];
        
        walls[20]= new Wall(game,1408,-2816,5,4);
        walls[21]= new Wall(game,640,-2816,5,6);
        walls[22]= new Wall(game,1408,-3584,5,2);
        walls[23]= new Wall(game,640,-3584,5,8);
       
        walls[24]= new Wall(game,896,-3072,5,1);
        walls[25]= new Wall(game,896,-3200,5,1);
        walls[26]= new Wall(game,896,-3328,5,1);
        walls[27]= new Wall(game,1152,-3200,5,1);
        walls[28]= new Wall(game,1280,-3200,5,1);
        
         walls[29]= new Wall(game,1536,-3426,5,1);
        walls[30]= new Wall(game,1536,-3200,5,1);
         walls[31]= new Wall(game,1536,-2944,5,5);
         
        walls[32]= new Wall(game,896,-2688,5,7);
         walls[33]= new Wall(game,1152,-2688,5,3);
        
        enemies[0] = new Enemy(game,1024,-3200,5);
        enemies[1] = new Enemy(game,896,-2944,5);
        
        f1 = new Floor(game,1536,-3328,5);
        f2 = new Floor(game,1536,-3072,5);
        f3 = new Floor(game,1024,-2688,5);
        
        puertas[0] = new Puerta(game,640,-3200,5,4,true);
        puertas[1] = new Puerta(game,1024,-2816,5,3,true);
        puertas[2] = new Puerta(game,1408,-3328,5,2,true);
        puertas[3] = new Puerta(game,1408,-3072,5,2,true);
    }
    
    public void paint(Graphics g){
        Graphics2D g2d = (Graphics2D) g;
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6; j++) {
                FloorHab01[i][j].paint(g2d);
                
            }    
        }
        
        f1.paint(g);
        f2.paint(g);
        f3.paint(g);
        
        for (int i = 0; i < walls.length; i++) {
            walls[i].paint(g2d);
        }
        
        for (int i = 0; i < enemies.length; i++) {
            enemies[i].paint(g2d);
        }
        for (int i = 0; i < puertas.length; i++) {
            puertas[i].paintDoor(g2d);
            puertas[i].paintTop(g2d);
        }
    }
    
    public void checkCollision(){
        for (int i = 0; i < walls.length; i++) {
            walls[i].checkCollision();
        }
        for (int i = 0; i < puertas.length; i++) {
            puertas[i].checkCollision();
        }
    }
    
    public void checkWallCollision(){
        for (int i = 0; i < walls.length; i++) {
            walls[i].enemyWall();
        
        }
        for (int i = 0; i <puertas.length; i++) {
            puertas[i].enemyWall();
        
        }
    }
    
    public void gameOver(){
        for (int i = 0; i < enemies.length; i++) {
            enemies[i].gameOver();
        }
    }
    
    public void reiniciar(){
       for (int i = 0; i < enemies.length; i++) {
            enemies[i].gameOver();
        }
    }
    
    public Rectangle room6(){
        return new Rectangle(768-game.CamX, -3456-game.CamY, 5*128, 5*128);
    }
}

