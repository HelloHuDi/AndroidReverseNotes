package com.tencent.p177mm.plugin.wallet_payu.balance.p567ui;

import android.content.Context;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.plugin.wallet.balance.p552ui.WalletBalanceSaveUI;
import com.tencent.p177mm.plugin.wallet_payu.balance.p1316a.C43824a;
import com.tencent.p177mm.pluginsdk.wallet.C35899h;

/* renamed from: com.tencent.mm.plugin.wallet_payu.balance.ui.WalletPayUBalanceSaveUI */
public class WalletPayUBalanceSaveUI extends WalletBalanceSaveUI {
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(48330);
        super.onCreate(bundle);
        this.tgF.setVisibility(8);
        AppMethodBeat.m2505o(48330);
    }

    public final void cNd() {
        AppMethodBeat.m2504i(48331);
        mo39970a(new C43824a(this.pQV, "ZAR"), true, true);
        AppMethodBeat.m2505o(48331);
    }

    /* renamed from: c */
    public final boolean mo7885c(int i, int i2, String str, C1207m c1207m) {
        AppMethodBeat.m2504i(48332);
        if (i == 0 && i2 == 0 && (c1207m instanceof C43824a)) {
            C35899h.m58854a((Context) this, ((C43824a) c1207m).czZ, "", 11, 1);
        }
        AppMethodBeat.m2505o(48332);
        return false;
    }
}
