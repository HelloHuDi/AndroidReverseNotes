package com.tencent.p177mm.plugin.topstory.p539a.p540a;

import com.tencent.mars.smc.IDKey;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.report.service.C7060h;
import java.util.ArrayList;

/* renamed from: com.tencent.mm.plugin.topstory.a.a.b */
public final class C4203b {
    public static void cFr() {
        AppMethodBeat.m2504i(96379);
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
            C7060h.pYm.mo8379b(arrayList, false);
            AppMethodBeat.m2505o(96379);
        } catch (Throwable th) {
            AppMethodBeat.m2505o(96379);
        }
    }
}
