package SameLib.Tween.Easing;

public class EasingBackOut extends Easing {

    public EasingBackOut(int time) {
        super(time);
    }

    @Override
    public float calcProgress(int gameTime) {
        return EasingFunc.easeOutBack(timer.getElapsedTime(), period);
    }
}
