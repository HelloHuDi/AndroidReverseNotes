package com.tencent.mm.pluginsdk.model.app;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.e;
import com.tencent.mm.cd.h.d;
import com.tencent.mm.g.a.cq;
import com.tencent.mm.g.a.cy;
import com.tencent.mm.g.a.hn;
import com.tencent.mm.m.g;
import com.tencent.mm.model.ad;
import com.tencent.mm.model.at;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.bw;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.pluginsdk.model.app.al.a;
import com.tencent.mm.pluginsdk.model.b;
import com.tencent.mm.pluginsdk.model.j;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.HashMap;

public class am implements at {
    private static HashMap<Integer, d> eaA;
    private o vcO;
    private a vcP = null;
    private j vcQ = new j();
    private b vcR = new b();
    private c vcS = new c<hn>() {
        {
            AppMethodBeat.i(27414);
            this.xxI = hn.class.getName().hashCode();
            AppMethodBeat.o(27414);
        }

        private static boolean a(hn hnVar) {
            int i;
            AppMethodBeat.i(27415);
            try {
                if (g.Nu() == null) {
                    i = 0;
                } else {
                    i = bo.getInt(g.Nu().getValue("AndroidUseUnicodeEmoji"), 0);
                }
            } catch (Exception e) {
                i = 0;
            }
            hnVar.cCr.cwb = i;
            AppMethodBeat.o(27415);
            return false;
        }
    };
    private c vcT = new c<cq>() {
        {
            AppMethodBeat.i(27417);
            this.xxI = cq.class.getName().hashCode();
            AppMethodBeat.o(27417);
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            AppMethodBeat.i(27418);
            int i = bo.getInt(g.Nu().getValue("AndroidUseUnicodeEmoji"), 0);
            cy cyVar = new cy();
            cyVar.cwa.cwb = i;
            com.tencent.mm.sdk.b.a.xxA.m(cyVar);
            AppMethodBeat.o(27418);
            return false;
        }
    };

    public am() {
        AppMethodBeat.i(27419);
        AppMethodBeat.o(27419);
    }

    private static am dhL() {
        AppMethodBeat.i(27420);
        aw.ZE();
        am amVar = (am) bw.oJ(am.class.getName());
        if (amVar == null) {
            amVar = new am();
        }
        AppMethodBeat.o(27420);
        return amVar;
    }

    public static j dhM() {
        AppMethodBeat.i(27421);
        j jVar = dhL().vcQ;
        AppMethodBeat.o(27421);
        return jVar;
    }

    public static c aUq() {
        AppMethodBeat.i(27422);
        c aUq = com.tencent.mm.plugin.s.a.aUq();
        AppMethodBeat.o(27422);
        return aUq;
    }

    public static h bYI() {
        AppMethodBeat.i(27423);
        h bYI = com.tencent.mm.plugin.s.a.bYI();
        AppMethodBeat.o(27423);
        return bYI;
    }

    public static i bYJ() {
        AppMethodBeat.i(27424);
        i bYJ = com.tencent.mm.plugin.s.a.bYJ();
        AppMethodBeat.o(27424);
        return bYJ;
    }

    public static k dhN() {
        AppMethodBeat.i(27425);
        k bYK = com.tencent.mm.plugin.s.a.bYK();
        AppMethodBeat.o(27425);
        return bYK;
    }

    public static o dhO() {
        AppMethodBeat.i(27426);
        com.tencent.mm.kernel.g.RN().QU();
        if (dhL().vcO == null) {
            am dhL = dhL();
            aw.ZK();
            dhL.vcO = new o(com.tencent.mm.model.c.Ru());
        }
        o oVar = dhL().vcO;
        AppMethodBeat.o(27426);
        return oVar;
    }

    public static a dhP() {
        AppMethodBeat.i(27427);
        com.tencent.mm.kernel.g.RN().QU();
        if (dhL().vcP == null) {
            dhL().vcP = new a();
        }
        a aVar = dhL().vcP;
        AppMethodBeat.o(27427);
        return aVar;
    }

    public static m bYL() {
        AppMethodBeat.i(27428);
        m bYL = com.tencent.mm.plugin.s.a.bYL();
        AppMethodBeat.o(27428);
        return bYL;
    }

    public static d bYM() {
        AppMethodBeat.i(27429);
        d bYM = com.tencent.mm.plugin.s.a.bYM();
        AppMethodBeat.o(27429);
        return bYM;
    }

    public final void onAccountRelease() {
        AppMethodBeat.i(27430);
        a aVar = dhL().vcP;
        if (aVar != null) {
            aVar.cqV = 0;
        }
        e.d.b(Integer.valueOf(47), this.vcR);
        e.d.b(Integer.valueOf(49), this.vcQ);
        com.tencent.mm.sdk.b.a.xxA.d(this.vcS);
        com.tencent.mm.sdk.b.a.xxA.d(this.vcT);
        j.dhc();
        AppMethodBeat.o(27430);
    }

    static {
        AppMethodBeat.i(27432);
        HashMap hashMap = new HashMap();
        eaA = hashMap;
        hashMap.put(Integer.valueOf("APPMESSAGE_TABLE".hashCode()), new d() {
            public final String[] Af() {
                return k.fnj;
            }
        });
        eaA.put(Integer.valueOf("APPSORT_TABLE".hashCode()), new d() {
            public final String[] Af() {
                return o.fnj;
            }
        });
        AppMethodBeat.o(27432);
    }

    public final HashMap<Integer, d> Jx() {
        return eaA;
    }

    public final void iy(int i) {
    }

    public final void bA(boolean z) {
    }

    public final void bz(boolean z) {
        AppMethodBeat.i(27431);
        ad.a.fls = com.tencent.mm.plugin.s.a.bYI();
        e.d.a(Integer.valueOf(47), this.vcR);
        e.d.a(Integer.valueOf(49), this.vcQ);
        com.tencent.mm.sdk.b.a.xxA.c(this.vcS);
        com.tencent.mm.sdk.b.a.xxA.c(this.vcT);
        AnonymousClass3 anonymousClass3 = new Runnable() {
            public final void run() {
                AppMethodBeat.i(27413);
                SightVideoJNI.registerALL();
                AppMethodBeat.o(27413);
            }
        };
        try {
            anonymousClass3.run();
            AppMethodBeat.o(27431);
        } catch (Throwable th) {
            if (com.tencent.mm.compatible.util.d.fP(20)) {
                anonymousClass3.run();
                AppMethodBeat.o(27431);
                return;
            }
            AppMethodBeat.o(27431);
        }
    }
}
