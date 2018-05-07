package SameLib.Tween.Easing;

public class EasingSineInOut extends Easing {

    public EasingSineInOut(int time) {
        super(time);
    }

    @Override
    public float calcProgress(int gameTime) {
        return EasingFunc.easeInOutSine(timer.getElapsedTime(), period);
    }
}
