package com.tencent.p177mm.plugin.account.p275ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.graphics.Typeface;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.text.method.PasswordTransformationMethod;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnKeyListener;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.modelsimple.C6686q;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C7306ak;

/* renamed from: com.tencent.mm.plugin.account.ui.LoginPasswordUI */
public class LoginPasswordUI extends LoginHistoryUI {
    private static String TAG = "LoginPasswordUI";

    /* renamed from: com.tencent.mm.plugin.account.ui.LoginPasswordUI$2 */
    class C20202 implements OnKeyListener {
        C20202() {
        }

        public final boolean onKey(View view, int i, KeyEvent keyEvent) {
            AppMethodBeat.m2504i(124999);
            if (66 == i && keyEvent.getAction() == 0) {
                LoginPasswordUI.this.aqU();
                AppMethodBeat.m2505o(124999);
                return true;
            }
            AppMethodBeat.m2505o(124999);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.account.ui.LoginPasswordUI$3 */
    class C20213 implements TextWatcher {
        C20213() {
        }

        public final void afterTextChanged(Editable editable) {
            AppMethodBeat.m2504i(125000);
            if (LoginPasswordUI.this.gBJ.getText().toString().length() > 0) {
                LoginPasswordUI.this.gBK.setEnabled(true);
                AppMethodBeat.m2505o(125000);
                return;
            }
            LoginPasswordUI.this.gBK.setEnabled(false);
            AppMethodBeat.m2505o(125000);
        }

        public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }
    }

    /* renamed from: com.tencent.mm.plugin.account.ui.LoginPasswordUI$4 */
    class C20224 implements OnClickListener {
        C20224() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(125001);
            LoginPasswordUI.this.aqU();
            AppMethodBeat.m2505o(125001);
        }
    }

    /* renamed from: com.tencent.mm.plugin.account.ui.LoginPasswordUI$5 */
    class C188905 implements Runnable {
        C188905() {
        }

        public final void run() {
            AppMethodBeat.m2504i(125002);
            LoginPasswordUI.this.aqU();
            AppMethodBeat.m2505o(125002);
        }
    }

    /* renamed from: com.tencent.mm.plugin.account.ui.LoginPasswordUI$1 */
    class C380651 implements OnEditorActionListener {
        C380651() {
        }

        public final boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
            AppMethodBeat.m2504i(124998);
            if (i == 6 || i == 5) {
                LoginPasswordUI.this.aqU();
                AppMethodBeat.m2505o(124998);
                return true;
            }
            AppMethodBeat.m2505o(124998);
            return false;
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(125004);
        super.onCreate(bundle);
        if (this.gCl) {
            AppMethodBeat.m2505o(125004);
            return;
        }
        this.gwX = 2;
        this.gCh.setVisibility(0);
        this.gBK.setVisibility(0);
        this.gBJ.setTypeface(Typeface.DEFAULT);
        this.gBJ.setTransformationMethod(new PasswordTransformationMethod());
        this.gBJ.setOnEditorActionListener(new C380651());
        this.gBJ.setOnKeyListener(new C20202());
        this.gBJ.addTextChangedListener(new C20213());
        if (this.gBJ.getText().toString().length() > 0) {
            this.gBK.setEnabled(true);
        } else {
            this.gBK.setEnabled(false);
        }
        this.gBK.setOnClickListener(new C20224());
        this.gzO = getIntent().getStringExtra("auth_ticket");
        if (!C5046bo.isNullOrNil(this.gzO)) {
            this.gBI.setText(C5046bo.nullAsNil(C31280f.ara()));
            this.gBJ.setText(C5046bo.nullAsNil(C31280f.arb()));
            new C7306ak().postDelayed(new C188905(), 500);
        }
        AppMethodBeat.m2505o(125004);
    }

    /* Access modifiers changed, original: protected|final */
    public final void aqU() {
        AppMethodBeat.m2504i(125005);
        super.aqU();
        if (isFinishing() || getWindow() == null) {
            C4990ab.m7412e(TAG, "LoginHistoryUI is finishing");
            AppMethodBeat.m2505o(125005);
            return;
        }
        this.gBT.guf = this.gBJ.getText().toString();
        if (this.gBT.account.equals("")) {
            C30379h.m48467g(this, C25738R.string.f0w, C25738R.string.cog);
            AppMethodBeat.m2505o(125005);
        } else if (this.gBT.guf.equals("")) {
            C30379h.m48467g(this, C25738R.string.f0s, C25738R.string.cog);
            AppMethodBeat.m2505o(125005);
        } else {
            aqX();
            aqV();
            final C1207m c6686q = new C6686q(this.gBT.account, this.gBT.guf, this.gzO, 0);
            C1720g.m3540Rg().mo14541a(c6686q, 0);
            getString(C25738R.string.f9238tz);
            this.ehJ = C30379h.m48458b((Context) this, getString(C25738R.string.cou), true, new OnCancelListener() {
                public final void onCancel(DialogInterface dialogInterface) {
                    AppMethodBeat.m2504i(125003);
                    C1720g.m3540Rg().mo14547c(c6686q);
                    LoginPasswordUI.this.aqW();
                    AppMethodBeat.m2505o(125003);
                }
            });
            AppMethodBeat.m2505o(125005);
        }
    }
}
