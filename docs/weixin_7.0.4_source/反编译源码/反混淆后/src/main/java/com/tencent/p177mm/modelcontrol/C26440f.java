package com.tencent.p177mm.modelcontrol;

/* renamed from: com.tencent.mm.modelcontrol.f */
public final class C26440f implements Comparable {
    public int fAa;
    public int fAb;
    public int fAc;
    public int fAd;
    public int fAe;
    public int fzY;
    public int fzZ;

    public C26440f(int i, int i2, int i3, int i4, int i5, int i6, int i7) {
        this.fzY = i;
        this.fzZ = i2;
        this.fAa = i3;
        this.fAb = i4;
        this.fAc = i5;
        this.fAd = i6;
        this.fAe = i7;
    }

    public final int compareTo(Object obj) {
        if (obj == null || !(obj instanceof C26440f)) {
            return 0;
        }
        return this.fzY - ((C26440f) obj).fzY;
    }
}
