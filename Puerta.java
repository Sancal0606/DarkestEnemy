package Scripts;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import javax.swing.ImageIcon;

public class Puerta {
    Game game;
    boolean isOpen;
    int posX;
    int posY;
    int sizeX;
    int sizeY;
    int num;
    boolean light;
    Image sprite;
    Image sprite2;
    Image sprite1c;
    Image sprite2c;
    Image sprite3c;
    Image sprite4c;
    Image sprite1o;
    Image sprite2o;
    Image sprite3o;
    Image sprite4o;
    Image top1;
    Image top2;
    Image top3;
    Image top4;
    Image sprite3;
    Image actualSprite;
    Image actualTop;
    int orien;

    
    public Puerta(Game _game,int _posX, int _posY,int hab, int ori,boolean open){
        game = _game;
        posX = _posX;
        posY=_posY;
        num = hab;
        isOpen = open;
        orien = ori;
        sizeX=128;
        sizeY=128;
        ImageIcon f1c = new ImageIcon("src/Images/PuertaCerradaAba.png");
        ImageIcon f1o = new ImageIcon("src/Images/PuertaAbiertaAba.png");
        ImageIcon f2c = new ImageIcon("src/Images/PuertaCerradaIzq.png");
        ImageIcon f2o = new ImageIcon("src/Images/PuertaAbiertaIzq.png");
        
        ImageIcon f3c = new ImageIcon("src/Images/PuertaCerradaArr.png");
        ImageIcon f3o = new ImageIcon("src/Images/PuertaAbiertaArr.png");
        ImageIcon f4c = new ImageIcon("src/Images/PuertaCerradaDer.png");
        ImageIcon f4o = new ImageIcon("src/Images/PuertaAbiertaDer.png");
        
        ImageIcon t1 = new ImageIcon("src/Images/PuertaTechoAba.png");
        ImageIcon t2 = new ImageIcon("src/Images/PuertaTechoIzq.png");
        ImageIcon t3 = new ImageIcon("src/Images/PuertaTechoArr.png");
        ImageIcon t4 = new ImageIcon("src/Images/PuertaTechoDer.png");
        
        sprite1c = f1c.getImage();
        sprite1o = f1o.getImage();
        sprite2c = f2c.getImage();
        sprite2o = f2o.getImage();
        sprite3c = f3c.getImage();
        sprite3o = f3o.getImage();
        sprite4c = f4c.getImage();
        sprite4o = f4o.getImage();
        
        top1 = t1.getImage();
        top2 = t2.getImage();
        top3 = t3.getImage();
        top4 = t4.getImage();
        
        
        switch(ori){
            case 1:
                sprite = sprite1c;
                sprite2 = sprite1o;
                sprite3 = top1;
    
                break;
            case 2:
                sprite = sprite2c;
                sprite2 = sprite2o;
                sprite3 = top2;
                break;
            case 3:
                sprite = sprite3c;
                sprite2 = sprite3o;
                sprite3 = top3;
                break;
            case 4:
                sprite = sprite4c;
                sprite2 = sprite4o;
                sprite3 = top4;
                break;
        }
        
    }
    
    public void paintTop(Graphics2D g){
        switch (orien){
            case 1: 
                 g.drawImage(actualTop,posX+(-game.CamX), posY+(-game.CamY), null);
                 break;
            case 2: 
                 g.drawImage(actualTop,posX+(-game.CamX)+64, posY+(-game.CamY), null);
                 break;
            case 3:
                g.drawImage(actualTop,posX+(-game.CamX), posY+(-game.CamY)+64, null);
                break;
            case 4:
                g.drawImage(actualTop,posX+(-game.CamX), posY+(-game.CamY), null);
        }
       
    }
    
    private boolean collisionPlayer(){
        
        return game.p1.getBoundsPlayer2().intersects(getBoundsWall());
        
    }
    
     public void paintDoor(Graphics2D g){
        switch(orien){
            case 1:
                 g.drawImage(actualSprite,posX+(-game.CamX), posY+(-game.CamY)+64, null);
                g.setColor(Color.yellow);
                
                 
                break;
            case 2: 
                g.drawImage(actualSprite,posX+(-game.CamX), posY+(-game.CamY), null);
                break;
            case 3: 
                g.drawImage(actualSprite,posX+(-game.CamX), posY+(-game.CamY), null);
                break;
            case 4: 
                g.drawImage(actualSprite,posX+(-game.CamX)+64, posY+(-game.CamY), null);
                break;
        }
       
       if(collisionPlayer()==true&&game.p1.llaves>0&&game.p1.accion==true&&isOpen==false){
           isOpen=true;
           //game.p1.llaves--;
       }
    }
    
    public Rectangle getBoundsWall(){
        return new Rectangle(posX-game.CamX-50, posY-game.CamY-50, sizeX+100, sizeY+100);
    }
    public Rectangle getBoundsBlock(){
        return new Rectangle(posX-game.CamX, posY-game.CamY, sizeX, sizeY);
    }

    public void checkCollision(){
           
         if(collisionLight()&&game.p1.lightOn){
         light=true;
       }
       else{
           light=false;
       }
         if(light||game.lightsOnRooms[num]||collisionPlayer()){
             
             if(isOpen==false){
                actualSprite=sprite; 
      
               
            }  
            else if(isOpen==true){
                actualSprite=sprite2;
            }
            actualTop = sprite3;
         }
          else{
           actualSprite=null;
           actualTop = null;
           
       }

       if(isOpen==false){  
       
       if((game.p1.positionX+(game.p1.horzMove*game.p1.speed)+65>posX&&
               game.p1.positionX+(game.p1.horzMove*game.p1.speed)<posX+sizeY)&&
               (game.p1.positionY+(game.p1.vertMove*game.p1.speed)+116>posY)&&
               (game.p1.positionY+(game.p1.vertMove*game.p1.speed)<posY+sizeY-80)){
        
           if(game.p1.vertMove==game.p1.speed)
               game.p1.vertMove=0; 
           if(game.p1.horzMove==-game.p1.speed)
               game.p1.horzMove=0;
           if(game.p1.vertMove==-game.p1.speed) 
                game.p1.vertMove=0;
           if(game.p1.horzMove==game.p1.speed)
                game.p1.horzMove=0;
       }
       } 
     }
 
    public void enemyWall(){
      
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
        for (int i = 0; i < 2; i++) {
             
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
        for (int i = 0; i < 2; i++) {
             
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
        for (int i = 0; i < 2; i++) {
             
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
            if(game.mapa8.bloques[i].collisionIzq().intersects(getBoundsBlock())==true)
              game.mapa8.bloques[i].obstacleX=true;
            if(game.mapa8.bloques[i].collisionDer().intersects(getBoundsBlock())==true)
              game.mapa8.bloques[i].obstacleX=true;
            if(game.mapa8.bloques[i].collisionArr().intersects(getBoundsBlock())==true)
              game.mapa8.bloques[i].obstacleY=true;
            if(game.mapa8.bloques[i].collisionAba().intersects(getBoundsBlock())==true)
              game.mapa8.bloques[i].obstacleY=true;
        }
        bloqueHab09();
    } 
     
    public void bloqueHab09(){
        for (int i = 0; i < game.mapa9.bloques.length; i++) {
            if(game.mapa9.bloques[i].collisionIzq().intersects(getBoundsBlock())==true)
              game.mapa9.bloques[i].obstacleX=true;
            if(game.mapa9.bloques[i].collisionDer().intersects(getBoundsBlock())==true)
              game.mapa9.bloques[i].obstacleX=true;
            if(game.mapa9.bloques[i].collisionArr().intersects(getBoundsBlock())==true)
              game.mapa9.bloques[i].obstacleY=true;
            if(game.mapa9.bloques[i].collisionAba().intersects(getBoundsBlock())==true)
              game.mapa9.bloques[i].obstacleY=true;
        }
        bloqueHab10();
    }
    
    public void bloqueHab10(){
        for (int i = 0; i < game.mapa10.bloques.length; i++) {
            if(game.mapa10.bloques[i].collisionIzq().intersects(getBoundsBlock())==true)
              game.mapa10.bloques[i].obstacleX=true;
            if(game.mapa10.bloques[i].collisionDer().intersects(getBoundsBlock())==true)
              game.mapa10.bloques[i].obstacleX=true;
            if(game.mapa10.bloques[i].collisionArr().intersects(getBoundsBlock())==true)
              game.mapa10.bloques[i].obstacleY=true;
            if(game.mapa10.bloques[i].collisionAba().intersects(getBoundsBlock())==true)
              game.mapa10.bloques[i].obstacleY=true;
        }
    }
    
    private boolean collisionLight(){
        return game.p1.getBoundsLight().intersects(getBoundsWall());
    }
 
    
}
