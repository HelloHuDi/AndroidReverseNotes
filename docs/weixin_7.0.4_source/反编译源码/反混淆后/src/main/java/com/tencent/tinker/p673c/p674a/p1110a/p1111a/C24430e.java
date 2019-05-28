package com.tencent.tinker.p673c.p674a.p1110a.p1111a;

import com.tencent.tinker.p668a.p669a.C36543i;
import com.tencent.tinker.p668a.p669a.C36543i.C36544e;
import com.tencent.tinker.p668a.p669a.C41083t.C31086a;
import com.tencent.tinker.p668a.p669a.C5914e;
import com.tencent.tinker.p668a.p669a.p1365a.C46943a;
import com.tencent.tinker.p673c.p674a.p1426b.C31093a;
import com.tencent.tinker.p673c.p674a.p675c.C5920a;
import com.tencent.tinker.p673c.p674a.p675c.C7392c;

/* renamed from: com.tencent.tinker.c.a.a.a.e */
public final class C24430e extends C46815i<C5914e> {
    private C31086a AzL = null;
    private C36544e AzM = null;

    /* Access modifiers changed, original: protected|final|synthetic */
    /* renamed from: a */
    public final /* synthetic */ Comparable mo29594a(C5920a c5920a, Comparable comparable) {
        C5914e c5914e = (C5914e) comparable;
        return new C5914e(c5914e.off, c5920a.mo12586b(c5914e.Axs), c5920a.mo12586b(c5914e.Axt), c5920a.mo12587b(c5914e.Axu), c5920a.mo12587b(c5914e.Axv));
    }

    /* Access modifiers changed, original: protected|final|synthetic */
    /* renamed from: e */
    public final /* synthetic */ int mo29598e(Comparable comparable) {
        C5914e c5914e = (C5914e) comparable;
        C31086a c31086a = this.AzL;
        c31086a.size++;
        return this.AzM.mo57805a(c5914e);
    }

    public C24430e(C31093a c31093a, C36543i c36543i, C36543i c36543i2, C7392c c7392c) {
        super(c31093a, c36543i, c7392c);
        if (c36543i2 != null) {
            this.AzL = c36543i2.AxY.AyD;
            this.AzM = c36543i2.mo57798a(this.AzL);
        }
    }

    /* Access modifiers changed, original: protected|final */
    /* renamed from: a */
    public final void mo29596a(C7392c c7392c, int i, int i2, int i3, int i4) {
        if (i2 != i4) {
            c7392c.AAX.put(i2, i4);
        }
    }

    /* Access modifiers changed, original: protected|final */
    /* renamed from: c */
    public final C31086a mo29597c(C36543i c36543i) {
        return c36543i.AxY.AyD;
    }

    /* Access modifiers changed, original: protected|final */
    /* renamed from: a */
    public final void mo29595a(C7392c c7392c, int i, int i2) {
        if (i2 >= 0) {
            c7392c.ABl.mo40758RI(i2);
        }
    }

    /* Access modifiers changed, original: protected|final|synthetic */
    /* renamed from: a */
    public final /* synthetic */ Comparable mo29593a(C46943a c46943a) {
        return c46943a.dRF();
    }
}
