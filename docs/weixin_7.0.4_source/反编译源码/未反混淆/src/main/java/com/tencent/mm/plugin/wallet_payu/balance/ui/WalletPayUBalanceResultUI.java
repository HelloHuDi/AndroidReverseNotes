package com.tencent.mm.plugin.wallet_payu.balance.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.wallet.balance.ui.WalletBalanceResultUI;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.wallet_core.ui.e;

public class WalletPayUBalanceResultUI extends WalletBalanceResultUI {
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public final void initView() {
        AppMethodBeat.i(48328);
        super.initView();
        this.thI.setVisibility(8);
        AppMethodBeat.o(48328);
    }

    public final void cu() {
        AppMethodBeat.i(48329);
        if (this.pWy != null) {
            this.thG.setText(e.e(this.pWy.pTN, this.pWy.pcl));
            if (!(this.thJ == null || bo.isNullOrNil(this.thJ.field_bankName))) {
                if (bo.isNullOrNil(this.thJ.field_bankcardTail)) {
                    this.pMc.setText(this.thJ.field_bankName);
                } else {
                    this.pMc.setText(this.thJ.field_bankName + " " + getString(R.string.foc) + this.thJ.field_bankcardTail);
                    AppMethodBeat.o(48329);
                    return;
                }
            }
        }
        AppMethodBeat.o(48329);
    }
}
