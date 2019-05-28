package com.tencent.mm.plugin.bottle.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.at;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.bw;
import com.tencent.mm.model.c;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.ak;
import com.tencent.mm.storage.be;
import com.tencent.mm.storage.be.a;
import java.util.HashMap;

public final class d implements at {
    private static HashMap<Integer, com.tencent.mm.cd.h.d> eaA;
    private a flN = new a() {
        public final void a(ak akVar, be beVar) {
            AppMethodBeat.i(18537);
            if (akVar == null) {
                AppMethodBeat.o(18537);
            } else if ("_USER_FOR_THROWBOTTLE_".equals(akVar.field_username)) {
                akVar.setUsername("");
                AppMethodBeat.o(18537);
            } else {
                if (!(1 == akVar.field_isSend || !ad.mR(akVar.field_username) || beVar.MV(akVar.field_username))) {
                    c.FA(akVar.field_username);
                }
                AppMethodBeat.o(18537);
            }
        }
    };
    private b jJM;

    public d() {
        AppMethodBeat.i(18538);
        AppMethodBeat.o(18538);
    }

    private static d aVL() {
        AppMethodBeat.i(18539);
        aw.ZE();
        d dVar = (d) bw.oJ("plugin.bottle");
        if (dVar == null) {
            dVar = new d();
            aw.ZE().a("plugin.bottle", dVar);
        }
        AppMethodBeat.o(18539);
        return dVar;
    }

    public static b aVM() {
        AppMethodBeat.i(18540);
        g.RN().QU();
        if (aVL().jJM == null) {
            d aVL = aVL();
            aw.ZK();
            aVL.jJM = new b(c.Ru());
        }
        b bVar = aVL().jJM;
        AppMethodBeat.o(18540);
        return bVar;
    }

    public final void onAccountRelease() {
        AppMethodBeat.i(18541);
        aw.ZK();
        c.XR().d(this.flN);
        AppMethodBeat.o(18541);
    }

    static {
        AppMethodBeat.i(18543);
        HashMap hashMap = new HashMap();
        eaA = hashMap;
        hashMap.put(Integer.valueOf("THROWBOTTLEINFO_TABLE".hashCode()), new com.tencent.mm.cd.h.d() {
            public final String[] Af() {
                return b.fnj;
            }
        });
        AppMethodBeat.o(18543);
    }

    public final HashMap<Integer, com.tencent.mm.cd.h.d> Jx() {
        return eaA;
    }

    public final void iy(int i) {
    }

    public final void bz(boolean z) {
        AppMethodBeat.i(18542);
        c.aVK();
        aw.ZK();
        c.XR().c(this.flN);
        AppMethodBeat.o(18542);
    }

    public final void bA(boolean z) {
    }
}
