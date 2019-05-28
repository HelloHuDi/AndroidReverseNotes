package com.tencent.mm.plugin.wallet_ecard.ui;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ai.m;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.wallet_core.ui.formview.WalletFormView;
import com.tencent.mm.wallet_core.ui.formview.WalletFormView.a;

public class WalletECardCheckOtherCardUI extends WalletECardBaseUI implements a {
    private Button gHn;
    private String kGE;
    private WalletFormView pMi;
    private WalletFormView tQF;

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(48134);
        super.onCreate(bundle);
        this.kGE = this.mBundle.getString(com.tencent.mm.plugin.wallet_ecard.a.a.tPY, "");
        setMMTitle(getString(R.string.b88));
        this.Ahr.nf(385);
        initView();
        AppMethodBeat.o(48134);
    }

    public final void initView() {
        AppMethodBeat.i(48135);
        this.pMi = (WalletFormView) findViewById(R.id.bb7);
        this.tQF = (WalletFormView) findViewById(R.id.bb8);
        this.gHn = (Button) findViewById(R.id.bb9);
        com.tencent.mm.wallet_core.ui.formview.a.b(this.pMi);
        com.tencent.mm.wallet_core.ui.formview.a.c(this, this.tQF);
        if (bo.isNullOrNil(this.kGE)) {
            this.pMi.setHint(getString(R.string.b86));
        } else {
            this.pMi.setHint(getString(R.string.b85, new Object[]{this.kGE}));
        }
        this.tQF.setHint(getString(R.string.b87));
        this.pMi.setOnInputValidChangeListener(this);
        this.tQF.setOnInputValidChangeListener(this);
        e(this.pMi, 0, false);
        e(this.tQF, 0, false);
        this.gHn.setEnabled(false);
        this.gHn.setClickable(false);
        this.gHn.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(48133);
                ab.i("MicroMsg.WalletECardCheckOtherCardUI", "do check card");
                if (WalletECardCheckOtherCardUI.this.pMi.asa() && WalletECardCheckOtherCardUI.this.tQF.asa()) {
                    String text = WalletECardCheckOtherCardUI.this.pMi.getText();
                    String text2 = WalletECardCheckOtherCardUI.this.tQF.getText();
                    WalletECardCheckOtherCardUI.this.dOE().p(text, text2);
                    AppMethodBeat.o(48133);
                    return;
                }
                ab.w("MicroMsg.WalletECardCheckOtherCardUI", "input invalid");
                AppMethodBeat.o(48133);
            }
        });
        AppMethodBeat.o(48135);
    }

    public final boolean c(int i, int i2, String str, m mVar) {
        return false;
    }

    public final int getLayoutId() {
        return R.layout.t2;
    }

    public void onDestroy() {
        AppMethodBeat.i(48136);
        super.onDestroy();
        this.Ahr.ng(385);
        AppMethodBeat.o(48136);
    }

    public final void hY(boolean z) {
        AppMethodBeat.i(48137);
        ab.d("MicroMsg.WalletECardCheckOtherCardUI", "is valid: %s", Boolean.valueOf(z));
        if (this.pMi.asa() && this.tQF.asa()) {
            this.gHn.setEnabled(true);
            this.gHn.setClickable(true);
            AppMethodBeat.o(48137);
            return;
        }
        this.gHn.setEnabled(false);
        this.gHn.setClickable(false);
        AppMethodBeat.o(48137);
    }
}
