package com.tencent.mm.plugin.welab;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.e;
import com.tencent.mm.model.bz.a;
import com.tencent.mm.platformtools.aa;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.ArrayList;

public final class b implements a {
    public final void a(e.a aVar) {
        AppMethodBeat.i(80536);
        if (aVar == null || aVar.eAB == null || aVar.eAB.vED == null) {
            ab.i("MicroMsg.WelabNewMsgLsn", "recv null msg");
            AppMethodBeat.o(80536);
            return;
        }
        String a = aa.a(aVar.eAB.vED);
        ab.i("MicroMsg.WelabNewMsgLsn", "recv addMsg ".concat(String.valueOf(a)));
        com.tencent.mm.plugin.welab.d.a.a agK = f.agK(a);
        if (agK != null && agK.isValid()) {
            if (agK.field_status == 1) {
                a.ddj().uLQ.a((c) agK, "expId");
            } else {
                a.ddj().uLQ.c(agK);
                com.tencent.mm.plugin.welab.e.b.ddC().f(agK);
                agK.ddv();
                ArrayList arrayList = new ArrayList();
                arrayList.add(agK);
                a.ddj();
                a.ed(arrayList);
            }
            d.t(agK.field_LabsAppId, 6, false);
        }
        AppMethodBeat.o(80536);
    }
}
