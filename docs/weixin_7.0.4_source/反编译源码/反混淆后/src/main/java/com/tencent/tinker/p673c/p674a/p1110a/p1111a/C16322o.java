package com.tencent.tinker.p673c.p674a.p1110a.p1111a;

import com.tencent.tinker.p668a.p669a.C36543i;
import com.tencent.tinker.p668a.p669a.C36543i.C36544e;
import com.tencent.tinker.p668a.p669a.C41083t.C31086a;
import com.tencent.tinker.p668a.p669a.p1365a.C46943a;
import com.tencent.tinker.p673c.p674a.p1426b.C31093a;
import com.tencent.tinker.p673c.p674a.p675c.C5920a;
import com.tencent.tinker.p673c.p674a.p675c.C7392c;

/* renamed from: com.tencent.tinker.c.a.a.a.o */
public final class C16322o extends C46815i<Integer> {
    private C31086a AAf = null;
    private C36544e AAg = null;

    /* Access modifiers changed, original: protected|final|synthetic */
    /* renamed from: a */
    public final /* synthetic */ Comparable mo29594a(C5920a c5920a, Comparable comparable) {
        return Integer.valueOf(c5920a.mo12572RL(((Integer) comparable).intValue()));
    }

    /* Access modifiers changed, original: protected|final|synthetic */
    /* renamed from: e */
    public final /* synthetic */ int mo29598e(Comparable comparable) {
        Integer num = (Integer) comparable;
        int position = this.AAg.aEY.position();
        this.AAg.writeInt(num.intValue());
        C31086a c31086a = this.AAf;
        c31086a.size++;
        return position;
    }

    public C16322o(C31093a c31093a, C36543i c36543i, C36543i c36543i2, C7392c c7392c) {
        super(c31093a, c36543i, c7392c);
        if (c36543i2 != null) {
            this.AAf = c36543i2.AxY.Ayu;
            this.AAg = c36543i2.mo57798a(this.AAf);
        }
    }

    /* Access modifiers changed, original: protected|final */
    /* renamed from: a */
    public final void mo29596a(C7392c c7392c, int i, int i2, int i3, int i4) {
        if (i != i3) {
            c7392c.AAN.put(i, i3);
        }
    }

    /* Access modifiers changed, original: protected|final */
    /* renamed from: c */
    public final C31086a mo29597c(C36543i c36543i) {
        return c36543i.AxY.Ayu;
    }

    /* Access modifiers changed, original: protected|final */
    /* renamed from: a */
    public final void mo29595a(C7392c c7392c, int i, int i2) {
        if (i >= 0) {
            c7392c.ABb.mo40758RI(i);
        }
    }

    /* Access modifiers changed, original: protected|final|synthetic */
    /* renamed from: a */
    public final /* synthetic */ Comparable mo29593a(C46943a c46943a) {
        return Integer.valueOf(c46943a.aEY.getInt());
    }
}
