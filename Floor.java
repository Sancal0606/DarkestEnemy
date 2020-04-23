package Scripts;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import javax.swing.ImageIcon;

public class Floor {
    public Game game;
    Image image;
    ImageIcon i0;
    
    boolean light=true;
    int x;
    int y;
    int num;
    Pilas pilaUno;
    Floor(Game _game,int posX,int posY, int hab){
        game = _game;
        x=posX;
        y=posY;
        num = hab;
        //pilaUno = new Pilas(game,x,y,0);
    }
    
    
    public void paint(Graphics g){
         i0 = new ImageIcon("src/Images/Floor.png");
         image = i0.getImage();
        if((collisionLight()&&game.p1.lightOn)||collisionPlayer()||game.lightsOnRooms[num]==true){
         light=true;
       }else{
            light=false;
        }
        if(light==true)
            g.drawImage(image, x-game.CamX, y-game.CamY, null);
        Graphics2D g2d = (Graphics2D)g;
        //pilaUno.paint(g2d);
    }
    
   private boolean collisionPlayer(){
        
        return game.p1.getBoundsPlayerLight().intersects(getBounds());
        
    }
    
     private boolean collisionLight(){
        
        return game.p1.getBoundsLight().intersects(getBounds());
        
    }
    
    public Rectangle getBounds(){
        return new Rectangle(x-game.CamX, y-game.CamY, 128, 128);
    }
}
