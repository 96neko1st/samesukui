package Same;

import SameLib.Compoment.Anchor;
import SameLib.Compoment.GameObject;
import SameLib.Compoment.Sprite;
import SameLib.Scene;
import SameLib.SpriteFactory;

public class GameScene extends Scene {
    public GameScene() {
        super("game");
    }

    @Override
    public void init() {
        add(createField());

        add(createSamekun());
        add(createSamekun());
        add(createSamekun());
        add(createSamekun());
        add(createSamekun());
        add(createSamekun());
        add(createSamekun());
        add(createSamekun());
        add(createSamekun());
        add(createSamekun());
        add(createSamekun());
        add(createSamekun());

        add(createPoi());
    }

    private GameObject createField() {
        GameObject obj = SpriteFactory.create("field.png");
        Sprite sprite = (Sprite) obj.getComponent(Sprite.class);
        sprite.setSize(720, 480);

        return obj;
    }

    private GameObject createPoi() {
        GameObject obj = SpriteFactory.create("poi.png");
        Sprite sprite = (Sprite) obj.getComponent(Sprite.class);
        sprite.getAnchor().set(Anchor.AnchorType.MIDDLE_CENTER);
        sprite.setSize(50, 50);

        PoiController poictrl = new PoiController();
        obj.addComponent(poictrl);

        return obj;
    }

    private GameObject createSamekun() {
        GameObject obj = SpriteFactory.create("samekun.png");
        Sprite sprite = (Sprite) obj.getComponent(Sprite.class);
        sprite.getAnchor().set(Anchor.AnchorType.MIDDLE_CENTER);
        sprite.setSize(50, 50);

        SameController samectrl = new SameController();
        obj.addComponent(samectrl);

        return obj;
    }
}
