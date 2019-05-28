package com.tencent.mm.plugin.profile.ui.newbizinfo.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.profile.ui.newbizinfo.b.d;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.storage.s;

public final class c {
    public static final void cP(String str, int i) {
        AppMethodBeat.i(23957);
        d Va = com.tencent.mm.plugin.profile.c.cap().Va(str);
        String str2 = Va != null ? Va.field_decryptUserName : "";
        ab.d("MicroMsg.Kv13307", "username:%s scene::%s optype:%d opscene:%d decryptUserName:%s", str, Integer.valueOf(3), Integer.valueOf(i), Integer.valueOf(4), str2);
        h.pYm.e(13307, str, Integer.valueOf(3), Integer.valueOf(i), Integer.valueOf(4), str2, Integer.valueOf(s.getSessionId()));
        AppMethodBeat.o(23957);
    }
}
