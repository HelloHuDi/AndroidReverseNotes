package com.tencent.mm.ui.contact;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

public final class y {
    public static final void q(String str, int i, int i2, int i3) {
        AppMethodBeat.i(105263);
        if (bo.isNullOrNil(str)) {
            AppMethodBeat.o(105263);
            return;
        }
        ab.v("MicroMsg.SelectContactReportLogic", "reportClick: %s", String.format("%s,%d,%d,%d,%d", new Object[]{str, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(0)}));
        h.pYm.X(13234, r0);
        AppMethodBeat.o(105263);
    }

    public static void Pp(int i) {
        AppMethodBeat.i(105264);
        ab.i("MicroMsg.SelectContactReportLogic", "reportCreateChatroomClick %d %d", Integer.valueOf(13941), Integer.valueOf(i));
        h.pYm.e(13941, Integer.valueOf(i));
        AppMethodBeat.o(105264);
    }
}
