package Scripts;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

public class Hab10 {
 Game game;
    Wall walls[]= new Wall[39];
    Floor FloorHab01[][]= new Floor[8][6];
    Enemy enemies[] = new Enemy[2];
    Puerta puertas[] = new Puerta[2];
    Floor f1;
    Trampa trampas[] = new Trampa[2];
    Bloque2 bloques[]=new Bloque2[3];
    
    Hab10 (Game _game){
        game = _game;
        generar();
    }
    
    private void generar(){
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 6; j++) {
                FloorHab01[i][j]= new Floor(game,j*128+2816,i*(128)-2432,9);
            }    
        }
        
        f1 = new Floor(game,2560,-1792,9);
        
        for (int i = 0; i < 5; i++) {
            walls[i]= new Wall(game,i*(128)+2816,-1408,9,5);
        }
        for (int i = 5; i < 13; i++) {
            walls[i]= new Wall(game,2688,(i-5)*(-128)-1536,9,7);
        }
        for (int i = 13; i < 21; i++) {
            walls[i]= new Wall(game,3456,(i-13)*(-128)-1536,9,3);
        }
        for (int i = 21; i < 26; i++) {
            walls[i]= new Wall(game,(i-21)*(128)+2816,-2560,9,1);
        }
        walls[7]=walls[1];
        walls[23]=walls[1];
        walls[26]= new Wall(game,3456,-1408,9,4);
        walls[27]= new Wall(game,2668,-1408,9,6);
        walls[28]= new Wall(game,2668,-2560,9,8);
        walls[29]= new Wall(game,3456,-2560,9,2);
       
        walls[30]= new Wall(game,2816,-2304,9,1);
        walls[31]= new Wall(game,2944,-2304,9,1);
        walls[32]= new Wall(game,3200,-2304,9,1);
        walls[33]= new Wall(game,2816,-2176,9,1);
        walls[34]= new Wall(game,2944,-2048,9,1);
        walls[35]= new Wall(game,3072,-1920,9,1);
        walls[36]= new Wall(game,3072,-1792,9,1);
        
        walls[37]= new Wall(game,2944,-2688,9,7);
        walls[38]= new Wall(game,3200,-2688,9,3);
        walls[37]= new Wall(game,2560,-1920,9,1);
        walls[38]= new Wall(game,2560,-1664,9,5);
        
        enemies[0] = new Enemy(game,3072,-2048,9);
        enemies[1] = new Enemy(game,2816,-1664,9);
        
        trampas[0] = new Trampa(game,3072,-2304,9);
        trampas[1] = new Trampa(game,3072,-1664,9);
        
        puertas[0] = new Puerta(game,3072,-2560,9,1,true);
        puertas[1] = new Puerta(game,2688,-1792,9,4,true);
        
        bloques[0] = new Bloque2(game,3072,-2176,9);
        bloques[1] = new Bloque2(game,3072,-1536,9);
        bloques[2] = new Bloque2(game,2944,-1664,9);
        
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
        f1.paint(g);
        
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
        
        for (int i = 0; i < enemies.length; i++) {
            enemies[i].collBloque();
        }
    }
    
    public void checkWallCollision(){
        for (int i = 0; i < walls.length; i++) {
            walls[i].enemyWall();
        
        }
        
        for (int i = 0; i <puertas.length; i++) {
            puertas[i].enemyWall();
        
        }
        for (int i = 0; i <bloques.length; i++) {
            bloques[i].enemyWall();
        }
    }
    
    public void gameOver(){
        for (int i = 0; i < enemies.length; i++) {
            enemies[i].gameOver();
        }
        for (int i = 0; i < bloques.length; i++) {
            bloques[i].gameOver();
        }
    }
    
    public void reiniciar(){
       for (int i = 0; i < enemies.length; i++) {
            enemies[i].gameOver();
        }
        for (int i = 0; i < bloques.length; i++) {
            bloques[i].gameOver();
        }
    }
    
    public Rectangle room5(){
        return new Rectangle(2816-game.CamX, -2432-game.CamY, 5*128, 8*128);
    }
}
