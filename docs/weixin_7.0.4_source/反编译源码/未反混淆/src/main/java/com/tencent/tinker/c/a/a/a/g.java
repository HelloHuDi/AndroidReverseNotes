package com.tencent.tinker.c.a.a.a;

import com.tencent.tinker.a.a.i;
import com.tencent.tinker.a.a.i.e;
import com.tencent.tinker.a.a.t.a;
import com.tencent.tinker.c.a.c.b;
import com.tencent.tinker.c.a.c.c;

public final class g extends i<com.tencent.tinker.a.a.g> {
    private a AzP = null;
    private e AzQ = null;

    /* Access modifiers changed, original: protected|final|synthetic */
    public final /* synthetic */ Comparable a(com.tencent.tinker.c.a.c.a aVar, Comparable comparable) {
        com.tencent.tinker.a.a.g.a[] aVarArr;
        com.tencent.tinker.a.a.g gVar = (com.tencent.tinker.a.a.g) comparable;
        int RX = aVar.RX(gVar.AxK);
        short[] sArr = gVar.AxL;
        if (!(sArr == null || sArr.length == 0)) {
            sArr = new b(aVar).a(sArr);
        }
        com.tencent.tinker.a.a.g.a[] aVarArr2 = gVar.AxN;
        if (aVarArr2 == null || aVarArr2.length == 0) {
            aVarArr = aVarArr2;
        } else {
            aVarArr = new com.tencent.tinker.a.a.g.a[aVarArr2.length];
            for (int i = 0; i < aVarArr2.length; i++) {
                com.tencent.tinker.a.a.g.a aVar2 = aVarArr2[i];
                int length = aVar2.AxO.length;
                int[] iArr = new int[length];
                for (int i2 = 0; i2 < length; i2++) {
                    iArr[i2] = aVar.RM(aVar2.AxO[i2]);
                }
                aVarArr[i] = new com.tencent.tinker.a.a.g.a(iArr, aVar2.AxP, aVar2.AxQ, aVar2.offset);
            }
        }
        return new com.tencent.tinker.a.a.g(gVar.off, gVar.AxH, gVar.AxI, gVar.AxJ, RX, sArr, gVar.AxM, aVarArr);
    }

    /* Access modifiers changed, original: protected|final|synthetic */
    public final /* synthetic */ int e(Comparable comparable) {
        com.tencent.tinker.a.a.g gVar = (com.tencent.tinker.a.a.g) comparable;
        a aVar = this.AzP;
        aVar.size++;
        return this.AzQ.a(gVar);
    }

    public g(com.tencent.tinker.c.a.b.a aVar, i iVar, i iVar2, c cVar) {
        super(aVar, iVar, cVar);
        if (iVar2 != null) {
            this.AzP = iVar2.AxY.AyE;
            this.AzQ = iVar2.a(this.AzP);
        }
    }

    /* Access modifiers changed, original: protected|final */
    public final void a(c cVar, int i, int i2, int i3, int i4) {
        if (i2 != i4) {
            cVar.AAZ.put(i2, i4);
        }
    }

    /* Access modifiers changed, original: protected|final */
    public final a c(i iVar) {
        return iVar.AxY.AyE;
    }

    /* Access modifiers changed, original: protected|final */
    public final void a(c cVar, int i, int i2) {
        if (i2 >= 0) {
            cVar.ABn.RI(i2);
        }
    }

    /* Access modifiers changed, original: protected|final|synthetic */
    public final /* synthetic */ Comparable a(com.tencent.tinker.a.a.a.a aVar) {
        return aVar.dRD();
    }
}
