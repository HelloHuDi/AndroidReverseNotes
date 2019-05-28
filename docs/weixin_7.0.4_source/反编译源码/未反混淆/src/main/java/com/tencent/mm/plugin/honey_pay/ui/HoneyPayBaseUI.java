package com.tencent.mm.plugin.honey_pay.ui;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;

public abstract class HoneyPayBaseUI extends WalletBaseUI {
    protected final String TAG = ("MicroMsg." + getClass().getSimpleName());
    protected int nqT = R.color.a69;

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        bFY();
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(41770);
                HoneyPayBaseUI.this.aqX();
                HoneyPayBaseUI.this.aoB();
                HoneyPayBaseUI.this.finish();
                AppMethodBeat.o(41770);
                return false;
            }
        });
    }

    /* Access modifiers changed, original: protected */
    public void bFY() {
        xE(getResources().getColor(this.nqT));
        dyb();
    }
}
