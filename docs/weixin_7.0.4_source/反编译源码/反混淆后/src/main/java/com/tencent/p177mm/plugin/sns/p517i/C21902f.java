package com.tencent.p177mm.plugin.sns.p517i;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.report.C7053e;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.plugin.sns.i.f */
public final class C21902f {
    /* renamed from: k */
    public static void m33470k(int i, String str, int i2) {
        AppMethodBeat.m2504i(94486);
        C4990ab.m7417i("MicroMsg.SNS.SnsReportLogic", "snsRedDotAction 16172 report %s", String.format("%s,%s,%s,%s", new Object[]{Integer.valueOf(i), str, Integer.valueOf(i2), Long.valueOf(System.currentTimeMillis())}));
        C7053e.pXa.mo8374X(16172, r0);
        AppMethodBeat.m2505o(94486);
    }
}
