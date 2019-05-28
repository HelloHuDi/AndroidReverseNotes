package com.tencent.mm.plugin.appbrand.jsapi.o;

import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.i;

public final class a extends b {
    public final SparseArray<c> hVp = new SparseArray();

    public a() {
        AppMethodBeat.i(131429);
        AppMethodBeat.o(131429);
    }

    /* JADX WARNING: Missing block: B:9:0x0020, code skipped:
            a.f.b.j.p(r0, "info");
            r2 = r0.hVq;
            a.f.b.j.o(r2, "info.component");
            r2 = r2.getRuntime();
     */
    /* JADX WARNING: Missing block: B:10:0x0034, code skipped:
            if ((r2 instanceof com.tencent.mm.plugin.appbrand.o) != false) goto L_0x0075;
     */
    /* JADX WARNING: Missing block: B:11:0x0036, code skipped:
            r1 = (com.tencent.mm.plugin.appbrand.o) r1;
     */
    /* JADX WARNING: Missing block: B:12:0x0038, code skipped:
            if (r1 == null) goto L_0x0073;
     */
    /* JADX WARNING: Missing block: B:13:0x003a, code skipped:
            r2 = r1.xY();
     */
    /* JADX WARNING: Missing block: B:14:0x003e, code skipped:
            if (r2 == null) goto L_0x0073;
     */
    /* JADX WARNING: Missing block: B:15:0x0040, code skipped:
            r5 = r2.a((com.tencent.mm.plugin.appbrand.jsapi.c) r0.hVq, r0.hVr, r0.data, false);
     */
    /* JADX WARNING: Missing block: B:16:0x004d, code skipped:
            com.tencent.mm.plugin.appbrand.report.model.j.a(r0.hVq.getAppId(), r0.path, r0.hVr.getName(), r0.data, r5, com.tencent.mm.sdk.platformtools.bo.yz() - r0.startTime, r12);
            com.tencent.matrix.trace.core.AppMethodBeat.o(131430);
     */
    /* JADX WARNING: Missing block: B:21:0x0073, code skipped:
            r5 = -1;
     */
    /* JADX WARNING: Missing block: B:22:0x0075, code skipped:
            r1 = r2;
     */
    /* JADX WARNING: Missing block: B:27:?, code skipped:
            return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void W(int i, String str) {
        i iVar = null;
        AppMethodBeat.i(131430);
        synchronized (this.hVp) {
            try {
                c cVar = (c) this.hVp.get(i, null);
                if (cVar == null) {
                } else {
                    this.hVp.remove(i);
                }
            } finally {
                while (true) {
                }
                AppMethodBeat.o(131430);
            }
        }
    }
}
