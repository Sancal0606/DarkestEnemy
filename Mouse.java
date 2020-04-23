/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Scripts;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 *
 * @author carlo
 */
public class Mouse implements MouseListener{

    Game game;
    
    Mouse (Game _game){
        game = _game;
    }
    @Override
    public void mouseClicked(MouseEvent me) {
       
    }

    @Override
    public void mousePressed(MouseEvent e) {
        
        //public Rectangle playButton = new Rectangle(30+120,150,100,50);
        //public Rectangle helpButton = new Rectangle(30+120,250,100,50);
        //public Rectangle quitButton = new Rectangle(30+120,350,100,50); 
        
        int mx = e.getX();
        int my = e.getY();
        if(Game.state==Game.State.Menu){
        if(mx >= 650&&mx<=650+150){
            if(my>=340&&my<=390){
                Game.state=Game.State.Game;
                
            }
        }
        if(mx >= 650&&mx<=650+150){
            if(my>=470&&my<=520){
                System.exit(1);
                
                
            }
        }
        }
        if(Game.state==Game.State.Pause){
        if(mx >= 593&&mx<=593+100){
            if(my>=150&&my<=200){
                Game.state=Game.State.Game;
                
            }
        }
        if(mx >= 593&&mx<=593+100){
            if(my>=250&&my<=300){
                Game.state=Game.State.Menu;
            }
        }
        
        if(mx >= 593&&mx<=593+100){
            if(my>=350&&my<=400){
                System.exit(1);
                
                
            }
        }
        }
    }

    @Override
    public void mouseReleased(MouseEvent me) {
       
    }

    @Override
    public void mouseEntered(MouseEvent me) {
       
    }

    @Override
    public void mouseExited(MouseEvent me) {
        
    }
    
}
