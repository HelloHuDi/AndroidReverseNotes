package com.tencent.mm.plugin.bbom;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.sf;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ao;
import com.tencent.mm.modelvideo.o;
import com.tencent.mm.modelvoice.m;
import com.tencent.mm.network.n.a;
import com.tencent.mm.pluginsdk.model.app.am;
import com.tencent.mm.sdk.platformtools.ab;

public final class p {
    private static boolean jEw = false;

    public static synchronized void cR(final Context context) {
        synchronized (p.class) {
            AppMethodBeat.i(18276);
            if (jEw) {
                AppMethodBeat.o(18276);
            } else {
                jEw = true;
                g.RO().a(new a() {
                    public final void gl(int i) {
                        AppMethodBeat.i(18275);
                        if (i == 4 || i == 6) {
                            p.aVr();
                            AppMethodBeat.o(18275);
                            return;
                        }
                        AppMethodBeat.o(18275);
                    }
                });
                AppMethodBeat.o(18276);
            }
        }
    }

    static /* synthetic */ void aVr() {
        AppMethodBeat.i(18277);
        if (!g.RK() || com.tencent.mm.kernel.a.QT()) {
            ab.w("MicroMsg.OnNetworkAvailableListener", "dealWithNetworkAvailable hasSetuin:" + g.RK() + " isHold:" + com.tencent.mm.kernel.a.QT());
            AppMethodBeat.o(18277);
            return;
        }
        m.amc().run();
        o.alq().run();
        com.tencent.mm.at.o.ahj().run();
        am.dhP().run();
        if (ao.a.flx != null) {
            ao.a.flx.Zw();
        }
        com.tencent.mm.sdk.b.a.xxA.m(new sf());
        AppMethodBeat.o(18277);
    }
}
