package com.tencent.tinker.a.b.a;

public final class h extends a {
    public short[] Azg;

    public h(int i) {
        if (i < 0) {
            throw new IllegalArgumentException("initSize < 0");
        }
        this.Azg = new short[i];
    }

    public final void c(short s) {
        int i = this.akp;
        if (this.Azg.length - i <= 0) {
            short[] sArr = new short[(this.Azg.length + (this.Azg.length >> 1))];
            System.arraycopy(this.Azg, 0, sArr, 0, i);
            this.Azg = sArr;
        }
        this.Azg[this.akp] = s;
        dSc();
    }

    public final void c(short s, short s2) {
        c(s);
        c(s2);
    }

    public final void a(short s, short s2, short s3) {
        c(s);
        c(s2);
        c(s3);
    }

    public final void writeInt(int i) {
        c((short) i);
        c((short) (i >> 16));
    }
}
