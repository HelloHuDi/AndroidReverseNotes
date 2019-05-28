package com.tencent.p177mm.plugin.wallet_payu.balance.p567ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.plugin.wallet.balance.p552ui.WalletBalanceResultUI;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.wallet_core.p650ui.C36391e;

/* renamed from: com.tencent.mm.plugin.wallet_payu.balance.ui.WalletPayUBalanceResultUI */
public class WalletPayUBalanceResultUI extends WalletBalanceResultUI {
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public final void initView() {
        AppMethodBeat.m2504i(48328);
        super.initView();
        this.thI.setVisibility(8);
        AppMethodBeat.m2505o(48328);
    }

    /* renamed from: cu */
    public final void mo47805cu() {
        AppMethodBeat.m2504i(48329);
        if (this.pWy != null) {
            this.thG.setText(C36391e.m60006e(this.pWy.pTN, this.pWy.pcl));
            if (!(this.thJ == null || C5046bo.isNullOrNil(this.thJ.field_bankName))) {
                if (C5046bo.isNullOrNil(this.thJ.field_bankcardTail)) {
                    this.pMc.setText(this.thJ.field_bankName);
                } else {
                    this.pMc.setText(this.thJ.field_bankName + " " + getString(C25738R.string.foc) + this.thJ.field_bankcardTail);
                    AppMethodBeat.m2505o(48329);
                    return;
                }
            }
        }
        AppMethodBeat.m2505o(48329);
    }
}
