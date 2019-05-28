package com.tencent.p177mm.plugin.wallet_payu.remittance.p1056ui;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C26415ao.C26417a;
import com.tencent.p177mm.model.C26415ao.C9635b.C9636a;
import com.tencent.p177mm.p182ah.C17884o;
import com.tencent.p177mm.p182ah.C41730b;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p612ui.base.C5271a;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.C6982j;
import com.tencent.p177mm.plugin.remittance.p497ui.RemittanceAdapterUI;
import com.tencent.p177mm.plugin.wallet_payu.remittance.p1055a.C46386d;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.wallet_core.p650ui.C36391e;

@C5271a(7)
/* renamed from: com.tencent.mm.plugin.wallet_payu.remittance.ui.PayURemittanceAdapterUI */
public class PayURemittanceAdapterUI extends RemittanceAdapterUI {
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public final void cfy() {
        AppMethodBeat.m2504i(48539);
        mo39970a(new C46386d(this.edV), false, false);
        AppMethodBeat.m2505o(48539);
    }

    /* renamed from: c */
    public final boolean mo7885c(int i, int i2, String str, C1207m c1207m) {
        AppMethodBeat.m2504i(48540);
        super.mo7885c(i, i2, str, c1207m);
        if (c1207m instanceof C46386d) {
            this.pQP = false;
        }
        if (i == 0 && i2 == 0 && (c1207m instanceof C46386d)) {
            final C46386d c46386d = (C46386d) c1207m;
            this.edV = c46386d.username;
            if (C5046bo.isNullOrNil(this.edV)) {
                C4990ab.m7410d("MicroMsg.PayURemittanceAdapterUI", "Username empty & fishsh. scene=" + this.gOW);
                finish();
                AppMethodBeat.m2505o(48540);
                return true;
            }
            final Intent intent = new Intent();
            intent.putExtra("fee", c46386d.kCJ);
            intent.putExtra("desc", c46386d.desc);
            intent.putExtra("scan_remittance_id", c46386d.pPQ);
            intent.putExtra("receiver_true_name", C36391e.att(c46386d.pPP));
            C1720g.m3537RQ();
            if (((C6982j) C1720g.m3528K(C6982j.class)).mo15369XM().aoN(this.edV) != null) {
                mo25089c(this.edV, c46386d.scene, intent);
            } else {
                C4990ab.m7410d("MicroMsg.PayURemittanceAdapterUI", "Receiver in contactStg and try to get contact");
                final long anU = C5046bo.anU();
                C26417a.flu.mo20966a(this.edV, "", new C9636a() {
                    /* renamed from: o */
                    public final void mo6218o(String str, boolean z) {
                        AppMethodBeat.m2504i(48538);
                        if (z) {
                            C4990ab.m7418v("MicroMsg.PayURemittanceAdapterUI", "getContact suc; cost=" + (C5046bo.anU() - anU) + " ms");
                            C41730b.m73489U(str, 3);
                            C17884o.acv().mo67495pZ(str);
                        } else {
                            C4990ab.m7420w("MicroMsg.PayURemittanceAdapterUI", "getContact failed");
                        }
                        PayURemittanceAdapterUI.this.mo25089c(PayURemittanceAdapterUI.this.edV, c46386d.scene, intent);
                        AppMethodBeat.m2505o(48538);
                    }
                });
            }
            AppMethodBeat.m2505o(48540);
            return true;
        }
        AppMethodBeat.m2505o(48540);
        return false;
    }

    /* renamed from: c */
    public final void mo25089c(String str, int i, Intent intent) {
        Intent intent2;
        AppMethodBeat.m2504i(48541);
        C4990ab.m7416i("MicroMsg.PayURemittanceAdapterUI", "startRemittanceUI scene=" + this.gOW + ", name=" + str);
        if (intent != null) {
            intent2 = new Intent(intent);
        } else {
            intent2 = new Intent();
        }
        intent2.putExtra("receiver_name", str);
        intent2.putExtra("scene", this.gOW);
        intent2.putExtra("pay_scene", i);
        startActivity(intent2);
        setResult(-1);
        finish();
        AppMethodBeat.m2505o(48541);
    }
}
