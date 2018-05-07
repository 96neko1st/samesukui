package SameLib.Compoment;

public abstract class GameBehavior {
    protected boolean active = true;
    protected boolean execOnEnable = true;

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean value) {
        // 現在動いていなくて、動作させる場合、OnEnableを実行させるフラグをたてる
        if (!this.active && value) {
            this.execOnEnable = true;
        }

        this.active = value;
    }

    public boolean isExecOnEnable() {
        return execOnEnable;
    }

    public void setExecOnEnable(boolean value) {
        execOnEnable = value;
    }

    public abstract void onEnable(int gameTime);

    public abstract void onUpdate(int gameTime);

    public abstract void onRender(int gameTime);
}
