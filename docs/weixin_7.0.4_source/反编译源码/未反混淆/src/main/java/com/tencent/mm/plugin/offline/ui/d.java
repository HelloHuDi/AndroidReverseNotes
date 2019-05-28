package com.tencent.mm.plugin.offline.ui;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.su;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.offline.i;
import com.tencent.mm.plugin.offline.k;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;

public final class d extends c<su> {
    private ak mHandler;

    public d() {
        AppMethodBeat.i(43501);
        this.mHandler = new ak(Looper.getMainLooper());
        this.xxI = su.class.getName().hashCode();
        AppMethodBeat.o(43501);
    }

    public final /* synthetic */ boolean a(b bVar) {
        AppMethodBeat.i(43502);
        final su suVar = (su) bVar;
        if (g.RK() && (suVar instanceof su)) {
            ab.i("MicroMsg.SyncOfflineTokenListener", "SyncOfflineTokenListener -> updateToken()");
            boolean z = suVar.cOT.cOU;
            final boolean z2 = suVar.cOT.scene == 1;
            if (z2) {
                h.pYm.a(135, 25, 1, true);
            }
            if (z) {
                this.mHandler.postDelayed(new Runnable() {
                    public final void run() {
                        AppMethodBeat.i(43500);
                        if (g.RK()) {
                            if (suVar.cOT.cOV) {
                                k.bXg();
                                i bXj = k.bXj();
                                int i = suVar.cOT.cOW;
                                bXj.eO(i, i);
                                AppMethodBeat.o(43500);
                                return;
                            }
                            k.bXg();
                            k.bXj().jF(z2);
                        }
                        AppMethodBeat.o(43500);
                    }
                }, 10000);
            } else if (suVar.cOT.cOV) {
                k.bXg();
                i bXj = k.bXj();
                int i = suVar.cOT.cOW;
                bXj.eO(i, i);
            } else {
                k.bXg();
                k.bXj().jF(z2);
            }
        }
        AppMethodBeat.o(43502);
        return false;
    }
}
