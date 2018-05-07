package SameLib.Compoment;

import java.util.ArrayList;

public class Node {
    ArrayList<GameObject> children = new ArrayList<>();

    public ArrayList<GameObject> getChildren() {
        return children;
    }

    public GameObject find(String name) {
        for (GameObject obj : children) {
            if (name.equals(obj.getName())) {
                return obj;
            }
        }
        return null;
    }

    public void add(GameObject obj) {
        children.add(obj);
    }

    public void remove(GameObject obj) {
        children.remove(obj);
    }

    public boolean hasObject(GameObject obj) {
        for(GameObject o : children) {
            if(o == obj)
                return true;
        }
        return false;
    }

    public void callChildOnEnable(int gameTime) {
        for (GameObject obj : children) {
            if (obj.isActive()) {
                if (obj.isExecOnEnable()) {
                    obj.setExecOnEnable(false);
                    obj.onEnable(gameTime);
                }
                obj.getNode().callChildOnEnable(gameTime);
            }
        }
    }

    public void callChildOnUpdate(int gameTime) {
        for (GameObject obj : children) {
            if (obj.isActive()) {
                obj.onUpdate(gameTime);
                obj.getNode().callChildOnUpdate(gameTime);
            }
        }
    }

    public void callChildOnRender(int gameTime) {
        for (GameObject obj : children) {
            if (obj.isActive()) {
                obj.onPreRender(gameTime);
                obj.onRender(gameTime);
                obj.getNode().callChildOnRender(gameTime);
                obj.onPostRender(gameTime);
            }
        }
    }
}
