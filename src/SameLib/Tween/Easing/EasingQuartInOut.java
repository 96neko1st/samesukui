package SameLib.Tween.Easing;

public class EasingQuartInOut extends Easing {

    public EasingQuartInOut(int time) {
        super(time);
    }

    @Override
    public float calcProgress(int gameTime) {
        return EasingFunc.easeInOutQuart(timer.getElapsedTime(), period);
    }
}
