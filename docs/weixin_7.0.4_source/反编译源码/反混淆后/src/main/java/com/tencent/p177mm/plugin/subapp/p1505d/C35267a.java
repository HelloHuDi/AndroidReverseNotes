package com.tencent.p177mm.plugin.subapp.p1505d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.modelvoice.C26500m;
import com.tencent.p177mm.modelvoice.C32849p;
import com.tencent.p177mm.p230g.p231a.C45324ft;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.sdk.p600b.C4883b;
import com.tencent.p177mm.sdk.p600b.C4884c;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;

/* renamed from: com.tencent.mm.plugin.subapp.d.a */
public final class C35267a extends C4884c<C45324ft> {
    public C35267a() {
        AppMethodBeat.m2504i(25324);
        this.xxI = C45324ft.class.getName().hashCode();
        AppMethodBeat.m2505o(25324);
    }

    /* renamed from: a */
    public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
        AppMethodBeat.m2504i(25325);
        C45324ft c45324ft = (C45324ft) c4883b;
        if (c45324ft == null) {
            AppMethodBeat.m2505o(25325);
            return false;
        } else if (C5046bo.isNullOrNil(c45324ft.czK.fileName)) {
            C4990ab.m7412e("MicroMsg.VoiceTransformTextClickEventListener", "alvinluo fileName is null");
            AppMethodBeat.m2505o(25325);
            return false;
        } else {
            C32849p uZ = C26500m.ama().mo33987uZ(c45324ft.czK.fileName);
            if (uZ == null) {
                C4990ab.m7412e("MicroMsg.VoiceTransformTextClickEventListener", "alvinluo voiceInfo is null");
                AppMethodBeat.m2505o(25325);
                return false;
            }
            String str;
            int i;
            if (c45324ft.czK.czL == 1 || c45324ft.czK.czL == 2) {
                str = uZ.clientId;
                i = c45324ft.czK.scene;
                C4990ab.m7417i("MicroMsg.VoiceTransformTextReporter", "alvinluo reportTransformTextClick voiceId: %s, clickScene: %d", str, Integer.valueOf(i));
                C7060h.pYm.mo8381e(14220, Integer.valueOf(i), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), str);
            } else if (c45324ft.czK.czL == 3) {
                str = uZ.clientId;
                i = c45324ft.czK.scene;
                C4990ab.m7417i("MicroMsg.VoiceTransformTextReporter", "alvinluo reportTransformTextDoubleClick voiceId: %s, clickScene: %d", str, Integer.valueOf(i));
                C7060h.pYm.mo8381e(14220, Integer.valueOf(0), Integer.valueOf(i), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), str);
            }
            AppMethodBeat.m2505o(25325);
            return true;
        }
    }
}
