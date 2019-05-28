package com.tencent.p177mm.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p183ai.C1201e;
import com.tencent.p177mm.p183ai.C1201e.C1197a;
import com.tencent.p177mm.p183ai.C1201e.C1198b;
import com.tencent.p177mm.p183ai.C1201e.C1199c;
import com.tencent.p177mm.protocal.protobuf.C7254cm;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C5049br;
import com.tencent.p177mm.storage.C7580z;
import java.util.Map;

/* renamed from: com.tencent.mm.model.ca */
public final class C45440ca implements C1201e {
    /* renamed from: b */
    public final C1198b mo4453b(C1197a c1197a) {
        AppMethodBeat.m2504i(16351);
        C7254cm c7254cm = c1197a.eAB;
        if (c7254cm == null) {
            C4990ab.m7412e("MicroMsg.SysNoticeMsgExtension", "onPreAddMessage cmdAM is null");
            AppMethodBeat.m2505o(16351);
        } else {
            try {
                Map z = C5049br.m7595z("<root>" + c7254cm.vED + "</root>", "root");
                int intValue = Integer.valueOf((String) z.get(".root.newcount")).intValue();
                int intValue2 = Integer.valueOf((String) z.get(".root.version")).intValue();
                C9638aw.m17190ZK();
                C7580z Ry = C18628c.m29072Ry();
                if (intValue2 == C5046bo.m7567h((Integer) Ry.get(12305, null))) {
                    C4990ab.m7416i("MicroMsg.SysNoticeMsgExtension", "ignore new sys notice count, same version");
                    AppMethodBeat.m2505o(16351);
                } else {
                    Ry.set(12304, Integer.valueOf(intValue));
                    Ry.set(12305, Integer.valueOf(intValue2));
                    AppMethodBeat.m2505o(16351);
                }
            } catch (Exception e) {
                C4990ab.m7413e("MicroMsg.SysNoticeMsgExtension", "exception:%s", C5046bo.m7574l(e));
            }
        }
        return null;
    }

    /* renamed from: a */
    public final void mo4452a(C1199c c1199c) {
    }
}
