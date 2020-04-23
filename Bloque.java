/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Scripts;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import javax.swing.ImageIcon;

/**
 *
 * @author carlo
 */
public class Bloque {
    Game game;
    
    int posX;
    int posY;
    int sizeX;
    int sizeY;
    boolean light;
    Color color;
    Image sprite1;
    Image actualSprite;
    int num;
    int orient;
    int xa;
    int ya;
    boolean canMove;
    boolean moveHorz;
    boolean moveVert;
    
     public Bloque(Game _game, int _posX,int _posY, int hab){
        posX=_posX;
        posY=_posY;
        sizeX=128;
        sizeY=128;
        game =_game;
        ImageIcon f1=   new ImageIcon("src/Images/ParedFrente.png");
        sprite1 = f1.getImage();
        color = Color.white;
        actualSprite=null;
        num = hab;
        moveHorz=true;
        moveVert=true;

    }
    
    public void paint(Graphics2D g){
       game.wall1.block();
        game.wall2.block();
        game.wall3.block();
        game.wallLado1.block();
        posX+=xa;
        posY+=ya;
        g.setColor(Color.blue);
        //System.out.println("B");
        g.fillRect(posX+(-game.CamX), posY+(-game.CamY), 128, 128);
    //g.drawImage(actualSprite,posX+(-game.CamX), posY+(-game.CamY), null);

          
       
      
    }
    
    public Rectangle getBoundsWall(){
        return new Rectangle(posX-game.CamX, posY-game.CamY, sizeX, sizeY);
    }
    
    public Rectangle Der(){
        return new Rectangle(posX-game.CamX+128, posY-game.CamY, 1, sizeY);
    }
    public Rectangle Izq(){
        return new Rectangle(posX-game.CamX+1, posY-game.CamY, 1, sizeY);
    }
    public Rectangle Up(){
        return new Rectangle(posX-game.CamX, posY-game.CamY+1, sizeX, 1);
    }public Rectangle Down(){
        return new Rectangle(posX-game.CamX, posY-game.CamY+128, sizeX, 1);
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
             actualSprite=sprite1;
         }
          else{
           //color = Color.black;
           actualSprite=null;
       }
         xa=0;
         ya=0;

        if((game.p1.positionX+(game.p1.horzMove*game.p1.speed)+65>posX&&
               game.p1.positionX+(game.p1.horzMove*game.p1.speed)<posX+sizeX)&&
               (game.p1.positionY+(game.p1.vertMove*game.p1.speed)+116>posY)&&
               (game.p1.positionY+(game.p1.vertMove*game.p1.speed)<posY+sizeY-80)){
 
           if(game.p1.vertMove==game.p1.speed){
                if(canMove==false)
                    game.p1.vertMove=0; 
                else if(canMove==true)
                    ya+=game.p1.speed;
               
           }
           if(game.p1.horzMove==-game.p1.speed){
              if(canMove==false) 
                game.p1.horzMove=0;
              else if(canMove==true)
                    xa-=game.p1.speed;  
                
           }
           if(game.p1.vertMove==-game.p1.speed) {
               if(canMove==false)
                    game.p1.vertMove=0; 
                else if(canMove==true)
                    ya-=game.p1.speed;
           }
           if(game.p1.horzMove==game.p1.speed){
                if(canMove==false) 
                game.p1.horzMove=0;
              else if(canMove==true)
                    xa+=game.p1.speed; 
           }
       } 

        
       canMove = true;        
        CollBloque();
       enemyWall();  
       
     }
 
    public void enemyWall(){
      

       
        if(game.enemy.x+game.enemy.xa+128>posX&&
               game.enemy.x+game.enemy.xa+6<posX+sizeX&&
               game.enemy.y+game.enemy.ya+108>posY&&
               game.enemy.y+game.enemy.ya+6<posY+sizeY){
            canMove=false;
            if(game.enemy.xa>0){
               game.enemy.xa=0; 
               game.enemy.x-=game.enemy.speed;
               game.enemy.tryY=true;
           }
           if(game.enemy.xa<0){
               game.enemy.xa=0;
               game.enemy.tryY=true;
               game.enemy.x+=game.enemy.speed;
           }
           if(game.enemy.ya<0){
                game.enemy.ya=0;    
                game.enemy.y+=game.enemy.speed;
           }
           if(game.enemy.ya>0){
               game.enemy.ya=0;
               game.enemy.y-=game.enemy.speed;

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
          canMove=false;
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
    }
    
    public void CollBloque(){
        if(this==game.b1){
            if((game.b1.posX+(game.b1.xa*game.p1.speed)+128>game.b2.posX&&
               game.b1.posX+(game.b1.xa*game.p1.speed)<game.b2.posX+sizeX)&
               (game.b1.posY+(game.b1.ya*game.p1.speed)+128>game.b2.posY)&&
               (game.b1.posY+(game.b1.ya*game.p1.speed)<game.b2.posY+sizeY)){
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
           if(game.b2.getBoundsWall().intersects(game.b1.Der())){
               game.b1.posX-=game.p1.speed;
           }
           if(game.b2.getBoundsWall().intersects(game.b1.Izq())){
               game.b1.posX+=game.p1.speed;
           }
           if(game.b2.getBoundsWall().intersects(game.b1.Up())){
               //game.b1.posY-=game.p1.speed;
           }
           if(game.b2.getBoundsWall().intersects(game.b1.Down())){
               //game.b1.posY+=game.p1.speed;
           }
        }
        if(this==game.b2){
            if((game.b2.posX+(game.b1.xa*game.p1.speed)+128>game.b1.posX&&
               game.b2.posX+(game.b1.xa*game.p1.speed)<game.b1.posX+sizeX)&
               (game.b2.posY+(game.b1.ya*game.p1.speed)+128>game.b1.posY)&&
               (game.b2.posY+(game.b1.ya*game.p1.speed)<game.b1.posY+sizeY)){
                    game.b2.xa=0;
                    game.b2.ya=0;
                    game.b2.canMove=false;
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
            if(game.b1.getBoundsWall().intersects(game.b2.Der())){
               game.b2.posX-=game.p1.speed+2;
           }
           if(game.b1.getBoundsWall().intersects(game.b2.Izq())){
               game.b2.posX+=game.p1.speed+2;
           }
           if(game.b1.getBoundsWall().intersects(game.b2.Up())){
               game.b2.posY-=game.p1.speed+2;
           }
           if(game.b1.getBoundsWall().intersects(game.b2.Down())){
               game.b2.posY+=game.p1.speed+2;
           }
            
        }
       
    }
    
    private boolean collisionLight(){
        return game.p1.getBoundsLight().intersects(getBoundsWall());
    }
}
