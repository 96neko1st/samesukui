package SameLib.Tween.Easing;

public class EasingExpoInOut extends Easing {

    public EasingExpoInOut(int time) {
        super(time);
    }

    @Override
    public float calcProgress(int gameTime) {
        return EasingFunc.easeInOutExpo(timer.getElapsedTime(), period);
    }
}
