package com.tencent.tinker.p668a.p671b.p1109a;

import com.tencent.tinker.p668a.p1352c.C24428b;

/* renamed from: com.tencent.tinker.a.b.a.a */
public abstract class C16318a {
    final C24428b AyY = new C24428b();
    public int akp = 0;

    public final int dSb() {
        int indexOfKey = this.AyY.indexOfKey(this.akp);
        if (indexOfKey < 0) {
            return this.akp;
        }
        return this.AyY.Azj[indexOfKey];
    }

    /* renamed from: hZ */
    public final void mo29591hZ(int i, int i2) {
        this.AyY.put(i, i2);
    }

    /* Access modifiers changed, original: protected|final */
    public final void dSc() {
        this.akp++;
    }
}
