package com.tencent.mm.plugin.wallet_payu.create.ui;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.m;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;

@a(3)
public class WalletPayUVerifyCodeUI extends WalletBaseUI {
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(48403);
        super.onCreate(bundle);
        AppMethodBeat.o(48403);
    }

    public void onResume() {
        AppMethodBeat.i(48404);
        super.onResume();
        AppMethodBeat.o(48404);
    }

    public void onDestroy() {
        AppMethodBeat.i(48405);
        super.onDestroy();
        AppMethodBeat.o(48405);
    }

    public final int getLayoutId() {
        return 0;
    }

    public final boolean c(int i, int i2, String str, m mVar) {
        return false;
    }
}
