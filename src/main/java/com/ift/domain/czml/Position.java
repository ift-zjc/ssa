package com.ift.domain.czml;


import com.fasterxml.jackson.annotation.JsonRootName;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by chen3 on 3/31/17.
 */

@JsonRootName(value = "position")
public class Position implements Serializable {

    private String interpolationAlgorithm;
    private int interpolationDegree;
    private String referenceFrame;
    private String epoch;
    private ArrayList<Double> cartesian;

    public int getInterpolationDegree() {
        return interpolationDegree;
    }

    public void setInterpolationDegree(int interpolationDegree) {
        this.interpolationDegree = interpolationDegree;
    }

    public String getReferenceFrame() {
        return referenceFrame;
    }

    public void setReferenceFrame(String referenceFrame) {
        this.referenceFrame = referenceFrame;
    }

    public String getEpoch() {
        return epoch;
    }

    public void setEpoch(String epoch) {
        this.epoch = epoch;
    }

    public ArrayList<Double> getCartesian() {
        return cartesian;
    }

    public void setCartesian(ArrayList<Double> cartesian) {
        this.cartesian = cartesian;
    }

    public String getInterpolationAlgorithm() {

        return interpolationAlgorithm;
    }

    public void setInterpolationAlgorithm(String interpolationAlgorithm) {
        this.interpolationAlgorithm = interpolationAlgorithm;
    }
}
