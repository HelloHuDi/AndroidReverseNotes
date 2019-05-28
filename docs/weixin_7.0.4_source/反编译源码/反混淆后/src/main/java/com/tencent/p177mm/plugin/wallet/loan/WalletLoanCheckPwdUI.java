package com.tencent.p177mm.plugin.wallet.loan;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p612ui.base.C5271a;
import com.tencent.p177mm.plugin.wallet_core.p561ui.WalletCheckPwdUI;
import com.tencent.p177mm.plugin.wallet_core.p749c.C7184s;
import com.tencent.p177mm.wallet_core.C24143a;

@C5271a(3)
/* renamed from: com.tencent.mm.plugin.wallet.loan.WalletLoanCheckPwdUI */
public class WalletLoanCheckPwdUI extends WalletCheckPwdUI {

    /* renamed from: com.tencent.mm.plugin.wallet.loan.WalletLoanCheckPwdUI$1 */
    class C71811 implements OnMenuItemClickListener {
        C71811() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(45836);
            C24143a.m37118o(WalletLoanCheckPwdUI.this, 0);
            AppMethodBeat.m2505o(45836);
            return true;
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(45837);
        super.onCreate(bundle);
        if (dOD() != null) {
            setBackBtn(new C71811());
        }
        AppMethodBeat.m2505o(45837);
    }

    /* renamed from: c */
    public final boolean mo7885c(int i, int i2, String str, C1207m c1207m) {
        AppMethodBeat.m2504i(45838);
        if (!(c1207m instanceof C7184s) || (i == 0 && i2 == 0)) {
            boolean c = super.mo7885c(i, i2, str, c1207m);
            AppMethodBeat.m2505o(45838);
            return c;
        }
        AppMethodBeat.m2505o(45838);
        return false;
    }

    public final int getForceOrientation() {
        return 1;
    }
}
