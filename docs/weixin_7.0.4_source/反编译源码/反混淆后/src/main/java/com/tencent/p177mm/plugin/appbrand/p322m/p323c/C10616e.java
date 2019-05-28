package com.tencent.p177mm.plugin.appbrand.p322m.p323c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p1174aa.C41724g;
import com.tencent.p177mm.p1174aa.C41726i;
import com.tencent.p177mm.plugin.appbrand.p322m.p1228a.C19597c;
import com.tencent.p177mm.plugin.appbrand.p322m.p1228a.C27190b;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.plugin.appbrand.m.c.e */
public final class C10616e extends C27190b {
    public static C2386a iqg;

    /* renamed from: com.tencent.mm.plugin.appbrand.m.c.e$a */
    public interface C2386a {
        /* renamed from: X */
        void mo6286X(int i, String str);
    }

    /* renamed from: a */
    public final void mo22138a(C41726i c41726i, C19597c c19597c) {
        AppMethodBeat.m2504i(102196);
        if (iqg == null) {
            C4990ab.m7410d("MicroMsg.NodeReportKV", "sDelegate null");
            AppMethodBeat.m2505o(102196);
            return;
        }
        try {
            iqg.mo6286X(c41726i.getInt("id"), c41726i.optString("val"));
            AppMethodBeat.m2505o(102196);
        } catch (C41724g e) {
            C4990ab.m7413e("MicroMsg.NodeReportKV", "execute exception : %s", e);
            c19597c.aIU();
            AppMethodBeat.m2505o(102196);
        }
    }

    public final int aIT() {
        return 8;
    }
}
