package com.tencent.p177mm.p213cd.p214a;

import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p213cd.p214a.C7595f.C1355a;
import java.util.ArrayList;

/* renamed from: com.tencent.mm.cd.a.g */
public abstract class C37631g<K, T extends C1351a> {
    public C1354d ycB;

    /* renamed from: com.tencent.mm.cd.a.g$1 */
    class C376301 implements C1355a {
        C376301() {
        }

        public final C1351a dvz() {
            AppMethodBeat.m2504i(59205);
            C1351a dvB = C37631g.this.dvB();
            AppMethodBeat.m2505o(59205);
            return dvB;
        }

        /* renamed from: ao */
        public final ArrayList<C1351a> mo4725ao(ArrayList<Object> arrayList) {
            AppMethodBeat.m2504i(59206);
            ArrayList ao = C37631g.this.mo60456ao(arrayList);
            AppMethodBeat.m2505o(59206);
            return ao;
        }
    }

    /* renamed from: ao */
    public abstract ArrayList<T> mo60456ao(ArrayList<Object> arrayList);

    public abstract T dvB();

    public C37631g(C1354d c1354d, int i) {
        this.ycB = c1354d;
        this.ycB.mo4724pt(true);
        this.ycB.mo4717a(new C376301());
        if (i != 0) {
            this.ycB.mo4716MH(i);
        }
        getCount();
    }

    public final void close() {
        this.ycB.close();
        this.ycB = null;
    }

    public final int getCount() {
        return this.ycB.getCount();
    }

    public final boolean isClosed() {
        return this.ycB.isClosed();
    }

    public final boolean dvr() {
        return this.ycB.dvr();
    }

    /* renamed from: c */
    public final void mo60457c(Object obj, T t) {
        this.ycB.mo4718a(obj, t);
    }

    public final SparseArray<K>[] dvp() {
        return this.ycB.dvp();
    }

    /* renamed from: cK */
    public final boolean mo60458cK(Object obj) {
        return this.ycB.mo4719cK(obj);
    }
}
