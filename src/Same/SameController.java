package Same;

import SameLib.Compoment.GameComponent;
import SameLib.Game;
import processing.core.PApplet;
import processing.core.PVector;

public class SameController extends GameComponent {
    private Game game;
    private PApplet applet;
    private int width, height;

    @Override
    public void onEnable(int gameTime) {
        game = Game.getInstance();
        applet = game.getApplet();
        width = game.getWidth();
        height = game.getHeight();

        PVector pos = parent.getTransform().getPosition();
        pos.x = 100 + game.random(width - 200);
        pos.y = 100 + game.random(height - 200);
    }

    @Override
    public void onUpdate(int gameTime) {
        PVector mpos = Game.getInstance().getInput().getMousePosition();

        PVector pos = parent.getTransform().getPosition();

        float d = PVector.dist(mpos, pos);
        PVector dir = new PVector(0f, 0f);
        if (d < 100) {
            dir = PVector.sub(pos, mpos)
                    .normalize()
                    .mult(10);

            pos.x += dir.x;
            pos.y += dir.y;
        } else {
            pos.x += dir.x + Game.getInstance().random(11) - 5;
            pos.y += dir.y + Game.getInstance().random(11) - 5;
        }

        pos.x = PApplet.constrain(pos.x, 100, width - 100);
        pos.y = PApplet.constrain(pos.y, 100, height - 100);
//        if (pos.x < 100) {
//            pos.x = 100;
//        }
//        if (pos.x > width - 100) {
//            pos.x = width - 100;
//        }
//        if (pos.y < 100) {
//            pos.y = 100;
//        }
//        if (pos.y > height - 100) {
//            pos.y = height - 100;
//        }

    }

    @Override
    public void onRender(int gameTime) {

    }
}
