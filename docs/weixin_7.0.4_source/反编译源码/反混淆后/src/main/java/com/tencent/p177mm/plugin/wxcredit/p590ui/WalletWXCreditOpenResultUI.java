package com.tencent.p177mm.plugin.wxcredit.p590ui;

import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p612ui.base.C5271a;
import com.tencent.p177mm.plugin.wallet_core.model.Bankcard;
import com.tencent.p177mm.plugin.wallet_core.model.C14241r;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.wallet_core.p650ui.WalletBaseUI;

@C5271a(19)
/* renamed from: com.tencent.mm.plugin.wxcredit.ui.WalletWXCreditOpenResultUI */
public class WalletWXCreditOpenResultUI extends WalletBaseUI {
    private CheckBox uZE;

    /* renamed from: com.tencent.mm.plugin.wxcredit.ui.WalletWXCreditOpenResultUI$1 */
    class C464781 implements OnClickListener {
        C464781() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(48744);
            WalletWXCreditOpenResultUI.m87684a(WalletWXCreditOpenResultUI.this);
            AppMethodBeat.m2505o(48744);
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    /* renamed from: a */
    static /* synthetic */ void m87684a(WalletWXCreditOpenResultUI walletWXCreditOpenResultUI) {
        AppMethodBeat.m2504i(48749);
        walletWXCreditOpenResultUI.ari();
        AppMethodBeat.m2505o(48749);
    }

    /* renamed from: c */
    public final boolean mo7885c(int i, int i2, String str, C1207m c1207m) {
        return false;
    }

    public final int getLayoutId() {
        return 2130971190;
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(48745);
        super.onCreate(bundle);
        C1720g.m3537RQ();
        C1720g.m3536RP().mo5239Ry().set(196658, Boolean.TRUE);
        C14241r.cPI().tDa = C5046bo.anT();
        initView();
        AppMethodBeat.m2505o(48745);
    }

    public final void initView() {
        AppMethodBeat.m2504i(48746);
        setMMTitle((int) C25738R.string.fx3);
        TextView textView = (TextView) findViewById(2131829095);
        this.uZE = (CheckBox) findViewById(2131829096);
        if (((Bankcard) this.mBundle.getParcelable("key_bankcard")) != null) {
            this.uZE.setText(getString(C25738R.string.fx5, new Object[]{r1.field_bankName}));
            textView.setText(C25738R.string.fx6);
        }
        ((Button) findViewById(2131822846)).setOnClickListener(new C464781());
        AppMethodBeat.m2505o(48746);
    }

    private void ari() {
        AppMethodBeat.m2504i(48747);
        dOE().mo9366p(Boolean.valueOf(this.uZE.isChecked()));
        AppMethodBeat.m2505o(48747);
    }

    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        AppMethodBeat.m2504i(48748);
        if (i == 4) {
            ari();
            AppMethodBeat.m2505o(48748);
            return true;
        }
        boolean onKeyUp = super.onKeyUp(i, keyEvent);
        AppMethodBeat.m2505o(48748);
        return onKeyUp;
    }
}
