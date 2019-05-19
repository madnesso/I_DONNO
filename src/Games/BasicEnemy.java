package Games;

import java.awt.*;

public class BasicEnemy extends GameObject {
    public BasicEnemy(int x, int y, ID id) {
        super(x, y, id);
        velx = 10;
        vely = 10;
    }

    @Override
    public void tick() {
        x += velx;
        y +=vely;
        if (y <=0 || y>=Game.HEIGHT-32 ) vely*=-1;
        if (x <=0 || x>=Game.WIDTH-16 ) velx*=-1;

    }

    @Override
    public void render(Graphics g) {
    g.setColor(Color.RED);
    g.fillRect(x,y,16,16);
    }
}
