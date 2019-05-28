package com.tencent.mm.plugin.wallet_payu.bind.ui;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.m;
import com.tencent.mm.plugin.wallet.bind.ui.WalletBankcardManageUI;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_payu.bind.model.c;
import com.tencent.mm.plugin.wallet_payu.bind.model.d;
import com.tencent.mm.ui.base.a;

@a(3)
public class WalletPayUBankcardManageUI extends WalletBankcardManageUI {
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(48354);
        super.onCreate(bundle);
        AppMethodBeat.o(48354);
    }

    public final void mV(boolean z) {
        AppMethodBeat.i(48355);
        if (z) {
            a(new com.tencent.mm.plugin.wallet_core.c.b.a(), false, false);
            AppMethodBeat.o(48355);
            return;
        }
        a(new com.tencent.mm.plugin.wallet_core.c.b.a(), true, false);
        AppMethodBeat.o(48355);
    }

    public final void cNv() {
        AppMethodBeat.i(48356);
        com.tencent.mm.wallet_core.a.a(this, c.class, null);
        AppMethodBeat.o(48356);
    }

    public final boolean c(int i, int i2, String str, m mVar) {
        AppMethodBeat.i(48357);
        if (mVar instanceof com.tencent.mm.plugin.wallet_core.c.b.a) {
            cNw();
            AppMethodBeat.o(48357);
            return true;
        }
        AppMethodBeat.o(48357);
        return false;
    }

    public final com.tencent.mm.plugin.wallet.bind.ui.a cNu() {
        AppMethodBeat.i(48358);
        a aVar = new a(this, this.tlM);
        AppMethodBeat.o(48358);
        return aVar;
    }

    public final void d(Bankcard bankcard) {
        AppMethodBeat.i(48359);
        Bundle bundle = new Bundle();
        bundle.putParcelable("key_bankcard", bankcard);
        com.tencent.mm.wallet_core.a.a(this, d.class, bundle);
        AppMethodBeat.o(48359);
    }
}
