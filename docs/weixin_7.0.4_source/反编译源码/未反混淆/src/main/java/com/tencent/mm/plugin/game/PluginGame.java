package com.tencent.mm.plugin.game;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.api.bucket.c;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.kernel.b.g;
import com.tencent.mm.kernel.e;
import com.tencent.mm.plugin.game.a.a.a;
import com.tencent.mm.plugin.game.a.b;
import com.tencent.mm.plugin.game.a.d;
import com.tencent.mm.plugin.game.model.j;
import com.tencent.mm.plugin.messenger.foundation.a.p;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ab;

public class PluginGame extends f implements c, d {
    c mTo;

    public void configure(g gVar) {
        AppMethodBeat.i(111178);
        if (gVar.SG()) {
            ab.i("MicroMsg.PluginGame", "PluginGame configure");
            a.a(new b());
            if (this.mTo == null) {
                this.mTo = new c();
            }
        }
        if (gVar.lQ(":tools")) {
            h.pYm.k(939, 1, 1);
        }
        AppMethodBeat.o(111178);
    }

    public void execute(g gVar) {
        AppMethodBeat.i(111179);
        if (gVar.SG()) {
            ab.i("MicroMsg.PluginGame", "PluginGame execute");
            com.tencent.mm.bp.c.aks("game");
            com.tencent.mm.kernel.g.a(com.tencent.mm.plugin.game.a.c.class, new e());
            com.tencent.mm.kernel.g.a(b.class, new d());
        }
        AppMethodBeat.o(111179);
    }

    public void onAccountInitialized(e.c cVar) {
        AppMethodBeat.i(111180);
        ab.i("MicroMsg.PluginGame", "onAccountInitialized");
        if (this.mTo != null) {
            c cVar2 = this.mTo;
            ((p) com.tencent.mm.kernel.g.M(p.class)).getSysCmdMsgExtension().a("gamecenter", cVar2.luy, true);
            com.tencent.mm.sdk.b.a.xxA.c(cVar2.mSR);
            com.tencent.mm.sdk.b.a.xxA.c(cVar2.mSS);
            com.tencent.mm.sdk.b.a.xxA.c(cVar2.mST);
            com.tencent.mm.sdk.b.a.xxA.c(cVar2.egQ);
            com.tencent.mm.sdk.b.a.xxA.c(cVar2.mSU);
            com.tencent.mm.sdk.b.a.xxA.c(cVar2.mSV);
            com.tencent.mm.sdk.b.a.xxA.c(cVar2.mSW);
            com.tencent.mm.sdk.b.a.xxA.c(cVar2.mSX);
            com.tencent.mm.sdk.b.a.xxA.c(cVar2.mSY);
            com.tencent.mm.sdk.b.a.xxA.c(cVar2.mTb);
            com.tencent.mm.sdk.b.a.xxA.c(cVar2.mTc);
            com.tencent.mm.sdk.b.a.xxA.c(cVar2.mSZ);
            com.tencent.mm.sdk.b.a.xxA.c(cVar2.mTd);
            com.tencent.mm.sdk.b.a.xxA.c(cVar2.mTe);
            com.tencent.mm.sdk.b.a.xxA.c(cVar2.lOc);
            com.tencent.mm.sdk.b.a.xxA.c(cVar2.mTf);
            j.bie();
            com.tencent.mm.plugin.game.model.a.e.bie();
        }
        AppMethodBeat.o(111180);
    }

    public void onAccountRelease() {
        AppMethodBeat.i(111181);
        ab.i("MicroMsg.PluginGame", "onAccountRelease");
        if (this.mTo != null) {
            c cVar = this.mTo;
            ((p) com.tencent.mm.kernel.g.M(p.class)).getSysCmdMsgExtension().b("gamecenter", cVar.luy, true);
            com.tencent.mm.sdk.b.a.xxA.d(cVar.mSR);
            com.tencent.mm.sdk.b.a.xxA.d(cVar.mSS);
            com.tencent.mm.sdk.b.a.xxA.d(cVar.mST);
            com.tencent.mm.sdk.b.a.xxA.d(cVar.egQ);
            com.tencent.mm.sdk.b.a.xxA.d(cVar.mSU);
            com.tencent.mm.sdk.b.a.xxA.d(cVar.mSV);
            com.tencent.mm.sdk.b.a.xxA.d(cVar.mSW);
            com.tencent.mm.sdk.b.a.xxA.d(cVar.mSX);
            com.tencent.mm.sdk.b.a.xxA.d(cVar.mSY);
            com.tencent.mm.sdk.b.a.xxA.d(cVar.mTb);
            com.tencent.mm.sdk.b.a.xxA.d(cVar.mTc);
            com.tencent.mm.sdk.b.a.xxA.d(cVar.mSZ);
            com.tencent.mm.sdk.b.a.xxA.d(cVar.mTd);
            com.tencent.mm.sdk.b.a.xxA.d(cVar.mTe);
            com.tencent.mm.sdk.b.a.xxA.d(cVar.lOc);
            com.tencent.mm.sdk.b.a.xxA.d(cVar.mTf);
            j.bgr();
            com.tencent.mm.plugin.game.model.a.e.bgr();
        }
        com.tencent.mm.plugin.game.f.c.aNR();
        AppMethodBeat.o(111181);
    }
}
