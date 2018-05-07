package SameLib.Tween.Easing;

public class EasingCircInOut extends Easing {

    public EasingCircInOut(int time) {
        super(time);
    }

    @Override
    public float calcProgress(int gameTime) {
        return EasingFunc.easeInOutCirc(timer.getElapsedTime(), period);
    }
}
