package Scripts;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import javax.swing.ImageIcon;

public class Enemy {
    Game game;
    int x;
    int y;
    int xa=0;
    int ya =0;
    int speed;
    int inicialX=800;
    int inicialY=600;
    int rangeX=300;
    int rangeY=300;
    String state;
    public Color color;
    public boolean isActive;
    public boolean seen;
    public boolean collisionX=false;
    public boolean collisionY=false;
    boolean light;
    
    Image front1;
    Image back1;
    Image right1;
    Image left1;
    Image front2;
    Image back2;
    Image right2;
    Image left2;
    Image currentImage;
    Image hide;
    
    boolean facingRight;
    boolean facingLeft;
    boolean facingBack;
    boolean facingFront=true;
    boolean isWalking;
    int num;
    
    public Enemy(Game _game, int _x, int _y,int hab){
        game = _game;
        state = "idle";
        speed=1;
        color = Color.black;
        isActive = true;
        seen=false;
        x=_x;
        y=_y;
        inicialX = x;
        inicialY = y;
        num = hab;
        
        ImageIcon f1 = new ImageIcon("src/Images/EnemyFront01.png");
        ImageIcon f2 = new ImageIcon("src/Images/EnemyFront02.png");
        ImageIcon b1 = new ImageIcon("src/Images/EnemyBack01.png");
        ImageIcon b2 = new ImageIcon("src/Images/EnemyBack02.png");
        ImageIcon l1 = new ImageIcon("src/Images/EnemyIzq01.png");
        ImageIcon l2 = new ImageIcon("src/Images/EnemyIzq02.png");
        ImageIcon r1 = new ImageIcon("src/Images/EnemyDer01.png");
        ImageIcon r2 = new ImageIcon("src/Images/EnemyDer02.png");
        ImageIcon h = new ImageIcon("src/Images/EnemyHide.png");
        
        front1= f1.getImage();
        back1 = b1.getImage();
        left1 = l1.getImage();
        right1 = r1.getImage();
        front2= f2.getImage();
        back2 = b2.getImage();
        left2 = l2.getImage();
        right2 = r2.getImage();
        hide = h.getImage();
        currentImage = null;
    }
    
    
    double wait3=1;
    boolean waitTres=false;
    public void paint (Graphics2D g){
        
        g.setColor(color);
        //g.fillRect(x-game.CamX, y-game.CamY, 128, 128);
        state();
        if(collisionLight()&&game.p1.lightOn){
         light=true;
       }
       else{
           light=false;
       }
       
        if(light||game.lightsOnRooms[num]==true){
            waitTres=true;
            color = Color.pink;
            anim();
            
        }
        if(wait3<0){
            seen=true;
        }
        if(waitTres)
            wait3-=0.02;
        
       g.drawImage(currentImage, x-game.CamX, y-game.CamY, null);
     
    }
    
    void state(){
        
        
       if(isActive){
        
        if(game.p1.lightOn&&seen||game.lightsOnRooms[num]==true&&game.p1.room==(num+1)){
           state="chase";
           chase();
           color=Color.pink;
           anim();
        }
        if(seen&&game.p1.lightOn==false&&game.lightsOnRooms[num]==false){
            color=Color.blue;
            currentImage = hide;
        }
       }
        attack();
        
    }

    boolean tryY=false;
    boolean notYUp=false;
     boolean notYDown=false;
    
    void chase(){
        if(isActive) {
            if(Game.state == Game.State.Game){
            
            if(game.p1.positionX-20-x<0&&tryY==false){
                xa=-speed;
            }
            if(game.p1.positionX-20-x>0&&tryY==false)
                xa=speed;
            if(game.p1.positionX-20-x==0)
                xa=0;
            if(collisionX==true)
                xa=0;
     
            if(game.p1.positionX-20==x||tryY==true){
                if(game.p1.positionY-y<0){
                    ya=-speed;
                    if(tryY==true&&notYDown==false)
                        ya-=2;
                }
                    
                if(game.p1.positionY-y>0){
                    ya=speed;
                    if(tryY==true&&notYUp==false)
                        ya+=2;
                }
                if(game.p1.positionY-y==0)
                    ya=0;
               
            } 
            if(game.p1.positionX-20!=x&&tryY==false)
                ya=0;
              
            tryY=false;    
           
            game.checkWallCollision();
           if(xa<0){
                
                facingRight=false;
                facingLeft=true;
                facingBack=false;
                facingFront=false;
           }
           if(xa>0){
                facingRight=true;
                facingLeft=false;
                facingBack=false;
                facingFront=false;
           }
           if(ya<0){
                facingRight=false;
                facingLeft=false;
                facingBack=true;
                facingFront=false;
           }
           if(ya>0){
                facingRight=false;
                facingLeft=false;
                facingBack=false;
                facingFront=true;
           }
            x+=xa;  
             y+=ya; 
            
        }  
        }
    }      
        
    void attack(){
        if(isActive){
        if(collisionPlayer()){
            isActive=false;
            game.isGameOver=true;
            currentImage = front1;
        }
    }
    }
    private boolean collisionPlayer(){
        
        return game.p1.getBoundsPlayer().intersects(getBoundsPlayer());
        
    }
    
     private boolean collisionLight(){
        
        return game.p1.getBoundsLight().intersects(getBoundsLight());
        
    }
    
    public void gameOver(){
        x = inicialX;
        y = inicialY;
        isActive=true;
        color = Color.black;
        wait3=1;
        currentImage = null;
        waitTres=false;
        seen=false;
        facingFront=true;
        facingBack=false;
        facingLeft=false;
        facingRight=false;
    }
    double seg=0;
    int a =0;
    public void anim(){
       if(isActive){
           if(Game.state == Game.State.Game){
        if(facingLeft){
            if(seg<=0){
                    if(a==0){
                        currentImage=left2;
                        a=1;
                    }
                    else if(a==1){
                        currentImage=left1;
                        a=0;
                    }
                    seg=1;
                    
                }
                seg-=0.02;
        }
        if(facingRight){
            if(seg<=0){
                    if(a==0){
                        currentImage=right2;
                        a=1;
                    }
                    else if(a==1){
                        currentImage=right1;
                        a=0;
                    }
                    seg=1;
                    
                }
                seg-=0.02;
        }
        if(facingBack){
             if(seg<=0){
                    if(a==0){
                        currentImage=back2;
                        a=1;
                    }
                    else if(a==1){
                        currentImage=back1;
                        a=0;
                    }
                    seg=1;
                    
                }
                seg-=0.02;
        }
        if(facingFront){
             if(seg<=0){
                    if(a==0){
                        currentImage=front2;
                        a=1;
                    }
                    else if(a==1){
                        currentImage=front1;
                        a=0;
                    }
                    seg=1;
                    
                }
                seg-=0.02;
        }
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
            if(game.mapa8.bloques[i].collisionIzq().intersects(getBoundsBlock())==true)
              game.mapa8.bloques[i].obstacleX=true;
            if(game.mapa8.bloques[i].collisionDer().intersects(getBoundsBlock())==true)
              game.mapa8.bloques[i].obstacleX=true;
            if(game.mapa8.bloques[i].collisionArr().intersects(getBoundsBlock())==true)
              game.mapa8.bloques[i].obstacleY=true;
            if(game.mapa8.bloques[i].collisionAba().intersects(getBoundsBlock())==true)
              game.mapa8.bloques[i].obstacleY=true;
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
     
     public boolean Bloqu2Izq(){
        return game.bo2.collisionIzq().intersects(getBoundsBlock());
    }
    public boolean Bloqu2Der(){
        return game.bo2.collisionDer().intersects(getBoundsBlock());
    }
    public boolean Bloqu2Arr(){
        return game.bo2.collisionArr().intersects(getBoundsBlock());
    } 
    public boolean Bloqu2Aba(){
        return game.bo2.collisionAba().intersects(getBoundsBlock());
    }
    
     public boolean Bloqu1Izq(){
        return game.bo1.collisionIzq().intersects(getBoundsBlock());
    }
    public boolean Bloqu1Der(){
        return game.bo1.collisionDer().intersects(getBoundsBlock());
    }
    public boolean Bloqu1Arr(){
        return game.bo1.collisionArr().intersects(getBoundsBlock());
    } 
    public boolean Bloqu1Aba(){
        return game.bo1.collisionAba().intersects(getBoundsBlock());
    }
     
     
    public Rectangle getBounds(){
        return new Rectangle(x+(-game.CamX)+24, y+(-game.CamY)+24, 80, 108);
    }
    
    public Rectangle getBoundsPlayer(){
        return new Rectangle(x+(-game.CamX)+12, y+(-game.CamY)+24, 100, 60);
    }
    
    public Rectangle getBoundsLight(){
        return new Rectangle(x+(-game.CamX)-6, y+(-game.CamY), 140, 128+16);
    }
    public Rectangle getBoundsBlock(){
        return new Rectangle(x+(-game.CamX), y+(-game.CamY), 128, 128);
    }
    
}
