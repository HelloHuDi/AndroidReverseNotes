package com.tencent.p177mm.plugin.offline;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.offline.p479ui.WalletOfflineCoinPurseUI;
import com.tencent.p177mm.plugin.wallet_core.p561ui.WalletVerifyCodeUI;
import com.tencent.p177mm.wallet_core.C40931c;

/* renamed from: com.tencent.mm.plugin.offline.l */
public class C3564l extends C40931c {
    /* renamed from: a */
    public final C40931c mo8123a(Activity activity, Bundle bundle) {
        AppMethodBeat.m2504i(43373);
        mo64571b(activity, WalletVerifyCodeUI.class, bundle);
        AppMethodBeat.m2505o(43373);
        return this;
    }

    /* renamed from: a */
    public final void mo8124a(Activity activity, int i, Bundle bundle) {
        AppMethodBeat.m2504i(43374);
        if (activity instanceof WalletVerifyCodeUI) {
            mo8125b(activity, bundle);
        }
        AppMethodBeat.m2505o(43374);
    }

    /* renamed from: c */
    public final void mo8127c(Activity activity, int i) {
    }

    /* renamed from: b */
    public final void mo8125b(Activity activity, Bundle bundle) {
        AppMethodBeat.m2504i(43375);
        Intent intent = new Intent(activity, WalletOfflineCoinPurseUI.class);
        intent.addFlags(67108864);
        activity.startActivity(intent);
        AppMethodBeat.m2505o(43375);
    }

    /* renamed from: c */
    public final boolean mo8128c(Activity activity, Bundle bundle) {
        return false;
    }

    public final String bxP() {
        return "VerifyProcess";
    }
}
