package com.tencent.mm.plugin.appbrand.jsapi.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.i;
import com.tencent.mm.plugin.appbrand.page.a.c.a;
import com.tencent.mm.plugin.appbrand.r.m;
import com.tencent.mm.sdk.platformtools.al;

final class k {
    long hKQ = 0;
    a hKR;

    k() {
    }

    /* Access modifiers changed, original: final */
    public final void w(final i iVar) {
        AppMethodBeat.i(74749);
        m.runOnUiThread(new Runnable() {
            public final void run() {
                AppMethodBeat.i(74746);
                if (k.this.hKR != null) {
                    k.this.hKR.dismiss();
                }
                k.this.hKR = com.tencent.mm.plugin.appbrand.page.a.z(iVar).a(com.tencent.mm.plugin.appbrand.page.a.a.LBS);
                k.this.hKQ = System.currentTimeMillis();
                AppMethodBeat.o(74746);
            }
        });
        AppMethodBeat.o(74749);
    }

    /* Access modifiers changed, original: final */
    public final void aDE() {
        AppMethodBeat.i(74750);
        m.runOnUiThread(new Runnable() {
            public final void run() {
                AppMethodBeat.i(74748);
                if (k.this.hKR == null) {
                    AppMethodBeat.o(74748);
                    return;
                }
                long currentTimeMillis = System.currentTimeMillis() - k.this.hKQ;
                if (currentTimeMillis < 3000) {
                    al.n(new Runnable() {
                        public final void run() {
                            AppMethodBeat.i(74747);
                            k.this.hKR.dismiss();
                            AppMethodBeat.o(74747);
                        }
                    }, 3000 - currentTimeMillis);
                    AppMethodBeat.o(74748);
                    return;
                }
                k.this.hKR.dismiss();
                AppMethodBeat.o(74748);
            }
        });
        AppMethodBeat.o(74750);
    }
}
