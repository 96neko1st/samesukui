package Same;

import SameLib.Compoment.GameComponent;
import SameLib.Game;
import processing.core.PVector;

public class PoiController extends GameComponent {
    @Override
    public void onEnable(int gameTime) {

    }

    @Override
    public void onUpdate(int gameTime) {
        PVector pos = Game.getInstance().getInput().getMousePosition();
        parent.getTransform().setPosition(pos);
    }

    @Override
    public void onRender(int gameTime) {

    }
}
