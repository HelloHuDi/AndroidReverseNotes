package com.tencent.tinker.p673c.p674a.p1110a.p1111a;

import com.tencent.tinker.p668a.p669a.C16312f;
import com.tencent.tinker.p668a.p669a.C36543i;
import com.tencent.tinker.p668a.p669a.C36543i.C36544e;
import com.tencent.tinker.p668a.p669a.C41083t.C31086a;
import com.tencent.tinker.p668a.p669a.p1365a.C46943a;
import com.tencent.tinker.p673c.p674a.p1426b.C31093a;
import com.tencent.tinker.p673c.p674a.p675c.C5920a;
import com.tencent.tinker.p673c.p674a.p675c.C7392c;

/* renamed from: com.tencent.tinker.c.a.a.a.f */
public final class C24431f extends C46815i<C16312f> {
    private C31086a AzN = null;
    private C36544e AzO = null;

    /* Access modifiers changed, original: protected|final|synthetic */
    /* renamed from: a */
    public final /* synthetic */ Comparable mo29594a(C5920a c5920a, Comparable comparable) {
        C16312f c16312f = (C16312f) comparable;
        return new C16312f(c16312f.off, c5920a.mo12573RM(c16312f.AxA), c16312f.Axx, c5920a.mo12573RM(c16312f.AxB), c5920a.mo12577RQ(c16312f.AxC), c5920a.mo12572RL(c16312f.AxD), c5920a.mo12581RU(c16312f.AxE), c5920a.mo12583RW(c16312f.AxF), c5920a.mo12582RV(c16312f.AxG));
    }

    /* Access modifiers changed, original: protected|final|synthetic */
    /* renamed from: e */
    public final /* synthetic */ int mo29598e(Comparable comparable) {
        C16312f c16312f = (C16312f) comparable;
        C31086a c31086a = this.AzN;
        c31086a.size++;
        return this.AzO.mo57806a(c16312f);
    }

    public C24431f(C31093a c31093a, C36543i c36543i, C36543i c36543i2, C7392c c7392c) {
        super(c31093a, c36543i, c7392c);
        if (c36543i2 != null) {
            this.AzN = c36543i2.AxY.Ayy;
            this.AzO = c36543i2.mo57798a(this.AzN);
        }
    }

    /* Access modifiers changed, original: protected|final */
    /* renamed from: c */
    public final C31086a mo29597c(C36543i c36543i) {
        return c36543i.AxY.Ayy;
    }

    /* Access modifiers changed, original: protected|final|synthetic */
    /* renamed from: a */
    public final /* synthetic */ Comparable mo29593a(C46943a c46943a) {
        return c46943a.dRC();
    }
}
