package Scripts;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import javax.swing.ImageIcon;

public class Bloque2 {
 Game game;
    
    int posX;
    int posY;
    int sizeX;
    int sizeY;
    boolean light;
    Color color;
    Image sprite;
    Image sprite1;
    Image sprite2;
    Image sprite3;
    Image sprite4;
    Image sprite5;
    Image sprite6;
    Image sprite7;
    Image sprite8;
    Image actualSprite;
    int num;
    int orient;
    boolean obstacleX;
    boolean obstacleY;
    int xa;
    int ya;
    int inicialX;
    int inicialY;
    
    public Bloque2 (Game _game, int _posX,int _posY, int hab){
        posX=_posX;
        posY=_posY;
        inicialX=posX;
        inicialY=posY;
        sizeX=128;
        sizeY=128;
        game =_game;
        ImageIcon f1=   new ImageIcon("src/Images/ParedFrente.png");
        sprite1 = f1.getImage();
        actualSprite=null;
        num = hab;

    }
    public void paint(Graphics2D g){
      posX+=xa;
      posY+=ya;
        g.setColor(Color.blue);
       g.fillRect(posX-game.CamX, posY-game.CamY, 128, 128);
       
       
      // g.drawImage(actualSprite,posX+(-game.CamX), posY+(-game.CamY), null);
    }

    public void checkCollision(){
         
         if(collisionLight()&&game.p1.lightOn){
         light=true;
       }
       else{
           light=false;
       }
         if(light||game.lightsOnRooms[num]){
             color = Color.white;
             if(sizeX==32){
                 actualSprite = sprite2;
             }else
             actualSprite=sprite;
         }
          else{
           color = Color.black;
           actualSprite=null;
       }
         
         
        if((game.p1.positionX+(game.p1.horzMove*game.p1.speed)+65>posX&&
               game.p1.positionX+(game.p1.horzMove*game.p1.speed)<posX+sizeX)&&
               (game.p1.positionY+(game.p1.vertMove*game.p1.speed)+116>posY)&&
               (game.p1.positionY+(game.p1.vertMove*game.p1.speed)<posY+sizeY-80)){
 
           if(game.p1.vertMove==game.p1.speed){
   
                    game.p1.vertMove=0; 
                   
               
           }
           if(game.p1.horzMove==-game.p1.speed){
               
                    game.p1.horzMove=0;
                
           }
           if(game.p1.vertMove==-game.p1.speed) {
               
                    game.p1.vertMove=0;
              
           }
           if(game.p1.horzMove==game.p1.speed&&game.p1.accion==false){
                game.p1.horzMove=0;
           }
       }  
         xa=0;
          ya=0;
          obstacleX=false;
          obstacleY=false;
        game.CollisionBlock();  
        
          if(obstacleX==false){
               if(PlayerIzq()&&game.p1.horzMove>0){
                    xa=game.p1.speed;
                }
               if(PlayerDer()&&game.p1.horzMove<0){
                    xa=-game.p1.speed;
                }
               
          }
          if(obstacleY==false){
              if(PlayerArr()&&game.p1.vertMove>0){
                    ya=game.p1.speed;
                }
               if(PlayerAba()&&game.p1.vertMove<0){
                    ya=-game.p1.speed;
                }
          }
          
         enemyWall();  
     }
 
    public void collBloque(){
        if(this==game.bo1){
          if(Bloqu1Izq()==true)
              game.bo1.obstacleX=true;
          if(Bloqu1Der()==true)
              game.bo1.obstacleX=true;
          if(Bloqu1Arr()==true)
              game.bo1.obstacleY=true;
          if(Bloqu1Aba()==true)
              game.bo1.obstacleY=true;
        }
         if(this==game.bo2){
          if(Bloqu1Izq()==true)
              game.bo2.obstacleX=true;
          if(Bloqu1Der()==true)
              game.bo2.obstacleX=true;
          if(Bloqu1Arr()==true)
              game.bo2.obstacleY=true;
          if(Bloqu1Aba()==true)
              game.bo2.obstacleY=true;
        }
         bloqueHab08();
    }
    
    public void bloqueHab08(){
        for (int i = 0; i < game.mapa8.bloques.length; i++) {
            if(game.mapa8.bloques[i].collisionIzq().intersects(getBoundsWall())==true)
              game.mapa8.bloques[i].obstacleX=true;
            if(game.mapa8.bloques[i].collisionDer().intersects(getBoundsWall())==true)
              game.mapa8.bloques[i].obstacleX=true;
            if(game.mapa8.bloques[i].collisionArr().intersects(getBoundsWall())==true)
              game.mapa8.bloques[i].obstacleY=true;
            if(game.mapa8.bloques[i].collisionAba().intersects(getBoundsWall())==true)
              game.mapa8.bloques[i].obstacleY=true;
        }
        bloqueHab09();
    }
    
    public void bloqueHab09(){
        for (int i = 0; i < game.mapa9.bloques.length; i++) {
            if(game.mapa9.bloques[i].collisionIzq().intersects(getBoundsWall())==true)
              game.mapa9.bloques[i].obstacleX=true;
            if(game.mapa9.bloques[i].collisionDer().intersects(getBoundsWall())==true)
              game.mapa9.bloques[i].obstacleX=true;
            if(game.mapa9.bloques[i].collisionArr().intersects(getBoundsWall())==true)
              game.mapa9.bloques[i].obstacleY=true;
            if(game.mapa9.bloques[i].collisionAba().intersects(getBoundsWall())==true)
              game.mapa9.bloques[i].obstacleY=true;
        }
        bloqueHab10();
    }
    
    public void bloqueHab10(){
        for (int i = 0; i < game.mapa10.bloques.length; i++) {
            if(game.mapa10.bloques[i].collisionIzq().intersects(getBoundsWall())==true)
              game.mapa10.bloques[i].obstacleX=true;
            if(game.mapa10.bloques[i].collisionDer().intersects(getBoundsWall())==true)
              game.mapa10.bloques[i].obstacleX=true;
            if(game.mapa10.bloques[i].collisionArr().intersects(getBoundsWall())==true)
              game.mapa10.bloques[i].obstacleY=true;
            if(game.mapa10.bloques[i].collisionAba().intersects(getBoundsWall())==true)
              game.mapa10.bloques[i].obstacleY=true;
        }
    }
    
    public void gameOver(){
        posX=inicialX;
        posY=inicialY;
    }
    
    public void block(){ 
        if((game.b1.posX+(game.b1.xa*game.p1.speed)+128>posX&&
               game.b1.posX+(game.b1.xa*game.p1.speed)<posX+sizeX)&&
               (game.b1.posY+(game.b1.ya*game.p1.speed)+128>posY)&&
               (game.b1.posY+(game.b1.ya*game.p1.speed)<posY+sizeY)){
                game.b1.xa=0;
                game.b1.ya=0;
                
                game.b1.canMove=false;
                   if(game.p1.vertMove==game.p1.speed){
                        game.p1.positionY-=game.p1.speed;
                    game.p1.vertMove=0; 
                      game.CamY-=game.p1.speed;
      
               
           }
           if(game.p1.horzMove==-game.p1.speed){
                    game.p1.positionX+=game.p1.speed;
                    game.CamX+=game.p1.speed;
                    game.p1.horzMove=0;
                
           }
           if(game.p1.vertMove==-game.p1.speed) {
                game.CamY+=game.p1.speed;
               game.p1.positionY+=game.p1.speed;
                    game.p1.vertMove=0;
              
           }
           if(game.p1.horzMove==game.p1.speed){
                game.p1.horzMove=0;
              game.CamX-=game.p1.speed;
               game.p1.positionX-=game.p1.speed;
           }
           }
    }
    
    public void enemyWall(){
      

       if(game.enemy.x+game.enemy.xa+128>posX-game.p1.speed&&
               game.enemy.x+game.enemy.xa+6<posX+sizeX+game.p1.speed&&
               game.enemy.y+game.enemy.ya+108>posY-game.p1.speed&&
               game.enemy.y+game.enemy.ya+6<posY+sizeY+game.p1.speed){

       }
        if(game.enemy.x+game.enemy.xa+128>posX&&
               game.enemy.x+game.enemy.xa+6<posX+sizeX&&
               game.enemy.y+game.enemy.ya+108>posY&&
               game.enemy.y+game.enemy.ya+6<posY+sizeY){
            
            if(game.enemy.xa>0){
               game.enemy.xa=0; 
               game.enemy.tryY=true;
           }
           if(game.enemy.xa<0){
               game.enemy.xa=0;
               game.enemy.tryY=true;
           }
           if(game.enemy.ya<0){
                game.enemy.ya=0;    

           }
           if(game.enemy.ya>0){
               game.enemy.ya=0;

           }
            if(game.enemy.y+game.enemy.ya<posY-12+108&&game.enemy.x+game.enemy.xa+128>posX&&
               game.enemy.x+game.enemy.xa+6<posX+sizeX ){
               game.enemy.notYUp=true;
           }else
                game.enemy.notYUp=false;
            if(game.enemy.y+game.enemy.ya+108>posY+12&&game.enemy.x+game.enemy.xa+128>posX&&
               game.enemy.x+game.enemy.xa+6<posX+sizeX)
                game.enemy.notYDown=true;
            else
                game.enemy.notYDown=false;
            
       }
        enemy2Wall();
    }
    
    public void enemy2Wall(){
 
        if(game.enemy2.x+game.enemy2.xa+128>posX-game.p1.speed&&
               game.enemy2.x+game.enemy2.xa+6<posX+sizeX+game.p1.speed&&
               game.enemy2.y+game.enemy2.ya+108>posY-game.p1.speed&&
               game.enemy2.y+game.enemy2.ya+6<posY+sizeY+game.p1.speed){
            
        }
        if(game.enemy2.x+game.enemy2.xa+128>posX&&
               game.enemy2.x+game.enemy2.xa+6<posX+sizeX&&
               game.enemy2.y+game.enemy2.ya+108>posY&&
               game.enemy2.y+game.enemy2.ya+6<posY+sizeY){
          
           if(game.enemy2.xa>0){
               game.enemy2.x-=game.enemy2.speed; 
               game.enemy2.tryY=true;
           }
           if(game.enemy2.xa<0){
               game.enemy2.x+=game.enemy2.speed;
               game.enemy2.tryY=true;
           }
           if(game.enemy2.ya<0){
                game.enemy2.y+=game.enemy2.speed;    
                
           }
           if(game.enemy2.ya>0){
               game.enemy2.y-=game.enemy2.speed;
              
           }
           
           if(game.enemy2.y+game.enemy2.ya<posY-12+128&&game.enemy2.x+game.enemy2.xa+128>posX&&
               game.enemy2.x+game.enemy2.xa+6<posX+sizeX ){
               game.enemy2.notYUp=true;
           }else
                game.enemy2.notYUp=false;
            if(game.enemy2.y+game.enemy2.ya+108>posY+12&&game.enemy2.x+game.enemy2.xa+128>posX&&
               game.enemy2.x+game.enemy2.xa+6<posX+sizeX)
                game.enemy2.notYDown=true;
            else
                game.enemy2.notYDown=false;
               
       }
        enemyHab10();
    }
    
     public void enemyHab10(){
          for (int i = 0; i < game.mapa10.enemies.length; i++) {
             
            if(game.mapa10.enemies[i].x+game.mapa10.enemies[i].xa+128>posX&&
                game.mapa10.enemies[i].x+game.mapa10.enemies[i].xa+6<posX+sizeX&&
                game.mapa10.enemies[i].y+game.mapa10.enemies[i].ya+108>posY&&
                game.mapa10.enemies[i].y+game.mapa10.enemies[i].ya+6<posY+sizeY){
          
                    if(game.mapa10.enemies[i].xa>0){
                        game.mapa10.enemies[i].x-=game.mapa10.enemies[i].speed; 
                        game.mapa10.enemies[i].tryY=true;
                    }
                    if(game.mapa10.enemies[i].xa<0){
                        game.mapa10.enemies[i].x+=game.mapa10.enemies[i].speed;
                        game.mapa10.enemies[i].tryY=true;
                    }
                    if(game.mapa10.enemies[i].ya<0){
                        game.mapa10.enemies[i].y+=game.mapa10.enemies[i].speed;    
                    }
                    if(game.mapa10.enemies[i].ya>0){
                        game.mapa10.enemies[i].y-=game.mapa10.enemies[i].speed;
                    }
           
                    if(game.mapa10.enemies[i].y+game.mapa10.enemies[i].ya<posY-12+128&&game.mapa10.enemies[i].x+game.mapa10.enemies[i].xa+128>posX&&
                        game.mapa10.enemies[i].x+game.mapa10.enemies[i].xa+6<posX+sizeX )
                    {
                            game.mapa10.enemies[i].notYUp=true;
                    }else
                        game.mapa10.enemies[i].notYUp=false;
                    if(game.mapa10.enemies[i].y+game.mapa10.enemies[i].ya+108>posY+12&&game.mapa10.enemies[i].x+game.mapa10.enemies[i].xa+128>posX&&
                        game.mapa10.enemies[i].x+game.mapa10.enemies[i].xa+6<posX+sizeX)
                            game.mapa10.enemies[i].notYDown=true;
                    else
                        game.mapa10.enemies[i].notYDown=false;
               
            }
        }
     }
    
     public Rectangle getBoundsWall(){
        return new Rectangle(posX-game.CamX, posY-game.CamY, sizeX, sizeY);
    }
     
    public Rectangle collisionIzq(){
         return new Rectangle(posX-game.CamX-2, posY-game.CamY, 2, 128);
    }
    public Rectangle collisionDer(){
         return new Rectangle(posX-game.CamX+128, posY-game.CamY, 2, 128);
    }
    public Rectangle collisionArr(){
         return new Rectangle(posX-game.CamX+14, posY-game.CamY-2, 100, 2);
    }
    public Rectangle collisionAba(){
         return new Rectangle(posX-game.CamX+14, posY-game.CamY+128, 100, 2);
    }
    
    private boolean PlayerIzq(){
        return game.p1.getBoundsBloque().intersects(collisionIzq());
    }
    
    private boolean PlayerDer(){
        return game.p1.getBoundsPlayer2().intersects(collisionDer());
    }
    
    private boolean PlayerArr(){
        return game.p1.getBoundsPlayer2().intersects(collisionArr());
    }
    
    private boolean PlayerAba(){
        return game.p1.getBoundsPlayer2().intersects(collisionAba());
    }
    
   
    
    private boolean collisionLight(){
        return game.p1.getBoundsLight().intersects(getBoundsWall());
    }
   
    
   public boolean Bloqu1Izq(){
        return game.bo2.collisionIzq().intersects(game.bo1.getBoundsWall());
    }
    public boolean Bloqu1Der(){
        return game.bo2.collisionDer().intersects(game.bo1.getBoundsWall());
    }
    public boolean Bloqu1Arr(){
        return game.bo2.collisionArr().intersects(game.bo1.getBoundsWall());
    } 
    public boolean Bloqu1Aba(){
        return game.bo2.collisionAba().intersects(game.bo1.getBoundsWall());
    }
    
    public boolean Bloqu2Izq(){
        return game.bo1.collisionIzq().intersects(game.bo2.getBoundsWall());
    }
    public boolean Bloqu2Der(){
        return game.bo1.collisionDer().intersects(game.bo2.getBoundsWall());
    }
    public boolean Bloqu2Arr(){
        return game.bo1.collisionArr().intersects(game.bo2.getBoundsWall());
    } 
    public boolean Bloqu2Aba(){
        return game.bo1.collisionAba().intersects(game.bo2.getBoundsWall());
    }
    
}
