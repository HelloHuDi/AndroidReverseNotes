package com.tencent.mm.plugin.account.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelfriend.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.base.h;

public class LoginSmsUI extends LoginHistoryUI {
    private static String TAG = "LoginSmsUI";

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(125020);
        super.onCreate(bundle);
        if (this.gCl) {
            AppMethodBeat.o(125020);
            return;
        }
        this.gwX = 3;
        if (!bo.ant(this.gCb).booleanValue() && bo.ant(this.gBV).booleanValue()) {
            this.gBI.setText(ws(this.gBV));
        }
        this.gCi.setVisibility(0);
        this.gCi.setInputType(3);
        this.gCi.setSendSmsBtnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(125015);
                h.a(LoginSmsUI.this, LoginSmsUI.this.getString(R.string.dm4) + LoginSmsUI.this.gBV, LoginSmsUI.this.getString(R.string.dm5), LoginSmsUI.this.getString(R.string.s6), LoginSmsUI.this.getString(R.string.or), false, new DialogInterface.OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        AppMethodBeat.i(125013);
                        LoginSmsUI.this.gCi.dzH();
                        LoginSmsUI.a(LoginSmsUI.this, LoginSmsUI.this.gBV);
                        AppMethodBeat.o(125013);
                    }
                }, new DialogInterface.OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        AppMethodBeat.i(125014);
                        LoginSmsUI.this.gCi.reset();
                        AppMethodBeat.o(125014);
                    }
                });
                AppMethodBeat.o(125015);
            }
        });
        this.gCi.addTextChangedListener(new TextWatcher() {
            public final void afterTextChanged(Editable editable) {
                AppMethodBeat.i(125016);
                if (LoginSmsUI.this.gCi.getText().toString().length() > 0) {
                    LoginSmsUI.this.gBK.setEnabled(true);
                    AppMethodBeat.o(125016);
                    return;
                }
                LoginSmsUI.this.gBK.setEnabled(false);
                AppMethodBeat.o(125016);
            }

            public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }
        });
        if (this.gCi.getText().toString().length() > 0) {
            this.gBK.setEnabled(true);
        } else {
            this.gBK.setEnabled(false);
        }
        this.gBK.setVisibility(0);
        this.gBK.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(125017);
                LoginSmsUI.this.aqU();
                AppMethodBeat.o(125017);
            }
        });
        AppMethodBeat.o(125020);
    }

    /* Access modifiers changed, original: protected|final */
    public final void aqU() {
        AppMethodBeat.i(125021);
        super.aqU();
        if (isFinishing() || getWindow() == null) {
            ab.e(TAG, "LoginHistoryUI is finishing");
            AppMethodBeat.o(125021);
            return;
        }
        if (!bo.isNullOrNil(this.gBV)) {
            this.gBT.account = this.gBV;
            aqX();
            aqV();
            final m aVar = new a(this.gBV, 17, this.gCi.getText().toString().trim(), 0, "");
            g.Rg().a(aVar, 0);
            getString(R.string.tz);
            this.ehJ = h.b((Context) this, getString(R.string.cou), true, new OnCancelListener() {
                public final void onCancel(DialogInterface dialogInterface) {
                    AppMethodBeat.i(125019);
                    g.Rg().c(aVar);
                    AppMethodBeat.o(125019);
                }
            });
        }
        AppMethodBeat.o(125021);
    }

    public void onResume() {
        AppMethodBeat.i(125022);
        super.onResume();
        g.Rg().a(145, (f) this);
        AppMethodBeat.o(125022);
    }

    public void onStop() {
        AppMethodBeat.i(125023);
        super.onStop();
        g.Rg().b(145, (f) this);
        AppMethodBeat.o(125023);
    }

    public void onDestroy() {
        AppMethodBeat.i(125024);
        super.onDestroy();
        this.gCi.reset();
        AppMethodBeat.o(125024);
    }

    static /* synthetic */ void a(LoginSmsUI loginSmsUI, String str) {
        AppMethodBeat.i(125025);
        if (!bo.isNullOrNil(str)) {
            final m aVar = new a(str, 16, "", 0, "");
            g.Rg().a(aVar, 0);
            loginSmsUI.getString(R.string.tz);
            loginSmsUI.ehJ = h.b((Context) loginSmsUI, loginSmsUI.getString(R.string.un), true, new OnCancelListener() {
                public final void onCancel(DialogInterface dialogInterface) {
                    AppMethodBeat.i(125018);
                    g.Rg().c(aVar);
                    AppMethodBeat.o(125018);
                }
            });
        }
        AppMethodBeat.o(125025);
    }
}
