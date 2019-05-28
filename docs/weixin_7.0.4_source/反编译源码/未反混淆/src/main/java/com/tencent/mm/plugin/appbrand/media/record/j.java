package com.tencent.mm.plugin.appbrand.media.record;

import com.tencent.mars.smc.IDKey;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import java.util.ArrayList;

public final class j {
    public static void aIt() {
        AppMethodBeat.i(105642);
        h.pYm.a(689, 0, 1, true);
        AppMethodBeat.o(105642);
    }

    public static void pj(int i) {
        AppMethodBeat.i(105643);
        ArrayList arrayList = new ArrayList();
        IDKey iDKey = new IDKey();
        iDKey.SetID(689);
        iDKey.SetKey(1);
        iDKey.SetValue(1);
        IDKey iDKey2 = new IDKey();
        iDKey2.SetID(689);
        iDKey2.SetKey(i.pi(i));
        iDKey2.SetValue(1);
        arrayList.add(iDKey);
        arrayList.add(iDKey2);
        h.pYm.b(arrayList, true);
        AppMethodBeat.o(105643);
    }

    public static void pk(int i) {
        AppMethodBeat.i(105644);
        h.pYm.a(689, (long) i.pi(i), 1, true);
        AppMethodBeat.o(105644);
    }
}
