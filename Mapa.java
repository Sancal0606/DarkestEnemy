package Scripts;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import javax.swing.ImageIcon;

public class Mapa {
    Game game;
    int radius = 50;
    Color color;
    public boolean isActive=true;
    int posX;
    int posY;
    boolean light;
    Image icon;
    Image mapa;
    Image currentImage;
    int num;
    
    public Mapa(Game _game, int _posX, int _posY, int hab){
        game = _game;
        posX = _posX;
        posY = _posY;
        ImageIcon p0 = new ImageIcon("src/Images/IconoMapa.png");
        ImageIcon p1 = new ImageIcon("src/Images/Mapa.png");
        icon = p0.getImage();
        mapa = p1.getImage();
        currentImage = icon;
        num = hab;
    }
    
    public void paint(Graphics2D g){
      if(isActive){
        if(collisionLight()&&game.p1.lightOn){
         light=true;
       }
       else{
           light=false;
       } 
       if(light||game.lightsOnRooms[num]==true){
         color = Color.green;
         currentImage=icon;
       }
       else{
           color = Color.black;
           currentImage=null;
       }
       g.setColor(color);
      
      
       checkCollision();
        g.drawImage(currentImage, posX+42-game.CamX,posY+20-game.CamY, null);
      }
     
      
       if(isActive==false){
            g.drawImage(currentImage, posX,posY, null);
            System.out.println("H");
       }
    }
    
    void checkCollision(){
        if(collisionPlayer()){
            posX = 1110;
            posY=30;
            currentImage=mapa;
            isActive=false;

        }
    }
    
    
    
    public Rectangle getBounds(){
        return new Rectangle(posX-game.CamX+42, posY-game.CamY+20, 44, 88);    
    }
    public Rectangle getBoundsLight(){
        return new Rectangle(posX-game.CamX, posY-game.CamY, 128, 128);    
    }
    
    private boolean collisionLight(){
        return game.p1.getBoundsLight().intersects(getBoundsLight());
    }
    
    private boolean collisionPlayer(){
        return game.p1.getBoundsPlayer().intersects(getBounds());
    }
}


