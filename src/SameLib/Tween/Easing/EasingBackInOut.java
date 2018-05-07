package SameLib.Tween.Easing;

public class EasingBackInOut extends Easing {

    public EasingBackInOut(int time) {
        super(time);
    }

    @Override
    public float calcProgress(int gameTime) {
        return EasingFunc.easeInOutBack(timer.getElapsedTime(), period);
    }
}
