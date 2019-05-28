package com.tencent.mm.plugin.wallet_payu.create.ui;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ai.m;
import com.tencent.mm.plugin.wallet_payu.a.c;
import com.tencent.mm.plugin.wallet_payu.create.a.d;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.base.MMFormMobileInputView;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.wallet_core.c.ae;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;

@a(3)
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

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    static /* synthetic */ void a(WalletPayUStartOpenUI walletPayUStartOpenUI) {
        AppMethodBeat.i(48402);
        walletPayUStartOpenUI.cTe();
        AppMethodBeat.o(48402);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(48397);
        super.onCreate(bundle);
        this.gDV = this.mBundle.getString("key_mobile");
        this.tTv = this.mBundle.getString("dial_code");
        if (bo.isNullOrNil(this.tTv)) {
            this.tTv = "27";
        }
        this.tTo = (WalletPayUOpenIntroView) findViewById(R.id.dmd);
        this.tTo.setPagerData(new d[]{new d(R.drawable.bef, R.string.fpp, R.string.fpj), new d(R.drawable.beg, R.string.fpq, R.string.fpk), new d(R.drawable.beh, R.string.fpr, R.string.fpl)});
        this.tTp = (MMFormMobileInputView) findViewById(R.id.dme);
        this.tTs = (Button) findViewById(R.id.b7r);
        this.tTq = this.tTp.getCountryCodeEditText();
        this.tTr = this.tTp.getMobileNumberEditText();
        if (!bo.isNullOrNil(this.gDV)) {
            this.tTr.setText(this.gDV);
        }
        if (!bo.isNullOrNil(this.tTv)) {
            this.tTq.setText(this.tTv);
        }
        AnonymousClass1 anonymousClass1 = new TextWatcher() {
            public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public final void afterTextChanged(Editable editable) {
                AppMethodBeat.i(48395);
                WalletPayUStartOpenUI.a(WalletPayUStartOpenUI.this);
                AppMethodBeat.o(48395);
            }
        };
        this.tTr.addTextChangedListener(anonymousClass1);
        this.tTq.addTextChangedListener(anonymousClass1);
        this.tTs.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(48396);
                if (WalletPayUStartOpenUI.this.tTp.getVisibility() == 0) {
                    WalletPayUStartOpenUI.this.mBundle.putString("key_mobile", WalletPayUStartOpenUI.this.gDV);
                    WalletPayUStartOpenUI.this.mBundle.putString("dial_code", WalletPayUStartOpenUI.this.tTv);
                }
                WalletPayUStartOpenUI.this.dOE().p(new Object[0]);
                AppMethodBeat.o(48396);
            }
        });
        this.tTt = (TextView) findViewById(R.id.dm5);
        c.a(this, this.tTt);
        this.tTu = (TextView) findViewById(R.id.dmf);
        this.tTu.setText(ae.dOc());
        AppMethodBeat.o(48397);
    }

    public void onResume() {
        AppMethodBeat.i(48398);
        super.onResume();
        cTe();
        AppMethodBeat.o(48398);
    }

    private String cNE() {
        AppMethodBeat.i(48399);
        String substring;
        if (this.tTp.getCountryCode().startsWith("+")) {
            substring = this.tTp.getCountryCode().substring(1);
            AppMethodBeat.o(48399);
            return substring;
        }
        substring = this.tTp.getCountryCode();
        AppMethodBeat.o(48399);
        return substring;
    }

    private boolean cTd() {
        AppMethodBeat.i(48400);
        if (bo.isNullOrNil(cNE()) || bo.isNullOrNil(this.tTr.getText().toString())) {
            AppMethodBeat.o(48400);
            return false;
        }
        AppMethodBeat.o(48400);
        return true;
    }

    private void cTe() {
        AppMethodBeat.i(48401);
        if (this.tTp.getVisibility() == 0) {
            if (cTd()) {
                this.tTv = cNE();
                this.gDV = this.tTp.getMobileNumber();
                this.tTs.setEnabled(true);
                AppMethodBeat.o(48401);
                return;
            }
            this.tTs.setEnabled(false);
        }
        AppMethodBeat.o(48401);
    }

    public final boolean cNR() {
        return true;
    }

    public final int getLayoutId() {
        return R.layout.ak_;
    }

    public final boolean c(int i, int i2, String str, m mVar) {
        return false;
    }
}
