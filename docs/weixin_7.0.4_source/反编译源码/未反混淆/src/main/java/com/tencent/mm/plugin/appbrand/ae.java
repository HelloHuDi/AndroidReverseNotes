package com.tencent.mm.plugin.appbrand;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.d.a.l;
import com.tencent.mm.d.a.l.b;
import com.tencent.mm.d.a.t;
import com.tencent.mm.d.a.u;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

class ae extends t {
    static final /* synthetic */ boolean $assertionsDisabled = (!ae.class.desiredAssertionStatus());

    static class a extends com.tencent.mm.d.a.t.a {
        String appId;
        String gQB;
        boolean gQC;

        a(com.tencent.mm.d.a.t.a aVar, String str, String str2, boolean z) {
            super(aVar.filePath, aVar.script);
            this.gQB = str;
            this.appId = str2;
            this.gQC = z;
        }

        a(String str, String str2, String str3, boolean z) {
            super(str, str2);
            this.gQB = null;
            this.appId = str3;
            this.gQC = z;
        }
    }

    static {
        AppMethodBeat.i(129157);
        AppMethodBeat.o(129157);
    }

    ae(u uVar) {
        super(uVar);
    }

    public final void a(l lVar, com.tencent.mm.d.a.t.a aVar) {
        int i;
        AppMethodBeat.i(129156);
        if (aVar instanceof a) {
            String str = ((a) aVar).gQB;
            if (!bo.isNullOrNil(str)) {
                ab.i("MicroMsg.V8EngineWorkerManagerWC", "hy: %s has sourcemap", aVar.filePath);
                lVar.a(str, null);
            }
        }
        ab.i("MicroMsg.V8EngineWorkerManagerWC", "hy: evaluating %s", aVar.filePath);
        if (!aVar.filePath.endsWith("WAWorker.js")) {
            i = 0;
        } else if ($assertionsDisabled || (aVar instanceof a)) {
            final a aVar2 = (a) aVar;
            final long currentTimeMillis = System.currentTimeMillis();
            final com.tencent.mm.d.a.t.a aVar3 = aVar;
            lVar.a(aVar.filePath, aVar.script, new b() {
                public final void ds(String str) {
                    AppMethodBeat.i(129155);
                    com.tencent.mm.plugin.appbrand.report.quality.a.aLz();
                    com.tencent.mm.plugin.appbrand.report.quality.b.a(aVar2.gQC, aVar2.appId, currentTimeMillis, "WAWorker.js", (long) aVar3.script.length());
                    AppMethodBeat.o(129155);
                }
            });
            i = 1;
        } else {
            AssertionError assertionError = new AssertionError();
            AppMethodBeat.o(129156);
            throw assertionError;
        }
        if (i != 0) {
            AppMethodBeat.o(129156);
            return;
        }
        lVar.a(aVar.filePath, aVar.script, null);
        AppMethodBeat.o(129156);
    }
}
