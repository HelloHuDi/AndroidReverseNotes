package com.tencent.tinker.c.a.a.a;

import com.tencent.tinker.a.a.i;
import com.tencent.tinker.a.a.t.a;
import com.tencent.tinker.c.a.c.c;

public final class e extends i<com.tencent.tinker.a.a.e> {
    private a AzL = null;
    private com.tencent.tinker.a.a.i.e AzM = null;

    /* Access modifiers changed, original: protected|final|synthetic */
    public final /* synthetic */ Comparable a(com.tencent.tinker.c.a.c.a aVar, Comparable comparable) {
        com.tencent.tinker.a.a.e eVar = (com.tencent.tinker.a.a.e) comparable;
        return new com.tencent.tinker.a.a.e(eVar.off, aVar.b(eVar.Axs), aVar.b(eVar.Axt), aVar.b(eVar.Axu), aVar.b(eVar.Axv));
    }

    /* Access modifiers changed, original: protected|final|synthetic */
    public final /* synthetic */ int e(Comparable comparable) {
        com.tencent.tinker.a.a.e eVar = (com.tencent.tinker.a.a.e) comparable;
        a aVar = this.AzL;
        aVar.size++;
        return this.AzM.a(eVar);
    }

    public e(com.tencent.tinker.c.a.b.a aVar, i iVar, i iVar2, c cVar) {
        super(aVar, iVar, cVar);
        if (iVar2 != null) {
            this.AzL = iVar2.AxY.AyD;
            this.AzM = iVar2.a(this.AzL);
        }
    }

    /* Access modifiers changed, original: protected|final */
    public final void a(c cVar, int i, int i2, int i3, int i4) {
        if (i2 != i4) {
            cVar.AAX.put(i2, i4);
        }
    }

    /* Access modifiers changed, original: protected|final */
    public final a c(i iVar) {
        return iVar.AxY.AyD;
    }

    /* Access modifiers changed, original: protected|final */
    public final void a(c cVar, int i, int i2) {
        if (i2 >= 0) {
            cVar.ABl.RI(i2);
        }
    }

    /* Access modifiers changed, original: protected|final|synthetic */
    public final /* synthetic */ Comparable a(com.tencent.tinker.a.a.a.a aVar) {
        return aVar.dRF();
    }
}
