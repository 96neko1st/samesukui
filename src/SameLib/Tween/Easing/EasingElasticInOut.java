package SameLib.Tween.Easing;

public class EasingElasticInOut extends Easing {

    public EasingElasticInOut(int time) {
        super(time);
    }

    @Override
    public float calcProgress(int gameTime) {
        return EasingFunc.easeInOutElastic(timer.getElapsedTime(), period);
    }
}
