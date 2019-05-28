package com.tencent.p177mm.plugin.wallet.bind.p553ui;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.p612ui.base.C5271a;
import com.tencent.p177mm.plugin.wallet.pay.p554a.C40071a;
import com.tencent.p177mm.plugin.wallet.pay.p554a.p555a.C14157b;
import com.tencent.p177mm.plugin.wallet.pay.p554a.p555a.C29593c;
import com.tencent.p177mm.plugin.wallet_core.id_verify.util.RealnameGuideHelper;
import com.tencent.p177mm.plugin.wallet_core.model.Authen;
import com.tencent.p177mm.plugin.wallet_core.model.Bankcard;
import com.tencent.p177mm.plugin.wallet_core.model.C14241r;
import com.tencent.p177mm.plugin.wallet_core.model.ElementQuery;
import com.tencent.p177mm.plugin.wallet_core.model.Orders;
import com.tencent.p177mm.plugin.wallet_core.p561ui.view.WalletPhoneInputView;
import com.tencent.p177mm.plugin.wallet_core.p749c.C14225t;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.wallet_core.C24143a;
import com.tencent.p177mm.wallet_core.p650ui.C36391e;
import com.tencent.p177mm.wallet_core.p650ui.MMScrollView;
import com.tencent.p177mm.wallet_core.p650ui.WalletBaseUI;
import com.tencent.p177mm.wallet_core.p650ui.formview.C30890a;
import com.tencent.p177mm.wallet_core.p650ui.formview.WalletFormView;
import com.tencent.p177mm.wallet_core.p650ui.formview.WalletFormView.C36397a;

@C5271a(19)
/* renamed from: com.tencent.mm.plugin.wallet.bind.ui.WalletResetInfoUI */
public class WalletResetInfoUI extends WalletBaseUI implements C36397a {
    private Button gEZ;
    private TextView iqU;
    private Orders pWy;
    private Bankcard thJ;
    private WalletFormView tmn;
    private WalletFormView tmo;
    private WalletFormView tmp;
    private WalletFormView tmq;
    private WalletPhoneInputView tmr;
    private Authen tms;
    private ElementQuery tmt;

    /* renamed from: com.tencent.mm.plugin.wallet.bind.ui.WalletResetInfoUI$1 */
    class C400671 implements OnClickListener {
        C400671() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(45818);
            if (WalletResetInfoUI.m68648a(WalletResetInfoUI.this)) {
                if (WalletResetInfoUI.this.tmp.getVisibility() == 0) {
                    WalletResetInfoUI.this.tms.twh = WalletResetInfoUI.this.tmp.getText();
                }
                if (WalletResetInfoUI.this.tmo.getVisibility() == 0) {
                    WalletResetInfoUI.this.tms.twi = C5046bo.m7532bc(WalletResetInfoUI.this.tmo.getText(), "");
                }
                if (WalletResetInfoUI.this.tmr.getVisibility() == 0) {
                    WalletResetInfoUI.this.tms.tuk = C5046bo.m7532bc(WalletResetInfoUI.this.tmq.getText(), "");
                    WalletResetInfoUI.this.mBundle.putString("key_mobile", C36391e.atu(WalletResetInfoUI.this.tms.tuk));
                }
                C4990ab.m7411d("Micromsg.WalletResetInfoUI", "tft: bank_type: %s, bank_serial: %s", WalletResetInfoUI.this.tms.pbn, WalletResetInfoUI.this.tms.pbo);
                WalletResetInfoUI.this.tms.twb = 1;
                WalletResetInfoUI.this.tms.twt = "+" + WalletResetInfoUI.this.tmr.getCountryCode();
                if (WalletResetInfoUI.this.mBundle.getBoolean("key_is_changing_balance_phone_num", false)) {
                    WalletResetInfoUI.this.mo39970a(C40071a.m68668b(WalletResetInfoUI.this.tms, WalletResetInfoUI.this.pWy, WalletResetInfoUI.this.mBundle.getBoolean("key_isbalance", false)), true, true);
                    AppMethodBeat.m2505o(45818);
                    return;
                }
                C1207m a = C40071a.m68666a(WalletResetInfoUI.this.tms, WalletResetInfoUI.this.pWy, false);
                if (a != null) {
                    WalletResetInfoUI.this.mo39970a(a, true, true);
                }
                AppMethodBeat.m2505o(45818);
                return;
            }
            C4990ab.m7420w("Micromsg.WalletResetInfoUI", "input format illegal!");
            AppMethodBeat.m2505o(45818);
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    /* renamed from: a */
    static /* synthetic */ boolean m68648a(WalletResetInfoUI walletResetInfoUI) {
        AppMethodBeat.m2504i(45829);
        boolean arW = walletResetInfoUI.arW();
        AppMethodBeat.m2505o(45829);
        return arW;
    }

    public final int getLayoutId() {
        return 2130971162;
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(45819);
        super.onCreate(bundle);
        initView();
        AppMethodBeat.m2505o(45819);
    }

    public void onDestroy() {
        AppMethodBeat.m2504i(45820);
        super.onDestroy();
        AppMethodBeat.m2505o(45820);
    }

    public final void initView() {
        AppMethodBeat.m2504i(45821);
        this.iqU = (TextView) findViewById(2131829045);
        this.thJ = cNz();
        this.pWy = (Orders) this.mBundle.getParcelable("key_orders");
        this.tms = (Authen) this.mBundle.getParcelable("key_authen");
        if (TextUtils.isEmpty(this.mBundle.getString("key_pwd1", ""))) {
            this.mBundle.putString("key_pwd1", this.tms.twc);
            C4990ab.m7412e("Micromsg.WalletResetInfoUI", "pwd is empty, reset it to input");
        }
        this.tmt = (ElementQuery) this.mBundle.getParcelable("elemt_query");
        this.tmr = (WalletPhoneInputView) findViewById(2131828728);
        this.tmq = this.tmr.getPhoneNumberEt();
        if (this.thJ.txl == 1) {
            this.tmr.cSC();
        } else {
            this.tmr.cSB();
        }
        EditText editText = (EditText) this.tmr.findViewById(2131829013);
        mo39989e(this.tmr.getPhoneNumberEt(), 0, false);
        mo39969a(this.tmr.getPhoneNumberEt(), editText, 0, false, false, true);
        this.tmn = (WalletFormView) findViewById(2131829046);
        this.tmo = (WalletFormView) findViewById(2131826504);
        C30890a.m49290a((MMActivity) this, this.tmo);
        this.tmp = (WalletFormView) findViewById(2131826502);
        C30890a.m49293b(this, this.tmp);
        this.tmo.setOnInputValidChangeListener(this);
        this.tmp.setOnInputValidChangeListener(this);
        this.tmq.setOnInputValidChangeListener(this);
        MMScrollView mMScrollView = (MMScrollView) findViewById(2131823366);
        mMScrollView.mo28524a(mMScrollView, mMScrollView);
        if (this.thJ != null) {
            this.tmn.setText(this.thJ.field_desc);
        } else {
            this.tmn.setVisibility(8);
        }
        cNB();
        if (cNA()) {
            mo39970a(new C14225t("", "", null), true, false);
        }
        AppMethodBeat.m2505o(45821);
    }

    /* renamed from: c */
    public final boolean mo7885c(int i, int i2, String str, C1207m c1207m) {
        AppMethodBeat.m2504i(45825);
        C4990ab.m7410d("Micromsg.WalletResetInfoUI", " errCode: " + i2 + " errMsg :" + str);
        if (i == 0 && i2 == 0) {
            Bundle bundle = this.mBundle;
            if ((c1207m instanceof C14157b) || (c1207m instanceof C29593c)) {
                C14157b c14157b = (C14157b) c1207m;
                bundle.putBoolean("key_need_verify_sms", !c14157b.tof);
                bundle.putString("kreq_token", c14157b.token);
                if (c14157b.tpw) {
                    bundle.putParcelable("key_orders", c14157b.tog);
                }
                RealnameGuideHelper realnameGuideHelper = c14157b.oYc;
                if (realnameGuideHelper != null) {
                    bundle.putParcelable("key_realname_guide_helper", realnameGuideHelper);
                }
                bundle.putInt("key_err_code", 0);
                C24143a.m37116j(this, bundle);
                AppMethodBeat.m2505o(45825);
                return true;
            } else if ((c1207m instanceof C14225t) && this.thJ != null) {
                this.tmt = C14241r.cPQ().acz(this.thJ.field_bindSerial);
                cNB();
            }
        }
        AppMethodBeat.m2505o(45825);
        return false;
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        AppMethodBeat.m2504i(45826);
        if (this.tmr.mo26600e(i, i2, intent)) {
            AppMethodBeat.m2505o(45826);
            return;
        }
        super.onActivityResult(i, i2, intent);
        AppMethodBeat.m2505o(45826);
    }

    private boolean arW() {
        boolean z;
        AppMethodBeat.m2504i(45827);
        if (this.tmo.mo64602fx(null)) {
            z = true;
        } else {
            z = false;
        }
        if (this.tmr.getVisibility() == 0 && this.tmr.cSA() && !this.tmq.mo64602fx(null)) {
            z = false;
        }
        if (!this.tmp.mo64602fx(null)) {
            z = false;
        }
        if (this.pWy == null || this.tms == null) {
            z = false;
        }
        if (z) {
            this.gEZ.setEnabled(true);
            this.gEZ.setClickable(true);
        } else {
            this.gEZ.setEnabled(false);
            this.gEZ.setClickable(false);
        }
        AppMethodBeat.m2505o(45827);
        return z;
    }

    /* renamed from: hY */
    public final void mo9407hY(boolean z) {
        AppMethodBeat.m2504i(45828);
        arW();
        AppMethodBeat.m2505o(45828);
    }

    private Bankcard cNz() {
        AppMethodBeat.m2504i(45822);
        Bankcard bankcard = (Bankcard) this.mBundle.getParcelable("key_switch_phone_reset_bank_card");
        if (bankcard == null) {
            bankcard = (Bankcard) this.mBundle.getParcelable("key_bankcard");
        }
        AppMethodBeat.m2505o(45822);
        return bankcard;
    }

    private boolean cNA() {
        AppMethodBeat.m2504i(45823);
        if (this.mBundle.getInt("key_err_code", 408) == 408 && this.tmt == null) {
            AppMethodBeat.m2505o(45823);
            return true;
        }
        AppMethodBeat.m2505o(45823);
        return false;
    }

    private void cNB() {
        AppMethodBeat.m2504i(45824);
        switch (this.mBundle.getInt("key_err_code", 408)) {
            case 402:
                setMMTitle((int) C25738R.string.frl);
                this.tmp.setVisibility(0);
                this.iqU.setText(C25738R.string.frk);
                break;
            case 403:
                setMMTitle((int) C25738R.string.frs);
                this.tmo.setVisibility(0);
                this.iqU.setText(C25738R.string.frr);
                break;
            default:
                if (this.mBundle.getBoolean("key_balance_change_phone_need_confirm_phone", true)) {
                    setMMTitle((int) C25738R.string.frp);
                    this.tmr.setVisibility(0);
                } else {
                    setMMTitle((int) C25738R.string.frn);
                }
                if (this.thJ != null) {
                    C4990ab.m7411d("Micromsg.WalletResetInfoUI", "bankPhone: %s", this.thJ.field_bankPhone);
                    this.iqU.setText(String.format(getString(C25738R.string.fro), new Object[]{this.thJ.field_bankPhone}));
                }
                if (this.tmt == null && this.thJ != null) {
                    this.tmt = C14241r.cPQ().acy(this.thJ.field_bankcardType);
                }
                if (this.tmt != null && this.tmt.tyy) {
                    this.tmp.setVisibility(0);
                }
                if (this.tmt != null && this.tmt.tyz) {
                    this.tmo.setVisibility(0);
                    break;
                }
        }
        this.gEZ = (Button) findViewById(2131822846);
        this.gEZ.setOnClickListener(new C400671());
        arW();
        if (cNA()) {
            mo9439AM(4);
            AppMethodBeat.m2505o(45824);
            return;
        }
        mo9439AM(0);
        AppMethodBeat.m2505o(45824);
    }
}
