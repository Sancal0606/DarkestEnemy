package Scripts;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import javax.swing.ImageIcon;

public class Interruptor {
    Game game;
    int num;
    Image actualSprite;
    Image On;
    Image Off;
    int posX;
    int posY;
    
    Interruptor(Game _game, int x,int y,int hab){
        game = _game;
        num = hab;
        ImageIcon off = new ImageIcon("src/Images/Interruptor.png");
        ImageIcon on = new ImageIcon("src/Images/Interruptor2.png");
        On=on.getImage();
        Off = off.getImage();
        actualSprite=null;
        posX = x;
        posY = y;
        num = hab;
    }
    public void paint(Graphics g){
      if(collisionPlayer()==true&&game.p1.accion==true){
          for (int i = 0; i < game.lightsOnRooms.length; i++) {
            game.lightsOnRooms[i]=true;
          }
          
      }
      if(game.lightsOnRooms[num]==true||(collisionLight()&&game.p1.lightOn)){
          actualSprite=On;
      }
      if(game.lightsOnRooms[num]==false&&(collisionLight()&&game.p1.lightOn))
          actualSprite=Off;
      else if(collisionLight()==false&&game.lightsOnRooms[num]==false)
          actualSprite=null;
      g.drawImage(actualSprite, posX-game.CamX, posY-game.CamY, null);
    }
    
    public void gameOver(){
        actualSprite=null;
        game.lightsOnRooms[num]=false;
    }
    
     private boolean collisionPlayer(){
        return game.p1.getBoundsPlayer().intersects(getBounds());
    }
     private boolean collisionLight(){
        return game.p1.getBoundsLight().intersects(getBounds());
    }
    
     public Rectangle getBounds(){
        return new Rectangle(posX-game.CamX-48, posY-game.CamY-35, 128,128);
    }    
}
