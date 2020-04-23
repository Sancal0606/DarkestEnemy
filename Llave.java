package Scripts;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import javax.swing.ImageIcon;

public class Llave {
    Game game;
    int x; 
    int y;
    int num;
    Image uno;
    Image dos;
    Image current;
    boolean isActive;
    boolean light;
    
    Llave(Game _game, int posX, int posY, int _hab){
        game=_game;
        x = posX;
        y = posY;
        num =_hab;
        ImageIcon i1 = new ImageIcon("src/Images/Llave01.png");
        uno =i1.getImage();
        isActive=true;
    }
    
    
    public void paint (Graphics g){
        
      
   if(isActive){
        if(collisionLight()&&game.p1.lightOn){
         light=true;
       }
       else{
           light=false;
       } 
       if(light||game.lightsOnRooms[num]==true){

         current=uno;
       }
       else{
           current=null;
       }
       g.drawImage(current, x+42-game.CamX,y+20-game.CamY, null);
    }
   else if(isActive==false&&game.p1.llaves>0) 
       g.drawImage(uno, game.getWidth()/2+128,30, null);
    collision();
    }  
    public void collision(){
        if(collisionPlayer()&&isActive==true){
             isActive=false;
             game.p1.llaves++;
        }
       
    }
    
    public void gameover(){
        isActive=true;
    }
     public Rectangle getBounds(){
        return new Rectangle(x-game.CamX+42, y-game.CamY+20, 44, 88);    
    }
    public Rectangle getBoundsLight(){
        return new Rectangle(x-game.CamX, y-game.CamY, 128, 128);    
    }
    
    private boolean collisionLight(){
        return game.p1.getBoundsLight().intersects(getBoundsLight());
    }
    
    private boolean collisionPlayer(){
        return game.p1.getBoundsPlayer().intersects(getBounds());
    }
}
