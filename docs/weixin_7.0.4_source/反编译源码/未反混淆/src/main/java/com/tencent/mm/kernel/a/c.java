package com.tencent.mm.kernel.a;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.api.f;
import com.tencent.mm.kernel.api.h;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.aj;
import com.tencent.mm.sdk.platformtools.ab;
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

public final class c implements com.tencent.mm.kernel.api.c, com.tencent.mm.kernel.api.e, f {
    private static c eKZ = new c();
    public static com.tencent.mm.vending.c.a<Void, com.tencent.mm.kernel.a.b.f.a> eLc = new com.tencent.mm.vending.c.a<Void, com.tencent.mm.kernel.a.b.f.a>() {
        public final /* synthetic */ Object call(Object obj) {
            AppMethodBeat.i(58025);
            com.tencent.mm.kernel.a.b.f.a aVar = (com.tencent.mm.kernel.a.b.f.a) obj;
            if (aVar.eMa.eLE == com.tencent.mm.kernel.b.b.class) {
                com.tencent.mm.kernel.b.f fVar = (com.tencent.mm.kernel.b.f) aVar.eLA;
                if (fVar.isConfigured()) {
                    ab.i("MicroMsg.CallbacksProxy", "skip configure for plugin %s.", fVar);
                } else {
                    ab.i("MicroMsg.CallbacksProxy", "configuring plugin [%s]...", fVar);
                    fVar.invokeConfigure(g.RM().Rn());
                }
            }
            Void voidR = zXH;
            AppMethodBeat.o(58025);
            return voidR;
        }
    };
    public static com.tencent.mm.vending.c.a<Void, com.tencent.mm.kernel.a.b.f.a> eLd = new com.tencent.mm.vending.c.a<Void, com.tencent.mm.kernel.a.b.f.a>() {
        public final /* synthetic */ Object call(Object obj) {
            AppMethodBeat.i(58026);
            com.tencent.mm.kernel.a.b.f.a aVar = (com.tencent.mm.kernel.a.b.f.a) obj;
            if (aVar.eMa.eLE == com.tencent.mm.kernel.a.c.b.class) {
                c.a((com.tencent.mm.kernel.a.c.b) aVar.eLA, g.RM().Rn());
            }
            Void voidR = zXH;
            AppMethodBeat.o(58026);
            return voidR;
        }
    };
    public static com.tencent.mm.vending.c.a<Void, com.tencent.mm.kernel.a.b.f.a> eLe = new com.tencent.mm.vending.c.a<Void, com.tencent.mm.kernel.a.b.f.a>() {
        public final /* synthetic */ Object call(Object obj) {
            AppMethodBeat.i(58027);
            com.tencent.mm.kernel.a.b.f.a aVar = (com.tencent.mm.kernel.a.b.f.a) obj;
            ab.i("MicroMsg.CallbacksProxy", "before running %s", aVar.eLA);
            if (aVar.eMa.eLE == h.class) {
                ((h) aVar.eLA).RW();
            } else if (aVar.eMa.eLE == com.tencent.mm.kernel.api.a.class) {
                c.a((com.tencent.mm.kernel.api.a) aVar.eLA);
            } else if (aVar.eMa.eLE == com.tencent.mm.kernel.api.e.class) {
                ((com.tencent.mm.kernel.api.e) aVar.eLA).onDataBaseOpened(g.RP().eJN, g.RP().eJO);
            } else if (aVar.eMa.eLE == aj.class) {
                c.b((aj) aVar.eLA);
            } else if (aVar.eMa.eLE == com.tencent.mm.kernel.api.c.class) {
                ((com.tencent.mm.kernel.api.c) aVar.eLA).onAccountInitialized(g.RN().eIR);
            }
            ab.i("MicroMsg.CallbacksProxy", "[account-init] for phase(%s) subject(%s)", aVar.eMa.eLE, aVar.eLA);
            Void voidR = zXH;
            AppMethodBeat.o(58027);
            return voidR;
        }
    };
    private static Map<Integer, Map> eLf = new ConcurrentHashMap();
    private boolean eKR = true;
    public final com.tencent.mm.kernel.a.b.g eKS = new com.tencent.mm.kernel.a.b.g();
    public final com.tencent.mm.kernel.a.b.g eKT = new com.tencent.mm.kernel.a.b.g();
    public final com.tencent.mm.kernel.a.b.g eKU = new com.tencent.mm.kernel.a.b.g();
    public final b eKV = new b();
    public final c eKW = new c();
    public final a eKX = new a();
    public final d eKY = new d();
    public volatile boolean eLa = false;
    private AtomicBoolean eLb = new AtomicBoolean(false);
    private Set<Looper> eLg = new HashSet();
    private ConcurrentHashMap<Object, e> eLh = new ConcurrentHashMap();
    private ConcurrentHashMap eLi = new ConcurrentHashMap();

    static final class e {
        private long eLu;
        private int mStatus;

        public e() {
            AppMethodBeat.i(58048);
            this.eLu = 0;
            this.mStatus = 0;
            this.eLu = Thread.currentThread().getId();
            AppMethodBeat.o(58048);
        }

        public final synchronized boolean Sh() {
            boolean z = false;
            synchronized (this) {
                AppMethodBeat.i(58049);
                if (this.mStatus == 1 && this.eLu == Thread.currentThread().getId()) {
                    AppMethodBeat.o(58049);
                } else if (this.mStatus == 2) {
                    AppMethodBeat.o(58049);
                } else {
                    AppMethodBeat.o(58049);
                    z = true;
                }
            }
            return z;
        }

        public final synchronized void jS(int i) {
            if (i > this.mStatus) {
                this.mStatus = i;
            }
        }
    }

    public static class a extends com.tencent.mm.ci.a<com.tencent.mm.kernel.api.b> implements com.tencent.mm.kernel.api.b {
        private boolean eLk = false;

        a() {
        }

        public final /* synthetic */ com.tencent.mm.vending.b.b aD(Object obj) {
            AppMethodBeat.i(58032);
            com.tencent.mm.vending.b.b a = a((com.tencent.mm.kernel.api.b) obj);
            AppMethodBeat.o(58032);
            return a;
        }

        public final synchronized com.tencent.mm.vending.b.b<com.tencent.mm.kernel.api.b> a(com.tencent.mm.kernel.api.b bVar) {
            com.tencent.mm.vending.b.b aD;
            AppMethodBeat.i(58028);
            aD = super.aD(bVar);
            if (this.eLk) {
                List collectStoragePaths = bVar.collectStoragePaths();
                if (collectStoragePaths != null && collectStoragePaths.size() > 0) {
                    b(collectStoragePaths, g.RP().eJM);
                }
                ab.i("MicroMsg.CallbacksProxy", "collectStoragePaths has been called. cb %s", bVar);
            }
            AppMethodBeat.o(58028);
            return aD;
        }

        public final List<String> collectStoragePaths() {
            AppMethodBeat.i(58029);
            LinkedList dMf = dMf();
            LinkedList linkedList = new LinkedList();
            Iterator it = dMf.iterator();
            while (it.hasNext()) {
                com.tencent.mm.vending.b.b bVar = (com.tencent.mm.vending.b.b) it.next();
                if (bVar != null) {
                    List collectStoragePaths = ((com.tencent.mm.kernel.api.b) bVar.d).collectStoragePaths();
                    if (collectStoragePaths != null) {
                        linkedList.addAll(collectStoragePaths);
                    }
                }
            }
            AppMethodBeat.o(58029);
            return linkedList;
        }

        public final synchronized void lN(String str) {
            AppMethodBeat.i(58030);
            List collectStoragePaths = collectStoragePaths();
            this.eLk = true;
            ab.i("MicroMsg.CallbacksProxy", "all account storage folder %s", collectStoragePaths.toString());
            b(collectStoragePaths, str);
            AppMethodBeat.o(58030);
        }

        private static void b(List<String> list, String str) {
            int i = 0;
            AppMethodBeat.i(58031);
            String[] strArr = new String[(list.size() + 1)];
            strArr[0] = str;
            while (true) {
                int i2 = i;
                if (i2 < list.size()) {
                    strArr[i2 + 1] = str + ((String) list.get(i2));
                    i = i2 + 1;
                } else {
                    com.tencent.mm.a.e.f(strArr);
                    AppMethodBeat.o(58031);
                    return;
                }
            }
        }
    }

    public static class b extends com.tencent.mm.ci.a<com.tencent.mm.kernel.api.c> implements com.tencent.mm.kernel.api.c {
        private b() {
        }

        /* synthetic */ b(byte b) {
            this();
        }

        public final void onAccountInitialized(final com.tencent.mm.kernel.e.c cVar) {
            AppMethodBeat.i(58035);
            a(new com.tencent.mm.ci.a.a<com.tencent.mm.kernel.api.c>() {
                public final /* synthetic */ void ax(Object obj) {
                    AppMethodBeat.i(58033);
                    ((com.tencent.mm.kernel.api.c) obj).onAccountInitialized(cVar);
                    AppMethodBeat.o(58033);
                }
            });
            AppMethodBeat.o(58035);
        }

        public final void onAccountRelease() {
            AppMethodBeat.i(58036);
            a(new com.tencent.mm.ci.a.a<com.tencent.mm.kernel.api.c>() {
                public final /* synthetic */ void ax(Object obj) {
                    AppMethodBeat.i(58034);
                    com.tencent.mm.kernel.api.c cVar = (com.tencent.mm.kernel.api.c) obj;
                    if (b.a(cVar)) {
                        cVar.onAccountRelease();
                    }
                    AppMethodBeat.o(58034);
                }
            });
            AppMethodBeat.o(58036);
        }

        static /* synthetic */ boolean a(com.tencent.mm.kernel.api.c cVar) {
            AppMethodBeat.i(58037);
            boolean a = c.a(c.Sa().eKU, com.tencent.mm.kernel.api.c.class, cVar);
            AppMethodBeat.o(58037);
            return a;
        }
    }

    public static class c extends com.tencent.mm.ci.a<com.tencent.mm.kernel.api.e> implements com.tencent.mm.kernel.api.e {
        c() {
        }

        public final void onDataBaseOpened(final com.tencent.mm.cd.h hVar, final com.tencent.mm.cd.h hVar2) {
            AppMethodBeat.i(58040);
            a(new com.tencent.mm.ci.a.a<com.tencent.mm.kernel.api.e>() {
                public final /* synthetic */ void ax(Object obj) {
                    AppMethodBeat.i(58038);
                    ((com.tencent.mm.kernel.api.e) obj).onDataBaseOpened(hVar, hVar2);
                    AppMethodBeat.o(58038);
                }
            });
            AppMethodBeat.o(58040);
        }

        public final void onDataBaseClosed(final com.tencent.mm.cd.h hVar, final com.tencent.mm.cd.h hVar2) {
            AppMethodBeat.i(58041);
            a(new com.tencent.mm.ci.a.a<com.tencent.mm.kernel.api.e>() {
                public final /* synthetic */ void ax(Object obj) {
                    AppMethodBeat.i(58039);
                    ((com.tencent.mm.kernel.api.e) obj).onDataBaseClosed(hVar, hVar2);
                    AppMethodBeat.o(58039);
                }
            });
            AppMethodBeat.o(58041);
        }
    }

    public static class d extends com.tencent.mm.ci.a<f> implements f {
        private boolean eLq = false;
        private String eLr;

        d() {
        }

        public final /* synthetic */ com.tencent.mm.vending.b.b aD(Object obj) {
            AppMethodBeat.i(58047);
            com.tencent.mm.vending.b.b a = a((f) obj);
            AppMethodBeat.o(58047);
            return a;
        }

        public final void RV() {
            AppMethodBeat.i(58044);
            a(new com.tencent.mm.ci.a.a<f>() {
                public final /* synthetic */ void ax(Object obj) {
                    AppMethodBeat.i(58042);
                    ((f) obj).RV();
                    AppMethodBeat.o(58042);
                }
            });
            AppMethodBeat.o(58044);
        }

        public final synchronized com.tencent.mm.vending.b.b<f> a(f fVar) {
            com.tencent.mm.vending.b.b aD;
            AppMethodBeat.i(58045);
            aD = super.aD(fVar);
            if (this.eLq) {
                fVar.lM(this.eLr);
                ab.i("MicroMsg.CallbacksProxy", "onAccountPathChanged has been called. cb %s", fVar);
            }
            AppMethodBeat.o(58045);
            return aD;
        }

        public final synchronized void lM(final String str) {
            AppMethodBeat.i(58046);
            a(new com.tencent.mm.ci.a.a<f>() {
                public final /* synthetic */ void ax(Object obj) {
                    AppMethodBeat.i(58043);
                    ((f) obj).lM(str);
                    AppMethodBeat.o(58043);
                }
            });
            this.eLq = true;
            this.eLr = str;
            AppMethodBeat.o(58046);
        }
    }

    private c() {
        AppMethodBeat.i(58050);
        AppMethodBeat.o(58050);
    }

    static {
        AppMethodBeat.i(58073);
        AppMethodBeat.o(58073);
    }

    public static c Sa() {
        return eKZ;
    }

    public static boolean a(com.tencent.mm.kernel.a.b.g gVar, Class cls, Object obj) {
        AppMethodBeat.i(58051);
        com.tencent.mm.kernel.a.b.f.a aVar = (com.tencent.mm.kernel.a.b.f.a) gVar.S(cls).aF(obj);
        if (aVar == null) {
            AppMethodBeat.o(58051);
            return false;
        }
        boolean z = aVar.eLB;
        AppMethodBeat.o(58051);
        return z;
    }

    public final void aA(Object obj) {
        AppMethodBeat.i(58052);
        if (!((com.tencent.mm.kernel.b.h) g.RM().Rn()).SG()) {
            ab.d("MicroMsg.CallbacksProxy", "Not main process, skip making parallels dependencies.");
            AppMethodBeat.o(58052);
        } else if (com.tencent.mm.kernel.f.ay(obj)) {
            ab.printErrStackTrace("MicroMsg.CallbacksProxy", new RuntimeException(), "Found dummy subject!", new Object[0]);
            AppMethodBeat.o(58052);
        } else {
            this.eKU.aN(obj);
            AppMethodBeat.o(58052);
        }
    }

    public final void RV() {
        AppMethodBeat.i(139005);
        this.eKY.RV();
        AppMethodBeat.o(139005);
    }

    public final void lM(String str) {
        AppMethodBeat.i(58054);
        this.eKX.lN(str);
        this.eKY.lM(str);
        AppMethodBeat.o(58054);
    }

    public final void onAccountInitialized(com.tencent.mm.kernel.e.c cVar) {
        AppMethodBeat.i(58055);
        if (this.eKR) {
            com.tencent.mm.blink.a.jD("beforeAccountInit");
            this.eKU.b(com.tencent.mm.kernel.api.c.class, true);
            com.tencent.mm.kernel.a.b.e Sq = com.tencent.mm.kernel.a.b.e.Sq();
            Sq.a(new com.tencent.mm.kernel.a.b.e.b(), eLe, this.eKU);
            this.eKU.SD();
            Sq.start("account-init from onAccountInitialized");
            Sq.Ss();
            AppMethodBeat.o(58055);
            return;
        }
        this.eKV.onAccountInitialized(cVar);
        AppMethodBeat.o(58055);
    }

    public final void onAccountRelease() {
        AppMethodBeat.i(58056);
        this.eKV.onAccountRelease();
        this.eKU.b(h.class, true);
        AppMethodBeat.o(58056);
    }

    public final void onDataBaseOpened(com.tencent.mm.cd.h hVar, com.tencent.mm.cd.h hVar2) {
        AppMethodBeat.i(58057);
        if (!this.eKR) {
            this.eKW.onDataBaseOpened(hVar, hVar2);
        }
        AppMethodBeat.o(58057);
    }

    public final void onDataBaseClosed(com.tencent.mm.cd.h hVar, com.tencent.mm.cd.h hVar2) {
        AppMethodBeat.i(58058);
        this.eKW.onDataBaseClosed(hVar, hVar2);
        AppMethodBeat.o(58058);
    }

    public final void add(Object obj) {
        AppMethodBeat.i(58059);
        if (obj instanceof com.tencent.mm.kernel.api.c) {
            this.eKV.aD((com.tencent.mm.kernel.api.c) obj);
        }
        if (obj instanceof com.tencent.mm.kernel.api.e) {
            this.eKW.aD((com.tencent.mm.kernel.api.e) obj);
        }
        if (obj instanceof com.tencent.mm.kernel.api.b) {
            this.eKX.a((com.tencent.mm.kernel.api.b) obj);
        }
        if (obj instanceof f) {
            this.eKY.a((f) obj);
        }
        AppMethodBeat.o(58059);
    }

    public final void d(Looper looper) {
        AppMethodBeat.i(58060);
        ab.i("MicroMsg.CallbacksProxy", "Thread(%s) not allow load-alone.", looper);
        this.eLg.add(looper);
        AppMethodBeat.o(58060);
    }

    private boolean Sb() {
        AppMethodBeat.i(58061);
        if (!((com.tencent.mm.kernel.b.h) g.RM().Rn()).SG()) {
            AppMethodBeat.o(58061);
            return false;
        } else if (this.eLg.contains(Looper.myLooper())) {
            ab.d("MicroMsg.CallbacksProxy", "Invalidate scene, it not allows to load alone in this thread(%s), illegal.", Looper.myLooper());
            AppMethodBeat.o(58061);
            return false;
        } else if (g.RQ().eKi.eKC) {
            AppMethodBeat.o(58061);
            return true;
        } else {
            ab.e("MicroMsg.CallbacksProxy", "Invalidate scene, kernel does not startup done.");
            AppMethodBeat.o(58061);
            return false;
        }
    }

    public final void aB(Object obj) {
        AppMethodBeat.i(58062);
        if (!this.eLb.get() || this.eLa) {
            AppMethodBeat.o(58062);
        } else if (Sb()) {
            if (!this.eLh.containsKey(obj)) {
                this.eLh.putIfAbsent(obj, new e());
            }
            e eVar = (e) this.eLh.get(obj);
            if (eVar.Sh()) {
                long currentTimeMillis = System.currentTimeMillis();
                ab.i("MicroMsg.CallbacksProxy", "loadAlone for subject %s", obj);
                ab.printErrStackTrace("MicroMsg.CallbacksProxy", new RuntimeException(), "loadAlone", new Object[0]);
                if (!this.eKU.aM(obj)) {
                    ab.e("MicroMsg.CallbacksProxy", "This subject(%s) has not made dependency while loading alone.");
                    this.eKU.aN(obj);
                }
                try {
                    com.tencent.mm.kernel.a.b.f.a aK;
                    eVar.jS(1);
                    if (obj instanceof com.tencent.mm.kernel.b.f) {
                        if (!((com.tencent.mm.kernel.b.f) obj).isConfigured()) {
                            aK = this.eKT.S(com.tencent.mm.kernel.b.b.class).aK((com.tencent.mm.kernel.b.b) obj);
                            Assert.assertNotNull(aK);
                            aK.a(eLc);
                        }
                        aK = this.eKS.S(com.tencent.mm.kernel.a.c.b.class).aK((com.tencent.mm.kernel.a.c.b) obj);
                        Assert.assertNotNull(aK);
                        aK.a(eLd);
                    }
                    if (g.RN().QY()) {
                        if (obj instanceof h) {
                            aK = this.eKU.S(h.class).aK((h) obj);
                            Assert.assertNotNull(aK);
                            aK.a(eLe);
                        }
                        if (obj instanceof com.tencent.mm.kernel.api.a) {
                            aK = this.eKU.S(com.tencent.mm.kernel.api.a.class).aK((com.tencent.mm.kernel.api.a) obj);
                            Assert.assertNotNull(aK);
                            aK.a(eLe);
                        }
                        if (obj instanceof aj) {
                            aK = this.eKU.S(aj.class).aK((aj) obj);
                            Assert.assertNotNull(aK);
                            aK.a(eLe);
                        }
                        if (obj instanceof com.tencent.mm.kernel.api.e) {
                            aK = this.eKU.S(com.tencent.mm.kernel.api.e.class).aK((com.tencent.mm.kernel.api.e) obj);
                            Assert.assertNotNull(aK);
                            aK.a(eLe);
                        }
                        if (obj instanceof com.tencent.mm.kernel.api.c) {
                            aK = this.eKU.S(com.tencent.mm.kernel.api.c.class).aK((com.tencent.mm.kernel.api.c) obj);
                            Assert.assertNotNull(aK);
                            aK.a(eLe);
                        }
                        eVar.jS(2);
                        ab.i("MicroMsg.CallbacksProxy", "Subject(%s) load alone spend %sms", obj, Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                        AppMethodBeat.o(58062);
                        return;
                    }
                    ab.i("MicroMsg.CallbacksProxy", "account not init, return.");
                    eVar.jS(2);
                    ab.i("MicroMsg.CallbacksProxy", "Subject(%s) load alone spend %sms", obj, Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                    AppMethodBeat.o(58062);
                } catch (Throwable th) {
                    eVar.jS(2);
                    ab.i("MicroMsg.CallbacksProxy", "Subject(%s) load alone spend %sms", obj, Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                    AppMethodBeat.o(58062);
                }
            } else {
                AppMethodBeat.o(58062);
            }
        } else {
            ab.d("MicroMsg.CallbacksProxy", "Invalidate scene for subject %s to load account-init alone.", obj);
            AppMethodBeat.o(58062);
        }
    }

    public final void aC(Object obj) {
        AppMethodBeat.i(58063);
        ab.i("MicroMsg.CallbacksProxy", "add pending callbacks %s", obj);
        this.eLi.putIfAbsent(obj, this.eLi);
        AppMethodBeat.o(58063);
    }

    private void Sc() {
        AppMethodBeat.i(58064);
        for (Object next : this.eLi.keySet()) {
            g.RQ().a((com.tencent.mm.kernel.b.h) g.RM().Rn(), next);
            eKZ.aA(next);
        }
        AppMethodBeat.o(58064);
    }

    public final void Sd() {
        AppMethodBeat.i(58065);
        com.tencent.mm.blink.a.jD("initializePendingPlugins");
        if (this.eLb.compareAndSet(false, true)) {
            ab.i("MicroMsg.CallbacksProxy", "initialize pending plugins.");
            Se();
            Sc();
            Sf();
            Sg();
            this.eLa = true;
            if (((com.tencent.mm.kernel.b.h) g.RM().Rn()).SG()) {
                g.RN().QQ();
            }
            com.tencent.mm.blink.a.jD("initializePendingPlugins done");
            if ((com.tencent.mm.protocal.d.vxr || com.tencent.mm.protocal.d.vxq) && ((com.tencent.mm.kernel.b.h) g.RM().Rn()).SG() && g.RN().QY()) {
                a(this.eKS);
                a(this.eKT);
                a(this.eKU);
            }
            com.tencent.mm.kernel.a.b.e.Sq();
            com.tencent.mm.blink.a.jD("checkAllUnConsumed done");
        }
        AppMethodBeat.o(58065);
    }

    private static void a(com.tencent.mm.kernel.a.b.g gVar) {
        AppMethodBeat.i(58066);
        Map SC = gVar.SC();
        String str = "MicroMsg.CallbacksProxy";
        String str2 = "do parallels result check, %s for %s";
        Object[] objArr = new Object[2];
        objArr[0] = Boolean.valueOf(SC.size() > 0);
        objArr[1] = gVar;
        ab.i(str, str2, objArr);
        if (SC.size() > 0) {
            com.tencent.mm.blink.a.s(0, 1);
            HashMap hashMap = new HashMap();
            String str3 = "BlinkStartup";
            StringBuilder stringBuilder = new StringBuilder();
            for (com.tencent.mm.kernel.a.b.f fVar : SC.keySet()) {
                List list = (List) SC.get(fVar);
                stringBuilder.append(fVar.eLT);
                stringBuilder.append(" : ");
                stringBuilder.append(list.toString());
                stringBuilder.append(IOUtils.LINE_SEPARATOR_UNIX);
            }
            ab.e("MicroMsg.CallbacksProxy", "unconsumed message %s", stringBuilder.toString());
            ab.e("MicroMsg.CallbacksProxy", "maybe cycle dependencies");
            com.tencent.mm.plugin.report.e.pXa.g(str3, r0, hashMap);
        }
        AppMethodBeat.o(58066);
    }

    private void Sf() {
        AppMethodBeat.i(58068);
        com.tencent.mm.blink.a.jD("configureAndExecutePendingPlugins");
        this.eKT.b(com.tencent.mm.kernel.b.b.class, false);
        com.tencent.mm.kernel.a.b.e.Sq().a(new com.tencent.mm.kernel.a.b.e.b(), eLc, this.eKT, "configure-functional from pending plugins");
        this.eKS.b(com.tencent.mm.kernel.a.c.b.class, false);
        com.tencent.mm.kernel.a.b.e.Sq().a(new com.tencent.mm.kernel.a.b.e.b(), eLd, this.eKS, "task-functional from pending plugins");
        com.tencent.mm.blink.a.jD("configureAndExecutePendingPlugins done");
        AppMethodBeat.o(58068);
    }

    private void Sg() {
        AppMethodBeat.i(58069);
        if (((com.tencent.mm.kernel.b.h) g.RM().Rn()).SG() && g.RN().QY()) {
            this.eKU.b(h.class, false);
            com.tencent.mm.kernel.a.b.e Sq = com.tencent.mm.kernel.a.b.e.Sq();
            Sq.a(new com.tencent.mm.kernel.a.b.e.b(), eLe, this.eKU);
            this.eKU.SD();
            Sq.start("account-init from pending plugins");
            Sq.Ss();
            AppMethodBeat.o(58069);
            return;
        }
        AppMethodBeat.o(58069);
    }

    private static void Se() {
        AppMethodBeat.i(58067);
        c cVar = eKZ;
        for (com.tencent.mm.kernel.b.f aA : g.RL().Rm()) {
            cVar.aA(aA);
        }
        com.tencent.mm.blink.a.jD("makePluginsParallelsDependency");
        AppMethodBeat.o(58067);
    }

    static /* synthetic */ void a(com.tencent.mm.kernel.a.c.b bVar, com.tencent.mm.kernel.b.g gVar) {
        AppMethodBeat.i(58070);
        if (eLf.containsKey(Integer.valueOf(bVar.hashCode()))) {
            a.k("skip task %s execution hash %s", bVar.name(), Integer.valueOf(bVar.hashCode()));
            AppMethodBeat.o(58070);
            return;
        }
        bVar.execute(gVar);
        eLf.put(Integer.valueOf(bVar.hashCode()), eLf);
        a.k("boot task executing [%s] hash %s...", bVar.name(), Integer.valueOf(bVar.hashCode()));
        AppMethodBeat.o(58070);
    }

    static /* synthetic */ void b(aj ajVar) {
        AppMethodBeat.i(58072);
        g.RP().a(ajVar);
        AppMethodBeat.o(58072);
    }
}
