package com.tencent.p177mm.plugin.brandservice.p349ui.timeline.preload.p1476a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.sdk.p603e.C4925c;
import com.tencent.p177mm.sdk.p603e.C4927e;
import com.tencent.p177mm.sdk.p603e.C7563j;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import java.util.List;

/* renamed from: com.tencent.mm.plugin.brandservice.ui.timeline.preload.a.b */
public final class C38707b extends C7563j<C45763a> {
    public static final String[] fjY = new String[]{C7563j.m13217a(C45763a.fjX, "BizAppMsgReportContext")};
    public static final String[] fjZ = new String[0];
    final C4927e bSd;

    /* renamed from: b */
    public final /* synthetic */ boolean mo10101b(C4925c c4925c) {
        AppMethodBeat.m2504i(14397);
        boolean a = mo61566a((C45763a) c4925c);
        AppMethodBeat.m2505o(14397);
        return a;
    }

    static {
        AppMethodBeat.m2504i(14398);
        AppMethodBeat.m2505o(14398);
    }

    public C38707b(C4927e c4927e) {
        super(c4927e, C45763a.fjX, "BizAppMsgReportContext", fjZ);
        this.bSd = c4927e;
    }

    /* renamed from: a */
    public final boolean mo61566a(C45763a c45763a) {
        AppMethodBeat.m2504i(14395);
        c45763a.field_appMsgReportContextId = c45763a.field_reportTime;
        boolean b = super.mo10101b((C4925c) c45763a);
        AppMethodBeat.m2505o(14395);
        return b;
    }

    /* renamed from: ba */
    public final void mo61567ba(List<C45763a> list) {
        AppMethodBeat.m2504i(14396);
        long iV = C1720g.m3536RP().eJN.mo15639iV(Thread.currentThread().getId());
        for (C45763a a : list) {
            if (!mo16760a((C4925c) a, new String[0])) {
                C4990ab.m7418v("MicroMsg.Preload.BizAppMsgReportContextStorage", "[remove] delete fail");
            }
        }
        C1720g.m3536RP().eJN.mo15640mB(iV);
        AppMethodBeat.m2505o(14396);
    }
}
