package com.tencent.ttpic.model;

public class FaceActionCounter {
    public int count;
    public long updateTime;

    public FaceActionCounter(int i, long j) {
        this.count = i;
        this.updateTime = j;
    }

    public void clear() {
        this.count = 0;
        this.updateTime = 0;
    }
}
