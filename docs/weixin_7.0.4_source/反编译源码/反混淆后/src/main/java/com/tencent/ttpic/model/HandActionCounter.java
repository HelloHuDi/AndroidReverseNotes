package com.tencent.ttpic.model;

public class HandActionCounter {
    public int count;
    public long updateTime;

    public HandActionCounter(int i, long j) {
        this.count = i;
        this.updateTime = j;
    }

    public void clear() {
        this.count = 0;
        this.updateTime = 0;
    }
}
