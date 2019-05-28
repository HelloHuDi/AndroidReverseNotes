package com.tencent.tinker.c.a.a.a;

import com.tencent.tinker.a.a.i;
import com.tencent.tinker.a.a.i.e;
import com.tencent.tinker.a.a.r;
import com.tencent.tinker.a.a.t.a;
import com.tencent.tinker.c.a.c.c;

public final class l extends i<r> {
    private a AzX = null;
    private e AzY = null;

    /* Access modifiers changed, original: protected|final|synthetic */
    public final /* synthetic */ Comparable a(com.tencent.tinker.c.a.c.a aVar, Comparable comparable) {
        r rVar = (r) comparable;
        return new r(rVar.off, aVar.RL(rVar.Ayp), aVar.RM(rVar.Ayq), aVar.RQ(rVar.Ayr));
    }

    /* Access modifiers changed, original: protected|final|synthetic */
    public final /* synthetic */ int e(Comparable comparable) {
        r rVar = (r) comparable;
        a aVar = this.AzX;
        aVar.size++;
        return this.AzY.a(rVar);
    }

    public l(com.tencent.tinker.c.a.b.a aVar, i iVar, i iVar2, c cVar) {
        super(aVar, iVar, cVar);
        if (iVar2 != null) {
            this.AzX = iVar2.AxY.Ayv;
            this.AzY = iVar2.a(this.AzX);
        }
    }

    /* Access modifiers changed, original: protected|final */
    public final void a(c cVar, int i, int i2, int i3, int i4) {
        if (i != i3) {
            cVar.AAO.put(i, i3);
        }
    }

    /* Access modifiers changed, original: protected|final */
    public final a c(i iVar) {
        return iVar.AxY.Ayv;
    }

    /* Access modifiers changed, original: protected|final */
    public final void a(c cVar, int i, int i2) {
        if (i >= 0) {
            cVar.ABc.RI(i);
        }
    }

    /* Access modifiers changed, original: protected|final|synthetic */
    public final /* synthetic */ Comparable a(com.tencent.tinker.a.a.a.a aVar) {
        return aVar.dRB();
    }
}
