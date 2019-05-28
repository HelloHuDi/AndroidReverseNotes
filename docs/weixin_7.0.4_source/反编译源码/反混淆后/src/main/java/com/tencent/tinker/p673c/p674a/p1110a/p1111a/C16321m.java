package com.tencent.tinker.p673c.p674a.p1110a.p1111a;

import com.tencent.tinker.p668a.p669a.C36543i;
import com.tencent.tinker.p668a.p669a.C36543i.C36544e;
import com.tencent.tinker.p668a.p669a.C41083t.C31086a;
import com.tencent.tinker.p668a.p669a.C44545k;
import com.tencent.tinker.p668a.p669a.C5915m;
import com.tencent.tinker.p668a.p669a.p1365a.C46943a;
import com.tencent.tinker.p673c.p674a.p1426b.C31093a;
import com.tencent.tinker.p673c.p674a.p675c.C5920a;
import com.tencent.tinker.p673c.p674a.p675c.C5920a.C59223;
import com.tencent.tinker.p673c.p674a.p675c.C5920a.C5923a;
import com.tencent.tinker.p673c.p674a.p675c.C7392c;
import java.io.ByteArrayOutputStream;

/* renamed from: com.tencent.tinker.c.a.a.a.m */
public final class C16321m extends C46815i<C44545k> {
    private C36544e AAa = null;
    private C31086a AzZ = null;

    /* Access modifiers changed, original: protected|final|synthetic */
    /* renamed from: a */
    public final /* synthetic */ Comparable mo29594a(C5920a c5920a, Comparable comparable) {
        C44545k c44545k = (C44545k) comparable;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(c44545k.data.length);
        new C5923a(new C59223(byteArrayOutputStream)).mo12590c(new C5915m(c44545k, 28));
        return new C44545k(c44545k.off, byteArrayOutputStream.toByteArray());
    }

    /* Access modifiers changed, original: protected|final|synthetic */
    /* renamed from: e */
    public final /* synthetic */ int mo29598e(Comparable comparable) {
        C44545k c44545k = (C44545k) comparable;
        C31086a c31086a = this.AzZ;
        c31086a.size++;
        return this.AAa.mo57809a(c44545k);
    }

    public C16321m(C31093a c31093a, C36543i c36543i, C36543i c36543i2, C7392c c7392c) {
        super(c31093a, c36543i, c7392c);
        if (c36543i2 != null) {
            this.AzZ = c36543i2.AxY.AyI;
            this.AAa = c36543i2.mo57798a(this.AzZ);
        }
    }

    /* Access modifiers changed, original: protected|final */
    /* renamed from: a */
    public final void mo29596a(C7392c c7392c, int i, int i2, int i3, int i4) {
        if (i2 != i4) {
            c7392c.AAW.put(i2, i4);
        }
    }

    /* Access modifiers changed, original: protected|final */
    /* renamed from: c */
    public final C31086a mo29597c(C36543i c36543i) {
        return c36543i.AxY.AyI;
    }

    /* Access modifiers changed, original: protected|final */
    /* renamed from: a */
    public final void mo29595a(C7392c c7392c, int i, int i2) {
        if (i2 >= 0) {
            c7392c.ABk.mo40758RI(i2);
        }
    }

    /* Access modifiers changed, original: protected|final|synthetic */
    /* renamed from: a */
    public final /* synthetic */ Comparable mo29593a(C46943a c46943a) {
        return c46943a.dRK();
    }
}
