package Scripts;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

public class Hab11 {
    Game game;
    Wall walls[]= new Wall[26];
    Floor FloorHab01[][]= new Floor[7][6];
    Puerta puertas[] = new Puerta[2];
    Interruptor int1;
    Floor f1;

    
    Hab11(Game _game){
        game = _game;
        generar();
    }
    
     private void generar(){
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6; j++) {
                FloorHab01[i][j]= new Floor(game,j*128+1792,i*(128)-2048,7);
            }    
        }
       int1 = new Interruptor(game,2048+50,-2176+50,8);
        for (int i = 0; i < 5; i++) {
            walls[i]= new Wall(game,i*(128)+1792,-1408,7,5);
        }
        for (int i = 5; i < 10; i++) {
            walls[i]= new Wall(game,1664,(i-5)*(-128)-1536,7,7);
        }
        for (int i = 10; i < 15; i++) {
            walls[i]= new Wall(game,2432,(i-10)*(-128)-1536,7,3);
        }
        for (int i = 15; i < 20; i++) {
            walls[i]= new Wall(game,(i-15)*(128)+1792,-2176,7,1);
        }
        walls[6]=walls[1];
        walls[12]=walls[1];
        
        walls[20]= new Wall(game,2432,-1408,7,4);
        walls[21]= new Wall(game,1664,-1408,7,6);
        walls[22]= new Wall(game,2432,-2176,7,2);
        walls[23]= new Wall(game,1664,-2176,7,8);
       
     
        
         walls[24]= new Wall(game,1536,-1792,7,1);
        walls[25]= new Wall(game,1536,-1536,7,5);
        
        f1 = new Floor(game,1536,-1664,5);
        
        puertas[0] = new Puerta(game,1664,-1664,7,4,true);
        puertas[1] = new Puerta(game,2432,-1792,7,2,true);

        

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
        
        int1.paint(g);
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
    
    public Rectangle room5(){
        return new Rectangle(1792-game.CamX, -2048-game.CamY, 5*128, 5*128);
    }
}
