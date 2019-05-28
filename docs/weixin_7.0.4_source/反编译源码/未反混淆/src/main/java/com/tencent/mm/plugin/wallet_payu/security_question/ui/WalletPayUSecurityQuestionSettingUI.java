package com.tencent.mm.plugin.wallet_payu.security_question.ui;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ai.m;
import com.tencent.mm.plugin.wallet_payu.security_question.model.PayUSecurityQuestion;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.base.n.c;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.tools.k;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.formview.WalletFormView;
import java.util.ArrayList;

@com.tencent.mm.ui.base.a(3)
public class WalletPayUSecurityQuestionSettingUI extends WalletBaseUI {
    private Button gHn;
    private WalletPayUSecurityQuestionView tUN;
    private WalletFormView tUO;
    private k tUS;
    private String tUT = "";
    private a tUU;

    protected class a {
        protected a() {
        }

        static /* synthetic */ void a(a aVar) {
            AppMethodBeat.i(48589);
            aVar.cTc();
            AppMethodBeat.o(48589);
        }

        private void cTc() {
            AppMethodBeat.i(48587);
            if (cTh()) {
                WalletPayUSecurityQuestionSettingUI.this.gHn.setEnabled(true);
                AppMethodBeat.o(48587);
                return;
            }
            WalletPayUSecurityQuestionSettingUI.this.gHn.setEnabled(false);
            AppMethodBeat.o(48587);
        }

        /* Access modifiers changed, original: protected|final */
        public final boolean cTh() {
            AppMethodBeat.i(48588);
            if (WalletPayUSecurityQuestionSettingUI.this.tUN.asa() && WalletPayUSecurityQuestionSettingUI.this.tUO.asa()) {
                AppMethodBeat.o(48588);
                return true;
            }
            AppMethodBeat.o(48588);
            return false;
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(48590);
        super.onCreate(bundle);
        this.tUS = new k(this);
        this.tUS.qR(true);
        this.tUS.rBl = new c() {
            public final void a(l lVar) {
                AppMethodBeat.i(48582);
                lVar.clear();
                ArrayList a = WalletPayUSecurityQuestionSettingUI.a(WalletPayUSecurityQuestionSettingUI.this);
                if (a != null) {
                    int i = 0;
                    while (true) {
                        int i2 = i;
                        if (i2 >= a.size()) {
                            break;
                        }
                        lVar.add(((PayUSecurityQuestion) a.get(i2)).desc);
                        i = i2 + 1;
                    }
                }
                AppMethodBeat.o(48582);
            }
        };
        this.tUS.rBm = new d() {
            public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
                AppMethodBeat.i(48583);
                WalletPayUSecurityQuestionSettingUI.this.tUN.setQuestionText(((PayUSecurityQuestion) WalletPayUSecurityQuestionSettingUI.a(WalletPayUSecurityQuestionSettingUI.this).get(i)).desc);
                WalletPayUSecurityQuestionSettingUI.this.tUT = ((PayUSecurityQuestion) WalletPayUSecurityQuestionSettingUI.a(WalletPayUSecurityQuestionSettingUI.this).get(i)).id;
                WalletPayUSecurityQuestionSettingUI.this.tUO.cey();
                a.a(WalletPayUSecurityQuestionSettingUI.this.tUU);
                AppMethodBeat.o(48583);
            }
        };
        this.tUU = new a();
        this.tUN = (WalletPayUSecurityQuestionView) findViewById(R.id.dma);
        this.tUO = (WalletFormView) findViewById(R.id.dmb);
        com.tencent.mm.wallet_core.ui.formview.a.g(this.tUO);
        this.gHn = (Button) findViewById(R.id.dmc);
        this.tUN.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(48584);
                WalletPayUSecurityQuestionSettingUI.this.tUS.gP();
                AppMethodBeat.o(48584);
            }
        });
        this.tUO.setOnInputValidChangeListener(new com.tencent.mm.wallet_core.ui.formview.WalletFormView.a() {
            public final void hY(boolean z) {
                AppMethodBeat.i(48585);
                a.a(WalletPayUSecurityQuestionSettingUI.this.tUU);
                AppMethodBeat.o(48585);
            }
        });
        this.gHn.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(48586);
                if (WalletPayUSecurityQuestionSettingUI.this.tUU.cTh()) {
                    WalletPayUSecurityQuestionSettingUI.this.mBundle.putString("key_question_id", WalletPayUSecurityQuestionSettingUI.this.tUT);
                    WalletPayUSecurityQuestionSettingUI.this.mBundle.putString("key_question_answer", WalletPayUSecurityQuestionSettingUI.this.tUO.getText());
                    com.tencent.mm.wallet_core.a.j(WalletPayUSecurityQuestionSettingUI.this, WalletPayUSecurityQuestionSettingUI.this.mBundle);
                    AppMethodBeat.o(48586);
                    return;
                }
                a.a(WalletPayUSecurityQuestionSettingUI.this.tUU);
                AppMethodBeat.o(48586);
            }
        });
        a.a(this.tUU);
        AppMethodBeat.o(48590);
    }

    public void onResume() {
        AppMethodBeat.i(48591);
        super.onResume();
        AppMethodBeat.o(48591);
    }

    public final boolean c(int i, int i2, String str, m mVar) {
        AppMethodBeat.i(48592);
        if ((mVar instanceof com.tencent.mm.plugin.wallet_payu.security_question.model.d) && this.tUS.isShowing()) {
            this.tUS.dismiss();
        }
        AppMethodBeat.o(48592);
        return false;
    }

    public final int getLayoutId() {
        return R.layout.ak9;
    }

    public final boolean cNR() {
        return true;
    }

    static /* synthetic */ ArrayList a(WalletPayUSecurityQuestionSettingUI walletPayUSecurityQuestionSettingUI) {
        AppMethodBeat.i(48593);
        ArrayList parcelableArrayList = walletPayUSecurityQuestionSettingUI.mBundle.getParcelableArrayList("key_security_question_list");
        AppMethodBeat.o(48593);
        return parcelableArrayList;
    }
}
