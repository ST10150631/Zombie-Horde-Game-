/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package zombie.horde.game;

import java.awt.Graphics;

/**
 *
 * @author Mike Turner
 */
public abstract class GameObject {
    
    protected float x,y;
    protected float VelX,VelY;
    protected ID id;

    public GameObject(float x, float y, ID id) {
        this.x = x;
        this.y = y;
        this.id = id;
    }

    public abstract void tick();
    
    public abstract void render(Graphics g);

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }

    public float getVelX() {
        return VelX;
    }

    public void setVelX(float VelX) {
        this.VelX = VelX;
    }

    public float getVelY() {
        return VelY;
    }

    public void setVelY(float VelY) {
        this.VelY = VelY;
    }

    public ID getId() {
        return id;
    }

    public void setId(ID id) {
        this.id = id;
    }
    
    
   
}
