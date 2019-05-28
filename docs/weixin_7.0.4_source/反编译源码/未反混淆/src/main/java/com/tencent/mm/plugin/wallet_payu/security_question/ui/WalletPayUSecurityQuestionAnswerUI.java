package com.tencent.mm.plugin.wallet_payu.security_question.ui;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ai.m;
import com.tencent.mm.plugin.wallet_payu.security_question.model.PayUSecurityQuestion;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.formview.WalletFormView;

@com.tencent.mm.ui.base.a(3)
public class WalletPayUSecurityQuestionAnswerUI extends WalletBaseUI {
    private Button gHn;
    private WalletPayUSecurityQuestionView tUN;
    private WalletFormView tUO;
    private PayUSecurityQuestion tUP;
    private a tUQ;

    protected class a {
        protected a() {
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(48580);
        super.onCreate(bundle);
        this.tUQ = new a();
        this.tUN = (WalletPayUSecurityQuestionView) findViewById(R.id.dma);
        this.tUO = (WalletFormView) findViewById(R.id.dmb);
        com.tencent.mm.wallet_core.ui.formview.a.g(this.tUO);
        this.gHn = (Button) findViewById(R.id.dmc);
        this.tUO.setOnInputValidChangeListener(new com.tencent.mm.wallet_core.ui.formview.WalletFormView.a() {
            public final void hY(boolean z) {
                boolean z2;
                AppMethodBeat.i(48578);
                a a = WalletPayUSecurityQuestionAnswerUI.this.tUQ;
                if (WalletPayUSecurityQuestionAnswerUI.this.tUO.asa()) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                if (z2) {
                    WalletPayUSecurityQuestionAnswerUI.this.gHn.setEnabled(true);
                    AppMethodBeat.o(48578);
                    return;
                }
                WalletPayUSecurityQuestionAnswerUI.this.gHn.setEnabled(false);
                AppMethodBeat.o(48578);
            }
        });
        this.gHn.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(48579);
                if (WalletPayUSecurityQuestionAnswerUI.this.tUO.asa()) {
                    WalletPayUSecurityQuestionAnswerUI.this.mBundle.putString("key_question_answer", WalletPayUSecurityQuestionAnswerUI.this.tUO.getText());
                    WalletPayUSecurityQuestionAnswerUI.this.dOE().p(new Object[0]);
                }
                AppMethodBeat.o(48579);
            }
        });
        AppMethodBeat.o(48580);
    }

    public final boolean c(int i, int i2, String str, m mVar) {
        AppMethodBeat.i(48581);
        if (i == 0 && i2 == 0) {
            this.tUP = (PayUSecurityQuestion) this.mBundle.getParcelable("key_security_question");
            ab.d("MicroMsg.WalletPayUSecurityQuestionAnswerUI", "hy: updating view");
            if (this.tUP != null) {
                this.tUN.setQuestionText(this.tUP.desc);
            }
            this.tUO.cey();
        }
        AppMethodBeat.o(48581);
        return false;
    }

    public final int getLayoutId() {
        return R.layout.ak8;
    }

    public final boolean cNR() {
        return true;
    }
}
