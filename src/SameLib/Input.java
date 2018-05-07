package SameLib;

import processing.core.PApplet;
import processing.core.PConstants;
import processing.core.PVector;

public class Input {
    private static Input instance = new Input();

    private PApplet applet;

    private Input() {
    }

    public static Input getInstance() {
        return instance;
    }

    public void init() {
        applet = Game.getInstance().getApplet();
    }

    /**
     * マウスの位置を得る
     * @return
     */
    public PVector getMousePosition() {
        return new PVector(applet.mouseX, applet.mouseY);
    }

    /**
     * マウスの移動量を得る
     * @return
     */
    public PVector getMouseDeltaPosition() {
        return new PVector(applet.mouseX - applet.pmouseX, applet.mouseY - applet.pmouseY);
    }

    /**
     * マウスボタンの状態を得る
     * @param button 0:left, 1:right, 2:center
     * @return
     */
    public boolean getMouseButton(int button) {
        if(applet.mousePressed) {
            switch(button) {
                case 0:
                    return applet.mouseButton == PConstants.LEFT;
                case 1:
                    return applet.mouseButton == PConstants.RIGHT;
                case 2:
                    return applet.mouseButton == PConstants.CENTER;
            }
        }
        return false;
    }
}
