package SameLib.Tween.Easing;

public class EasingCubicIn extends Easing {

    public EasingCubicIn(int time) {
        super(time);
    }

    @Override
    public float calcProgress(int gameTime) {
        return EasingFunc.easeInCubic(timer.getElapsedTime(), period);
    }
}
