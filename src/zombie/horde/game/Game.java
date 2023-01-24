/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package zombie.horde.game;
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;


/**
 *
 * @author Mike Turner
 */
public class Game extends Canvas implements Runnable {

    public static int WIDTH = 1400, HEIGHT = 750;
    public String title = "Zombie Horde";

    private Thread thread;
    private boolean isRunning = false;
    
    //Instances 
    private Handler handler;

    public Game() {
        //constructor
        new Window(WIDTH,HEIGHT,title,this);
        start();
        
        init();
        //add below here :
        handler.addObject(new Player(100,100,ID.Player));
        handler.addObject(new Player(100,200,ID.Player));
        handler.addObject(new Player(200,100,ID.Player));
        
    }
    private void init(){
       handler = new Handler(); 
    }

    private synchronized void start() {
        if (isRunning) {
            return;
        }
        thread = new Thread(this);
        thread.start();
        isRunning = true;
    }

    private synchronized void stop() {
        if (!isRunning) {
            return;
        }
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        isRunning = false;
    }

    //gameloop
    public void run() {
        long lastTime = System.nanoTime();
        double amountOfTicks = 60.0;
        double ns = 1000000000 / amountOfTicks;
        double delta = 0;
        long timer = System.currentTimeMillis();
        int updates = 0;
        int frames = 0;
        while (isRunning) {
            long now = System.nanoTime();
            delta += (now - lastTime) / ns;
            lastTime = now;
            while (delta >= 1) {
                tick();
                updates++;
                delta--;
            }
            render();
            frames++;

            if (System.currentTimeMillis() - timer > 1000) {
                timer += 1000;
                System.out.println("FPS: " + frames + " TICKS: " + updates);
                frames = 0;
                updates = 0;
            }
        }
        stop();
    }
    
    private void tick(){
        //updates the game
        handler.tick();
    }
    
    private void render(){
        //renders the game
        BufferStrategy bs = this.getBufferStrategy();
        if (bs==null){
            this.createBufferStrategy(3);
            return;
        }
        
        Graphics g = bs.getDrawGraphics();
        g.setColor(Color.GRAY);
        g.fillRect(0, 0, WIDTH, HEIGHT);
        
        handler.render(g);
        //Meat of the rendering
        
        bs.show();
        g.dispose();
        
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        new Game();
    }

}


