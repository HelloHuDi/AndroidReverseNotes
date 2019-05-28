package com.tencent.mm.plugin.e;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.n;
import com.tencent.mm.ai.p;
import com.tencent.mm.booter.NotifyReceiver.NotifyService;
import com.tencent.mm.bp.d;
import com.tencent.mm.g.a.sz;
import com.tencent.mm.kernel.a.c.a;
import com.tencent.mm.kernel.b.g;
import com.tencent.mm.model.am;
import com.tencent.mm.model.aw;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.MMAppMgr;

public final class e extends a {
    private am flA;

    public e(am amVar) {
        this.flA = amVar;
    }

    public final void execute(g gVar) {
        AppMethodBeat.i(18526);
        aw.a(this.flA, new p.a() {
            public final void a(p pVar, boolean z) {
                AppMethodBeat.i(18525);
                if (z && !pVar.foreground) {
                    if (e.aVI()) {
                        MMAppMgr.dyr();
                        ab.e("MicroMsg.MMCoreInitTask", "now killing the working process....");
                        if (com.tencent.mm.platformtools.a.anD()) {
                            ab.e("MicroMsg.MMCoreInitTask", "address book syncing, wait a minute please");
                            AppMethodBeat.o(18525);
                            return;
                        }
                        d.aI(new Intent(ah.getContext(), NotifyService.class));
                        n.x(new Runnable() {
                            public final void run() {
                            }
                        });
                    } else {
                        ab.w("MicroMsg.MMCoreInitTask", "can't kill the working process");
                        AppMethodBeat.o(18525);
                        return;
                    }
                }
                AppMethodBeat.o(18525);
            }

            public final void a(p pVar) {
            }
        });
        AppMethodBeat.o(18526);
    }

    static /* synthetic */ boolean aVI() {
        AppMethodBeat.i(18527);
        if (com.tencent.mm.aw.a.aie()) {
            AppMethodBeat.o(18527);
            return false;
        }
        sz szVar = new sz();
        szVar.cPf.cPh = true;
        com.tencent.mm.sdk.b.a.xxA.m(szVar);
        if (bo.isNullOrNil(szVar.cPg.cPj)) {
            AppMethodBeat.o(18527);
            return true;
        }
        AppMethodBeat.o(18527);
        return false;
    }
}
