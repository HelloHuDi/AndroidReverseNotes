package com.tencent.tinker.p673c.p674a.p1110a.p1111a;

import com.tencent.tinker.p668a.p669a.C36543i;
import com.tencent.tinker.p668a.p669a.C36543i.C36544e;
import com.tencent.tinker.p668a.p669a.C41083t.C31086a;
import com.tencent.tinker.p668a.p669a.C44546s;
import com.tencent.tinker.p668a.p669a.p1365a.C46943a;
import com.tencent.tinker.p673c.p674a.p1426b.C31093a;
import com.tencent.tinker.p673c.p674a.p675c.C7392c;

/* renamed from: com.tencent.tinker.c.a.a.a.n */
public final class C31091n extends C46815i<C44546s> {
    private C31086a AAb = null;
    private C31086a AAc = null;
    private C36544e AAd = null;
    private C36544e AAe = null;

    /* Access modifiers changed, original: protected|final|synthetic */
    /* renamed from: e */
    public final /* synthetic */ int mo29598e(Comparable comparable) {
        int a = this.AAd.mo57813a((C44546s) comparable);
        this.AAe.writeInt(a);
        C31086a c31086a = this.AAb;
        c31086a.size++;
        c31086a = this.AAc;
        c31086a.size++;
        return a;
    }

    public C31091n(C31093a c31093a, C36543i c36543i, C36543i c36543i2, C7392c c7392c) {
        super(c31093a, c36543i, c7392c);
        if (c36543i2 != null) {
            this.AAb = c36543i2.AxY.AyF;
            this.AAc = c36543i2.AxY.Ayt;
            this.AAd = c36543i2.mo57798a(this.AAb);
            this.AAe = c36543i2.mo57798a(this.AAc);
        }
    }

    /* Access modifiers changed, original: protected|final */
    /* renamed from: a */
    public final void mo29596a(C7392c c7392c, int i, int i2, int i3, int i4) {
        if (i != i3) {
            c7392c.AAM.put(i, i3);
        }
    }

    /* Access modifiers changed, original: protected|final */
    /* renamed from: c */
    public final C31086a mo29597c(C36543i c36543i) {
        return c36543i.AxY.AyF;
    }

    /* Access modifiers changed, original: protected|final */
    /* renamed from: a */
    public final void mo29595a(C7392c c7392c, int i, int i2) {
        if (i >= 0) {
            c7392c.ABa.mo40758RI(i);
        }
    }

    /* Access modifiers changed, original: protected|final|synthetic */
    /* renamed from: a */
    public final /* synthetic */ Comparable mo29593a(C46943a c46943a) {
        return c46943a.dRx();
    }
}
