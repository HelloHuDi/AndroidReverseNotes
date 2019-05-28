package com.tencent.p177mm.plugin.wepkg.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.wepkg.C40393b;
import com.tencent.p177mm.plugin.wepkg.utils.C30022d;
import com.tencent.p177mm.plugin.wepkg.utils.C35765a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.xweb.C31147o;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.tencent.mm.plugin.wepkg.model.d */
public final class C44024d {
    private Map<String, C40398f> uWM = new HashMap();
    private int uWN = 1;

    public C44024d() {
        AppMethodBeat.m2504i(63520);
        AppMethodBeat.m2505o(63520);
    }

    public final void ahR(String str) {
        AppMethodBeat.m2504i(63521);
        if (this.uWN > 3) {
            C4990ab.m7416i("MicroMsg.Wepkg.SupportIframe", "more than 3 wepkgs");
            AppMethodBeat.m2505o(63521);
            return;
        }
        String aid = C30022d.aid(str);
        if (!(C5046bo.isNullOrNil(aid) || this.uWM.get(aid) != null || C40393b.ahw(aid))) {
            this.uWN++;
            C40398f bN = C40393b.m69300bN(str, true);
            if (!(bN == null || bN.uWY == null)) {
                this.uWM.put(aid, bN);
                C35765a.m58633b("EnterWeb", str, bN.uWY.eBS, bN.uWY.version, 1, 0, null);
                C4990ab.m7417i("MicroMsg.Wepkg.SupportIframe", "load wepkg: %s", aid);
            }
        }
        AppMethodBeat.m2505o(63521);
    }

    public final C31147o ahS(String str) {
        AppMethodBeat.m2504i(63522);
        if (C5046bo.isNullOrNil(str)) {
            AppMethodBeat.m2505o(63522);
            return null;
        }
        for (C40398f ahS : this.uWM.values()) {
            C31147o ahS2 = ahS.ahS(str);
            if (ahS2 != null) {
                C4990ab.m7417i("MicroMsg.Wepkg.SupportIframe", "hit rid: %s", str);
                AppMethodBeat.m2505o(63522);
                return ahS2;
            }
        }
        AppMethodBeat.m2505o(63522);
        return null;
    }
}
