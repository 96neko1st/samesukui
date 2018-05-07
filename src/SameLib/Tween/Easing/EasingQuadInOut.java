package SameLib.Tween.Easing;

public class EasingQuadInOut extends Easing {

    public EasingQuadInOut(int time) {
        super(time);
    }

    @Override
    public float calcProgress(int gameTime) {
        return EasingFunc.easeInOutQuad(timer.getElapsedTime(), period);
    }
}

