package com.tencent.p177mm.plugin.appbrand.appusage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C1812ai;
import com.tencent.p177mm.storage.C5128ac.C5127a;

/* renamed from: com.tencent.mm.plugin.appbrand.appusage.ad */
public final class C38125ad extends C1812ai {
    public final void transfer(int i) {
        AppMethodBeat.m2504i(129715);
        if (mo5386kw(i)) {
            C1720g.m3536RP().mo5239Ry().set(C5127a.APPBRAND_PREDOWNLOAD_DONE_USAGE_USERNAME_DUPLICATE_BEFORE_BOOLEAN_SYNC, Boolean.FALSE);
        }
        AppMethodBeat.m2505o(129715);
    }

    /* renamed from: kw */
    public final boolean mo5386kw(int i) {
        int i2 = 1;
        int i3 = i != 0 ? 1 : 0;
        if (i >= 637927936) {
            i2 = 0;
        }
        return i2 & i3;
    }

    public final String getTag() {
        return "MicroMsg.AppBrand.DuplicateUsageUsernameSetFlagDataTransfer";
    }
}
