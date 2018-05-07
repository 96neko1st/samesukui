package SameLib.Tween.Easing;

public class EasingElasticIn extends Easing {

    public EasingElasticIn(int time) {
        super(time);
    }

    @Override
    public float calcProgress(int gameTime) {
        return EasingFunc.easeInElastic(timer.getElapsedTime(), period);
    }
}
