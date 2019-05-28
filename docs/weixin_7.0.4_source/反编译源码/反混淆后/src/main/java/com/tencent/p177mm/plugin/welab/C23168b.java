package com.tencent.p177mm.plugin.welab;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.model.C6673bz.C1837a;
import com.tencent.p177mm.p183ai.C1201e.C1197a;
import com.tencent.p177mm.platformtools.C1946aa;
import com.tencent.p177mm.plugin.welab.p1331d.p1332a.C23169a;
import com.tencent.p177mm.plugin.welab.p1563e.C46450b;
import com.tencent.p177mm.sdk.p603e.C4925c;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import java.util.ArrayList;

/* renamed from: com.tencent.mm.plugin.welab.b */
public final class C23168b implements C1837a {
    /* renamed from: a */
    public final void mo5414a(C1197a c1197a) {
        AppMethodBeat.m2504i(80536);
        if (c1197a == null || c1197a.eAB == null || c1197a.eAB.vED == null) {
            C4990ab.m7416i("MicroMsg.WelabNewMsgLsn", "recv null msg");
            AppMethodBeat.m2505o(80536);
            return;
        }
        String a = C1946aa.m4148a(c1197a.eAB.vED);
        C4990ab.m7416i("MicroMsg.WelabNewMsgLsn", "recv addMsg ".concat(String.valueOf(a)));
        C23169a agK = C40363f.agK(a);
        if (agK != null && agK.isValid()) {
            if (agK.field_status == 1) {
                C29974a.ddj().uLQ.mo16760a((C4925c) agK, "expId");
            } else {
                C29974a.ddj().uLQ.mo63725c(agK);
                C46450b.ddC().mo74670f(agK);
                agK.ddv();
                ArrayList arrayList = new ArrayList();
                arrayList.add(agK);
                C29974a.ddj();
                C29974a.m47423ed(arrayList);
            }
            C40361d.m69201t(agK.field_LabsAppId, 6, false);
        }
        AppMethodBeat.m2505o(80536);
    }
}
