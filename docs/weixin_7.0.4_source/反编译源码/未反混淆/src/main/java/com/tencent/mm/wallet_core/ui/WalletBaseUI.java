package com.tencent.mm.wallet_core.ui;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnFocusChangeListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ai.m;
import com.tencent.mm.bz.a;
import com.tencent.mm.model.r;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.q.b;
import com.tencent.mm.wallet_core.c;
import com.tencent.mm.wallet_core.c.h;
import com.tencent.mm.wallet_core.c.j;
import com.tencent.mm.wallet_core.c.l;
import com.tencent.mm.wallet_core.c.q;
import com.tencent.mm.wallet_core.c.w;
import com.tencent.mm.wallet_core.d.f;
import com.tencent.mm.wallet_core.d.g;
import com.tencent.mm.wallet_core.d.i;
import com.tencent.mm.wallet_core.keyboard.WcPayKeyboard;
import com.tencent.mm.wallet_core.ui.formview.EditHintPasswdView;
import com.tencent.mm.wallet_core.ui.formview.WalletFormView;
import com.tenpay.android.wechat.MyKeyboardWindow;
import com.tenpay.android.wechat.TenpaySecureEditText;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public abstract class WalletBaseUI extends MMActivity implements h, f {
    private static q Aht = null;
    private static Set<String> Ahx = new HashSet();
    public static final int gnS = a.fromDPToPix(ah.getContext(), 270);
    private c Ahq = null;
    public i Ahr = null;
    private g Ahs = null;
    private OnMenuItemClickListener Ahu;
    protected WcPayKeyboard Ahv;
    public int Ahw = 0;
    public boolean Ahy = false;
    public boolean Ahz = false;
    public Bundle mBundle = new Bundle();
    public MyKeyboardWindow mKeyboard;
    private Dialog msu;
    public View nTi;
    protected a obM;
    private LinkedList<j> ocA = new LinkedList();
    private OnMenuItemClickListener yQu;

    public abstract boolean c(int i, int i2, String str, m mVar);

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public final String cNH() {
        if (this.mBundle == null) {
            return "";
        }
        PayInfo payInfo = (PayInfo) this.mBundle.getParcelable("key_pay_info");
        if (payInfo != null) {
            return payInfo.czZ;
        }
        return "";
    }

    public void bLz() {
        ab.d("MicroMsg.WalletBaseUI", "cancelforceScene");
        this.Ahr.bLz();
        finish();
    }

    public void onCreate(Bundle bundle) {
        String simpleName;
        if (cfN()) {
            simpleName = getClass().getSimpleName();
            if (Ahx.contains(simpleName)) {
                ab.w("MicroMsg.WalletBaseUI", "has contain lock key: %s", simpleName);
                finish();
            } else {
                Ahx.add(simpleName);
            }
        }
        super.onCreate(bundle);
        bht();
        if (!com.tencent.mm.kernel.g.RK()) {
            ab.e("MicroMsg.WalletBaseUI", "hy: account not ready. finish now");
            com.tencent.mm.ui.base.h.a((Context) this, getString(R.string.f81), "", false, new OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    AppMethodBeat.i(49241);
                    com.tencent.mm.wallet_core.a.b(WalletBaseUI.this, null, -10000);
                    AppMethodBeat.o(49241);
                }
            });
        }
        this.Ahr = new i(this, this);
        this.Ahr.nf(385);
        this.Ahr.nf(1518);
        ab.d("MicroMsg.WalletBaseUI", "current process:" + getIntent().getIntExtra("process_id", 0));
        c aE = com.tencent.mm.wallet_core.a.aE(this);
        if (aE != null) {
            this.Ahr.eHT = aE.bxP();
            aE.a(this);
        }
        ab.d("MicroMsg.WalletBaseUI", "proc ".concat(String.valueOf(aE)));
        this.mBundle = com.tencent.mm.wallet_core.a.aD((Activity) this);
        if (this.mBundle == null) {
            this.mBundle = new Bundle();
        }
        this.Ahr.mBundle = this.mBundle;
        if (bNf() && !com.tencent.mm.wallet_core.a.aC(this)) {
            ab.e("MicroMsg.WalletBaseUI", "Activity extends WalletBaseUI but not in process!!!");
        }
        if (getLayoutId() > 0) {
            simpleName = "";
            if (!bo.isNullOrNil(simpleName)) {
                setMMSubTitle(simpleName);
            }
        }
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(49244);
                WalletBaseUI.this.Ahw = 4;
                if (WalletBaseUI.this.cNR()) {
                    WalletBaseUI.this.aqX();
                    WalletBaseUI.this.showDialog(1000);
                } else {
                    WalletBaseUI.this.finish();
                }
                AppMethodBeat.o(49244);
                return true;
            }
        });
        this.Ahs = dOE();
        if (this.Ahs != null && this.Ahs.w(new Object[0])) {
            AM(4);
        } else if (getLayoutId() <= 0) {
            AM(4);
        } else if (bwP()) {
            AM(4);
        } else {
            AM(0);
        }
        dOI();
    }

    public void finish() {
        super.finish();
        this.Ahy = true;
    }

    public final void setBackBtn(OnMenuItemClickListener onMenuItemClickListener) {
        this.yQu = onMenuItemClickListener;
        super.setBackBtn(onMenuItemClickListener);
    }

    public final void addTextOptionMenu(int i, String str, OnMenuItemClickListener onMenuItemClickListener) {
        this.Ahu = onMenuItemClickListener;
        super.addTextOptionMenu(i, str, onMenuItemClickListener);
    }

    public final void a(String str, OnMenuItemClickListener onMenuItemClickListener, b bVar) {
        this.Ahu = onMenuItemClickListener;
        super.a(0, str, onMenuItemClickListener, bVar);
    }

    public void onResume() {
        super.onResume();
        if (w.dNQ()) {
            m bVar;
            if (r.YM()) {
                bVar = new com.tencent.mm.wallet_core.e.a.b();
            } else {
                bVar = new com.tencent.mm.wallet_core.tenpay.model.q();
            }
            this.Ahr.a(bVar, false);
        }
    }

    public void onPause() {
        super.onPause();
    }

    public void onDestroy() {
        super.onDestroy();
        this.Ahr.ng(385);
        this.Ahr.ng(1518);
        c dOD = dOD();
        if (dOD != null) {
            dOD.b(this);
        }
        Ahx.remove(getClass().getSimpleName());
        for (j onDestroy : (List) this.ocA.clone()) {
            onDestroy.onDestroy();
        }
        this.ocA.clear();
    }

    public void b(int i, int i2, String str, m mVar, boolean z) {
        ab.d("MicroMsg.WalletBaseUI", "errType = " + i + ", errCode = " + i2 + ", errMsg = " + str);
        TenpaySecureEditText.setSalt(w.dNR());
        if (mVar instanceof q) {
            q qVar = (q) mVar;
            Aht = qVar;
            if (this.mBundle != null) {
                if (qVar.tyd > 0) {
                    this.mBundle.putInt("key_is_gen_cert", qVar.tyd);
                }
                if (qVar.tyf > 0) {
                    this.mBundle.putInt("key_is_hint_crt", qVar.tyf);
                }
                if (qVar.tyh > 0) {
                    this.mBundle.putInt("key_is_ignore_cert", qVar.tyh);
                }
                if (!bo.isNullOrNil(qVar.tye)) {
                    this.mBundle.putString("key_crt_token", qVar.tye);
                }
                if (!bo.isNullOrNil(qVar.tyg)) {
                    this.mBundle.putString("key_crt_wording", qVar.tyg);
                }
            }
        }
        i(i, i2, str, mVar);
        f.a(this, i, i2, str, mVar, z);
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        dOE().onActivityResult(i, i2, intent);
        for (j dNL : (List) this.ocA.clone()) {
            dNL.dNL();
        }
    }

    public void wU(int i) {
    }

    public boolean i(int i, int i2, String str, m mVar) {
        return true;
    }

    public boolean bNf() {
        return true;
    }

    /* Access modifiers changed, original: protected */
    public boolean bwQ() {
        return false;
    }

    public boolean bwP() {
        if (getLayoutId() > 0 && !this.Ahr.bLA()) {
            return false;
        }
        return true;
    }

    public boolean cNR() {
        return false;
    }

    /* Access modifiers changed, original: protected|final */
    public final void dOy() {
        PayInfo payInfo = (PayInfo) this.mBundle.getParcelable("key_pay_info");
        if (payInfo == null) {
            payInfo = (PayInfo) getIntent().getParcelableExtra("key_pay_info");
        }
        if (payInfo != null && !bo.isNullOrNil(payInfo.eCq)) {
            this.Ahr.a(new l(payInfo.eCq, payInfo.czZ), true, 1);
            payInfo.eCq = null;
        }
    }

    /* Access modifiers changed, original: protected */
    public boolean aoE() {
        return true;
    }

    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (this.nTi != null && this.nTi.isShown()) {
                aoB();
                return true;
            } else if (cNR()) {
                aqX();
                showDialog(1000);
                return true;
            } else if (this.yQu != null && aoE()) {
                this.yQu.onMenuItemClick(null);
                return true;
            } else if (this.Ahu != null) {
                this.Ahu.onMenuItemClick(null);
                return true;
            }
        }
        return super.onKeyUp(i, keyEvent);
    }

    public final boolean apx() {
        if (this.yQu != null) {
            this.yQu.onMenuItemClick(null);
            return true;
        } else if (this.Ahu == null) {
            return super.apx();
        } else {
            this.Ahu.onMenuItemClick(null);
            return true;
        }
    }

    /* Access modifiers changed, original: protected */
    public Dialog onCreateDialog(int i) {
        ab.i("MicroMsg.WalletBaseUI", "onCreateDialog id = ".concat(String.valueOf(i)));
        switch (i) {
            case 1000:
                int a;
                c aE = com.tencent.mm.wallet_core.a.aE(this);
                if (aE != null) {
                    a = aE.a((MMActivity) this, 1);
                } else {
                    a = -1;
                }
                if (a != -1) {
                    return com.tencent.mm.ui.base.h.a((Context) this, true, getString(a), "", getString(R.string.up), getString(R.string.s2), new OnClickListener() {
                        public final void onClick(DialogInterface dialogInterface, int i) {
                            AppMethodBeat.i(49245);
                            WalletBaseUI.this.dOy();
                            c aE = com.tencent.mm.wallet_core.a.aE(WalletBaseUI.this);
                            WalletBaseUI.this.Ahw = 4;
                            if (aE == null) {
                                WalletBaseUI.this.finish();
                            } else if (!aE.h(WalletBaseUI.this, WalletBaseUI.this.mBundle)) {
                                aE.b(WalletBaseUI.this, WalletBaseUI.this.mBundle);
                                AppMethodBeat.o(49245);
                                return;
                            }
                            AppMethodBeat.o(49245);
                        }
                    }, new OnClickListener() {
                        public final void onClick(DialogInterface dialogInterface, int i) {
                            AppMethodBeat.i(49246);
                            View findFocus = WalletBaseUI.this.mController.contentView == null ? null : WalletBaseUI.this.mController.contentView.findFocus();
                            if (findFocus != null && (findFocus instanceof EditText)) {
                                WalletBaseUI.this.showVKB();
                            }
                            AppMethodBeat.o(49246);
                        }
                    });
                }
                if (aE != null) {
                    aE.b(this, this.mBundle);
                } else {
                    this.Ahw = 4;
                    finish();
                }
                return super.onCreateDialog(i);
            default:
                return super.onCreateDialog(i);
        }
    }

    /* Access modifiers changed, original: protected|final */
    public final void e(View view, int i, boolean z) {
        a(view, i, z, true);
    }

    /* Access modifiers changed, original: protected|final */
    public final void e(final EditText editText) {
        this.Ahv = (WcPayKeyboard) findViewById(R.id.fjg);
        if (this.Ahv != null && editText != null) {
            e.setNoSystemInputOnEditText(editText);
            editText.setOnFocusChangeListener(new OnFocusChangeListener() {
                final /* synthetic */ OnFocusChangeListener AhB;
                final /* synthetic */ boolean gnU = false;
                private boolean ohP;

                public final void onFocusChange(final View view, boolean z) {
                    AppMethodBeat.i(49249);
                    if (z) {
                        ((InputMethodManager) WalletBaseUI.this.mController.ylL.getSystemService("input_method")).hideSoftInputFromWindow(view.getWindowToken(), 0);
                        new ak().postDelayed(new Runnable() {
                            public final void run() {
                                AppMethodBeat.i(49247);
                                if (!WalletBaseUI.this.Ahv.isShown() && view.isShown()) {
                                    if (AnonymousClass9.this.gnU || !AnonymousClass9.this.ohP) {
                                        WalletBaseUI.this.dOA();
                                    }
                                    AnonymousClass9.this.ohP = false;
                                }
                                WalletBaseUI.this.Ahv.setInputEditText(editText);
                                ((InputMethodManager) WalletBaseUI.this.mController.ylL.getSystemService("input_method")).hideSoftInputFromWindow(view.getWindowToken(), 0);
                                AppMethodBeat.o(49247);
                            }
                        }, 300);
                    } else {
                        new ak().postDelayed(new Runnable() {
                            public final void run() {
                                AppMethodBeat.i(49248);
                                WalletBaseUI.this.dOz();
                                AppMethodBeat.o(49248);
                            }
                        }, 200);
                    }
                    if (this.AhB != null) {
                        this.AhB.onFocusChange(view, z);
                    }
                    AppMethodBeat.o(49249);
                }
            });
            editText.setOnClickListener(new View.OnClickListener() {
                public final void onClick(View view) {
                    AppMethodBeat.i(49250);
                    WalletBaseUI.this.dOA();
                    AppMethodBeat.o(49250);
                }
            });
        }
    }

    public final void dOz() {
        if (this.Ahv != null && this.Ahv.isShown()) {
            this.Ahv.setVisibility(8);
            if (this.obM != null) {
                this.obM.ic(false);
            }
        }
    }

    public final void dOA() {
        if (this.Ahv != null && !this.Ahv.isShown()) {
            this.Ahv.setVisibility(0);
            if (this.obM != null) {
                this.obM.ic(true);
            }
        }
    }

    /* Access modifiers changed, original: protected */
    public void a(View view, int i, boolean z, boolean z2) {
        a(view, i, z, true, z2);
    }

    /* Access modifiers changed, original: protected|final */
    @TargetApi(14)
    public final void a(View view, int i, boolean z, boolean z2, boolean z3) {
        a(view, null, i, z, z2, z3);
    }

    /* Access modifiers changed, original: protected|final */
    public final void a(View view, EditText editText, final int i, final boolean z, boolean z2, boolean z3) {
        EditText editText2;
        this.mKeyboard = (MyKeyboardWindow) findViewById(R.id.akz);
        this.nTi = findViewById(R.id.aky);
        View findViewById = findViewById(R.id.al0);
        if (editText == null) {
            editText2 = (EditText) view.findViewById(R.id.d6);
        } else {
            editText2 = editText;
        }
        if (this.mKeyboard != null && editText2 != null && this.nTi != null) {
            OnFocusChangeListener onFocusChangeListener = null;
            if (z3) {
                onFocusChangeListener = editText2.getOnFocusChangeListener();
            }
            e.setNoSystemInputOnEditText(editText2);
            final boolean z4 = z;
            final boolean z5 = z2;
            final View view2 = view;
            final int i2 = i;
            editText2.setOnFocusChangeListener(new OnFocusChangeListener() {
                public final void onFocusChange(final View view, boolean z) {
                    AppMethodBeat.i(49253);
                    if (!view.isFocused() || z4) {
                        new ak().postDelayed(new Runnable() {
                            public final void run() {
                                AppMethodBeat.i(49252);
                                WalletBaseUI.this.aoB();
                                if (z4) {
                                    ((InputMethodManager) WalletBaseUI.this.mController.ylL.getSystemService("input_method")).showSoftInput(editText2, 0);
                                }
                                AppMethodBeat.o(49252);
                            }
                        }, 200);
                    } else {
                        ((InputMethodManager) WalletBaseUI.this.mController.ylL.getSystemService("input_method")).hideSoftInputFromWindow(view.getWindowToken(), 0);
                        new ak().postDelayed(new Runnable() {
                            public final void run() {
                                com.tencent.mm.ui.a.c cVar;
                                AppMethodBeat.i(49251);
                                if (!WalletBaseUI.this.nTi.isShown() && view.isShown() && (z5 || WalletBaseUI.this.Ahz)) {
                                    WalletBaseUI.this.Ahz = true;
                                    WalletBaseUI.this.dOC();
                                }
                                if ((view2 instanceof WalletFormView) && VERSION.SDK_INT >= 14) {
                                    WalletFormView walletFormView = (WalletFormView) view2;
                                    if ((r.YM() || walletFormView.getEncrptType() == 100) && (!r.YM() || walletFormView.getEncrptType() == 0)) {
                                        WalletBaseUI.this.mKeyboard.resetSecureAccessibility();
                                        editText2.setAccessibilityDelegate(null);
                                    } else {
                                        cVar = new com.tencent.mm.ui.a.c();
                                        WalletBaseUI.this.mKeyboard.setSecureAccessibility(cVar);
                                        editText2.setAccessibilityDelegate(cVar);
                                    }
                                }
                                if ((view2 instanceof EditHintPasswdView) && VERSION.SDK_INT >= 14) {
                                    cVar = new com.tencent.mm.ui.a.c();
                                    WalletBaseUI.this.mKeyboard.setSecureAccessibility(cVar);
                                    editText2.setAccessibilityDelegate(cVar);
                                }
                                WalletBaseUI.this.QP(i2);
                                WalletBaseUI.this.mKeyboard.setInputEditText((EditText) view);
                                ((InputMethodManager) WalletBaseUI.this.mController.ylL.getSystemService("input_method")).hideSoftInputFromWindow(view.getWindowToken(), 0);
                                AppMethodBeat.o(49251);
                            }
                        }, 300);
                    }
                    if (onFocusChangeListener != null) {
                        onFocusChangeListener.onFocusChange(view, z);
                    }
                    AppMethodBeat.o(49253);
                }
            });
            editText2.setOnClickListener(new View.OnClickListener() {
                public final void onClick(View view) {
                    AppMethodBeat.i(49254);
                    if (WalletBaseUI.this.nTi.isShown() || z) {
                        if (z) {
                            WalletBaseUI.this.aoB();
                            ((InputMethodManager) WalletBaseUI.this.mController.ylL.getSystemService("input_method")).showSoftInput(editText2, 0);
                        }
                        AppMethodBeat.o(49254);
                        return;
                    }
                    WalletBaseUI.this.dOC();
                    WalletBaseUI.this.QP(i);
                    AppMethodBeat.o(49254);
                }
            });
            findViewById.setOnClickListener(new View.OnClickListener() {
                public final void onClick(View view) {
                    AppMethodBeat.i(49255);
                    WalletBaseUI.this.aoB();
                    AppMethodBeat.o(49255);
                }
            });
        }
    }

    public final boolean rl(boolean z) {
        if (Aht == null || (!Aht.bXl() && !z)) {
            return false;
        }
        this.Ahr.a(Aht, true);
        return true;
    }

    public static void dOB() {
        f.dOB();
    }

    public void aoB() {
        if (this.nTi != null && this.nTi.isShown()) {
            this.nTi.setVisibility(8);
            if (this.obM != null) {
                this.obM.ic(false);
            }
        }
    }

    public final void dOC() {
        if (this.nTi != null && !this.nTi.isShown()) {
            this.nTi.setVisibility(0);
            if (this.obM != null) {
                this.obM.ic(true);
            }
        }
    }

    public final void QP(int i) {
        this.mKeyboard.setXMode(i);
    }

    public final c dOD() {
        if (this.Ahq == null) {
            this.Ahq = com.tencent.mm.wallet_core.a.aE(this);
        }
        return this.Ahq;
    }

    public final g dOE() {
        if (this.Ahs == null) {
            c dOD = dOD();
            if (dOD != null) {
                this.Ahs = dOD.a((MMActivity) this, this.Ahr);
            }
            if (this.Ahs == null) {
                this.Ahs = new g(this, this.Ahr) {
                    public final boolean c(int i, int i2, String str, m mVar) {
                        return false;
                    }

                    public final boolean p(Object... objArr) {
                        return false;
                    }
                };
            }
        }
        return this.Ahs;
    }

    public final CharSequence dOF() {
        if (this.Ahs == null) {
            return null;
        }
        return this.Ahs.Au(0);
    }

    public void dY() {
        dOD().a((Activity) this, 0, this.mBundle);
    }

    public final void nf(int i) {
        this.Ahr.nf(i);
    }

    public final void ng(int i) {
        this.Ahr.ng(i);
    }

    public final void a(m mVar, boolean z, boolean z2) {
        a(mVar, z, z2, 0);
    }

    public final void a(m mVar, boolean z, boolean z2, int i) {
        dOH();
        int i2 = 1;
        if (!z2) {
            i2 = 2;
        }
        this.Ahr.a(mVar, z, i2, i);
    }

    public final void dOG() {
        if (this.msu == null || !(this.msu == null || this.msu.isShowing())) {
            if (this.msu != null) {
                this.msu.dismiss();
            }
            this.msu = g.a((Context) this, false, new OnCancelListener() {
                public final void onCancel(DialogInterface dialogInterface) {
                    AppMethodBeat.i(49242);
                    WalletBaseUI.this.bLz();
                    AppMethodBeat.o(49242);
                }
            });
        }
    }

    public final void bgk() {
        if (this.msu != null) {
            this.msu.dismiss();
        }
    }

    public final void bgj() {
        if (this.msu == null || !(this.msu == null || this.msu.isShowing())) {
            if (this.msu != null) {
                this.msu.dismiss();
            }
            this.msu = g.b(this, false, new OnCancelListener() {
                public final void onCancel(DialogInterface dialogInterface) {
                }
            });
        }
    }

    private void dOH() {
        c dOD = dOD();
        if (dOD != null) {
            this.Ahr.mBundle = dOD.mqu;
        }
    }

    public void AM(int i) {
        super.AM(i);
    }

    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        if (intent.getBooleanExtra("key_process_is_end", false) && !intent.getBooleanExtra("key_process_is_stay", true)) {
            setIntent(intent);
            Bundle extras = getIntent().getExtras();
            int i = (extras == null || !extras.containsKey("key_process_result_code")) ? 0 : extras.getInt("key_process_result_code", 0);
            if (i == -1) {
                ab.i("MicroMsg.WalletBaseUI", "process end ok!");
                setResult(-1, getIntent());
            } else {
                ab.i("MicroMsg.WalletBaseUI", "process end with user cancel or err! resultCode : ".concat(String.valueOf(i)));
                setResult(0, getIntent());
            }
            finish();
        }
    }

    public final void b(final View view, View view2, int i) {
        if (view != null) {
            final int i2;
            int[] iArr = new int[2];
            view2.getLocationInWindow(iArr);
            int ge = (a.ge(this) - i2) - a.fromDPToPix(this, i);
            ab.d("MicroMsg.WalletBaseUI", "scrollToFormEditPosAfterShowTenPay, editText locationY: %s, height: %s, diff: %s, hardcodeKeyboardHeight: %s", Integer.valueOf(iArr[1] + view2.getHeight()), Integer.valueOf(a.ge(this)), Integer.valueOf(ge), Integer.valueOf(gnS));
            if (ge > 0 && ge < gnS) {
                i2 = gnS - ge;
                ab.d("MicroMsg.WalletBaseUI", "scrollToFormEditPosAfterShowTenPay, scrollDistance: %s", Integer.valueOf(i2));
                view.post(new Runnable() {
                    public final void run() {
                        AppMethodBeat.i(49243);
                        view.scrollBy(0, i2);
                        AppMethodBeat.o(49243);
                    }
                });
            }
        }
    }

    /* Access modifiers changed, original: protected */
    public boolean cfN() {
        return false;
    }

    public final void a(j jVar) {
        if (!this.ocA.contains(jVar)) {
            this.ocA.add(jVar);
        }
    }

    private void dOI() {
        Iterator it = ((List) this.ocA.clone()).iterator();
        while (it.hasNext()) {
            it.next();
        }
    }

    /* Access modifiers changed, original: protected */
    public void bht() {
        xE(this.mController.dyj());
    }
}
