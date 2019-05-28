package com.tencent.mm.kernel.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.f;
import java.util.HashSet;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;
import junit.framework.Assert;

public class a<T> {
    protected final ConcurrentHashMap<T, a<T>> eLx = new ConcurrentHashMap();

    public static class a<T> {
        public T eLA;
        public volatile boolean eLB = false;
        private boolean eLC = true;
        private HashSet<a> eLy;
        private HashSet<a> eLz;

        protected a(T t) {
            this.eLA = t;
        }

        public final synchronized HashSet<a> Si() {
            HashSet<a> hashSet;
            AppMethodBeat.i(123281);
            if (this.eLz == null) {
                hashSet = null;
                AppMethodBeat.o(123281);
            } else {
                hashSet = new HashSet(this.eLz);
                AppMethodBeat.o(123281);
            }
            return hashSet;
        }

        public final synchronized HashSet<a> Sj() {
            HashSet<a> hashSet;
            AppMethodBeat.i(123282);
            if (this.eLy == null) {
                hashSet = null;
                AppMethodBeat.o(123282);
            } else {
                hashSet = new HashSet(this.eLy);
                AppMethodBeat.o(123282);
            }
            return hashSet;
        }

        public final synchronized int Sk() {
            int i;
            AppMethodBeat.i(123283);
            if (this.eLy == null) {
                i = 0;
                AppMethodBeat.o(123283);
            } else {
                i = this.eLy.size();
                AppMethodBeat.o(123283);
            }
            return i;
        }

        public final synchronized boolean Sl() {
            return this.eLC;
        }

        public final synchronized void Sm() {
            AppMethodBeat.i(123284);
            if (this.eLy == null || this.eLy.size() == 0) {
                this.eLC = true;
            }
            AppMethodBeat.o(123284);
        }

        public final synchronized boolean Sn() {
            boolean z;
            AppMethodBeat.i(123285);
            if (this.eLy == null || this.eLy.size() <= 0) {
                z = false;
                AppMethodBeat.o(123285);
            } else {
                z = true;
                AppMethodBeat.o(123285);
            }
            return z;
        }

        public String toString() {
            AppMethodBeat.i(123286);
            String str = "Ref-" + this.eLA.toString();
            AppMethodBeat.o(123286);
            return str;
        }

        public void a(a aVar) {
            AppMethodBeat.i(123287);
            b(aVar);
            aVar.c(this);
            AppMethodBeat.o(123287);
        }

        private synchronized void b(a aVar) {
            AppMethodBeat.i(123288);
            this.eLC = false;
            if (this.eLy == null) {
                this.eLy = new HashSet(4);
            }
            this.eLy.add(aVar);
            AppMethodBeat.o(123288);
        }

        private synchronized void c(a aVar) {
            AppMethodBeat.i(123289);
            if (this.eLz == null) {
                this.eLz = new HashSet(4);
            }
            this.eLz.add(aVar);
            AppMethodBeat.o(123289);
        }

        public int hashCode() {
            AppMethodBeat.i(123290);
            int hashCode = this.eLA.hashCode();
            AppMethodBeat.o(123290);
            return hashCode;
        }

        public boolean equals(Object obj) {
            AppMethodBeat.i(123291);
            boolean equals;
            if (obj instanceof a) {
                equals = this.eLA.equals(((a) obj).eLA);
                AppMethodBeat.o(123291);
                return equals;
            }
            equals = this.eLA.equals(obj);
            AppMethodBeat.o(123291);
            return equals;
        }
    }

    public a() {
        AppMethodBeat.i(123292);
        AppMethodBeat.o(123292);
    }

    /* Access modifiers changed, original: protected */
    public a<T> aE(T t) {
        AppMethodBeat.i(123293);
        if (!this.eLx.containsKey(t)) {
            this.eLx.putIfAbsent(t, new a(t));
        }
        a aVar = (a) this.eLx.get(t);
        AppMethodBeat.o(123293);
        return aVar;
    }

    public final a<T> aF(T t) {
        AppMethodBeat.i(123294);
        a aVar = (a) this.eLx.get(t);
        AppMethodBeat.o(123294);
        return aVar;
    }

    public final boolean aG(T t) {
        AppMethodBeat.i(123295);
        a aVar = (a) this.eLx.get(t);
        if (aVar == null || !(aVar.Sl() || aVar.Sn())) {
            AppMethodBeat.o(123295);
            return false;
        }
        AppMethodBeat.o(123295);
        return true;
    }

    private static void aH(T t) {
        AppMethodBeat.i(123296);
        Assert.assertNotNull("Found a null object, maybe your component isn't installedor registered.", t);
        Assert.assertFalse("Found a dummy object, maybe your component isn't installed or registered.", f.ay(t));
        AppMethodBeat.o(123296);
    }

    public final void n(T t, T t2) {
        AppMethodBeat.i(123297);
        Object[] objArr = new Object[]{t, t2};
        aH(t);
        aH(t2);
        if (t == t2) {
            aE(t).Sm();
            AppMethodBeat.o(123297);
            return;
        }
        aE(t).a(aE(t2));
        AppMethodBeat.o(123297);
    }

    public void reset(boolean z) {
        AppMethodBeat.i(123298);
        for (Entry value : this.eLx.entrySet()) {
            ((a) value.getValue()).eLB = false;
        }
        AppMethodBeat.o(123298);
    }
}
