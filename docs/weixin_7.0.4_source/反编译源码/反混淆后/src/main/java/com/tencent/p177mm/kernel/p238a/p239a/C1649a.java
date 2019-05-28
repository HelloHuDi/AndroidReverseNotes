package com.tencent.p177mm.kernel.p238a.p239a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1718f;
import java.util.HashSet;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;
import junit.framework.Assert;

/* renamed from: com.tencent.mm.kernel.a.a.a */
public class C1649a<T> {
    protected final ConcurrentHashMap<T, C1648a<T>> eLx = new ConcurrentHashMap();

    /* renamed from: com.tencent.mm.kernel.a.a.a$a */
    public static class C1648a<T> {
        public T eLA;
        public volatile boolean eLB = false;
        private boolean eLC = true;
        private HashSet<C1648a> eLy;
        private HashSet<C1648a> eLz;

        protected C1648a(T t) {
            this.eLA = t;
        }

        /* renamed from: Si */
        public final synchronized HashSet<C1648a> mo5107Si() {
            HashSet<C1648a> hashSet;
            AppMethodBeat.m2504i(123281);
            if (this.eLz == null) {
                hashSet = null;
                AppMethodBeat.m2505o(123281);
            } else {
                hashSet = new HashSet(this.eLz);
                AppMethodBeat.m2505o(123281);
            }
            return hashSet;
        }

        /* renamed from: Sj */
        public final synchronized HashSet<C1648a> mo5108Sj() {
            HashSet<C1648a> hashSet;
            AppMethodBeat.m2504i(123282);
            if (this.eLy == null) {
                hashSet = null;
                AppMethodBeat.m2505o(123282);
            } else {
                hashSet = new HashSet(this.eLy);
                AppMethodBeat.m2505o(123282);
            }
            return hashSet;
        }

        /* renamed from: Sk */
        public final synchronized int mo5109Sk() {
            int i;
            AppMethodBeat.m2504i(123283);
            if (this.eLy == null) {
                i = 0;
                AppMethodBeat.m2505o(123283);
            } else {
                i = this.eLy.size();
                AppMethodBeat.m2505o(123283);
            }
            return i;
        }

        /* renamed from: Sl */
        public final synchronized boolean mo5110Sl() {
            return this.eLC;
        }

        /* renamed from: Sm */
        public final synchronized void mo5111Sm() {
            AppMethodBeat.m2504i(123284);
            if (this.eLy == null || this.eLy.size() == 0) {
                this.eLC = true;
            }
            AppMethodBeat.m2505o(123284);
        }

        /* renamed from: Sn */
        public final synchronized boolean mo5112Sn() {
            boolean z;
            AppMethodBeat.m2504i(123285);
            if (this.eLy == null || this.eLy.size() <= 0) {
                z = false;
                AppMethodBeat.m2505o(123285);
            } else {
                z = true;
                AppMethodBeat.m2505o(123285);
            }
            return z;
        }

        public String toString() {
            AppMethodBeat.m2504i(123286);
            String str = "Ref-" + this.eLA.toString();
            AppMethodBeat.m2505o(123286);
            return str;
        }

        /* renamed from: a */
        public void mo5113a(C1648a c1648a) {
            AppMethodBeat.m2504i(123287);
            m3323b(c1648a);
            c1648a.m3324c(this);
            AppMethodBeat.m2505o(123287);
        }

        /* renamed from: b */
        private synchronized void m3323b(C1648a c1648a) {
            AppMethodBeat.m2504i(123288);
            this.eLC = false;
            if (this.eLy == null) {
                this.eLy = new HashSet(4);
            }
            this.eLy.add(c1648a);
            AppMethodBeat.m2505o(123288);
        }

        /* renamed from: c */
        private synchronized void m3324c(C1648a c1648a) {
            AppMethodBeat.m2504i(123289);
            if (this.eLz == null) {
                this.eLz = new HashSet(4);
            }
            this.eLz.add(c1648a);
            AppMethodBeat.m2505o(123289);
        }

        public int hashCode() {
            AppMethodBeat.m2504i(123290);
            int hashCode = this.eLA.hashCode();
            AppMethodBeat.m2505o(123290);
            return hashCode;
        }

        public boolean equals(Object obj) {
            AppMethodBeat.m2504i(123291);
            boolean equals;
            if (obj instanceof C1648a) {
                equals = this.eLA.equals(((C1648a) obj).eLA);
                AppMethodBeat.m2505o(123291);
                return equals;
            }
            equals = this.eLA.equals(obj);
            AppMethodBeat.m2505o(123291);
            return equals;
        }
    }

    public C1649a() {
        AppMethodBeat.m2504i(123292);
        AppMethodBeat.m2505o(123292);
    }

    /* Access modifiers changed, original: protected */
    /* renamed from: aE */
    public C1648a<T> mo5117aE(T t) {
        AppMethodBeat.m2504i(123293);
        if (!this.eLx.containsKey(t)) {
            this.eLx.putIfAbsent(t, new C1648a(t));
        }
        C1648a c1648a = (C1648a) this.eLx.get(t);
        AppMethodBeat.m2505o(123293);
        return c1648a;
    }

    /* renamed from: aF */
    public final C1648a<T> mo5118aF(T t) {
        AppMethodBeat.m2504i(123294);
        C1648a c1648a = (C1648a) this.eLx.get(t);
        AppMethodBeat.m2505o(123294);
        return c1648a;
    }

    /* renamed from: aG */
    public final boolean mo5119aG(T t) {
        AppMethodBeat.m2504i(123295);
        C1648a c1648a = (C1648a) this.eLx.get(t);
        if (c1648a == null || !(c1648a.mo5110Sl() || c1648a.mo5112Sn())) {
            AppMethodBeat.m2505o(123295);
            return false;
        }
        AppMethodBeat.m2505o(123295);
        return true;
    }

    /* renamed from: aH */
    private static void m3332aH(T t) {
        AppMethodBeat.m2504i(123296);
        Assert.assertNotNull("Found a null object, maybe your component isn't installedor registered.", t);
        Assert.assertFalse("Found a dummy object, maybe your component isn't installed or registered.", C1718f.m3526ay(t));
        AppMethodBeat.m2505o(123296);
    }

    /* renamed from: n */
    public final void mo5120n(T t, T t2) {
        AppMethodBeat.m2504i(123297);
        Object[] objArr = new Object[]{t, t2};
        C1649a.m3332aH(t);
        C1649a.m3332aH(t2);
        if (t == t2) {
            mo5117aE(t).mo5111Sm();
            AppMethodBeat.m2505o(123297);
            return;
        }
        mo5117aE(t).mo5113a(mo5117aE(t2));
        AppMethodBeat.m2505o(123297);
    }

    public void reset(boolean z) {
        AppMethodBeat.m2504i(123298);
        for (Entry value : this.eLx.entrySet()) {
            ((C1648a) value.getValue()).eLB = false;
        }
        AppMethodBeat.m2505o(123298);
    }
}
