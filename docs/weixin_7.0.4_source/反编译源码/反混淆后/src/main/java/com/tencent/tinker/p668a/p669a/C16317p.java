package com.tencent.tinker.p668a.p669a;

import com.tencent.tinker.p668a.p669a.C41083t.C31086a.C31087a;
import com.tencent.tinker.p668a.p669a.p670b.C5910c;

/* renamed from: com.tencent.tinker.a.a.p */
public final class C16317p extends C31087a<C16317p> {
    public int Aym;
    public int Ayn;
    public int Ayo;

    public final /* synthetic */ int compareTo(Object obj) {
        C16317p c16317p = (C16317p) obj;
        if (this.Aym != c16317p.Aym) {
            return C5910c.m9194hX(this.Aym, c16317p.Aym);
        }
        if (this.Ayn != c16317p.Ayn) {
            return C5910c.m9194hX(this.Ayn, c16317p.Ayn);
        }
        return C5910c.m9194hX(this.Ayo, c16317p.Ayo);
    }

    public C16317p(int i, int i2, int i3, int i4) {
        super(i);
        this.Aym = i2;
        this.Ayo = i3;
        this.Ayn = i4;
    }
}
