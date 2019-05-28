package com.tencent.p177mm.plugin.subapp.p1505d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.modelvoice.C26500m;
import com.tencent.p177mm.modelvoice.C32849p;
import com.tencent.p177mm.p230g.p231a.C37717fu;
import com.tencent.p177mm.sdk.p600b.C4883b;
import com.tencent.p177mm.sdk.p600b.C4884c;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import org.xwalk.core.Log;

/* renamed from: com.tencent.mm.plugin.subapp.d.c */
public final class C35269c extends C4884c<C37717fu> {
    public C35269c() {
        AppMethodBeat.m2504i(25327);
        this.xxI = C37717fu.class.getName().hashCode();
        AppMethodBeat.m2505o(25327);
    }

    /* renamed from: a */
    public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
        AppMethodBeat.m2504i(25328);
        C37717fu c37717fu = (C37717fu) c4883b;
        if (c37717fu == null) {
            AppMethodBeat.m2505o(25328);
            return false;
        } else if (C5046bo.isNullOrNil(c37717fu.czM.fileName)) {
            Log.m81046e("MicroMsg.VoiceTransformResultClickEventListener", "alvinluo fileName is null");
            AppMethodBeat.m2505o(25328);
            return false;
        } else {
            C32849p uZ = C26500m.ama().mo33987uZ(c37717fu.czM.fileName);
            if (uZ == null) {
                Log.m81046e("MicroMsg.VoiceTransformResultClickEventListener", "alvinluo voiceInfo is null");
                AppMethodBeat.m2505o(25328);
                return false;
            }
            C35268b.m57941b(uZ.clientId, c37717fu.czM.czN, c37717fu.czM.czO, c37717fu.czM.czP, c37717fu.czM.result);
            AppMethodBeat.m2505o(25328);
            return true;
        }
    }
}
