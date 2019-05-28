package com.tencent.p177mm.kernel;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.p238a.C1651a;
import com.tencent.p177mm.kernel.p238a.p239a.C1649a;
import com.tencent.p177mm.kernel.p238a.p715c.C6609b;
import com.tencent.p177mm.kernel.p241b.C1677a;
import com.tencent.p177mm.kernel.p241b.C1678b;
import com.tencent.p177mm.kernel.p241b.C1679e;
import com.tencent.p177mm.kernel.p241b.C1681g;
import com.tencent.p177mm.kernel.p241b.C7597f;
import com.tencent.p177mm.kernel.p242c.C1694a;
import com.tencent.p177mm.kernel.p242c.C1696c;
import com.tencent.p177mm.kernel.p242c.C1698d;
import com.tencent.p177mm.kernel.p242c.C1698d.C1697a;
import com.tencent.p177mm.kernel.p242c.C6625e;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import junit.framework.Assert;

/* renamed from: com.tencent.mm.kernel.c */
public final class C1699c {
    public C1649a<Class<? extends C7597f>> eJA = new C1649a();
    private C1698d eJB = new C1698d();
    protected C1693a eJC;
    public Class<? extends C1677a> eJD = null;
    private C1651a eJE;
    private final ConcurrentHashMap<Class<? extends C1677a>, C7597f> eJw = new ConcurrentHashMap();
    private final ArrayList<C7597f> eJx = new ArrayList();
    private final ConcurrentHashMap<Class<? extends C7597f>, ArrayList<Class<? extends C1677a>>> eJy = new ConcurrentHashMap();
    private final ConcurrentHashMap<Class<? extends C1677a>, Class<? extends C7597f>> eJz = new ConcurrentHashMap();

    /* renamed from: com.tencent.mm.kernel.c$a */
    public interface C1693a {
        /* renamed from: b */
        void mo5197b(C7597f c7597f);

        /* renamed from: b */
        void mo5198b(C1694a c1694a);

        /* renamed from: c */
        void mo5199c(C7597f c7597f);

        /* renamed from: c */
        void mo5200c(C1694a c1694a);

        /* renamed from: d */
        void mo5201d(C1694a c1694a);
    }

    /* renamed from: com.tencent.mm.kernel.c$1 */
    class C17001 implements C1697a {
        C17001() {
        }

        /* renamed from: a */
        public final void mo5206a(C1696c c1696c) {
            AppMethodBeat.m2504i(123228);
            if ((c1696c instanceof C6625e) && C1699c.this.eJC != null) {
                C1699c.this.eJC.mo5198b(c1696c.mo5204SJ());
            }
            AppMethodBeat.m2505o(123228);
        }

        /* renamed from: b */
        public final void mo5207b(C1696c c1696c) {
            AppMethodBeat.m2504i(123229);
            if ((c1696c instanceof C6625e) && C1699c.this.eJC != null) {
                C1699c.this.eJC.mo5200c(c1696c.mo5204SJ());
            }
            AppMethodBeat.m2505o(123229);
        }

        /* renamed from: a */
        public final void mo5205a(C1694a c1694a) {
            AppMethodBeat.m2504i(123230);
            if (C1699c.this.eJC != null) {
                C1699c.this.eJC.mo5201d(c1694a);
            }
            AppMethodBeat.m2505o(123230);
        }
    }

    public C1699c() {
        AppMethodBeat.m2504i(123231);
        AppMethodBeat.m2505o(123231);
    }

    /* renamed from: I */
    public final synchronized C7597f mo5212I(Class<? extends C7597f> cls) {
        C7597f a;
        AppMethodBeat.m2504i(123232);
        a = m3466a((Class) cls, false);
        AppMethodBeat.m2505o(123232);
        return a;
    }

    /* renamed from: a */
    private synchronized C7597f m3466a(Class<? extends C7597f> cls, boolean z) {
        C7597f c7597f;
        AppMethodBeat.m2504i(123233);
        Assert.assertNotNull(cls);
        try {
            c7597f = (C7597f) cls.newInstance();
            if (z) {
                c7597f.markAsPendingPlugin();
            }
            c7597f = m3465a(c7597f);
            AppMethodBeat.m2505o(123233);
        } catch (Exception e) {
            C1736j.printErrStackTrace("MMSkeleton.CorePlugins", e, "Install plugin %s failed.", cls);
            c7597f = null;
            AppMethodBeat.m2505o(123233);
        }
        return c7597f;
    }

    /* renamed from: lH */
    public final synchronized C7597f mo5222lH(String str) {
        C7597f u;
        AppMethodBeat.m2504i(123234);
        u = mo5223u(str, false);
        AppMethodBeat.m2505o(123234);
        return u;
    }

    /* renamed from: u */
    public final synchronized C7597f mo5223u(String str, boolean z) {
        C7597f a;
        AppMethodBeat.m2504i(123235);
        try {
            Class cls = Class.forName(str);
            if (C7597f.class.isAssignableFrom(cls)) {
                a = m3466a(cls, z);
                AppMethodBeat.m2505o(123235);
            } else {
                C1736j.m3585e("MMSkeleton.CorePlugins", "class string %s, not a Plugin", str);
                a = null;
                AppMethodBeat.m2505o(123235);
            }
        } catch (ClassNotFoundException e) {
            C1736j.m3585e("MMSkeleton.CorePlugins", "plugin %s not found.", str);
            C1728h.m3566RT().mo5266RM();
            new Object[1][0] = str;
            C1736j.m3582RU();
        }
        return a;
    }

    /* renamed from: a */
    private synchronized C7597f m3465a(C7597f c7597f) {
        C7597f c7597f2;
        AppMethodBeat.m2504i(123236);
        if (mo5213J(c7597f.getClass())) {
            C1736j.m3590w("MMSkeleton.CorePlugins", "Plugin %s has been installed.", c7597f.getClass());
            c7597f2 = (C7597f) m3463N(c7597f.getClass());
            AppMethodBeat.m2505o(123236);
        } else {
            Assert.assertNotNull(c7597f);
            String[] ofProcesses = c7597f.ofProcesses();
            if (ofProcesses != null && ofProcesses.length > 0) {
                C1681g Rn = C1728h.m3566RT().mo5266RM().mo5224Rn();
                boolean z = false;
                for (String lQ : ofProcesses) {
                    z = Rn.mo5183lQ(lQ);
                    if (z) {
                        break;
                    }
                }
                if (!z) {
                    IllegalStateException illegalStateException = new IllegalStateException(String.format("Plugin %s can't install in process %s. It only support process %s.", new Object[]{c7597f, Rn.eHT, Arrays.asList(ofProcesses)}));
                    AppMethodBeat.m2505o(123236);
                    throw illegalStateException;
                }
            }
            this.eJw.put(c7597f.getClass(), c7597f);
            this.eJx.add(c7597f);
            c7597f.invokeInstalled();
            if (this.eJC != null) {
                this.eJC.mo5197b(c7597f);
            }
            AppMethodBeat.m2505o(123236);
            c7597f2 = c7597f;
        }
        return c7597f2;
    }

    /* renamed from: J */
    public final synchronized boolean mo5213J(Class<? extends C1677a> cls) {
        boolean containsKey;
        AppMethodBeat.m2504i(123237);
        containsKey = this.eJw.containsKey(cls);
        AppMethodBeat.m2505o(123237);
        return containsKey;
    }

    /* renamed from: k */
    public final synchronized void mo5220k(Class<? extends C7597f> cls, Class<? extends C1677a> cls2) {
        AppMethodBeat.m2504i(123238);
        Assert.assertNotNull(cls);
        Assert.assertNotNull(cls2);
        C7597f c7597f = (C7597f) this.eJw.get(cls);
        Assert.assertNotNull(c7597f);
        ArrayList arrayList = (ArrayList) this.eJy.get(cls);
        if (arrayList == null) {
            arrayList = new ArrayList();
            this.eJy.put(cls, arrayList);
        }
        this.eJz.put(cls2, cls);
        arrayList.add(cls2);
        this.eJw.put(cls2, c7597f);
        AppMethodBeat.m2505o(123238);
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x0035  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0052  */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x004a  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: K */
    public final <T extends C1694a> T mo5214K(Class<T> cls) {
        T U;
        AppMethodBeat.m2504i(123239);
        T U2 = this.eJB.mo5209U(cls);
        if (U2 == null) {
            int i;
            if (cls != null) {
                C1679e c1679e = (C1679e) cls.getAnnotation(C1679e.class);
                if (!(c1679e == null || c1679e.value() == null)) {
                    C1677a M = mo5216M(c1679e.value());
                    i = (M == null || C1718f.m3526ay(M)) ? 0 : 1;
                    if (i != 0) {
                        C1736j.m3587i("MMSkeleton.CorePlugins", "Try load OwnerPlugin for service(%s)...", cls);
                        U = this.eJB.mo5209U(cls);
                        if (U == null) {
                            AppMethodBeat.m2505o(123239);
                            return U;
                        }
                        C1728h.m3566RT().mo5266RM();
                        new Object[1][0] = cls;
                        C1736j.m3582RU();
                        C1694a c1694a = (C1694a) C1718f.m3524P(cls);
                        AppMethodBeat.m2505o(123239);
                        return c1694a;
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

    /* renamed from: a */
    public final <T extends C1694a, N extends T> void mo5219a(Class<T> cls, C1696c<N> c1696c) {
        AppMethodBeat.m2504i(123240);
        this.eJB.mo5211b(cls, c1696c);
        AppMethodBeat.m2505o(123240);
    }

    /* renamed from: L */
    public final void mo5215L(Class<? extends C1694a> cls) {
        AppMethodBeat.m2504i(123241);
        this.eJB.mo5208L(cls);
        AppMethodBeat.m2505o(123241);
    }

    /* renamed from: M */
    public final synchronized <T extends C1677a> T mo5216M(Class<T> cls) {
        T t;
        AppMethodBeat.m2504i(123242);
        T N = m3463N(cls);
        if (this.eJC != null) {
            this.eJC.mo5199c((C7597f) N);
        }
        if (N == null) {
            t = (C1677a) C1718f.m3524P(cls);
        } else {
            t = N;
        }
        AppMethodBeat.m2505o(123242);
        return t;
    }

    /* renamed from: N */
    private synchronized <T extends C1677a> T m3463N(Class<T> cls) {
        C1677a c1677a;
        AppMethodBeat.m2504i(123243);
        Assert.assertNotNull(cls);
        c1677a = (C1677a) this.eJw.get(cls);
        AppMethodBeat.m2505o(123243);
        return c1677a;
    }

    /* renamed from: O */
    private synchronized boolean m3464O(Class<? extends C1677a> cls) {
        boolean z = false;
        synchronized (this) {
            AppMethodBeat.m2504i(123244);
            Assert.assertNotNull(cls);
            if (mo5213J(cls)) {
                z = true;
                AppMethodBeat.m2505o(123244);
            } else {
                C1736j.m3590w("MMSkeleton.CorePlugins", "Plugin " + cls + " must be installed!", new Object[0]);
                AppMethodBeat.m2505o(123244);
            }
        }
        return z;
    }

    /* renamed from: l */
    public final void mo5221l(Class<? extends C7597f> cls, Class<? extends C1677a> cls2) {
        AppMethodBeat.m2504i(123245);
        Assert.assertNotNull(cls);
        Assert.assertNotNull(cls2);
        if (m3464O(cls2)) {
            Object cls22;
            if (this.eJz.containsKey(cls22)) {
                cls22 = (Class) this.eJz.get(cls22);
            }
            this.eJA.mo5120n(cls, cls22);
            if (this.eJE == null) {
                this.eJE = C1728h.m3566RT().mo5266RM().mo5224Rn().eJE;
            }
            C7597f c7597f = (C7597f) m3463N(cls);
            C7597f c7597f2 = (C7597f) m3463N(cls22);
            this.eJE.eKM.mo5122a(C1678b.class, c7597f, c7597f2);
            this.eJE.eKM.mo5122a(C6609b.class, c7597f, c7597f2);
            AppMethodBeat.m2505o(123245);
            return;
        }
        String format = String.format("depends plugin %s not install, plugin %s will not add in to dependency tree", new Object[]{cls22.getName(), cls.getName()});
        C1736j.m3585e("MMSkeleton.CorePlugins", format, new Object[0]);
        IllegalAccessError illegalAccessError = new IllegalAccessError(format);
        AppMethodBeat.m2505o(123245);
        throw illegalAccessError;
    }

    /* renamed from: Rl */
    public final synchronized void mo5217Rl() {
        AppMethodBeat.m2504i(123246);
        Iterator it = this.eJx.iterator();
        while (it.hasNext()) {
            C7597f c7597f = (C7597f) it.next();
            if (c7597f.isDependencyMade()) {
                C1651a.m3339k("skip make dependency for plugin %s.", c7597f);
            } else {
                C1651a.m3339k("make dependency for plugin %s...", c7597f);
                c7597f.invokeDependency();
            }
        }
        AppMethodBeat.m2505o(123246);
    }

    /* renamed from: Rm */
    public final synchronized List<C7597f> mo5218Rm() {
        return this.eJx;
    }
}
