package SameLib.Tween.Easing;

public class EasingSineIn extends Easing {

    public EasingSineIn(int time) {
        super(time);
    }

    @Override
    public float calcProgress(int gameTime) {
        return EasingFunc.easeInSine(timer.getElapsedTime(), period);
    }
}
