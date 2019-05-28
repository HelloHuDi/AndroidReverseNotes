package com.tencent.tinker.c.a.a.a;

import com.tencent.tinker.a.a.i;
import com.tencent.tinker.a.a.i.e;
import com.tencent.tinker.a.a.t.a;
import com.tencent.tinker.c.a.c.c;

public final class f extends i<com.tencent.tinker.a.a.f> {
    private a AzN = null;
    private e AzO = null;

    /* Access modifiers changed, original: protected|final|synthetic */
    public final /* synthetic */ Comparable a(com.tencent.tinker.c.a.c.a aVar, Comparable comparable) {
        com.tencent.tinker.a.a.f fVar = (com.tencent.tinker.a.a.f) comparable;
        return new com.tencent.tinker.a.a.f(fVar.off, aVar.RM(fVar.AxA), fVar.Axx, aVar.RM(fVar.AxB), aVar.RQ(fVar.AxC), aVar.RL(fVar.AxD), aVar.RU(fVar.AxE), aVar.RW(fVar.AxF), aVar.RV(fVar.AxG));
    }

    /* Access modifiers changed, original: protected|final|synthetic */
    public final /* synthetic */ int e(Comparable comparable) {
        com.tencent.tinker.a.a.f fVar = (com.tencent.tinker.a.a.f) comparable;
        a aVar = this.AzN;
        aVar.size++;
        return this.AzO.a(fVar);
    }

    public f(com.tencent.tinker.c.a.b.a aVar, i iVar, i iVar2, c cVar) {
        super(aVar, iVar, cVar);
        if (iVar2 != null) {
            this.AzN = iVar2.AxY.Ayy;
            this.AzO = iVar2.a(this.AzN);
        }
    }

    /* Access modifiers changed, original: protected|final */
    public final a c(i iVar) {
        return iVar.AxY.Ayy;
    }

    /* Access modifiers changed, original: protected|final|synthetic */
    public final /* synthetic */ Comparable a(com.tencent.tinker.a.a.a.a aVar) {
        return aVar.dRC();
    }
}
