package SameLib.Compoment;

public class Anchor {
    public enum AnchorType {
        TOP_LEFT,
        TOP_CENTER,
        TOP_RIGHT,
        MIDDLE_LEFT,
        MIDDLE_CENTER,
        MIDDLE_RIGHT,
        BOTTOM_LEFT,
        BOTTOM_CENTER,
        BOTTOM_RIGHT,
    }

    private AnchorType type = AnchorType.TOP_LEFT;
    private float hCoeff = 0f, vCoeff = 0f;

    public AnchorType get() {
        return this.type;
    }

    public void set(AnchorType type) {
        this.type = type;
        hCoeff = calcHorizontalCoefficient();
        vCoeff = calcVerticalCoefficient();
    }

    private float calcVerticalCoefficient() {
        switch (type) {
            case TOP_LEFT:
            case TOP_CENTER:
            case TOP_RIGHT:
                return 0;
            case MIDDLE_LEFT:
            case MIDDLE_CENTER:
            case MIDDLE_RIGHT:
                return 0.5f;
            case BOTTOM_LEFT:
            case BOTTOM_CENTER:
            case BOTTOM_RIGHT:
                return 1f;
        }
        return 0;
    }

    private float calcHorizontalCoefficient() {
        switch (type) {
            case TOP_LEFT:
            case MIDDLE_LEFT:
            case BOTTOM_LEFT:
                return 0;
            case TOP_CENTER:
            case MIDDLE_CENTER:
            case BOTTOM_CENTER:
                return 0.5f;
            case TOP_RIGHT:
            case MIDDLE_RIGHT:
            case BOTTOM_RIGHT:
                return 1f;
        }
        return 0;
    }

    public float getHorizontalCoefficient() {
        return hCoeff;
    }

    public float getVerticalCoefficient() {
        return vCoeff;
    }
}
