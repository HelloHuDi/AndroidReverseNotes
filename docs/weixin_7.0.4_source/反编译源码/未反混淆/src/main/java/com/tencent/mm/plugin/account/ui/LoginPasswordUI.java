package com.tencent.mm.plugin.account.ui;

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
import com.tencent.mm.R;
import com.tencent.mm.ai.m;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelsimple.q;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.base.h;

public class LoginPasswordUI extends LoginHistoryUI {
    private static String TAG = "LoginPasswordUI";

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(125004);
        super.onCreate(bundle);
        if (this.gCl) {
            AppMethodBeat.o(125004);
            return;
        }
        this.gwX = 2;
        this.gCh.setVisibility(0);
        this.gBK.setVisibility(0);
        this.gBJ.setTypeface(Typeface.DEFAULT);
        this.gBJ.setTransformationMethod(new PasswordTransformationMethod());
        this.gBJ.setOnEditorActionListener(new OnEditorActionListener() {
            public final boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                AppMethodBeat.i(124998);
                if (i == 6 || i == 5) {
                    LoginPasswordUI.this.aqU();
                    AppMethodBeat.o(124998);
                    return true;
                }
                AppMethodBeat.o(124998);
                return false;
            }
        });
        this.gBJ.setOnKeyListener(new OnKeyListener() {
            public final boolean onKey(View view, int i, KeyEvent keyEvent) {
                AppMethodBeat.i(124999);
                if (66 == i && keyEvent.getAction() == 0) {
                    LoginPasswordUI.this.aqU();
                    AppMethodBeat.o(124999);
                    return true;
                }
                AppMethodBeat.o(124999);
                return false;
            }
        });
        this.gBJ.addTextChangedListener(new TextWatcher() {
            public final void afterTextChanged(Editable editable) {
                AppMethodBeat.i(125000);
                if (LoginPasswordUI.this.gBJ.getText().toString().length() > 0) {
                    LoginPasswordUI.this.gBK.setEnabled(true);
                    AppMethodBeat.o(125000);
                    return;
                }
                LoginPasswordUI.this.gBK.setEnabled(false);
                AppMethodBeat.o(125000);
            }

            public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }
        });
        if (this.gBJ.getText().toString().length() > 0) {
            this.gBK.setEnabled(true);
        } else {
            this.gBK.setEnabled(false);
        }
        this.gBK.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(125001);
                LoginPasswordUI.this.aqU();
                AppMethodBeat.o(125001);
            }
        });
        this.gzO = getIntent().getStringExtra("auth_ticket");
        if (!bo.isNullOrNil(this.gzO)) {
            this.gBI.setText(bo.nullAsNil(f.ara()));
            this.gBJ.setText(bo.nullAsNil(f.arb()));
            new ak().postDelayed(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(125002);
                    LoginPasswordUI.this.aqU();
                    AppMethodBeat.o(125002);
                }
            }, 500);
        }
        AppMethodBeat.o(125004);
    }

    /* Access modifiers changed, original: protected|final */
    public final void aqU() {
        AppMethodBeat.i(125005);
        super.aqU();
        if (isFinishing() || getWindow() == null) {
            ab.e(TAG, "LoginHistoryUI is finishing");
            AppMethodBeat.o(125005);
            return;
        }
        this.gBT.guf = this.gBJ.getText().toString();
        if (this.gBT.account.equals("")) {
            h.g(this, R.string.f0w, R.string.cog);
            AppMethodBeat.o(125005);
        } else if (this.gBT.guf.equals("")) {
            h.g(this, R.string.f0s, R.string.cog);
            AppMethodBeat.o(125005);
        } else {
            aqX();
            aqV();
            final m qVar = new q(this.gBT.account, this.gBT.guf, this.gzO, 0);
            g.Rg().a(qVar, 0);
            getString(R.string.tz);
            this.ehJ = h.b((Context) this, getString(R.string.cou), true, new OnCancelListener() {
                public final void onCancel(DialogInterface dialogInterface) {
                    AppMethodBeat.i(125003);
                    g.Rg().c(qVar);
                    LoginPasswordUI.this.aqW();
                    AppMethodBeat.o(125003);
                }
            });
            AppMethodBeat.o(125005);
        }
    }
}
