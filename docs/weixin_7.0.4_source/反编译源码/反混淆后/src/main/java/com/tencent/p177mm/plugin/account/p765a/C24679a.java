package com.tencent.p177mm.plugin.account.p765a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.pluginsdk.C23244m;
import com.tencent.p177mm.pluginsdk.C23255n;
import com.tencent.p177mm.pluginsdk.C23256o;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.plugin.account.a.a */
public final class C24679a implements C23256o {
    public static volatile C23255n gkE;
    public static volatile C23244m gkF;

    /* renamed from: a */
    public final void mo7223a(C23255n c23255n) {
        gkE = c23255n;
    }

    /* renamed from: a */
    public final void mo7222a(C23244m c23244m) {
        AppMethodBeat.m2504i(73678);
        C4990ab.m7417i("MicroMsg.AccountSyncApplication", "regitMMModelCallback %s", c23244m);
        gkF = c23244m;
        AppMethodBeat.m2505o(73678);
    }
}
