package com.tencent.mm.kernel.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.e.n;
import com.tencent.mm.g.a.ml;
import com.tencent.mm.g.a.mm;
import com.tencent.mm.kernel.a.b.e;
import com.tencent.mm.kernel.api.a;
import com.tencent.mm.kernel.api.c;
import com.tencent.mm.kernel.b.b;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.kernel.b.h;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.aj;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import java.util.HashSet;
import java.util.Iterator;

public abstract class d implements b {
    public e<Object> eLv = e.Sr();
    private final HashSet<String> eLw = new HashSet();

    public void Bd() {
        ab.i("MicroMsg.ParallelsBootStep", "core num %s for parallels", Integer.valueOf((int) Math.min(Math.floor((((h) g.RM().Rn()).SG() ? 1.5d : 1.0d) * ((double) n.getNumCores())), 6.0d)));
        this.eLv.init(r0);
        c Sa = c.Sa();
        Sa.eKT.a(b.class);
        Sa.eKS.a(com.tencent.mm.kernel.a.c.b.class);
        Sa.eKU.a(com.tencent.mm.kernel.api.h.class, a.class, com.tencent.mm.kernel.api.e.class, aj.class, c.class);
        com.tencent.mm.kernel.a.b.g gVar = Sa.eKU;
        Class[] clsArr = new Class[]{c.class};
        gVar.eMg = new Class[1];
        System.arraycopy(clsArr, 0, gVar.eMg, 0, 1);
        ((h) g.RM().Rn()).eJE.eKM = new com.tencent.mm.kernel.a.a.b() {
            public final void a(Class cls, Object obj, Object obj2) {
                AppMethodBeat.i(58024);
                if (cls == com.tencent.mm.kernel.a.c.b.class) {
                    c.Sa().eKS.a(cls, obj, obj2);
                    AppMethodBeat.o(58024);
                    return;
                }
                if (cls == com.tencent.mm.kernel.b.b.class) {
                    c.Sa().eKT.a(cls, obj, obj2);
                }
                AppMethodBeat.o(58024);
            }
        };
        com.tencent.mm.blink.a.jD("helloWeChat");
    }

    public static void Q(Class<? extends f> cls) {
        g.RL().I(cls);
    }

    protected static void lO(String str) {
        g.RL().lH(str);
    }

    /* Access modifiers changed, original: protected|final */
    public final void lP(String str) {
        this.eLw.add(str);
    }

    public final void RY() {
        g.RL().Rl();
        this.eLv.prepare();
        for (e.c cVar : this.eLv.St()) {
            c.Sa().d(cVar.cet.getLooper());
        }
        com.tencent.mm.blink.a.jD("makeDependency");
    }

    public void a(com.tencent.mm.kernel.b.g gVar) {
        this.eLv.a(new e.b(), c.eLc, c.Sa().eKT, "configure-functional plugins");
        com.tencent.mm.blink.a.jD("configurePlugins");
        com.tencent.mm.sdk.b.a.xxA.m(new ml());
    }

    public final void RZ() {
        this.eLv.a(new e.b(), c.eLd, c.Sa().eKS, "task-functional plugins");
        com.tencent.mm.blink.a.jD("executeTasks");
    }

    public void b(com.tencent.mm.kernel.b.g gVar) {
        a.k("startup final step, account initialize... for parallels", new Object[0]);
        if (gVar.SG()) {
            c Sa = c.Sa();
            for (f aA : g.RL().Rm()) {
                Sa.aA(aA);
            }
            if (g.RN().QY()) {
                g.RN().QP();
            }
        }
        com.tencent.mm.blink.a.jD("installPendingPlugins");
        long nanoTime = System.nanoTime();
        if (this.eLw.size() > 0) {
            Iterator it = this.eLw.iterator();
            while (it.hasNext()) {
                String str = (String) it.next();
                g.RQ();
                g.RL().u(str, true);
            }
            this.eLw.clear();
            com.tencent.mm.blink.a.h("installPendingPlugins installed", nanoTime);
            g.RQ();
            g.RL().Rl();
            com.tencent.mm.blink.a.jD("installPendingPlugins dependency made.");
            com.tencent.mm.sdk.b.a.xxA.m(new mm());
        }
        boolean Bg = Bg();
        boolean z = gVar.SG() && g.RN().QY();
        if (z && !Bg) {
            g.RN().QZ();
        }
        com.tencent.mm.blink.b HQ = com.tencent.mm.blink.b.HQ();
        ab.i("MicroMsg.FirstScreenArrangement", "arrangeInitializePendingPlugins now? %s", Boolean.valueOf(Bg));
        if (Bg) {
            HQ.a(com.tencent.mm.blink.b.b.Now);
        } else {
            al.n(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(57704);
                    b.a(b.this, b.Timeout);
                    AppMethodBeat.o(57704);
                }
            }, 1000);
        }
        if (z && Bg) {
            g.RN().QZ();
        }
        com.tencent.mm.blink.a.jD("afterAccountInit");
    }

    public boolean Bg() {
        return true;
    }
}
