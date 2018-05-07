package SameLib.Tween.Easing;

public class EasingBackIn extends Easing {

    public EasingBackIn(int time) {
        super(time);
    }

    @Override
    public float calcProgress(int gameTime) {
        return EasingFunc.easeInBack(timer.getElapsedTime(), period);
    }
}
