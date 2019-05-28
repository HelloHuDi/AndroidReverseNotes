package com.tencent.mm.plugin.appbrand.appcache.b.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ci.f;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.vending.c.a;

public enum i {
    ;
    
    private volatile boolean gWe;
    private volatile f<Void> gWf;

    private i(String str) {
        this.gWe = false;
    }

    static {
        AppMethodBeat.o(129490);
    }

    public final synchronized void awv() {
        AppMethodBeat.i(129487);
        if (this.gWe) {
            ab.d("MicroMsg.AppBrand.Predownload.GetCodeRetryLogic", "triggerRetry, queueRunning, skip");
            AppMethodBeat.o(129487);
        } else if (g.RN().eJb) {
            ab.i("MicroMsg.AppBrand.Predownload.GetCodeRetryLogic", "triggerRetry, set flag queue running");
            this.gWe = true;
            this.gWf = com.tencent.mm.ci.g.dOW();
            this.gWf.i(new a<Void, Void>() {
                public final /* synthetic */ Object call(Object obj) {
                    AppMethodBeat.i(129478);
                    Void asR = asR();
                    AppMethodBeat.o(129478);
                    return asR;
                }

                private Void asR() {
                    AppMethodBeat.i(129477);
                    try {
                        i.a(i.this);
                    } catch (Throwable th) {
                        AppMethodBeat.o(129477);
                    }
                    AppMethodBeat.o(129477);
                    return null;
                }
            });
            AppMethodBeat.o(129487);
        } else {
            ab.e("MicroMsg.AppBrand.Predownload.GetCodeRetryLogic", "triggerRetry, account not ready");
            AppMethodBeat.o(129487);
        }
    }

    public final synchronized void cleanup() {
        AppMethodBeat.i(129488);
        if (this.gWf != null) {
            this.gWf.dMk();
        }
        this.gWe = false;
        AppMethodBeat.o(129488);
    }
}
