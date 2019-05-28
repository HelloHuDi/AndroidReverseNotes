package com.tencent.mm.openim;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.m;
import com.tencent.mm.cd.h.d;
import com.tencent.mm.g.a.hx;
import com.tencent.mm.g.a.lx;
import com.tencent.mm.g.a.ly;
import com.tencent.mm.kernel.api.a;
import com.tencent.mm.kernel.api.bucket.c;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ah;
import com.tencent.mm.openim.b.j;
import com.tencent.mm.openim.b.r;
import com.tencent.mm.openim.b.t;
import com.tencent.mm.openim.d.p;
import com.tencent.mm.plugin.appbrand.jsapi.k.l;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.HashMap;

public class PluginOpenIM extends f implements a, c {
    public static HashMap<Integer, d> eaA;
    private com.tencent.mm.ai.f fur = new com.tencent.mm.ai.f() {
        public final void onSceneEnd(int i, int i2, String str, m mVar) {
            AppMethodBeat.i(78824);
            if (mVar instanceof j) {
                j jVar = (j) mVar;
                ly lyVar = new ly();
                lyVar.cHM.cHN = jVar.cHN;
                com.tencent.mm.sdk.b.a.xxA.m(lyVar);
            }
            AppMethodBeat.o(78824);
        }
    };
    private com.tencent.mm.sdk.b.c geL = new com.tencent.mm.sdk.b.c<lx>() {
        {
            AppMethodBeat.i(78820);
            this.xxI = lx.class.getName().hashCode();
            AppMethodBeat.o(78820);
        }

        public final /* synthetic */ boolean a(b bVar) {
            AppMethodBeat.i(78821);
            g.RQ();
            g.RO().eJo.a(new r(), 0);
            AppMethodBeat.o(78821);
            return true;
        }
    };
    private com.tencent.mm.sdk.b.c geM = new com.tencent.mm.sdk.b.c<hx>() {
        {
            AppMethodBeat.i(78822);
            this.xxI = hx.class.getName().hashCode();
            AppMethodBeat.o(78822);
        }

        public final /* synthetic */ boolean a(b bVar) {
            AppMethodBeat.i(78823);
            String str = ((hx) bVar).cCQ.userName;
            g.RQ();
            g.RO().eJo.a(new j(str), 0);
            AppMethodBeat.o(78823);
            return true;
        }
    };
    private com.tencent.mm.openim.e.d geN;
    private com.tencent.mm.openim.e.b geO;
    private com.tencent.mm.openim.e.f geP;

    public PluginOpenIM() {
        AppMethodBeat.i(78825);
        AppMethodBeat.o(78825);
    }

    public com.tencent.mm.openim.e.d getAppIdInfoStg() {
        AppMethodBeat.i(78826);
        g.RN().QU();
        if (this.geO == null) {
            g.RQ();
            this.geN = new com.tencent.mm.openim.e.d(g.RP().eJN);
        }
        com.tencent.mm.openim.e.d dVar = this.geN;
        AppMethodBeat.o(78826);
        return dVar;
    }

    public com.tencent.mm.openim.e.b getAccTypeInfoStg() {
        AppMethodBeat.i(78827);
        g.RN().QU();
        if (this.geO == null) {
            g.RQ();
            this.geO = new com.tencent.mm.openim.e.b(g.RP().eJN);
        }
        com.tencent.mm.openim.e.b bVar = this.geO;
        AppMethodBeat.o(78827);
        return bVar;
    }

    public com.tencent.mm.openim.e.f getWordingInfoStg() {
        AppMethodBeat.i(78828);
        g.RN().QU();
        if (this.geP == null) {
            g.RQ();
            this.geP = new com.tencent.mm.openim.e.f(g.RP().eJN);
        }
        com.tencent.mm.openim.e.f fVar = this.geP;
        AppMethodBeat.o(78828);
        return fVar;
    }

    public void onAccountInitialized(e.c cVar) {
        AppMethodBeat.i(78829);
        ab.i("MicroMsg.PluginOpenIM", "onAccountInitialized");
        com.tencent.mm.sdk.b.a.xxA.b(this.geL);
        this.geM.dnU();
        g.RQ();
        g.a(com.tencent.mm.openim.a.b.class, new t());
        g.RQ();
        g.a(com.tencent.mm.openim.a.a.class, new p());
        com.tencent.mm.model.t.a((ah) g.K(com.tencent.mm.openim.a.a.class));
        g.RQ();
        g.RO().eJo.a((int) l.CTRL_INDEX, (com.tencent.mm.ai.f) g.K(com.tencent.mm.openim.a.b.class));
        g.RQ();
        g.RO().eJo.a(913, this.fur);
        AppMethodBeat.o(78829);
    }

    public void onAccountRelease() {
        AppMethodBeat.i(78830);
        ab.i("MicroMsg.PluginOpenIM", "onAccountRelease");
        com.tencent.mm.sdk.b.a.xxA.d(this.geL);
        this.geM.dead();
        g.RQ();
        g.RO().eJo.b((int) l.CTRL_INDEX, (com.tencent.mm.ai.f) g.K(com.tencent.mm.openim.a.b.class));
        g.RQ();
        g.RO().eJo.b(913, this.fur);
        AppMethodBeat.o(78830);
    }

    public void execute(com.tencent.mm.kernel.b.g gVar) {
    }

    public void configure(com.tencent.mm.kernel.b.g gVar) {
    }

    static {
        AppMethodBeat.i(78831);
        HashMap hashMap = new HashMap();
        eaA = hashMap;
        hashMap.put(Integer.valueOf("OpenIMAccTypeInfo_TABLE".hashCode()), new d() {
            public final String[] Af() {
                return com.tencent.mm.openim.e.b.fnj;
            }
        });
        eaA.put(Integer.valueOf("OpenIMAppIdInfo_TABLE".hashCode()), new d() {
            public final String[] Af() {
                return com.tencent.mm.openim.e.d.fnj;
            }
        });
        eaA.put(Integer.valueOf("OpenIMWordingInfo_TABLE".hashCode()), new d() {
            public final String[] Af() {
                return com.tencent.mm.openim.e.f.fnj;
            }
        });
        AppMethodBeat.o(78831);
    }

    public HashMap<Integer, d> collectDatabaseFactory() {
        return eaA;
    }
}
