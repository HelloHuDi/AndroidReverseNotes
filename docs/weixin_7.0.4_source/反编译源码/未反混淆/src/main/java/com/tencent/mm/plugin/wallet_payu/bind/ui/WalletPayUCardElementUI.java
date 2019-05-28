package com.tencent.mm.plugin.wallet_payu.bind.ui;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ai.m;
import com.tencent.mm.plugin.wallet_payu.a.c;
import com.tencent.mm.plugin.wallet_payu.bind.model.NetScenePayUElementQuery;
import com.tencent.mm.plugin.wallet_payu.bind.model.NetScenePayUElementQuery.PayUBankcardElement;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.wallet_core.c.ae;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.formview.WalletFormView;
import java.util.HashMap;
import java.util.HashSet;

@com.tencent.mm.ui.base.a(19)
public class WalletPayUCardElementUI extends WalletBaseUI implements com.tencent.mm.wallet_core.ui.formview.WalletFormView.a {
    private Button gHn;
    private WalletFormView tSL;
    WalletFormView tSM;
    private WalletFormView tSN;
    private TextView tSO;
    private TextView tSP;
    private TextView tSQ;
    private b tSR;
    private boolean tSS = false;
    private boolean tST = false;
    private boolean tSU = false;
    private HashMap<String, PayUBankcardElement> tSV = null;
    private HashSet<String> tSW = null;

    protected class b {
        boolean tSY;
        boolean tSZ;
        boolean tTa;

        protected b() {
        }

        /* Access modifiers changed, original: protected|final */
        public final void cTc() {
            AppMethodBeat.i(48364);
            this.tSY = WalletPayUCardElementUI.this.tSL.asa();
            this.tSZ = WalletPayUCardElementUI.this.tSM.asa();
            this.tTa = WalletPayUCardElementUI.this.tSN.asa();
            if (!WalletPayUCardElementUI.this.tSU || this.tTa) {
                WalletPayUCardElementUI.this.tSP.setVisibility(4);
            } else {
                WalletPayUCardElementUI.this.tSP.setVisibility(0);
                WalletPayUCardElementUI.this.tSP.setText(R.string.fav);
            }
            boolean z;
            int z2;
            if (!WalletPayUCardElementUI.this.tSS) {
                z2 = false;
            } else if (!this.tSY) {
                WalletPayUCardElementUI.this.tSO.setVisibility(0);
                WalletPayUCardElementUI.this.tSO.setTextColor(WalletPayUCardElementUI.this.getResources().getColor(R.color.xy));
                WalletPayUCardElementUI.this.tSO.setText(R.string.fah);
                z2 = 0;
            } else if (!WalletPayUCardElementUI.this.tSV.containsKey(WalletPayUCardElementUI.this.tSL.getText()) || WalletPayUCardElementUI.this.tSW.contains(WalletPayUCardElementUI.this.tSL.getText())) {
                WalletPayUCardElementUI.this.a(new NetScenePayUElementQuery(WalletPayUCardElementUI.this.tSL.getText()), false, false);
                WalletPayUCardElementUI.this.tSW.add(WalletPayUCardElementUI.this.tSL.getText());
                WalletPayUCardElementUI.this.tSO.setVisibility(0);
                WalletPayUCardElementUI.this.tSO.setTextColor(WalletPayUCardElementUI.this.getResources().getColor(R.color.s0));
                WalletPayUCardElementUI.this.tSO.setText(WalletPayUCardElementUI.this.getString(R.string.f_x));
                z2 = true;
            } else {
                PayUBankcardElement payUBankcardElement = (PayUBankcardElement) WalletPayUCardElementUI.this.tSV.get(WalletPayUCardElementUI.this.tSL.getText());
                WalletPayUCardElementUI.this.tSO.setVisibility(0);
                if (bo.isNullOrNil(payUBankcardElement.tSG)) {
                    WalletPayUCardElementUI.this.tSO.setTextColor(WalletPayUCardElementUI.this.getResources().getColor(R.color.xy));
                    WalletPayUCardElementUI.this.tSO.setText(payUBankcardElement.tSH);
                    this.tSY = false;
                    z2 = 0;
                } else {
                    WalletPayUCardElementUI.this.tSO.setTextColor(WalletPayUCardElementUI.this.getResources().getColor(R.color.s0));
                    WalletPayUCardElementUI.this.tSO.setText(payUBankcardElement.tSH);
                    z2 = 0;
                }
            }
            if (this.tSY && this.tSZ && this.tTa && z2 == 0) {
                WalletPayUCardElementUI.this.gHn.setEnabled(true);
                AppMethodBeat.o(48364);
                return;
            }
            WalletPayUCardElementUI.this.gHn.setEnabled(false);
            AppMethodBeat.o(48364);
        }
    }

    abstract class a implements TextWatcher {
        private a() {
        }

        /* synthetic */ a(WalletPayUCardElementUI walletPayUCardElementUI, byte b) {
            this();
        }

        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(48365);
        super.onCreate(bundle);
        this.tSR = new b();
        this.tSV = new HashMap();
        this.tSW = new HashSet();
        this.tSL = (WalletFormView) findViewById(R.id.dm0);
        com.tencent.mm.wallet_core.ui.formview.a.b(this.tSL);
        this.tSM = (WalletFormView) findViewById(R.id.dm4);
        com.tencent.mm.wallet_core.ui.formview.a.a((MMActivity) this, this.tSM);
        this.tSN = (WalletFormView) findViewById(R.id.dm2);
        com.tencent.mm.wallet_core.ui.formview.a.b(this, this.tSN);
        this.tSO = (TextView) findViewById(R.id.dm1);
        this.tSP = (TextView) findViewById(R.id.dm3);
        this.gHn = (Button) findViewById(R.id.ay8);
        e(this.tSL, 0, false);
        e(this.tSN, 0, false);
        this.tSL.setOnInputValidChangeListener(this);
        this.tSN.setOnInputValidChangeListener(this);
        this.tSM.setOnInputValidChangeListener(this);
        this.tSL.setEncryptType(0);
        this.tSN.a(new a() {
            public final void afterTextChanged(Editable editable) {
                AppMethodBeat.i(48360);
                WalletPayUCardElementUI.a(WalletPayUCardElementUI.this, WalletPayUCardElementUI.this.tSN, editable);
                AppMethodBeat.o(48360);
            }
        });
        this.tSM.a(new a() {
            public final void afterTextChanged(Editable editable) {
                AppMethodBeat.i(48361);
                WalletPayUCardElementUI.a(WalletPayUCardElementUI.this, WalletPayUCardElementUI.this.tSM, editable);
                AppMethodBeat.o(48361);
            }
        });
        this.tSL.a(new a() {
            public final void afterTextChanged(Editable editable) {
                AppMethodBeat.i(48362);
                WalletPayUCardElementUI.a(WalletPayUCardElementUI.this, WalletPayUCardElementUI.this.tSL, editable);
                AppMethodBeat.o(48362);
            }
        });
        this.gHn.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(48363);
                PayUBankcardElement payUBankcardElement = (PayUBankcardElement) WalletPayUCardElementUI.this.tSV.get(WalletPayUCardElementUI.this.tSL.getText());
                if (payUBankcardElement == null) {
                    ab.e("MicroMsg.WalletPayUCardElementUI", "hy: should not be NULL!!!");
                    AppMethodBeat.o(48363);
                    return;
                }
                WalletPayUCardElementUI.this.tSL.setEncryptType(50);
                WalletPayUCardElementUI.this.mBundle.putParcelable("key_card_element", payUBankcardElement);
                WalletPayUCardElementUI.this.mBundle.putString("key_card_id", WalletPayUCardElementUI.this.tSL.getText());
                WalletPayUCardElementUI.this.mBundle.putString("key_cvv", WalletPayUCardElementUI.this.tSN.getText());
                WalletPayUCardElementUI.this.mBundle.putString("key_expire_data", WalletPayUCardElementUI.this.tSM.getText());
                WalletPayUCardElementUI.this.dOE().p(new Object[0]);
                AppMethodBeat.o(48363);
            }
        });
        ((TextView) findViewById(R.id.dm6)).setText(ae.dOc());
        this.tSQ = (TextView) findViewById(R.id.dm5);
        c.a(this, this.tSQ);
        AppMethodBeat.o(48365);
    }

    public void onResume() {
        AppMethodBeat.i(48366);
        super.onResume();
        this.tSR.cTc();
        AppMethodBeat.o(48366);
    }

    public final boolean c(int i, int i2, String str, m mVar) {
        AppMethodBeat.i(48367);
        if (mVar instanceof NetScenePayUElementQuery) {
            this.tSV.put(((NetScenePayUElementQuery) mVar).tSD, (PayUBankcardElement) this.mBundle.getParcelable("key_card_element"));
            this.tSR.cTc();
            this.tSW.remove(((NetScenePayUElementQuery) mVar).tSD);
            AppMethodBeat.o(48367);
            return true;
        }
        if ((mVar instanceof com.tencent.mm.plugin.wallet_payu.bind.model.a) && !(i == 0 && i2 == 0)) {
            this.tSL.setEncryptType(0);
        }
        AppMethodBeat.o(48367);
        return false;
    }

    public final int getLayoutId() {
        return R.layout.ak6;
    }

    public final void hY(boolean z) {
    }

    public final boolean cNR() {
        return true;
    }

    static /* synthetic */ void a(WalletPayUCardElementUI walletPayUCardElementUI, View view, Editable editable) {
        AppMethodBeat.i(48368);
        if (!(editable == null || editable.length() == 0)) {
            if (view.getId() == walletPayUCardElementUI.tSL.getId()) {
                walletPayUCardElementUI.tSS = true;
            } else if (view.getId() == walletPayUCardElementUI.tSN.getId()) {
                walletPayUCardElementUI.tSU = true;
            } else if (view.getId() == walletPayUCardElementUI.tSM.getId()) {
                walletPayUCardElementUI.tST = true;
            }
        }
        walletPayUCardElementUI.tSR.cTc();
        AppMethodBeat.o(48368);
    }
}
