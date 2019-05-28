package com.tencent.p177mm.plugin.appbrand.p322m.p323c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p1174aa.C41724g;
import com.tencent.p177mm.p1174aa.C41726i;
import com.tencent.p177mm.plugin.appbrand.p322m.p1228a.C19597c;
import com.tencent.p177mm.plugin.appbrand.p322m.p1228a.C27190b;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.plugin.appbrand.m.c.d */
public final class C33444d extends C27190b {
    public static C27193a iqf;

    /* renamed from: com.tencent.mm.plugin.appbrand.m.c.d$a */
    public interface C27193a {
        /* renamed from: M */
        void mo22136M(int i, int i2, int i3);
    }

    public final int aIT() {
        return 3;
    }

    /* renamed from: a */
    public final void mo22138a(C41726i c41726i, C19597c c19597c) {
        AppMethodBeat.m2504i(102195);
        if (iqf == null) {
            C4990ab.m7410d("MicroMsg.NodeReportIDKey", "sDelegate null");
            AppMethodBeat.m2505o(102195);
            return;
        }
        try {
            iqf.mo22136M(c41726i.getInt("id"), c41726i.getInt("key"), c41726i.optInt("val", 1));
            AppMethodBeat.m2505o(102195);
        } catch (C41724g e) {
            C4990ab.m7413e("MicroMsg.NodeReportIDKey", "execute exception : %s", e);
            c19597c.aIU();
            AppMethodBeat.m2505o(102195);
        }
    }
}
