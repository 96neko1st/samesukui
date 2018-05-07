package SameLib.Tween.Easing;

public class EasingBounceOut extends Easing {

    public EasingBounceOut(int time) {
        super(time);
    }

    @Override
    public float calcProgress(int gameTime) {
        return EasingFunc.easeOutBounce(timer.getElapsedTime(), period);
    }
}
