package com.tencent.mm.plugin.wxcredit.ui;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ai.m;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.e;

public class WalletWXCreditChangeAmountResultUI extends WalletBaseUI {
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public final boolean c(int i, int i2, String str, m mVar) {
        return false;
    }

    public final int getLayoutId() {
        return R.layout.b6j;
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(48686);
        super.onCreate(bundle);
        initView();
        AppMethodBeat.o(48686);
    }

    public final void initView() {
        AppMethodBeat.i(48687);
        ((TextView) findViewById(R.id.fhp)).setText(e.G(this.mBundle.getDouble("key_credit_amount")));
        showHomeBtn(false);
        enableBackMenu(false);
        addTextOptionMenu(0, getString(R.string.qt), new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(48685);
                WalletWXCreditChangeAmountResultUI.this.dOD().a(WalletWXCreditChangeAmountResultUI.this.mController.ylL, 0, WalletWXCreditChangeAmountResultUI.this.mBundle);
                AppMethodBeat.o(48685);
                return true;
            }
        });
        AppMethodBeat.o(48687);
    }
}
