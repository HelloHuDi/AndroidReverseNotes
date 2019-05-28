package com.tencent.ttpic.model;

public class CharmRange {
    public static final int HIT = 1;
    public static final int NOT_HIT = 2;
    public static final int PENDING = 0;
    public double max;
    public double min;
    public int status = 0;

    public boolean isHit() {
        return this.status == 1;
    }

    public void hit(double d) {
        if (d < this.min || (d >= this.max && (this.max != 1.0d || d > this.max))) {
            this.status = 2;
        } else {
            this.status = 1;
        }
    }

    public void clearStatus() {
        this.status = 0;
    }
}
