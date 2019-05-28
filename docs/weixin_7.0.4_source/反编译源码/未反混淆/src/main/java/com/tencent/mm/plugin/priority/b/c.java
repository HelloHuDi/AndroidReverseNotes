package com.tencent.mm.plugin.priority.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.n;
import com.tencent.mm.model.t;
import com.tencent.mm.plugin.expt.a.a;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.plugin.report.e;
import com.tencent.mm.protocal.protobuf.gi;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.at;
import com.tencent.mm.storage.ad;

public final class c {
    public static final void a(int i, long j, int i2, gi giVar) {
        AppMethodBeat.i(54897);
        if (((a) g.K(a.class)).a(a.a.clicfg_mmc2c_img_auto_download_report_flag, a.pgk)) {
            int i3;
            String gB = at.gB(ah.getContext());
            int i4 = t.kH(giVar.ptA) ? 1 : 2;
            int i5 = com.tencent.mm.plugin.priority.a.a.a.a.UE(giVar.ptA) ? 1 : 2;
            int mA = i4 == 1 ? n.mA(giVar.ptA) : 1;
            ad aoO = ((j) g.K(j.class)).XM().aoO(giVar.ptA);
            if (i4 == 1) {
                i3 = com.tencent.mm.n.a.jh(aoO.field_type) ? 3 : 4;
            } else {
                i3 = aoO.Oc() ? 1 : 2;
            }
            int i6 = ((j) g.K(j.class)).XR().aph(giVar.ptA) ? 1 : 2;
            long round = Math.round(giVar.vIB * 100.0d);
            ab.i("MicroMsg.Priority.PriorityReportLogic", "report16308 %s", String.format("%d,%d,%d,%s,%d,%d,%d,%d,%d,%d,%d,%d,%s,%d,%d,%d,%d,%s,%d", new Object[]{Long.valueOf(giVar.vIs), Integer.valueOf(i), Long.valueOf(j), gB, Integer.valueOf(giVar.vIw), Integer.valueOf(i2), Long.valueOf(j - giVar.vIv), Integer.valueOf(0), Integer.valueOf(giVar.vIz), Long.valueOf(giVar.vIy), Integer.valueOf(i4), Integer.valueOf(i5), giVar.ptA, Integer.valueOf(mA), Integer.valueOf(i3), Integer.valueOf(i6), Long.valueOf(round), giVar.vIt, Integer.valueOf(giVar.vIC)}));
            e.pXa.X(16308, r2);
            AppMethodBeat.o(54897);
            return;
        }
        AppMethodBeat.o(54897);
    }
}
