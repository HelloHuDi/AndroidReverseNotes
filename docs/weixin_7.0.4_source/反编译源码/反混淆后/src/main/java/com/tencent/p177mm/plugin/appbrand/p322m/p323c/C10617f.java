package com.tencent.p177mm.plugin.appbrand.p322m.p323c;

import com.facebook.share.internal.ShareConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p1174aa.C41724g;
import com.tencent.p177mm.p1174aa.C41726i;
import com.tencent.p177mm.plugin.appbrand.p322m.p1228a.C19597c;
import com.tencent.p177mm.plugin.appbrand.p322m.p1228a.C27190b;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.plugin.appbrand.m.c.f */
public final class C10617f extends C27190b {
    public final int aIT() {
        return 4;
    }

    /* renamed from: a */
    public final void mo22138a(C41726i c41726i, C19597c c19597c) {
        AppMethodBeat.m2504i(102197);
        try {
            int i = c41726i.getInt("level");
            String optString = c41726i.optString(ShareConstants.WEB_DIALOG_PARAM_MESSAGE);
            switch (i) {
                case 2:
                    C4990ab.m7416i("MicroMsg.NodeJs", optString);
                    AppMethodBeat.m2505o(102197);
                    return;
                case 3:
                    C4990ab.m7420w("MicroMsg.NodeJs", optString);
                    AppMethodBeat.m2505o(102197);
                    return;
                case 4:
                    C4990ab.m7412e("MicroMsg.NodeJs", optString);
                    AppMethodBeat.m2505o(102197);
                    return;
                default:
                    C4990ab.m7410d("MicroMsg.NodeJs", optString);
                    AppMethodBeat.m2505o(102197);
                    return;
            }
        } catch (C41724g e) {
            C4990ab.m7413e("MicroMsg.NodeToXLog", "execute exception : %s", e);
            c19597c.aIU();
            AppMethodBeat.m2505o(102197);
        }
        C4990ab.m7413e("MicroMsg.NodeToXLog", "execute exception : %s", e);
        c19597c.aIU();
        AppMethodBeat.m2505o(102197);
    }
}
