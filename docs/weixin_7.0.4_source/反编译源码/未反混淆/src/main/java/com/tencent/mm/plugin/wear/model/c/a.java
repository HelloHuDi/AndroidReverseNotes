package com.tencent.mm.plugin.wear.model.c;

import com.tencent.mars.smc.IDKey;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.ArrayList;

public final class a {
    public static final void HH(int i) {
        AppMethodBeat.i(26370);
        h.pYm.a(249, (long) i, 1, false);
        AppMethodBeat.o(26370);
    }

    public static final void nD(boolean z) {
        AppMethodBeat.i(26371);
        ArrayList arrayList = new ArrayList();
        IDKey iDKey = new IDKey();
        iDKey.SetID(249);
        iDKey.SetKey(12);
        iDKey.SetValue(1);
        arrayList.add(iDKey);
        if (z) {
            iDKey = new IDKey();
            iDKey.SetID(249);
            iDKey.SetKey(13);
            iDKey.SetValue(1);
            arrayList.add(iDKey);
        }
        h.pYm.b(arrayList, false);
        AppMethodBeat.o(26371);
    }

    public static final void gn(int i, int i2) {
        AppMethodBeat.i(26369);
        if (com.tencent.mm.plugin.wear.model.a.cUn().tXt.tXK.tYz != null) {
            ab.v("MicroMsg.Wear.ReportKVUtil", "report kv operation=%d scene=%d", Integer.valueOf(i), Integer.valueOf(i2));
            h.pYm.e(11632, Integer.valueOf(i), r0.jBG, r0.xqt, Integer.valueOf(i2));
        }
        AppMethodBeat.o(26369);
    }
}
