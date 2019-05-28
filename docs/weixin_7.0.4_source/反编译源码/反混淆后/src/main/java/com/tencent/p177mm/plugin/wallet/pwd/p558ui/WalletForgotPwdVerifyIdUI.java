package com.tencent.p177mm.plugin.wallet.pwd.p558ui;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.view.View.OnLayoutChangeListener;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p612ui.C5229aj;
import com.tencent.p177mm.p612ui.base.C5271a;
import com.tencent.p177mm.p612ui.widget.MMEditText;
import com.tencent.p177mm.plugin.wallet.pwd.p1049a.C22542q;
import com.tencent.p177mm.plugin.wallet_core.model.C14241r;
import com.tencent.p177mm.plugin.wallet_core.p749c.C35475y;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C7306ak;
import com.tencent.p177mm.wallet_core.p649c.C30860n;
import com.tencent.p177mm.wallet_core.p649c.C40928b;
import com.tencent.p177mm.wallet_core.p649c.C46720ab;
import com.tencent.p177mm.wallet_core.p650ui.C36391e;
import com.tencent.p177mm.wallet_core.p650ui.C40947a;
import com.tencent.p177mm.wallet_core.p650ui.WalletBaseUI;
import com.tencent.p177mm.wallet_core.p650ui.formview.C30890a;
import com.tencent.p177mm.wallet_core.p650ui.formview.WalletFormView;

@C5271a(3)
/* renamed from: com.tencent.mm.plugin.wallet.pwd.ui.WalletForgotPwdVerifyIdUI */
public class WalletForgotPwdVerifyIdUI extends WalletBaseUI implements OnLayoutChangeListener {
    private TextView gsf;
    private int iev = 0;
    private View iym;
    private int keyHeight = 0;
    private boolean trE;
    private MMEditText trJ;
    private TextView trK;
    private WalletFormView trL;
    private Button trM;
    private TextView trN;
    private LinearLayout trO;
    MarginLayoutParams trP;
    MarginLayoutParams trQ;
    private View trR;
    private boolean trS = false;
    private boolean trT = false;
    private boolean trU = false;
    private boolean trV = false;

    /* renamed from: com.tencent.mm.plugin.wallet.pwd.ui.WalletForgotPwdVerifyIdUI$4 */
    class C142124 implements TextWatcher {
        C142124() {
        }

        public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            AppMethodBeat.m2504i(46309);
            C4990ab.m7416i("MicroMsg.WalletForgotPwdVerifyIdUI", " haveNameext：" + WalletForgotPwdVerifyIdUI.this.trJ.getText());
            if (WalletForgotPwdVerifyIdUI.this.trJ.getText() == null || "".equals(WalletForgotPwdVerifyIdUI.this.trJ.getText().toString())) {
                WalletForgotPwdVerifyIdUI.this.trS = false;
            } else {
                WalletForgotPwdVerifyIdUI.this.trS = true;
            }
            WalletForgotPwdVerifyIdUI.m38879g(WalletForgotPwdVerifyIdUI.this);
            AppMethodBeat.m2505o(46309);
        }

        public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public final void afterTextChanged(Editable editable) {
        }
    }

    /* renamed from: com.tencent.mm.plugin.wallet.pwd.ui.WalletForgotPwdVerifyIdUI$6 */
    class C142136 implements C40947a {
        C142136() {
        }

        /* renamed from: ic */
        public final void mo9448ic(boolean z) {
            AppMethodBeat.m2504i(46311);
            if (z) {
                C4990ab.m7416i("MicroMsg.WalletForgotPwdVerifyIdUI", " TenpayKBS visible");
                WalletForgotPwdVerifyIdUI.m38870a(WalletForgotPwdVerifyIdUI.this, WalletForgotPwdVerifyIdUI.this.iym, WalletForgotPwdVerifyIdUI.this.trL);
                WalletForgotPwdVerifyIdUI.m38881i(WalletForgotPwdVerifyIdUI.this);
                AppMethodBeat.m2505o(46311);
                return;
            }
            C4990ab.m7416i("MicroMsg.WalletForgotPwdVerifyIdUI", " TenpayKBS unvisible");
            WalletForgotPwdVerifyIdUI.m38882j(WalletForgotPwdVerifyIdUI.this);
            WalletForgotPwdVerifyIdUI.this.iym.scrollTo(0, 0);
            AppMethodBeat.m2505o(46311);
        }
    }

    /* renamed from: com.tencent.mm.plugin.wallet.pwd.ui.WalletForgotPwdVerifyIdUI$7 */
    class C142147 implements OnFocusChangeListener {
        C142147() {
        }

        public final void onFocusChange(View view, boolean z) {
            AppMethodBeat.m2504i(46312);
            if (z) {
                C4990ab.m7416i("MicroMsg.WalletForgotPwdVerifyIdUI", " has focus");
                WalletForgotPwdVerifyIdUI.m38881i(WalletForgotPwdVerifyIdUI.this);
                AppMethodBeat.m2505o(46312);
                return;
            }
            C4990ab.m7416i("MicroMsg.WalletForgotPwdVerifyIdUI", " lose focus");
            AppMethodBeat.m2505o(46312);
        }
    }

    /* renamed from: com.tencent.mm.plugin.wallet.pwd.ui.WalletForgotPwdVerifyIdUI$5 */
    class C248925 implements TextWatcher {
        C248925() {
        }

        public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            AppMethodBeat.m2504i(46310);
            if (WalletForgotPwdVerifyIdUI.this.trL.getText() != null) {
                WalletForgotPwdVerifyIdUI.this.trT = true;
            } else {
                WalletForgotPwdVerifyIdUI.this.trT = false;
            }
            WalletForgotPwdVerifyIdUI.m38879g(WalletForgotPwdVerifyIdUI.this);
            AppMethodBeat.m2505o(46310);
        }

        public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public final void afterTextChanged(Editable editable) {
        }
    }

    /* renamed from: com.tencent.mm.plugin.wallet.pwd.ui.WalletForgotPwdVerifyIdUI$2 */
    class C248932 implements OnClickListener {
        C248932() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(46307);
            C36391e.m60016n(WalletForgotPwdVerifyIdUI.this, "https://kf.qq.com/touch/scene_product.html?scene_id=kf3258", false);
            AppMethodBeat.m2505o(46307);
        }
    }

    /* renamed from: com.tencent.mm.plugin.wallet.pwd.ui.WalletForgotPwdVerifyIdUI$1 */
    class C248941 implements OnClickListener {
        C248941() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(46306);
            String text = WalletForgotPwdVerifyIdUI.this.trL.getText();
            int cQq = C14241r.cPI().cQq();
            String obj = WalletForgotPwdVerifyIdUI.this.trJ.getText().toString();
            if (!(C5046bo.isNullOrNil(text) || C5046bo.isNullOrNil(obj))) {
                WalletForgotPwdVerifyIdUI.this.mBundle.putString("key_identity", text);
                WalletForgotPwdVerifyIdUI.this.mBundle.putInt("key_id_type", cQq);
                WalletForgotPwdVerifyIdUI.this.mBundle.putString("key_true_name", obj);
                if (WalletForgotPwdVerifyIdUI.this.dOD() != null) {
                    WalletForgotPwdVerifyIdUI.this.dOD().mqu.putString("key_identity", text);
                    WalletForgotPwdVerifyIdUI.this.dOD().mqu.putInt("key_id_type", cQq);
                    WalletForgotPwdVerifyIdUI.this.dOD().mqu.putString("key_true_name", obj);
                }
                WalletForgotPwdVerifyIdUI.this.dOE().mo9366p(text, Integer.valueOf(cQq), obj);
            }
            AppMethodBeat.m2505o(46306);
        }
    }

    /* renamed from: com.tencent.mm.plugin.wallet.pwd.ui.WalletForgotPwdVerifyIdUI$3 */
    class C248953 implements Runnable {
        C248953() {
        }

        public final void run() {
            AppMethodBeat.m2504i(46308);
            WalletForgotPwdVerifyIdUI.this.gsf.setVisibility(8);
            WalletForgotPwdVerifyIdUI.this.trN.setVisibility(8);
            WalletForgotPwdVerifyIdUI.this.trP = (MarginLayoutParams) WalletForgotPwdVerifyIdUI.this.trO.getLayoutParams();
            WalletForgotPwdVerifyIdUI.this.trP.topMargin = C5229aj.fromDPToPix(WalletForgotPwdVerifyIdUI.this, 47);
            WalletForgotPwdVerifyIdUI.this.trO.setLayoutParams(WalletForgotPwdVerifyIdUI.this.trP);
            WalletForgotPwdVerifyIdUI.this.trQ = (MarginLayoutParams) WalletForgotPwdVerifyIdUI.this.trM.getLayoutParams();
            WalletForgotPwdVerifyIdUI.this.trQ.topMargin = C5229aj.fromDPToPix(WalletForgotPwdVerifyIdUI.this, 48);
            WalletForgotPwdVerifyIdUI.this.trM.setLayoutParams(WalletForgotPwdVerifyIdUI.this.trQ);
            AppMethodBeat.m2505o(46308);
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    /* renamed from: a */
    static /* synthetic */ void m38870a(WalletForgotPwdVerifyIdUI walletForgotPwdVerifyIdUI, View view, View view2) {
        AppMethodBeat.m2504i(46319);
        walletForgotPwdVerifyIdUI.mo39974b(view, view2, 10);
        AppMethodBeat.m2505o(46319);
    }

    /* renamed from: i */
    static /* synthetic */ void m38881i(WalletForgotPwdVerifyIdUI walletForgotPwdVerifyIdUI) {
        AppMethodBeat.m2504i(46320);
        walletForgotPwdVerifyIdUI.cOD();
        AppMethodBeat.m2505o(46320);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(46313);
        super.onCreate(bundle);
        C4990ab.m7416i("MicroMsg.WalletForgotPwdVerifyIdUI", "onCreate");
        mo17446xE(Color.parseColor("#FFFFFF"));
        dyb();
        mo17369MY(8);
        this.trR = findViewById(2131825792);
        this.iev = getWindowManager().getDefaultDisplay().getHeight();
        this.keyHeight = this.iev / 3;
        this.trR.addOnLayoutChangeListener(this);
        this.trE = this.mBundle.getBoolean("key_is_force_bind", false);
        if (!this.trE) {
            mo39970a(new C35475y(null, 6), true, true);
            mo9439AM(4);
        }
        this.trJ = (MMEditText) findViewById(2131828805);
        this.trK = (TextView) findViewById(2131828806);
        this.trL = (WalletFormView) findViewById(2131828720);
        this.trM = (Button) findViewById(2131822846);
        this.trN = (TextView) findViewById(2131828808);
        this.iym = findViewById(2131820987);
        this.gsf = (TextView) findViewById(2131820678);
        this.trO = (LinearLayout) findViewById(2131823731);
        this.trL.setEnabled(false);
        this.trL.setFocusable(false);
        this.trM.setOnClickListener(new C248941());
        this.trN.setOnClickListener(new C248932());
        m38875cu();
        this.obM = new C142136();
        this.trJ.setOnFocusChangeListener(new C142147());
        this.trJ.addTextChangedListener(new C142124());
        this.trL.mo64594a(new C248925());
        AppMethodBeat.m2505o(46313);
    }

    /* renamed from: cu */
    private void m38875cu() {
        AppMethodBeat.m2504i(46314);
        C4990ab.m7416i("MicroMsg.WalletForgotPwdVerifyIdUI", "updateView");
        int i = C14241r.cPE().cRh().field_cre_type;
        String str = C14241r.cPE().cRh().field_cre_name;
        String str2 = C14241r.cPE().cRh().field_true_name;
        this.trJ.setHint(getString(C25738R.string.fcr, new Object[]{C36391e.att(str2)}));
        if (C5046bo.isNullOrNil(str)) {
            C4990ab.m7420w("MicroMsg.WalletForgotPwdVerifyIdUI", "creName is null");
        } else {
            this.trK.setText(str);
        }
        if (i == 1) {
            C30890a.m49298d(this.trL);
            mo39989e(this.trL, 1, false);
            AppMethodBeat.m2505o(46314);
            return;
        }
        C4990ab.m7416i("MicroMsg.WalletForgotPwdVerifyIdUI", "no need tenpay keyboard");
        AppMethodBeat.m2505o(46314);
    }

    /* renamed from: c */
    public final boolean mo7885c(int i, int i2, String str, C1207m c1207m) {
        AppMethodBeat.m2504i(46315);
        C4990ab.m7417i("MicroMsg.WalletForgotPwdVerifyIdUI", " errCode: %s errMsg: %s  scene: %s", Integer.valueOf(i2), str, c1207m);
        if (i == 0 && i2 == 0) {
            if (c1207m instanceof C35475y) {
                m38875cu();
                mo9439AM(0);
            } else if (c1207m instanceof C22542q) {
                C22542q c22542q = (C22542q) c1207m;
                this.mBundle.putInt("key_is_support_face", c22542q.tqK);
                this.mBundle.putInt("key_face_action_scene", c22542q.scene);
                this.mBundle.putString("key_face_action_package", c22542q.packageName);
                this.mBundle.putString("key_face_action_package_sign", c22542q.cKT);
                if (c22542q.tqL == 1) {
                    C46720ab.dNZ();
                    String dNY = C46720ab.dNY();
                    C40928b.dNJ();
                    if (C40928b.isCertExist(dNY)) {
                        C4990ab.m7416i("MicroMsg.WalletForgotPwdVerifyIdUI", "already install cert, go to next process");
                        dOD().mo8124a((Activity) this, 0, this.mBundle);
                    } else {
                        C4990ab.m7416i("MicroMsg.WalletForgotPwdVerifyIdUI", "checkInstallCert, crt not installed");
                        mo39970a(new C30860n(c22542q.tqI, c22542q.tqJ, c22542q.cQY), true, false);
                    }
                } else {
                    C4990ab.m7416i("MicroMsg.WalletForgotPwdVerifyIdUI", "verify realname info finish, go to next process");
                    dOD().mo8124a((Activity) this, 0, this.mBundle);
                }
            } else if (c1207m instanceof C30860n) {
                C4990ab.m7416i("MicroMsg.WalletForgotPwdVerifyIdUI", "install cert finish, go to next process");
                dOD().mo8124a((Activity) this, 0, this.mBundle);
            }
        }
        AppMethodBeat.m2505o(46315);
        return false;
    }

    private void cOD() {
        AppMethodBeat.m2504i(46316);
        C4990ab.m7416i("MicroMsg.WalletForgotPwdVerifyIdUI", " setChangParams()");
        new C7306ak().postDelayed(new C248953(), 100);
        AppMethodBeat.m2505o(46316);
    }

    public void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        AppMethodBeat.m2504i(46317);
        if (i8 == 0 || i4 == 0 || i8 - i4 <= this.keyHeight) {
            if (!(i8 == 0 || i4 == 0 || i4 - i8 <= this.keyHeight)) {
                C4990ab.m7416i("MicroMsg.WalletForgotPwdVerifyIdUI", " down");
            }
            AppMethodBeat.m2505o(46317);
            return;
        }
        C4990ab.m7416i("MicroMsg.WalletForgotPwdVerifyIdUI", " up");
        cOD();
        AppMethodBeat.m2505o(46317);
    }

    public final int getForceOrientation() {
        return 1;
    }

    public final int getLayoutId() {
        return 2130971100;
    }

    /* renamed from: g */
    static /* synthetic */ void m38879g(WalletForgotPwdVerifyIdUI walletForgotPwdVerifyIdUI) {
        AppMethodBeat.m2504i(46318);
        C4990ab.m7416i("MicroMsg.WalletForgotPwdVerifyIdUI", " haveIdentityText：" + walletForgotPwdVerifyIdUI.trT);
        C4990ab.m7416i("MicroMsg.WalletForgotPwdVerifyIdUI", " haveNameText：" + walletForgotPwdVerifyIdUI.trS);
        if (walletForgotPwdVerifyIdUI.trT && walletForgotPwdVerifyIdUI.trS) {
            walletForgotPwdVerifyIdUI.trM.setEnabled(true);
            AppMethodBeat.m2505o(46318);
            return;
        }
        walletForgotPwdVerifyIdUI.trM.setEnabled(false);
        AppMethodBeat.m2505o(46318);
    }

    /* renamed from: j */
    static /* synthetic */ void m38882j(WalletForgotPwdVerifyIdUI walletForgotPwdVerifyIdUI) {
        AppMethodBeat.m2504i(46321);
        C4990ab.m7416i("MicroMsg.WalletForgotPwdVerifyIdUI", " resetParams()");
        walletForgotPwdVerifyIdUI.gsf.setVisibility(0);
        walletForgotPwdVerifyIdUI.trN.setVisibility(0);
        walletForgotPwdVerifyIdUI.trP = (MarginLayoutParams) walletForgotPwdVerifyIdUI.trO.getLayoutParams();
        walletForgotPwdVerifyIdUI.trP.topMargin = C5229aj.fromDPToPix(walletForgotPwdVerifyIdUI, 59);
        walletForgotPwdVerifyIdUI.trO.setLayoutParams(walletForgotPwdVerifyIdUI.trP);
        walletForgotPwdVerifyIdUI.trQ = (MarginLayoutParams) walletForgotPwdVerifyIdUI.trM.getLayoutParams();
        walletForgotPwdVerifyIdUI.trQ.topMargin = C5229aj.fromDPToPix(walletForgotPwdVerifyIdUI, 114);
        walletForgotPwdVerifyIdUI.trM.setLayoutParams(walletForgotPwdVerifyIdUI.trQ);
        AppMethodBeat.m2505o(46321);
    }
}
