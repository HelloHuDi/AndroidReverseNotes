package com.tencent.p177mm.kernel.p238a.p240b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1736j;
import com.tencent.p177mm.kernel.p238a.p239a.C1649a.C1648a;
import com.tencent.p177mm.kernel.p238a.p239a.C1650b;
import com.tencent.p177mm.kernel.p238a.p240b.C1654a.C1652a;
import com.tencent.p177mm.kernel.p238a.p240b.C1654a.C1653b;
import com.tencent.p177mm.kernel.p238a.p240b.C6597f.C6596a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;

/* renamed from: com.tencent.mm.kernel.a.b.g */
public final class C6598g implements C1650b, C1656c<Object>, C1657d<Object> {
    private Map<Class<?>, C6597f<Object>> eMe = new ConcurrentHashMap();
    private Class<?>[] eMf;
    public volatile Class<?>[] eMg;
    public Map<Class, Object> eMh = new ConcurrentHashMap();
    private int eMi = 0;
    private Queue<C6596a> eMj = new ConcurrentLinkedQueue();
    private ConcurrentHashMap<Object, C1664a> eMk = new ConcurrentHashMap();

    /* renamed from: com.tencent.mm.kernel.a.b.g$a */
    static class C1664a {
        byte[] eMl;

        private C1664a() {
            AppMethodBeat.m2504i(123344);
            this.eMl = new byte[1];
            AppMethodBeat.m2505o(123344);
        }

        /* synthetic */ C1664a(byte b) {
            this();
        }

        /* Access modifiers changed, original: final */
        /* renamed from: SE */
        public final boolean mo5146SE() {
            boolean z = false;
            synchronized (this.eMl) {
                if (this.eMl[0] == (byte) 2) {
                    z = true;
                }
            }
            return z;
        }
    }

    public C6598g() {
        AppMethodBeat.m2504i(123345);
        AppMethodBeat.m2505o(123345);
    }

    /* renamed from: a */
    public final void mo14815a(Class... clsArr) {
        int i = 0;
        AppMethodBeat.m2504i(123346);
        this.eMf = new Class[clsArr.length];
        System.arraycopy(clsArr, 0, this.eMf, 0, clsArr.length);
        while (i < this.eMf.length) {
            this.eMe.put(this.eMf[i], new C6597f(this.eMf[i], this, this));
            i++;
        }
        AppMethodBeat.m2505o(123346);
    }

    /* renamed from: R */
    private boolean m10869R(Class cls) {
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

    /* renamed from: SC */
    public final Map<C6597f, List<C1648a>> mo14813SC() {
        AppMethodBeat.m2504i(123347);
        HashMap hashMap = new HashMap();
        for (C6597f c6597f : this.eMe.values()) {
            List Sw = c6597f.mo14809Sw();
            if (Sw.size() > 0) {
                hashMap.put(c6597f, Sw);
            }
        }
        AppMethodBeat.m2505o(123347);
        return hashMap;
    }

    /* renamed from: S */
    public final <T> C6597f<T> mo14812S(Class<T> cls) {
        AppMethodBeat.m2504i(123348);
        C6597f c6597f = (C6597f) this.eMe.get(cls);
        AppMethodBeat.m2505o(123348);
        return c6597f;
    }

    /* renamed from: b */
    public final void mo14818b(Class cls, boolean z) {
        AppMethodBeat.m2504i(123349);
        int min = Math.min(m10870T(cls), this.eMf.length - 1);
        if (min >= 0 && this.eMi > min) {
            for (int i = min; i < this.eMi; i++) {
                mo14812S(this.eMf[i]).reset(z);
            }
            this.eMi = min;
        }
        AppMethodBeat.m2505o(123349);
    }

    public final void prepare() {
        int i;
        AppMethodBeat.m2504i(123350);
        C1736j.m3587i("MicroMsg.ParallelsManagement", "prepare()", new Object[0]);
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
                    AppMethodBeat.m2505o(123350);
                }
            }
        }
        if (i != -1) {
            mo14812S(this.eMf[i]).prepare();
        }
        AppMethodBeat.m2505o(123350);
    }

    /* renamed from: SD */
    public final void mo14814SD() {
        AppMethodBeat.m2504i(123351);
        while (true) {
            synchronized (this.eMf) {
                try {
                    if (this.eMf.length <= this.eMi) {
                        break;
                    }
                } finally {
                    while (true) {
                    }
                    AppMethodBeat.m2505o(123351);
                }
            }
            prepare();
        }
    }

    /* renamed from: T */
    private int m10870T(Class cls) {
        for (int i = 0; i < this.eMf.length; i++) {
            if (this.eMf[i] == cls) {
                return i;
            }
        }
        return -1;
    }

    /* renamed from: Sp */
    public final C6596a mo5131Sp() {
        C6596a c6596a;
        AppMethodBeat.m2504i(123352);
        synchronized (this.eMj) {
            try {
                c6596a = (C6596a) this.eMj.poll();
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(123352);
            }
        }
        return c6596a;
    }

    /* renamed from: a */
    public final void mo5132a(C6596a c6596a) {
        AppMethodBeat.m2504i(123353);
        C4990ab.m7417i("MicroMsg.ParallelsManagement", "ParallelsManagement resolvedOne %s for type %s then next %s", c6596a, c6596a.eMa.eLE, c6596a.eMa.eMn);
        mo14812S(c6596a.eMa.eLE).mo5132a(c6596a);
        if (c6596a.eMa.eMn != null) {
            mo14812S(c6596a.eMa.eMn).mo14811aL(c6596a);
        }
        AppMethodBeat.m2505o(123353);
    }

    /* renamed from: b */
    public final void mo5135b(C6596a<Object> c6596a) {
        AppMethodBeat.m2504i(123354);
        synchronized (this.eMj) {
            try {
                this.eMj.offer(c6596a);
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(123354);
            }
        }
        C4990ab.m7411d("MicroMsg.ParallelsManagement", "ParallelsManagement provideOne %s %s", c6596a, c6596a.eMa.eLE);
    }

    /* renamed from: a */
    public final void mo5122a(Class cls, Object obj, Object obj2) {
        AppMethodBeat.m2504i(123355);
        if (m10869R(cls)) {
            C6597f S = mo14812S(cls);
            if (S != null) {
                S.mo5120n(obj, obj2);
            }
            AppMethodBeat.m2505o(123355);
            return;
        }
        C1736j.m3590w("MicroMsg.ParallelsManagement", "Not allow phase(%s) has dependency", cls);
        AppMethodBeat.m2505o(123355);
    }

    /* renamed from: aM */
    public final boolean mo14816aM(Object obj) {
        AppMethodBeat.m2504i(123356);
        C1664a c1664a = (C1664a) this.eMk.get(obj);
        if (c1664a == null || !c1664a.mo5146SE()) {
            AppMethodBeat.m2505o(123356);
            return false;
        }
        AppMethodBeat.m2505o(123356);
        return true;
    }

    /* renamed from: aN */
    public final void mo14817aN(Object obj) {
        int i = 0;
        AppMethodBeat.m2504i(123357);
        if (!this.eMk.containsKey(obj)) {
            this.eMk.putIfAbsent(obj, new C1664a());
        }
        C1664a c1664a = (C1664a) this.eMk.get(obj);
        synchronized (c1664a.eMl) {
            try {
                if (c1664a.eMl[0] == (byte) 2) {
                } else {
                    if (c1664a.eMl[0] == (byte) 1) {
                        try {
                            c1664a.eMl.wait();
                        } catch (InterruptedException e) {
                        }
                    } else {
                        c1664a.eMl[0] = (byte) 1;
                    }
                }
            } finally {
                AppMethodBeat.m2505o(123357);
            }
        }
        if (c1664a.mo5146SE()) {
            C1736j.m3587i("MicroMsg.ParallelsManagement", "%s Has done. return.", obj);
            return;
        }
        Class cls;
        C1736j.m3584d("MicroMsg.ParallelsManagement", "Make dependency on subject(%s), hashcode(%s)", obj, Integer.valueOf(obj.hashCode()));
        if (obj instanceof C1655b) {
            C1654a.start();
            ((C1655b) obj).parallelsDependency();
            C1653b So = C1654a.m3348So();
            if (So.f1232cS != null) {
                for (C1652a c1652a : So.f1232cS.values()) {
                    for (Object next : c1652a.eLF) {
                        if (mo14812S(c1652a.eLE).mo5118aF(next) == null) {
                            C1736j.m3587i("MicroMsg.ParallelsManagement", "Traversal make dependency for %s by subject(%s)", next, obj);
                            mo14817aN(next);
                        }
                        mo5122a(c1652a.eLE, obj, next);
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
        C6596a c6596a = null;
        C6596a c6596a2 = null;
        while (i < clsArr.length) {
            Class cls3 = clsArr[i];
            if (i < clsArr.length - 1) {
                cls2 = clsArr[i + 1];
            } else {
                cls2 = null;
            }
            C6596a c = c6596a != null ? c6596a : m10871c(cls3, obj);
            if (cls2 != null) {
                c6596a = m10871c(cls2, obj);
            } else {
                c6596a = null;
            }
            c.eLY = c6596a2;
            c.eLZ = c6596a;
            if (c6596a2 != null) {
                c.eMa.eMm = c6596a2.eMa.eLE;
            }
            if (c6596a != null) {
                c.eMa.eMn = c6596a.eMa.eLE;
            }
            i++;
            c6596a2 = c;
        }
        synchronized (c1664a.eMl) {
            try {
                if (c1664a.eMl[0] == (byte) 1) {
                    c1664a.eMl[0] = (byte) 2;
                    c1664a.eMl.notifyAll();
                }
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(123357);
            }
        }
    }

    /* renamed from: c */
    private C6596a m10871c(Class cls, Object obj) {
        AppMethodBeat.m2504i(123358);
        C6597f S = mo14812S(cls);
        C6596a c6596a = (C6596a) S.mo5118aF(obj);
        C4990ab.m7411d("MicroMsg.ParallelsManagement", "makeDependency on IDependency of type %s for %s with %s", cls, obj, S);
        if (c6596a == null) {
            Object obj2 = this.eMh.get(cls);
            if (obj2 == null) {
                obj2 = obj;
            }
            S.mo5120n(obj, obj2);
            c6596a = (C6596a) S.mo5118aF(obj);
        }
        AppMethodBeat.m2505o(123358);
        return c6596a;
    }
}
