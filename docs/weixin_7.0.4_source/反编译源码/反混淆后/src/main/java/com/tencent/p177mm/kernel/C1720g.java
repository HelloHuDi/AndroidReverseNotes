package com.tencent.p177mm.kernel;

import android.app.Application;
import android.os.SystemClock;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1668a.C1647b;
import com.tencent.p177mm.kernel.C1682b.C1691a;
import com.tencent.p177mm.kernel.C1699c.C1693a;
import com.tencent.p177mm.kernel.C1736j.C1735a;
import com.tencent.p177mm.kernel.api.C1670b;
import com.tencent.p177mm.kernel.api.C1671c;
import com.tencent.p177mm.kernel.api.C1672d;
import com.tencent.p177mm.kernel.api.C1673e;
import com.tencent.p177mm.kernel.api.C1674f;
import com.tencent.p177mm.kernel.api.C1675g;
import com.tencent.p177mm.kernel.p238a.C6610c;
import com.tencent.p177mm.kernel.p241b.C1677a;
import com.tencent.p177mm.kernel.p241b.C6624h;
import com.tencent.p177mm.kernel.p241b.C7597f;
import com.tencent.p177mm.kernel.p242c.C1694a;
import com.tencent.p177mm.kernel.p242c.C1696c;
import com.tencent.p177mm.kernel.p242c.C6625e;
import com.tencent.p177mm.model.C1841cc;
import com.tencent.p177mm.p178a.C1183p;
import com.tencent.p177mm.p183ai.C6300p;
import com.tencent.p177mm.p183ai.C6300p.C1213a;
import com.tencent.p177mm.p212cc.C1349b;
import com.tencent.p177mm.p217ci.C6454a;
import com.tencent.p177mm.p217ci.C6454a.C1387a;
import com.tencent.p177mm.sdk.p604g.C7305d;
import com.tencent.p177mm.sdk.p604g.p605a.C4941c.C4940a;
import com.tencent.p177mm.sdk.p604g.p607c.C4960c;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import com.tencent.p177mm.sdk.platformtools.C5004al.C5003b;
import com.tencent.p177mm.sdk.platformtools.C5023at;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.vending.p642h.C5703d;
import com.tencent.tinker.entry.ApplicationLifeCycle;
import java.util.concurrent.ConcurrentHashMap;
import junit.framework.Assert;

/* renamed from: com.tencent.mm.kernel.g */
public final class C1720g {
    private static C1720g eKh;
    public final C1691a eJn = new C1691a();
    public C1728h<C6624h> eKi;
    C5004al eKj;
    private C1841cc eKk = null;
    public C1706e eKl;
    public C1668a eKm;
    public C1682b eKn;
    public C1349b eKo;
    public final C1725a eKp = new C1725a();
    private final boolean eKq;
    private ConcurrentHashMap eKr = new ConcurrentHashMap();
    public volatile boolean eKs = false;

    /* renamed from: com.tencent.mm.kernel.g$2 */
    class C17192 implements Runnable {
        C17192() {
        }

        public final void run() {
            AppMethodBeat.m2504i(57979);
            C5023at.m7478gI(C4996ah.getContext());
            AppMethodBeat.m2505o(57979);
        }
    }

    /* renamed from: com.tencent.mm.kernel.g$1 */
    class C17211 implements C4940a {
        C17211() {
        }
    }

    /* renamed from: com.tencent.mm.kernel.g$4 */
    static class C17234 implements C1735a {
        C17234() {
        }

        /* renamed from: e */
        public final void mo5260e(String str, String str2, Object... objArr) {
            AppMethodBeat.m2504i(57985);
            C4990ab.m7413e(str, str2, objArr);
            AppMethodBeat.m2505o(57985);
        }

        /* renamed from: w */
        public final void mo5263w(String str, String str2, Object... objArr) {
            AppMethodBeat.m2504i(57986);
            C4990ab.m7421w(str, str2, objArr);
            AppMethodBeat.m2505o(57986);
        }

        /* renamed from: i */
        public final void mo5261i(String str, String str2, Object... objArr) {
            AppMethodBeat.m2504i(57987);
            C4990ab.m7417i(str, str2, objArr);
            AppMethodBeat.m2505o(57987);
        }

        /* renamed from: d */
        public final void mo5259d(String str, String str2, Object... objArr) {
            AppMethodBeat.m2504i(57988);
            C4990ab.m7411d(str, str2, objArr);
            AppMethodBeat.m2505o(57988);
        }

        public final void printErrStackTrace(String str, Throwable th, String str2, Object... objArr) {
            AppMethodBeat.m2504i(57989);
            C4990ab.printErrStackTrace(str, th, str2, objArr);
            AppMethodBeat.m2505o(57989);
        }
    }

    /* renamed from: com.tencent.mm.kernel.g$5 */
    class C17245 implements C5003b {
        C17245() {
        }

        /* renamed from: wM */
        public final void mo5264wM() {
            AppMethodBeat.m2504i(57990);
            C7305d.xDG.cin().reset();
            if (C1720g.this.eKm != null) {
                C1720g.this.eKm.release();
            }
            AppMethodBeat.m2505o(57990);
        }
    }

    /* renamed from: com.tencent.mm.kernel.g$a */
    static class C1725a extends C6454a<C1213a> implements C1213a {
        private C1725a() {
        }

        /* synthetic */ C1725a(byte b) {
            this();
        }

        /* renamed from: a */
        public final void mo4484a(final C6300p c6300p, final boolean z) {
            AppMethodBeat.m2504i(57993);
            mo14669a(new C1387a<C1213a>() {
                /* renamed from: ax */
                public final /* synthetic */ void mo4769ax(Object obj) {
                    AppMethodBeat.m2504i(57991);
                    ((C1213a) obj).mo4484a(c6300p, z);
                    AppMethodBeat.m2505o(57991);
                }
            });
            AppMethodBeat.m2505o(57993);
        }

        /* renamed from: a */
        public final void mo4483a(final C6300p c6300p) {
            AppMethodBeat.m2504i(57994);
            mo14669a(new C1387a<C1213a>() {
                /* renamed from: ax */
                public final /* synthetic */ void mo4769ax(Object obj) {
                    AppMethodBeat.m2504i(57992);
                    ((C1213a) obj).mo4483a(c6300p);
                    AppMethodBeat.m2505o(57992);
                }
            });
            AppMethodBeat.m2505o(57994);
        }
    }

    private C1720g(final C6624h c6624h) {
        AppMethodBeat.m2504i(57995);
        this.eKi = C1728h.m3567c(c6624h);
        this.eKq = ((C6624h) this.eKi.mo5266RM().mo5224Rn()).mo5181SG();
        if (this.eKq) {
            this.eKk = new C1841cc();
            this.eKj = C4960c.dqp();
            C7305d.xDC = false;
            C7305d.xDH.mo10139a(new C17211());
            this.eKj.mo10302aa(new C17192());
        }
        this.eKi.mo5265RL().eJC = new C1693a() {
            /* renamed from: b */
            public final void mo5197b(C7597f c7597f) {
                AppMethodBeat.m2504i(57980);
                C1720g.this.mo5253a(c6624h, (Object) c7597f);
                AppMethodBeat.m2505o(57980);
            }

            /* renamed from: b */
            public final void mo5198b(C1694a c1694a) {
                AppMethodBeat.m2504i(57981);
                C1720g.this.mo5253a(c6624h, (Object) c1694a);
                C6610c.m10890Sa().mo14822aA(c1694a);
                AppMethodBeat.m2505o(57981);
            }

            /* renamed from: c */
            public final void mo5200c(C1694a c1694a) {
                AppMethodBeat.m2504i(57982);
                C1720g c1720g = C1720g.this;
                C6624h c6624h = c6624h;
                C6610c Sa = C6610c.m10890Sa();
                if (c1694a instanceof C1671c) {
                    Sa.eKV.remove((C1671c) c1694a);
                }
                if (c1694a instanceof C1673e) {
                    Sa.eKW.remove((C1673e) c1694a);
                }
                if (c1694a instanceof C1670b) {
                    Sa.eKX.remove((C1670b) c1694a);
                }
                if (c1694a instanceof C1674f) {
                    Sa.eKY.remove((C1674f) c1694a);
                }
                if (c1694a instanceof ApplicationLifeCycle) {
                    c6624h.eMA.remove((ApplicationLifeCycle) c1694a);
                }
                if (c1694a instanceof C1672d) {
                    c1720g.eJn.remove((C1672d) c1694a);
                }
                if (c1694a instanceof C1675g) {
                    c1720g.eKi.mo5269b((C1675g) c1694a);
                }
                AppMethodBeat.m2505o(57982);
            }

            /* renamed from: c */
            public final void mo5199c(C7597f c7597f) {
                AppMethodBeat.m2504i(57983);
                C6610c Sa = C6610c.m10890Sa();
                if (c7597f != null) {
                    Sa.mo14823aB(c7597f);
                }
                AppMethodBeat.m2505o(57983);
            }

            /* renamed from: d */
            public final void mo5201d(C1694a c1694a) {
                AppMethodBeat.m2504i(57984);
                C6610c Sa = C6610c.m10890Sa();
                if (c1694a != null) {
                    Sa.mo14823aB(c1694a);
                }
                AppMethodBeat.m2505o(57984);
            }
        };
        AppMethodBeat.m2505o(57995);
    }

    /* renamed from: a */
    public final void mo5253a(C6624h c6624h, Object obj) {
        AppMethodBeat.m2504i(57996);
        if (this.eKr.containsKey(obj)) {
            C4990ab.m7417i("MicroMsg.MMKernel", "Already add, skip it[%s].", obj);
            AppMethodBeat.m2505o(57996);
        } else if (this.eKr.putIfAbsent(obj, this.eKr) != null) {
            C4990ab.m7417i("MicroMsg.MMKernel", "Already add, skip[%s].", obj);
            AppMethodBeat.m2505o(57996);
        } else {
            C6610c.m10890Sa().add(obj);
            if (obj instanceof ApplicationLifeCycle) {
                c6624h.eMA.mo14670aD((ApplicationLifeCycle) obj);
            }
            if (obj instanceof C1672d) {
                this.eJn.mo14670aD((C1672d) obj);
            }
            if (obj instanceof C1675g) {
                this.eKi.mo5267a((C1675g) obj);
            }
            AppMethodBeat.m2505o(57996);
        }
    }

    /* renamed from: a */
    public final void mo5252a(C1675g c1675g) {
        AppMethodBeat.m2504i(57997);
        this.eKi.mo5267a(c1675g);
        AppMethodBeat.m2505o(57997);
    }

    /* renamed from: b */
    public final void mo5255b(C1675g c1675g) {
        AppMethodBeat.m2504i(57998);
        this.eKi.mo5269b(c1675g);
        AppMethodBeat.m2505o(57998);
    }

    /* renamed from: RJ */
    public final boolean mo5251RJ() {
        return this.eKs;
    }

    /* renamed from: RK */
    public static boolean m3531RK() {
        AppMethodBeat.m2504i(57999);
        C1668a c1668a = C1720g.m3537RQ().eKm;
        if (c1668a == null || !c1668a.mo5161QY()) {
            AppMethodBeat.m2505o(57999);
            return false;
        }
        AppMethodBeat.m2505o(57999);
        return true;
    }

    /* renamed from: RL */
    public static C1699c m3532RL() {
        AppMethodBeat.m2504i(58000);
        Assert.assertNotNull("mCorePlugins not initialized!", C1720g.m3537RQ().eKi.mo5265RL());
        C1699c RL = C1720g.m3537RQ().eKi.mo5265RL();
        AppMethodBeat.m2505o(58000);
        return RL;
    }

    /* renamed from: RM */
    public static C1701d<C6624h> m3533RM() {
        AppMethodBeat.m2504i(58001);
        Assert.assertNotNull("mCoreProcess not initialized!", C1720g.m3537RQ().eKi.mo5266RM());
        C1701d RM = C1720g.m3537RQ().eKi.mo5266RM();
        AppMethodBeat.m2505o(58001);
        return RM;
    }

    /* renamed from: RN */
    public static C1668a m3534RN() {
        AppMethodBeat.m2504i(58002);
        Assert.assertNotNull("mCoreAccount not initialized!", C1720g.m3537RQ().eKm);
        C1668a c1668a = C1720g.m3537RQ().eKm;
        AppMethodBeat.m2505o(58002);
        return c1668a;
    }

    /* renamed from: RO */
    public static C1682b m3535RO() {
        AppMethodBeat.m2504i(58003);
        Assert.assertNotNull("mCoreNetwork not initialized!", C1720g.m3537RQ().eKn);
        C1682b c1682b = C1720g.m3537RQ().eKn;
        AppMethodBeat.m2505o(58003);
        return c1682b;
    }

    /* renamed from: RP */
    public static C1706e m3536RP() {
        AppMethodBeat.m2504i(58004);
        Assert.assertNotNull("mCoreStorage not initialized!", C1720g.m3537RQ().eKl);
        C1706e c1706e = C1720g.m3537RQ().eKl;
        AppMethodBeat.m2505o(58004);
        return c1706e;
    }

    /* renamed from: RQ */
    public static C1720g m3537RQ() {
        AppMethodBeat.m2504i(58005);
        Assert.assertNotNull("Kernel not initialized by MMApplication!", eKh);
        C1720g c1720g = eKh;
        AppMethodBeat.m2505o(58005);
        return c1720g;
    }

    /* renamed from: M */
    public static <T extends C1677a> T m3530M(Class<T> cls) {
        AppMethodBeat.m2504i(58006);
        C1720g.m3537RQ();
        C1677a M = C1720g.m3532RL().mo5216M(cls);
        AppMethodBeat.m2505o(58006);
        return M;
    }

    /* renamed from: K */
    public static <T extends C1694a> T m3528K(Class<T> cls) {
        AppMethodBeat.m2504i(58007);
        C1720g.m3537RQ();
        C1694a K = C1720g.m3532RL().mo5214K(cls);
        AppMethodBeat.m2505o(58007);
        return K;
    }

    /* renamed from: a */
    public static <T extends C1694a, N extends T> void m3542a(Class<T> cls, N n) {
        AppMethodBeat.m2504i(58008);
        C1720g.m3537RQ();
        C1720g.m3532RL().mo5219a((Class) cls, new C6625e(n));
        AppMethodBeat.m2505o(58008);
    }

    /* renamed from: a */
    public static <T extends C1694a, N extends T> void m3543a(Class<T> cls, C1696c<N> c1696c) {
        AppMethodBeat.m2504i(58009);
        C1720g.m3537RQ();
        C1720g.m3532RL().mo5219a((Class) cls, (C1696c) c1696c);
        AppMethodBeat.m2505o(58009);
    }

    /* renamed from: L */
    public static void m3529L(Class<? extends C1694a> cls) {
        AppMethodBeat.m2504i(58010);
        C1720g.m3537RQ();
        C1720g.m3532RL().mo5215L(cls);
        AppMethodBeat.m2505o(58010);
    }

    /* renamed from: Rg */
    public static C6300p m3540Rg() {
        AppMethodBeat.m2504i(58011);
        C1720g.m3537RQ();
        C6300p c6300p = C1720g.m3535RO().eJo;
        AppMethodBeat.m2505o(58011);
        return c6300p;
    }

    /* renamed from: RR */
    public static C1841cc m3538RR() {
        AppMethodBeat.m2504i(58012);
        Assert.assertTrue(C1720g.m3537RQ().eKq);
        C1841cc c1841cc = C1720g.m3537RQ().eKk;
        AppMethodBeat.m2505o(58012);
        return c1841cc;
    }

    @Deprecated
    /* renamed from: RS */
    public static C5004al m3539RS() {
        AppMethodBeat.m2504i(58013);
        Assert.assertTrue(C1720g.m3537RQ().eKq);
        C5004al c5004al = C1720g.m3537RQ().eKj;
        AppMethodBeat.m2505o(58013);
        return c5004al;
    }

    /* renamed from: a */
    public static synchronized void m3541a(C6624h c6624h) {
        synchronized (C1720g.class) {
            AppMethodBeat.m2504i(58014);
            if (eKh != null) {
                C6624h c6624h2 = (C6624h) eKh.eKi.mo5266RM().mo5224Rn();
                Application application = c6624h.f1233cc;
                c6624h2.eMz = c6624h.eMz;
                c6624h2.f1233cc = application;
                C4990ab.m7416i("MicroMsg.MMKernel", "Kernel not null, has initialized.");
                AppMethodBeat.m2505o(58014);
            } else {
                C1736j.m3583a(new C17234());
                C4990ab.m7416i("MicroMsg.MMKernel", "Initialize kernel, create whole WeChat world.");
                eKh = new C1720g(c6624h);
                AppMethodBeat.m2505o(58014);
            }
        }
    }

    /* renamed from: jR */
    public static void m3544jR(int i) {
        AppMethodBeat.m2504i(58015);
        C1668a RN = C1720g.m3534RN();
        if (C1668a.m3402jN(i) && C1647b.m3318a(C1668a.eIM) == i && RN.mo5161QY()) {
            C4990ab.m7421w("MMKernel.CoreAccount", "loginUin, uin not changed, return :%d", Integer.valueOf(i));
            AppMethodBeat.m2505o(58015);
            return;
        }
        synchronized (RN.eIL) {
            try {
                C1647b.m3319a(C1668a.eIM, i);
                RN.mo5155QO();
                RN.eIZ = SystemClock.elapsedRealtime();
                RN.mo5164cl(true);
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(58015);
            }
        }
    }

    /* renamed from: lL */
    public final void mo5257lL(String str) {
        AppMethodBeat.m2504i(58016);
        C4990ab.m7421w("MicroMsg.MMKernel", "logoutAccount uin:%s info:%s stack:%s", C1183p.getString(C1668a.m3383QF()), str, C5046bo.dpG());
        C1668a.m3406lE(C5046bo.dpG().toString() + str);
        this.eKm.mo5158QR().mo4507fu((long) C1668a.m3383QF());
        releaseAll();
        C1668a.m3390QM();
        C1668a.m3401cm(false);
        AppMethodBeat.m2505o(58016);
    }

    public final void releaseAll() {
        AppMethodBeat.m2504i(58017);
        long currentTimeMillis = System.currentTimeMillis();
        String str = "MicroMsg.MMKernel";
        String str2 = "release uin:%s ";
        Object[] objArr = new Object[1];
        objArr[0] = this.eKm != null ? C1183p.getString(C1668a.m3383QF()) : "-1";
        C4990ab.m7421w(str, str2, objArr);
        if (this.eKn.eJo != null) {
            this.eKn.eJo.reset();
        }
        C7305d.xDG.cin().shutdown();
        if (this.eKj != null) {
            this.eKj.mo10301a(new C17245());
        }
        C4990ab.m7417i("MicroMsg.MMKernel", "release uin:%s finish!!! cost:%sms", r0, Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
        AppMethodBeat.m2505o(58017);
    }

    /* renamed from: a */
    public final void mo5254a(C5703d c5703d) {
        AppMethodBeat.m2504i(58018);
        this.eKi.mo5268a(c5703d);
        AppMethodBeat.m2505o(58018);
    }

    /* renamed from: cn */
    public final void mo5256cn(boolean z) {
        AppMethodBeat.m2504i(58019);
        this.eKi.eKE.mo5177bi(z);
        AppMethodBeat.m2505o(58019);
    }
}
