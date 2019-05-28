package com.tencent.p177mm.plugin.appbrand;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p224d.p225a.C26065u;
import com.tencent.p177mm.p224d.p225a.C32488l;
import com.tencent.p177mm.p224d.p225a.C32488l.C32490b;
import com.tencent.p177mm.p224d.p225a.C37673t;
import com.tencent.p177mm.p224d.p225a.C37673t.C1492a;
import com.tencent.p177mm.plugin.appbrand.report.quality.C27285a;
import com.tencent.p177mm.plugin.appbrand.report.quality.C38501b;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;

/* renamed from: com.tencent.mm.plugin.appbrand.ae */
class C42329ae extends C37673t {
    static final /* synthetic */ boolean $assertionsDisabled = (!C42329ae.class.desiredAssertionStatus());

    /* renamed from: com.tencent.mm.plugin.appbrand.ae$a */
    static class C18995a extends C1492a {
        String appId;
        String gQB;
        boolean gQC;

        C18995a(C1492a c1492a, String str, String str2, boolean z) {
            super(c1492a.filePath, c1492a.script);
            this.gQB = str;
            this.appId = str2;
            this.gQC = z;
        }

        C18995a(String str, String str2, String str3, boolean z) {
            super(str, str2);
            this.gQB = null;
            this.appId = str3;
            this.gQC = z;
        }
    }

    static {
        AppMethodBeat.m2504i(129157);
        AppMethodBeat.m2505o(129157);
    }

    C42329ae(C26065u c26065u) {
        super(c26065u);
    }

    /* renamed from: a */
    public final void mo60498a(C32488l c32488l, C1492a c1492a) {
        int i;
        AppMethodBeat.m2504i(129156);
        if (c1492a instanceof C18995a) {
            String str = ((C18995a) c1492a).gQB;
            if (!C5046bo.isNullOrNil(str)) {
                C4990ab.m7417i("MicroMsg.V8EngineWorkerManagerWC", "hy: %s has sourcemap", c1492a.filePath);
                c32488l.mo53121a(str, null);
            }
        }
        C4990ab.m7417i("MicroMsg.V8EngineWorkerManagerWC", "hy: evaluating %s", c1492a.filePath);
        if (!c1492a.filePath.endsWith("WAWorker.js")) {
            i = 0;
        } else if ($assertionsDisabled || (c1492a instanceof C18995a)) {
            final C18995a c18995a = (C18995a) c1492a;
            final long currentTimeMillis = System.currentTimeMillis();
            final C1492a c1492a2 = c1492a;
            c32488l.mo53122a(c1492a.filePath, c1492a.script, new C32490b() {
                /* renamed from: ds */
                public final void mo21687ds(String str) {
                    AppMethodBeat.m2504i(129155);
                    C27285a.aLz();
                    C38501b.m65164a(c18995a.gQC, c18995a.appId, currentTimeMillis, "WAWorker.js", (long) c1492a2.script.length());
                    AppMethodBeat.m2505o(129155);
                }
            });
            i = 1;
        } else {
            AssertionError assertionError = new AssertionError();
            AppMethodBeat.m2505o(129156);
            throw assertionError;
        }
        if (i != 0) {
            AppMethodBeat.m2505o(129156);
            return;
        }
        c32488l.mo53122a(c1492a.filePath, c1492a.script, null);
        AppMethodBeat.m2505o(129156);
    }
}
