package SameLib.Tween.Easing;

public class EasingCubicInOut extends Easing {

    public EasingCubicInOut(int time) {
        super(time);
    }

    @Override
    public float calcProgress(int gameTime) {
        return EasingFunc.easeInOutCubic(timer.getElapsedTime(), period);
    }
}

