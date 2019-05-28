package com.tencent.p177mm.plugin.appbrand.jsapi.p304e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.C6750i;
import com.tencent.p177mm.plugin.appbrand.p328r.C45673m;
import com.tencent.p177mm.plugin.appbrand.page.C38456a;
import com.tencent.p177mm.plugin.appbrand.page.C38456a.C2403a;
import com.tencent.p177mm.plugin.appbrand.page.p327a.C42642c.C2405a;
import com.tencent.p177mm.sdk.platformtools.C5004al;

/* renamed from: com.tencent.mm.plugin.appbrand.jsapi.e.k */
final class C33297k {
    long hKQ = 0;
    C2405a hKR;

    /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.e.k$2 */
    class C332982 implements Runnable {

        /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.e.k$2$1 */
        class C103771 implements Runnable {
            C103771() {
            }

            public final void run() {
                AppMethodBeat.m2504i(74747);
                C33297k.this.hKR.dismiss();
                AppMethodBeat.m2505o(74747);
            }
        }

        C332982() {
        }

        public final void run() {
            AppMethodBeat.m2504i(74748);
            if (C33297k.this.hKR == null) {
                AppMethodBeat.m2505o(74748);
                return;
            }
            long currentTimeMillis = System.currentTimeMillis() - C33297k.this.hKQ;
            if (currentTimeMillis < 3000) {
                C5004al.m7442n(new C103771(), 3000 - currentTimeMillis);
                AppMethodBeat.m2505o(74748);
                return;
            }
            C33297k.this.hKR.dismiss();
            AppMethodBeat.m2505o(74748);
        }
    }

    C33297k() {
    }

    /* Access modifiers changed, original: final */
    /* renamed from: w */
    public final void mo53817w(final C6750i c6750i) {
        AppMethodBeat.m2504i(74749);
        C45673m.runOnUiThread(new Runnable() {
            public final void run() {
                AppMethodBeat.m2504i(74746);
                if (C33297k.this.hKR != null) {
                    C33297k.this.hKR.dismiss();
                }
                C33297k.this.hKR = C38456a.m65057z(c6750i).mo61145a(C2403a.LBS);
                C33297k.this.hKQ = System.currentTimeMillis();
                AppMethodBeat.m2505o(74746);
            }
        });
        AppMethodBeat.m2505o(74749);
    }

    /* Access modifiers changed, original: final */
    public final void aDE() {
        AppMethodBeat.m2504i(74750);
        C45673m.runOnUiThread(new C332982());
        AppMethodBeat.m2505o(74750);
    }
}
