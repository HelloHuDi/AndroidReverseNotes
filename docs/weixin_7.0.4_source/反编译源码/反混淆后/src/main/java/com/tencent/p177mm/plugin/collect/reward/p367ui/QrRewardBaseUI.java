package com.tencent.p177mm.plugin.collect.reward.p367ui;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.boot.C1319a.C1318a;
import com.tencent.p177mm.wallet_core.p650ui.WalletBaseUI;

/* renamed from: com.tencent.mm.plugin.collect.reward.ui.QrRewardBaseUI */
public abstract class QrRewardBaseUI extends WalletBaseUI {

    /* renamed from: com.tencent.mm.plugin.collect.reward.ui.QrRewardBaseUI$1 */
    class C28371 implements OnMenuItemClickListener {
        C28371() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(41062);
            QrRewardBaseUI.this.aqX();
            QrRewardBaseUI.this.aoB();
            QrRewardBaseUI.this.finish();
            AppMethodBeat.m2505o(41062);
            return false;
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        dyb();
        setBackBtn(new C28371(), C1318a.actionbar_icon_dark_back);
    }
}
