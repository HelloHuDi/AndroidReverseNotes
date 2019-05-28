package com.tencent.tinker.p668a.p669a;

import com.tencent.tinker.p668a.p669a.C41083t.C31086a.C31087a;
import com.tencent.tinker.p668a.p669a.p670b.C5910c;

/* renamed from: com.tencent.tinker.a.a.n */
public final class C5916n extends C31087a<C5916n> {
    public int AxA;
    public int Aym;
    public int Ayn;

    public final /* synthetic */ int compareTo(Object obj) {
        C5916n c5916n = (C5916n) obj;
        if (this.Aym != c5916n.Aym) {
            return C5910c.m9194hX(this.Aym, c5916n.Aym);
        }
        if (this.Ayn != c5916n.Ayn) {
            return C5910c.m9194hX(this.Ayn, c5916n.Ayn);
        }
        return C5910c.m9194hX(this.AxA, c5916n.AxA);
    }

    public C5916n(int i, int i2, int i3, int i4) {
        super(i);
        this.Aym = i2;
        this.AxA = i3;
        this.Ayn = i4;
    }
}
