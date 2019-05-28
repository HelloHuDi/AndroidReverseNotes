package com.tencent.p177mm.plugin.fingerprint.p413b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.wallet_core.model.C35481v;
import com.tencent.p177mm.pluginsdk.wallet.C30157a;
import com.tencent.p177mm.pluginsdk.wallet.C4786k;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;

/* renamed from: com.tencent.mm.plugin.fingerprint.b.o */
public final class C34179o implements C4786k {
    /* renamed from: a */
    public final void mo9938a(C30157a c30157a) {
        AppMethodBeat.m2504i(41556);
        C4990ab.m7416i("MicroMsg.SoterPrePayAuthDelegate", "hy: pre auth prepare.");
        if (C5046bo.isNullOrNil(C35481v.tCn.msn)) {
            C4990ab.m7412e("MicroMsg.SoterPrePayAuthDelegate", "hy: no challenge. failed.");
            c30157a.mo7375aC(-1, "no challenge");
            AppMethodBeat.m2505o(41556);
            return;
        }
        c30157a.mo7375aC(0, "");
        AppMethodBeat.m2505o(41556);
    }
}
