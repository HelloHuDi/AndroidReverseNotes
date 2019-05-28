package com.tencent.p177mm.plugin.wxcredit.p590ui;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.wallet_core.p650ui.C36391e;
import com.tencent.p177mm.wallet_core.p650ui.WalletBaseUI;

/* renamed from: com.tencent.mm.plugin.wxcredit.ui.WalletWXCreditChangeAmountResultUI */
public class WalletWXCreditChangeAmountResultUI extends WalletBaseUI {

    /* renamed from: com.tencent.mm.plugin.wxcredit.ui.WalletWXCreditChangeAmountResultUI$1 */
    class C249331 implements OnMenuItemClickListener {
        C249331() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(48685);
            WalletWXCreditChangeAmountResultUI.this.dOD().mo8124a(WalletWXCreditChangeAmountResultUI.this.mController.ylL, 0, WalletWXCreditChangeAmountResultUI.this.mBundle);
            AppMethodBeat.m2505o(48685);
            return true;
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    /* renamed from: c */
    public final boolean mo7885c(int i, int i2, String str, C1207m c1207m) {
        return false;
    }

    public final int getLayoutId() {
        return 2130971183;
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(48686);
        super.onCreate(bundle);
        initView();
        AppMethodBeat.m2505o(48686);
    }

    public final void initView() {
        AppMethodBeat.m2504i(48687);
        ((TextView) findViewById(2131829079)).setText(C36391e.m59972G(this.mBundle.getDouble("key_credit_amount")));
        showHomeBtn(false);
        enableBackMenu(false);
        addTextOptionMenu(0, getString(C25738R.string.f9142qt), new C249331());
        AppMethodBeat.m2505o(48687);
    }
}
