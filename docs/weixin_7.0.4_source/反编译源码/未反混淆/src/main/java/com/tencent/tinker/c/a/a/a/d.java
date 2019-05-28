package com.tencent.tinker.c.a.a.a;

import com.tencent.tinker.a.a.i;
import com.tencent.tinker.a.a.i.e;
import com.tencent.tinker.a.a.t.a;
import com.tencent.tinker.c.a.c.c;
import java.lang.reflect.Array;

public final class d extends i<com.tencent.tinker.a.a.d> {
    private a AzJ = null;
    private e AzK = null;

    /* Access modifiers changed, original: protected|final|synthetic */
    public final /* synthetic */ Comparable a(com.tencent.tinker.c.a.c.a aVar, Comparable comparable) {
        int i;
        com.tencent.tinker.a.a.d dVar = (com.tencent.tinker.a.a.d) comparable;
        int RS = aVar.RS(dVar.Axo);
        int[][] iArr = (int[][]) Array.newInstance(Integer.TYPE, new int[]{dVar.Axp.length, 2});
        for (i = 0; i < iArr.length; i++) {
            iArr[i][0] = aVar.RO(dVar.Axp[i][0]);
            iArr[i][1] = aVar.RS(dVar.Axp[i][1]);
        }
        int[][] iArr2 = (int[][]) Array.newInstance(Integer.TYPE, new int[]{dVar.Axq.length, 2});
        for (i = 0; i < iArr2.length; i++) {
            iArr2[i][0] = aVar.RP(dVar.Axq[i][0]);
            iArr2[i][1] = aVar.RS(dVar.Axq[i][1]);
        }
        int[][] iArr3 = (int[][]) Array.newInstance(Integer.TYPE, new int[]{dVar.Axr.length, 2});
        for (i = 0; i < iArr3.length; i++) {
            iArr3[i][0] = aVar.RP(dVar.Axr[i][0]);
            iArr3[i][1] = aVar.RT(dVar.Axr[i][1]);
        }
        return new com.tencent.tinker.a.a.d(dVar.off, RS, iArr, iArr2, iArr3);
    }

    /* Access modifiers changed, original: protected|final|synthetic */
    public final /* synthetic */ int e(Comparable comparable) {
        com.tencent.tinker.a.a.d dVar = (com.tencent.tinker.a.a.d) comparable;
        a aVar = this.AzJ;
        aVar.size++;
        return this.AzK.a(dVar);
    }

    public d(com.tencent.tinker.c.a.b.a aVar, i iVar, i iVar2, c cVar) {
        super(aVar, iVar, cVar);
        if (iVar2 != null) {
            this.AzJ = iVar2.AxY.AyJ;
            this.AzK = iVar2.a(this.AzJ);
        }
    }

    /* Access modifiers changed, original: protected|final */
    public final void a(c cVar, int i, int i2, int i3, int i4) {
        if (i2 != i4) {
            cVar.AAV.put(i2, i4);
        }
    }

    /* Access modifiers changed, original: protected|final */
    public final a c(i iVar) {
        return iVar.AxY.AyJ;
    }

    /* Access modifiers changed, original: protected|final */
    public final void a(c cVar, int i, int i2) {
        if (i2 >= 0) {
            cVar.ABj.RI(i2);
        }
    }

    /* Access modifiers changed, original: protected|final|synthetic */
    public final /* synthetic */ Comparable a(com.tencent.tinker.a.a.a.a aVar) {
        return aVar.dRJ();
    }
}
