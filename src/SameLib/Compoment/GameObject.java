package SameLib.Compoment;

import SameLib.Game;
import processing.core.PApplet;
import processing.core.PVector;

import java.util.ArrayList;

public class GameObject extends GameBehavior {
    private String name;
    private Transform transform;
    private ArrayList<GameComponent> components = new ArrayList<>();
    private Node node = new Node();
    private PApplet applet;
    private GameObject parent;

    public GameObject() {
        this("");
    }

    public GameObject(String name) {
        transform = new Transform();

        if (name.equals(""))
            setName(this.getClass().getName() + Game.getInstance().getObjectIndex());
        else
            setName(name);

        applet = Game.getInstance().getApplet();
        parent = null;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public PApplet getApplet() {
        return applet;
    }

    public Transform getTransform() {
        return transform;
    }

    public void setTransform(Transform transform) {
        this.transform = transform;
    }

    public Node getNode() {
        return node;
    }

    public void addChild(GameObject child) {
        child.setParent(this);
    }

    public void removeChild(GameObject child) {
        child.setParent(null);
    }

    public boolean isChild(GameObject obj) {
        return node.hasObject(obj);
    }

    public GameObject getParent() {
        return parent;
    }

    public void setParent(GameObject parent) {
        if (this.parent == parent) return;

        if (this.parent != null) {
            if (parent == null) {   // 削除
                this.parent.node.remove(this);
                this.parent = null;
            } else {    // 付け替え
                this.parent.node.remove(this);
                this.parent = parent;
                parent.node.add(this);
            }
        } else { // this.parent == null
            if (!parent.isChild(this)) {    // 追加
                this.parent = parent;
                parent.node.add(this);
            }
        }
    }

    public void addComponent(GameComponent component) {
        component.setParent(this);
    }

    public void removeComponent(GameComponent component) {
        component.setParent(null);
    }

    public GameComponent getComponent(Class<?> cls) {
        for (GameComponent cmp : components) {
            if (cls == cmp.getClass()) {
                return cmp;
            }
        }
        return null;
    }

    public ArrayList<GameComponent> getComponents() {
        return components;
    }

    public ArrayList<GameComponent> getComponents(Class<?> cls) {
        ArrayList<GameComponent> result = new ArrayList<>();

        for (GameComponent cmp : components) {
            if (cls == cmp.getClass()) {
                result.add(cmp);
            }
        }

        return (result.size() > 0) ? result : null;
    }

    public boolean isExecOnEnable() {
        return execOnEnable;
    }

    @Override
    public void onEnable(int gameTime) {
        for (GameComponent c : components) {
            if(c.isActive() && c.isExecOnEnable()) {
                c.onEnable(gameTime);
                c.setExecOnEnable(false);
            }
        }
    }

    @Override
    public void onUpdate(int gameTime) {
        for (GameComponent c : components) {
            c.onUpdate(gameTime);
        }
    }

    @Override
    public void onRender(int gameTime) {
        applet.pushMatrix();

        for (GameComponent c : components) {
            c.onRender(gameTime);
        }

        applet.popMatrix();
    }

    public void onPreRender(int gameTime) {
        applet.pushMatrix();
        PVector p = transform.getPosition();
        applet.translate(p.x, p.y, p.z);

        PVector r = transform.getRotation();
        applet.rotateX(r.x);
        applet.rotateY(r.y);
        applet.rotateZ(r.z);

        PVector s = transform.getScale();
        applet.scale(s.x, s.y, s.z);
    }

    public void onPostRender(int gameTime) {
        applet.popMatrix();
    }
}