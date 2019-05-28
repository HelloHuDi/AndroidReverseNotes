package com.tencent.mm.booter;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.a.i;
import com.tencent.mm.m.g;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.c;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.a.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;

public final class j {
    public static void run() {
        AppMethodBeat.i(15853);
        int i = g.Nu().getInt("EnableForgroundService", 0);
        aw.ZK();
        int bL = i.bL(c.QF(), 101);
        boolean z = b.dnO() || (i > 0 && bL >= 0 && bL <= i);
        if (!z) {
            z = d.vxr;
        }
        if (!z) {
            z = b.dnO();
        }
        if (com.tencent.mm.sdk.platformtools.g.cdf == 1) {
            z = false;
        }
        ah.getContext().getSharedPreferences("system_config_prefs", 0).edit().putBoolean("set_service", z).commit();
        ab.i("MicroMsg.PostTaskSetPushForegroundService", "Set service, userHash:%d, prob:%d, enabled: %b  isalpha:%b channel:%d", Integer.valueOf(bL), Integer.valueOf(i), Boolean.valueOf(z), Boolean.valueOf(d.vxr), Integer.valueOf(com.tencent.mm.sdk.platformtools.g.cdf));
        AppMethodBeat.o(15853);
    }
}
