package Scripts;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Game extends JPanel {

    Player p1 = new Player(this,16,-250);
    Bateria bateria = new Bateria(this);
    
    public static int tiempo=20;
    
    Floor floor01[][]=new Floor[5][10];
    
    Wall wall1 = new Wall(this,128,384,0,1); 
   Wall wall2= new Wall(this,256,384,0,1); 
    Wall wall3 = new Wall(this,384,384,0,1);
    Wall wallLado1 = new Wall(this,-128,0,0,7);
    
    Bloque2 bo2 = new Bloque2(this,640,384,0);
    Bloque2 bo1 = new Bloque2(this,768,384,0);

    Bloque b1 = new Bloque(this,640,381,0);
     Bloque b2 = new Bloque(this,640,525,0);
    
    Puerta puerta1 = new Puerta(this,0,-128,0,3,false);
   Interruptor int1 = new Interruptor(this,432,419,8);
    
    Pilas pila = new Pilas(this,256,0,0);
    Mapa m = new Mapa(this,512,0,0);
    Llave llave = new Llave(this,384,0,0);
    
    Enemy enemy = new Enemy (this,256,512,0);
    Enemy enemy2 = new Enemy(this,640,0,0);
    
    Trampa trampa = new Trampa(this,128,256,0);
    Trampa trampa2 = new Trampa(this,768,128,0);
    
    private Menu menu = new Menu(this);
    private Pause pause = new Pause(this);
    
   boolean lightsOnRooms[]= new boolean[11];
    
    int CamX=-624;
    int CamY=-600;
   

    Hab01 mapa  = new Hab01(this);
    Hab02 mapa2  = new Hab02(this);
    Hab03 mapa3 = new Hab03(this);
    Hab04 mapa4 = new Hab04(this);
    Hab05 mapa5 = new Hab05(this);
    Hab06 mapa6 = new Hab06(this);
    Hab07 mapa7 = new Hab07(this); 
    Hab08 mapa8 = new Hab08(this);
    Hab09 mapa9 = new Hab09(this);
    Hab10 mapa10 = new Hab10(this);
    Hab11 mapa11 = new Hab11(this);
    
    public boolean isGameOver=false;
    
    public  static enum State{
        Menu, Game, Pause
    };
   
    public  static State state = State.Menu;
    
    public int getTiempo(){
        return tiempo;
    }
    
    public Game(){
        
        this.addMouseListener(new Mouse(this));
    
        isGameOver=false;
        addKeyListener(new KeyListener() {
           @Override
           public void keyTyped(KeyEvent e){
           }
           @Override
           public void keyReleased(KeyEvent e){
               p1.keyReleased(e);
           }
           @Override
           public void keyPressed(KeyEvent e){
               p1.keyPressed(e);
           }
        });
        setFocusable(true);
    
    }
    
    int a=1;
    @Override
    public void paint(Graphics g){
       
        super.paint(g);
        Graphics2D g2d = (Graphics2D) g;
	g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
            RenderingHints.VALUE_ANTIALIAS_ON);
	
        if(state == State.Game||state == State.Pause){
            g2d.setColor(Color.white);
            for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 10; j++) {
                floor01[i][j]= new Floor(this,j*128,i*128,0);
                floor01[i][j].paint(g2d);
            }
            
            
            }
      mapa.paint(g);
      mapa2.paint(g);
      mapa3.paint(g);
      mapa4.paint(g);
      mapa5.paint(g);
      mapa6.paint(g);
      mapa7.paint(g);
      mapa8.paint(g);
      mapa9.paint(g);
      mapa10.paint(g);
      mapa11.paint(g);
        wall1.paint(g2d);
        wall2.paint(g2d);
        wall3.paint(g2d);
        wallLado1.paint(g2d);
      
        
        bo2.paint(g2d);
        bo1.paint(g2d);
        //b1.paint(g2d);
        //b2.paint(g2d);
        int1.paint(g2d);
       //lightsOnRooms[0]=true;
       puerta1.paintDoor(g2d);
        trampa.paint(g2d);
        trampa2.paint(g2d);
        enemy.paint(g2d);
        enemy2.paint(g2d); 
        pila.paint(g2d);
        m.paint(g2d);
        llave.paint(g2d);
        bateria.paint(g2d);
        p1.paint(g2d);
        puerta1.paintTop(g2d);
    }
        else if(state == State.Menu){
            menu.paint(g);
        }
        if(state == State.Pause){
            pause.paint(g);

        }
    }
    float waitGameOver=5;
    
   
    
    public void gameOver(){
        
       if(state == State.Game){
        if(isGameOver){
            
            p1.canMove=false;
             waitGameOver-=0.02;
            if(waitGameOver<=0){
                CamX=-624;
                CamY=-600; 
                p1.gameOver();
                bateria.gameOver();
                pila.gameOver();
                waitGameOver=5;
                enemy.gameOver();
                enemy2.gameOver();
                isGameOver=false;
                trampa.gameOver();
                trampa2.gameOver();
                int1.gameOver();
                llave.gameover();
                bo1.gameOver();
                bo2.gameOver();
                mapa2.gameOver();
                mapa3.gameOver();
                mapa4.gameOver();
                mapa6.gameOver();
                mapa7.gameOver();
                mapa8.gameOver();
                mapa9.gameOver();
                mapa10.gameOver();
            }
        }
       }
    }
    
    private void move(){
        if(state == State.Game){
        p1.move();
        bateria.countdown();
     
        gameOver();
        }
    }
        
    
    void checkCollision(){
      if(state == State.Game){
       wall1.checkCollision();
       wall2.checkCollision();
       wall3.checkCollision();
       wallLado1.checkCollision();
       mapa.checkCollision();
       mapa2.checkCollision();
       mapa3.checkCollision();
       mapa4.checkCollision();
      mapa5.checkCollision();
      mapa6.checkCollision();
      mapa7.checkCollision();
      mapa8.checkCollision();
      mapa9.checkCollision();
      mapa10.checkCollision();
      mapa11.checkCollision();
       puerta1.checkCollision();
       //b1.checkCollision();
       //b2.checkCollision();
       bo2.checkCollision();
       bo1.checkCollision();
      }
    }
    
    
    public void checkWallCollision(){
        if(state == State.Game){
        wall1.enemyWall();
        wall2.enemyWall();
        wall3.enemyWall();
        wallLado1.enemyWall();
        mapa.checkWallCollision();
        mapa2.checkWallCollision();
        mapa3.checkWallCollision();
        mapa4.checkWallCollision();
        mapa6.checkWallCollision();
        mapa7.checkWallCollision();
        mapa8.checkWallCollision();
        mapa9.checkWallCollision();
        mapa10.checkWallCollision();
        puerta1.enemyWall();
  
        //b1.enemyWall();
        //b2.enemyWall();
        bo2.enemyWall();
        bo1.enemyWall();
        }
    }

   public void CollisionBlock(){
       wall1.collBloque(); 
       wall2.collBloque(); 
       wall3.collBloque(); 
       wallLado1.collBloque(); 
       enemy2.collBloque();
       enemy.collBloque();
       bo1.collBloque();
       bo2.collBloque();
       puerta1.collBloque();
       mapa8.collisionBlock();
       mapa9.collisionBlock();
       mapa10.collisionBlock();
   }
  
    
    public static void main(String[] args) throws InterruptedException {
        JFrame frame = new JFrame("Game");
        Game game = new Game();
        frame.add(game);
        frame.setSize(1286,669);
        //frame.setResizable(false);
        game.setBackground(Color.black);
            frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        while(true){
            game.repaint();
            game.move();
            Thread.sleep(20);
            
        }
    }
}