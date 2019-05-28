package com.tencent.mm.plugin.wallet.balance.ui.lqt;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.m;
import com.tencent.mm.vending.app.a;
import com.tencent.mm.vending.app.c;
import com.tencent.mm.vending.c.b;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;

public abstract class WalletLqtBasePresenterUI extends WalletBaseUI {
    private c eMI = new c();

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.eMI.A(getIntent(), this);
        this.Ahz = true;
    }

    public void onResume() {
        super.onResume();
        this.eMI.a(2);
    }

    public void onPause() {
        super.onPause();
        this.eMI.a(3);
    }

    public void onDestroy() {
        super.onDestroy();
        this.eMI.onDestroy();
    }

    public final <T extends b<? extends a>> T V(Class<? extends b<? extends a>> cls) {
        return this.eMI.a(this, cls);
    }

    public final <T extends a> T Z(Class<? extends a> cls) {
        return this.eMI.b(this, cls);
    }

    public boolean c(int i, int i2, String str, m mVar) {
        return false;
    }

    public int getLayoutId() {
        return 0;
    }

    public final int getForceOrientation() {
        return 1;
    }
}
