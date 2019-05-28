package com.tencent.ttpic.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Arrays;

public class PhantomItem {
    private int blendMode = 0;
    private String dataPath;
    /* renamed from: id */
    private String f14332id = "";
    private String maskImage = "";
    private double opacity = 1.0d;
    private double scale = 1.0d;
    private double xAsin = 0.0d;
    private double xBcos = 0.0d;
    /* renamed from: xK */
    private double f14333xK = 0.0d;
    private double xOffset = 0.0d;
    private double xPhase = 0.0d;
    private double[] xRange = new double[]{0.0d, 360.0d};
    private double xStep = 0.0d;
    private double xtime = 0.0d;
    private double yAsin = 0.0d;
    private double yBcos = 0.0d;
    /* renamed from: yK */
    private double f14334yK = 0.0d;
    private double yOffset = 0.0d;
    private double yPhase = 0.0d;
    private double[] yRange = new double[]{0.0d, 360.0d};
    private double yStep = 0.0d;
    private double ytime = 0.0d;

    public PhantomItem() {
        AppMethodBeat.m2504i(83510);
        AppMethodBeat.m2505o(83510);
    }

    public String getId() {
        return this.f14332id;
    }

    public void setId(String str) {
        this.f14332id = str;
    }

    public String getDataPath() {
        return this.dataPath;
    }

    public void setDataPath(String str) {
        this.dataPath = str;
    }

    public String getMaskImage() {
        return this.maskImage;
    }

    public void setMaskImage(String str) {
        this.maskImage = str;
    }

    public int getBlendMode() {
        return this.blendMode;
    }

    public void setBlendMode(int i) {
        this.blendMode = i;
    }

    public double getScale() {
        return this.scale;
    }

    public void setScale(double d) {
        if (d <= 0.0d) {
            this.scale = 1.0d;
        } else {
            this.scale = d;
        }
    }

    public double getOpacity() {
        return this.opacity;
    }

    public void setOpacity(double d) {
        if (d > 1.0d) {
            this.opacity = 1.0d;
        } else if (d < 0.0d) {
            this.opacity = 0.0d;
        } else {
            this.opacity = d;
        }
    }

    public double getxK() {
        return this.f14333xK;
    }

    public void setxK(double d) {
        this.f14333xK = d;
    }

    public double getxAsin() {
        return this.xAsin / this.scale;
    }

    public void setxAsin(double d) {
        this.xAsin = d;
    }

    public double getxBcos() {
        return this.xBcos / this.scale;
    }

    public void setxBcos(double d) {
        this.xBcos = d;
    }

    public double getxPhase() {
        return this.xPhase;
    }

    public void setxPhase(double d) {
        this.xPhase = d;
    }

    public double getxOffset() {
        return (this.xOffset - (0.5d * (1.0d - this.scale))) / this.scale;
    }

    public void setxOffset(double d) {
        this.xOffset = d;
    }

    public double getxStep() {
        return this.xStep;
    }

    public void setxStep(double d) {
        this.xStep = d;
    }

    public double[] getxRange() {
        return this.xRange;
    }

    public void setxRange(double[] dArr) {
        this.xRange = dArr;
    }

    public double getyK() {
        return this.f14334yK;
    }

    public void setyK(double d) {
        this.f14334yK = d;
    }

    public double getyAsin() {
        return this.yAsin / this.scale;
    }

    public void setyAsin(double d) {
        this.yAsin = d;
    }

    public double getyBcos() {
        return this.yBcos / this.scale;
    }

    public void setyBcos(double d) {
        this.yBcos = d;
    }

    public double getyPhase() {
        return this.yPhase;
    }

    public void setyPhase(double d) {
        this.yPhase = d;
    }

    public double getyOffset() {
        return (this.yOffset - (0.5d * (1.0d - this.scale))) / this.scale;
    }

    public void setyOffset(double d) {
        this.yOffset = d;
    }

    public double getyStep() {
        return this.yStep;
    }

    public void setyStep(double d) {
        this.yStep = d;
    }

    public double[] getyRange() {
        return this.yRange;
    }

    public void setyRange(double[] dArr) {
        this.yRange = dArr;
    }

    public double getXtime() {
        return this.xtime;
    }

    public void setXtime(double d) {
        this.xtime = d;
    }

    public double getYtime() {
        return this.ytime;
    }

    public void setYtime(double d) {
        this.ytime = d;
    }

    public void makeXStep(long j) {
        this.xtime += (this.xStep * ((double) j)) * 0.03d;
        if (this.xtime > this.xRange[1]) {
            this.xtime = this.xRange[0];
        }
    }

    public void makeYStep(long j) {
        this.ytime += (this.yStep * ((double) j)) * 0.03d;
        if (this.ytime > this.yRange[1]) {
            this.ytime = this.yRange[0];
        }
    }

    public String toString() {
        AppMethodBeat.m2504i(83511);
        String str = "PhantomItem{dataPath='" + this.dataPath + '\'' + ", id='" + this.f14332id + '\'' + ", maskImage='" + this.maskImage + '\'' + ", blendMode=" + this.blendMode + ", scale=" + this.scale + ", opacity=" + this.opacity + ", xK=" + this.f14333xK + ", xAsin=" + this.xAsin + ", xBcos=" + this.xBcos + ", xPhase=" + this.xPhase + ", xOffset=" + this.xOffset + ", xStep=" + this.xStep + ", xRange=" + Arrays.toString(this.xRange) + ", yK=" + this.f14334yK + ", yAsin=" + this.yAsin + ", yBcos=" + this.yBcos + ", yPhase=" + this.yPhase + ", yOffset=" + this.yOffset + ", yStep=" + this.yStep + ", yRange=" + Arrays.toString(this.yRange) + '}';
        AppMethodBeat.m2505o(83511);
        return str;
    }
}
