package com.tencent.p177mm.plugin.account.p275ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.modelfriend.C32815a;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;

/* renamed from: com.tencent.mm.plugin.account.ui.LoginSmsUI */
public class LoginSmsUI extends LoginHistoryUI {
    private static String TAG = "LoginSmsUI";

    /* renamed from: com.tencent.mm.plugin.account.ui.LoginSmsUI$2 */
    class C20232 implements TextWatcher {
        C20232() {
        }

        public final void afterTextChanged(Editable editable) {
            AppMethodBeat.m2504i(125016);
            if (LoginSmsUI.this.gCi.getText().toString().length() > 0) {
                LoginSmsUI.this.gBK.setEnabled(true);
                AppMethodBeat.m2505o(125016);
                return;
            }
            LoginSmsUI.this.gBK.setEnabled(false);
            AppMethodBeat.m2505o(125016);
        }

        public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }
    }

    /* renamed from: com.tencent.mm.plugin.account.ui.LoginSmsUI$3 */
    class C20243 implements OnClickListener {
        C20243() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(125017);
            LoginSmsUI.this.aqU();
            AppMethodBeat.m2505o(125017);
        }
    }

    /* renamed from: com.tencent.mm.plugin.account.ui.LoginSmsUI$1 */
    class C266201 implements OnClickListener {

        /* renamed from: com.tencent.mm.plugin.account.ui.LoginSmsUI$1$1 */
        class C188911 implements DialogInterface.OnClickListener {
            C188911() {
            }

            public final void onClick(DialogInterface dialogInterface, int i) {
                AppMethodBeat.m2504i(125013);
                LoginSmsUI.this.gCi.dzH();
                LoginSmsUI.m60900a(LoginSmsUI.this, LoginSmsUI.this.gBV);
                AppMethodBeat.m2505o(125013);
            }
        }

        /* renamed from: com.tencent.mm.plugin.account.ui.LoginSmsUI$1$2 */
        class C266192 implements DialogInterface.OnClickListener {
            C266192() {
            }

            public final void onClick(DialogInterface dialogInterface, int i) {
                AppMethodBeat.m2504i(125014);
                LoginSmsUI.this.gCi.reset();
                AppMethodBeat.m2505o(125014);
            }
        }

        C266201() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(125015);
            C30379h.m48445a(LoginSmsUI.this, LoginSmsUI.this.getString(C25738R.string.dm4) + LoginSmsUI.this.gBV, LoginSmsUI.this.getString(C25738R.string.dm5), LoginSmsUI.this.getString(C25738R.string.f9187s6), LoginSmsUI.this.getString(C25738R.string.f9076or), false, new C188911(), new C266192());
            AppMethodBeat.m2505o(125015);
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(125020);
        super.onCreate(bundle);
        if (this.gCl) {
            AppMethodBeat.m2505o(125020);
            return;
        }
        this.gwX = 3;
        if (!C5046bo.ant(this.gCb).booleanValue() && C5046bo.ant(this.gBV).booleanValue()) {
            this.gBI.setText(mo53543ws(this.gBV));
        }
        this.gCi.setVisibility(0);
        this.gCi.setInputType(3);
        this.gCi.setSendSmsBtnClickListener(new C266201());
        this.gCi.addTextChangedListener(new C20232());
        if (this.gCi.getText().toString().length() > 0) {
            this.gBK.setEnabled(true);
        } else {
            this.gBK.setEnabled(false);
        }
        this.gBK.setVisibility(0);
        this.gBK.setOnClickListener(new C20243());
        AppMethodBeat.m2505o(125020);
    }

    /* Access modifiers changed, original: protected|final */
    public final void aqU() {
        AppMethodBeat.m2504i(125021);
        super.aqU();
        if (isFinishing() || getWindow() == null) {
            C4990ab.m7412e(TAG, "LoginHistoryUI is finishing");
            AppMethodBeat.m2505o(125021);
            return;
        }
        if (!C5046bo.isNullOrNil(this.gBV)) {
            this.gBT.account = this.gBV;
            aqX();
            aqV();
            final C1207m c32815a = new C32815a(this.gBV, 17, this.gCi.getText().toString().trim(), 0, "");
            C1720g.m3540Rg().mo14541a(c32815a, 0);
            getString(C25738R.string.f9238tz);
            this.ehJ = C30379h.m48458b((Context) this, getString(C25738R.string.cou), true, new OnCancelListener() {
                public final void onCancel(DialogInterface dialogInterface) {
                    AppMethodBeat.m2504i(125019);
                    C1720g.m3540Rg().mo14547c(c32815a);
                    AppMethodBeat.m2505o(125019);
                }
            });
        }
        AppMethodBeat.m2505o(125021);
    }

    public void onResume() {
        AppMethodBeat.m2504i(125022);
        super.onResume();
        C1720g.m3540Rg().mo14539a(145, (C1202f) this);
        AppMethodBeat.m2505o(125022);
    }

    public void onStop() {
        AppMethodBeat.m2504i(125023);
        super.onStop();
        C1720g.m3540Rg().mo14546b(145, (C1202f) this);
        AppMethodBeat.m2505o(125023);
    }

    public void onDestroy() {
        AppMethodBeat.m2504i(125024);
        super.onDestroy();
        this.gCi.reset();
        AppMethodBeat.m2505o(125024);
    }

    /* renamed from: a */
    static /* synthetic */ void m60900a(LoginSmsUI loginSmsUI, String str) {
        AppMethodBeat.m2504i(125025);
        if (!C5046bo.isNullOrNil(str)) {
            final C1207m c32815a = new C32815a(str, 16, "", 0, "");
            C1720g.m3540Rg().mo14541a(c32815a, 0);
            loginSmsUI.getString(C25738R.string.f9238tz);
            loginSmsUI.ehJ = C30379h.m48458b((Context) loginSmsUI, loginSmsUI.getString(C25738R.string.f9260un), true, new OnCancelListener() {
                public final void onCancel(DialogInterface dialogInterface) {
                    AppMethodBeat.m2504i(125018);
                    C1720g.m3540Rg().mo14547c(c32815a);
                    AppMethodBeat.m2505o(125018);
                }
            });
        }
        AppMethodBeat.m2505o(125025);
    }
}
