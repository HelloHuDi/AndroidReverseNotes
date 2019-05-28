package com.tencent.tinker.c.a.a.a;

import com.tencent.tinker.a.a.i;
import com.tencent.tinker.a.a.i.e;
import com.tencent.tinker.a.a.k;
import com.tencent.tinker.a.a.m;
import com.tencent.tinker.c.a.c.a.AnonymousClass4;
import com.tencent.tinker.c.a.c.c;
import java.io.ByteArrayOutputStream;

public final class a extends i<com.tencent.tinker.a.a.a> {
    private com.tencent.tinker.a.a.t.a AzD = null;
    private e AzE = null;

    /* Access modifiers changed, original: protected|final|synthetic */
    public final /* synthetic */ Comparable a(com.tencent.tinker.c.a.c.a aVar, Comparable comparable) {
        com.tencent.tinker.a.a.a aVar2 = (com.tencent.tinker.a.a.a) comparable;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(aVar2.Axl.data.length);
        new com.tencent.tinker.c.a.c.a.a(new AnonymousClass4(byteArrayOutputStream)).b(new m(aVar2.Axl, 29));
        return new com.tencent.tinker.a.a.a(aVar2.off, aVar2.Axk, new k(aVar2.Axl.off, byteArrayOutputStream.toByteArray()));
    }

    /* Access modifiers changed, original: protected|final|synthetic */
    public final /* synthetic */ int e(Comparable comparable) {
        com.tencent.tinker.a.a.a aVar = (com.tencent.tinker.a.a.a) comparable;
        com.tencent.tinker.a.a.t.a aVar2 = this.AzD;
        aVar2.size++;
        return this.AzE.a(aVar);
    }

    public a(com.tencent.tinker.c.a.b.a aVar, i iVar, i iVar2, c cVar) {
        super(aVar, iVar, cVar);
        if (iVar2 != null) {
            this.AzD = iVar2.AxY.AyH;
            this.AzE = iVar2.a(this.AzD);
        }
    }

    /* Access modifiers changed, original: protected|final */
    public final void a(c cVar, int i, int i2, int i3, int i4) {
        if (i2 != i4) {
            cVar.AAS.put(i2, i4);
        }
    }

    /* Access modifiers changed, original: protected|final */
    public final com.tencent.tinker.a.a.t.a c(i iVar) {
        return iVar.AxY.AyH;
    }

    /* Access modifiers changed, original: protected|final */
    public final void a(c cVar, int i, int i2) {
        if (i2 >= 0) {
            cVar.ABg.RI(i2);
        }
    }

    /* Access modifiers changed, original: protected|final|synthetic */
    public final /* synthetic */ Comparable a(com.tencent.tinker.a.a.a.a aVar) {
        return aVar.dRG();
    }
}
