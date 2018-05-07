package SameLib.Tween.Easing;

public class EasingExpoIn extends Easing {

    public EasingExpoIn(int time) {
        super(time);
    }

    @Override
    public float calcProgress(int gameTime) {
        return EasingFunc.easeInExpo(timer.getElapsedTime(), period);
    }
}
