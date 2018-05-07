package SameLib.Tween.Easing;

public class EasingQuartIn extends Easing {

    public EasingQuartIn(int time) {
        super(time);
    }

    @Override
    public float calcProgress(int gameTime) {
        return EasingFunc.easeInQuart(timer.getElapsedTime(), period);
    }
}
