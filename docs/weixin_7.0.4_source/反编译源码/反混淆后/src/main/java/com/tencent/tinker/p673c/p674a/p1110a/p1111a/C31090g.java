package com.tencent.tinker.p673c.p674a.p1110a.p1111a;

import com.tencent.tinker.p668a.p669a.C16313g;
import com.tencent.tinker.p668a.p669a.C16313g.C16314a;
import com.tencent.tinker.p668a.p669a.C36543i;
import com.tencent.tinker.p668a.p669a.C36543i.C36544e;
import com.tencent.tinker.p668a.p669a.C41083t.C31086a;
import com.tencent.tinker.p668a.p669a.p1365a.C46943a;
import com.tencent.tinker.p673c.p674a.p1426b.C31093a;
import com.tencent.tinker.p673c.p674a.p675c.C5920a;
import com.tencent.tinker.p673c.p674a.p675c.C5926b;
import com.tencent.tinker.p673c.p674a.p675c.C7392c;

/* renamed from: com.tencent.tinker.c.a.a.a.g */
public final class C31090g extends C46815i<C16313g> {
    private C31086a AzP = null;
    private C36544e AzQ = null;

    /* Access modifiers changed, original: protected|final|synthetic */
    /* renamed from: a */
    public final /* synthetic */ Comparable mo29594a(C5920a c5920a, Comparable comparable) {
        C16314a[] c16314aArr;
        C16313g c16313g = (C16313g) comparable;
        int RX = c5920a.mo12584RX(c16313g.AxK);
        short[] sArr = c16313g.AxL;
        if (!(sArr == null || sArr.length == 0)) {
            sArr = new C5926b(c5920a).mo12598a(sArr);
        }
        C16314a[] c16314aArr2 = c16313g.AxN;
        if (c16314aArr2 == null || c16314aArr2.length == 0) {
            c16314aArr = c16314aArr2;
        } else {
            c16314aArr = new C16314a[c16314aArr2.length];
            for (int i = 0; i < c16314aArr2.length; i++) {
                C16314a c16314a = c16314aArr2[i];
                int length = c16314a.AxO.length;
                int[] iArr = new int[length];
                for (int i2 = 0; i2 < length; i2++) {
                    iArr[i2] = c5920a.mo12573RM(c16314a.AxO[i2]);
                }
                c16314aArr[i] = new C16314a(iArr, c16314a.AxP, c16314a.AxQ, c16314a.offset);
            }
        }
        return new C16313g(c16313g.off, c16313g.AxH, c16313g.AxI, c16313g.AxJ, RX, sArr, c16313g.AxM, c16314aArr);
    }

    /* Access modifiers changed, original: protected|final|synthetic */
    /* renamed from: e */
    public final /* synthetic */ int mo29598e(Comparable comparable) {
        C16313g c16313g = (C16313g) comparable;
        C31086a c31086a = this.AzP;
        c31086a.size++;
        return this.AzQ.mo57807a(c16313g);
    }

    public C31090g(C31093a c31093a, C36543i c36543i, C36543i c36543i2, C7392c c7392c) {
        super(c31093a, c36543i, c7392c);
        if (c36543i2 != null) {
            this.AzP = c36543i2.AxY.AyE;
            this.AzQ = c36543i2.mo57798a(this.AzP);
        }
    }

    /* Access modifiers changed, original: protected|final */
    /* renamed from: a */
    public final void mo29596a(C7392c c7392c, int i, int i2, int i3, int i4) {
        if (i2 != i4) {
            c7392c.AAZ.put(i2, i4);
        }
    }

    /* Access modifiers changed, original: protected|final */
    /* renamed from: c */
    public final C31086a mo29597c(C36543i c36543i) {
        return c36543i.AxY.AyE;
    }

    /* Access modifiers changed, original: protected|final */
    /* renamed from: a */
    public final void mo29595a(C7392c c7392c, int i, int i2) {
        if (i2 >= 0) {
            c7392c.ABn.mo40758RI(i2);
        }
    }

    /* Access modifiers changed, original: protected|final|synthetic */
    /* renamed from: a */
    public final /* synthetic */ Comparable mo29593a(C46943a c46943a) {
        return c46943a.dRD();
    }
}
