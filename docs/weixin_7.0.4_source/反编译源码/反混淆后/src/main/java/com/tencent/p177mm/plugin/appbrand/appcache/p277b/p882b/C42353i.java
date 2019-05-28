package com.tencent.p177mm.plugin.appbrand.appcache.p277b.p882b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.p217ci.C37654f;
import com.tencent.p177mm.p217ci.C41930g;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.vending.p637c.C5681a;
import com.tencent.p177mm.vending.p641g.C5698f;

/* renamed from: com.tencent.mm.plugin.appbrand.appcache.b.b.i */
public enum C42353i {
    ;
    
    private volatile boolean gWe;
    private volatile C37654f<Void> gWf;

    /* renamed from: com.tencent.mm.plugin.appbrand.appcache.b.b.i$1 */
    class C330861 implements C5681a<Void, Void> {
        C330861() {
        }

        public final /* synthetic */ Object call(Object obj) {
            AppMethodBeat.m2504i(129478);
            Void asR = asR();
            AppMethodBeat.m2505o(129478);
            return asR;
        }

        private Void asR() {
            AppMethodBeat.m2504i(129477);
            try {
                C42353i.m74907a(C42353i.this);
            } catch (Throwable th) {
                AppMethodBeat.m2505o(129477);
            }
            AppMethodBeat.m2505o(129477);
            return null;
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.appcache.b.b.i$3 */
    class C330903 implements C5681a<Void, Void> {
        C330903() {
        }

        public final /* synthetic */ Object call(Object obj) {
            AppMethodBeat.m2504i(129484);
            Void asR = asR();
            AppMethodBeat.m2505o(129484);
            return asR;
        }

        private Void asR() {
            AppMethodBeat.m2504i(129483);
            C5698f.dMj().mo11582cR(null);
            synchronized (C42353i.this) {
                try {
                    C42353i.this.gWe = false;
                } finally {
                    while (true) {
                    }
                    AppMethodBeat.m2505o(129483);
                }
            }
            return null;
        }
    }

    private C42353i(String str) {
        this.gWe = false;
    }

    static {
        AppMethodBeat.m2505o(129490);
    }

    public final synchronized void awv() {
        AppMethodBeat.m2504i(129487);
        if (this.gWe) {
            C4990ab.m7410d("MicroMsg.AppBrand.Predownload.GetCodeRetryLogic", "triggerRetry, queueRunning, skip");
            AppMethodBeat.m2505o(129487);
        } else if (C1720g.m3534RN().eJb) {
            C4990ab.m7416i("MicroMsg.AppBrand.Predownload.GetCodeRetryLogic", "triggerRetry, set flag queue running");
            this.gWe = true;
            this.gWf = C41930g.dOW();
            this.gWf.mo60493i(new C330861());
            AppMethodBeat.m2505o(129487);
        } else {
            C4990ab.m7412e("MicroMsg.AppBrand.Predownload.GetCodeRetryLogic", "triggerRetry, account not ready");
            AppMethodBeat.m2505o(129487);
        }
    }

    public final synchronized void cleanup() {
        AppMethodBeat.m2504i(129488);
        if (this.gWf != null) {
            this.gWf.dMk();
        }
        this.gWe = false;
        AppMethodBeat.m2505o(129488);
    }
}
