package Same;

import processing.core.*;
import SameLib.*;

public class Main extends PApplet {

    Game game;

    @Override
    public void settings() {
        super.settings();

        game = Game.create(this);
        game.showWindow(720, 480, P3D);
    }

    @Override
    public void setup() {
        super.setup();

        game.addScene(new GameScene());
        game.changeScene("game");

        game.initScenes();
    }

    @Override
    public void draw() {
        game.update(millis());
    }

    public static void main(String[] args) {
        PApplet.main("Same.Main");
    }
}
