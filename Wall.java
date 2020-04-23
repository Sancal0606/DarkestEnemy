package Scripts;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import javax.swing.ImageIcon;


public class Wall {
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
   
    
    public Wall(Game _game, int _posX,int _posY, int hab, int orient){
        posX=_posX;
        posY=_posY;
        sizeX=128;
        sizeY=128;
        game =_game;
        ImageIcon f1=   new ImageIcon("src/Images/ParedFrente.png");
        ImageIcon f2=   new ImageIcon("src/Images/ParedArrDer.png");
        ImageIcon f3=   new ImageIcon("src/Images/ParedDer.png");
        ImageIcon f4=   new ImageIcon("src/Images/ParedAbaDer.png");
        ImageIcon f5=   new ImageIcon("src/Images/ParedAtras.png");
        ImageIcon f6=   new ImageIcon("src/Images/ParedAbaIzq.png");
        ImageIcon f7=   new ImageIcon("src/Images/ParedIzq.png");
        ImageIcon f8=   new ImageIcon("src/Images/ParedArrIzq.png");
        sprite1 = f1.getImage();
        sprite2 = f2.getImage();
        sprite3 = f3.getImage();
        sprite4 = f4.getImage();
        sprite5 = f5.getImage();
        sprite6 = f6.getImage();
        sprite7 = f7.getImage();
        sprite8 = f8.getImage();
        switch (orient){
            case 1:
                sprite = sprite1;
                break;
            case 2:
                sprite = sprite2;
                break;
            case 3:
                sprite = sprite3;
                break;
            case 4:
                sprite = sprite4;
                break;
            case 5:
                sprite = sprite5;
                break;
            case 6:
                sprite = sprite6;
                break;
            case 7:
                sprite = sprite7;
                break;
            case 8:
                sprite = sprite8;
                break;  
        }
        actualSprite=null;
        num = hab;

    }
    public void paint(Graphics2D g){
       g.setColor(Color.blue);
        //System.out.println("B");
      
            g.drawImage(actualSprite,posX+(-game.CamX), posY+(-game.CamY), null);
          
       
      
    }
    
    public Rectangle getBoundsWall(){
        return new Rectangle(posX-game.CamX, posY-game.CamY, sizeX, sizeY);
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
           if(game.p1.horzMove==game.p1.speed){
                game.p1.horzMove=0;
           }
       } 

   
       //obstacle = false;        
         enemyWall();  
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
      

      
        if(game.mapa2.enemy.x+game.mapa2.enemy.xa+128>posX&&
               game.mapa2.enemy.x+game.mapa2.enemy.xa+6<posX+sizeX&&
               game.mapa2.enemy.y+game.mapa2.enemy.ya+108>posY&&
               game.mapa2.enemy.y+game.mapa2.enemy.ya+6<posY+sizeY){
            
            if(game.mapa2.enemy.xa>0){
               game.mapa2.enemy.xa=0; 
               game.mapa2.enemy.tryY=true;
           }
           if(game.mapa2.enemy.xa<0){
               game.mapa2.enemy.xa=0;
               game.mapa2.enemy.tryY=true;
           }
           if(game.mapa2.enemy.ya<0){
                game.mapa2.enemy.ya=0;    

           }
           if(game.mapa2.enemy.ya>0){
               game.mapa2.enemy.ya=0;

           }
            if(game.mapa2.enemy.y+game.mapa2.enemy.ya<posY-12+108&&game.mapa2.enemy.x+game.mapa2.enemy.xa+128>posX&&
               game.mapa2.enemy.x+game.enemy.xa+6<posX+sizeX ){
               game.mapa2.enemy.notYUp=true;
           }else
                game.mapa2.enemy.notYUp=false;
            if(game.mapa2.enemy.y+game.mapa2.enemy.ya+108>posY+12&&game.mapa2.enemy.x+game.mapa2.enemy.xa+128>posX&&
               game.mapa2.enemy.x+game.mapa2.enemy.xa+6<posX+sizeX)
                game.mapa2.enemy.notYDown=true;
            else
                game.mapa2.enemy.notYDown=false;
            
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
        
        enemyHab03();
    }
    
    public void enemyHab03(){
        for (int i = 0; i <  game.mapa3.enemies.length; i++) {
             
            if(game.mapa3.enemies[i].x+game.mapa3.enemies[i].xa+128>posX&&
                game.mapa3.enemies[i].x+game.mapa3.enemies[i].xa+6<posX+sizeX&&
                game.mapa3.enemies[i].y+game.mapa3.enemies[i].ya+108>posY&&
                game.mapa3.enemies[i].y+game.mapa3.enemies[i].ya+6<posY+sizeY){
          
                    if(game.mapa3.enemies[i].xa>0){
                        game.mapa3.enemies[i].x-=game.mapa3.enemies[i].speed; 
                        game.mapa3.enemies[i].tryY=true;
                    }
                    if(game.mapa3.enemies[i].xa<0){
                        game.mapa3.enemies[i].x+=game.mapa3.enemies[i].speed;
                        game.mapa3.enemies[i].tryY=true;
                    }
                    if(game.mapa3.enemies[i].ya<0){
                        game.mapa3.enemies[i].y+=game.mapa3.enemies[i].speed;    
                    }
                    if(game.mapa3.enemies[i].ya>0){
                        game.mapa3.enemies[i].y-=game.mapa3.enemies[i].speed;
                    }
           
                    if(game.mapa3.enemies[i].y+game.mapa3.enemies[i].ya<posY-12+128&&game.mapa3.enemies[i].x+game.mapa3.enemies[i].xa+128>posX&&
                        game.mapa3.enemies[i].x+game.mapa3.enemies[i].xa+6<posX+sizeX )
                    {
                            game.mapa3.enemies[i].notYUp=true;
                    }else
                        game.mapa3.enemies[i].notYUp=false;
                    if(game.mapa3.enemies[i].y+game.mapa3.enemies[i].ya+108>posY+12&&game.mapa3.enemies[i].x+game.mapa3.enemies[i].xa+128>posX&&
                        game.mapa3.enemies[i].x+game.mapa3.enemies[i].xa+6<posX+sizeX)
                            game.mapa3.enemies[i].notYDown=true;
                    else
                        game.mapa3.enemies[i].notYDown=false;
               
            }
        }
        enemyHab04();
    }
     public void enemyHab04(){
        for (int i = 0; i <  game.mapa4.enemies.length; i++) {
             
            if(game.mapa4.enemies[i].x+game.mapa4.enemies[i].xa+128>posX&&
                game.mapa4.enemies[i].x+game.mapa4.enemies[i].xa+6<posX+sizeX&&
                game.mapa4.enemies[i].y+game.mapa4.enemies[i].ya+108>posY&&
                game.mapa4.enemies[i].y+game.mapa4.enemies[i].ya+6<posY+sizeY){
          
                    if(game.mapa4.enemies[i].xa>0){
                        game.mapa4.enemies[i].x-=game.mapa4.enemies[i].speed; 
                        game.mapa4.enemies[i].tryY=true;
                    }
                    if(game.mapa4.enemies[i].xa<0){
                        game.mapa4.enemies[i].x+=game.mapa4.enemies[i].speed;
                        game.mapa4.enemies[i].tryY=true;
                    }
                    if(game.mapa4.enemies[i].ya<0){
                        game.mapa4.enemies[i].y+=game.mapa4.enemies[i].speed;    
                    }
                    if(game.mapa4.enemies[i].ya>0){
                        game.mapa4.enemies[i].y-=game.mapa4.enemies[i].speed;
                    }
           
                    if(game.mapa4.enemies[i].y+game.mapa4.enemies[i].ya<posY-12+128&&game.mapa4.enemies[i].x+game.mapa4.enemies[i].xa+128>posX&&
                        game.mapa4.enemies[i].x+game.mapa4.enemies[i].xa+6<posX+sizeX )
                    {
                            game.mapa4.enemies[i].notYUp=true;
                    }else
                        game.mapa4.enemies[i].notYUp=false;
                    if(game.mapa4.enemies[i].y+game.mapa4.enemies[i].ya+108>posY+12&&game.mapa4.enemies[i].x+game.mapa4.enemies[i].xa+128>posX&&
                        game.mapa4.enemies[i].x+game.mapa4.enemies[i].xa+6<posX+sizeX)
                            game.mapa4.enemies[i].notYDown=true;
                    else
                        game.mapa4.enemies[i].notYDown=false;
               
            }
        }
        enemyHab06();
    }
    
     public void enemyHab06(){
        for (int i = 0; i <  game.mapa6.enemies.length; i++) {
             
            if(game.mapa6.enemies[i].x+game.mapa6.enemies[i].xa+128>posX&&
                game.mapa6.enemies[i].x+game.mapa6.enemies[i].xa+6<posX+sizeX&&
                game.mapa6.enemies[i].y+game.mapa6.enemies[i].ya+108>posY&&
                game.mapa6.enemies[i].y+game.mapa6.enemies[i].ya+6<posY+sizeY){
          
                    if(game.mapa6.enemies[i].xa>0){
                        game.mapa6.enemies[i].x-=game.mapa6.enemies[i].speed; 
                        game.mapa6.enemies[i].tryY=true;
                    }
                    if(game.mapa6.enemies[i].xa<0){
                        game.mapa6.enemies[i].x+=game.mapa6.enemies[i].speed;
                        game.mapa6.enemies[i].tryY=true;
                    }
                    if(game.mapa6.enemies[i].ya<0){
                        game.mapa6.enemies[i].y+=game.mapa6.enemies[i].speed;    
                    }
                    if(game.mapa6.enemies[i].ya>0){
                        game.mapa6.enemies[i].y-=game.mapa6.enemies[i].speed;
                    }
           
                    if(game.mapa6.enemies[i].y+game.mapa6.enemies[i].ya<posY-12+128&&game.mapa6.enemies[i].x+game.mapa6.enemies[i].xa+128>posX&&
                        game.mapa6.enemies[i].x+game.mapa6.enemies[i].xa+6<posX+sizeX )
                    {
                            game.mapa6.enemies[i].notYUp=true;
                    }else
                        game.mapa6.enemies[i].notYUp=false;
                    if(game.mapa6.enemies[i].y+game.mapa6.enemies[i].ya+108>posY+12&&game.mapa6.enemies[i].x+game.mapa6.enemies[i].xa+128>posX&&
                        game.mapa6.enemies[i].x+game.mapa6.enemies[i].xa+6<posX+sizeX)
                            game.mapa6.enemies[i].notYDown=true;
                    else
                        game.mapa6.enemies[i].notYDown=false;
               
            }
        }
        
        enemyHab07();
    }  
     public void enemyHab07(){
          for (int i = 0; i < game.mapa7.enemies.length; i++) {
             
            if(game.mapa7.enemies[i].x+game.mapa7.enemies[i].xa+128>posX&&
                game.mapa7.enemies[i].x+game.mapa7.enemies[i].xa+6<posX+sizeX&&
                game.mapa7.enemies[i].y+game.mapa7.enemies[i].ya+108>posY&&
                game.mapa7.enemies[i].y+game.mapa7.enemies[i].ya+6<posY+sizeY){
          
                    if(game.mapa7.enemies[i].xa>0){
                        game.mapa7.enemies[i].x-=game.mapa7.enemies[i].speed; 
                        game.mapa7.enemies[i].tryY=true;
                    }
                    if(game.mapa7.enemies[i].xa<0){
                        game.mapa7.enemies[i].x+=game.mapa7.enemies[i].speed;
                        game.mapa7.enemies[i].tryY=true;
                    }
                    if(game.mapa7.enemies[i].ya<0){
                        game.mapa7.enemies[i].y+=game.mapa7.enemies[i].speed;    
                    }
                    if(game.mapa7.enemies[i].ya>0){
                        game.mapa7.enemies[i].y-=game.mapa7.enemies[i].speed;
                    }
           
                    if(game.mapa7.enemies[i].y+game.mapa7.enemies[i].ya<posY-12+128&&game.mapa7.enemies[i].x+game.mapa7.enemies[i].xa+128>posX&&
                        game.mapa7.enemies[i].x+game.mapa7.enemies[i].xa+6<posX+sizeX )
                    {
                            game.mapa7.enemies[i].notYUp=true;
                    }else
                        game.mapa7.enemies[i].notYUp=false;
                    if(game.mapa7.enemies[i].y+game.mapa7.enemies[i].ya+108>posY+12&&game.mapa7.enemies[i].x+game.mapa7.enemies[i].xa+128>posX&&
                        game.mapa7.enemies[i].x+game.mapa7.enemies[i].xa+6<posX+sizeX)
                            game.mapa7.enemies[i].notYDown=true;
                    else
                        game.mapa7.enemies[i].notYDown=false;
               
            }
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
     
    public void collBloque(){
        if(Bloqu2Izq()==true)
              game.bo2.obstacleX=true;
          if(Bloqu2Der()==true)
              game.bo2.obstacleX=true;
          if(Bloqu2Arr()==true)
              game.bo2.obstacleY=true;
          if(Bloqu2Aba()==true)
              game.bo2.obstacleY=true;
          
          if(Bloqu1Izq()==true)
              game.bo1.obstacleX=true;
          if(Bloqu1Der()==true)
              game.bo1.obstacleX=true;
          if(Bloqu1Arr()==true)
              game.bo1.obstacleY=true;
          if(Bloqu1Aba()==true)
              game.bo1.obstacleY=true;
          
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
    
    public boolean Bloqu2Izq(){
        return game.bo2.collisionIzq().intersects(getBoundsWall());
    }
    public boolean Bloqu2Der(){
        return game.bo2.collisionDer().intersects(getBoundsWall());
    }
    public boolean Bloqu2Arr(){
        return game.bo2.collisionArr().intersects(getBoundsWall());
    } 
    public boolean Bloqu2Aba(){
        return game.bo2.collisionAba().intersects(getBoundsWall());
    }
     
    public boolean Bloqu1Izq(){
        return game.bo1.collisionIzq().intersects(getBoundsWall());
    }
    public boolean Bloqu1Der(){
        return game.bo1.collisionDer().intersects(getBoundsWall());
    }
    public boolean Bloqu1Arr(){
        return game.bo1.collisionArr().intersects(getBoundsWall());
    } 
    public boolean Bloqu1Aba(){
        return game.bo1.collisionAba().intersects(getBoundsWall());
    }
    
    private boolean collisionLight(){
        return game.p1.getBoundsLight().intersects(getBoundsWall());
    }
   
    
}
