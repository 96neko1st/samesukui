package SameLib.Tween.Easing;

public class EasingSineOut extends Easing {

    public EasingSineOut(int time) {
        super(time);
    }

    @Override
    public float calcProgress(int gameTime) {
        return EasingFunc.easeOutSine(timer.getElapsedTime(), period);
    }
}
