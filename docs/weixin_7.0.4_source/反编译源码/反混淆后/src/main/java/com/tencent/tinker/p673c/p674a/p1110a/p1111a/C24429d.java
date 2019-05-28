package com.tencent.tinker.p673c.p674a.p1110a.p1111a;

import com.tencent.tinker.p668a.p669a.C16311d;
import com.tencent.tinker.p668a.p669a.C36543i;
import com.tencent.tinker.p668a.p669a.C36543i.C36544e;
import com.tencent.tinker.p668a.p669a.C41083t.C31086a;
import com.tencent.tinker.p668a.p669a.p1365a.C46943a;
import com.tencent.tinker.p673c.p674a.p1426b.C31093a;
import com.tencent.tinker.p673c.p674a.p675c.C5920a;
import com.tencent.tinker.p673c.p674a.p675c.C7392c;
import java.lang.reflect.Array;

/* renamed from: com.tencent.tinker.c.a.a.a.d */
public final class C24429d extends C46815i<C16311d> {
    private C31086a AzJ = null;
    private C36544e AzK = null;

    /* Access modifiers changed, original: protected|final|synthetic */
    /* renamed from: a */
    public final /* synthetic */ Comparable mo29594a(C5920a c5920a, Comparable comparable) {
        int i;
        C16311d c16311d = (C16311d) comparable;
        int RS = c5920a.mo12579RS(c16311d.Axo);
        int[][] iArr = (int[][]) Array.newInstance(Integer.TYPE, new int[]{c16311d.Axp.length, 2});
        for (i = 0; i < iArr.length; i++) {
            iArr[i][0] = c5920a.mo12575RO(c16311d.Axp[i][0]);
            iArr[i][1] = c5920a.mo12579RS(c16311d.Axp[i][1]);
        }
        int[][] iArr2 = (int[][]) Array.newInstance(Integer.TYPE, new int[]{c16311d.Axq.length, 2});
        for (i = 0; i < iArr2.length; i++) {
            iArr2[i][0] = c5920a.mo12576RP(c16311d.Axq[i][0]);
            iArr2[i][1] = c5920a.mo12579RS(c16311d.Axq[i][1]);
        }
        int[][] iArr3 = (int[][]) Array.newInstance(Integer.TYPE, new int[]{c16311d.Axr.length, 2});
        for (i = 0; i < iArr3.length; i++) {
            iArr3[i][0] = c5920a.mo12576RP(c16311d.Axr[i][0]);
            iArr3[i][1] = c5920a.mo12580RT(c16311d.Axr[i][1]);
        }
        return new C16311d(c16311d.off, RS, iArr, iArr2, iArr3);
    }

    /* Access modifiers changed, original: protected|final|synthetic */
    /* renamed from: e */
    public final /* synthetic */ int mo29598e(Comparable comparable) {
        C16311d c16311d = (C16311d) comparable;
        C31086a c31086a = this.AzJ;
        c31086a.size++;
        return this.AzK.mo57804a(c16311d);
    }

    public C24429d(C31093a c31093a, C36543i c36543i, C36543i c36543i2, C7392c c7392c) {
        super(c31093a, c36543i, c7392c);
        if (c36543i2 != null) {
            this.AzJ = c36543i2.AxY.AyJ;
            this.AzK = c36543i2.mo57798a(this.AzJ);
        }
    }

    /* Access modifiers changed, original: protected|final */
    /* renamed from: a */
    public final void mo29596a(C7392c c7392c, int i, int i2, int i3, int i4) {
        if (i2 != i4) {
            c7392c.AAV.put(i2, i4);
        }
    }

    /* Access modifiers changed, original: protected|final */
    /* renamed from: c */
    public final C31086a mo29597c(C36543i c36543i) {
        return c36543i.AxY.AyJ;
    }

    /* Access modifiers changed, original: protected|final */
    /* renamed from: a */
    public final void mo29595a(C7392c c7392c, int i, int i2) {
        if (i2 >= 0) {
            c7392c.ABj.mo40758RI(i2);
        }
    }

    /* Access modifiers changed, original: protected|final|synthetic */
    /* renamed from: a */
    public final /* synthetic */ Comparable mo29593a(C46943a c46943a) {
        return c46943a.dRJ();
    }
}
