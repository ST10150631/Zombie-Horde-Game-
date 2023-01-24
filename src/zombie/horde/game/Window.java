/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package zombie.horde.game;

import java.awt.Dimension;
import javax.swing.JFrame;

/**
 *
 * @author Mike Turner
 */
public class Window {

    public Window (int Width, int Height, String title, Game game){
        //construct
        
        JFrame frame = new JFrame(title);
        
        frame .setPreferredSize(new Dimension(Width,Height));
        frame.setMaximumSize(new Dimension(Width,Height));
        frame.setMinimumSize(new Dimension(Width,Height));
        
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.add(game);
        frame.setVisible(true);
    }
    
    
}
