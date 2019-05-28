package com.tencent.matrix.trace.d;

public final class a {
    public int bZt;
    public int bZu;
    public int bna;
    public int count = 1;

    public a(int i, int i2, int i3) {
        this.bZt = i;
        this.bZu = i2;
        this.bna = i3;
    }

    public final String toString() {
        return this.bna + "," + this.bZt + "," + this.count + "," + this.bZu;
    }

    public final void aD(long j) {
        this.count++;
        this.bZu = (int) (((long) this.bZu) + j);
    }
}
