package com.tencent.p177mm.plugin.wallet_payu.remittance.p1056ui;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.p612ui.base.C5271a;
import com.tencent.p177mm.plugin.remittance.p497ui.RemittanceResendMsgUI;
import com.tencent.p177mm.plugin.wallet_payu.remittance.p1055a.C43828f;

@C5271a(3)
/* renamed from: com.tencent.mm.plugin.wallet_payu.remittance.ui.PayURemittanceResendMsgUI */
public class PayURemittanceResendMsgUI extends RemittanceResendMsgUI {
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(48562);
        super.onCreate(bundle);
        AppMethodBeat.m2505o(48562);
    }

    /* renamed from: f */
    public final void mo26637f(String str, String str2, String str3, int i, int i2) {
        AppMethodBeat.m2504i(48563);
        mo39970a(new C43828f(str, getIntent().getIntExtra("total_fee", 0), getIntent().getStringExtra("fee_type"), str3, i), true, true);
        AppMethodBeat.m2505o(48563);
    }

    /* renamed from: c */
    public final boolean mo7885c(int i, int i2, String str, C1207m c1207m) {
        AppMethodBeat.m2504i(48564);
        if (!(c1207m instanceof C43828f)) {
            AppMethodBeat.m2505o(48564);
            return false;
        } else if (i == 0 && i2 == 0) {
            C30379h.m48465bQ(this, getString(C25738R.string.dq5));
            finish();
            AppMethodBeat.m2505o(48564);
            return true;
        } else {
            C30379h.m48465bQ(this, str);
            finish();
            AppMethodBeat.m2505o(48564);
            return true;
        }
    }
}
