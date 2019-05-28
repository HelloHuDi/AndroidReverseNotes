package com.tencent.p177mm.plugin.wxcredit.p590ui;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p612ui.base.C23639t;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.wallet_core.p650ui.WalletBaseUI;
import com.tencent.p177mm.wallet_core.p650ui.formview.C30890a;
import com.tencent.p177mm.wallet_core.p650ui.formview.WalletFormView;

/* renamed from: com.tencent.mm.plugin.wxcredit.ui.WalletCheckIdentityUI */
public class WalletCheckIdentityUI extends WalletBaseUI {
    private WalletFormView tEq;
    private WalletFormView trX;
    private String uYV;

    /* renamed from: com.tencent.mm.plugin.wxcredit.ui.WalletCheckIdentityUI$1 */
    class C404111 implements OnClickListener {
        C404111() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(48681);
            if (WalletCheckIdentityUI.m79115a(WalletCheckIdentityUI.this, WalletCheckIdentityUI.this.tEq.getText(), WalletCheckIdentityUI.this.trX.getText())) {
                WalletCheckIdentityUI.this.dOE().mo9366p(r0, r1);
            }
            AppMethodBeat.m2505o(48681);
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(48682);
        super.onCreate(bundle);
        initView();
        AppMethodBeat.m2505o(48682);
    }

    /* renamed from: c */
    public final boolean mo7885c(int i, int i2, String str, C1207m c1207m) {
        return false;
    }

    public final int getLayoutId() {
        return 2130971185;
    }

    public final void initView() {
        AppMethodBeat.m2504i(48683);
        setMMTitle((int) C25738R.string.fd3);
        this.tEq = (WalletFormView) findViewById(2131828681);
        C30890a.m49299e(this, this.tEq);
        this.trX = (WalletFormView) findViewById(2131828720);
        C30890a.m49296c(this.trX);
        mo39989e(this.trX, 1, false);
        String string = this.mBundle.getString("key_pre_name");
        this.uYV = this.mBundle.getString("key_pre_indentity");
        if (!C5046bo.isNullOrNil(string)) {
            this.tEq.getPrefilledTv().setText(string);
            this.tEq.setHint(getString(C25738R.string.fcs));
        }
        if (!C5046bo.isNullOrNil(this.uYV)) {
            this.trX.setMaxInputLength(4);
            this.trX.getPrefilledTv().setText(this.uYV);
            this.trX.setHint(getString(C25738R.string.fbj));
        }
        findViewById(2131822846).setOnClickListener(new C404111());
        AppMethodBeat.m2505o(48683);
    }

    public final int getForceOrientation() {
        return 1;
    }

    /* renamed from: a */
    static /* synthetic */ boolean m79115a(WalletCheckIdentityUI walletCheckIdentityUI, String str, String str2) {
        AppMethodBeat.m2504i(48684);
        if (C5046bo.isNullOrNil(str)) {
            C23639t.makeText(walletCheckIdentityUI, C25738R.string.fd1, 0).show();
            AppMethodBeat.m2505o(48684);
            return false;
        } else if (C5046bo.isNullOrNil(str2) || str2.length() < 4 || (C5046bo.isNullOrNil(walletCheckIdentityUI.uYV) && !walletCheckIdentityUI.trX.asa())) {
            C23639t.makeText(walletCheckIdentityUI, C25738R.string.fbg, 0).show();
            AppMethodBeat.m2505o(48684);
            return false;
        } else {
            AppMethodBeat.m2505o(48684);
            return true;
        }
    }
}
