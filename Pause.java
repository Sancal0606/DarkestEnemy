package Scripts;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

public class Pause {
    Game game;
    
    private AlphaComposite creaComposite( float alfa ) {
    int tipo = AlphaComposite.SRC_OVER;

    return( AlphaComposite.getInstance(tipo,alfa) );
    }
    
    Pause(Game _game){
        game = _game;
    }
    public Rectangle playButton = new Rectangle(593,150,100,50);
    public Rectangle MenuButton = new Rectangle(593,250,100,50);
    public Rectangle quitButton = new Rectangle(593,350,100,50); 
    
    public void paint(Graphics g){
       
         Graphics2D g2d = (Graphics2D)g;
        g2d.setComposite(creaComposite(0.8f));
        g2d.setColor(Color.black);
        g2d.fillRect(0,0,1286,669);
        g2d.setComposite(creaComposite(1f));
        Font font = new Font("arial", Font.BOLD,50);
        Font font2 = new Font("arial", Font.BOLD,20);
        g2d.setFont(font);
        g2d.setColor(Color.white);
        g2d.drawString("Pausa", game.getWidth()/2-100, 100);
        g2d.setFont(font2);
        g2d.drawString("Continar", playButton.x+19, playButton.y+30);
        g2d.drawString("Menu", MenuButton.x+19, MenuButton.y+30);
        g2d.drawString("Quit", quitButton.x+19, quitButton.y+30);
        g2d.draw(playButton);
        g2d.draw(MenuButton);
        g2d.draw(quitButton);
       
       
    }
    
}
