package com.tencent.p177mm.plugin.priority.p1284b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C1855t;
import com.tencent.p177mm.model.C37921n;
import com.tencent.p177mm.p264n.C7486a;
import com.tencent.p177mm.plugin.expt.p394a.C34069a;
import com.tencent.p177mm.plugin.expt.p394a.C34069a.C11745a;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.C6982j;
import com.tencent.p177mm.plugin.priority.p1407a.p1408a.p1409a.C39485a;
import com.tencent.p177mm.plugin.report.C7053e;
import com.tencent.p177mm.protocal.protobuf.C23390gi;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5023at;
import com.tencent.p177mm.storage.C7616ad;

/* renamed from: com.tencent.mm.plugin.priority.b.c */
public final class C21437c {
    /* renamed from: a */
    public static final void m32874a(int i, long j, int i2, C23390gi c23390gi) {
        AppMethodBeat.m2504i(54897);
        if (((C34069a) C1720g.m3528K(C34069a.class)).mo54614a(C11745a.clicfg_mmc2c_img_auto_download_report_flag, C46130a.pgk)) {
            int i3;
            String gB = C5023at.m7471gB(C4996ah.getContext());
            int i4 = C1855t.m3896kH(c23390gi.ptA) ? 1 : 2;
            int i5 = C39485a.m67464UE(c23390gi.ptA) ? 1 : 2;
            int mA = i4 == 1 ? C37921n.m64060mA(c23390gi.ptA) : 1;
            C7616ad aoO = ((C6982j) C1720g.m3528K(C6982j.class)).mo15369XM().aoO(c23390gi.ptA);
            if (i4 == 1) {
                i3 = C7486a.m12942jh(aoO.field_type) ? 3 : 4;
            } else {
                i3 = aoO.mo16700Oc() ? 1 : 2;
            }
            int i6 = ((C6982j) C1720g.m3528K(C6982j.class)).mo15371XR().aph(c23390gi.ptA) ? 1 : 2;
            long round = Math.round(c23390gi.vIB * 100.0d);
            C4990ab.m7417i("MicroMsg.Priority.PriorityReportLogic", "report16308 %s", String.format("%d,%d,%d,%s,%d,%d,%d,%d,%d,%d,%d,%d,%s,%d,%d,%d,%d,%s,%d", new Object[]{Long.valueOf(c23390gi.vIs), Integer.valueOf(i), Long.valueOf(j), gB, Integer.valueOf(c23390gi.vIw), Integer.valueOf(i2), Long.valueOf(j - c23390gi.vIv), Integer.valueOf(0), Integer.valueOf(c23390gi.vIz), Long.valueOf(c23390gi.vIy), Integer.valueOf(i4), Integer.valueOf(i5), c23390gi.ptA, Integer.valueOf(mA), Integer.valueOf(i3), Integer.valueOf(i6), Long.valueOf(round), c23390gi.vIt, Integer.valueOf(c23390gi.vIC)}));
            C7053e.pXa.mo8374X(16308, r2);
            AppMethodBeat.m2505o(54897);
            return;
        }
        AppMethodBeat.m2505o(54897);
    }
}
