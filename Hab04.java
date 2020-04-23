package Scripts;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

public class Hab04 {
    Game game;
    Wall walls[]= new Wall[29];
    Floor FloorHab01[][]= new Floor[7][6];
    Trampa trampas[] = new Trampa[2];
    Enemy enemies[] = new Enemy[2];
    Puerta puertas[] = new Puerta[2];
    
    Floor f1;
    
    Hab04(Game _game){
        game = _game;
        generar();
    }
    
     private void generar(){
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6; j++) {
                FloorHab01[i][j]= new Floor(game,j*128-1280,i*(128)-3456,3);
            }    
        }
        
        for (int i = 0; i < 5; i++) {
            walls[i]= new Wall(game,i*(-128)-768,-2816,3,5);
        }
        for (int i = 5; i < 10; i++) {
            walls[i]= new Wall(game,-1408,(i-5)*(-128)-2944,3,7);
        }
        for (int i = 10; i < 15; i++) {
            walls[i]= new Wall(game,-640,(i-10)*(-128)-2944,3,3);
        }
        for (int i = 15; i < 20; i++) {
            walls[i]= new Wall(game,(i-15)*(-128)-768,-3584,3,1);
        }
        walls[12]=walls[1];
        walls[2]=walls[1];
        
        walls[20]= new Wall(game,-640,-2816,3,4);
        walls[21]= new Wall(game,-1408,-2816,3,6);
        walls[22]= new Wall(game,-1408,-3584,3,8);
        walls[23]= new Wall(game,-640,-3584,3,2);
       
        walls[24]= new Wall(game,-1024,-3200,3,1);
        walls[25]= new Wall(game,-768,-3072,3,1);
        walls[26]= new Wall(game,-896,-3072,3,1);
        
        walls[27]= new Wall(game,-512,-3328,3,1);
        walls[28]= new Wall(game,-512,-3072,3,5);
        
        trampas[0] = new Trampa(game,-1152,-3328,3);
        trampas[1] = new Trampa(game,-1024,-3072,3);
        
        enemies[0] = new Enemy(game,-1280,-3328,3);
        enemies[1] = new Enemy(game,-896,-3200,3);
        
        f1 = new Floor(game,-512,-3200,3);
        
        
        puertas[0] = new Puerta(game,-640,-3200,3,2,true);
        puertas[1] = new Puerta(game,-1024,-2816,3,3,true);
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
        
        for (int i = 0; i < trampas.length; i++) {
            trampas[i].paint(g2d);
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
        for (int i = 0; i < puertas.length; i++) {
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
    
    public Rectangle room4(){
        return new Rectangle(-1280-game.CamX, -3456-game.CamY, 5*128, 5*128);
    }
}