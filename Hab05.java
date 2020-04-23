package Scripts;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

public class Hab05 {
    Game game;
    Wall walls[]= new Wall[28];
    Floor FloorHab01[][]= new Floor[7][6];
    Puerta puertas[] = new Puerta[4];
    
    Floor f1;
    Floor f2;
    
    Hab05(Game _game){
        game = _game;
        generar();
    }
    
     private void generar(){
        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 6; j++) {
                FloorHab01[i][j]= new Floor(game,j*128-256,i*(128)-3456,4);
            }    
        }
        
        for (int i = 0; i < 5; i++) {
            walls[i]= new Wall(game,i*(128)-256,-2816,4,5);
        }
        for (int i = 5; i < 10; i++) {
            walls[i]= new Wall(game,-384,(i-5)*(-128)-2944,4,7);
        }
        for (int i = 10; i < 15; i++) {
            walls[i]= new Wall(game,384,(i-10)*(-128)-2944,4,3);
        }
        for (int i = 15; i < 20; i++) {
            walls[i]= new Wall(game,(i-15)*(128)-256,-3584,4,1);
        }
        walls[12]=walls[1];
        walls[17]=walls[1];
        walls[2]=walls[1];
        walls[7]=walls[1];
        
        walls[20]= new Wall(game,384,-2816,4,4);
        walls[21]= new Wall(game,-384,-2816,4,6);
        walls[22]= new Wall(game,-384,-3584,4,8);
        walls[23]= new Wall(game,384,-3584,4,2);
        
         walls[24]= new Wall(game,-128,-3712,4,7);
        walls[25]= new Wall(game,128,-3712,4,3);
        
        walls[26]= new Wall(game,512,-3328,4,1);
        walls[27]= new Wall(game,512,-3072,4,5);
       
        f1 = new Floor(game,0,-3712,4);
        f2 = new Floor(game,512,-3200,4);
        
        puertas[0] = new Puerta(game,0,-2816,4,3,false);
        puertas[1] = new Puerta(game,-384,-3200,4,4,true);
        puertas[2] = new Puerta(game,384,-3200,4,2,true);
        puertas[3] = new Puerta(game,0,-3584,4,1,false);
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
        for (int i = 0; i < walls.length; i++) {
            walls[i].paint(g2d);
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
        if(game.p1.getBoundsPlayer2().intersects(f())){
            game.p1.endGame=true;
        }
    }
    
public Rectangle room5(){
        return new Rectangle(-256-game.CamX, -3456-game.CamY, 5*128, 5*128);
}
    
 public Rectangle f(){
        return new Rectangle(0-game.CamX, -3712-game.CamY, 128, 40);
} 
}