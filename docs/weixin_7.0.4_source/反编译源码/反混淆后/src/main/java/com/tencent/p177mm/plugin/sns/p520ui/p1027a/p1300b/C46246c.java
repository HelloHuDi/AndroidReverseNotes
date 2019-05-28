package com.tencent.p177mm.plugin.sns.p520ui.p1027a.p1300b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.sns.data.C29036i;
import com.tencent.p177mm.plugin.sns.model.C13373af;
import com.tencent.p177mm.plugin.sns.storage.C46236n;
import com.tencent.p177mm.protocal.protobuf.aao;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.plugin.sns.ui.a.b.c */
public final class C46246c extends C22052a {
    public C46246c() {
        super(new C46236n());
        AppMethodBeat.m2504i(39954);
        dLZ();
        AppMethodBeat.m2505o(39954);
    }

    /* renamed from: w */
    public final String mo63009w(long j, String str) {
        AppMethodBeat.m2504i(39955);
        C4990ab.m7411d("MicroMsg.SnsTimeLineVending", "updateLitmitSeq %s %s", Integer.valueOf(C13373af.cnv().cod()), str);
        String jW = C29036i.m46118jW(C13373af.cnF().mo62938g(j, str.equals("") ? C13373af.cnv().cod() / 2 : C13373af.cnv().cod(), false));
        String cuP = cuP();
        if (!cuP.equals("") && jW.compareTo(cuP) >= 0) {
            jW = cuP;
        }
        aao cqL = C13373af.cnJ().mo69179YX("@__weixintimtline").cqL();
        if (cqL.wfM == 0) {
            AppMethodBeat.m2505o(39955);
            return jW;
        }
        cuP = C29036i.m46118jW(cqL.wfM);
        if (jW.equals("")) {
            AppMethodBeat.m2505o(39955);
            return cuP;
        } else if (cuP.compareTo(jW) > 0) {
            AppMethodBeat.m2505o(39955);
            return cuP;
        } else {
            AppMethodBeat.m2505o(39955);
            return jW;
        }
    }
}
