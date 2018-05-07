package SameLib;

import SameLib.Compoment.GameObject;
import SameLib.Compoment.Sprite;
import processing.core.PImage;

import java.util.HashMap;

/**
 * スプライト管理とゲームオブジェクトを作る
 */
public class SpriteFactory {
    private static SpriteFactory instance = new SpriteFactory();

    private HashMap<String, PImage> images;

    private SpriteFactory() {
        images = new HashMap<>();
    }

    public static SpriteFactory getInstance() {
        return instance;
    }

    /**
     * 指定した画像を読み込む。既に読み込み済みならキャッシュから返す。
     * @param name
     * @return
     */
    private PImage load(String name) {
        PImage img = images.get(name);
        if(img != null)
            return img;

        img = Game.getInstance().getApplet().loadImage("sprites/" + name);
        if(img != null) {
            images.put(name, img);
        }

        return img;
    }

    /**
     * 指定したファイル名のスプライトのゲームオブジェクトを作成する。
     * @param name スプライト名
     * @return
     */
    public static GameObject create(String name) {
        Sprite sprite = new Sprite(getInstance().load(name));
        GameObject obj = new GameObject();

        obj.addComponent(sprite);

        return obj;
    }
}
