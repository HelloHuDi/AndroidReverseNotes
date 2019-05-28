package com.tencent.p177mm.plugin.appbrand.media.record;

import com.tencent.mars.smc.IDKey;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.report.service.C7060h;
import java.util.ArrayList;

/* renamed from: com.tencent.mm.plugin.appbrand.media.record.j */
public final class C27203j {
    public static void aIt() {
        AppMethodBeat.m2504i(105642);
        C7060h.pYm.mo8378a(689, 0, 1, true);
        AppMethodBeat.m2505o(105642);
    }

    /* renamed from: pj */
    public static void m43226pj(int i) {
        AppMethodBeat.m2504i(105643);
        ArrayList arrayList = new ArrayList();
        IDKey iDKey = new IDKey();
        iDKey.SetID(689);
        iDKey.SetKey(1);
        iDKey.SetValue(1);
        IDKey iDKey2 = new IDKey();
        iDKey2.SetID(689);
        iDKey2.SetKey(C19607i.m30403pi(i));
        iDKey2.SetValue(1);
        arrayList.add(iDKey);
        arrayList.add(iDKey2);
        C7060h.pYm.mo8379b(arrayList, true);
        AppMethodBeat.m2505o(105643);
    }

    /* renamed from: pk */
    public static void m43227pk(int i) {
        AppMethodBeat.m2504i(105644);
        C7060h.pYm.mo8378a(689, (long) C19607i.m30403pi(i), 1, true);
        AppMethodBeat.m2505o(105644);
    }
}
