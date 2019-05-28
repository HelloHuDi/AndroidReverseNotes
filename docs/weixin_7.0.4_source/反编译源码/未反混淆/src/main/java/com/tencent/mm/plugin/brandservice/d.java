package com.tencent.mm.plugin.brandservice;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.m;
import com.tencent.mm.g.a.qi;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.at;
import com.tencent.mm.model.q;
import com.tencent.mm.plugin.brandservice.b.k;
import com.tencent.mm.plugin.brandservice.ui.timeline.preload.a.b;
import com.tencent.mm.plugin.fts.a.n;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.HashMap;

public class d implements at {
    private static HashMap<Integer, com.tencent.mm.cd.h.d> eaA;
    private a jKr;
    private b jKs;

    public static class a extends c<qi> {
        public a() {
            AppMethodBeat.i(13815);
            this.xxI = qi.class.getName().hashCode();
            AppMethodBeat.o(13815);
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            AppMethodBeat.i(13816);
            qi qiVar = (qi) bVar;
            if (qiVar instanceof qi) {
                if (!(qiVar.cMy == null || bo.isNullOrNil(qiVar.cMy.cKE) || qiVar.cMy.cMz == null)) {
                    m kVar = new k(qiVar.cMy.cKE, qiVar.cMy.cMz);
                    g.RQ();
                    g.Rg().a(kVar, 0);
                }
                AppMethodBeat.o(13816);
                return true;
            }
            ab.f("MicroMsg.BrandService.SubCoreBrandService", "mismatched event");
            AppMethodBeat.o(13816);
            return false;
        }
    }

    private static d aVS() {
        AppMethodBeat.i(13817);
        d dVar = (d) q.Y(d.class);
        AppMethodBeat.o(13817);
        return dVar;
    }

    static {
        AppMethodBeat.i(13821);
        HashMap hashMap = new HashMap();
        eaA = hashMap;
        hashMap.put(Integer.valueOf("BIZAPPMSGREPORTCCONTEXT_TABLE".hashCode()), new com.tencent.mm.cd.h.d() {
            public final String[] Af() {
                return b.fjY;
            }
        });
        AppMethodBeat.o(13821);
    }

    public final HashMap<Integer, com.tencent.mm.cd.h.d> Jx() {
        return eaA;
    }

    public final void iy(int i) {
    }

    public final void bA(boolean z) {
    }

    public final void bz(boolean z) {
        AppMethodBeat.i(13818);
        ab.d("MicroMsg.BrandService.SubCoreBrandService", "on sub core brand service reset");
        if (this.jKr == null) {
            this.jKr = new a();
        }
        com.tencent.mm.sdk.b.a.xxA.c(this.jKr);
        ((n) g.M(n.class)).registerFTSUILogic(new com.tencent.mm.plugin.brandservice.ui.a.d());
        ((n) g.M(n.class)).registerFTSUILogic(new com.tencent.mm.plugin.brandservice.ui.a.b());
        AppMethodBeat.o(13818);
    }

    public final void onAccountRelease() {
        AppMethodBeat.i(13819);
        if (this.jKr != null) {
            com.tencent.mm.sdk.b.a.xxA.d(this.jKr);
        }
        ((n) g.M(n.class)).unregisterFTSUILogic(96);
        ((n) g.M(n.class)).unregisterFTSUILogic(4208);
        AppMethodBeat.o(13819);
    }

    public static b aVT() {
        AppMethodBeat.i(13820);
        g.RN().QU();
        if (aVS().jKs == null) {
            aVS().jKs = new b(g.RP().eJN);
        }
        b bVar = aVS().jKs;
        AppMethodBeat.o(13820);
        return bVar;
    }
}
