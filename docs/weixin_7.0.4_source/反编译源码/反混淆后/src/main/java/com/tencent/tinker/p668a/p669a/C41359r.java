package com.tencent.tinker.p668a.p669a;

import com.tencent.tinker.p668a.p669a.C41083t.C31086a.C31087a;
import com.tencent.tinker.p668a.p669a.p670b.C5910c;

/* renamed from: com.tencent.tinker.a.a.r */
public final class C41359r extends C31087a<C41359r> {
    public int Ayp;
    public int Ayq;
    public int Ayr;

    public final /* synthetic */ int compareTo(Object obj) {
        C41359r c41359r = (C41359r) obj;
        int hX = C5910c.m9194hX(this.Ayp, c41359r.Ayp);
        if (hX != 0) {
            return hX;
        }
        hX = C5910c.m9194hX(this.Ayq, c41359r.Ayq);
        if (hX == 0) {
            return C5910c.m9195hY(this.Ayr, c41359r.Ayr);
        }
        return hX;
    }

    public C41359r(int i, int i2, int i3, int i4) {
        super(i);
        this.Ayp = i2;
        this.Ayq = i3;
        this.Ayr = i4;
    }
}
