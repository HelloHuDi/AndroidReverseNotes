package com.tencent.p177mm.plugin.wallet.balance.p552ui.lqt;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.vending.app.C16025a;
import com.tencent.p177mm.vending.app.C40919c;
import com.tencent.p177mm.vending.p637c.C24135b;
import com.tencent.p177mm.wallet_core.p650ui.WalletBaseUI;

/* renamed from: com.tencent.mm.plugin.wallet.balance.ui.lqt.WalletLqtBasePresenterUI */
public abstract class WalletLqtBasePresenterUI extends WalletBaseUI {
    private C40919c eMI = new C40919c();

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.eMI.mo64539A(getIntent(), this);
        this.Ahz = true;
    }

    public void onResume() {
        super.onResume();
        this.eMI.mo64542a(2);
    }

    public void onPause() {
        super.onPause();
        this.eMI.mo64542a(3);
    }

    public void onDestroy() {
        super.onDestroy();
        this.eMI.onDestroy();
    }

    /* renamed from: V */
    public final <T extends C24135b<? extends C16025a>> T mo74555V(Class<? extends C24135b<? extends C16025a>> cls) {
        return this.eMI.mo64541a(this, cls);
    }

    /* renamed from: Z */
    public final <T extends C16025a> T mo74556Z(Class<? extends C16025a> cls) {
        return this.eMI.mo64543b(this, cls);
    }

    /* renamed from: c */
    public boolean mo7885c(int i, int i2, String str, C1207m c1207m) {
        return false;
    }

    public int getLayoutId() {
        return 0;
    }

    public final int getForceOrientation() {
        return 1;
    }
}
