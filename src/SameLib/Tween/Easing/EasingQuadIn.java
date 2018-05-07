package SameLib.Tween.Easing;

public class EasingQuadIn extends Easing {
    public EasingQuadIn(int time) {
        super(time);
    }

    @Override
    public float calcProgress(int gameTime) {
        return EasingFunc.easeInQuad(timer.getElapsedTime(), period);
    }
}
