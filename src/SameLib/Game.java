package SameLib;

import SameLib.Utils.Sfmt;
import processing.core.*;

public class Game {
    private static Game instance = null;

    private PApplet applet;
    private float gameTime = 0;
    private SceneManager sceneManager;
    private Input input;

    private Sfmt random;

    private Color background;
    private int objectIndex = 0;

    private Game() {
        sceneManager = SceneManager.getInstance();
        input = Input.getInstance();
        background = new Color(255);

        random = new Sfmt((int) System.currentTimeMillis());
    }

    public static Game create(PApplet applet) {
        if (instance == null) {
            instance = new Game();
        }
        instance.applet = applet;

        instance.input.init();

        return instance;
    }

    /**
     * インスタンスを得る
     *
     * @return
     */
    public static Game getInstance() {
        return instance;
    }

    public PApplet getApplet() {
        return applet;
    }

    public Input getInput() {
        return input;
    }

    public int getObjectIndex() {
        return ++objectIndex;
    }

    /**
     * 0以上n未満のランダムな値を得る
     *
     * @param n
     * @return
     */
    public int random(int n) {
        return this.random.NextInt(n);
    }

    /**
     * ウィンドウを表示する
     *
     * @param width
     * @param height
     * @param mode
     */
    public void showWindow(int width, int height, String mode) {
        applet.size(width, height, mode);
    }

    /**
     * ウィンドウの幅を取得する
     *
     * @return
     */
    public int getWidth() {
        return applet.width;
    }

    /**
     * ウィンドウの高さを取得する
     *
     * @return
     */
    public int getHeight() {
        return applet.height;
    }

    /**
     * シーンを追加する
     *
     * @param scene
     */
    public void addScene(Scene scene) {
        sceneManager.add(scene);
    }

    /**
     * シーンを切り替える
     *
     * @param name シーン名
     */
    public void changeScene(String name) {
        sceneManager.set(name);
    }

    /**
     * シーンの初期化を行う。
     * ※必ず呼び出そう！
     */
    public void initScenes() {
        sceneManager.initScenes();
    }

    /**
     * 現在のシーンを得る
     *
     * @return
     */
    public Scene getScene() {
        return sceneManager.getScene();
    }

    /**
     * 現在のゲーム時間を得る
     *
     * @return
     */
    public float getGameTime() {
        return gameTime;
    }

    /**
     * 背景色を設定する
     *
     * @param color
     */
    public void setBackground(Color color) {
        this.background = color;
    }

    /**
     * 更新処理
     *
     * @param gameTime
     */
    public void update(int gameTime) {
        applet.background(background.r, background.g, background.b);
        sceneManager.update(gameTime);
    }
}