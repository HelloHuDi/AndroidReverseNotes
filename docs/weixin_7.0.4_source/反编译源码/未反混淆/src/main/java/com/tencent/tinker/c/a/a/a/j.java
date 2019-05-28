package com.tencent.tinker.c.a.a.a;

import com.tencent.tinker.a.a.i;
import com.tencent.tinker.a.a.i.e;
import com.tencent.tinker.a.a.n;
import com.tencent.tinker.a.a.t.a;
import com.tencent.tinker.c.a.c.c;

public final class j extends i<n> {
    private a AzT = null;
    private e AzU = null;

    /* Access modifiers changed, original: protected|final|synthetic */
    public final /* synthetic */ Comparable a(com.tencent.tinker.c.a.c.a aVar, Comparable comparable) {
        n nVar = (n) comparable;
        return new n(nVar.off, aVar.RM(nVar.Aym), aVar.RM(nVar.AxA), aVar.RL(nVar.Ayn));
    }

    /* Access modifiers changed, original: protected|final|synthetic */
    public final /* synthetic */ int e(Comparable comparable) {
        n nVar = (n) comparable;
        a aVar = this.AzT;
        aVar.size++;
        return this.AzU.a(nVar);
    }

    public j(com.tencent.tinker.c.a.b.a aVar, i iVar, i iVar2, c cVar) {
        super(aVar, iVar, cVar);
        if (iVar2 != null) {
            this.AzT = iVar2.AxY.Ayw;
            this.AzU = iVar2.a(this.AzT);
        }
    }

    /* Access modifiers changed, original: protected|final */
    public final void a(c cVar, int i, int i2, int i3, int i4) {
        if (i != i3) {
            cVar.AAP.put(i, i3);
        }
    }

    /* Access modifiers changed, original: protected|final */
    public final a c(i iVar) {
        return iVar.AxY.Ayw;
    }

    /* Access modifiers changed, original: protected|final */
    public final void a(c cVar, int i, int i2) {
        if (i >= 0) {
            cVar.ABd.RI(i);
        }
    }

    /* Access modifiers changed, original: protected|final|synthetic */
    public final /* synthetic */ Comparable a(com.tencent.tinker.a.a.a.a aVar) {
        return aVar.dRz();
    }
}
