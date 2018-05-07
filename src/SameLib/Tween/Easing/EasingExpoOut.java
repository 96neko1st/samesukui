package SameLib.Tween.Easing;

public class EasingExpoOut extends Easing {

    public EasingExpoOut(int time) {
        super(time);
    }

    @Override
    public float calcProgress(int gameTime) {
        return EasingFunc.easeOutExpo(timer.getElapsedTime(), period);
    }
}
