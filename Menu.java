
package Scripts;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import javax.swing.ImageIcon;

public class Menu {
    Game game;
    
   
    
    Menu(Game _game){
        game = _game;
    }
    public Rectangle playButton = new Rectangle(650,340,150,50);
    public Rectangle helpButton = new Rectangle(650,400,220,50);
    public Rectangle quitButton = new Rectangle(650,470,150,50); 
    
    public Image menu;
    
    
    public void paint(Graphics g){
        Graphics2D g2d = (Graphics2D)g;
        ImageIcon i= new ImageIcon("src/Images/Menu.png");
        menu = i.getImage();
        Font font = new Font("arial", Font.BOLD,50);
        Font font2 = new Font("arial", Font.BOLD,30);
        g.setFont(font);
        g.setColor(Color.white);
        g2d.drawImage(menu, 0, 0, null);

        g.setFont(font2);

        g2d.draw(playButton);
        g2d.draw(helpButton);
        g2d.draw(quitButton);
        
    }
}
