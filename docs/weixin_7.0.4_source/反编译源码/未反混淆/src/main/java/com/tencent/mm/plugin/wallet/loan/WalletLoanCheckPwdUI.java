package com.tencent.mm.plugin.wallet.loan;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.m;
import com.tencent.mm.plugin.wallet_core.c.s;
import com.tencent.mm.plugin.wallet_core.ui.WalletCheckPwdUI;
import com.tencent.mm.ui.base.a;

@a(3)
public class WalletLoanCheckPwdUI extends WalletCheckPwdUI {
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(45837);
        super.onCreate(bundle);
        if (dOD() != null) {
            setBackBtn(new OnMenuItemClickListener() {
                public final boolean onMenuItemClick(MenuItem menuItem) {
                    AppMethodBeat.i(45836);
                    com.tencent.mm.wallet_core.a.o(WalletLoanCheckPwdUI.this, 0);
                    AppMethodBeat.o(45836);
                    return true;
                }
            });
        }
        AppMethodBeat.o(45837);
    }

    public final boolean c(int i, int i2, String str, m mVar) {
        AppMethodBeat.i(45838);
        if (!(mVar instanceof s) || (i == 0 && i2 == 0)) {
            boolean c = super.c(i, i2, str, mVar);
            AppMethodBeat.o(45838);
            return c;
        }
        AppMethodBeat.o(45838);
        return false;
    }

    public final int getForceOrientation() {
        return 1;
    }
}
