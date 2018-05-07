package SameLib.Compoment;

import processing.core.PImage;

public class Sprite extends GameComponent {
    private PImage image;
    private int width, height;
    private Anchor anchor;

    public Sprite(PImage image) {
        anchor = new Anchor();
        this.image = image;
        setSize(image.width, image.height);
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public void setSize(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public Anchor getAnchor() {
        return anchor;
    }

    @Override
    public void onEnable(int gameTime) {
    }

    @Override
    public void onUpdate(int gameTime) {
    }

    @Override
    public void onRender(int gameTime) {
        parent.getApplet().image(this.image, -anchor.getHorizontalCoefficient() * width, -anchor.getVerticalCoefficient() * height, width, height);
    }
}
