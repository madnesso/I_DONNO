package Games;

import java.awt.*;

public  abstract class GameObject {
    protected  int x , y,velx,vely;
    protected ID id;

    public GameObject(int x,int y , ID id){
        this.x= x;
        this.y=y;
        this.id = id;
    }
    public abstract void tick();
    public  abstract  void render(Graphics g);

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public ID getId() {
        return id;
    }

    public void setId(ID id) {
        this.id = id;
    }

    public int getVelx() {
        return velx;
    }

    public void setVelx(int velx) {
        this.velx = velx;
    }

    public int getVely() {
        return vely;
    }

    public void setVely(int vely) {
        this.vely = vely;
    }

}
