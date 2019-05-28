package com.tencent.mm.plugin.wallet_payu.remittance.ui;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ai.m;
import com.tencent.mm.plugin.remittance.ui.RemittanceResendMsgUI;
import com.tencent.mm.plugin.wallet_payu.remittance.a.f;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.base.h;

@a(3)
public class PayURemittanceResendMsgUI extends RemittanceResendMsgUI {
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(48562);
        super.onCreate(bundle);
        AppMethodBeat.o(48562);
    }

    public final void f(String str, String str2, String str3, int i, int i2) {
        AppMethodBeat.i(48563);
        a(new f(str, getIntent().getIntExtra("total_fee", 0), getIntent().getStringExtra("fee_type"), str3, i), true, true);
        AppMethodBeat.o(48563);
    }

    public final boolean c(int i, int i2, String str, m mVar) {
        AppMethodBeat.i(48564);
        if (!(mVar instanceof f)) {
            AppMethodBeat.o(48564);
            return false;
        } else if (i == 0 && i2 == 0) {
            h.bQ(this, getString(R.string.dq5));
            finish();
            AppMethodBeat.o(48564);
            return true;
        } else {
            h.bQ(this, str);
            finish();
            AppMethodBeat.o(48564);
            return true;
        }
    }
}
