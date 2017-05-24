package com.ift.domain.czml;

/**
 * Created by chen3 on 5/24/17.
 */
public class Color {

    private int[] rgba;

    public Color(int[] rgba) {
        this.rgba = rgba;
    }

    public int[] getRgba() {
        return rgba;
    }

    public void setRgba(int[] rgba) {
        this.rgba = rgba;
    }
}
