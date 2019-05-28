package com.tencent.mm.booter;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.a.i;
import com.tencent.mm.m.g;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.c;
import com.tencent.mm.sdk.a.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ar.a;

public final class l {
    public static void run() {
        AppMethodBeat.i(15861);
        int i = g.Nu().getInt("EnableFlockMultiProcSPProb", 0);
        aw.ZK();
        int bL = i.bL(c.QF(), 101);
        boolean z = b.dnO() || (i > 0 && bL >= 0 && bL <= i);
        a.setValue(a.xAa, z);
        ab.i("MicroMsg.PostTaskUpdateMultiProcSPSwitchListener", "Update MMImgDecSwitch, userHash:%d, prob:%d, enabled: %b", Integer.valueOf(bL), Integer.valueOf(i), Boolean.valueOf(z));
        AppMethodBeat.o(15861);
    }
}
