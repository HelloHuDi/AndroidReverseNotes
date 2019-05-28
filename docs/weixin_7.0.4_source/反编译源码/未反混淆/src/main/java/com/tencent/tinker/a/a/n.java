package com.tencent.tinker.a.a;

import com.tencent.tinker.a.a.b.c;
import com.tencent.tinker.a.a.t.a.a;

public final class n extends a<n> {
    public int AxA;
    public int Aym;
    public int Ayn;

    public final /* synthetic */ int compareTo(Object obj) {
        n nVar = (n) obj;
        if (this.Aym != nVar.Aym) {
            return c.hX(this.Aym, nVar.Aym);
        }
        if (this.Ayn != nVar.Ayn) {
            return c.hX(this.Ayn, nVar.Ayn);
        }
        return c.hX(this.AxA, nVar.AxA);
    }

    public n(int i, int i2, int i3, int i4) {
        super(i);
        this.Aym = i2;
        this.AxA = i3;
        this.Ayn = i4;
    }
}
