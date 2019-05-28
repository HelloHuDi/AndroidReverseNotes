package com.tencent.tinker.p673c.p674a.p1110a.p1111a;

import com.tencent.tinker.p668a.p669a.C36543i;
import com.tencent.tinker.p668a.p669a.C36543i.C36544e;
import com.tencent.tinker.p668a.p669a.C41083t.C31086a;
import com.tencent.tinker.p668a.p669a.C46810c;
import com.tencent.tinker.p668a.p669a.p1365a.C46943a;
import com.tencent.tinker.p673c.p674a.p1426b.C31093a;
import com.tencent.tinker.p673c.p674a.p675c.C5920a;
import com.tencent.tinker.p673c.p674a.p675c.C7392c;

/* renamed from: com.tencent.tinker.c.a.a.a.b */
public final class C44550b extends C46815i<C46810c> {
    private C31086a AzF = null;
    private C36544e AzG = null;

    /* Access modifiers changed, original: protected|final|synthetic */
    /* renamed from: a */
    public final /* synthetic */ Comparable mo29594a(C5920a c5920a, Comparable comparable) {
        C46810c c46810c = (C46810c) comparable;
        int length = c46810c.Axn.length;
        int[] iArr = new int[length];
        for (int i = 0; i < length; i++) {
            iArr[i] = c5920a.mo12579RS(c46810c.Axn[i]);
        }
        return new C46810c(c46810c.off, iArr);
    }

    /* Access modifiers changed, original: protected|final|synthetic */
    /* renamed from: e */
    public final /* synthetic */ int mo29598e(Comparable comparable) {
        C46810c c46810c = (C46810c) comparable;
        C31086a c31086a = this.AzF;
        c31086a.size++;
        return this.AzG.mo57803a(c46810c);
    }

    public C44550b(C31093a c31093a, C36543i c36543i, C36543i c36543i2, C7392c c7392c) {
        super(c31093a, c36543i, c7392c);
        if (c36543i2 != null) {
            this.AzF = c36543i2.AxY.AyB;
            this.AzG = c36543i2.mo57798a(this.AzF);
        }
    }

    /* Access modifiers changed, original: protected|final */
    /* renamed from: a */
    public final void mo29596a(C7392c c7392c, int i, int i2, int i3, int i4) {
        if (i2 != i4) {
            c7392c.AAU.put(i2, i4);
        }
    }

    /* Access modifiers changed, original: protected|final */
    /* renamed from: c */
    public final C31086a mo29597c(C36543i c36543i) {
        return c36543i.AxY.AyB;
    }

    /* Access modifiers changed, original: protected|final */
    /* renamed from: a */
    public final void mo29595a(C7392c c7392c, int i, int i2) {
        if (i2 >= 0) {
            c7392c.ABi.mo40758RI(i2);
        }
    }

    /* Access modifiers changed, original: protected|final|synthetic */
    /* renamed from: a */
    public final /* synthetic */ Comparable mo29593a(C46943a c46943a) {
        return c46943a.dRI();
    }
}
