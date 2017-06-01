package com.ift.domain.czml;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by chen3 on 5/24/17.
 */
public class PolyLine {

    private boolean followSurface;
    private Positions positions;
    private int width = 1;
    private String[] availability;
    private ShowInterval[] show;
    private Material material;


    public String[] getAvailability() {
        return availability;
    }

    public void setAvailability(String[] availability) {
        this.availability = availability;
    }

    public boolean isFollowSurface() {
        return followSurface;
    }

    public void setFollowSurface(boolean followSurface) {
        this.followSurface = followSurface;
    }

    public Positions getPositions() {
        return positions;
    }

    public void setPositions(Positions positions) {
        this.positions = positions;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public ShowInterval[] getShow() {
        return show;
    }

    public void setShow(ShowInterval[] show) {
        this.show = show;
    }

    public Material getMaterial() {
        return material;
    }

    public void setMaterial(Material material) {
        this.material = material;
    }
}
