package SameLib.Tween.Easing;

public class EasingCircOut extends Easing {

    public EasingCircOut(int time) {
        super(time);
    }

    @Override
    public float calcProgress(int gameTime) {
        return EasingFunc.easeOutCirc(timer.getElapsedTime(), period);
    }
}
