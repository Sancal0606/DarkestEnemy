package Scripts;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

public class Hab03 {
    
    Game game;
    Wall walls[]= new Wall[43];
    Floor FloorHab01[][]= new Floor[8][6];
    Trampa trampas[] = new Trampa[2];
    Enemy enemies[] = new Enemy[2];
    Puerta puertas[] = new Puerta[3];
    Mapa mapa;
    Floor f1;
    Floor f2;
    
    Hab03(Game _game){
        game = _game;
        generar();
    }
    
    private void generar(){
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 6; j++) {
                FloorHab01[i][j]= new Floor(game,j*128-1280,i*(128)-2432,2);
            }    
        }
        
        for (int i = 0; i < 5; i++) {
            walls[i]= new Wall(game,i*(-128)-768,-1408,2,5);
        }
        for (int i = 5; i < 13; i++) {
            walls[i]= new Wall(game,-1408,(i-5)*(-128)-1536,2,7);
        }
        for (int i = 13; i < 21; i++) {
            walls[i]= new Wall(game,-640,(i-13)*(-128)-1536,2,3);
        }
        for (int i = 21; i < 26; i++) {
            walls[i]= new Wall(game,(i-21)*(-128)-768,-2560,2,1);
        }
        walls[6]=walls[1];
        walls[19]=walls[1];
        walls[23]=walls[1];
        walls[26]= new Wall(game,-640,-1408,2,4);
        walls[27]= new Wall(game,-1408,-1408,2,6);
        walls[28]= new Wall(game,-1408,-2560,2,8);
        walls[29]= new Wall(game,-640,-2560,2,2);
       
        walls[30]= new Wall(game,-1280,-1920,2,1);
        walls[31]= new Wall(game,-1152,-1920,2,1);
        walls[32]= new Wall(game,-896,-1920,2,1);
        walls[33]= new Wall(game,-896,-2432,2,1);
        walls[34]= new Wall(game,-896,-2304,2,1);
        walls[35]= new Wall(game,-896,-2176,2,1);
        
        walls[36]= new Wall(game,-1152,-2688,2,7);
        walls[37]= new Wall(game,-896,-2688,2,3);
        
        walls[38]= new Wall(game,-1536,-1792,2,1);
        walls[39]= new Wall(game,-1536,-1536,2,5);
        
        walls[40]= new Wall(game,-1664,-1792,2,8);
        walls[41]= new Wall(game,-1664,-1664,2,7);
        walls[42]= new Wall(game,-1664,-1536,2,6);
        
        trampas[0] = new Trampa(game,-1024,-1920,2);
        trampas[1] = new Trampa(game,-896,-1664,2);
        
        enemies[0] = new Enemy(game,-1152,-1664,2);
        enemies[1] = new Enemy(game,-1024,-2304,2);
        
        f1 = new Floor(game,-1536,-1664,2);
        f2 = new Floor(game,-1024,-2688,2);
        
        mapa = new Mapa(game,-1536,-1664,2);
        
        puertas[0] = new Puerta(game,-1408,-1664,2,4,true);
        puertas[1] = new Puerta(game,-640,-2304,2,2,true);
        puertas[2] = new Puerta(game,-1024,-2560,2,1,true);
    }
    
    public void paint(Graphics g){
        Graphics2D g2d = (Graphics2D) g;
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 6; j++) {
                FloorHab01[i][j].paint(g2d);
                
            }    
        }
        f1.paint(g);
        f2.paint(g);
        mapa.paint(g2d);
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
    
    public Rectangle room3(){
        return new Rectangle(-1280-game.CamX, -2432-game.CamY, 5*128, 8*128);
    }
}
