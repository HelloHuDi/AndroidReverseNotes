package com.tencent.mm.kernel;

import android.app.Application;
import android.os.SystemClock;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.p;
import com.tencent.mm.cc.b;
import com.tencent.mm.kernel.api.e;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.kernel.b.h;
import com.tencent.mm.model.cc;
import com.tencent.mm.sdk.g.c.c;
import com.tencent.mm.sdk.g.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.at;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.tinker.entry.ApplicationLifeCycle;
import java.util.concurrent.ConcurrentHashMap;
import junit.framework.Assert;

public final class g {
    private static g eKh;
    public final com.tencent.mm.kernel.b.a eJn = new com.tencent.mm.kernel.b.a();
    public h<h> eKi;
    al eKj;
    private cc eKk = null;
    public e eKl;
    public a eKm;
    public b eKn;
    public b eKo;
    public final a eKp = new a();
    private final boolean eKq;
    private ConcurrentHashMap eKr = new ConcurrentHashMap();
    public volatile boolean eKs = false;

    static class a extends com.tencent.mm.ci.a<com.tencent.mm.ai.p.a> implements com.tencent.mm.ai.p.a {
        private a() {
        }

        /* synthetic */ a(byte b) {
            this();
        }

        public final void a(final p pVar, final boolean z) {
            AppMethodBeat.i(57993);
            a(new com.tencent.mm.ci.a.a<com.tencent.mm.ai.p.a>() {
                public final /* synthetic */ void ax(Object obj) {
                    AppMethodBeat.i(57991);
                    ((com.tencent.mm.ai.p.a) obj).a(pVar, z);
                    AppMethodBeat.o(57991);
                }
            });
            AppMethodBeat.o(57993);
        }

        public final void a(final p pVar) {
            AppMethodBeat.i(57994);
            a(new com.tencent.mm.ci.a.a<com.tencent.mm.ai.p.a>() {
                public final /* synthetic */ void ax(Object obj) {
                    AppMethodBeat.i(57992);
                    ((com.tencent.mm.ai.p.a) obj).a(pVar);
                    AppMethodBeat.o(57992);
                }
            });
            AppMethodBeat.o(57994);
        }
    }

    private g(final h hVar) {
        AppMethodBeat.i(57995);
        this.eKi = h.c(hVar);
        this.eKq = ((h) this.eKi.RM().Rn()).SG();
        if (this.eKq) {
            this.eKk = new cc();
            this.eKj = c.dqp();
            d.xDC = false;
            d.xDH.a(new com.tencent.mm.sdk.g.a.c.a() {
            });
            this.eKj.aa(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(57979);
                    at.gI(ah.getContext());
                    AppMethodBeat.o(57979);
                }
            });
        }
        this.eKi.RL().eJC = new com.tencent.mm.kernel.c.a() {
            public final void b(f fVar) {
                AppMethodBeat.i(57980);
                g.this.a(hVar, (Object) fVar);
                AppMethodBeat.o(57980);
            }

            public final void b(com.tencent.mm.kernel.c.a aVar) {
                AppMethodBeat.i(57981);
                g.this.a(hVar, (Object) aVar);
                com.tencent.mm.kernel.a.c.Sa().aA(aVar);
                AppMethodBeat.o(57981);
            }

            public final void c(com.tencent.mm.kernel.c.a aVar) {
                AppMethodBeat.i(57982);
                g gVar = g.this;
                h hVar = hVar;
                com.tencent.mm.kernel.a.c Sa = com.tencent.mm.kernel.a.c.Sa();
                if (aVar instanceof com.tencent.mm.kernel.api.c) {
                    Sa.eKV.remove((com.tencent.mm.kernel.api.c) aVar);
                }
                if (aVar instanceof e) {
                    Sa.eKW.remove((e) aVar);
                }
                if (aVar instanceof com.tencent.mm.kernel.api.b) {
                    Sa.eKX.remove((com.tencent.mm.kernel.api.b) aVar);
                }
                if (aVar instanceof com.tencent.mm.kernel.api.f) {
                    Sa.eKY.remove((com.tencent.mm.kernel.api.f) aVar);
                }
                if (aVar instanceof ApplicationLifeCycle) {
                    hVar.eMA.remove((ApplicationLifeCycle) aVar);
                }
                if (aVar instanceof com.tencent.mm.kernel.api.d) {
                    gVar.eJn.remove((com.tencent.mm.kernel.api.d) aVar);
                }
                if (aVar instanceof com.tencent.mm.kernel.api.g) {
                    gVar.eKi.b((com.tencent.mm.kernel.api.g) aVar);
                }
                AppMethodBeat.o(57982);
            }

            public final void c(f fVar) {
                AppMethodBeat.i(57983);
                com.tencent.mm.kernel.a.c Sa = com.tencent.mm.kernel.a.c.Sa();
                if (fVar != null) {
                    Sa.aB(fVar);
                }
                AppMethodBeat.o(57983);
            }

            public final void d(com.tencent.mm.kernel.c.a aVar) {
                AppMethodBeat.i(57984);
                com.tencent.mm.kernel.a.c Sa = com.tencent.mm.kernel.a.c.Sa();
                if (aVar != null) {
                    Sa.aB(aVar);
                }
                AppMethodBeat.o(57984);
            }
        };
        AppMethodBeat.o(57995);
    }

    public final void a(h hVar, Object obj) {
        AppMethodBeat.i(57996);
        if (this.eKr.containsKey(obj)) {
            ab.i("MicroMsg.MMKernel", "Already add, skip it[%s].", obj);
            AppMethodBeat.o(57996);
        } else if (this.eKr.putIfAbsent(obj, this.eKr) != null) {
            ab.i("MicroMsg.MMKernel", "Already add, skip[%s].", obj);
            AppMethodBeat.o(57996);
        } else {
            com.tencent.mm.kernel.a.c.Sa().add(obj);
            if (obj instanceof ApplicationLifeCycle) {
                hVar.eMA.aD((ApplicationLifeCycle) obj);
            }
            if (obj instanceof com.tencent.mm.kernel.api.d) {
                this.eJn.aD((com.tencent.mm.kernel.api.d) obj);
            }
            if (obj instanceof com.tencent.mm.kernel.api.g) {
                this.eKi.a((com.tencent.mm.kernel.api.g) obj);
            }
            AppMethodBeat.o(57996);
        }
    }

    public final void a(com.tencent.mm.kernel.api.g gVar) {
        AppMethodBeat.i(57997);
        this.eKi.a(gVar);
        AppMethodBeat.o(57997);
    }

    public final void b(com.tencent.mm.kernel.api.g gVar) {
        AppMethodBeat.i(57998);
        this.eKi.b(gVar);
        AppMethodBeat.o(57998);
    }

    public final boolean RJ() {
        return this.eKs;
    }

    public static boolean RK() {
        AppMethodBeat.i(57999);
        a aVar = RQ().eKm;
        if (aVar == null || !aVar.QY()) {
            AppMethodBeat.o(57999);
            return false;
        }
        AppMethodBeat.o(57999);
        return true;
    }

    public static c RL() {
        AppMethodBeat.i(58000);
        Assert.assertNotNull("mCorePlugins not initialized!", RQ().eKi.RL());
        c RL = RQ().eKi.RL();
        AppMethodBeat.o(58000);
        return RL;
    }

    public static d<h> RM() {
        AppMethodBeat.i(58001);
        Assert.assertNotNull("mCoreProcess not initialized!", RQ().eKi.RM());
        d RM = RQ().eKi.RM();
        AppMethodBeat.o(58001);
        return RM;
    }

    public static a RN() {
        AppMethodBeat.i(58002);
        Assert.assertNotNull("mCoreAccount not initialized!", RQ().eKm);
        a aVar = RQ().eKm;
        AppMethodBeat.o(58002);
        return aVar;
    }

    public static b RO() {
        AppMethodBeat.i(58003);
        Assert.assertNotNull("mCoreNetwork not initialized!", RQ().eKn);
        b bVar = RQ().eKn;
        AppMethodBeat.o(58003);
        return bVar;
    }

    public static e RP() {
        AppMethodBeat.i(58004);
        Assert.assertNotNull("mCoreStorage not initialized!", RQ().eKl);
        e eVar = RQ().eKl;
        AppMethodBeat.o(58004);
        return eVar;
    }

    public static g RQ() {
        AppMethodBeat.i(58005);
        Assert.assertNotNull("Kernel not initialized by MMApplication!", eKh);
        g gVar = eKh;
        AppMethodBeat.o(58005);
        return gVar;
    }

    public static <T extends com.tencent.mm.kernel.b.a> T M(Class<T> cls) {
        AppMethodBeat.i(58006);
        RQ();
        com.tencent.mm.kernel.b.a M = RL().M(cls);
        AppMethodBeat.o(58006);
        return M;
    }

    public static <T extends com.tencent.mm.kernel.c.a> T K(Class<T> cls) {
        AppMethodBeat.i(58007);
        RQ();
        com.tencent.mm.kernel.c.a K = RL().K(cls);
        AppMethodBeat.o(58007);
        return K;
    }

    public static <T extends com.tencent.mm.kernel.c.a, N extends T> void a(Class<T> cls, N n) {
        AppMethodBeat.i(58008);
        RQ();
        RL().a((Class) cls, new com.tencent.mm.kernel.c.e(n));
        AppMethodBeat.o(58008);
    }

    public static <T extends com.tencent.mm.kernel.c.a, N extends T> void a(Class<T> cls, com.tencent.mm.kernel.c.c<N> cVar) {
        AppMethodBeat.i(58009);
        RQ();
        RL().a((Class) cls, (com.tencent.mm.kernel.c.c) cVar);
        AppMethodBeat.o(58009);
    }

    public static void L(Class<? extends com.tencent.mm.kernel.c.a> cls) {
        AppMethodBeat.i(58010);
        RQ();
        RL().L(cls);
        AppMethodBeat.o(58010);
    }

    public static p Rg() {
        AppMethodBeat.i(58011);
        RQ();
        p pVar = RO().eJo;
        AppMethodBeat.o(58011);
        return pVar;
    }

    public static cc RR() {
        AppMethodBeat.i(58012);
        Assert.assertTrue(RQ().eKq);
        cc ccVar = RQ().eKk;
        AppMethodBeat.o(58012);
        return ccVar;
    }

    @Deprecated
    public static al RS() {
        AppMethodBeat.i(58013);
        Assert.assertTrue(RQ().eKq);
        al alVar = RQ().eKj;
        AppMethodBeat.o(58013);
        return alVar;
    }

    public static synchronized void a(h hVar) {
        synchronized (g.class) {
            AppMethodBeat.i(58014);
            if (eKh != null) {
                h hVar2 = (h) eKh.eKi.RM().Rn();
                Application application = hVar.cc;
                hVar2.eMz = hVar.eMz;
                hVar2.cc = application;
                ab.i("MicroMsg.MMKernel", "Kernel not null, has initialized.");
                AppMethodBeat.o(58014);
            } else {
                j.a(new com.tencent.mm.kernel.j.a() {
                    public final void e(String str, String str2, Object... objArr) {
                        AppMethodBeat.i(57985);
                        ab.e(str, str2, objArr);
                        AppMethodBeat.o(57985);
                    }

                    public final void w(String str, String str2, Object... objArr) {
                        AppMethodBeat.i(57986);
                        ab.w(str, str2, objArr);
                        AppMethodBeat.o(57986);
                    }

                    public final void i(String str, String str2, Object... objArr) {
                        AppMethodBeat.i(57987);
                        ab.i(str, str2, objArr);
                        AppMethodBeat.o(57987);
                    }

                    public final void d(String str, String str2, Object... objArr) {
                        AppMethodBeat.i(57988);
                        ab.d(str, str2, objArr);
                        AppMethodBeat.o(57988);
                    }

                    public final void printErrStackTrace(String str, Throwable th, String str2, Object... objArr) {
                        AppMethodBeat.i(57989);
                        ab.printErrStackTrace(str, th, str2, objArr);
                        AppMethodBeat.o(57989);
                    }
                });
                ab.i("MicroMsg.MMKernel", "Initialize kernel, create whole WeChat world.");
                eKh = new g(hVar);
                AppMethodBeat.o(58014);
            }
        }
    }

    public static void jR(int i) {
        AppMethodBeat.i(58015);
        a RN = RN();
        if (a.jN(i) && b.a(a.eIM) == i && RN.QY()) {
            ab.w("MMKernel.CoreAccount", "loginUin, uin not changed, return :%d", Integer.valueOf(i));
            AppMethodBeat.o(58015);
            return;
        }
        synchronized (RN.eIL) {
            try {
                b.a(a.eIM, i);
                RN.QO();
                RN.eIZ = SystemClock.elapsedRealtime();
                RN.cl(true);
            } finally {
                while (true) {
                }
                AppMethodBeat.o(58015);
            }
        }
    }

    public final void lL(String str) {
        AppMethodBeat.i(58016);
        ab.w("MicroMsg.MMKernel", "logoutAccount uin:%s info:%s stack:%s", com.tencent.mm.a.p.getString(a.QF()), str, bo.dpG());
        a.lE(bo.dpG().toString() + str);
        this.eKm.QR().fu((long) a.QF());
        releaseAll();
        a.QM();
        a.cm(false);
        AppMethodBeat.o(58016);
    }

    public final void releaseAll() {
        AppMethodBeat.i(58017);
        long currentTimeMillis = System.currentTimeMillis();
        String str = "MicroMsg.MMKernel";
        String str2 = "release uin:%s ";
        Object[] objArr = new Object[1];
        objArr[0] = this.eKm != null ? com.tencent.mm.a.p.getString(a.QF()) : "-1";
        ab.w(str, str2, objArr);
        if (this.eKn.eJo != null) {
            this.eKn.eJo.reset();
        }
        d.xDG.cin().shutdown();
        if (this.eKj != null) {
            this.eKj.a(new al.b() {
                public final void wM() {
                    AppMethodBeat.i(57990);
                    d.xDG.cin().reset();
                    if (g.this.eKm != null) {
                        g.this.eKm.release();
                    }
                    AppMethodBeat.o(57990);
                }
            });
        }
        ab.i("MicroMsg.MMKernel", "release uin:%s finish!!! cost:%sms", r0, Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
        AppMethodBeat.o(58017);
    }

    public final void a(com.tencent.mm.vending.h.d dVar) {
        AppMethodBeat.i(58018);
        this.eKi.a(dVar);
        AppMethodBeat.o(58018);
    }

    public final void cn(boolean z) {
        AppMethodBeat.i(58019);
        this.eKi.eKE.bi(z);
        AppMethodBeat.o(58019);
    }
}
