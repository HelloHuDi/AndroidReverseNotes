package com.tencent.p177mm.plugin.wallet_payu.security_question.p574ui;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p612ui.base.C5271a;
import com.tencent.p177mm.plugin.wallet_payu.security_question.model.PayUSecurityQuestion;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.wallet_core.p650ui.WalletBaseUI;
import com.tencent.p177mm.wallet_core.p650ui.formview.C30890a;
import com.tencent.p177mm.wallet_core.p650ui.formview.WalletFormView;
import com.tencent.p177mm.wallet_core.p650ui.formview.WalletFormView.C36397a;

@C5271a(3)
/* renamed from: com.tencent.mm.plugin.wallet_payu.security_question.ui.WalletPayUSecurityQuestionAnswerUI */
public class WalletPayUSecurityQuestionAnswerUI extends WalletBaseUI {
    private Button gHn;
    private WalletPayUSecurityQuestionView tUN;
    private WalletFormView tUO;
    private PayUSecurityQuestion tUP;
    private C29707a tUQ;

    /* renamed from: com.tencent.mm.plugin.wallet_payu.security_question.ui.WalletPayUSecurityQuestionAnswerUI$2 */
    class C45012 implements OnClickListener {
        C45012() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(48579);
            if (WalletPayUSecurityQuestionAnswerUI.this.tUO.asa()) {
                WalletPayUSecurityQuestionAnswerUI.this.mBundle.putString("key_question_answer", WalletPayUSecurityQuestionAnswerUI.this.tUO.getText());
                WalletPayUSecurityQuestionAnswerUI.this.dOE().mo9366p(new Object[0]);
            }
            AppMethodBeat.m2505o(48579);
        }
    }

    /* renamed from: com.tencent.mm.plugin.wallet_payu.security_question.ui.WalletPayUSecurityQuestionAnswerUI$1 */
    class C297061 implements C36397a {
        C297061() {
        }

        /* renamed from: hY */
        public final void mo9407hY(boolean z) {
            boolean z2;
            AppMethodBeat.m2504i(48578);
            C29707a a = WalletPayUSecurityQuestionAnswerUI.this.tUQ;
            if (WalletPayUSecurityQuestionAnswerUI.this.tUO.asa()) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (z2) {
                WalletPayUSecurityQuestionAnswerUI.this.gHn.setEnabled(true);
                AppMethodBeat.m2505o(48578);
                return;
            }
            WalletPayUSecurityQuestionAnswerUI.this.gHn.setEnabled(false);
            AppMethodBeat.m2505o(48578);
        }
    }

    /* renamed from: com.tencent.mm.plugin.wallet_payu.security_question.ui.WalletPayUSecurityQuestionAnswerUI$a */
    protected class C29707a {
        protected C29707a() {
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(48580);
        super.onCreate(bundle);
        this.tUQ = new C29707a();
        this.tUN = (WalletPayUSecurityQuestionView) findViewById(2131826511);
        this.tUO = (WalletFormView) findViewById(2131826512);
        C30890a.m49302g(this.tUO);
        this.gHn = (Button) findViewById(2131826513);
        this.tUO.setOnInputValidChangeListener(new C297061());
        this.gHn.setOnClickListener(new C45012());
        AppMethodBeat.m2505o(48580);
    }

    /* renamed from: c */
    public final boolean mo7885c(int i, int i2, String str, C1207m c1207m) {
        AppMethodBeat.m2504i(48581);
        if (i == 0 && i2 == 0) {
            this.tUP = (PayUSecurityQuestion) this.mBundle.getParcelable("key_security_question");
            C4990ab.m7410d("MicroMsg.WalletPayUSecurityQuestionAnswerUI", "hy: updating view");
            if (this.tUP != null) {
                this.tUN.setQuestionText(this.tUP.desc);
            }
            this.tUO.cey();
        }
        AppMethodBeat.m2505o(48581);
        return false;
    }

    public final int getLayoutId() {
        return 2130970354;
    }

    public final boolean cNR() {
        return true;
    }
}
