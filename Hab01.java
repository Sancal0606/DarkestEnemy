package Scripts;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import javax.swing.JPanel;

public class Hab01 extends JPanel{
   
   Game game; 
   
    Floor FloorHab01[][]= new Floor[8][5];
    Wall wallHab01;
    Wall wallHab02;
    Wall wallHab03;
    Wall wallHab04;
    Wall wallHab05;
    Wall wallHab06;
    Wall wallHab07;
    Wall wallHab08;
    Wall wallHab09;
    Wall wallHab10;
    Wall wallHab11;
    Wall wallHab12;
    Wall wallHab13;
    Wall wallHab14;
    Wall wallHab15;
    Wall wallHab16;
    Wall wallHab17;
    Wall wallHab18;
    Wall wallHab19;
    Wall wallHab20;
    Wall wallHab21;
    Wall wallHab22;
    Wall wallHab23;
    Wall wallHab24;
    Wall wallHab25;
    Wall wallHab26;
    Wall wallHab28;
    Wall wallHab29;
    Wall wallHab30;
    Wall wallHab31;
    Wall wallHab32;
    Trampa trampaHab01; 
    Trampa trampaHab02; 
    Trampa trampaHab03; 
    Trampa trampaHab04; 
    Trampa trampaHab05; 
    Trampa trampaHab06; 
    Floor f;
    Puerta puerta1;

    Hab01 (Game _game){
        game = _game;
        crear();
    }
    
    private void crear(){
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 5; j++) {
                FloorHab01[i][j]= new Floor(game,j*128-256,i*(128)-1152,0);
            }    
        }
        f = new Floor(game,0,-1280,0);
        puerta1 = new Puerta(game,0,-1152,0,1,true);
        wallHab01 = new Wall(game,-128,-128,0,5);
        wallHab02 = new Wall(game,-128,-128,0,5);
        wallHab03 = new Wall(game,-256,-128,0,5);
        wallHab04 = new Wall(game,-384,-128,0,6);
        wallHab05 = new Wall(game,128,-128,0,5);
        wallHab06 = new Wall(game,256,-128,0,5);
        wallHab07 = new Wall(game,384,-128,0,4);
        wallHab08 = new Wall(game,-384,-256,0,7);
        wallHab09 = new Wall(game,-384,-384,0,7);
        wallHab10 = new Wall(game,-384,-512,0,7);
        wallHab11 = new Wall(game,-384,-640,0,7);
        wallHab12 = new Wall(game,-384,-768,0,7);
        wallHab13 = new Wall(game,-384,-896,0,7);
        wallHab14 = new Wall(game,-384,-1024,0,7);
        wallHab15 = new Wall(game,-384,-1152,0,7);
        wallHab16 = new Wall(game,384,-256,0,3);
        wallHab17 = new Wall(game,384,-384,0,3);
        wallHab18 = new Wall(game,384,-512,0,3);
        wallHab19 = new Wall(game,384,-640,0,3);
        wallHab20 = new Wall(game,384,-768,0,3);
        wallHab21 = new Wall(game,384,-896,0,3);
        wallHab22 = new Wall(game,384,-1024,0,3);
        wallHab23 = new Wall(game,384,-1152,0,3);
        wallHab24 = new Wall(game,-384,-1152,0,8);
        wallHab25 = new Wall(game,-256,-1152,0,1);
        wallHab26 = new Wall(game,-128,-1152,0,1);
        
        
        wallHab28 = new Wall(game,128,-1152,0,1);
        wallHab29 = new Wall(game,256,-1152,0,1);
        wallHab30 = new Wall(game,384,-1152,0,2);
        
         wallHab31 = new Wall(game,-128,-1280,0,7);
          wallHab32 = new Wall(game,128,-1280,0,3);
          
        trampaHab01 = new Trampa(game,-128,-640,0);
        trampaHab02 = new Trampa(game,0,-640,0);
        trampaHab03 = new Trampa(game,128,-640,0);
        trampaHab04 = new Trampa(game,-128,-768,0);
        trampaHab05 = new Trampa(game,0,-768,0);
        trampaHab06 = new Trampa(game,128,-768,0);
    
    }
    
   @Override
    public void paint(Graphics g){
        
        Graphics2D g2d = (Graphics2D) g;
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 5; j++) {
                FloorHab01[i][j].paint(g2d);
            }    
        }
        f.paint(g2d);
        wallHab01.paint(g2d);
        wallHab02.paint(g2d);
        wallHab03.paint(g2d);
        wallHab04.paint(g2d);
        wallHab05.paint(g2d);
        wallHab06.paint(g2d);
        wallHab07.paint(g2d);
        wallHab08.paint(g2d);
        wallHab09.paint(g2d);
        wallHab10.paint(g2d);
        wallHab11.paint(g2d);
        wallHab12.paint(g2d);
        wallHab13.paint(g2d);
        wallHab14.paint(g2d);
        wallHab15.paint(g2d);
        wallHab16.paint(g2d);
        wallHab17.paint(g2d);
        wallHab18.paint(g2d);
        wallHab19.paint(g2d);
        wallHab20.paint(g2d);
        wallHab21.paint(g2d);
        wallHab22.paint(g2d);
        wallHab23.paint(g2d);
        wallHab24.paint(g2d);
        wallHab25.paint(g2d);
        wallHab26.paint(g2d);
        wallHab28.paint(g2d);
        wallHab29.paint(g2d);
        wallHab30.paint(g2d);
        wallHab31.paint(g2d);
        wallHab32.paint(g2d);
        trampaHab01.paint(g2d);
        trampaHab02.paint(g2d);
        trampaHab03.paint(g2d);
        trampaHab04.paint(g2d);
        trampaHab05.paint(g2d);
        trampaHab06.paint(g2d);
        puerta1.paintDoor(g2d);
        puerta1.paintTop(g2d);
    }
    
    public void checkCollision(){
         wallHab01.checkCollision();
        wallHab02.checkCollision();
        wallHab03.checkCollision();
        wallHab04.checkCollision();
        wallHab05.checkCollision();
        wallHab06.checkCollision();
        wallHab07.checkCollision();
         wallHab08.checkCollision();
        wallHab09.checkCollision();
        wallHab10.checkCollision();
         wallHab11.checkCollision();
        wallHab12.checkCollision();
        wallHab13.checkCollision();
        wallHab14.checkCollision();
        wallHab15.checkCollision();
        wallHab16.checkCollision();
        wallHab17.checkCollision();
         wallHab18.checkCollision();
        wallHab19.checkCollision();
        wallHab20.checkCollision();
         wallHab21.checkCollision();
        wallHab22.checkCollision();
        wallHab23.checkCollision();
        wallHab24.checkCollision();
        wallHab25.checkCollision();
        wallHab26.checkCollision();
         wallHab28.checkCollision();
        wallHab29.checkCollision();
        wallHab30.checkCollision();
        wallHab31.checkCollision();
        wallHab32.checkCollision();
        puerta1.checkCollision();
    }
    
    public void checkWallCollision(){
        wallHab01.enemyWall();
        wallHab02.enemyWall();
        wallHab03.enemyWall();
        wallHab04.enemyWall();
        wallHab05.enemyWall();
        wallHab06.enemyWall();
        wallHab07.enemyWall();
        wallHab08.enemyWall();
        wallHab09.enemyWall();
        wallHab10.enemyWall();
        wallHab11.enemyWall();
        wallHab12.enemyWall();
        wallHab13.enemyWall();
        wallHab14.enemyWall();
        wallHab15.enemyWall();
        wallHab16.enemyWall();
        wallHab17.enemyWall();
        wallHab18.enemyWall();
        wallHab19.enemyWall();
        wallHab20.enemyWall();
        wallHab21.enemyWall();
        wallHab22.enemyWall();
        wallHab23.enemyWall();
        wallHab24.enemyWall();
        wallHab25.enemyWall();
        wallHab26.enemyWall();
        wallHab28.enemyWall();
        wallHab29.enemyWall();
        wallHab30.enemyWall();
        wallHab31.enemyWall();
        wallHab32.enemyWall();
        puerta1.enemyWall();
    }
    
    public Rectangle room1(){
        return new Rectangle(-256-game.CamX, -1152-game.CamY, 5*128, 8*128);
    }
}
