/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package zombie.horde.game;

import java.awt.Graphics;
import java.util.LinkedList;

/**
 *
 * @author Mike Turner
 */
public class Handler {

    public LinkedList<GameObject> object = new LinkedList<GameObject>();

    public void tick() {
        for(GameObject tempObject : object){
            tempObject.tick();
        }
    }

    public void render(Graphics g) {
        for(GameObject tempObject : object){
            tempObject.render(g);
        }
    }
    
    
    public void addObject (GameObject tempObject){
        object.add(tempObject);
    }
    
    public void removeObject (GameObject tempObject){
        object.remove(tempObject);
    }
}
