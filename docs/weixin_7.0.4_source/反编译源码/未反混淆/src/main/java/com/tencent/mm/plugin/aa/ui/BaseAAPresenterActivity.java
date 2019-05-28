package com.tencent.mm.plugin.aa.ui;

import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ai.m;
import com.tencent.mm.bz.a;
import com.tencent.mm.model.r;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.vending.app.c;
import com.tencent.mm.vending.c.b;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.e;
import com.tencent.mm.wallet_core.ui.formview.EditHintPasswdView;
import com.tencent.mm.wallet_core.ui.formview.WalletFormView;
import com.tenpay.android.wechat.MyKeyboardWindow;

public abstract class BaseAAPresenterActivity extends WalletBaseUI {
    private static final int gnS = a.fromDPToPix(ah.getContext(), 300);
    private c eMI = new c();
    protected View gnR;

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.eMI.A(getIntent(), this);
        this.Ahz = true;
    }

    public void onResume() {
        super.onResume();
        this.eMI.a(2);
    }

    public void onPause() {
        super.onPause();
        this.eMI.a(3);
    }

    public void onDestroy() {
        super.onDestroy();
        this.eMI.onDestroy();
    }

    public final <T extends b<? extends com.tencent.mm.vending.app.a>> T V(Class<? extends b<? extends com.tencent.mm.vending.app.a>> cls) {
        return this.eMI.a(this, cls);
    }

    public final <T extends com.tencent.mm.vending.app.a> T Z(Class<? extends com.tencent.mm.vending.app.a> cls) {
        return this.eMI.b(this, cls);
    }

    public final boolean c(int i, int i2, String str, m mVar) {
        return false;
    }

    public final void a(View view, final int i, final boolean z, boolean z2) {
        this.mKeyboard = (MyKeyboardWindow) findViewById(R.id.akz);
        this.nTi = findViewById(R.id.aky);
        View findViewById = findViewById(R.id.al0);
        final EditText editText = (EditText) view.findViewById(R.id.d6);
        if (this.mKeyboard != null && editText != null && this.nTi != null) {
            this.nTi.setVisibility(8);
            e.setNoSystemInputOnEditText(editText);
            final boolean z3 = z;
            final boolean z4 = z2;
            final View view2 = view;
            final int i2 = i;
            editText.setOnFocusChangeListener(new OnFocusChangeListener() {
                public final void onFocusChange(final View view, boolean z) {
                    AppMethodBeat.i(40777);
                    if (!view.isFocused() || z3) {
                        new ak().postDelayed(new Runnable() {
                            public final void run() {
                                AppMethodBeat.i(40776);
                                BaseAAPresenterActivity.this.aoB();
                                if (z3) {
                                    ((InputMethodManager) BaseAAPresenterActivity.this.mController.ylL.getSystemService("input_method")).showSoftInput(editText, 0);
                                }
                                AppMethodBeat.o(40776);
                            }
                        }, 200);
                        AppMethodBeat.o(40777);
                        return;
                    }
                    ((InputMethodManager) BaseAAPresenterActivity.this.mController.ylL.getSystemService("input_method")).hideSoftInputFromWindow(view.getWindowToken(), 0);
                    new ak().postDelayed(new Runnable() {
                        public final void run() {
                            com.tencent.mm.ui.a.c cVar;
                            AppMethodBeat.i(40775);
                            if (!BaseAAPresenterActivity.this.nTi.isShown() && view.isShown()) {
                                if (z4) {
                                    BaseAAPresenterActivity.this.dOC();
                                } else if (!BaseAAPresenterActivity.this.Ahz) {
                                    BaseAAPresenterActivity.this.dOC();
                                }
                                BaseAAPresenterActivity.this.Ahz = false;
                                BaseAAPresenterActivity.a(BaseAAPresenterActivity.this, editText);
                            }
                            if ((view2 instanceof WalletFormView) && VERSION.SDK_INT >= 14) {
                                WalletFormView walletFormView = (WalletFormView) view2;
                                if ((r.YM() || walletFormView.getEncrptType() == 100) && (!r.YM() || walletFormView.getEncrptType() == 0)) {
                                    BaseAAPresenterActivity.this.mKeyboard.resetSecureAccessibility();
                                    editText.setAccessibilityDelegate(null);
                                } else {
                                    cVar = new com.tencent.mm.ui.a.c();
                                    BaseAAPresenterActivity.this.mKeyboard.setSecureAccessibility(cVar);
                                    editText.setAccessibilityDelegate(cVar);
                                }
                            }
                            if ((view2 instanceof EditHintPasswdView) && VERSION.SDK_INT >= 14) {
                                cVar = new com.tencent.mm.ui.a.c();
                                BaseAAPresenterActivity.this.mKeyboard.setSecureAccessibility(cVar);
                                editText.setAccessibilityDelegate(cVar);
                            }
                            BaseAAPresenterActivity.this.QP(i2);
                            BaseAAPresenterActivity.this.mKeyboard.setInputEditText((EditText) view);
                            ((InputMethodManager) BaseAAPresenterActivity.this.mController.ylL.getSystemService("input_method")).hideSoftInputFromWindow(view.getWindowToken(), 0);
                            AppMethodBeat.o(40775);
                        }
                    }, 300);
                    AppMethodBeat.o(40777);
                }
            });
            editText.setOnClickListener(new OnClickListener() {
                public final void onClick(View view) {
                    AppMethodBeat.i(40778);
                    if (BaseAAPresenterActivity.this.nTi.isShown() || z) {
                        if (z) {
                            BaseAAPresenterActivity.this.aoB();
                            ((InputMethodManager) BaseAAPresenterActivity.this.mController.ylL.getSystemService("input_method")).showSoftInput(editText, 0);
                        }
                        AppMethodBeat.o(40778);
                        return;
                    }
                    BaseAAPresenterActivity.this.dOC();
                    BaseAAPresenterActivity.a(BaseAAPresenterActivity.this, editText);
                    BaseAAPresenterActivity.this.QP(i);
                    AppMethodBeat.o(40778);
                }
            });
            findViewById.setOnClickListener(new OnClickListener() {
                public final void onClick(View view) {
                    AppMethodBeat.i(40779);
                    BaseAAPresenterActivity.this.aoB();
                    AppMethodBeat.o(40779);
                }
            });
        }
    }

    public final void aoB() {
        super.aoB();
        if (this.gnR != null) {
            this.gnR.scrollTo(0, 0);
        }
    }
}
