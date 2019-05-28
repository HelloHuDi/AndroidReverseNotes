package com.tencent.tinker.c.a.a.a;

import com.tencent.tinker.a.a.b;
import com.tencent.tinker.a.a.i;
import com.tencent.tinker.a.a.i.e;
import com.tencent.tinker.a.a.t.a;

public final class c extends i<b> {
    private a AzH = null;
    private e AzI = null;

    /* Access modifiers changed, original: protected|final|synthetic */
    public final /* synthetic */ Comparable a(com.tencent.tinker.c.a.c.a aVar, Comparable comparable) {
        b bVar = (b) comparable;
        int length = bVar.Axm.length;
        int[] iArr = new int[length];
        for (int i = 0; i < length; i++) {
            iArr[i] = aVar.RR(bVar.Axm[i]);
        }
        return new b(bVar.off, iArr);
    }

    /* Access modifiers changed, original: protected|final|synthetic */
    public final /* synthetic */ int e(Comparable comparable) {
        b bVar = (b) comparable;
        a aVar = this.AzH;
        aVar.size++;
        return this.AzI.a(bVar);
    }

    public c(com.tencent.tinker.c.a.b.a aVar, i iVar, i iVar2, com.tencent.tinker.c.a.c.c cVar) {
        super(aVar, iVar, cVar);
        if (iVar2 != null) {
            this.AzH = iVar2.AxY.AyC;
            this.AzI = iVar2.a(this.AzH);
        }
    }

    /* Access modifiers changed, original: protected|final */
    public final void a(com.tencent.tinker.c.a.c.c cVar, int i, int i2, int i3, int i4) {
        if (i2 != i4) {
            cVar.AAT.put(i2, i4);
        }
    }

    /* Access modifiers changed, original: protected|final */
    public final a c(i iVar) {
        return iVar.AxY.AyC;
    }

    /* Access modifiers changed, original: protected|final */
    public final void a(com.tencent.tinker.c.a.c.c cVar, int i, int i2) {
        if (i2 >= 0) {
            cVar.ABh.RI(i2);
        }
    }

    /* Access modifiers changed, original: protected|final|synthetic */
    public final /* synthetic */ Comparable a(com.tencent.tinker.a.a.a.a aVar) {
        return aVar.dRH();
    }
}
