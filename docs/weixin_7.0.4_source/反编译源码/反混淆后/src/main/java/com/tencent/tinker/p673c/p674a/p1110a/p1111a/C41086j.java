package com.tencent.tinker.p673c.p674a.p1110a.p1111a;

import com.tencent.tinker.p668a.p669a.C36543i;
import com.tencent.tinker.p668a.p669a.C36543i.C36544e;
import com.tencent.tinker.p668a.p669a.C41083t.C31086a;
import com.tencent.tinker.p668a.p669a.C5916n;
import com.tencent.tinker.p668a.p669a.p1365a.C46943a;
import com.tencent.tinker.p673c.p674a.p1426b.C31093a;
import com.tencent.tinker.p673c.p674a.p675c.C5920a;
import com.tencent.tinker.p673c.p674a.p675c.C7392c;

/* renamed from: com.tencent.tinker.c.a.a.a.j */
public final class C41086j extends C46815i<C5916n> {
    private C31086a AzT = null;
    private C36544e AzU = null;

    /* Access modifiers changed, original: protected|final|synthetic */
    /* renamed from: a */
    public final /* synthetic */ Comparable mo29594a(C5920a c5920a, Comparable comparable) {
        C5916n c5916n = (C5916n) comparable;
        return new C5916n(c5916n.off, c5920a.mo12573RM(c5916n.Aym), c5920a.mo12573RM(c5916n.AxA), c5920a.mo12572RL(c5916n.Ayn));
    }

    /* Access modifiers changed, original: protected|final|synthetic */
    /* renamed from: e */
    public final /* synthetic */ int mo29598e(Comparable comparable) {
        C5916n c5916n = (C5916n) comparable;
        C31086a c31086a = this.AzT;
        c31086a.size++;
        return this.AzU.mo57810a(c5916n);
    }

    public C41086j(C31093a c31093a, C36543i c36543i, C36543i c36543i2, C7392c c7392c) {
        super(c31093a, c36543i, c7392c);
        if (c36543i2 != null) {
            this.AzT = c36543i2.AxY.Ayw;
            this.AzU = c36543i2.mo57798a(this.AzT);
        }
    }

    /* Access modifiers changed, original: protected|final */
    /* renamed from: a */
    public final void mo29596a(C7392c c7392c, int i, int i2, int i3, int i4) {
        if (i != i3) {
            c7392c.AAP.put(i, i3);
        }
    }

    /* Access modifiers changed, original: protected|final */
    /* renamed from: c */
    public final C31086a mo29597c(C36543i c36543i) {
        return c36543i.AxY.Ayw;
    }

    /* Access modifiers changed, original: protected|final */
    /* renamed from: a */
    public final void mo29595a(C7392c c7392c, int i, int i2) {
        if (i >= 0) {
            c7392c.ABd.mo40758RI(i);
        }
    }

    /* Access modifiers changed, original: protected|final|synthetic */
    /* renamed from: a */
    public final /* synthetic */ Comparable mo29593a(C46943a c46943a) {
        return c46943a.dRz();
    }
}
