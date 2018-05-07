package SameLib.Tween.Easing;

public class EasingQuartOut extends Easing {

    public EasingQuartOut(int time) {
        super(time);
    }

    @Override
    public float calcProgress(int gameTime) {
        return EasingFunc.easeOutQuart(timer.getElapsedTime(), period);
    }
}
