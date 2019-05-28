package com.tencent.mm.plugin.appbrand.jsapi.appdownload;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.b.c.a;
import com.tencent.mm.plugin.appbrand.ipc.MMToClientEvent;
import com.tencent.mm.plugin.appbrand.ipc.MMToClientEvent.c;
import com.tencent.mm.plugin.appbrand.ipc.d;
import com.tencent.mm.plugin.appbrand.jsapi.p;
import com.tencent.mm.plugin.appbrand.q;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.HashMap;

public final class b extends p {
    public static final int CTRL_INDEX = -2;
    public static final String NAME = "onDownloadAppStateChange";
    private static HashMap<String, b> hzE = new HashMap();
    private c hzD;

    private b(final q qVar) {
        AppMethodBeat.i(130646);
        this.hzD = new c() {
            public final void bk(Object obj) {
                AppMethodBeat.i(130644);
                if (obj instanceof AppbrandDownloadState) {
                    AppbrandDownloadState appbrandDownloadState = (AppbrandDownloadState) obj;
                    if (qVar != null) {
                        b.this.i(qVar).AL(appbrandDownloadState.aCq().toString()).aCj();
                    }
                }
                AppMethodBeat.o(130644);
            }
        };
        MMToClientEvent.a(qVar.getAppId(), this.hzD);
        qVar.getRuntime().gNN.a(new a() {
            public final void a(String str, com.tencent.mm.plugin.appbrand.b.b bVar) {
                AppMethodBeat.i(130645);
                if (bVar == com.tencent.mm.plugin.appbrand.b.b.DESTROYED) {
                    ab.d("MicroMsg.DownloadAppStateChangeEvent", "destroyed");
                    MMToClientEvent.b(qVar.getAppId(), b.this.hzD);
                    b.f(qVar);
                }
                AppMethodBeat.o(130645);
            }
        });
        AppMethodBeat.o(130646);
    }

    static {
        AppMethodBeat.i(130650);
        AppMethodBeat.o(130650);
    }

    public static void e(q qVar) {
        AppMethodBeat.i(130647);
        if (hzE.containsKey(qVar.getAppId())) {
            AppMethodBeat.o(130647);
            return;
        }
        hzE.put(qVar.getAppId(), new b(qVar));
        AppMethodBeat.o(130647);
    }

    public static void a(AppbrandDownloadState appbrandDownloadState) {
        AppMethodBeat.i(130648);
        for (String a : hzE.keySet()) {
            d.a(a, appbrandDownloadState);
        }
        AppMethodBeat.o(130648);
    }

    static /* synthetic */ void f(q qVar) {
        AppMethodBeat.i(130649);
        hzE.remove(qVar.getAppId());
        AppMethodBeat.o(130649);
    }
}
