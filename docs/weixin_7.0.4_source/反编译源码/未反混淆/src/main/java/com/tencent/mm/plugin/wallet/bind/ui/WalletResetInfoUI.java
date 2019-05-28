package com.tencent.mm.plugin.wallet.bind.ui;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ai.m;
import com.tencent.mm.plugin.wallet.pay.a.a.b;
import com.tencent.mm.plugin.wallet.pay.a.a.c;
import com.tencent.mm.plugin.wallet_core.c.t;
import com.tencent.mm.plugin.wallet_core.id_verify.util.RealnameGuideHelper;
import com.tencent.mm.plugin.wallet_core.model.Authen;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.ElementQuery;
import com.tencent.mm.plugin.wallet_core.model.Orders;
import com.tencent.mm.plugin.wallet_core.model.r;
import com.tencent.mm.plugin.wallet_core.ui.view.WalletPhoneInputView;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.wallet_core.ui.MMScrollView;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.e;
import com.tencent.mm.wallet_core.ui.formview.WalletFormView;

@a(19)
public class WalletResetInfoUI extends WalletBaseUI implements WalletFormView.a {
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

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    static /* synthetic */ boolean a(WalletResetInfoUI walletResetInfoUI) {
        AppMethodBeat.i(45829);
        boolean arW = walletResetInfoUI.arW();
        AppMethodBeat.o(45829);
        return arW;
    }

    public final int getLayoutId() {
        return R.layout.b5z;
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(45819);
        super.onCreate(bundle);
        initView();
        AppMethodBeat.o(45819);
    }

    public void onDestroy() {
        AppMethodBeat.i(45820);
        super.onDestroy();
        AppMethodBeat.o(45820);
    }

    public final void initView() {
        AppMethodBeat.i(45821);
        this.iqU = (TextView) findViewById(R.id.fgs);
        this.thJ = cNz();
        this.pWy = (Orders) this.mBundle.getParcelable("key_orders");
        this.tms = (Authen) this.mBundle.getParcelable("key_authen");
        if (TextUtils.isEmpty(this.mBundle.getString("key_pwd1", ""))) {
            this.mBundle.putString("key_pwd1", this.tms.twc);
            ab.e("Micromsg.WalletResetInfoUI", "pwd is empty, reset it to input");
        }
        this.tmt = (ElementQuery) this.mBundle.getParcelable("elemt_query");
        this.tmr = (WalletPhoneInputView) findViewById(R.id.f98);
        this.tmq = this.tmr.getPhoneNumberEt();
        if (this.thJ.txl == 1) {
            this.tmr.cSC();
        } else {
            this.tmr.cSB();
        }
        EditText editText = (EditText) this.tmr.findViewById(R.id.ffx);
        e(this.tmr.getPhoneNumberEt(), 0, false);
        a(this.tmr.getPhoneNumberEt(), editText, 0, false, false, true);
        this.tmn = (WalletFormView) findViewById(R.id.fgt);
        this.tmo = (WalletFormView) findViewById(R.id.dm4);
        com.tencent.mm.wallet_core.ui.formview.a.a((MMActivity) this, this.tmo);
        this.tmp = (WalletFormView) findViewById(R.id.dm2);
        com.tencent.mm.wallet_core.ui.formview.a.b(this, this.tmp);
        this.tmo.setOnInputValidChangeListener(this);
        this.tmp.setOnInputValidChangeListener(this);
        this.tmq.setOnInputValidChangeListener(this);
        MMScrollView mMScrollView = (MMScrollView) findViewById(R.id.bb_);
        mMScrollView.a(mMScrollView, mMScrollView);
        if (this.thJ != null) {
            this.tmn.setText(this.thJ.field_desc);
        } else {
            this.tmn.setVisibility(8);
        }
        cNB();
        if (cNA()) {
            a(new t("", "", null), true, false);
        }
        AppMethodBeat.o(45821);
    }

    public final boolean c(int i, int i2, String str, m mVar) {
        AppMethodBeat.i(45825);
        ab.d("Micromsg.WalletResetInfoUI", " errCode: " + i2 + " errMsg :" + str);
        if (i == 0 && i2 == 0) {
            Bundle bundle = this.mBundle;
            if ((mVar instanceof b) || (mVar instanceof c)) {
                b bVar = (b) mVar;
                bundle.putBoolean("key_need_verify_sms", !bVar.tof);
                bundle.putString("kreq_token", bVar.token);
                if (bVar.tpw) {
                    bundle.putParcelable("key_orders", bVar.tog);
                }
                RealnameGuideHelper realnameGuideHelper = bVar.oYc;
                if (realnameGuideHelper != null) {
                    bundle.putParcelable("key_realname_guide_helper", realnameGuideHelper);
                }
                bundle.putInt("key_err_code", 0);
                com.tencent.mm.wallet_core.a.j(this, bundle);
                AppMethodBeat.o(45825);
                return true;
            } else if ((mVar instanceof t) && this.thJ != null) {
                this.tmt = r.cPQ().acz(this.thJ.field_bindSerial);
                cNB();
            }
        }
        AppMethodBeat.o(45825);
        return false;
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        AppMethodBeat.i(45826);
        if (this.tmr.e(i, i2, intent)) {
            AppMethodBeat.o(45826);
            return;
        }
        super.onActivityResult(i, i2, intent);
        AppMethodBeat.o(45826);
    }

    private boolean arW() {
        boolean z;
        AppMethodBeat.i(45827);
        if (this.tmo.fx(null)) {
            z = true;
        } else {
            z = false;
        }
        if (this.tmr.getVisibility() == 0 && this.tmr.cSA() && !this.tmq.fx(null)) {
            z = false;
        }
        if (!this.tmp.fx(null)) {
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
        AppMethodBeat.o(45827);
        return z;
    }

    public final void hY(boolean z) {
        AppMethodBeat.i(45828);
        arW();
        AppMethodBeat.o(45828);
    }

    private Bankcard cNz() {
        AppMethodBeat.i(45822);
        Bankcard bankcard = (Bankcard) this.mBundle.getParcelable("key_switch_phone_reset_bank_card");
        if (bankcard == null) {
            bankcard = (Bankcard) this.mBundle.getParcelable("key_bankcard");
        }
        AppMethodBeat.o(45822);
        return bankcard;
    }

    private boolean cNA() {
        AppMethodBeat.i(45823);
        if (this.mBundle.getInt("key_err_code", 408) == 408 && this.tmt == null) {
            AppMethodBeat.o(45823);
            return true;
        }
        AppMethodBeat.o(45823);
        return false;
    }

    private void cNB() {
        AppMethodBeat.i(45824);
        switch (this.mBundle.getInt("key_err_code", 408)) {
            case 402:
                setMMTitle((int) R.string.frl);
                this.tmp.setVisibility(0);
                this.iqU.setText(R.string.frk);
                break;
            case 403:
                setMMTitle((int) R.string.frs);
                this.tmo.setVisibility(0);
                this.iqU.setText(R.string.frr);
                break;
            default:
                if (this.mBundle.getBoolean("key_balance_change_phone_need_confirm_phone", true)) {
                    setMMTitle((int) R.string.frp);
                    this.tmr.setVisibility(0);
                } else {
                    setMMTitle((int) R.string.frn);
                }
                if (this.thJ != null) {
                    ab.d("Micromsg.WalletResetInfoUI", "bankPhone: %s", this.thJ.field_bankPhone);
                    this.iqU.setText(String.format(getString(R.string.fro), new Object[]{this.thJ.field_bankPhone}));
                }
                if (this.tmt == null && this.thJ != null) {
                    this.tmt = r.cPQ().acy(this.thJ.field_bankcardType);
                }
                if (this.tmt != null && this.tmt.tyy) {
                    this.tmp.setVisibility(0);
                }
                if (this.tmt != null && this.tmt.tyz) {
                    this.tmo.setVisibility(0);
                    break;
                }
        }
        this.gEZ = (Button) findViewById(R.id.ay8);
        this.gEZ.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(45818);
                if (WalletResetInfoUI.a(WalletResetInfoUI.this)) {
                    if (WalletResetInfoUI.this.tmp.getVisibility() == 0) {
                        WalletResetInfoUI.this.tms.twh = WalletResetInfoUI.this.tmp.getText();
                    }
                    if (WalletResetInfoUI.this.tmo.getVisibility() == 0) {
                        WalletResetInfoUI.this.tms.twi = bo.bc(WalletResetInfoUI.this.tmo.getText(), "");
                    }
                    if (WalletResetInfoUI.this.tmr.getVisibility() == 0) {
                        WalletResetInfoUI.this.tms.tuk = bo.bc(WalletResetInfoUI.this.tmq.getText(), "");
                        WalletResetInfoUI.this.mBundle.putString("key_mobile", e.atu(WalletResetInfoUI.this.tms.tuk));
                    }
                    ab.d("Micromsg.WalletResetInfoUI", "tft: bank_type: %s, bank_serial: %s", WalletResetInfoUI.this.tms.pbn, WalletResetInfoUI.this.tms.pbo);
                    WalletResetInfoUI.this.tms.twb = 1;
                    WalletResetInfoUI.this.tms.twt = "+" + WalletResetInfoUI.this.tmr.getCountryCode();
                    if (WalletResetInfoUI.this.mBundle.getBoolean("key_is_changing_balance_phone_num", false)) {
                        WalletResetInfoUI.this.a(com.tencent.mm.plugin.wallet.pay.a.a.b(WalletResetInfoUI.this.tms, WalletResetInfoUI.this.pWy, WalletResetInfoUI.this.mBundle.getBoolean("key_isbalance", false)), true, true);
                        AppMethodBeat.o(45818);
                        return;
                    }
                    m a = com.tencent.mm.plugin.wallet.pay.a.a.a(WalletResetInfoUI.this.tms, WalletResetInfoUI.this.pWy, false);
                    if (a != null) {
                        WalletResetInfoUI.this.a(a, true, true);
                    }
                    AppMethodBeat.o(45818);
                    return;
                }
                ab.w("Micromsg.WalletResetInfoUI", "input format illegal!");
                AppMethodBeat.o(45818);
            }
        });
        arW();
        if (cNA()) {
            AM(4);
            AppMethodBeat.o(45824);
            return;
        }
        AM(0);
        AppMethodBeat.o(45824);
    }
}
