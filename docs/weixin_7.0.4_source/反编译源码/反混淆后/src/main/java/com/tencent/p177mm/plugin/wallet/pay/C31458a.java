package com.tencent.p177mm.plugin.wallet.pay;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.wallet_core.p560b.C29615b;

/* renamed from: com.tencent.mm.plugin.wallet.pay.a */
public class C31458a extends C29615b {
    /* renamed from: c */
    public final void mo8127c(Activity activity, int i) {
        AppMethodBeat.m2504i(45860);
        if (activity != null) {
            activity.finish();
        }
        AppMethodBeat.m2505o(45860);
    }

    /* renamed from: b */
    public final void mo8125b(Activity activity, Bundle bundle) {
        AppMethodBeat.m2504i(45861);
        Intent intent = new Intent();
        intent.putExtras(bundle);
        mo64564a(activity, "wallet", ".pay.ui.WalletPayUI", -1, intent, false);
        AppMethodBeat.m2505o(45861);
    }

    public final String bxP() {
        return "BindCardForPayProcess";
    }
}
