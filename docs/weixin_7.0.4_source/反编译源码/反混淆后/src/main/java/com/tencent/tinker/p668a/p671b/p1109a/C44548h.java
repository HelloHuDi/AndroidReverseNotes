package com.tencent.tinker.p668a.p671b.p1109a;

/* renamed from: com.tencent.tinker.a.b.a.h */
public final class C44548h extends C16318a {
    public short[] Azg;

    public C44548h(int i) {
        if (i < 0) {
            throw new IllegalArgumentException("initSize < 0");
        }
        this.Azg = new short[i];
    }

    /* renamed from: c */
    public final void mo70971c(short s) {
        int i = this.akp;
        if (this.Azg.length - i <= 0) {
            short[] sArr = new short[(this.Azg.length + (this.Azg.length >> 1))];
            System.arraycopy(this.Azg, 0, sArr, 0, i);
            this.Azg = sArr;
        }
        this.Azg[this.akp] = s;
        dSc();
    }

    /* renamed from: c */
    public final void mo70972c(short s, short s2) {
        mo70971c(s);
        mo70971c(s2);
    }

    /* renamed from: a */
    public final void mo70970a(short s, short s2, short s3) {
        mo70971c(s);
        mo70971c(s2);
        mo70971c(s3);
    }

    public final void writeInt(int i) {
        mo70971c((short) i);
        mo70971c((short) (i >> 16));
    }
}
