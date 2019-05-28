package com.tencent.tinker.c.a.a.a;

import com.tencent.tinker.a.a.i;
import com.tencent.tinker.a.a.i.e;
import com.tencent.tinker.a.a.s;
import com.tencent.tinker.a.a.t.a;
import com.tencent.tinker.c.a.c.c;

public final class n extends i<s> {
    private a AAb = null;
    private a AAc = null;
    private e AAd = null;
    private e AAe = null;

    /* Access modifiers changed, original: protected|final|synthetic */
    public final /* synthetic */ int e(Comparable comparable) {
        int a = this.AAd.a((s) comparable);
        this.AAe.writeInt(a);
        a aVar = this.AAb;
        aVar.size++;
        aVar = this.AAc;
        aVar.size++;
        return a;
    }

    public n(com.tencent.tinker.c.a.b.a aVar, i iVar, i iVar2, c cVar) {
        super(aVar, iVar, cVar);
        if (iVar2 != null) {
            this.AAb = iVar2.AxY.AyF;
            this.AAc = iVar2.AxY.Ayt;
            this.AAd = iVar2.a(this.AAb);
            this.AAe = iVar2.a(this.AAc);
        }
    }

    /* Access modifiers changed, original: protected|final */
    public final void a(c cVar, int i, int i2, int i3, int i4) {
        if (i != i3) {
            cVar.AAM.put(i, i3);
        }
    }

    /* Access modifiers changed, original: protected|final */
    public final a c(i iVar) {
        return iVar.AxY.AyF;
    }

    /* Access modifiers changed, original: protected|final */
    public final void a(c cVar, int i, int i2) {
        if (i >= 0) {
            cVar.ABa.RI(i);
        }
    }

    /* Access modifiers changed, original: protected|final|synthetic */
    public final /* synthetic */ Comparable a(com.tencent.tinker.a.a.a.a aVar) {
        return aVar.dRx();
    }
}
