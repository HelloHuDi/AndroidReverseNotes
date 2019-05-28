package com.tencent.mm.plugin.game.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.ab;

public final class t implements f {
    public t() {
        AppMethodBeat.i(111336);
        g.Rg().a(1223, (f) this);
        AppMethodBeat.o(111336);
    }

    public final void onSceneEnd(int i, int i2, String str, m mVar) {
    }

    public static void b(String str, int i, int i2, String str2, String str3) {
        AppMethodBeat.i(111337);
        ab.i("MicroMsg.GameMsgReportService", "appId = %s, opType = %d, opStatus = %d, extInfo = %s", str, Integer.valueOf(i), Integer.valueOf(i2), str3);
        g.Rg().a(new at(str, i, i2, str2, str3), 0);
        AppMethodBeat.o(111337);
    }
}
