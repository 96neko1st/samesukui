package SameLib.Tween.Easing;

public class EasingCircIn extends Easing {

    public EasingCircIn(int time) {
        super(time);
    }

    @Override
    public float calcProgress(int gameTime) {
        return EasingFunc.easeInCirc(timer.getElapsedTime(), period);
    }
}
