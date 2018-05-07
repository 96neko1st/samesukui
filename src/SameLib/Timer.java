package SameLib;

/**
 * タイマー
 */
public class Timer {
    private boolean enabled;
    private int periodTime, startTime, curTime;
    private Event updateEvent;
    private Object updateParam;
    private Event finishedEvent;
    private Object finishedParam;

    /**
     * タイマーを作成
     *
     * @param period 設定時間
     */
    public Timer(int period) {
        enabled = false;
        periodTime = period;
        startTime = curTime = 0;
        updateEvent = null;
        updateParam = null;
        finishedEvent = null;
        finishedParam = null;
    }

    /**
     * イベントを登録する
     *
     * @param updateEvent
     * @param finishedEvent
     */
    public Timer setEvent(Event updateEvent, Object updateParam, Event finishedEvent, Object finishedParam) {
        this.updateEvent = updateEvent;
        this.updateParam = updateParam;
        this.finishedEvent = finishedEvent;
        this.finishedParam = finishedParam;

        return this;
    }

    public Timer setUpdateEvent(Event updateEvent, Object updateParam) {
        this.updateEvent = updateEvent;
        this.updateParam = updateParam;

        return this;
    }

    public Timer setFinishedEvent(Event finishedEvent, Object finishedParam) {
        this.finishedEvent = finishedEvent;
        this.finishedParam = finishedParam;

        return this;
    }

    /**
     * タイマーを開始する。
     *
     * @param time
     */
    public Timer start(int time) {
        enabled = true;
        startTime = curTime = time;

        return this;
    }

    /**
     * タイマーを止める
     */
    public void stop() {
        enabled = false;
    }

    /**
     * タイマーの更新
     *
     * @param time
     */
    public void update(int time) {
        if (!enabled) return;

        boolean finish = (curTime = time) - startTime > periodTime;
        if (finish) {
            if (finishedEvent != null) {
                finishedEvent.handleEvent(new EventParam(time, this, finishedParam));
            }
        } else {
            if (updateEvent != null) {
                updateEvent.handleEvent(new EventParam(time, this, updateParam));
            }
        }
    }

    /**
     * 完了したかどうか
     *
     * @return
     */
    public boolean isFinished() {
        return curTime - startTime > periodTime;
    }

    /**
     * 経過時間を取得する
     *
     * @return 経過時間
     */
    public int getElapsedTime() {
        return isFinished() ? periodTime : curTime - startTime;
    }

    /**
     * 設定時間を取得する
     *
     * @return 設定時間
     */
    public int getPeriodTime() {
        return periodTime;
    }
}
