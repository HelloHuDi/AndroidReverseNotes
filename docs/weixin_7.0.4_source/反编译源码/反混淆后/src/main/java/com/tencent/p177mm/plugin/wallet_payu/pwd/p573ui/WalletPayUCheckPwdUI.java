package com.tencent.p177mm.plugin.wallet_payu.pwd.p573ui;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p612ui.base.C5271a;
import com.tencent.p177mm.plugin.wallet_core.p561ui.WalletCheckPwdUI;
import com.tencent.p177mm.wallet_core.p650ui.formview.C30890a;

@C5271a(3)
/* renamed from: com.tencent.mm.plugin.wallet_payu.pwd.ui.WalletPayUCheckPwdUI */
public class WalletPayUCheckPwdUI extends WalletCheckPwdUI {
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(48519);
        super.onCreate(bundle);
        C30890a.m49292a(this.nrZ, true);
        AppMethodBeat.m2505o(48519);
    }

    public final boolean cNR() {
        return true;
    }
}
