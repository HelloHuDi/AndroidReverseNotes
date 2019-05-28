package com.tencent.p177mm.wallet_core.p650ui;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C1853r;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p208bz.C1338a;
import com.tencent.p177mm.p612ui.C5536q.C5535b;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.p612ui.p613a.C5218c;
import com.tencent.p177mm.pluginsdk.wallet.PayInfo;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C7306ak;
import com.tencent.p177mm.wallet_core.C24143a;
import com.tencent.p177mm.wallet_core.C40931c;
import com.tencent.p177mm.wallet_core.keyboard.WcPayKeyboard;
import com.tencent.p177mm.wallet_core.p1512e.p1513a.C36884b;
import com.tencent.p177mm.wallet_core.p649c.C24154l;
import com.tencent.p177mm.wallet_core.p649c.C30862w;
import com.tencent.p177mm.wallet_core.p649c.C44425h;
import com.tencent.p177mm.wallet_core.p649c.C44427j;
import com.tencent.p177mm.wallet_core.p649c.C44430q;
import com.tencent.p177mm.wallet_core.p650ui.formview.EditHintPasswdView;
import com.tencent.p177mm.wallet_core.p650ui.formview.WalletFormView;
import com.tencent.p177mm.wallet_core.p760d.C30868i;
import com.tencent.p177mm.wallet_core.p760d.C40932f;
import com.tencent.p177mm.wallet_core.p760d.C44432g;
import com.tencent.p177mm.wallet_core.tenpay.model.C40944q;
import com.tenpay.android.wechat.MyKeyboardWindow;
import com.tenpay.android.wechat.TenpaySecureEditText;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/* renamed from: com.tencent.mm.wallet_core.ui.WalletBaseUI */
public abstract class WalletBaseUI extends MMActivity implements C44425h, C40932f {
    private static C44430q Aht = null;
    private static Set<String> Ahx = new HashSet();
    public static final int gnS = C1338a.fromDPToPix(C4996ah.getContext(), 270);
    private C40931c Ahq = null;
    public C30868i Ahr = null;
    private C44432g Ahs = null;
    private OnMenuItemClickListener Ahu;
    protected WcPayKeyboard Ahv;
    public int Ahw = 0;
    public boolean Ahy = false;
    public boolean Ahz = false;
    public Bundle mBundle = new Bundle();
    public MyKeyboardWindow mKeyboard;
    private Dialog msu;
    public View nTi;
    protected C40947a obM;
    private LinkedList<C44427j> ocA = new LinkedList();
    private OnMenuItemClickListener yQu;

    /* renamed from: com.tencent.mm.wallet_core.ui.WalletBaseUI$6 */
    class C160966 implements OnMenuItemClickListener {
        C160966() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(49244);
            WalletBaseUI.this.Ahw = 4;
            if (WalletBaseUI.this.cNR()) {
                WalletBaseUI.this.aqX();
                WalletBaseUI.this.showDialog(1000);
            } else {
                WalletBaseUI.this.finish();
            }
            AppMethodBeat.m2505o(49244);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.wallet_core.ui.WalletBaseUI$13 */
    class C2416513 implements OnClickListener {
        C2416513() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(49255);
            WalletBaseUI.this.aoB();
            AppMethodBeat.m2505o(49255);
        }
    }

    /* renamed from: com.tencent.mm.wallet_core.ui.WalletBaseUI$8 */
    class C241668 implements DialogInterface.OnClickListener {
        C241668() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(49246);
            View findFocus = WalletBaseUI.this.mController.contentView == null ? null : WalletBaseUI.this.mController.contentView.findFocus();
            if (findFocus != null && (findFocus instanceof EditText)) {
                WalletBaseUI.this.showVKB();
            }
            AppMethodBeat.m2505o(49246);
        }
    }

    /* renamed from: com.tencent.mm.wallet_core.ui.WalletBaseUI$10 */
    class C2416710 implements OnClickListener {
        C2416710() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(49250);
            WalletBaseUI.this.dOA();
            AppMethodBeat.m2505o(49250);
        }
    }

    /* renamed from: com.tencent.mm.wallet_core.ui.WalletBaseUI$7 */
    class C241697 implements DialogInterface.OnClickListener {
        C241697() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(49245);
            WalletBaseUI.this.dOy();
            C40931c aE = C24143a.m37112aE(WalletBaseUI.this);
            WalletBaseUI.this.Ahw = 4;
            if (aE == null) {
                WalletBaseUI.this.finish();
            } else if (!aE.mo38264h(WalletBaseUI.this, WalletBaseUI.this.mBundle)) {
                aE.mo8125b(WalletBaseUI.this, WalletBaseUI.this.mBundle);
                AppMethodBeat.m2505o(49245);
                return;
            }
            AppMethodBeat.m2505o(49245);
        }
    }

    /* renamed from: com.tencent.mm.wallet_core.ui.WalletBaseUI$1 */
    class C241721 implements DialogInterface.OnClickListener {
        C241721() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(49241);
            C24143a.m37113b(WalletBaseUI.this, null, -10000);
            AppMethodBeat.m2505o(49241);
        }
    }

    /* renamed from: com.tencent.mm.wallet_core.ui.WalletBaseUI$3 */
    class C241733 implements OnCancelListener {
        C241733() {
        }

        public final void onCancel(DialogInterface dialogInterface) {
            AppMethodBeat.m2504i(49242);
            WalletBaseUI.this.bLz();
            AppMethodBeat.m2505o(49242);
        }
    }

    /* renamed from: com.tencent.mm.wallet_core.ui.WalletBaseUI$4 */
    class C241744 implements OnCancelListener {
        C241744() {
        }

        public final void onCancel(DialogInterface dialogInterface) {
        }
    }

    /* renamed from: c */
    public abstract boolean mo7885c(int i, int i2, String str, C1207m c1207m);

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
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
        C4990ab.m7410d("MicroMsg.WalletBaseUI", "cancelforceScene");
        this.Ahr.bLz();
        finish();
    }

    public void onCreate(Bundle bundle) {
        String simpleName;
        if (cfN()) {
            simpleName = getClass().getSimpleName();
            if (Ahx.contains(simpleName)) {
                C4990ab.m7421w("MicroMsg.WalletBaseUI", "has contain lock key: %s", simpleName);
                finish();
            } else {
                Ahx.add(simpleName);
            }
        }
        super.onCreate(bundle);
        bht();
        if (!C1720g.m3531RK()) {
            C4990ab.m7412e("MicroMsg.WalletBaseUI", "hy: account not ready. finish now");
            C30379h.m48448a((Context) this, getString(C25738R.string.f81), "", false, new C241721());
        }
        this.Ahr = new C30868i(this, this);
        this.Ahr.mo49372nf(385);
        this.Ahr.mo49372nf(1518);
        C4990ab.m7410d("MicroMsg.WalletBaseUI", "current process:" + getIntent().getIntExtra("process_id", 0));
        C40931c aE = C24143a.m37112aE(this);
        if (aE != null) {
            this.Ahr.eHT = aE.bxP();
            aE.mo26469a(this);
        }
        C4990ab.m7410d("MicroMsg.WalletBaseUI", "proc ".concat(String.valueOf(aE)));
        this.mBundle = C24143a.m37110aD((Activity) this);
        if (this.mBundle == null) {
            this.mBundle = new Bundle();
        }
        this.Ahr.mBundle = this.mBundle;
        if (bNf() && !C24143a.m37109aC(this)) {
            C4990ab.m7412e("MicroMsg.WalletBaseUI", "Activity extends WalletBaseUI but not in process!!!");
        }
        if (getLayoutId() > 0) {
            simpleName = "";
            if (!C5046bo.isNullOrNil(simpleName)) {
                setMMSubTitle(simpleName);
            }
        }
        setBackBtn(new C160966());
        this.Ahs = dOE();
        if (this.Ahs != null && this.Ahs.mo9367w(new Object[0])) {
            mo9439AM(4);
        } else if (getLayoutId() <= 0) {
            mo9439AM(4);
        } else if (bwP()) {
            mo9439AM(4);
        } else {
            mo9439AM(0);
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

    /* renamed from: a */
    public final void mo39972a(String str, OnMenuItemClickListener onMenuItemClickListener, C5535b c5535b) {
        this.Ahu = onMenuItemClickListener;
        super.mo17379a(0, str, onMenuItemClickListener, c5535b);
    }

    public void onResume() {
        super.onResume();
        if (C30862w.dNQ()) {
            C1207m c36884b;
            if (C1853r.m3831YM()) {
                c36884b = new C36884b();
            } else {
                c36884b = new C40944q();
            }
            this.Ahr.mo36581a(c36884b, false);
        }
    }

    public void onPause() {
        super.onPause();
    }

    public void onDestroy() {
        super.onDestroy();
        this.Ahr.mo49373ng(385);
        this.Ahr.mo49373ng(1518);
        C40931c dOD = dOD();
        if (dOD != null) {
            dOD.mo26471b(this);
        }
        Ahx.remove(getClass().getSimpleName());
        for (C44427j onDestroy : (List) this.ocA.clone()) {
            onDestroy.onDestroy();
        }
        this.ocA.clear();
    }

    /* renamed from: b */
    public void mo24300b(int i, int i2, String str, C1207m c1207m, boolean z) {
        C4990ab.m7410d("MicroMsg.WalletBaseUI", "errType = " + i + ", errCode = " + i2 + ", errMsg = " + str);
        TenpaySecureEditText.setSalt(C30862w.dNR());
        if (c1207m instanceof C44430q) {
            C44430q c44430q = (C44430q) c1207m;
            Aht = c44430q;
            if (this.mBundle != null) {
                if (c44430q.tyd > 0) {
                    this.mBundle.putInt("key_is_gen_cert", c44430q.tyd);
                }
                if (c44430q.tyf > 0) {
                    this.mBundle.putInt("key_is_hint_crt", c44430q.tyf);
                }
                if (c44430q.tyh > 0) {
                    this.mBundle.putInt("key_is_ignore_cert", c44430q.tyh);
                }
                if (!C5046bo.isNullOrNil(c44430q.tye)) {
                    this.mBundle.putString("key_crt_token", c44430q.tye);
                }
                if (!C5046bo.isNullOrNil(c44430q.tyg)) {
                    this.mBundle.putString("key_crt_wording", c44430q.tyg);
                }
            }
        }
        mo39991i(i, i2, str, c1207m);
        C16100f.m24406a(this, i, i2, str, c1207m, z);
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        dOE().onActivityResult(i, i2, intent);
        for (C44427j dNL : (List) this.ocA.clone()) {
            dNL.dNL();
        }
    }

    /* renamed from: wU */
    public void mo8137wU(int i) {
    }

    /* renamed from: i */
    public boolean mo39991i(int i, int i2, String str, C1207m c1207m) {
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
        if (payInfo != null && !C5046bo.isNullOrNil(payInfo.eCq)) {
            this.Ahr.mo49367a(new C24154l(payInfo.eCq, payInfo.czZ), true, 1);
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
        C4990ab.m7416i("MicroMsg.WalletBaseUI", "onCreateDialog id = ".concat(String.valueOf(i)));
        switch (i) {
            case 1000:
                int a;
                C40931c aE = C24143a.m37112aE(this);
                if (aE != null) {
                    a = aE.mo26468a((MMActivity) this, 1);
                } else {
                    a = -1;
                }
                if (a != -1) {
                    return C30379h.m48453a((Context) this, true, getString(a), "", getString(C25738R.string.f9262up), getString(C25738R.string.f9183s2), new C241697(), new C241668());
                }
                if (aE != null) {
                    aE.mo8125b(this, this.mBundle);
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
    /* renamed from: e */
    public final void mo39989e(View view, int i, boolean z) {
        mo21157a(view, i, z, true);
    }

    /* Access modifiers changed, original: protected|final */
    /* renamed from: e */
    public final void mo39990e(final EditText editText) {
        this.Ahv = (WcPayKeyboard) findViewById(2131829144);
        if (this.Ahv != null && editText != null) {
            C36391e.setNoSystemInputOnEditText(editText);
            editText.setOnFocusChangeListener(new OnFocusChangeListener() {
                final /* synthetic */ OnFocusChangeListener AhB;
                final /* synthetic */ boolean gnU = false;
                private boolean ohP;

                /* renamed from: com.tencent.mm.wallet_core.ui.WalletBaseUI$9$2 */
                class C160972 implements Runnable {
                    C160972() {
                    }

                    public final void run() {
                        AppMethodBeat.m2504i(49248);
                        WalletBaseUI.this.dOz();
                        AppMethodBeat.m2505o(49248);
                    }
                }

                public final void onFocusChange(final View view, boolean z) {
                    AppMethodBeat.m2504i(49249);
                    if (z) {
                        ((InputMethodManager) WalletBaseUI.this.mController.ylL.getSystemService("input_method")).hideSoftInputFromWindow(view.getWindowToken(), 0);
                        new C7306ak().postDelayed(new Runnable() {
                            public final void run() {
                                AppMethodBeat.m2504i(49247);
                                if (!WalletBaseUI.this.Ahv.isShown() && view.isShown()) {
                                    if (C241709.this.gnU || !C241709.this.ohP) {
                                        WalletBaseUI.this.dOA();
                                    }
                                    C241709.this.ohP = false;
                                }
                                WalletBaseUI.this.Ahv.setInputEditText(editText);
                                ((InputMethodManager) WalletBaseUI.this.mController.ylL.getSystemService("input_method")).hideSoftInputFromWindow(view.getWindowToken(), 0);
                                AppMethodBeat.m2505o(49247);
                            }
                        }, 300);
                    } else {
                        new C7306ak().postDelayed(new C160972(), 200);
                    }
                    if (this.AhB != null) {
                        this.AhB.onFocusChange(view, z);
                    }
                    AppMethodBeat.m2505o(49249);
                }
            });
            editText.setOnClickListener(new C2416710());
        }
    }

    public final void dOz() {
        if (this.Ahv != null && this.Ahv.isShown()) {
            this.Ahv.setVisibility(8);
            if (this.obM != null) {
                this.obM.mo9448ic(false);
            }
        }
    }

    public final void dOA() {
        if (this.Ahv != null && !this.Ahv.isShown()) {
            this.Ahv.setVisibility(0);
            if (this.obM != null) {
                this.obM.mo9448ic(true);
            }
        }
    }

    /* Access modifiers changed, original: protected */
    /* renamed from: a */
    public void mo21157a(View view, int i, boolean z, boolean z2) {
        mo39968a(view, i, z, true, z2);
    }

    /* Access modifiers changed, original: protected|final */
    @TargetApi(14)
    /* renamed from: a */
    public final void mo39968a(View view, int i, boolean z, boolean z2, boolean z3) {
        mo39969a(view, null, i, z, z2, z3);
    }

    /* Access modifiers changed, original: protected|final */
    /* renamed from: a */
    public final void mo39969a(View view, EditText editText, final int i, final boolean z, boolean z2, boolean z3) {
        EditText editText2;
        this.mKeyboard = (MyKeyboardWindow) findViewById(2131822357);
        this.nTi = findViewById(2131822356);
        View findViewById = findViewById(2131822358);
        if (editText == null) {
            editText2 = (EditText) view.findViewById(2131820687);
        } else {
            editText2 = editText;
        }
        if (this.mKeyboard != null && editText2 != null && this.nTi != null) {
            OnFocusChangeListener onFocusChangeListener = null;
            if (z3) {
                onFocusChangeListener = editText2.getOnFocusChangeListener();
            }
            C36391e.setNoSystemInputOnEditText(editText2);
            final boolean z4 = z;
            final boolean z5 = z2;
            final View view2 = view;
            final int i2 = i;
            editText2.setOnFocusChangeListener(new OnFocusChangeListener() {

                /* renamed from: com.tencent.mm.wallet_core.ui.WalletBaseUI$11$2 */
                class C241642 implements Runnable {
                    C241642() {
                    }

                    public final void run() {
                        AppMethodBeat.m2504i(49252);
                        WalletBaseUI.this.aoB();
                        if (z4) {
                            ((InputMethodManager) WalletBaseUI.this.mController.ylL.getSystemService("input_method")).showSoftInput(editText2, 0);
                        }
                        AppMethodBeat.m2505o(49252);
                    }
                }

                public final void onFocusChange(final View view, boolean z) {
                    AppMethodBeat.m2504i(49253);
                    if (!view.isFocused() || z4) {
                        new C7306ak().postDelayed(new C241642(), 200);
                    } else {
                        ((InputMethodManager) WalletBaseUI.this.mController.ylL.getSystemService("input_method")).hideSoftInputFromWindow(view.getWindowToken(), 0);
                        new C7306ak().postDelayed(new Runnable() {
                            public final void run() {
                                C5218c c5218c;
                                AppMethodBeat.m2504i(49251);
                                if (!WalletBaseUI.this.nTi.isShown() && view.isShown() && (z5 || WalletBaseUI.this.Ahz)) {
                                    WalletBaseUI.this.Ahz = true;
                                    WalletBaseUI.this.dOC();
                                }
                                if ((view2 instanceof WalletFormView) && VERSION.SDK_INT >= 14) {
                                    WalletFormView walletFormView = (WalletFormView) view2;
                                    if ((C1853r.m3831YM() || walletFormView.getEncrptType() == 100) && (!C1853r.m3831YM() || walletFormView.getEncrptType() == 0)) {
                                        WalletBaseUI.this.mKeyboard.resetSecureAccessibility();
                                        editText2.setAccessibilityDelegate(null);
                                    } else {
                                        c5218c = new C5218c();
                                        WalletBaseUI.this.mKeyboard.setSecureAccessibility(c5218c);
                                        editText2.setAccessibilityDelegate(c5218c);
                                    }
                                }
                                if ((view2 instanceof EditHintPasswdView) && VERSION.SDK_INT >= 14) {
                                    c5218c = new C5218c();
                                    WalletBaseUI.this.mKeyboard.setSecureAccessibility(c5218c);
                                    editText2.setAccessibilityDelegate(c5218c);
                                }
                                WalletBaseUI.this.mo39967QP(i2);
                                WalletBaseUI.this.mKeyboard.setInputEditText((EditText) view);
                                ((InputMethodManager) WalletBaseUI.this.mController.ylL.getSystemService("input_method")).hideSoftInputFromWindow(view.getWindowToken(), 0);
                                AppMethodBeat.m2505o(49251);
                            }
                        }, 300);
                    }
                    if (onFocusChangeListener != null) {
                        onFocusChangeListener.onFocusChange(view, z);
                    }
                    AppMethodBeat.m2505o(49253);
                }
            });
            editText2.setOnClickListener(new OnClickListener() {
                public final void onClick(View view) {
                    AppMethodBeat.m2504i(49254);
                    if (WalletBaseUI.this.nTi.isShown() || z) {
                        if (z) {
                            WalletBaseUI.this.aoB();
                            ((InputMethodManager) WalletBaseUI.this.mController.ylL.getSystemService("input_method")).showSoftInput(editText2, 0);
                        }
                        AppMethodBeat.m2505o(49254);
                        return;
                    }
                    WalletBaseUI.this.dOC();
                    WalletBaseUI.this.mo39967QP(i);
                    AppMethodBeat.m2505o(49254);
                }
            });
            findViewById.setOnClickListener(new C2416513());
        }
    }

    /* renamed from: rl */
    public final boolean mo39994rl(boolean z) {
        if (Aht == null || (!Aht.bXl() && !z)) {
            return false;
        }
        this.Ahr.mo36581a(Aht, true);
        return true;
    }

    public static void dOB() {
        C16100f.dOB();
    }

    public void aoB() {
        if (this.nTi != null && this.nTi.isShown()) {
            this.nTi.setVisibility(8);
            if (this.obM != null) {
                this.obM.mo9448ic(false);
            }
        }
    }

    public final void dOC() {
        if (this.nTi != null && !this.nTi.isShown()) {
            this.nTi.setVisibility(0);
            if (this.obM != null) {
                this.obM.mo9448ic(true);
            }
        }
    }

    /* renamed from: QP */
    public final void mo39967QP(int i) {
        this.mKeyboard.setXMode(i);
    }

    public final C40931c dOD() {
        if (this.Ahq == null) {
            this.Ahq = C24143a.m37112aE(this);
        }
        return this.Ahq;
    }

    public final C44432g dOE() {
        if (this.Ahs == null) {
            C40931c dOD = dOD();
            if (dOD != null) {
                this.Ahs = dOD.mo24745a((MMActivity) this, this.Ahr);
            }
            if (this.Ahs == null) {
                this.Ahs = new C44432g(this, this.Ahr) {
                    /* renamed from: c */
                    public final boolean mo9365c(int i, int i2, String str, C1207m c1207m) {
                        return false;
                    }

                    /* renamed from: p */
                    public final boolean mo9366p(Object... objArr) {
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
        return this.Ahs.mo9364Au(0);
    }

    /* renamed from: dY */
    public void mo39988dY() {
        dOD().mo8124a((Activity) this, 0, this.mBundle);
    }

    /* renamed from: nf */
    public final void mo39992nf(int i) {
        this.Ahr.mo49372nf(i);
    }

    /* renamed from: ng */
    public final void mo39993ng(int i) {
        this.Ahr.mo49373ng(i);
    }

    /* renamed from: a */
    public final void mo39970a(C1207m c1207m, boolean z, boolean z2) {
        mo39971a(c1207m, z, z2, 0);
    }

    /* renamed from: a */
    public final void mo39971a(C1207m c1207m, boolean z, boolean z2, int i) {
        dOH();
        int i2 = 1;
        if (!z2) {
            i2 = 2;
        }
        this.Ahr.mo49368a(c1207m, z, i2, i);
    }

    public final void dOG() {
        if (this.msu == null || !(this.msu == null || this.msu.isShowing())) {
            if (this.msu != null) {
                this.msu.dismiss();
            }
            this.msu = C30901g.m49317a((Context) this, false, new C241733());
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
            this.msu = C30901g.m49318b(this, false, new C241744());
        }
    }

    private void dOH() {
        C40931c dOD = dOD();
        if (dOD != null) {
            this.Ahr.mBundle = dOD.mqu;
        }
    }

    /* renamed from: AM */
    public void mo9439AM(int i) {
        super.mo9439AM(i);
    }

    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        if (intent.getBooleanExtra("key_process_is_end", false) && !intent.getBooleanExtra("key_process_is_stay", true)) {
            setIntent(intent);
            Bundle extras = getIntent().getExtras();
            int i = (extras == null || !extras.containsKey("key_process_result_code")) ? 0 : extras.getInt("key_process_result_code", 0);
            if (i == -1) {
                C4990ab.m7416i("MicroMsg.WalletBaseUI", "process end ok!");
                setResult(-1, getIntent());
            } else {
                C4990ab.m7416i("MicroMsg.WalletBaseUI", "process end with user cancel or err! resultCode : ".concat(String.valueOf(i)));
                setResult(0, getIntent());
            }
            finish();
        }
    }

    /* renamed from: b */
    public final void mo39974b(final View view, View view2, int i) {
        if (view != null) {
            final int i2;
            int[] iArr = new int[2];
            view2.getLocationInWindow(iArr);
            int ge = (C1338a.m2869ge(this) - i2) - C1338a.fromDPToPix(this, i);
            C4990ab.m7411d("MicroMsg.WalletBaseUI", "scrollToFormEditPosAfterShowTenPay, editText locationY: %s, height: %s, diff: %s, hardcodeKeyboardHeight: %s", Integer.valueOf(iArr[1] + view2.getHeight()), Integer.valueOf(C1338a.m2869ge(this)), Integer.valueOf(ge), Integer.valueOf(gnS));
            if (ge > 0 && ge < gnS) {
                i2 = gnS - ge;
                C4990ab.m7411d("MicroMsg.WalletBaseUI", "scrollToFormEditPosAfterShowTenPay, scrollDistance: %s", Integer.valueOf(i2));
                view.post(new Runnable() {
                    public final void run() {
                        AppMethodBeat.m2504i(49243);
                        view.scrollBy(0, i2);
                        AppMethodBeat.m2505o(49243);
                    }
                });
            }
        }
    }

    /* Access modifiers changed, original: protected */
    public boolean cfN() {
        return false;
    }

    /* renamed from: a */
    public final void mo24299a(C44427j c44427j) {
        if (!this.ocA.contains(c44427j)) {
            this.ocA.add(c44427j);
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
        mo17446xE(this.mController.dyj());
    }
}
