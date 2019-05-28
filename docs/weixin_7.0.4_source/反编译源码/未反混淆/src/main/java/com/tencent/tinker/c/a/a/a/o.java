package com.tencent.tinker.c.a.a.a;

import com.tencent.tinker.a.a.i;
import com.tencent.tinker.a.a.i.e;
import com.tencent.tinker.a.a.t.a;
import com.tencent.tinker.c.a.c.c;

public final class o extends i<Integer> {
    private a AAf = null;
    private e AAg = null;

    /* Access modifiers changed, original: protected|final|synthetic */
    public final /* synthetic */ Comparable a(com.tencent.tinker.c.a.c.a aVar, Comparable comparable) {
        return Integer.valueOf(aVar.RL(((Integer) comparable).intValue()));
    }

    /* Access modifiers changed, original: protected|final|synthetic */
    public final /* synthetic */ int e(Comparable comparable) {
        Integer num = (Integer) comparable;
        int position = this.AAg.aEY.position();
        this.AAg.writeInt(num.intValue());
        a aVar = this.AAf;
        aVar.size++;
        return position;
    }

    public o(com.tencent.tinker.c.a.b.a aVar, i iVar, i iVar2, c cVar) {
        super(aVar, iVar, cVar);
        if (iVar2 != null) {
            this.AAf = iVar2.AxY.Ayu;
            this.AAg = iVar2.a(this.AAf);
        }
    }

    /* Access modifiers changed, original: protected|final */
    public final void a(c cVar, int i, int i2, int i3, int i4) {
        if (i != i3) {
            cVar.AAN.put(i, i3);
        }
    }

    /* Access modifiers changed, original: protected|final */
    public final a c(i iVar) {
        return iVar.AxY.Ayu;
    }

    /* Access modifiers changed, original: protected|final */
    public final void a(c cVar, int i, int i2) {
        if (i >= 0) {
            cVar.ABb.RI(i);
        }
    }

    /* Access modifiers changed, original: protected|final|synthetic */
    public final /* synthetic */ Comparable a(com.tencent.tinker.a.a.a.a aVar) {
        return Integer.valueOf(aVar.aEY.getInt());
    }
}
