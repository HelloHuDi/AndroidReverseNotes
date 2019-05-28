package com.tencent.p177mm.booter;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.model.C18628c;
import com.tencent.p177mm.model.C9638aw;
import com.tencent.p177mm.p178a.C1179i;
import com.tencent.p177mm.p249m.C26373g;
import com.tencent.p177mm.protocal.C7243d;
import com.tencent.p177mm.sdk.p599a.C4872b;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5059g;

/* renamed from: com.tencent.mm.booter.j */
public final class C25974j {
    public static void run() {
        AppMethodBeat.m2504i(15853);
        int i = C26373g.m41964Nu().getInt("EnableForgroundService", 0);
        C9638aw.m17190ZK();
        int bL = C1179i.m2593bL(C18628c.m29064QF(), 101);
        boolean z = C4872b.dnO() || (i > 0 && bL >= 0 && bL <= i);
        if (!z) {
            z = C7243d.vxr;
        }
        if (!z) {
            z = C4872b.dnO();
        }
        if (C5059g.cdf == 1) {
            z = false;
        }
        C4996ah.getContext().getSharedPreferences("system_config_prefs", 0).edit().putBoolean("set_service", z).commit();
        C4990ab.m7417i("MicroMsg.PostTaskSetPushForegroundService", "Set service, userHash:%d, prob:%d, enabled: %b  isalpha:%b channel:%d", Integer.valueOf(bL), Integer.valueOf(i), Boolean.valueOf(z), Boolean.valueOf(C7243d.vxr), Integer.valueOf(C5059g.cdf));
        AppMethodBeat.m2505o(15853);
    }
}
