package com.tencent.tinker.a.a;

import com.tencent.tinker.a.a.b.c;
import com.tencent.tinker.a.a.t.a.a;

public final class r extends a<r> {
    public int Ayp;
    public int Ayq;
    public int Ayr;

    public final /* synthetic */ int compareTo(Object obj) {
        r rVar = (r) obj;
        int hX = c.hX(this.Ayp, rVar.Ayp);
        if (hX != 0) {
            return hX;
        }
        hX = c.hX(this.Ayq, rVar.Ayq);
        if (hX == 0) {
            return c.hY(this.Ayr, rVar.Ayr);
        }
        return hX;
    }

    public r(int i, int i2, int i3, int i4) {
        super(i);
        this.Ayp = i2;
        this.Ayq = i3;
        this.Ayr = i4;
    }
}
