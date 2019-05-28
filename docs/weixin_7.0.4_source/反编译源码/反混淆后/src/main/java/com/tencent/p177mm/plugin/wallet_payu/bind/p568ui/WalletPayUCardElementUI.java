package com.tencent.p177mm.plugin.wallet_payu.bind.p568ui;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.p612ui.base.C5271a;
import com.tencent.p177mm.plugin.wallet_payu.bind.model.C14358a;
import com.tencent.p177mm.plugin.wallet_payu.bind.model.NetScenePayUElementQuery;
import com.tencent.p177mm.plugin.wallet_payu.bind.model.NetScenePayUElementQuery.PayUBankcardElement;
import com.tencent.p177mm.plugin.wallet_payu.p1561a.C43822c;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.wallet_core.p649c.C44423ae;
import com.tencent.p177mm.wallet_core.p650ui.WalletBaseUI;
import com.tencent.p177mm.wallet_core.p650ui.formview.C30890a;
import com.tencent.p177mm.wallet_core.p650ui.formview.WalletFormView;
import com.tencent.p177mm.wallet_core.p650ui.formview.WalletFormView.C36397a;
import java.util.HashMap;
import java.util.HashSet;

@C5271a(19)
/* renamed from: com.tencent.mm.plugin.wallet_payu.bind.ui.WalletPayUCardElementUI */
public class WalletPayUCardElementUI extends WalletBaseUI implements C36397a {
    private Button gHn;
    private WalletFormView tSL;
    WalletFormView tSM;
    private WalletFormView tSN;
    private TextView tSO;
    private TextView tSP;
    private TextView tSQ;
    private C4490b tSR;
    private boolean tSS = false;
    private boolean tST = false;
    private boolean tSU = false;
    private HashMap<String, PayUBankcardElement> tSV = null;
    private HashSet<String> tSW = null;

    /* renamed from: com.tencent.mm.plugin.wallet_payu.bind.ui.WalletPayUCardElementUI$1 */
    class C44891 extends C4491a {
        C44891() {
            super(WalletPayUCardElementUI.this, (byte) 0);
        }

        public final void afterTextChanged(Editable editable) {
            AppMethodBeat.m2504i(48360);
            WalletPayUCardElementUI.m6866a(WalletPayUCardElementUI.this, WalletPayUCardElementUI.this.tSN, editable);
            AppMethodBeat.m2505o(48360);
        }
    }

    /* renamed from: com.tencent.mm.plugin.wallet_payu.bind.ui.WalletPayUCardElementUI$b */
    protected class C4490b {
        boolean tSY;
        boolean tSZ;
        boolean tTa;

        protected C4490b() {
        }

        /* Access modifiers changed, original: protected|final */
        public final void cTc() {
            AppMethodBeat.m2504i(48364);
            this.tSY = WalletPayUCardElementUI.this.tSL.asa();
            this.tSZ = WalletPayUCardElementUI.this.tSM.asa();
            this.tTa = WalletPayUCardElementUI.this.tSN.asa();
            if (!WalletPayUCardElementUI.this.tSU || this.tTa) {
                WalletPayUCardElementUI.this.tSP.setVisibility(4);
            } else {
                WalletPayUCardElementUI.this.tSP.setVisibility(0);
                WalletPayUCardElementUI.this.tSP.setText(C25738R.string.fav);
            }
            boolean z;
            int z2;
            if (!WalletPayUCardElementUI.this.tSS) {
                z2 = false;
            } else if (!this.tSY) {
                WalletPayUCardElementUI.this.tSO.setVisibility(0);
                WalletPayUCardElementUI.this.tSO.setTextColor(WalletPayUCardElementUI.this.getResources().getColor(C25738R.color.f12266xy));
                WalletPayUCardElementUI.this.tSO.setText(C25738R.string.fah);
                z2 = 0;
            } else if (!WalletPayUCardElementUI.this.tSV.containsKey(WalletPayUCardElementUI.this.tSL.getText()) || WalletPayUCardElementUI.this.tSW.contains(WalletPayUCardElementUI.this.tSL.getText())) {
                WalletPayUCardElementUI.this.mo39970a(new NetScenePayUElementQuery(WalletPayUCardElementUI.this.tSL.getText()), false, false);
                WalletPayUCardElementUI.this.tSW.add(WalletPayUCardElementUI.this.tSL.getText());
                WalletPayUCardElementUI.this.tSO.setVisibility(0);
                WalletPayUCardElementUI.this.tSO.setTextColor(WalletPayUCardElementUI.this.getResources().getColor(C25738R.color.f12092s0));
                WalletPayUCardElementUI.this.tSO.setText(WalletPayUCardElementUI.this.getString(C25738R.string.f_x));
                z2 = true;
            } else {
                PayUBankcardElement payUBankcardElement = (PayUBankcardElement) WalletPayUCardElementUI.this.tSV.get(WalletPayUCardElementUI.this.tSL.getText());
                WalletPayUCardElementUI.this.tSO.setVisibility(0);
                if (C5046bo.isNullOrNil(payUBankcardElement.tSG)) {
                    WalletPayUCardElementUI.this.tSO.setTextColor(WalletPayUCardElementUI.this.getResources().getColor(C25738R.color.f12266xy));
                    WalletPayUCardElementUI.this.tSO.setText(payUBankcardElement.tSH);
                    this.tSY = false;
                    z2 = 0;
                } else {
                    WalletPayUCardElementUI.this.tSO.setTextColor(WalletPayUCardElementUI.this.getResources().getColor(C25738R.color.f12092s0));
                    WalletPayUCardElementUI.this.tSO.setText(payUBankcardElement.tSH);
                    z2 = 0;
                }
            }
            if (this.tSY && this.tSZ && this.tTa && z2 == 0) {
                WalletPayUCardElementUI.this.gHn.setEnabled(true);
                AppMethodBeat.m2505o(48364);
                return;
            }
            WalletPayUCardElementUI.this.gHn.setEnabled(false);
            AppMethodBeat.m2505o(48364);
        }
    }

    /* renamed from: com.tencent.mm.plugin.wallet_payu.bind.ui.WalletPayUCardElementUI$a */
    abstract class C4491a implements TextWatcher {
        private C4491a() {
        }

        /* synthetic */ C4491a(WalletPayUCardElementUI walletPayUCardElementUI, byte b) {
            this();
        }

        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }
    }

    /* renamed from: com.tencent.mm.plugin.wallet_payu.bind.ui.WalletPayUCardElementUI$3 */
    class C44923 extends C4491a {
        C44923() {
            super(WalletPayUCardElementUI.this, (byte) 0);
        }

        public final void afterTextChanged(Editable editable) {
            AppMethodBeat.m2504i(48362);
            WalletPayUCardElementUI.m6866a(WalletPayUCardElementUI.this, WalletPayUCardElementUI.this.tSL, editable);
            AppMethodBeat.m2505o(48362);
        }
    }

    /* renamed from: com.tencent.mm.plugin.wallet_payu.bind.ui.WalletPayUCardElementUI$4 */
    class C44934 implements OnClickListener {
        C44934() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(48363);
            PayUBankcardElement payUBankcardElement = (PayUBankcardElement) WalletPayUCardElementUI.this.tSV.get(WalletPayUCardElementUI.this.tSL.getText());
            if (payUBankcardElement == null) {
                C4990ab.m7412e("MicroMsg.WalletPayUCardElementUI", "hy: should not be NULL!!!");
                AppMethodBeat.m2505o(48363);
                return;
            }
            WalletPayUCardElementUI.this.tSL.setEncryptType(50);
            WalletPayUCardElementUI.this.mBundle.putParcelable("key_card_element", payUBankcardElement);
            WalletPayUCardElementUI.this.mBundle.putString("key_card_id", WalletPayUCardElementUI.this.tSL.getText());
            WalletPayUCardElementUI.this.mBundle.putString("key_cvv", WalletPayUCardElementUI.this.tSN.getText());
            WalletPayUCardElementUI.this.mBundle.putString("key_expire_data", WalletPayUCardElementUI.this.tSM.getText());
            WalletPayUCardElementUI.this.dOE().mo9366p(new Object[0]);
            AppMethodBeat.m2505o(48363);
        }
    }

    /* renamed from: com.tencent.mm.plugin.wallet_payu.bind.ui.WalletPayUCardElementUI$2 */
    class C44942 extends C4491a {
        C44942() {
            super(WalletPayUCardElementUI.this, (byte) 0);
        }

        public final void afterTextChanged(Editable editable) {
            AppMethodBeat.m2504i(48361);
            WalletPayUCardElementUI.m6866a(WalletPayUCardElementUI.this, WalletPayUCardElementUI.this.tSM, editable);
            AppMethodBeat.m2505o(48361);
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(48365);
        super.onCreate(bundle);
        this.tSR = new C4490b();
        this.tSV = new HashMap();
        this.tSW = new HashSet();
        this.tSL = (WalletFormView) findViewById(2131826500);
        C30890a.m49294b(this.tSL);
        this.tSM = (WalletFormView) findViewById(2131826504);
        C30890a.m49290a((MMActivity) this, this.tSM);
        this.tSN = (WalletFormView) findViewById(2131826502);
        C30890a.m49293b(this, this.tSN);
        this.tSO = (TextView) findViewById(2131826501);
        this.tSP = (TextView) findViewById(2131826503);
        this.gHn = (Button) findViewById(2131822846);
        mo39989e(this.tSL, 0, false);
        mo39989e(this.tSN, 0, false);
        this.tSL.setOnInputValidChangeListener(this);
        this.tSN.setOnInputValidChangeListener(this);
        this.tSM.setOnInputValidChangeListener(this);
        this.tSL.setEncryptType(0);
        this.tSN.mo64594a(new C44891());
        this.tSM.mo64594a(new C44942());
        this.tSL.mo64594a(new C44923());
        this.gHn.setOnClickListener(new C44934());
        ((TextView) findViewById(2131826506)).setText(C44423ae.dOc());
        this.tSQ = (TextView) findViewById(2131826505);
        C43822c.m78564a(this, this.tSQ);
        AppMethodBeat.m2505o(48365);
    }

    public void onResume() {
        AppMethodBeat.m2504i(48366);
        super.onResume();
        this.tSR.cTc();
        AppMethodBeat.m2505o(48366);
    }

    /* renamed from: c */
    public final boolean mo7885c(int i, int i2, String str, C1207m c1207m) {
        AppMethodBeat.m2504i(48367);
        if (c1207m instanceof NetScenePayUElementQuery) {
            this.tSV.put(((NetScenePayUElementQuery) c1207m).tSD, (PayUBankcardElement) this.mBundle.getParcelable("key_card_element"));
            this.tSR.cTc();
            this.tSW.remove(((NetScenePayUElementQuery) c1207m).tSD);
            AppMethodBeat.m2505o(48367);
            return true;
        }
        if ((c1207m instanceof C14358a) && !(i == 0 && i2 == 0)) {
            this.tSL.setEncryptType(0);
        }
        AppMethodBeat.m2505o(48367);
        return false;
    }

    public final int getLayoutId() {
        return 2130970352;
    }

    /* renamed from: hY */
    public final void mo9407hY(boolean z) {
    }

    public final boolean cNR() {
        return true;
    }

    /* renamed from: a */
    static /* synthetic */ void m6866a(WalletPayUCardElementUI walletPayUCardElementUI, View view, Editable editable) {
        AppMethodBeat.m2504i(48368);
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
        AppMethodBeat.m2505o(48368);
    }
}
