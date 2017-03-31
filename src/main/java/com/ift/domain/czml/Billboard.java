package com.ift.domain.czml;

import java.io.Serializable;

/**
 * Created by chen3 on 3/31/17.
 */
public class Billboard implements Serializable {

    private boolean show = true;            // Whether or not the billboard is shown.
    private String image;                   // The URI of the image displayed on the billboard.
    private double scale = 1.0;             // The scale of the billboard. The scale is multiplied with the pixel size of the billboard's image.
    private String horizontalOrigin = "CENTER";
    private String verticalOrigin = "CENTER";

    public boolean isShow() {
        return show;
    }

    public void setShow(boolean show) {
        this.show = show;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public double getScale() {
        return scale;
    }

    public void setScale(double scale) {
        this.scale = scale;
    }

    public String getHorizontalOrigin() {
        return horizontalOrigin;
    }

    public void setHorizontalOrigin(String horizontalOrigin) {
        this.horizontalOrigin = horizontalOrigin;
    }

    public String getVerticalOrigin() {
        return verticalOrigin;
    }

    public void setVerticalOrigin(String verticalOrigin) {
        this.verticalOrigin = verticalOrigin;
    }
}
