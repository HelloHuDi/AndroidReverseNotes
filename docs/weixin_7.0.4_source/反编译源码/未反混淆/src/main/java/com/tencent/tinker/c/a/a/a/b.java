package com.tencent.tinker.c.a.a.a;

import com.tencent.tinker.a.a.c;
import com.tencent.tinker.a.a.i;
import com.tencent.tinker.a.a.i.e;
import com.tencent.tinker.a.a.t.a;

public final class b extends i<c> {
    private a AzF = null;
    private e AzG = null;

    /* Access modifiers changed, original: protected|final|synthetic */
    public final /* synthetic */ Comparable a(com.tencent.tinker.c.a.c.a aVar, Comparable comparable) {
        c cVar = (c) comparable;
        int length = cVar.Axn.length;
        int[] iArr = new int[length];
        for (int i = 0; i < length; i++) {
            iArr[i] = aVar.RS(cVar.Axn[i]);
        }
        return new c(cVar.off, iArr);
    }

    /* Access modifiers changed, original: protected|final|synthetic */
    public final /* synthetic */ int e(Comparable comparable) {
        c cVar = (c) comparable;
        a aVar = this.AzF;
        aVar.size++;
        return this.AzG.a(cVar);
    }

    public b(com.tencent.tinker.c.a.b.a aVar, i iVar, i iVar2, com.tencent.tinker.c.a.c.c cVar) {
        super(aVar, iVar, cVar);
        if (iVar2 != null) {
            this.AzF = iVar2.AxY.AyB;
            this.AzG = iVar2.a(this.AzF);
        }
    }

    /* Access modifiers changed, original: protected|final */
    public final void a(com.tencent.tinker.c.a.c.c cVar, int i, int i2, int i3, int i4) {
        if (i2 != i4) {
            cVar.AAU.put(i2, i4);
        }
    }

    /* Access modifiers changed, original: protected|final */
    public final a c(i iVar) {
        return iVar.AxY.AyB;
    }

    /* Access modifiers changed, original: protected|final */
    public final void a(com.tencent.tinker.c.a.c.c cVar, int i, int i2) {
        if (i2 >= 0) {
            cVar.ABi.RI(i2);
        }
    }

    /* Access modifiers changed, original: protected|final|synthetic */
    public final /* synthetic */ Comparable a(com.tencent.tinker.a.a.a.a aVar) {
        return aVar.dRI();
    }
}
