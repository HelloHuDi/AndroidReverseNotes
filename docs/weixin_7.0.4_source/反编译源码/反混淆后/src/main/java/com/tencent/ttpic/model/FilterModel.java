package com.tencent.ttpic.model;

public class FilterModel {
    private int effectIndex;
    private int filterId;

    public FilterModel(int i, int i2) {
        this.filterId = i;
        this.effectIndex = i2;
    }

    public int getFilterId() {
        return this.filterId;
    }

    public void setFilterId(int i) {
        this.filterId = i;
    }

    public int getEffectIndex() {
        return this.effectIndex;
    }

    public void setEffectIndex(int i) {
        this.effectIndex = i;
    }
}
