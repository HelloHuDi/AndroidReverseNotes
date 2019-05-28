package com.tencent.p177mm.plugin.wallet_payu.bind.p568ui;

import android.os.Bundle;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.plugin.wallet.bind.p553ui.WalletBankcardDetailUI;

/* renamed from: com.tencent.mm.plugin.wallet_payu.bind.ui.WalletPayUBankcardDetailUI */
public class WalletPayUBankcardDetailUI extends WalletBankcardDetailUI {
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(48353);
        super.onCreate(bundle);
        if (1 == this.thJ.field_bankcardState) {
            cNs();
            findViewById(2131828674).setVisibility(8);
            findViewById(2131828675).setVisibility(8);
        } else {
            mo74559mT(false);
        }
        findViewById(2131828677).setVisibility(8);
        ((TextView) findViewById(2131828678)).setText(C25738R.string.f_b);
        AppMethodBeat.m2505o(48353);
    }
}
