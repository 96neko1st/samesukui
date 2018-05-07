package SameLib;

import java.util.HashMap;

//
// SceneManager
//
public class SceneManager {
    private static SceneManager instance = new SceneManager();

    private HashMap<String, Scene> scenes;
    private String curName;
    private Scene curScene = null;

    private SceneManager() {
        scenes = new HashMap<>();
    }

    public static SceneManager getInstance() {
        return instance;
    }

    /**
     * 現在のシーンを得る
     * @return
     */
    public Scene getScene() {
        return curScene;
    }

    /**
     * 追加
     * @param scene
     */
    public void add(Scene scene) {
        scenes.put(scene.getName(), scene);
        if (curScene == null) {
            curName = scene.getName();
            curScene = scene;
        }
    }

    /**
     * シーンを切り替える
     * @param name
     */
    public void set(String name) {
        if (curName.equals(name)) return;


        Scene s = scenes.get(name);
        if (s != null) {
            // シーン切り替えのため、処理を打ち切るためのフラグを立てる
            curScene.setChangeScene(true);

            s.setChangeScene(false);
            curName = s.getName();
            curScene = s;   // シーン切り替え
        }
    }

    public void initScenes() {
        scenes.values().forEach(s -> s.init());
    }

    /**
     * カレントシーンのアップデート処理を呼び出す
     * @param gameTime
     */
    public void update(int gameTime) {
        if (curScene == null) return;

        curScene.update(gameTime);
    }
}