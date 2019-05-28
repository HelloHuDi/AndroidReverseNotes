package com.tencent.p177mm.plugin.wallet_core.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.storage.C5128ac.C5127a;

/* renamed from: com.tencent.mm.plugin.wallet_core.model.al */
public final class C22589al {
    public static boolean aFF() {
        AppMethodBeat.m2504i(47002);
        C1720g.m3537RQ();
        if (((Boolean) C1720g.m3536RP().mo5239Ry().get(C5127a.USERINFO_WALLET_AGREE_PAY_BOOLEAN_SYNC, Boolean.FALSE)).booleanValue()) {
            AppMethodBeat.m2505o(47002);
            return false;
        }
        AppMethodBeat.m2505o(47002);
        return true;
    }
}
