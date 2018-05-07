package SameLib.Tween.Easing;

import SameLib.Event;
import SameLib.EventParam;
import SameLib.Timer;

public abstract class Easing {
    protected Timer timer;
    protected int period;
    protected Event updateEvent;
    protected Object updateParam;
    protected Event finishedEvent;
    protected Object finishedParam;

    public Easing(int time) {
        period = time;
        timer = new Timer(time);
        updateEvent = null;
        finishedEvent = null;
    }

    public Easing start(int gameTime) {
        timer.start(gameTime);
        return this;
    }

    public void update(int gameTime) {
        timer.update(gameTime);
        handleEvent(gameTime, calcProgress(gameTime));
    }

    public abstract float calcProgress(int gameTime);

    public Easing setEvent(Event updateEvent, Object updateParam, Event finishedEvent, Object finishedParam) {
        this.updateEvent = updateEvent;
        this.updateParam = updateParam;
        this.finishedEvent = finishedEvent;
        this.finishedParam = finishedParam;

        return this;
    }

    public Easing setUpdateEvent(Event updateEvent, Object updateParam) {
        this.updateEvent = updateEvent;
        this.updateParam = updateParam;

        return this;
    }

    public Easing setFinishedEvent(Event finishedEvent, Object finishedParam) {
        this.finishedEvent = finishedEvent;
        this.finishedParam = finishedParam;

        return this;
    }

    protected void handleEvent(int gameTime, float progress) {
        if (progress >= 0.99995f) {
            if (finishedEvent != null)
                finishedEvent.handleEvent(new EventParam(gameTime, this, finishedParam));
        } else {
            if (updateEvent != null)
                updateEvent.handleEvent(new EventParam(gameTime, this, updateParam));
        }
    }
}

