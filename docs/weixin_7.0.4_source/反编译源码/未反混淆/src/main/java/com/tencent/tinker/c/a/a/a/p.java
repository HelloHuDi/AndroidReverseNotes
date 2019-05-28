package com.tencent.tinker.c.a.a.a;

import com.tencent.tinker.a.a.i;
import com.tencent.tinker.a.a.i.e;
import com.tencent.tinker.a.a.t.a;
import com.tencent.tinker.a.a.u;
import com.tencent.tinker.c.a.c.c;

public final class p extends i<u> {
    private a AAh = null;
    private e AAi = null;

    /* Access modifiers changed, original: protected|final|synthetic */
    public final /* synthetic */ Comparable a(com.tencent.tinker.c.a.c.a aVar, Comparable comparable) {
        u uVar = (u) comparable;
        if (uVar == u.AyQ) {
            return uVar;
        }
        short[] sArr = new short[uVar.AyR.length];
        for (int i = 0; i < sArr.length; i++) {
            sArr[i] = (short) aVar.RM(uVar.AyR[i]);
        }
        return new u(uVar.off, sArr);
    }

    /* Access modifiers changed, original: protected|final|synthetic */
    public final /* synthetic */ int e(Comparable comparable) {
        u uVar = (u) comparable;
        a aVar = this.AAh;
        aVar.size++;
        return this.AAi.a(uVar);
    }

    public p(com.tencent.tinker.c.a.b.a aVar, i iVar, i iVar2, c cVar) {
        super(aVar, iVar, cVar);
        if (iVar2 != null) {
            this.AAh = iVar2.AxY.AyA;
            this.AAi = iVar2.a(this.AAh);
        }
    }

    /* Access modifiers changed, original: protected|final */
    public final void a(c cVar, int i, int i2, int i3, int i4) {
        if (i2 != i4) {
            cVar.AAR.put(i2, i4);
        }
    }

    /* Access modifiers changed, original: protected|final */
    public final a c(i iVar) {
        return iVar.AxY.AyA;
    }

    /* Access modifiers changed, original: protected|final */
    public final void a(c cVar, int i, int i2) {
        if (i2 >= 0) {
            cVar.ABf.RI(i2);
        }
    }

    /* Access modifiers changed, original: protected|final|synthetic */
    public final /* synthetic */ Comparable a(com.tencent.tinker.a.a.a.a aVar) {
        return aVar.dRy();
    }
}
