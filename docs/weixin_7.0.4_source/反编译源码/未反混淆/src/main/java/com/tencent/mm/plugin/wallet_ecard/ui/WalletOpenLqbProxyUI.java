package com.tencent.mm.plugin.wallet_ecard.ui;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.m;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.wallet_core.c;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;

@a(3)
public class WalletOpenLqbProxyUI extends WalletBaseUI {
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(48160);
        super.onCreate(bundle);
        AM(4);
        c dOD = dOD();
        if (dOD != null) {
            int i = this.mBundle.getInt(com.tencent.mm.plugin.wallet_ecard.a.a.tPH, 0);
            String string = this.mBundle.getString(com.tencent.mm.plugin.wallet_ecard.a.a.tPN);
            ab.i("MicroMsg.WalletOpenLqbProxyUI", "WalletOpenLqbProxyUI onCreate, openScene: %s, extraData: %s", Integer.valueOf(i), string);
            if (i == 3) {
                dOE().p(Integer.valueOf(i), string);
                AppMethodBeat.o(48160);
                return;
            }
            dOD.b(this, this.mBundle);
            finish();
        }
        AppMethodBeat.o(48160);
    }

    public final boolean c(int i, int i2, String str, m mVar) {
        return false;
    }

    public final int getLayoutId() {
        return -1;
    }
}
