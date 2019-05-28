package com.tencent.p177mm.plugin.wear.model.p1662c;

import com.tencent.mars.smc.IDKey;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.plugin.wear.model.C43841a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import java.util.ArrayList;

/* renamed from: com.tencent.mm.plugin.wear.model.c.a */
public final class C46393a {
    /* renamed from: HH */
    public static final void m87275HH(int i) {
        AppMethodBeat.m2504i(26370);
        C7060h.pYm.mo8378a(249, (long) i, 1, false);
        AppMethodBeat.m2505o(26370);
    }

    /* renamed from: nD */
    public static final void m87277nD(boolean z) {
        AppMethodBeat.m2504i(26371);
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
        C7060h.pYm.mo8379b(arrayList, false);
        AppMethodBeat.m2505o(26371);
    }

    /* renamed from: gn */
    public static final void m87276gn(int i, int i2) {
        AppMethodBeat.m2504i(26369);
        if (C43841a.cUn().tXt.tXK.tYz != null) {
            C4990ab.m7419v("MicroMsg.Wear.ReportKVUtil", "report kv operation=%d scene=%d", Integer.valueOf(i), Integer.valueOf(i2));
            C7060h.pYm.mo8381e(11632, Integer.valueOf(i), r0.jBG, r0.xqt, Integer.valueOf(i2));
        }
        AppMethodBeat.m2505o(26369);
    }
}
