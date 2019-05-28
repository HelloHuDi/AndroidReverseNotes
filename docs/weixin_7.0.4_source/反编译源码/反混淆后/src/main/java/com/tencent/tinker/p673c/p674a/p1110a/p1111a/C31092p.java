package com.tencent.tinker.p673c.p674a.p1110a.p1111a;

import com.tencent.tinker.p668a.p669a.C31088u;
import com.tencent.tinker.p668a.p669a.C36543i;
import com.tencent.tinker.p668a.p669a.C36543i.C36544e;
import com.tencent.tinker.p668a.p669a.C41083t.C31086a;
import com.tencent.tinker.p668a.p669a.p1365a.C46943a;
import com.tencent.tinker.p673c.p674a.p1426b.C31093a;
import com.tencent.tinker.p673c.p674a.p675c.C5920a;
import com.tencent.tinker.p673c.p674a.p675c.C7392c;

/* renamed from: com.tencent.tinker.c.a.a.a.p */
public final class C31092p extends C46815i<C31088u> {
    private C31086a AAh = null;
    private C36544e AAi = null;

    /* Access modifiers changed, original: protected|final|synthetic */
    /* renamed from: a */
    public final /* synthetic */ Comparable mo29594a(C5920a c5920a, Comparable comparable) {
        C31088u c31088u = (C31088u) comparable;
        if (c31088u == C31088u.AyQ) {
            return c31088u;
        }
        short[] sArr = new short[c31088u.AyR.length];
        for (int i = 0; i < sArr.length; i++) {
            sArr[i] = (short) c5920a.mo12573RM(c31088u.AyR[i]);
        }
        return new C31088u(c31088u.off, sArr);
    }

    /* Access modifiers changed, original: protected|final|synthetic */
    /* renamed from: e */
    public final /* synthetic */ int mo29598e(Comparable comparable) {
        C31088u c31088u = (C31088u) comparable;
        C31086a c31086a = this.AAh;
        c31086a.size++;
        return this.AAi.mo57814a(c31088u);
    }

    public C31092p(C31093a c31093a, C36543i c36543i, C36543i c36543i2, C7392c c7392c) {
        super(c31093a, c36543i, c7392c);
        if (c36543i2 != null) {
            this.AAh = c36543i2.AxY.AyA;
            this.AAi = c36543i2.mo57798a(this.AAh);
        }
    }

    /* Access modifiers changed, original: protected|final */
    /* renamed from: a */
    public final void mo29596a(C7392c c7392c, int i, int i2, int i3, int i4) {
        if (i2 != i4) {
            c7392c.AAR.put(i2, i4);
        }
    }

    /* Access modifiers changed, original: protected|final */
    /* renamed from: c */
    public final C31086a mo29597c(C36543i c36543i) {
        return c36543i.AxY.AyA;
    }

    /* Access modifiers changed, original: protected|final */
    /* renamed from: a */
    public final void mo29595a(C7392c c7392c, int i, int i2) {
        if (i2 >= 0) {
            c7392c.ABf.mo40758RI(i2);
        }
    }

    /* Access modifiers changed, original: protected|final|synthetic */
    /* renamed from: a */
    public final /* synthetic */ Comparable mo29593a(C46943a c46943a) {
        return c46943a.dRy();
    }
}
