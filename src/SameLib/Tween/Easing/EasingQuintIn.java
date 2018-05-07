package SameLib.Tween.Easing;

public class EasingQuintIn extends Easing {

    public EasingQuintIn(int time) {
        super(time);
    }

    @Override
    public float calcProgress(int gameTime) {
        return EasingFunc.easeInQuint(timer.getElapsedTime(), period);
    }
}
