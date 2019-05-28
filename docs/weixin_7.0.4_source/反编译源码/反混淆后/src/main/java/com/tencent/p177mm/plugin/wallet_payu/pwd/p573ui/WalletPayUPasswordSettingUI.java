package com.tencent.p177mm.plugin.wallet_payu.pwd.p573ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.plugin.wallet.pwd.p558ui.WalletPasswordSettingUI;
import com.tencent.p177mm.plugin.wallet_payu.pwd.p1054a.C31468f;
import com.tencent.p177mm.plugin.wallet_payu.pwd.p1054a.C40163g;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.wallet_core.C24143a;

/* renamed from: com.tencent.mm.plugin.wallet_payu.pwd.ui.WalletPayUPasswordSettingUI */
public class WalletPayUPasswordSettingUI extends WalletPasswordSettingUI {
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public final void cOH() {
        AppMethodBeat.m2504i(48520);
        C4990ab.m7410d("MicroMsg.WalletPayUPasswordSettingUI", "hy: start payu do forgot pwd");
        C24143a.m37105a(this, C31468f.class, null);
        AppMethodBeat.m2505o(48520);
    }

    public final void cOG() {
        AppMethodBeat.m2504i(48521);
        C4990ab.m7410d("MicroMsg.WalletPayUPasswordSettingUI", "hy: start payu reset pwd");
        C24143a.m37105a(this, C40163g.class, null);
        AppMethodBeat.m2505o(48521);
    }

    public final int cOF() {
        return C25738R.xml.f8580cu;
    }

    public final void cOI() {
        AppMethodBeat.m2504i(48522);
        this.yCw.mo27715ce("wallet_modify_gesture_password", true);
        this.yCw.mo27715ce("wallet_open_gesture_password", true);
        AppMethodBeat.m2505o(48522);
    }
}
