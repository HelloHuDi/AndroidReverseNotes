package com.tencent.tinker.a.a;

import com.tencent.tinker.a.a.b.c;
import com.tencent.tinker.a.a.t.a.a;

public final class p extends a<p> {
    public int Aym;
    public int Ayn;
    public int Ayo;

    public final /* synthetic */ int compareTo(Object obj) {
        p pVar = (p) obj;
        if (this.Aym != pVar.Aym) {
            return c.hX(this.Aym, pVar.Aym);
        }
        if (this.Ayn != pVar.Ayn) {
            return c.hX(this.Ayn, pVar.Ayn);
        }
        return c.hX(this.Ayo, pVar.Ayo);
    }

    public p(int i, int i2, int i3, int i4) {
        super(i);
        this.Aym = i2;
        this.Ayo = i3;
        this.Ayn = i4;
    }
}
