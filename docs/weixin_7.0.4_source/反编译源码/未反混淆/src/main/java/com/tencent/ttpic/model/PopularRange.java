package com.tencent.ttpic.model;

public class PopularRange {
    public float max = 10.0f;
    public float min = -10.0f;
    public float value = -2.0f;

    public boolean isHit() {
        return this.min <= this.value && this.value < this.max;
    }

    public void setValue(float f) {
        if (this.value >= 0.0f) {
            f = this.value;
        }
        this.value = f;
    }

    public void clearStatus() {
        this.value = -2.0f;
    }
}
