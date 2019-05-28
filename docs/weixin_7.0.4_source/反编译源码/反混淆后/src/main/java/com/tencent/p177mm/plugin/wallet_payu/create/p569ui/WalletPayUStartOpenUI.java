package com.tencent.p177mm.plugin.wallet_payu.create.p569ui;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p612ui.base.C5271a;
import com.tencent.p177mm.p612ui.base.MMFormMobileInputView;
import com.tencent.p177mm.plugin.wallet_payu.create.p1317a.C40158d;
import com.tencent.p177mm.plugin.wallet_payu.p1561a.C43822c;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.wallet_core.p649c.C44423ae;
import com.tencent.p177mm.wallet_core.p650ui.WalletBaseUI;

@C5271a(3)
/* renamed from: com.tencent.mm.plugin.wallet_payu.create.ui.WalletPayUStartOpenUI */
public class WalletPayUStartOpenUI extends WalletBaseUI {
    private String gDV;
    private WalletPayUOpenIntroView tTo;
    private MMFormMobileInputView tTp;
    private EditText tTq;
    private EditText tTr;
    private Button tTs;
    private TextView tTt;
    private TextView tTu;
    private String tTv;

    /* renamed from: com.tencent.mm.plugin.wallet_payu.create.ui.WalletPayUStartOpenUI$1 */
    class C143631 implements TextWatcher {
        C143631() {
        }

        public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public final void afterTextChanged(Editable editable) {
            AppMethodBeat.m2504i(48395);
            WalletPayUStartOpenUI.m87231a(WalletPayUStartOpenUI.this);
            AppMethodBeat.m2505o(48395);
        }
    }

    /* renamed from: com.tencent.mm.plugin.wallet_payu.create.ui.WalletPayUStartOpenUI$2 */
    class C143642 implements OnClickListener {
        C143642() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(48396);
            if (WalletPayUStartOpenUI.this.tTp.getVisibility() == 0) {
                WalletPayUStartOpenUI.this.mBundle.putString("key_mobile", WalletPayUStartOpenUI.this.gDV);
                WalletPayUStartOpenUI.this.mBundle.putString("dial_code", WalletPayUStartOpenUI.this.tTv);
            }
            WalletPayUStartOpenUI.this.dOE().mo9366p(new Object[0]);
            AppMethodBeat.m2505o(48396);
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    /* renamed from: a */
    static /* synthetic */ void m87231a(WalletPayUStartOpenUI walletPayUStartOpenUI) {
        AppMethodBeat.m2504i(48402);
        walletPayUStartOpenUI.cTe();
        AppMethodBeat.m2505o(48402);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(48397);
        super.onCreate(bundle);
        this.gDV = this.mBundle.getString("key_mobile");
        this.tTv = this.mBundle.getString("dial_code");
        if (C5046bo.isNullOrNil(this.tTv)) {
            this.tTv = "27";
        }
        this.tTo = (WalletPayUOpenIntroView) findViewById(2131826514);
        this.tTo.setPagerData(new C40158d[]{new C40158d(C25738R.drawable.bef, C25738R.string.fpp, C25738R.string.fpj), new C40158d(C25738R.drawable.beg, C25738R.string.fpq, C25738R.string.fpk), new C40158d(C25738R.drawable.beh, C25738R.string.fpr, C25738R.string.fpl)});
        this.tTp = (MMFormMobileInputView) findViewById(2131826515);
        this.tTs = (Button) findViewById(2131823199);
        this.tTq = this.tTp.getCountryCodeEditText();
        this.tTr = this.tTp.getMobileNumberEditText();
        if (!C5046bo.isNullOrNil(this.gDV)) {
            this.tTr.setText(this.gDV);
        }
        if (!C5046bo.isNullOrNil(this.tTv)) {
            this.tTq.setText(this.tTv);
        }
        C143631 c143631 = new C143631();
        this.tTr.addTextChangedListener(c143631);
        this.tTq.addTextChangedListener(c143631);
        this.tTs.setOnClickListener(new C143642());
        this.tTt = (TextView) findViewById(2131826505);
        C43822c.m78564a(this, this.tTt);
        this.tTu = (TextView) findViewById(2131826516);
        this.tTu.setText(C44423ae.dOc());
        AppMethodBeat.m2505o(48397);
    }

    public void onResume() {
        AppMethodBeat.m2504i(48398);
        super.onResume();
        cTe();
        AppMethodBeat.m2505o(48398);
    }

    private String cNE() {
        AppMethodBeat.m2504i(48399);
        String substring;
        if (this.tTp.getCountryCode().startsWith("+")) {
            substring = this.tTp.getCountryCode().substring(1);
            AppMethodBeat.m2505o(48399);
            return substring;
        }
        substring = this.tTp.getCountryCode();
        AppMethodBeat.m2505o(48399);
        return substring;
    }

    private boolean cTd() {
        AppMethodBeat.m2504i(48400);
        if (C5046bo.isNullOrNil(cNE()) || C5046bo.isNullOrNil(this.tTr.getText().toString())) {
            AppMethodBeat.m2505o(48400);
            return false;
        }
        AppMethodBeat.m2505o(48400);
        return true;
    }

    private void cTe() {
        AppMethodBeat.m2504i(48401);
        if (this.tTp.getVisibility() == 0) {
            if (cTd()) {
                this.tTv = cNE();
                this.gDV = this.tTp.getMobileNumber();
                this.tTs.setEnabled(true);
                AppMethodBeat.m2505o(48401);
                return;
            }
            this.tTs.setEnabled(false);
        }
        AppMethodBeat.m2505o(48401);
    }

    public final boolean cNR() {
        return true;
    }

    public final int getLayoutId() {
        return 2130970356;
    }

    /* renamed from: c */
    public final boolean mo7885c(int i, int i2, String str, C1207m c1207m) {
        return false;
    }
}
