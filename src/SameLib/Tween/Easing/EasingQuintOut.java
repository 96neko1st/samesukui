package SameLib.Tween.Easing;

public class EasingQuintOut extends Easing {

    public EasingQuintOut(int time) {
        super(time);
    }

    @Override
    public float calcProgress(int gameTime) {
        return EasingFunc.easeOutQuint(timer.getElapsedTime(), period);
    }
}
