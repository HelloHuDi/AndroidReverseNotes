package com.tencent.p177mm.p612ui.contact;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;

/* renamed from: com.tencent.mm.ui.contact.y */
public final class C30670y {
    /* renamed from: q */
    public static final void m48901q(String str, int i, int i2, int i3) {
        AppMethodBeat.m2504i(105263);
        if (C5046bo.isNullOrNil(str)) {
            AppMethodBeat.m2505o(105263);
            return;
        }
        C4990ab.m7419v("MicroMsg.SelectContactReportLogic", "reportClick: %s", String.format("%s,%d,%d,%d,%d", new Object[]{str, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(0)}));
        C7060h.pYm.mo8374X(13234, r0);
        AppMethodBeat.m2505o(105263);
    }

    /* renamed from: Pp */
    public static void m48900Pp(int i) {
        AppMethodBeat.m2504i(105264);
        C4990ab.m7417i("MicroMsg.SelectContactReportLogic", "reportCreateChatroomClick %d %d", Integer.valueOf(13941), Integer.valueOf(i));
        C7060h.pYm.mo8381e(13941, Integer.valueOf(i));
        AppMethodBeat.m2505o(105264);
    }
}
