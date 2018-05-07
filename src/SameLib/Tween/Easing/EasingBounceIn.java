package SameLib.Tween.Easing;

public class EasingBounceIn extends Easing {

    public EasingBounceIn(int time) {
        super(time);
    }

    @Override
    public float calcProgress(int gameTime) {
        return EasingFunc.easeInBounce(timer.getElapsedTime(), period);
    }
}
