package com.tencent.p177mm.plugin.wallet_core.p561ui.ibg;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.plugin.wallet_core.model.Orders;
import com.tencent.p177mm.plugin.wallet_core.p561ui.WalletOrderInfoOldUI;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.wallet_core.p649c.C44431r;

/* renamed from: com.tencent.mm.plugin.wallet_core.ui.ibg.WalletIbgOrderInfoOldUI */
public class WalletIbgOrderInfoOldUI extends WalletOrderInfoOldUI {
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(47846);
        this.tog = WalletIbgOrderInfoUI.tog;
        super.onCreate(bundle);
        AppMethodBeat.m2505o(47846);
    }

    public final Orders cRD() {
        return this.tog;
    }

    public final void done() {
        AppMethodBeat.m2504i(47847);
        C4990ab.m7416i("MicroMsg.WalletIbgOrderInfoOldUI", "hy: result is not set manly. set to OK");
        for (String str : this.tIc) {
            if (!C5046bo.isNullOrNil(str)) {
                C4990ab.m7411d("MicroMsg.WalletIbgOrderInfoOldUI", "hy: doing netscene subscribe...appName: %s", str);
                C1720g.m3537RQ();
                C1720g.m3535RO().eJo.mo14541a(new C44431r(str), 0);
            }
        }
        setResult(-1);
        finish();
        AppMethodBeat.m2505o(47847);
    }
}
