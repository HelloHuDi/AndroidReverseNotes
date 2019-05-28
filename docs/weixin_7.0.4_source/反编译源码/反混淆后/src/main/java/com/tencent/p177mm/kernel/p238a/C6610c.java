package com.tencent.p177mm.kernel.p238a;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.blink.C1311a;
import com.tencent.p177mm.kernel.C1706e.C1705c;
import com.tencent.p177mm.kernel.C1718f;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.kernel.api.C1669a;
import com.tencent.p177mm.kernel.api.C1670b;
import com.tencent.p177mm.kernel.api.C1671c;
import com.tencent.p177mm.kernel.api.C1673e;
import com.tencent.p177mm.kernel.api.C1674f;
import com.tencent.p177mm.kernel.api.C1676h;
import com.tencent.p177mm.kernel.p238a.p239a.C1650b;
import com.tencent.p177mm.kernel.p238a.p240b.C1661e;
import com.tencent.p177mm.kernel.p238a.p240b.C1661e.C1662b;
import com.tencent.p177mm.kernel.p238a.p240b.C6597f;
import com.tencent.p177mm.kernel.p238a.p240b.C6597f.C6596a;
import com.tencent.p177mm.kernel.p238a.p240b.C6598g;
import com.tencent.p177mm.kernel.p238a.p715c.C6609b;
import com.tencent.p177mm.kernel.p241b.C1678b;
import com.tencent.p177mm.kernel.p241b.C1681g;
import com.tencent.p177mm.kernel.p241b.C6624h;
import com.tencent.p177mm.kernel.p241b.C7597f;
import com.tencent.p177mm.model.C1813aj;
import com.tencent.p177mm.p178a.C1173e;
import com.tencent.p177mm.p213cd.C7480h;
import com.tencent.p177mm.p217ci.C6454a;
import com.tencent.p177mm.p217ci.C6454a.C1387a;
import com.tencent.p177mm.plugin.report.C7053e;
import com.tencent.p177mm.protocal.C7243d;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.vending.p636b.C7358b;
import com.tencent.p177mm.vending.p637c.C5681a;
import com.tencent.ttpic.baseutils.IOUtils;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import junit.framework.Assert;

/* renamed from: com.tencent.mm.kernel.a.c */
public final class C6610c implements C1671c, C1673e, C1674f {
    private static C6610c eKZ = new C6610c();
    public static C5681a<Void, C6596a> eLc = new C66002();
    public static C5681a<Void, C6596a> eLd = new C66013();
    public static C5681a<Void, C6596a> eLe = new C66024();
    private static Map<Integer, Map> eLf = new ConcurrentHashMap();
    private boolean eKR = true;
    public final C6598g eKS = new C6598g();
    public final C6598g eKT = new C6598g();
    public final C6598g eKU = new C6598g();
    public final C6612b eKV = new C6612b();
    public final C6613c eKW = new C6613c();
    public final C6611a eKX = new C6611a();
    public final C6614d eKY = new C6614d();
    public volatile boolean eLa = false;
    private AtomicBoolean eLb = new AtomicBoolean(false);
    private Set<Looper> eLg = new HashSet();
    private ConcurrentHashMap<Object, C1667e> eLh = new ConcurrentHashMap();
    private ConcurrentHashMap eLi = new ConcurrentHashMap();

    /* renamed from: com.tencent.mm.kernel.a.c$e */
    static final class C1667e {
        private long eLu;
        private int mStatus;

        public C1667e() {
            AppMethodBeat.m2504i(58048);
            this.eLu = 0;
            this.mStatus = 0;
            this.eLu = Thread.currentThread().getId();
            AppMethodBeat.m2505o(58048);
        }

        /* renamed from: Sh */
        public final synchronized boolean mo5153Sh() {
            boolean z = false;
            synchronized (this) {
                AppMethodBeat.m2504i(58049);
                if (this.mStatus == 1 && this.eLu == Thread.currentThread().getId()) {
                    AppMethodBeat.m2505o(58049);
                } else if (this.mStatus == 2) {
                    AppMethodBeat.m2505o(58049);
                } else {
                    AppMethodBeat.m2505o(58049);
                    z = true;
                }
            }
            return z;
        }

        /* renamed from: jS */
        public final synchronized void mo5154jS(int i) {
            if (i > this.mStatus) {
                this.mStatus = i;
            }
        }
    }

    /* renamed from: com.tencent.mm.kernel.a.c$1 */
    class C65991 implements C1650b {
        C65991() {
        }

        /* renamed from: a */
        public final void mo5122a(Class cls, Object obj, Object obj2) {
            AppMethodBeat.m2504i(58024);
            if (cls == C6609b.class) {
                C6610c.m10890Sa().eKS.mo5122a(cls, obj, obj2);
                AppMethodBeat.m2505o(58024);
                return;
            }
            if (cls == C1678b.class) {
                C6610c.m10890Sa().eKT.mo5122a(cls, obj, obj2);
            }
            AppMethodBeat.m2505o(58024);
        }
    }

    /* renamed from: com.tencent.mm.kernel.a.c$2 */
    static class C66002 implements C5681a<Void, C6596a> {
        C66002() {
        }

        public final /* synthetic */ Object call(Object obj) {
            AppMethodBeat.m2504i(58025);
            C6596a c6596a = (C6596a) obj;
            if (c6596a.eMa.eLE == C1678b.class) {
                C7597f c7597f = (C7597f) c6596a.eLA;
                if (c7597f.isConfigured()) {
                    C4990ab.m7417i("MicroMsg.CallbacksProxy", "skip configure for plugin %s.", c7597f);
                } else {
                    C4990ab.m7417i("MicroMsg.CallbacksProxy", "configuring plugin [%s]...", c7597f);
                    c7597f.invokeConfigure(C1720g.m3533RM().mo5224Rn());
                }
            }
            Void voidR = zXH;
            AppMethodBeat.m2505o(58025);
            return voidR;
        }
    }

    /* renamed from: com.tencent.mm.kernel.a.c$3 */
    static class C66013 implements C5681a<Void, C6596a> {
        C66013() {
        }

        public final /* synthetic */ Object call(Object obj) {
            AppMethodBeat.m2504i(58026);
            C6596a c6596a = (C6596a) obj;
            if (c6596a.eMa.eLE == C6609b.class) {
                C6610c.m10897a((C6609b) c6596a.eLA, C1720g.m3533RM().mo5224Rn());
            }
            Void voidR = zXH;
            AppMethodBeat.m2505o(58026);
            return voidR;
        }
    }

    /* renamed from: com.tencent.mm.kernel.a.c$4 */
    static class C66024 implements C5681a<Void, C6596a> {
        C66024() {
        }

        public final /* synthetic */ Object call(Object obj) {
            AppMethodBeat.m2504i(58027);
            C6596a c6596a = (C6596a) obj;
            C4990ab.m7417i("MicroMsg.CallbacksProxy", "before running %s", c6596a.eLA);
            if (c6596a.eMa.eLE == C1676h.class) {
                ((C1676h) c6596a.eLA).mo5178RW();
            } else if (c6596a.eMa.eLE == C1669a.class) {
                C6610c.m10898a((C1669a) c6596a.eLA);
            } else if (c6596a.eMa.eLE == C1673e.class) {
                ((C1673e) c6596a.eLA).onDataBaseOpened(C1720g.m3536RP().eJN, C1720g.m3536RP().eJO);
            } else if (c6596a.eMa.eLE == C1813aj.class) {
                C6610c.m10900b((C1813aj) c6596a.eLA);
            } else if (c6596a.eMa.eLE == C1671c.class) {
                ((C1671c) c6596a.eLA).onAccountInitialized(C1720g.m3534RN().eIR);
            }
            C4990ab.m7417i("MicroMsg.CallbacksProxy", "[account-init] for phase(%s) subject(%s)", c6596a.eMa.eLE, c6596a.eLA);
            Void voidR = zXH;
            AppMethodBeat.m2505o(58027);
            return voidR;
        }
    }

    /* renamed from: com.tencent.mm.kernel.a.c$a */
    public static class C6611a extends C6454a<C1670b> implements C1670b {
        private boolean eLk = false;

        C6611a() {
        }

        /* renamed from: aD */
        public final /* synthetic */ C7358b mo14670aD(Object obj) {
            AppMethodBeat.m2504i(58032);
            C7358b a = mo14827a((C1670b) obj);
            AppMethodBeat.m2505o(58032);
            return a;
        }

        /* renamed from: a */
        public final synchronized C7358b<C1670b> mo14827a(C1670b c1670b) {
            C7358b aD;
            AppMethodBeat.m2504i(58028);
            aD = super.mo14670aD(c1670b);
            if (this.eLk) {
                List collectStoragePaths = c1670b.collectStoragePaths();
                if (collectStoragePaths != null && collectStoragePaths.size() > 0) {
                    C6611a.m10908b(collectStoragePaths, C1720g.m3536RP().eJM);
                }
                C4990ab.m7417i("MicroMsg.CallbacksProxy", "collectStoragePaths has been called. cb %s", c1670b);
            }
            AppMethodBeat.m2505o(58028);
            return aD;
        }

        public final List<String> collectStoragePaths() {
            AppMethodBeat.m2504i(58029);
            LinkedList dMf = dMf();
            LinkedList linkedList = new LinkedList();
            Iterator it = dMf.iterator();
            while (it.hasNext()) {
                C7358b c7358b = (C7358b) it.next();
                if (c7358b != null) {
                    List collectStoragePaths = ((C1670b) c7358b.f2002d).collectStoragePaths();
                    if (collectStoragePaths != null) {
                        linkedList.addAll(collectStoragePaths);
                    }
                }
            }
            AppMethodBeat.m2505o(58029);
            return linkedList;
        }

        /* renamed from: lN */
        public final synchronized void mo14828lN(String str) {
            AppMethodBeat.m2504i(58030);
            List collectStoragePaths = collectStoragePaths();
            this.eLk = true;
            C4990ab.m7417i("MicroMsg.CallbacksProxy", "all account storage folder %s", collectStoragePaths.toString());
            C6611a.m10908b(collectStoragePaths, str);
            AppMethodBeat.m2505o(58030);
        }

        /* renamed from: b */
        private static void m10908b(List<String> list, String str) {
            int i = 0;
            AppMethodBeat.m2504i(58031);
            String[] strArr = new String[(list.size() + 1)];
            strArr[0] = str;
            while (true) {
                int i2 = i;
                if (i2 < list.size()) {
                    strArr[i2 + 1] = str + ((String) list.get(i2));
                    i = i2 + 1;
                } else {
                    C1173e.m2570f(strArr);
                    AppMethodBeat.m2505o(58031);
                    return;
                }
            }
        }
    }

    /* renamed from: com.tencent.mm.kernel.a.c$b */
    public static class C6612b extends C6454a<C1671c> implements C1671c {

        /* renamed from: com.tencent.mm.kernel.a.c$b$2 */
        class C66042 implements C1387a<C1671c> {
            C66042() {
            }

            /* renamed from: ax */
            public final /* synthetic */ void mo4769ax(Object obj) {
                AppMethodBeat.m2504i(58034);
                C1671c c1671c = (C1671c) obj;
                if (C6612b.m10912a(c1671c)) {
                    c1671c.onAccountRelease();
                }
                AppMethodBeat.m2505o(58034);
            }
        }

        private C6612b() {
        }

        /* synthetic */ C6612b(byte b) {
            this();
        }

        public final void onAccountInitialized(final C1705c c1705c) {
            AppMethodBeat.m2504i(58035);
            mo14669a(new C1387a<C1671c>() {
                /* renamed from: ax */
                public final /* synthetic */ void mo4769ax(Object obj) {
                    AppMethodBeat.m2504i(58033);
                    ((C1671c) obj).onAccountInitialized(c1705c);
                    AppMethodBeat.m2505o(58033);
                }
            });
            AppMethodBeat.m2505o(58035);
        }

        public final void onAccountRelease() {
            AppMethodBeat.m2504i(58036);
            mo14669a(new C66042());
            AppMethodBeat.m2505o(58036);
        }

        /* renamed from: a */
        static /* synthetic */ boolean m10912a(C1671c c1671c) {
            AppMethodBeat.m2504i(58037);
            boolean a = C6610c.m10899a(C6610c.m10890Sa().eKU, C1671c.class, c1671c);
            AppMethodBeat.m2505o(58037);
            return a;
        }
    }

    /* renamed from: com.tencent.mm.kernel.a.c$c */
    public static class C6613c extends C6454a<C1673e> implements C1673e {
        C6613c() {
        }

        public final void onDataBaseOpened(final C7480h c7480h, final C7480h c7480h2) {
            AppMethodBeat.m2504i(58040);
            mo14669a(new C1387a<C1673e>() {
                /* renamed from: ax */
                public final /* synthetic */ void mo4769ax(Object obj) {
                    AppMethodBeat.m2504i(58038);
                    ((C1673e) obj).onDataBaseOpened(c7480h, c7480h2);
                    AppMethodBeat.m2505o(58038);
                }
            });
            AppMethodBeat.m2505o(58040);
        }

        public final void onDataBaseClosed(final C7480h c7480h, final C7480h c7480h2) {
            AppMethodBeat.m2504i(58041);
            mo14669a(new C1387a<C1673e>() {
                /* renamed from: ax */
                public final /* synthetic */ void mo4769ax(Object obj) {
                    AppMethodBeat.m2504i(58039);
                    ((C1673e) obj).onDataBaseClosed(c7480h, c7480h2);
                    AppMethodBeat.m2505o(58039);
                }
            });
            AppMethodBeat.m2505o(58041);
        }
    }

    /* renamed from: com.tencent.mm.kernel.a.c$d */
    public static class C6614d extends C6454a<C1674f> implements C1674f {
        private boolean eLq = false;
        private String eLr;

        /* renamed from: com.tencent.mm.kernel.a.c$d$1 */
        class C66071 implements C1387a<C1674f> {
            C66071() {
            }

            /* renamed from: ax */
            public final /* synthetic */ void mo4769ax(Object obj) {
                AppMethodBeat.m2504i(58042);
                ((C1674f) obj).mo5174RV();
                AppMethodBeat.m2505o(58042);
            }
        }

        C6614d() {
        }

        /* renamed from: aD */
        public final /* synthetic */ C7358b mo14670aD(Object obj) {
            AppMethodBeat.m2504i(58047);
            C7358b a = mo14829a((C1674f) obj);
            AppMethodBeat.m2505o(58047);
            return a;
        }

        /* renamed from: RV */
        public final void mo5174RV() {
            AppMethodBeat.m2504i(58044);
            mo14669a(new C66071());
            AppMethodBeat.m2505o(58044);
        }

        /* renamed from: a */
        public final synchronized C7358b<C1674f> mo14829a(C1674f c1674f) {
            C7358b aD;
            AppMethodBeat.m2504i(58045);
            aD = super.mo14670aD(c1674f);
            if (this.eLq) {
                c1674f.mo5175lM(this.eLr);
                C4990ab.m7417i("MicroMsg.CallbacksProxy", "onAccountPathChanged has been called. cb %s", c1674f);
            }
            AppMethodBeat.m2505o(58045);
            return aD;
        }

        /* renamed from: lM */
        public final synchronized void mo5175lM(final String str) {
            AppMethodBeat.m2504i(58046);
            mo14669a(new C1387a<C1674f>() {
                /* renamed from: ax */
                public final /* synthetic */ void mo4769ax(Object obj) {
                    AppMethodBeat.m2504i(58043);
                    ((C1674f) obj).mo5175lM(str);
                    AppMethodBeat.m2505o(58043);
                }
            });
            this.eLq = true;
            this.eLr = str;
            AppMethodBeat.m2505o(58046);
        }
    }

    private C6610c() {
        AppMethodBeat.m2504i(58050);
        AppMethodBeat.m2505o(58050);
    }

    static {
        AppMethodBeat.m2504i(58073);
        AppMethodBeat.m2505o(58073);
    }

    /* renamed from: Sa */
    public static C6610c m10890Sa() {
        return eKZ;
    }

    /* renamed from: a */
    public static boolean m10899a(C6598g c6598g, Class cls, Object obj) {
        AppMethodBeat.m2504i(58051);
        C6596a c6596a = (C6596a) c6598g.mo14812S(cls).mo5118aF(obj);
        if (c6596a == null) {
            AppMethodBeat.m2505o(58051);
            return false;
        }
        boolean z = c6596a.eLB;
        AppMethodBeat.m2505o(58051);
        return z;
    }

    /* renamed from: aA */
    public final void mo14822aA(Object obj) {
        AppMethodBeat.m2504i(58052);
        if (!((C6624h) C1720g.m3533RM().mo5224Rn()).mo5181SG()) {
            C4990ab.m7410d("MicroMsg.CallbacksProxy", "Not main process, skip making parallels dependencies.");
            AppMethodBeat.m2505o(58052);
        } else if (C1718f.m3526ay(obj)) {
            C4990ab.printErrStackTrace("MicroMsg.CallbacksProxy", new RuntimeException(), "Found dummy subject!", new Object[0]);
            AppMethodBeat.m2505o(58052);
        } else {
            this.eKU.mo14817aN(obj);
            AppMethodBeat.m2505o(58052);
        }
    }

    /* renamed from: RV */
    public final void mo5174RV() {
        AppMethodBeat.m2504i(139005);
        this.eKY.mo5174RV();
        AppMethodBeat.m2505o(139005);
    }

    /* renamed from: lM */
    public final void mo5175lM(String str) {
        AppMethodBeat.m2504i(58054);
        this.eKX.mo14828lN(str);
        this.eKY.mo5175lM(str);
        AppMethodBeat.m2505o(58054);
    }

    public final void onAccountInitialized(C1705c c1705c) {
        AppMethodBeat.m2504i(58055);
        if (this.eKR) {
            C1311a.m2807jD("beforeAccountInit");
            this.eKU.mo14818b(C1671c.class, true);
            C1661e Sq = C1661e.m3356Sq();
            Sq.mo5142a(new C1662b(), eLe, this.eKU);
            this.eKU.mo14814SD();
            Sq.start("account-init from onAccountInitialized");
            Sq.mo5139Ss();
            AppMethodBeat.m2505o(58055);
            return;
        }
        this.eKV.onAccountInitialized(c1705c);
        AppMethodBeat.m2505o(58055);
    }

    public final void onAccountRelease() {
        AppMethodBeat.m2504i(58056);
        this.eKV.onAccountRelease();
        this.eKU.mo14818b(C1676h.class, true);
        AppMethodBeat.m2505o(58056);
    }

    public final void onDataBaseOpened(C7480h c7480h, C7480h c7480h2) {
        AppMethodBeat.m2504i(58057);
        if (!this.eKR) {
            this.eKW.onDataBaseOpened(c7480h, c7480h2);
        }
        AppMethodBeat.m2505o(58057);
    }

    public final void onDataBaseClosed(C7480h c7480h, C7480h c7480h2) {
        AppMethodBeat.m2504i(58058);
        this.eKW.onDataBaseClosed(c7480h, c7480h2);
        AppMethodBeat.m2505o(58058);
    }

    public final void add(Object obj) {
        AppMethodBeat.m2504i(58059);
        if (obj instanceof C1671c) {
            this.eKV.mo14670aD((C1671c) obj);
        }
        if (obj instanceof C1673e) {
            this.eKW.mo14670aD((C1673e) obj);
        }
        if (obj instanceof C1670b) {
            this.eKX.mo14827a((C1670b) obj);
        }
        if (obj instanceof C1674f) {
            this.eKY.mo14829a((C1674f) obj);
        }
        AppMethodBeat.m2505o(58059);
    }

    /* renamed from: d */
    public final void mo14826d(Looper looper) {
        AppMethodBeat.m2504i(58060);
        C4990ab.m7417i("MicroMsg.CallbacksProxy", "Thread(%s) not allow load-alone.", looper);
        this.eLg.add(looper);
        AppMethodBeat.m2505o(58060);
    }

    /* renamed from: Sb */
    private boolean m10891Sb() {
        AppMethodBeat.m2504i(58061);
        if (!((C6624h) C1720g.m3533RM().mo5224Rn()).mo5181SG()) {
            AppMethodBeat.m2505o(58061);
            return false;
        } else if (this.eLg.contains(Looper.myLooper())) {
            C4990ab.m7411d("MicroMsg.CallbacksProxy", "Invalidate scene, it not allows to load alone in this thread(%s), illegal.", Looper.myLooper());
            AppMethodBeat.m2505o(58061);
            return false;
        } else if (C1720g.m3537RQ().eKi.eKC) {
            AppMethodBeat.m2505o(58061);
            return true;
        } else {
            C4990ab.m7412e("MicroMsg.CallbacksProxy", "Invalidate scene, kernel does not startup done.");
            AppMethodBeat.m2505o(58061);
            return false;
        }
    }

    /* renamed from: aB */
    public final void mo14823aB(Object obj) {
        AppMethodBeat.m2504i(58062);
        if (!this.eLb.get() || this.eLa) {
            AppMethodBeat.m2505o(58062);
        } else if (m10891Sb()) {
            if (!this.eLh.containsKey(obj)) {
                this.eLh.putIfAbsent(obj, new C1667e());
            }
            C1667e c1667e = (C1667e) this.eLh.get(obj);
            if (c1667e.mo5153Sh()) {
                long currentTimeMillis = System.currentTimeMillis();
                C4990ab.m7417i("MicroMsg.CallbacksProxy", "loadAlone for subject %s", obj);
                C4990ab.printErrStackTrace("MicroMsg.CallbacksProxy", new RuntimeException(), "loadAlone", new Object[0]);
                if (!this.eKU.mo14816aM(obj)) {
                    C4990ab.m7412e("MicroMsg.CallbacksProxy", "This subject(%s) has not made dependency while loading alone.");
                    this.eKU.mo14817aN(obj);
                }
                try {
                    C6596a aK;
                    c1667e.mo5154jS(1);
                    if (obj instanceof C7597f) {
                        if (!((C7597f) obj).isConfigured()) {
                            aK = this.eKT.mo14812S(C1678b.class).mo14810aK((C1678b) obj);
                            Assert.assertNotNull(aK);
                            aK.mo14808a(eLc);
                        }
                        aK = this.eKS.mo14812S(C6609b.class).mo14810aK((C6609b) obj);
                        Assert.assertNotNull(aK);
                        aK.mo14808a(eLd);
                    }
                    if (C1720g.m3534RN().mo5161QY()) {
                        if (obj instanceof C1676h) {
                            aK = this.eKU.mo14812S(C1676h.class).mo14810aK((C1676h) obj);
                            Assert.assertNotNull(aK);
                            aK.mo14808a(eLe);
                        }
                        if (obj instanceof C1669a) {
                            aK = this.eKU.mo14812S(C1669a.class).mo14810aK((C1669a) obj);
                            Assert.assertNotNull(aK);
                            aK.mo14808a(eLe);
                        }
                        if (obj instanceof C1813aj) {
                            aK = this.eKU.mo14812S(C1813aj.class).mo14810aK((C1813aj) obj);
                            Assert.assertNotNull(aK);
                            aK.mo14808a(eLe);
                        }
                        if (obj instanceof C1673e) {
                            aK = this.eKU.mo14812S(C1673e.class).mo14810aK((C1673e) obj);
                            Assert.assertNotNull(aK);
                            aK.mo14808a(eLe);
                        }
                        if (obj instanceof C1671c) {
                            aK = this.eKU.mo14812S(C1671c.class).mo14810aK((C1671c) obj);
                            Assert.assertNotNull(aK);
                            aK.mo14808a(eLe);
                        }
                        c1667e.mo5154jS(2);
                        C4990ab.m7417i("MicroMsg.CallbacksProxy", "Subject(%s) load alone spend %sms", obj, Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                        AppMethodBeat.m2505o(58062);
                        return;
                    }
                    C4990ab.m7416i("MicroMsg.CallbacksProxy", "account not init, return.");
                    c1667e.mo5154jS(2);
                    C4990ab.m7417i("MicroMsg.CallbacksProxy", "Subject(%s) load alone spend %sms", obj, Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                    AppMethodBeat.m2505o(58062);
                } catch (Throwable th) {
                    c1667e.mo5154jS(2);
                    C4990ab.m7417i("MicroMsg.CallbacksProxy", "Subject(%s) load alone spend %sms", obj, Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                    AppMethodBeat.m2505o(58062);
                }
            } else {
                AppMethodBeat.m2505o(58062);
            }
        } else {
            C4990ab.m7411d("MicroMsg.CallbacksProxy", "Invalidate scene for subject %s to load account-init alone.", obj);
            AppMethodBeat.m2505o(58062);
        }
    }

    /* renamed from: aC */
    public final void mo14824aC(Object obj) {
        AppMethodBeat.m2504i(58063);
        C4990ab.m7417i("MicroMsg.CallbacksProxy", "add pending callbacks %s", obj);
        this.eLi.putIfAbsent(obj, this.eLi);
        AppMethodBeat.m2505o(58063);
    }

    /* renamed from: Sc */
    private void m10892Sc() {
        AppMethodBeat.m2504i(58064);
        for (Object next : this.eLi.keySet()) {
            C1720g.m3537RQ().mo5253a((C6624h) C1720g.m3533RM().mo5224Rn(), next);
            eKZ.mo14822aA(next);
        }
        AppMethodBeat.m2505o(58064);
    }

    /* renamed from: Sd */
    public final void mo14821Sd() {
        AppMethodBeat.m2504i(58065);
        C1311a.m2807jD("initializePendingPlugins");
        if (this.eLb.compareAndSet(false, true)) {
            C4990ab.m7416i("MicroMsg.CallbacksProxy", "initialize pending plugins.");
            C6610c.m10893Se();
            m10892Sc();
            m10894Sf();
            m10895Sg();
            this.eLa = true;
            if (((C6624h) C1720g.m3533RM().mo5224Rn()).mo5181SG()) {
                C1720g.m3534RN().mo5157QQ();
            }
            C1311a.m2807jD("initializePendingPlugins done");
            if ((C7243d.vxr || C7243d.vxq) && ((C6624h) C1720g.m3533RM().mo5224Rn()).mo5181SG() && C1720g.m3534RN().mo5161QY()) {
                C6610c.m10896a(this.eKS);
                C6610c.m10896a(this.eKT);
                C6610c.m10896a(this.eKU);
            }
            C1661e.m3356Sq();
            C1311a.m2807jD("checkAllUnConsumed done");
        }
        AppMethodBeat.m2505o(58065);
    }

    /* renamed from: a */
    private static void m10896a(C6598g c6598g) {
        AppMethodBeat.m2504i(58066);
        Map SC = c6598g.mo14813SC();
        String str = "MicroMsg.CallbacksProxy";
        String str2 = "do parallels result check, %s for %s";
        Object[] objArr = new Object[2];
        objArr[0] = Boolean.valueOf(SC.size() > 0);
        objArr[1] = c6598g;
        C4990ab.m7417i(str, str2, objArr);
        if (SC.size() > 0) {
            C1311a.m2810s(0, 1);
            HashMap hashMap = new HashMap();
            String str3 = "BlinkStartup";
            StringBuilder stringBuilder = new StringBuilder();
            for (C6597f c6597f : SC.keySet()) {
                List list = (List) SC.get(c6597f);
                stringBuilder.append(c6597f.eLT);
                stringBuilder.append(" : ");
                stringBuilder.append(list.toString());
                stringBuilder.append(IOUtils.LINE_SEPARATOR_UNIX);
            }
            C4990ab.m7413e("MicroMsg.CallbacksProxy", "unconsumed message %s", stringBuilder.toString());
            C4990ab.m7412e("MicroMsg.CallbacksProxy", "maybe cycle dependencies");
            C7053e.pXa.mo8382g(str3, r0, hashMap);
        }
        AppMethodBeat.m2505o(58066);
    }

    /* renamed from: Sf */
    private void m10894Sf() {
        AppMethodBeat.m2504i(58068);
        C1311a.m2807jD("configureAndExecutePendingPlugins");
        this.eKT.mo14818b(C1678b.class, false);
        C1661e.m3356Sq().mo5141a(new C1662b(), eLc, this.eKT, "configure-functional from pending plugins");
        this.eKS.mo14818b(C6609b.class, false);
        C1661e.m3356Sq().mo5141a(new C1662b(), eLd, this.eKS, "task-functional from pending plugins");
        C1311a.m2807jD("configureAndExecutePendingPlugins done");
        AppMethodBeat.m2505o(58068);
    }

    /* renamed from: Sg */
    private void m10895Sg() {
        AppMethodBeat.m2504i(58069);
        if (((C6624h) C1720g.m3533RM().mo5224Rn()).mo5181SG() && C1720g.m3534RN().mo5161QY()) {
            this.eKU.mo14818b(C1676h.class, false);
            C1661e Sq = C1661e.m3356Sq();
            Sq.mo5142a(new C1662b(), eLe, this.eKU);
            this.eKU.mo14814SD();
            Sq.start("account-init from pending plugins");
            Sq.mo5139Ss();
            AppMethodBeat.m2505o(58069);
            return;
        }
        AppMethodBeat.m2505o(58069);
    }

    /* renamed from: Se */
    private static void m10893Se() {
        AppMethodBeat.m2504i(58067);
        C6610c c6610c = eKZ;
        for (C7597f aA : C1720g.m3532RL().mo5218Rm()) {
            c6610c.mo14822aA(aA);
        }
        C1311a.m2807jD("makePluginsParallelsDependency");
        AppMethodBeat.m2505o(58067);
    }

    /* renamed from: a */
    static /* synthetic */ void m10897a(C6609b c6609b, C1681g c1681g) {
        AppMethodBeat.m2504i(58070);
        if (eLf.containsKey(Integer.valueOf(c6609b.hashCode()))) {
            C1651a.m3339k("skip task %s execution hash %s", c6609b.name(), Integer.valueOf(c6609b.hashCode()));
            AppMethodBeat.m2505o(58070);
            return;
        }
        c6609b.execute(c1681g);
        eLf.put(Integer.valueOf(c6609b.hashCode()), eLf);
        C1651a.m3339k("boot task executing [%s] hash %s...", c6609b.name(), Integer.valueOf(c6609b.hashCode()));
        AppMethodBeat.m2505o(58070);
    }

    /* renamed from: b */
    static /* synthetic */ void m10900b(C1813aj c1813aj) {
        AppMethodBeat.m2504i(58072);
        C1720g.m3536RP().mo5242a(c1813aj);
        AppMethodBeat.m2505o(58072);
    }
}
