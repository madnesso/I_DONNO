package Games;

import java.awt.*;
import java.awt.image.BufferStrategy;

public class Game extends Canvas implements Runnable {
    public static final int WIDTH=640;
    public static final int HEIGHT = WIDTH/12*9;
    private  Thread thread;
    private  boolean running = false;
    private Handler handler;
    private Game(){
        handler = new Handler();
        this.addKeyListener(new Keyinput(handler));
        new window(WIDTH,HEIGHT, "Games",this);
        handler.addObject(new Player(WIDTH/2 ,HEIGHT/2,ID.Player));
        //handler.addObject(new Player(WIDTH/2 +64 ,HEIGHT/2,ID.Player2));
        handler.addObject(new BasicEnemy(WIDTH/2  ,HEIGHT/2+100,ID.BasicEnemy));
    }
    synchronized void start(){
    thread = new Thread(this);
    thread.start();
    running= true;

    }
    synchronized void stop(){
        try {
            thread.join();
            running= false;
        }catch (Exception e){
            e.printStackTrace();
        }

    }
    public  static void main(String[] args){
    new Game();
    }

    @Override
    public void run() {
        long lastTime = System.nanoTime();
        double amountOfTicks = 60.0;
        double ns = 1000000000 / amountOfTicks;
        double delta = 0;
        long timer = System.currentTimeMillis();
        int frames = 0;
        while(running){
           long now = System.nanoTime();
           delta += (now-lastTime)/ns;
           lastTime = now;
           while (delta>=1){
               tick();
               delta--;
           }
           if(running)
               render();
           frames++;

           if (System.currentTimeMillis() -timer >1000){
               timer +=1000;
               System.out.println("FPS : "+frames);
               frames = 0;
           }
        }
        stop();
    }
    public static int clamp(int var,int min,int max){
        if (var>=max)
            return var=max;
        else if (var<=min)
            return var=min;
        else return var;
    }
    private void tick(){
    handler.tick();
    }
    private void render(){
        BufferStrategy bs = this.getBufferStrategy();
        if (bs == null){
            this.createBufferStrategy(3);
            return;
        }
        Graphics g = bs.getDrawGraphics();
        g.setColor(Color.BLACK);
        g.fillRect(0,0,WIDTH,HEIGHT);
        handler.render(g);
        g.dispose();
        bs.show();
    }
}
