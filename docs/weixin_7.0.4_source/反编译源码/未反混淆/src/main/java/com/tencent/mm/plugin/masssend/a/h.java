package com.tencent.mm.plugin.masssend.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.e;
import com.tencent.mm.cd.h.d;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.at;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.bw;
import com.tencent.mm.model.bz.a;
import com.tencent.mm.model.c;
import com.tencent.mm.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.HashMap;

public final class h implements at {
    private static HashMap<Integer, d> eaA;
    private a olc = new a() {
        public final void a(e.a aVar) {
            AppMethodBeat.i(22744);
            String a = aa.a(aVar.eAB.vED);
            ab.i("MicroMsg.SubCoreMassSend", "MassSendTopConfXml:".concat(String.valueOf(a)));
            h.bNF().Qt(a);
            h.bNF().bNA();
            h.bNF();
            c.je(bo.anU());
            AppMethodBeat.o(22744);
        }
    };
    private b ooi;
    private c ooj;
    private i ook = new i();
    private g ool = new g();

    public h() {
        AppMethodBeat.i(22745);
        AppMethodBeat.o(22745);
    }

    private static h bND() {
        AppMethodBeat.i(22746);
        aw.ZE();
        h hVar = (h) bw.oJ("plugin.masssend");
        if (hVar == null) {
            hVar = new h();
            aw.ZE().a("plugin.favorite", hVar);
        }
        AppMethodBeat.o(22746);
        return hVar;
    }

    public static b bNE() {
        AppMethodBeat.i(22747);
        g.RN().QU();
        if (bND().ooi == null) {
            h bND = bND();
            aw.ZK();
            bND.ooi = new b(c.Ru());
        }
        b bVar = bND().ooi;
        AppMethodBeat.o(22747);
        return bVar;
    }

    public static c bNF() {
        AppMethodBeat.i(22748);
        if (bND().ooj == null) {
            bND().ooj = new c();
        }
        c cVar = bND().ooj;
        AppMethodBeat.o(22748);
        return cVar;
    }

    public final void onAccountRelease() {
        AppMethodBeat.i(22749);
        aw.getSysCmdMsgExtension().b("masssendapp", this.olc, false);
        com.tencent.mm.sdk.b.a.xxA.d(this.ook);
        com.tencent.mm.sdk.b.a.xxA.d(this.ool);
        AppMethodBeat.o(22749);
    }

    static {
        AppMethodBeat.i(22751);
        HashMap hashMap = new HashMap();
        eaA = hashMap;
        hashMap.put(Integer.valueOf("MASSENDINFO_TABLE".hashCode()), new d() {
            public final String[] Af() {
                return b.fnj;
            }
        });
        AppMethodBeat.o(22751);
    }

    public final HashMap<Integer, d> Jx() {
        return eaA;
    }

    public final void iy(int i) {
    }

    public final void bz(boolean z) {
        AppMethodBeat.i(22750);
        aw.getSysCmdMsgExtension().a("masssendapp", this.olc, false);
        com.tencent.mm.sdk.b.a.xxA.c(this.ook);
        com.tencent.mm.sdk.b.a.xxA.c(this.ool);
        AppMethodBeat.o(22750);
    }

    public final void bA(boolean z) {
    }
}
