package SameLib;

public class EventParam {
    public float gameTime;
    public Object callObj, param;

    public EventParam(float time, Object callObj, Object param) {
        this.gameTime = time;
        this.callObj = callObj;
        this.param = param;
    }
}