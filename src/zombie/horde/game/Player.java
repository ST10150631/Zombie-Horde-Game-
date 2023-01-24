/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package zombie.horde.game;

import java.awt.Color;
import java.awt.Graphics;

/**
 *
 * @author Mike Turner
 */
public class Player extends GameObject{

    public Player(float x, float y, ID id) {
        super(x, y, id);
        
        VelX = 50;
    }

    @Override
    public void tick() {
        x += VelX;
        y += VelY;
        
        if (x > Game.WIDTH) x = 0;
    }

    @Override
    public void render(Graphics g) {
        g.setColor(Color.yellow);
        g.fillRect((int) x, (int) y, 32, 32);
    }
    
    
}
