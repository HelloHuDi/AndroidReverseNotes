package com.tencent.tinker.a.b.a;

import com.tencent.tinker.a.c.b;

public abstract class a {
    final b AyY = new b();
    public int akp = 0;

    public final int dSb() {
        int indexOfKey = this.AyY.indexOfKey(this.akp);
        if (indexOfKey < 0) {
            return this.akp;
        }
        return this.AyY.Azj[indexOfKey];
    }

    public final void hZ(int i, int i2) {
        this.AyY.put(i, i2);
    }

    /* Access modifiers changed, original: protected|final */
    public final void dSc() {
        this.akp++;
    }
}
