package com.tencent.mm.kernel.a.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.a.a.b;
import com.tencent.mm.kernel.j;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;

public final class g implements b, c<Object>, d<Object> {
    private Map<Class<?>, f<Object>> eMe = new ConcurrentHashMap();
    private Class<?>[] eMf;
    public volatile Class<?>[] eMg;
    public Map<Class, Object> eMh = new ConcurrentHashMap();
    private int eMi = 0;
    private Queue<com.tencent.mm.kernel.a.b.f.a> eMj = new ConcurrentLinkedQueue();
    private ConcurrentHashMap<Object, a> eMk = new ConcurrentHashMap();

    static class a {
        byte[] eMl;

        private a() {
            AppMethodBeat.i(123344);
            this.eMl = new byte[1];
            AppMethodBeat.o(123344);
        }

        /* synthetic */ a(byte b) {
            this();
        }

        /* Access modifiers changed, original: final */
        public final boolean SE() {
            boolean z = false;
            synchronized (this.eMl) {
                if (this.eMl[0] == (byte) 2) {
                    z = true;
                }
            }
            return z;
        }
    }

    public g() {
        AppMethodBeat.i(123345);
        AppMethodBeat.o(123345);
    }

    public final void a(Class... clsArr) {
        int i = 0;
        AppMethodBeat.i(123346);
        this.eMf = new Class[clsArr.length];
        System.arraycopy(clsArr, 0, this.eMf, 0, clsArr.length);
        while (i < this.eMf.length) {
            this.eMe.put(this.eMf[i], new f(this.eMf[i], this, this));
            i++;
        }
        AppMethodBeat.o(123346);
    }

    private boolean R(Class cls) {
        if (this.eMg == null) {
            return true;
        }
        for (Class cls2 : this.eMg) {
            if (cls2 == cls) {
                return true;
            }
        }
        return false;
    }

    public final Map<f, List<com.tencent.mm.kernel.a.a.a.a>> SC() {
        AppMethodBeat.i(123347);
        HashMap hashMap = new HashMap();
        for (f fVar : this.eMe.values()) {
            List Sw = fVar.Sw();
            if (Sw.size() > 0) {
                hashMap.put(fVar, Sw);
            }
        }
        AppMethodBeat.o(123347);
        return hashMap;
    }

    public final <T> f<T> S(Class<T> cls) {
        AppMethodBeat.i(123348);
        f fVar = (f) this.eMe.get(cls);
        AppMethodBeat.o(123348);
        return fVar;
    }

    public final void b(Class cls, boolean z) {
        AppMethodBeat.i(123349);
        int min = Math.min(T(cls), this.eMf.length - 1);
        if (min >= 0 && this.eMi > min) {
            for (int i = min; i < this.eMi; i++) {
                S(this.eMf[i]).reset(z);
            }
            this.eMi = min;
        }
        AppMethodBeat.o(123349);
    }

    public final void prepare() {
        int i;
        AppMethodBeat.i(123350);
        j.i("MicroMsg.ParallelsManagement", "prepare()", new Object[0]);
        synchronized (this.eMf) {
            try {
                if (this.eMf.length > this.eMi) {
                    i = this.eMi;
                    this.eMi++;
                } else {
                    i = -1;
                }
            } catch (Throwable th) {
                while (true) {
                    AppMethodBeat.o(123350);
                }
            }
        }
        if (i != -1) {
            S(this.eMf[i]).prepare();
        }
        AppMethodBeat.o(123350);
    }

    public final void SD() {
        AppMethodBeat.i(123351);
        while (true) {
            synchronized (this.eMf) {
                try {
                    if (this.eMf.length <= this.eMi) {
                        break;
                    }
                } finally {
                    while (true) {
                    }
                    AppMethodBeat.o(123351);
                }
            }
            prepare();
        }
    }

    private int T(Class cls) {
        for (int i = 0; i < this.eMf.length; i++) {
            if (this.eMf[i] == cls) {
                return i;
            }
        }
        return -1;
    }

    public final com.tencent.mm.kernel.a.b.f.a Sp() {
        com.tencent.mm.kernel.a.b.f.a aVar;
        AppMethodBeat.i(123352);
        synchronized (this.eMj) {
            try {
                aVar = (com.tencent.mm.kernel.a.b.f.a) this.eMj.poll();
            } finally {
                while (true) {
                }
                AppMethodBeat.o(123352);
            }
        }
        return aVar;
    }

    public final void a(com.tencent.mm.kernel.a.b.f.a aVar) {
        AppMethodBeat.i(123353);
        ab.i("MicroMsg.ParallelsManagement", "ParallelsManagement resolvedOne %s for type %s then next %s", aVar, aVar.eMa.eLE, aVar.eMa.eMn);
        S(aVar.eMa.eLE).a(aVar);
        if (aVar.eMa.eMn != null) {
            S(aVar.eMa.eMn).aL(aVar);
        }
        AppMethodBeat.o(123353);
    }

    public final void b(com.tencent.mm.kernel.a.b.f.a<Object> aVar) {
        AppMethodBeat.i(123354);
        synchronized (this.eMj) {
            try {
                this.eMj.offer(aVar);
            } finally {
                while (true) {
                }
                AppMethodBeat.o(123354);
            }
        }
        ab.d("MicroMsg.ParallelsManagement", "ParallelsManagement provideOne %s %s", aVar, aVar.eMa.eLE);
    }

    public final void a(Class cls, Object obj, Object obj2) {
        AppMethodBeat.i(123355);
        if (R(cls)) {
            f S = S(cls);
            if (S != null) {
                S.n(obj, obj2);
            }
            AppMethodBeat.o(123355);
            return;
        }
        j.w("MicroMsg.ParallelsManagement", "Not allow phase(%s) has dependency", cls);
        AppMethodBeat.o(123355);
    }

    public final boolean aM(Object obj) {
        AppMethodBeat.i(123356);
        a aVar = (a) this.eMk.get(obj);
        if (aVar == null || !aVar.SE()) {
            AppMethodBeat.o(123356);
            return false;
        }
        AppMethodBeat.o(123356);
        return true;
    }

    public final void aN(Object obj) {
        int i = 0;
        AppMethodBeat.i(123357);
        if (!this.eMk.containsKey(obj)) {
            this.eMk.putIfAbsent(obj, new a());
        }
        a aVar = (a) this.eMk.get(obj);
        synchronized (aVar.eMl) {
            try {
                if (aVar.eMl[0] == (byte) 2) {
                } else {
                    if (aVar.eMl[0] == (byte) 1) {
                        try {
                            aVar.eMl.wait();
                        } catch (InterruptedException e) {
                        }
                    } else {
                        aVar.eMl[0] = (byte) 1;
                    }
                }
            } finally {
                AppMethodBeat.o(123357);
            }
        }
        if (aVar.SE()) {
            j.i("MicroMsg.ParallelsManagement", "%s Has done. return.", obj);
            return;
        }
        Class cls;
        j.d("MicroMsg.ParallelsManagement", "Make dependency on subject(%s), hashcode(%s)", obj, Integer.valueOf(obj.hashCode()));
        if (obj instanceof b) {
            a.start();
            ((b) obj).parallelsDependency();
            b So = a.So();
            if (So.cS != null) {
                for (com.tencent.mm.kernel.a.b.a.a aVar2 : So.cS.values()) {
                    for (Object next : aVar2.eLF) {
                        if (S(aVar2.eLE).aF(next) == null) {
                            j.i("MicroMsg.ParallelsManagement", "Traversal make dependency for %s by subject(%s)", next, obj);
                            aN(next);
                        }
                        a(aVar2.eLE, obj, next);
                    }
                }
            }
        }
        ArrayList arrayList = new ArrayList();
        for (Class cls2 : this.eMf) {
            if (cls2.isInstance(obj)) {
                arrayList.add(cls2);
            }
        }
        Class[] clsArr = (Class[]) arrayList.toArray(new Class[0]);
        com.tencent.mm.kernel.a.b.f.a aVar3 = null;
        com.tencent.mm.kernel.a.b.f.a aVar4 = null;
        while (i < clsArr.length) {
            Class cls3 = clsArr[i];
            if (i < clsArr.length - 1) {
                cls2 = clsArr[i + 1];
            } else {
                cls2 = null;
            }
            com.tencent.mm.kernel.a.b.f.a c = aVar3 != null ? aVar3 : c(cls3, obj);
            if (cls2 != null) {
                aVar3 = c(cls2, obj);
            } else {
                aVar3 = null;
            }
            c.eLY = aVar4;
            c.eLZ = aVar3;
            if (aVar4 != null) {
                c.eMa.eMm = aVar4.eMa.eLE;
            }
            if (aVar3 != null) {
                c.eMa.eMn = aVar3.eMa.eLE;
            }
            i++;
            aVar4 = c;
        }
        synchronized (aVar.eMl) {
            try {
                if (aVar.eMl[0] == (byte) 1) {
                    aVar.eMl[0] = (byte) 2;
                    aVar.eMl.notifyAll();
                }
            } finally {
                while (true) {
                }
                AppMethodBeat.o(123357);
            }
        }
    }

    private com.tencent.mm.kernel.a.b.f.a c(Class cls, Object obj) {
        AppMethodBeat.i(123358);
        f S = S(cls);
        com.tencent.mm.kernel.a.b.f.a aVar = (com.tencent.mm.kernel.a.b.f.a) S.aF(obj);
        ab.d("MicroMsg.ParallelsManagement", "makeDependency on IDependency of type %s for %s with %s", cls, obj, S);
        if (aVar == null) {
            Object obj2 = this.eMh.get(cls);
            if (obj2 == null) {
                obj2 = obj;
            }
            S.n(obj, obj2);
            aVar = (com.tencent.mm.kernel.a.b.f.a) S.aF(obj);
        }
        AppMethodBeat.o(123358);
        return aVar;
    }
}
