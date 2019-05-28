package com.tencent.matrix.trace.p173d;

/* renamed from: com.tencent.matrix.trace.d.a */
public final class C1151a {
    public int bZt;
    public int bZu;
    public int bna;
    public int count = 1;

    public C1151a(int i, int i2, int i3) {
        this.bZt = i;
        this.bZu = i2;
        this.bna = i3;
    }

    public final String toString() {
        return this.bna + "," + this.bZt + "," + this.count + "," + this.bZu;
    }

    /* renamed from: aD */
    public final void mo4383aD(long j) {
        this.count++;
        this.bZu = (int) (((long) this.bZu) + j);
    }
}
