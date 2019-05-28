package com.tencent.mm.plugin.appbrand.m.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.i;
import com.tencent.mm.plugin.appbrand.m.a.e;
import com.tencent.mm.plugin.appbrand.q;
import com.tencent.mm.plugin.appbrand.r.b;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.HashMap;
import java.util.Vector;

public final class a extends e {
    private b iqj;

    public a(com.tencent.mm.plugin.appbrand.m.a.e.a aVar, q qVar) {
        super(aVar, qVar);
    }

    public final void aIV() {
        AppMethodBeat.i(102205);
        this.iqj = new b() {
            public final void auh() {
                AppMethodBeat.i(102204);
                ab.i("MicroMsg.ProxyAppBrandServiceOnInitListener", "onRuntimeReady");
                i runtime = a.this.gMN.getRuntime();
                if (runtime == null) {
                    IllegalStateException illegalStateException = new IllegalStateException("onRuntimeReady runtime null");
                    AppMethodBeat.o(102204);
                    throw illegalStateException;
                }
                HashMap hashMap = new HashMap();
                com.tencent.mm.plugin.appbrand.permission.e xY = ((com.tencent.luggage.sdk.b.b) runtime).xY();
                if (xY == null) {
                    ab.w("MicroMsg.ProxyAppBrandServiceOnInitListener", "fillPermissionBytes controller null");
                } else {
                    Vector aKw = xY.aKw();
                    if (aKw == null) {
                        ab.i("MicroMsg.ProxyAppBrandServiceOnInitListener", "fillPermissionBytes getPermissionBytes null");
                    } else {
                        hashMap.put("fg", aKw.elementAt(0));
                        hashMap.put("bg", aKw.elementAt(1));
                    }
                }
                hashMap.put("state", Integer.valueOf(runtime.gNN.gWy.awz().ordinal()));
                hashMap.put("wxaData", com.tencent.mm.plugin.appbrand.m.b.b.y(runtime));
                a.this.D(hashMap);
                AppMethodBeat.o(102204);
            }
        };
        com.tencent.mm.plugin.appbrand.r.a.gPN.a(this.gMN, this.iqj);
        AppMethodBeat.o(102205);
    }

    public final int getType() {
        return 1;
    }

    public final void removeListener() {
        AppMethodBeat.i(102206);
        com.tencent.mm.plugin.appbrand.r.a.gPN.b(this.gMN, this.iqj);
        AppMethodBeat.o(102206);
    }
}
