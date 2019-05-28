package com.tencent.p177mm.plugin.wallet_ecard.p563ui;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.plugin.wallet_ecard.p1315a.C43818a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.wallet_core.p650ui.formview.C30890a;
import com.tencent.p177mm.wallet_core.p650ui.formview.WalletFormView;
import com.tencent.p177mm.wallet_core.p650ui.formview.WalletFormView.C36397a;

/* renamed from: com.tencent.mm.plugin.wallet_ecard.ui.WalletECardCheckOtherCardUI */
public class WalletECardCheckOtherCardUI extends WalletECardBaseUI implements C36397a {
    private Button gHn;
    private String kGE;
    private WalletFormView pMi;
    private WalletFormView tQF;

    /* renamed from: com.tencent.mm.plugin.wallet_ecard.ui.WalletECardCheckOtherCardUI$1 */
    class C438191 implements OnClickListener {
        C438191() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(48133);
            C4990ab.m7416i("MicroMsg.WalletECardCheckOtherCardUI", "do check card");
            if (WalletECardCheckOtherCardUI.this.pMi.asa() && WalletECardCheckOtherCardUI.this.tQF.asa()) {
                String text = WalletECardCheckOtherCardUI.this.pMi.getText();
                String text2 = WalletECardCheckOtherCardUI.this.tQF.getText();
                WalletECardCheckOtherCardUI.this.dOE().mo9366p(text, text2);
                AppMethodBeat.m2505o(48133);
                return;
            }
            C4990ab.m7420w("MicroMsg.WalletECardCheckOtherCardUI", "input invalid");
            AppMethodBeat.m2505o(48133);
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(48134);
        super.onCreate(bundle);
        this.kGE = this.mBundle.getString(C43818a.tPY, "");
        setMMTitle(getString(C25738R.string.b88));
        this.Ahr.mo49372nf(385);
        initView();
        AppMethodBeat.m2505o(48134);
    }

    public final void initView() {
        AppMethodBeat.m2504i(48135);
        this.pMi = (WalletFormView) findViewById(2131823363);
        this.tQF = (WalletFormView) findViewById(2131823364);
        this.gHn = (Button) findViewById(2131823365);
        C30890a.m49294b(this.pMi);
        C30890a.m49295c(this, this.tQF);
        if (C5046bo.isNullOrNil(this.kGE)) {
            this.pMi.setHint(getString(C25738R.string.b86));
        } else {
            this.pMi.setHint(getString(C25738R.string.b85, new Object[]{this.kGE}));
        }
        this.tQF.setHint(getString(C25738R.string.b87));
        this.pMi.setOnInputValidChangeListener(this);
        this.tQF.setOnInputValidChangeListener(this);
        mo39989e(this.pMi, 0, false);
        mo39989e(this.tQF, 0, false);
        this.gHn.setEnabled(false);
        this.gHn.setClickable(false);
        this.gHn.setOnClickListener(new C438191());
        AppMethodBeat.m2505o(48135);
    }

    /* renamed from: c */
    public final boolean mo7885c(int i, int i2, String str, C1207m c1207m) {
        return false;
    }

    public final int getLayoutId() {
        return 2130969309;
    }

    public void onDestroy() {
        AppMethodBeat.m2504i(48136);
        super.onDestroy();
        this.Ahr.mo49373ng(385);
        AppMethodBeat.m2505o(48136);
    }

    /* renamed from: hY */
    public final void mo9407hY(boolean z) {
        AppMethodBeat.m2504i(48137);
        C4990ab.m7411d("MicroMsg.WalletECardCheckOtherCardUI", "is valid: %s", Boolean.valueOf(z));
        if (this.pMi.asa() && this.tQF.asa()) {
            this.gHn.setEnabled(true);
            this.gHn.setClickable(true);
            AppMethodBeat.m2505o(48137);
            return;
        }
        this.gHn.setEnabled(false);
        this.gHn.setClickable(false);
        AppMethodBeat.m2505o(48137);
    }
}
