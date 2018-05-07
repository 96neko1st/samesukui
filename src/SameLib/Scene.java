package SameLib;

import SameLib.Compoment.GameObject;
import SameLib.Compoment.Node;
import processing.core.PApplet;

//
// Scene
//
public abstract class Scene {
    private String name;
    private Node root;
    private boolean change;
    private PApplet applet;

    /**
     * シーンを作成する
     * @param name シーン名
     */
    public Scene(String name) {
        this.name = name;
        root = new Node();
        change = false;
        applet = Game.getInstance().getApplet();
    }

    public abstract void init();

    /**
     * シーン名を得る
     * @return
     */
    public String getName() {
        return name;
    }

    /**
     * シーンの切り替えフラグの状態を得る。
     * @return
     */
    public boolean isChangeScene() {
        return change;
    }

    /**
     * シーンの切り替えフラグをセットする
     * @param change
     */
    public void setChangeScene(boolean change) {
        this.change = change;
    }

    public Node getRoot() {
        return root;
    }

    public void add(GameObject obj) {
        root.add(obj);
    }

    public void remove(GameObject obj) {
        root.remove(obj);
    }

    /**
     * シーンのアップデート処理
     * @param gameTime
     */
    void update(int gameTime) {
        //System.out.println(getName() + ".update(" + gameTime + ")");

        if (!change) {
            root.callChildOnEnable(gameTime);
        }

        if (!change) {
            root.callChildOnUpdate(gameTime);
        }
        if (!change) {
            applet.pushMatrix();
            root.callChildOnRender(gameTime);
            applet.popMatrix();
        }
    }
}