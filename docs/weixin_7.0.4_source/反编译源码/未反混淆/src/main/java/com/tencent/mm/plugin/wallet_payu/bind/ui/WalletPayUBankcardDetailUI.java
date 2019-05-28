package com.tencent.mm.plugin.wallet_payu.bind.ui;

import android.os.Bundle;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.wallet.bind.ui.WalletBankcardDetailUI;

public class WalletPayUBankcardDetailUI extends WalletBankcardDetailUI {
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(48353);
        super.onCreate(bundle);
        if (1 == this.thJ.field_bankcardState) {
            cNs();
            findViewById(R.id.f7r).setVisibility(8);
            findViewById(R.id.f7s).setVisibility(8);
        } else {
            mT(false);
        }
        findViewById(R.id.f7u).setVisibility(8);
        ((TextView) findViewById(R.id.f7v)).setText(R.string.f_b);
        AppMethodBeat.o(48353);
    }
}
