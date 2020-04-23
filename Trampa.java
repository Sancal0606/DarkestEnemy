package Scripts;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import javax.swing.ImageIcon;

public class Trampa {
    Game game;
    int posX;
    int posY;
    Color color;
    boolean light;
    Image trampa;
    Image actualTrampa;
    int num;
    
    public Trampa(Game _game, int _posX, int _posY, int hab){
        game = _game;
        posX = _posX;
        posY = _posY;
         ImageIcon lDL = new ImageIcon("src/Images/Trampa.png");
        trampa = lDL.getImage();
        actualTrampa=null;
        num = hab;
    }
    
    public void paint(Graphics2D g){
       
        if(collisionLight()&&game.p1.lightOn){
         light=true;
       }
       else{
           light=false;
       }
        if(light||game.lightsOnRooms[num]==true){
            actualTrampa = trampa;
        }
        else if (!collisionPlayer()&&!collisionEnemy()&&!collisionEnemy2()){
            actualTrampa = null;
        }
          //g.setColor(color);
        //g.fillRect(posX-game.CamX, posY-game.CamY, 128, 128);
        g.drawImage(actualTrampa, posX-game.CamX, posY-game.CamY,null);
        collision();
    }
    
    void collision(){
        if(collisionPlayer()){
            color=Color.red;
            game.isGameOver = true;
            game.p1.positionX=posX+14;
            actualTrampa = trampa;
            game.p1.positionY=posY+7;
        }
        if(collisionEnemy()){
            color = Color.red;
            game.mapa2.enemy.currentImage = game.enemy.front1;
            actualTrampa = trampa;
            game.mapa2.enemy.isActive = false;
            game.mapa2.enemy.x=posX;
            game.mapa2.enemy.y = posY;
        }
         if(Hab03Enemy1()){
            color = Color.red;
          game.mapa3.enemies[0].currentImage = game.enemy2.front1;
            actualTrampa = trampa;
            game.mapa3.enemies[0].isActive = false;
            game.mapa3.enemies[0].x=posX;
            game.mapa3.enemies[0].y = posY;
        }
         if(Hab03Enemy2()){
            color = Color.red;
           game.mapa3.enemies[1].currentImage = game.enemy2.front1;
            actualTrampa = trampa;
            game.mapa3.enemies[1].isActive = false;
            game.mapa3.enemies[1].x=posX;
            game.mapa3.enemies[1].y = posY;
        }
         
        if(Hab04Enemy1()){
            color = Color.red;
          game.mapa4.enemies[0].currentImage = game.enemy2.front1;
            actualTrampa = trampa;
            game.mapa4.enemies[0].isActive = false;
            game.mapa4.enemies[0].x=posX;
            game.mapa4.enemies[0].y = posY;
        }
         if(Hab04Enemy2()){
            color = Color.red;
           game.mapa4.enemies[1].currentImage = game.enemy2.front1;
            actualTrampa = trampa;
            game.mapa4.enemies[1].isActive = false;
            game.mapa4.enemies[1].x=posX;
            game.mapa4.enemies[1].y = posY;
        } 
         if(Hab10Enemy1()){
            color = Color.red;
           game.mapa10.enemies[0].currentImage = game.enemy2.front1;
            actualTrampa = trampa;
            game.mapa10.enemies[0].isActive = false;
            game.mapa10.enemies[0].x=posX;
            game.mapa10.enemies[0].y = posY;
        } 
         if(Hab10Enemy2()){
            color = Color.red;
           game.mapa10.enemies[1].currentImage = game.enemy2.front1;
            actualTrampa = trampa;
            game.mapa10.enemies[1].isActive = false;
            game.mapa10.enemies[1].x=posX;
            game.mapa10.enemies[1].y = posY;
        } 
    }
    
    public void gameOver(){
        actualTrampa = null;
    }
    
    private boolean collisionLight(){
        return game.p1.getBoundsLight().intersects(getBoundsTrampa());
    }
    
    private boolean collisionPlayer(){
        return game.p1.getBoundsPlayer().intersects(getBoundsTrampaPlayer());
    }
    private boolean collisionEnemy(){
        return game.mapa2.enemy.getBounds().intersects(getBoundsTrampa());
    }
    
    private boolean Hab03Enemy1(){
        return game.mapa3.enemies[0].getBounds().intersects(getBoundsTrampa());
    }
    private boolean Hab03Enemy2(){
        return game.mapa3.enemies[1].getBounds().intersects(getBoundsTrampa());
    }
    
    private boolean Hab10Enemy1(){
        return game.mapa10.enemies[0].getBounds().intersects(getBoundsTrampa());
    }
    private boolean Hab10Enemy2(){
        return game.mapa10.enemies[1].getBounds().intersects(getBoundsTrampa());
    }
    
    private boolean Hab04Enemy1(){
        return game.mapa4.enemies[0].getBounds().intersects(getBoundsTrampa());
    }
    private boolean Hab04Enemy2(){
        return game.mapa4.enemies[1].getBounds().intersects(getBoundsTrampa());
    }
    
    private boolean collisionEnemy2(){
        return game.enemy2.getBounds().intersects(getBoundsTrampa());
    }
    
    public Rectangle getBoundsTrampaPlayer(){
        return new Rectangle(posX-game.CamX+19, posY-game.CamY, 90,50);
    }
    public Rectangle getBoundsTrampa(){
        return new Rectangle(posX-game.CamX, posY-game.CamY, 128,128);
    }
   
}
