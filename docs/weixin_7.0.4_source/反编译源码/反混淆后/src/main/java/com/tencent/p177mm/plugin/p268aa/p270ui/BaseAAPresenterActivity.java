package com.tencent.p177mm.plugin.p268aa.p270ui;

import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.model.C1853r;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p208bz.C1338a;
import com.tencent.p177mm.p612ui.p613a.C5218c;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C7306ak;
import com.tencent.p177mm.vending.app.C16025a;
import com.tencent.p177mm.vending.app.C40919c;
import com.tencent.p177mm.vending.p637c.C24135b;
import com.tencent.p177mm.wallet_core.p650ui.C36391e;
import com.tencent.p177mm.wallet_core.p650ui.WalletBaseUI;
import com.tencent.p177mm.wallet_core.p650ui.formview.EditHintPasswdView;
import com.tencent.p177mm.wallet_core.p650ui.formview.WalletFormView;
import com.tenpay.android.wechat.MyKeyboardWindow;

/* renamed from: com.tencent.mm.plugin.aa.ui.BaseAAPresenterActivity */
public abstract class BaseAAPresenterActivity extends WalletBaseUI {
    private static final int gnS = C1338a.fromDPToPix(C4996ah.getContext(), 300);
    private C40919c eMI = new C40919c();
    protected View gnR;

    /* renamed from: com.tencent.mm.plugin.aa.ui.BaseAAPresenterActivity$3 */
    class C98013 implements OnClickListener {
        C98013() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(40779);
            BaseAAPresenterActivity.this.aoB();
            AppMethodBeat.m2505o(40779);
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.eMI.mo64539A(getIntent(), this);
        this.Ahz = true;
    }

    public void onResume() {
        super.onResume();
        this.eMI.mo64542a(2);
    }

    public void onPause() {
        super.onPause();
        this.eMI.mo64542a(3);
    }

    public void onDestroy() {
        super.onDestroy();
        this.eMI.onDestroy();
    }

    /* renamed from: V */
    public final <T extends C24135b<? extends C16025a>> T mo21155V(Class<? extends C24135b<? extends C16025a>> cls) {
        return this.eMI.mo64541a(this, cls);
    }

    /* renamed from: Z */
    public final <T extends C16025a> T mo21156Z(Class<? extends C16025a> cls) {
        return this.eMI.mo64543b(this, cls);
    }

    /* renamed from: c */
    public final boolean mo7885c(int i, int i2, String str, C1207m c1207m) {
        return false;
    }

    /* renamed from: a */
    public final void mo21157a(View view, final int i, final boolean z, boolean z2) {
        this.mKeyboard = (MyKeyboardWindow) findViewById(2131822357);
        this.nTi = findViewById(2131822356);
        View findViewById = findViewById(2131822358);
        final EditText editText = (EditText) view.findViewById(2131820687);
        if (this.mKeyboard != null && editText != null && this.nTi != null) {
            this.nTi.setVisibility(8);
            C36391e.setNoSystemInputOnEditText(editText);
            final boolean z3 = z;
            final boolean z4 = z2;
            final View view2 = view;
            final int i2 = i;
            editText.setOnFocusChangeListener(new OnFocusChangeListener() {

                /* renamed from: com.tencent.mm.plugin.aa.ui.BaseAAPresenterActivity$1$2 */
                class C98042 implements Runnable {
                    C98042() {
                    }

                    public final void run() {
                        AppMethodBeat.m2504i(40776);
                        BaseAAPresenterActivity.this.aoB();
                        if (z3) {
                            ((InputMethodManager) BaseAAPresenterActivity.this.mController.ylL.getSystemService("input_method")).showSoftInput(editText, 0);
                        }
                        AppMethodBeat.m2505o(40776);
                    }
                }

                public final void onFocusChange(final View view, boolean z) {
                    AppMethodBeat.m2504i(40777);
                    if (!view.isFocused() || z3) {
                        new C7306ak().postDelayed(new C98042(), 200);
                        AppMethodBeat.m2505o(40777);
                        return;
                    }
                    ((InputMethodManager) BaseAAPresenterActivity.this.mController.ylL.getSystemService("input_method")).hideSoftInputFromWindow(view.getWindowToken(), 0);
                    new C7306ak().postDelayed(new Runnable() {
                        public final void run() {
                            C5218c c5218c;
                            AppMethodBeat.m2504i(40775);
                            if (!BaseAAPresenterActivity.this.nTi.isShown() && view.isShown()) {
                                if (z4) {
                                    BaseAAPresenterActivity.this.dOC();
                                } else if (!BaseAAPresenterActivity.this.Ahz) {
                                    BaseAAPresenterActivity.this.dOC();
                                }
                                BaseAAPresenterActivity.this.Ahz = false;
                                BaseAAPresenterActivity.m17469a(BaseAAPresenterActivity.this, editText);
                            }
                            if ((view2 instanceof WalletFormView) && VERSION.SDK_INT >= 14) {
                                WalletFormView walletFormView = (WalletFormView) view2;
                                if ((C1853r.m3831YM() || walletFormView.getEncrptType() == 100) && (!C1853r.m3831YM() || walletFormView.getEncrptType() == 0)) {
                                    BaseAAPresenterActivity.this.mKeyboard.resetSecureAccessibility();
                                    editText.setAccessibilityDelegate(null);
                                } else {
                                    c5218c = new C5218c();
                                    BaseAAPresenterActivity.this.mKeyboard.setSecureAccessibility(c5218c);
                                    editText.setAccessibilityDelegate(c5218c);
                                }
                            }
                            if ((view2 instanceof EditHintPasswdView) && VERSION.SDK_INT >= 14) {
                                c5218c = new C5218c();
                                BaseAAPresenterActivity.this.mKeyboard.setSecureAccessibility(c5218c);
                                editText.setAccessibilityDelegate(c5218c);
                            }
                            BaseAAPresenterActivity.this.mo39967QP(i2);
                            BaseAAPresenterActivity.this.mKeyboard.setInputEditText((EditText) view);
                            ((InputMethodManager) BaseAAPresenterActivity.this.mController.ylL.getSystemService("input_method")).hideSoftInputFromWindow(view.getWindowToken(), 0);
                            AppMethodBeat.m2505o(40775);
                        }
                    }, 300);
                    AppMethodBeat.m2505o(40777);
                }
            });
            editText.setOnClickListener(new OnClickListener() {
                public final void onClick(View view) {
                    AppMethodBeat.m2504i(40778);
                    if (BaseAAPresenterActivity.this.nTi.isShown() || z) {
                        if (z) {
                            BaseAAPresenterActivity.this.aoB();
                            ((InputMethodManager) BaseAAPresenterActivity.this.mController.ylL.getSystemService("input_method")).showSoftInput(editText, 0);
                        }
                        AppMethodBeat.m2505o(40778);
                        return;
                    }
                    BaseAAPresenterActivity.this.dOC();
                    BaseAAPresenterActivity.m17469a(BaseAAPresenterActivity.this, editText);
                    BaseAAPresenterActivity.this.mo39967QP(i);
                    AppMethodBeat.m2505o(40778);
                }
            });
            findViewById.setOnClickListener(new C98013());
        }
    }

    public final void aoB() {
        super.aoB();
        if (this.gnR != null) {
            this.gnR.scrollTo(0, 0);
        }
    }
}
