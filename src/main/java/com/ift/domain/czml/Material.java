package com.ift.domain.czml;

/**
 * Created by chen3 on 5/24/17.
 */
public class Material {

    private SolidColor solidColor;

    public Material(SolidColor solidColor) {
        this.solidColor = solidColor;
    }

    public SolidColor getSolidColor() {
        return solidColor;
    }

    public void setSolidColor(SolidColor solidColor) {
        this.solidColor = solidColor;
    }
}
