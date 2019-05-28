package com.tencent.mm.plugin.topstory.a.a;

import com.tencent.mars.smc.IDKey;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import java.util.ArrayList;

public final class b {
    public static void cFr() {
        AppMethodBeat.i(96379);
        try {
            ArrayList arrayList = new ArrayList();
            IDKey iDKey = new IDKey();
            iDKey.SetID(990);
            iDKey.SetValue(1);
            iDKey.SetKey(0);
            IDKey iDKey2 = new IDKey();
            iDKey2.SetID(990);
            iDKey2.SetValue(1);
            iDKey2.SetKey(1);
            arrayList.add(iDKey);
            arrayList.add(iDKey2);
            h.pYm.b(arrayList, false);
            AppMethodBeat.o(96379);
        } catch (Throwable th) {
            AppMethodBeat.o(96379);
        }
    }
}
