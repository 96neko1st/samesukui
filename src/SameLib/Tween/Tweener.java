package SameLib.Tween;

import SameLib.Compoment.GameComponent;
import SameLib.Event;
import SameLib.Tween.Easing.Easing;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * Tween用のゲームコンポーネント
 */
public class Tweener extends GameComponent {
    private Easing easing;
    private Event updateEvent = null;
    private Object updateParam = null;
    private Event finishedEvent = null;
    private Object finishedParam = null;

    public Tweener(int periodTime, Class<? extends Easing> easingCls) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Constructor easingConstructor = easingCls.getConstructor(Integer.class);
        easing = (Easing) easingConstructor.newInstance(periodTime);
    }

    /**
     * イベントを登録する
     *
     * @param updateEvent
     * @param finishedEvent
     */
    public Tweener setEvent(Event updateEvent, Object updateParam, Event finishedEvent, Object finishedParam) {
        this.updateEvent = updateEvent;
        this.updateParam = updateParam;
        this.finishedEvent = finishedEvent;
        this.finishedParam = finishedParam;

        return this;
    }

    public Tweener setUpdateEvent(Event event, Object param) {
        this.updateEvent = event;
        this.updateParam = param;

        return this;
    }

    public Tweener setFinishedEvent(Event event, Object param) {
        this.finishedEvent = event;
        this.finishedParam = param;

        return this;
    }

    @Override
    public void onEnable(int gameTime) {

    }

    @Override
    public void onUpdate(int gameTime) {

    }

    @Override
    public void onRender(int gameTime) {

    }
}
