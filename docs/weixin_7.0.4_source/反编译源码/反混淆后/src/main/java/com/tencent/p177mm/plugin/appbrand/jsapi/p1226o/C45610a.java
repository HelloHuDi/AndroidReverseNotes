package com.tencent.p177mm.plugin.appbrand.jsapi.p1226o;

import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.C6750i;

/* renamed from: com.tencent.mm.plugin.appbrand.jsapi.o.a */
public final class C45610a extends C42553b {
    public final SparseArray<C42554c> hVp = new SparseArray();

    public C45610a() {
        AppMethodBeat.m2504i(131429);
        AppMethodBeat.m2505o(131429);
    }

    /* JADX WARNING: Missing block: B:9:0x0020, code skipped:
            p000a.p005f.p007b.C25052j.m39376p(r0, "info");
            r2 = r0.hVq;
            p000a.p005f.p007b.C25052j.m39375o(r2, "info.component");
            r2 = r2.getRuntime();
     */
    /* JADX WARNING: Missing block: B:10:0x0034, code skipped:
            if ((r2 instanceof com.tencent.p177mm.plugin.appbrand.C41243o) != false) goto L_0x0075;
     */
    /* JADX WARNING: Missing block: B:11:0x0036, code skipped:
            r1 = (com.tencent.p177mm.plugin.appbrand.C41243o) r1;
     */
    /* JADX WARNING: Missing block: B:12:0x0038, code skipped:
            if (r1 == null) goto L_0x0073;
     */
    /* JADX WARNING: Missing block: B:13:0x003a, code skipped:
            r2 = r1.mo43488xY();
     */
    /* JADX WARNING: Missing block: B:14:0x003e, code skipped:
            if (r2 == null) goto L_0x0073;
     */
    /* JADX WARNING: Missing block: B:15:0x0040, code skipped:
            r5 = r2.mo53976a((com.tencent.p177mm.plugin.appbrand.jsapi.C2241c) r0.hVq, r0.hVr, r0.data, false);
     */
    /* JADX WARNING: Missing block: B:16:0x004d, code skipped:
            com.tencent.p177mm.plugin.appbrand.report.model.C2445j.m4684a(r0.hVq.getAppId(), r0.path, r0.hVr.getName(), r0.data, r5, com.tencent.p177mm.sdk.platformtools.C5046bo.m7588yz() - r0.startTime, r12);
            com.tencent.matrix.trace.core.AppMethodBeat.m2505o(131430);
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
    /* renamed from: W */
    public final void mo73396W(int i, String str) {
        C6750i c6750i = null;
        AppMethodBeat.m2504i(131430);
        synchronized (this.hVp) {
            try {
                C42554c c42554c = (C42554c) this.hVp.get(i, null);
                if (c42554c == null) {
                } else {
                    this.hVp.remove(i);
                }
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(131430);
            }
        }
    }
}
