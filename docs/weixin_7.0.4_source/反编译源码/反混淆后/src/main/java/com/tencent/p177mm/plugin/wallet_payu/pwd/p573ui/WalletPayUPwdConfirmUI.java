package com.tencent.p177mm.plugin.wallet_payu.pwd.p573ui;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.wallet_core.p561ui.WalletPwdConfirmUI;
import com.tencent.p177mm.wallet_core.p650ui.formview.C30890a;

/* renamed from: com.tencent.mm.plugin.wallet_payu.pwd.ui.WalletPayUPwdConfirmUI */
public class WalletPayUPwdConfirmUI extends WalletPwdConfirmUI {
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(48523);
        super.onCreate(bundle);
        C30890a.m49292a(this.nrZ, false);
        AppMethodBeat.m2505o(48523);
    }
}
