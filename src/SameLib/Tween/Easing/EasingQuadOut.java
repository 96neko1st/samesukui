package SameLib.Tween.Easing;

public class EasingQuadOut extends Easing {
    public EasingQuadOut(int time) {
        super(time);
    }

    @Override
    public float calcProgress(int gameTime) {
        return EasingFunc.easeOutQuad(timer.getElapsedTime(), period);
    }
}
