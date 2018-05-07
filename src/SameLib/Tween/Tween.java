package SameLib.Tween;

import SameLib.Compoment.GameObject;
import SameLib.Event;
import SameLib.EventParam;
import SameLib.Game;
import SameLib.Tween.Easing.Easing;
import processing.core.PApplet;
import processing.core.PVector;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;

public class Tween {
    private static Tween instance = new Tween();
    private ArrayList<Tweener> tweeners;

    private Tween() {
        tweeners = new ArrayList<>();
    }

    public static Tween getInstance() {
        return instance;
    }

    public void removeTweener(Tweener tweener) {
        tweeners.remove(tweener);
        tweener.getGameObject().setParent(null);
    }

    public void killAll() {
        for(Tweener tweener: tweeners) {
            removeTweener(tweener);
        }
    }

    private void appendScene(GameObject targetObj, Tweener tweener) {
        Game game = Game.getInstance();

        GameObject obj = new GameObject("Tweener$" + targetObj.getName() + "$" + game.getObjectIndex());
        obj.addComponent(tweener);

        game.getScene().add(obj);
    }

    public static Tweener moveTo(GameObject targetObj, PVector destPos, int periodTime, Class<? extends Easing> easingCls) throws IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        Tweener tweener = new Tweener(periodTime, easingCls);

        PVector start = targetObj.getTransform().getPosition().copy();
        PVector dest = destPos.copy();
        PApplet applet = Game.getInstance().getApplet();

        tweener.setUpdateEvent(new Event() {
            @Override
            public int handleEvent(EventParam eventParam) {
                float amt = (float)eventParam.param;
                PVector p = start.lerp(dest, amt);
                targetObj.getTransform().setPosition(p);
                return 0;
            }
        }, null);

        getInstance().appendScene(targetObj, tweener);

        return tweener;
    }
}
