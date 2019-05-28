package com.tencent.p177mm.plugin.wxcredit.p590ui;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.plugin.wxcredit.C23213b;
import com.tencent.p177mm.wallet_core.C24143a;
import com.tencent.p177mm.wallet_core.p650ui.C36391e;
import com.tencent.p177mm.wallet_core.p650ui.WalletBaseUI;

/* renamed from: com.tencent.mm.plugin.wxcredit.ui.WalletWXCreditOpenNotifyUI */
public class WalletWXCreditOpenNotifyUI extends WalletBaseUI {

    /* renamed from: com.tencent.mm.plugin.wxcredit.ui.WalletWXCreditOpenNotifyUI$1 */
    class C357721 implements OnMenuItemClickListener {
        C357721() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(48740);
            WalletWXCreditOpenNotifyUI.this.setResult(-1);
            WalletWXCreditOpenNotifyUI.this.finish();
            AppMethodBeat.m2505o(48740);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.wxcredit.ui.WalletWXCreditOpenNotifyUI$2 */
    class C357732 implements OnClickListener {
        C357732() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(48741);
            Bundle bundle = new Bundle();
            bundle.putParcelable("key_bankcard", WalletWXCreditOpenNotifyUI.this.mBundle.getParcelable("key_bankcard"));
            C24143a.m37105a(WalletWXCreditOpenNotifyUI.this, C23213b.class, bundle);
            AppMethodBeat.m2505o(48741);
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
        return 2130971189;
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(48742);
        super.onCreate(bundle);
        C1720g.m3537RQ();
        C1720g.m3536RP().mo5239Ry().set(196658, Boolean.FALSE);
        initView();
        AppMethodBeat.m2505o(48742);
    }

    public final void initView() {
        int i = 0;
        AppMethodBeat.m2504i(48743);
        setMMTitle((int) C25738R.string.fx0);
        showHomeBtn(false);
        enableBackMenu(false);
        addTextOptionMenu(0, getString(C25738R.string.f9142qt), new C357721());
        ((TextView) findViewById(2131829079)).setText(C36391e.m59972G(this.mBundle.getDouble("key_total_amount")));
        Button button = (Button) findViewById(2131822846);
        button.setOnClickListener(new C357732());
        if (!this.mBundle.getBoolean("key_can_upgrade_amount", true)) {
            i = 8;
        }
        button.setVisibility(i);
        AppMethodBeat.m2505o(48743);
    }
}
