package SameLib.Tween.Easing;

public class EasingQuintInOut extends Easing {

    public EasingQuintInOut(int time) {
        super(time);
    }

    @Override
    public float calcProgress(int gameTime) {
        return EasingFunc.easeInOutQuint(timer.getElapsedTime(), period);
    }
}
