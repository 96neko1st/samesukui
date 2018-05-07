package SameLib;

public class Color {
    public int r, g, b, a;

    public Color() {
        r = g = b = a = 0;
    }

    public Color(int val) {
        r = g = b = val;
        a = 255;
    }

    public Color(int r, int g, int b) {
        this.r = r;
        this.g = g;
        this.b = b;
        a = 255;
    }

    public Color(int r, int g, int b, int a) {
        this.r = r;
        this.g = g;
        this.b = b;
        this.a = a;
    }
}
