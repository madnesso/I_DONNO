package Games;

import java.awt.*;

public class Player extends GameObject {
    public Player(int x, int y, ID id) {
        super(x, y, id);
    }

    @Override
    public void tick() {
     x+=velx;
     y+=vely;
     x = Game.clamp(x, 0, Game.WIDTH-38);
     y= Game.clamp(y,0,Game.HEIGHT-61);
    }

    @Override
    public void render(Graphics g) {

        if (id ==ID.Player)g.setColor(Color.WHITE);
        else if (id == ID.Player2)g.setColor(Color.BLUE);
        g.fillRect(x,y,32,32);

    }
}
