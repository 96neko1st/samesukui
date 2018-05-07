package SameLib.Compoment;

public abstract class GameComponent extends GameBehavior {
    protected GameObject parent = null;

    public GameObject getGameObject() {
        return parent;
    }

    public void setParent(GameObject parent) {
        if (this.parent == parent) return;

        if (this.parent != null) {
            if (parent == null) {
                this.parent.getComponents().remove(this);
                this.parent = null;
            } else {
                this.parent.getComponents().remove(this);
                this.parent = parent;
                parent.getComponents().add(this);
            }
        } else {
            this.parent = parent;
            parent.getComponents().add(this);
        }
    }
}
