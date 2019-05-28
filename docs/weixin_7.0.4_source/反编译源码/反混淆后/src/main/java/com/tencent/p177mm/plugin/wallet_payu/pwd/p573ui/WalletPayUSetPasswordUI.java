package com.tencent.p177mm.plugin.wallet_payu.pwd.p573ui;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.wallet_core.p561ui.WalletSetPasswordUI;
import com.tencent.p177mm.wallet_core.p650ui.formview.C30890a;

/* renamed from: com.tencent.mm.plugin.wallet_payu.pwd.ui.WalletPayUSetPasswordUI */
public class WalletPayUSetPasswordUI extends WalletSetPasswordUI {
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(48524);
        super.onCreate(bundle);
        C30890a.m49292a(this.nrZ, false);
        AppMethodBeat.m2505o(48524);
    }
}
