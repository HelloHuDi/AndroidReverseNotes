package com.tencent.mm.plugin.soter.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.soter.d.h;
import com.tencent.mm.plugin.soter.d.m;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.vending.g.b;
import com.tencent.mm.vending.g.f;
import com.tencent.mm.vending.j.c;
import com.tencent.soter.a.b.d;
import com.tencent.soter.a.b.e;

public final class a implements com.tencent.mm.vending.c.a<c<Boolean, Boolean>, c<Boolean, Boolean>> {
    private b glt = null;

    public final /* synthetic */ Object call(Object obj) {
        AppMethodBeat.i(59354);
        c cVar = (c) obj;
        ab.v("MicroMsg.SoterInitFunc", "alvinluo SoterInitFunc call");
        com.tencent.soter.a.g.e.a aVar = new com.tencent.soter.a.g.e.a();
        aVar.Awt.Awp = m.cvS();
        aVar.Awt.Aws = "WechatASK";
        aVar = aVar.E(1, 2, 3);
        aVar.Awt.Awo = null;
        aVar.Awt.Awr = new h();
        e eVar = new e(ah.getContext(), aVar.Awt);
        this.glt = f.dMj();
        this.glt.dMi();
        eVar.Awl = new com.tencent.soter.a.b.b<d>() {
            public final /* synthetic */ void a(e eVar) {
                AppMethodBeat.i(59353);
                d dVar = (d) eVar;
                ab.i("MicroMsg.SoterInitFunc", "alvinluo SoterInitFunc onResult errCode: %d, errMsg: %s", Integer.valueOf(dVar.errCode), dVar.aIm);
                if (dVar.isSuccess()) {
                    ab.v("MicroMsg.SoterInitFunc", "alvinluo resume %d", Long.valueOf(System.currentTimeMillis()));
                    a.this.glt.resume();
                    AppMethodBeat.o(59353);
                    return;
                }
                com.tencent.mm.plugin.soter.d.a.fH(0, dVar.errCode);
                a.this.glt.cR(f.E(Integer.valueOf(dVar.errCode), dVar.aIm));
                AppMethodBeat.o(59353);
            }
        };
        if (!com.tencent.soter.a.g.f.dRn().a(eVar, new d())) {
            ab.e("MicroMsg.SoterInitFunc", "alvinluo: add soterTaskInitForWX failed.");
        }
        ab.v("MicroMsg.SoterInitFunc", "alvinluo pending %d", Long.valueOf(System.currentTimeMillis()));
        AppMethodBeat.o(59354);
        return cVar;
    }
}
