package SameLib.Tween.Easing;

public class EasingCubicOut extends Easing {

    public EasingCubicOut(int time) {
        super(time);
    }

    @Override
    public float calcProgress(int gameTime) {
        return EasingFunc.easeOutCubic(timer.getElapsedTime(), period);
    }
}
