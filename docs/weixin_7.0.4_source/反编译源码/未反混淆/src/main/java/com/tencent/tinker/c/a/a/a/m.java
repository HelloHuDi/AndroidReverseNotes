package com.tencent.tinker.c.a.a.a;

import com.tencent.tinker.a.a.i;
import com.tencent.tinker.a.a.i.e;
import com.tencent.tinker.a.a.k;
import com.tencent.tinker.a.a.t.a;
import com.tencent.tinker.c.a.c.a.AnonymousClass3;
import com.tencent.tinker.c.a.c.c;
import java.io.ByteArrayOutputStream;

public final class m extends i<k> {
    private e AAa = null;
    private a AzZ = null;

    /* Access modifiers changed, original: protected|final|synthetic */
    public final /* synthetic */ Comparable a(com.tencent.tinker.c.a.c.a aVar, Comparable comparable) {
        k kVar = (k) comparable;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(kVar.data.length);
        new com.tencent.tinker.c.a.c.a.a(new AnonymousClass3(byteArrayOutputStream)).c(new com.tencent.tinker.a.a.m(kVar, 28));
        return new k(kVar.off, byteArrayOutputStream.toByteArray());
    }

    /* Access modifiers changed, original: protected|final|synthetic */
    public final /* synthetic */ int e(Comparable comparable) {
        k kVar = (k) comparable;
        a aVar = this.AzZ;
        aVar.size++;
        return this.AAa.a(kVar);
    }

    public m(com.tencent.tinker.c.a.b.a aVar, i iVar, i iVar2, c cVar) {
        super(aVar, iVar, cVar);
        if (iVar2 != null) {
            this.AzZ = iVar2.AxY.AyI;
            this.AAa = iVar2.a(this.AzZ);
        }
    }

    /* Access modifiers changed, original: protected|final */
    public final void a(c cVar, int i, int i2, int i3, int i4) {
        if (i2 != i4) {
            cVar.AAW.put(i2, i4);
        }
    }

    /* Access modifiers changed, original: protected|final */
    public final a c(i iVar) {
        return iVar.AxY.AyI;
    }

    /* Access modifiers changed, original: protected|final */
    public final void a(c cVar, int i, int i2) {
        if (i2 >= 0) {
            cVar.ABk.RI(i2);
        }
    }

    /* Access modifiers changed, original: protected|final|synthetic */
    public final /* synthetic */ Comparable a(com.tencent.tinker.a.a.a.a aVar) {
        return aVar.dRK();
    }
}
