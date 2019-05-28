package com.tencent.p177mm.plugin.wallet.balance;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.wallet_core.p560b.C29615b;
import com.tencent.p177mm.wallet_core.C40931c;
import com.tencent.p177mm.wallet_core.p649c.C36379x;

/* renamed from: com.tencent.mm.plugin.wallet.balance.a */
public class C43761a extends C29615b {
    public static int teT = 1;
    public static int teU = 2;

    /* renamed from: a */
    public final C40931c mo8123a(Activity activity, Bundle bundle) {
        AppMethodBeat.m2504i(45196);
        C36379x.m59950QN(14);
        C40931c a = super.mo8123a(activity, bundle);
        AppMethodBeat.m2505o(45196);
        return a;
    }

    /* renamed from: c */
    public final void mo8127c(Activity activity, int i) {
        AppMethodBeat.m2504i(45197);
        C36379x.dNV();
        if (activity != null) {
            activity.finish();
        }
        AppMethodBeat.m2505o(45197);
    }

    /* renamed from: b */
    public final void mo8125b(Activity activity, Bundle bundle) {
        AppMethodBeat.m2504i(45198);
        C36379x.dNV();
        if (bundle == null || !bundle.getBoolean("intent_bind_end", false)) {
            activity.finish();
            AppMethodBeat.m2505o(45198);
            return;
        }
        Intent intent = new Intent();
        intent.putExtras(bundle);
        if (bundle.getInt("from_bind_ui", teU) == teT) {
            intent.putExtra("from_bind_ui", teT);
            mo64564a(activity, "wallet", ".balance.ui.WalletBalanceManagerUI", -1, intent, true);
            AppMethodBeat.m2505o(45198);
            return;
        }
        intent.putExtra("from_bind_ui", teU);
        mo64564a(activity, "wallet", ".balance.ui.ltWalletLqtSaveFetchUI", -1, intent, true);
        AppMethodBeat.m2505o(45198);
    }

    public final String bxP() {
        return "BalanceFetchCardProcess";
    }
}
