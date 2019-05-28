package com.tencent.mm.kernel;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.b.b;
import com.tencent.mm.kernel.b.e;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.kernel.b.g;
import com.tencent.mm.kernel.c.d;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import junit.framework.Assert;

public final class c {
    public com.tencent.mm.kernel.a.a.a<Class<? extends f>> eJA = new com.tencent.mm.kernel.a.a.a();
    private d eJB = new d();
    protected a eJC;
    public Class<? extends com.tencent.mm.kernel.b.a> eJD = null;
    private com.tencent.mm.kernel.a.a eJE;
    private final ConcurrentHashMap<Class<? extends com.tencent.mm.kernel.b.a>, f> eJw = new ConcurrentHashMap();
    private final ArrayList<f> eJx = new ArrayList();
    private final ConcurrentHashMap<Class<? extends f>, ArrayList<Class<? extends com.tencent.mm.kernel.b.a>>> eJy = new ConcurrentHashMap();
    private final ConcurrentHashMap<Class<? extends com.tencent.mm.kernel.b.a>, Class<? extends f>> eJz = new ConcurrentHashMap();

    public interface a {
        void b(f fVar);

        void b(com.tencent.mm.kernel.c.a aVar);

        void c(f fVar);

        void c(com.tencent.mm.kernel.c.a aVar);

        void d(com.tencent.mm.kernel.c.a aVar);
    }

    public c() {
        AppMethodBeat.i(123231);
        AppMethodBeat.o(123231);
    }

    public final synchronized f I(Class<? extends f> cls) {
        f a;
        AppMethodBeat.i(123232);
        a = a((Class) cls, false);
        AppMethodBeat.o(123232);
        return a;
    }

    private synchronized f a(Class<? extends f> cls, boolean z) {
        f fVar;
        AppMethodBeat.i(123233);
        Assert.assertNotNull(cls);
        try {
            fVar = (f) cls.newInstance();
            if (z) {
                fVar.markAsPendingPlugin();
            }
            fVar = a(fVar);
            AppMethodBeat.o(123233);
        } catch (Exception e) {
            j.printErrStackTrace("MMSkeleton.CorePlugins", e, "Install plugin %s failed.", cls);
            fVar = null;
            AppMethodBeat.o(123233);
        }
        return fVar;
    }

    public final synchronized f lH(String str) {
        f u;
        AppMethodBeat.i(123234);
        u = u(str, false);
        AppMethodBeat.o(123234);
        return u;
    }

    public final synchronized f u(String str, boolean z) {
        f a;
        AppMethodBeat.i(123235);
        try {
            Class cls = Class.forName(str);
            if (f.class.isAssignableFrom(cls)) {
                a = a(cls, z);
                AppMethodBeat.o(123235);
            } else {
                j.e("MMSkeleton.CorePlugins", "class string %s, not a Plugin", str);
                a = null;
                AppMethodBeat.o(123235);
            }
        } catch (ClassNotFoundException e) {
            j.e("MMSkeleton.CorePlugins", "plugin %s not found.", str);
            h.RT().RM();
            new Object[1][0] = str;
            j.RU();
        }
        return a;
    }

    private synchronized f a(f fVar) {
        f fVar2;
        AppMethodBeat.i(123236);
        if (J(fVar.getClass())) {
            j.w("MMSkeleton.CorePlugins", "Plugin %s has been installed.", fVar.getClass());
            fVar2 = (f) N(fVar.getClass());
            AppMethodBeat.o(123236);
        } else {
            Assert.assertNotNull(fVar);
            String[] ofProcesses = fVar.ofProcesses();
            if (ofProcesses != null && ofProcesses.length > 0) {
                g Rn = h.RT().RM().Rn();
                boolean z = false;
                for (String lQ : ofProcesses) {
                    z = Rn.lQ(lQ);
                    if (z) {
                        break;
                    }
                }
                if (!z) {
                    IllegalStateException illegalStateException = new IllegalStateException(String.format("Plugin %s can't install in process %s. It only support process %s.", new Object[]{fVar, Rn.eHT, Arrays.asList(ofProcesses)}));
                    AppMethodBeat.o(123236);
                    throw illegalStateException;
                }
            }
            this.eJw.put(fVar.getClass(), fVar);
            this.eJx.add(fVar);
            fVar.invokeInstalled();
            if (this.eJC != null) {
                this.eJC.b(fVar);
            }
            AppMethodBeat.o(123236);
            fVar2 = fVar;
        }
        return fVar2;
    }

    public final synchronized boolean J(Class<? extends com.tencent.mm.kernel.b.a> cls) {
        boolean containsKey;
        AppMethodBeat.i(123237);
        containsKey = this.eJw.containsKey(cls);
        AppMethodBeat.o(123237);
        return containsKey;
    }

    public final synchronized void k(Class<? extends f> cls, Class<? extends com.tencent.mm.kernel.b.a> cls2) {
        AppMethodBeat.i(123238);
        Assert.assertNotNull(cls);
        Assert.assertNotNull(cls2);
        f fVar = (f) this.eJw.get(cls);
        Assert.assertNotNull(fVar);
        ArrayList arrayList = (ArrayList) this.eJy.get(cls);
        if (arrayList == null) {
            arrayList = new ArrayList();
            this.eJy.put(cls, arrayList);
        }
        this.eJz.put(cls2, cls);
        arrayList.add(cls2);
        this.eJw.put(cls2, fVar);
        AppMethodBeat.o(123238);
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x0035  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0052  */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x004a  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final <T extends com.tencent.mm.kernel.c.a> T K(Class<T> cls) {
        T U;
        AppMethodBeat.i(123239);
        T U2 = this.eJB.U(cls);
        if (U2 == null) {
            int i;
            if (cls != null) {
                e eVar = (e) cls.getAnnotation(e.class);
                if (!(eVar == null || eVar.value() == null)) {
                    com.tencent.mm.kernel.b.a M = M(eVar.value());
                    i = (M == null || f.ay(M)) ? 0 : 1;
                    if (i != 0) {
                        j.i("MMSkeleton.CorePlugins", "Try load OwnerPlugin for service(%s)...", cls);
                        U = this.eJB.U(cls);
                        if (U == null) {
                            AppMethodBeat.o(123239);
                            return U;
                        }
                        h.RT().RM();
                        new Object[1][0] = cls;
                        j.RU();
                        com.tencent.mm.kernel.c.a aVar = (com.tencent.mm.kernel.c.a) f.P(cls);
                        AppMethodBeat.o(123239);
                        return aVar;
                    }
                }
            }
            i = 0;
            if (i != 0) {
            }
        }
        U = U2;
        if (U == null) {
        }
    }

    public final <T extends com.tencent.mm.kernel.c.a, N extends T> void a(Class<T> cls, com.tencent.mm.kernel.c.c<N> cVar) {
        AppMethodBeat.i(123240);
        this.eJB.b(cls, cVar);
        AppMethodBeat.o(123240);
    }

    public final void L(Class<? extends com.tencent.mm.kernel.c.a> cls) {
        AppMethodBeat.i(123241);
        this.eJB.L(cls);
        AppMethodBeat.o(123241);
    }

    public final synchronized <T extends com.tencent.mm.kernel.b.a> T M(Class<T> cls) {
        T t;
        AppMethodBeat.i(123242);
        T N = N(cls);
        if (this.eJC != null) {
            this.eJC.c((f) N);
        }
        if (N == null) {
            t = (com.tencent.mm.kernel.b.a) f.P(cls);
        } else {
            t = N;
        }
        AppMethodBeat.o(123242);
        return t;
    }

    private synchronized <T extends com.tencent.mm.kernel.b.a> T N(Class<T> cls) {
        com.tencent.mm.kernel.b.a aVar;
        AppMethodBeat.i(123243);
        Assert.assertNotNull(cls);
        aVar = (com.tencent.mm.kernel.b.a) this.eJw.get(cls);
        AppMethodBeat.o(123243);
        return aVar;
    }

    private synchronized boolean O(Class<? extends com.tencent.mm.kernel.b.a> cls) {
        boolean z = false;
        synchronized (this) {
            AppMethodBeat.i(123244);
            Assert.assertNotNull(cls);
            if (J(cls)) {
                z = true;
                AppMethodBeat.o(123244);
            } else {
                j.w("MMSkeleton.CorePlugins", "Plugin " + cls + " must be installed!", new Object[0]);
                AppMethodBeat.o(123244);
            }
        }
        return z;
    }

    public final void l(Class<? extends f> cls, Class<? extends com.tencent.mm.kernel.b.a> cls2) {
        AppMethodBeat.i(123245);
        Assert.assertNotNull(cls);
        Assert.assertNotNull(cls2);
        if (O(cls2)) {
            Object cls22;
            if (this.eJz.containsKey(cls22)) {
                cls22 = (Class) this.eJz.get(cls22);
            }
            this.eJA.n(cls, cls22);
            if (this.eJE == null) {
                this.eJE = h.RT().RM().Rn().eJE;
            }
            f fVar = (f) N(cls);
            f fVar2 = (f) N(cls22);
            this.eJE.eKM.a(b.class, fVar, fVar2);
            this.eJE.eKM.a(com.tencent.mm.kernel.a.c.b.class, fVar, fVar2);
            AppMethodBeat.o(123245);
            return;
        }
        String format = String.format("depends plugin %s not install, plugin %s will not add in to dependency tree", new Object[]{cls22.getName(), cls.getName()});
        j.e("MMSkeleton.CorePlugins", format, new Object[0]);
        IllegalAccessError illegalAccessError = new IllegalAccessError(format);
        AppMethodBeat.o(123245);
        throw illegalAccessError;
    }

    public final synchronized void Rl() {
        AppMethodBeat.i(123246);
        Iterator it = this.eJx.iterator();
        while (it.hasNext()) {
            f fVar = (f) it.next();
            if (fVar.isDependencyMade()) {
                com.tencent.mm.kernel.a.a.k("skip make dependency for plugin %s.", fVar);
            } else {
                com.tencent.mm.kernel.a.a.k("make dependency for plugin %s...", fVar);
                fVar.invokeDependency();
            }
        }
        AppMethodBeat.o(123246);
    }

    public final synchronized List<f> Rm() {
        return this.eJx;
    }
}
