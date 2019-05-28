package com.tencent.mm.plugin.collect.reward.ui;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;

public abstract class QrRewardBaseUI extends WalletBaseUI {
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        dyb();
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(41062);
                QrRewardBaseUI.this.aqX();
                QrRewardBaseUI.this.aoB();
                QrRewardBaseUI.this.finish();
                AppMethodBeat.o(41062);
                return false;
            }
        }, R.raw.actionbar_icon_dark_back);
    }
}
