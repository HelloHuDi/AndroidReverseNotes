package com.tencent.p177mm.plugin.wallet_payu.bind.p568ui;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p612ui.base.C5271a;
import com.tencent.p177mm.plugin.wallet.bind.p553ui.C29591a;
import com.tencent.p177mm.plugin.wallet.bind.p553ui.WalletBankcardManageUI;
import com.tencent.p177mm.plugin.wallet_core.model.Bankcard;
import com.tencent.p177mm.plugin.wallet_core.p749c.p1659b.C46358a;
import com.tencent.p177mm.plugin.wallet_payu.bind.model.C14361c;
import com.tencent.p177mm.plugin.wallet_payu.bind.model.C46382d;
import com.tencent.p177mm.wallet_core.C24143a;

@C5271a(3)
/* renamed from: com.tencent.mm.plugin.wallet_payu.bind.ui.WalletPayUBankcardManageUI */
public class WalletPayUBankcardManageUI extends WalletBankcardManageUI {
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(48354);
        super.onCreate(bundle);
        AppMethodBeat.m2505o(48354);
    }

    /* renamed from: mV */
    public final void mo38273mV(boolean z) {
        AppMethodBeat.m2504i(48355);
        if (z) {
            mo39970a(new C46358a(), false, false);
            AppMethodBeat.m2505o(48355);
            return;
        }
        mo39970a(new C46358a(), true, false);
        AppMethodBeat.m2505o(48355);
    }

    public final void cNv() {
        AppMethodBeat.m2504i(48356);
        C24143a.m37105a(this, C14361c.class, null);
        AppMethodBeat.m2505o(48356);
    }

    /* renamed from: c */
    public final boolean mo7885c(int i, int i2, String str, C1207m c1207m) {
        AppMethodBeat.m2504i(48357);
        if (c1207m instanceof C46358a) {
            cNw();
            AppMethodBeat.m2505o(48357);
            return true;
        }
        AppMethodBeat.m2505o(48357);
        return false;
    }

    public final C29591a cNu() {
        AppMethodBeat.m2504i(48358);
        C22693a c22693a = new C22693a(this, this.tlM);
        AppMethodBeat.m2505o(48358);
        return c22693a;
    }

    /* renamed from: d */
    public final void mo38272d(Bankcard bankcard) {
        AppMethodBeat.m2504i(48359);
        Bundle bundle = new Bundle();
        bundle.putParcelable("key_bankcard", bankcard);
        C24143a.m37105a(this, C46382d.class, bundle);
        AppMethodBeat.m2505o(48359);
    }
}
