package com.tencent.mm.plugin.game;

import android.content.Context;
import android.content.Intent;
import com.facebook.device.yearclass.YearClass;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.ky;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.game.a.a;
import com.tencent.mm.plugin.game.f.c;
import com.tencent.mm.plugin.game.model.e;
import com.tencent.mm.plugin.game.model.n;
import com.tencent.mm.plugin.game.model.q;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pluginsdk.model.app.f;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;

public final class b implements a {
    private boolean mSP = false;
    private boolean mSQ = false;

    public final boolean bCS() {
        AppMethodBeat.i(111124);
        try {
            boolean bDd = com.tencent.mm.plugin.game.commlib.a.bDd();
            AppMethodBeat.o(111124);
            return bDd;
        } catch (Exception e) {
            AppMethodBeat.o(111124);
            return true;
        }
    }

    public final void dV(Context context) {
        AppMethodBeat.i(111132);
        e.dV(context);
        AppMethodBeat.o(111132);
    }

    public final String bCT() {
        AppMethodBeat.i(111133);
        String ef = e.ef(ah.getContext());
        AppMethodBeat.o(111133);
        return ef;
    }

    public final void hH(boolean z) {
        AppMethodBeat.i(111134);
        if (!this.mSQ) {
            boolean z2;
            if (((com.tencent.mm.game.report.a.b) g.K(com.tencent.mm.game.report.a.b.class)).a(com.tencent.mm.plugin.expt.a.a.a.game_luggage) && ((com.tencent.mm.game.report.a.b) g.K(com.tencent.mm.game.report.a.b.class)).a(com.tencent.mm.plugin.expt.a.a.a.preload_game_webcore)) {
                ab.i("MicroMsg.GameDelegateImpl", "hit expt preload");
                h.pYm.k(939, 4, 1);
                if (YearClass.get(ah.getContext()) < 2014) {
                    ab.i("MicroMsg.GameDelegateImpl", "device score smaller than 2014");
                    h.pYm.k(939, 5, 1);
                    z2 = false;
                } else {
                    if (System.currentTimeMillis() - e.bEd() > 21600000) {
                        ab.i("MicroMsg.GameDelegateImpl", "larger than 6 hours");
                        if (z) {
                            ((com.tencent.mm.plugin.game.a.b) g.K(com.tencent.mm.plugin.game.a.b.class)).bCX();
                            n bEm = q.bEm();
                            if (bEm == null || System.currentTimeMillis() - (bEm.field_receiveTime * 1000) > 21600000) {
                                ab.i("MicroMsg.GameDelegateImpl", "red dot larger than 6 hours");
                                h.pYm.k(939, 7, 1);
                                z2 = false;
                            }
                        } else {
                            h.pYm.k(939, 6, 1);
                            z2 = false;
                        }
                    }
                    if (com.tencent.mm.sdk.platformtools.g.dnY()) {
                        ab.i("MicroMsg.GameDelegateImpl", "isGPVersion");
                        h.pYm.k(939, 8, 1);
                        z2 = false;
                    } else if (bo.isNullOrNil(c.bFG())) {
                        h.pYm.k(939, 9, 1);
                        z2 = false;
                    } else {
                        z2 = true;
                    }
                }
            } else {
                z2 = false;
            }
            this.mSP = z2;
            this.mSQ = true;
        }
        if (this.mSP) {
            String bFG = c.bFG();
            if (!bo.isNullOrNil(bFG)) {
                ab.i("MicroMsg.GameDelegateImpl", "preload");
                ky kyVar = new ky();
                kyVar.cGQ.type = 3;
                Intent intent = new Intent();
                intent.putExtra("rawUrl", bFG);
                kyVar.cGQ.intent = intent;
                com.tencent.mm.sdk.b.a.xxA.m(kyVar);
            }
        }
        AppMethodBeat.o(111134);
    }

    public final void a(String str, String str2, int i, int i2, String str3, int i3) {
        AppMethodBeat.i(111125);
        com.tencent.mm.game.report.api.c.eBG.a(str, str2, i, i2, str3, i3);
        AppMethodBeat.o(111125);
    }

    public final void a(Context context, String str, String str2, String str3, int i, String str4, int i2) {
        AppMethodBeat.i(111126);
        com.tencent.mm.game.report.api.c.eBG.a(context, str, str2, str3, i, str4, i2);
        AppMethodBeat.o(111126);
    }

    public final void a(String str, String str2, int i, int i2, String str3, long j, String str4) {
        AppMethodBeat.i(111127);
        f bT = com.tencent.mm.pluginsdk.model.app.g.bT(str, true);
        if (bT != null) {
            com.tencent.mm.game.report.api.c.eBG.a(str, str2, i, i2, str3, j, bT.xy(), str4);
        }
        AppMethodBeat.o(111127);
    }

    public final void W(String str, int i, int i2) {
        AppMethodBeat.i(111128);
        com.tencent.mm.game.report.api.c.eBG.i(str, i, i2);
        AppMethodBeat.o(111128);
    }

    public final void m(String str, String str2, String str3) {
        AppMethodBeat.i(111129);
        com.tencent.mm.game.report.api.c.eBG.m(str, str2, str3);
        AppMethodBeat.o(111129);
    }

    public final void j(Context context, String str, String str2) {
        AppMethodBeat.i(111130);
        com.tencent.mm.game.report.api.c.eBG.j(context, str, str2);
        AppMethodBeat.o(111130);
    }

    public final void a(Context context, String str, String str2, String str3, int i, int i2, int i3, String str4, String str5, String str6) {
        AppMethodBeat.i(111131);
        com.tencent.mm.game.report.api.c.eBG.a(context, str, str2, str3, i, i2, i3, str4, 0, str5, str6);
        AppMethodBeat.o(111131);
    }
}
