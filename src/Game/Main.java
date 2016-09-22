package Game;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.SlickException;

public class Main {

    public static void main(String [] args) {
        Map map = new Map("Box2d Test Game");

        try
        {
            AppGameContainer app = new AppGameContainer(map);
            app.setDisplayMode(600, 600, false);
            app.start();

        }
        catch (SlickException e)
        {
            e.printStackTrace();
        }
    }
}
