package com.tencent.p177mm.plugin.wxcredit.p590ui;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.plugin.wallet_core.model.Bankcard;
import com.tencent.p177mm.wallet_core.C24143a;
import com.tencent.p177mm.wallet_core.p650ui.C36391e;
import com.tencent.p177mm.wallet_core.p650ui.WalletBaseUI;

/* renamed from: com.tencent.mm.plugin.wxcredit.ui.WalletWXCreditErrDetailUI */
public class WalletWXCreditErrDetailUI extends WalletBaseUI {
    private Bankcard thJ;
    private TextView uZA;
    private TextView uZB;
    private String uZz;

    /* renamed from: com.tencent.mm.plugin.wxcredit.ui.WalletWXCreditErrDetailUI$2 */
    class C232242 implements OnClickListener {
        C232242() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(48737);
            C24143a.m37116j(WalletWXCreditErrDetailUI.this, WalletWXCreditErrDetailUI.this.mBundle);
            AppMethodBeat.m2505o(48737);
        }
    }

    /* renamed from: com.tencent.mm.plugin.wxcredit.ui.WalletWXCreditErrDetailUI$1 */
    class C249421 implements OnClickListener {
        C249421() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(48736);
            C36391e.m60016n(WalletWXCreditErrDetailUI.this, WalletWXCreditErrDetailUI.this.uZz, false);
            AppMethodBeat.m2505o(48736);
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public final int getLayoutId() {
        return 2130971188;
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(48738);
        super.onCreate(bundle);
        setMMTitle((int) C25738R.string.f_h);
        initView();
        AppMethodBeat.m2505o(48738);
    }

    /* renamed from: c */
    public final boolean mo7885c(int i, int i2, String str, C1207m c1207m) {
        return false;
    }

    public final void initView() {
        AppMethodBeat.m2504i(48739);
        this.thJ = (Bankcard) this.mBundle.getParcelable("key_bankcard");
        this.uZz = this.mBundle.getString("key_repayment_url");
        if (this.thJ == null) {
            AppMethodBeat.m2505o(48739);
            return;
        }
        this.uZA = (TextView) findViewById(2131829094);
        this.uZA.setOnClickListener(new C249421());
        this.uZB = (TextView) findViewById(2131828673);
        this.uZB.setOnClickListener(new C232242());
        this.uZB.setVisibility(this.mBundle.getBoolean("key_can_unbind", true) ? 0 : 8);
        AppMethodBeat.m2505o(48739);
    }
}
