package SameLib.Compoment;

import processing.core.*;

public class Transform {
    private PVector position;
    private PVector rotation;
    private PVector scale;

    public Transform() {
        position = new PVector(0, 0, 0);
        rotation = new PVector(0, 0, 0);
        scale = new PVector(1, 1, 1);
    }

    public Transform(Transform t) {
        position = t.position.copy();
        rotation = t.rotation.copy();
        scale = t.scale.copy();
    }

    // get a copy of the Transform
    public Transform copy() {
        return new Transform(this);
    }

    public PVector getPosition() {
        return position;
    }

    public void setPosition(PVector v) {
        position = v;
    }

    public PVector getRotation() {
        return rotation;
    }

    public void setRotation(PVector v) {
        rotation = v;
    }

    public PVector getScale() {
        return scale;
    }

    public void setScele(PVector v) {
        scale = v;
    }
}