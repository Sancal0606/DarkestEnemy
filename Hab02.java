package Scripts;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import javax.swing.JPanel;

public class Hab02 extends JPanel{
   
   Game game; 
   
    Floor FloorHab01[][]= new Floor[8][5];
    Wall walls[]= new Wall[39];
 
    Trampa trampaHab01; 
    Trampa trampaHab02; 
    
    Enemy enemy;
    Puerta puertas[]=new Puerta[4];
    
    Floor f1;
    Floor f2;
    Floor f3;

    Hab02 (Game _game){
        game = _game;
        crear();
    }
    
    private void crear(){
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 5; j++) {
                FloorHab01[i][j]= new Floor(game,j*128-256,i*(128)-2432,1);
            }    
        }
        
        walls[0] = new Wall(game,-128,-1408,1,5);
        walls[1] = new Wall(game,-128,-1408,1,5);
        walls[2] = new Wall(game,-256,-1408,1,5);
        walls[3] = new Wall(game,-384,-1408,1,6);
        walls[4] = new Wall(game,128,-1408,1,5);
        walls[5] = new Wall(game,256,-1408,1,5);
        walls[6] = new Wall(game,384,-1408,1,4);
        walls[7] = new Wall(game,-384,-1536,1,7);
        walls[8] = new Wall(game,-384,-1664,1,7);
        walls[9]= new Wall(game,-384,-1792,1,7);
        walls[10] = new Wall(game,-384,-1920,1,7);
        walls[11] = new Wall(game,-384,-2048,1,7);
        walls[12] = new Wall(game,-384,-2176,1,7);
        walls[13] = new Wall(game,-384,-2432,1,7);
        walls[14] = new Wall(game,384,-1536,1,3);
        walls[15] = new Wall(game,384,-1792,1,3);
        walls[16] = new Wall(game,384,-1920,1,3);
        walls[17] = new Wall(game,384,-2048,1,3);
        walls[18] = new Wall(game,384,-2176,1,3);
        walls[19] = new Wall(game,384,-2304,1,3);
        walls[20] = new Wall(game,384,-2432,1,3);
        walls[21] = new Wall(game,-384,-2560,1,8);
        walls[22] = new Wall(game,-256,-2560,1,1);
        walls[23] = new Wall(game,-128,-2560,1,1);
        walls[24] = new Wall(game,128,-2560,1,1);
        walls[25] = new Wall(game,256,-2560,1,1);
        walls[26] = new Wall(game,384,-2560,1,2);
        walls[27] = new Wall(game,-256,-1920,1,1);
        walls[28] = new Wall(game,-128,-1920,1,1);
        walls[29] = new Wall(game,0,-1920,1,1);
        walls[30] = new Wall(game,-128,-2176,1,1);
        walls[31] = new Wall(game,128,-2176,1,1);
        walls[32]= new Wall(game,256,-2176,1,1);
         
        walls[33] = new Wall(game,512,-1792,1,1);
        walls[34]= new Wall(game,512,-1536,1,5);
        
        walls[35] = new Wall(game,-512,-2432,1,1);
        walls[36]= new Wall(game,-512,-2176,1,5);
        
         walls[37] = new Wall(game,-128,-2690,1,7);
        walls[38]= new Wall(game,128,-2690,1,3);

    
        trampaHab01 = new Trampa(game,128,-1920,1);
        trampaHab02 = new Trampa(game,0,-2176,1);
        
        enemy = new Enemy (game,-256,-2048,1);
        
        f1 = new Floor(game,512,-1664,1);
        f2 = new Floor(game,-512,-2304,1);
        f3 = new Floor(game,0,-2688,1);
        
        puertas[0] = new Puerta(game,384,-1664,1,2,false);
        puertas[1] = new Puerta(game,-384,-2304,1,4,true);
        puertas[2] = new Puerta(game,0,-2560,1,1,false);
        puertas[3] = new Puerta(game,0,-1408,1,3,true);
        
    }
    
   @Override
    public void paint(Graphics g){
        
        Graphics2D g2d = (Graphics2D) g;
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 5; j++) {
                FloorHab01[i][j].paint(g2d);
                
            }    
        }
        
        f1.paint(g);
        f2.paint(g);
        f3.paint(g);
        
        for (int i = 0; i < walls.length; i++) {
           walls[i].paint(g2d);
       }
       
        
        trampaHab01.paint(g2d);
        trampaHab02.paint(g2d);
        
        enemy.paint(g2d);
        for (int i = 0; i < puertas.length; i++) {
           puertas[i].paintDoor(g2d);
           puertas[i].paintTop(g2d);
       }
        
    }
    
    public void checkCollision(){
       
        for (int i = 0; i < walls.length; i++) {
            walls[i].checkCollision();
        }
        for (int i = 0; i <puertas.length; i++) {
            puertas[i].checkCollision();
        }
    }
    
    public void checkWallCollision(){
        for (int i = 0; i < 33; i++) {
            walls[i].enemyWall();
        
        }
        for (int i = 0; i < puertas.length; i++) {
            puertas[i].enemyWall();
        
        }
    }
    
    public void gameOver(){
        enemy.gameOver();
    }
    
    public void reiniciar(){
        enemy.gameOver();
    }
    
    public Rectangle room2(){
        return new Rectangle(-256-game.CamX, -2432-game.CamY, 5*128, 8*128);
    }
}
