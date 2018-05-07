package SameLib.Tween.Easing;

public class EasingElasticOut extends Easing {

    public EasingElasticOut(int time) {
        super(time);
    }

    @Override
    public float calcProgress(int gameTime) {
        return EasingFunc.easeOutElastic(timer.getElapsedTime(), period);
    }
}
