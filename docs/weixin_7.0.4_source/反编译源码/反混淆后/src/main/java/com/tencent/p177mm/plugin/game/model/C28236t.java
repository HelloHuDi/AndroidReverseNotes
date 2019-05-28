package com.tencent.p177mm.plugin.game.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.plugin.game.model.t */
public final class C28236t implements C1202f {
    public C28236t() {
        AppMethodBeat.m2504i(111336);
        C1720g.m3540Rg().mo14539a(1223, (C1202f) this);
        AppMethodBeat.m2505o(111336);
    }

    public final void onSceneEnd(int i, int i2, String str, C1207m c1207m) {
    }

    /* renamed from: b */
    public static void m44820b(String str, int i, int i2, String str2, String str3) {
        AppMethodBeat.m2504i(111337);
        C4990ab.m7417i("MicroMsg.GameMsgReportService", "appId = %s, opType = %d, opStatus = %d, extInfo = %s", str, Integer.valueOf(i), Integer.valueOf(i2), str3);
        C1720g.m3540Rg().mo14541a(new C12161at(str, i, i2, str2, str3), 0);
        AppMethodBeat.m2505o(111337);
    }
}
