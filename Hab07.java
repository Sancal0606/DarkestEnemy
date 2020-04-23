package Scripts;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

public class Hab07 {
    Game game;
    Wall walls[]= new Wall[42];
    Floor FloorHab01[][]= new Floor[8][6];
    Enemy enemies[] = new Enemy[1];
    Puerta puertas[] = new Puerta[3];
    Llave llave;
    
    Hab07(Game _game){
        game = _game;
        generar();
    }
    
    private void generar(){
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 6; j++) {
                FloorHab01[i][j]= new Floor(game,j*128+768,i*(128)-2432,6);
            }    
        }
        
        for (int i = 0; i < 5; i++) {
            walls[i]= new Wall(game,i*(128)+768,-1408,6,5);
        }
        for (int i = 5; i < 13; i++) {
            walls[i]= new Wall(game,640,(i-5)*(-128)-1536,6,7);
        }
        for (int i = 13; i < 21; i++) {
            walls[i]= new Wall(game,1408,(i-13)*(-128)-1536,6,3);
        }
        for (int i = 21; i < 26; i++) {
            walls[i]= new Wall(game,(i-21)*(128)+768,-2560,6,1);
        }
        walls[6]=walls[1];
        walls[23]=walls[1];
        walls[14]=walls[1];
        
        walls[26]= new Wall(game,1408,-1408,6,4);
        walls[27]= new Wall(game,646,-1408,6,6);
        walls[28]= new Wall(game,646,-2560,6,8);
        walls[29]= new Wall(game,1408,-2560,6,2);
       
        walls[30]= new Wall(game,768,-2176,6,1);
        walls[31]= new Wall(game,768,-2048,6,1);
        walls[32]= new Wall(game,768,-1920,6,1);
        walls[33]= new Wall(game,896,-2432,6,1);
        walls[34]= new Wall(game,896,-2304,6,1);
        walls[35]= new Wall(game,896,-1792,6,1);
        walls[36]= new Wall(game,1152,-2432,6,1);
        walls[37]= new Wall(game,1152,-2304,6,1);
        walls[38]= new Wall(game,1152,-1792,6,1);
        walls[39]= new Wall(game,1280,-2176,6,1);
        walls[40]= new Wall(game,1280,-2048,6,1);
        walls[41]= new Wall(game,1280,-1920,6,1);
        enemies[0] = new Enemy(game,1024,-1792,6);
        
        
        puertas[2]= new Puerta(game,1408,(14-13)*(-128)-1536,6,2,true);
        puertas[0] = new Puerta(game,1024,-2560,6,1,true);
        puertas[1] = new Puerta(game,640,-1664,6,4,true);
        
        llave = new Llave(game,1024,-1664,6);
    }
    
    public void paint(Graphics g){
        Graphics2D g2d = (Graphics2D) g;
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 6; j++) {
                FloorHab01[i][j].paint(g2d);
                
            }    
        }
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
        llave.paint(g);
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
    
    public Rectangle room7(){
        return new Rectangle(768-game.CamX, -2432-game.CamY, 5*128, 8*128);
    }
}


