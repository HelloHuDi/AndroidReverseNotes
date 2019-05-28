package com.tencent.p177mm.plugin.wallet_payu.security_question.p574ui;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p612ui.base.C40671n.C36073c;
import com.tencent.p177mm.p612ui.base.C40671n.C5279d;
import com.tencent.p177mm.p612ui.base.C44273l;
import com.tencent.p177mm.p612ui.base.C5271a;
import com.tencent.p177mm.p612ui.tools.C40890k;
import com.tencent.p177mm.plugin.wallet_payu.security_question.model.C43830d;
import com.tencent.p177mm.plugin.wallet_payu.security_question.model.PayUSecurityQuestion;
import com.tencent.p177mm.wallet_core.C24143a;
import com.tencent.p177mm.wallet_core.p650ui.WalletBaseUI;
import com.tencent.p177mm.wallet_core.p650ui.formview.C30890a;
import com.tencent.p177mm.wallet_core.p650ui.formview.WalletFormView;
import com.tencent.p177mm.wallet_core.p650ui.formview.WalletFormView.C36397a;
import java.util.ArrayList;

@C5271a(3)
/* renamed from: com.tencent.mm.plugin.wallet_payu.security_question.ui.WalletPayUSecurityQuestionSettingUI */
public class WalletPayUSecurityQuestionSettingUI extends WalletBaseUI {
    private Button gHn;
    private WalletPayUSecurityQuestionView tUN;
    private WalletFormView tUO;
    private C40890k tUS;
    private String tUT = "";
    private C40165a tUU;

    /* renamed from: com.tencent.mm.plugin.wallet_payu.security_question.ui.WalletPayUSecurityQuestionSettingUI$2 */
    class C227132 implements C5279d {
        C227132() {
        }

        public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
            AppMethodBeat.m2504i(48583);
            WalletPayUSecurityQuestionSettingUI.this.tUN.setQuestionText(((PayUSecurityQuestion) WalletPayUSecurityQuestionSettingUI.m78590a(WalletPayUSecurityQuestionSettingUI.this).get(i)).desc);
            WalletPayUSecurityQuestionSettingUI.this.tUT = ((PayUSecurityQuestion) WalletPayUSecurityQuestionSettingUI.m78590a(WalletPayUSecurityQuestionSettingUI.this).get(i)).f13718id;
            WalletPayUSecurityQuestionSettingUI.this.tUO.cey();
            C40165a.m68889a(WalletPayUSecurityQuestionSettingUI.this.tUU);
            AppMethodBeat.m2505o(48583);
        }
    }

    /* renamed from: com.tencent.mm.plugin.wallet_payu.security_question.ui.WalletPayUSecurityQuestionSettingUI$4 */
    class C227144 implements C36397a {
        C227144() {
        }

        /* renamed from: hY */
        public final void mo9407hY(boolean z) {
            AppMethodBeat.m2504i(48585);
            C40165a.m68889a(WalletPayUSecurityQuestionSettingUI.this.tUU);
            AppMethodBeat.m2505o(48585);
        }
    }

    /* renamed from: com.tencent.mm.plugin.wallet_payu.security_question.ui.WalletPayUSecurityQuestionSettingUI$5 */
    class C227155 implements OnClickListener {
        C227155() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(48586);
            if (WalletPayUSecurityQuestionSettingUI.this.tUU.cTh()) {
                WalletPayUSecurityQuestionSettingUI.this.mBundle.putString("key_question_id", WalletPayUSecurityQuestionSettingUI.this.tUT);
                WalletPayUSecurityQuestionSettingUI.this.mBundle.putString("key_question_answer", WalletPayUSecurityQuestionSettingUI.this.tUO.getText());
                C24143a.m37116j(WalletPayUSecurityQuestionSettingUI.this, WalletPayUSecurityQuestionSettingUI.this.mBundle);
                AppMethodBeat.m2505o(48586);
                return;
            }
            C40165a.m68889a(WalletPayUSecurityQuestionSettingUI.this.tUU);
            AppMethodBeat.m2505o(48586);
        }
    }

    /* renamed from: com.tencent.mm.plugin.wallet_payu.security_question.ui.WalletPayUSecurityQuestionSettingUI$3 */
    class C297083 implements OnClickListener {
        C297083() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(48584);
            WalletPayUSecurityQuestionSettingUI.this.tUS.mo49182gP();
            AppMethodBeat.m2505o(48584);
        }
    }

    /* renamed from: com.tencent.mm.plugin.wallet_payu.security_question.ui.WalletPayUSecurityQuestionSettingUI$a */
    protected class C40165a {
        protected C40165a() {
        }

        /* renamed from: a */
        static /* synthetic */ void m68889a(C40165a c40165a) {
            AppMethodBeat.m2504i(48589);
            c40165a.cTc();
            AppMethodBeat.m2505o(48589);
        }

        private void cTc() {
            AppMethodBeat.m2504i(48587);
            if (cTh()) {
                WalletPayUSecurityQuestionSettingUI.this.gHn.setEnabled(true);
                AppMethodBeat.m2505o(48587);
                return;
            }
            WalletPayUSecurityQuestionSettingUI.this.gHn.setEnabled(false);
            AppMethodBeat.m2505o(48587);
        }

        /* Access modifiers changed, original: protected|final */
        public final boolean cTh() {
            AppMethodBeat.m2504i(48588);
            if (WalletPayUSecurityQuestionSettingUI.this.tUN.asa() && WalletPayUSecurityQuestionSettingUI.this.tUO.asa()) {
                AppMethodBeat.m2505o(48588);
                return true;
            }
            AppMethodBeat.m2505o(48588);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.wallet_payu.security_question.ui.WalletPayUSecurityQuestionSettingUI$1 */
    class C438311 implements C36073c {
        C438311() {
        }

        /* renamed from: a */
        public final void mo5746a(C44273l c44273l) {
            AppMethodBeat.m2504i(48582);
            c44273l.clear();
            ArrayList a = WalletPayUSecurityQuestionSettingUI.m78590a(WalletPayUSecurityQuestionSettingUI.this);
            if (a != null) {
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= a.size()) {
                        break;
                    }
                    c44273l.add(((PayUSecurityQuestion) a.get(i2)).desc);
                    i = i2 + 1;
                }
            }
            AppMethodBeat.m2505o(48582);
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(48590);
        super.onCreate(bundle);
        this.tUS = new C40890k(this);
        this.tUS.mo49188qR(true);
        this.tUS.rBl = new C438311();
        this.tUS.rBm = new C227132();
        this.tUU = new C40165a();
        this.tUN = (WalletPayUSecurityQuestionView) findViewById(2131826511);
        this.tUO = (WalletFormView) findViewById(2131826512);
        C30890a.m49302g(this.tUO);
        this.gHn = (Button) findViewById(2131826513);
        this.tUN.setOnClickListener(new C297083());
        this.tUO.setOnInputValidChangeListener(new C227144());
        this.gHn.setOnClickListener(new C227155());
        C40165a.m68889a(this.tUU);
        AppMethodBeat.m2505o(48590);
    }

    public void onResume() {
        AppMethodBeat.m2504i(48591);
        super.onResume();
        AppMethodBeat.m2505o(48591);
    }

    /* renamed from: c */
    public final boolean mo7885c(int i, int i2, String str, C1207m c1207m) {
        AppMethodBeat.m2504i(48592);
        if ((c1207m instanceof C43830d) && this.tUS.isShowing()) {
            this.tUS.dismiss();
        }
        AppMethodBeat.m2505o(48592);
        return false;
    }

    public final int getLayoutId() {
        return 2130970355;
    }

    public final boolean cNR() {
        return true;
    }

    /* renamed from: a */
    static /* synthetic */ ArrayList m78590a(WalletPayUSecurityQuestionSettingUI walletPayUSecurityQuestionSettingUI) {
        AppMethodBeat.m2504i(48593);
        ArrayList parcelableArrayList = walletPayUSecurityQuestionSettingUI.mBundle.getParcelableArrayList("key_security_question_list");
        AppMethodBeat.m2505o(48593);
        return parcelableArrayList;
    }
}
