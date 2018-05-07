package SameLib.Tween.Easing;

public class EasingBounceInOut extends Easing {

    public EasingBounceInOut(int time) {
        super(time);
    }

    @Override
    public float calcProgress(int gameTime) {
        return EasingFunc.easeInOutBounce(timer.getElapsedTime(), period);
    }
}
