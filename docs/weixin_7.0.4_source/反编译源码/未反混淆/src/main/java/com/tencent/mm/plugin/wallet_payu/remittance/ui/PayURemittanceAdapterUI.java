package com.tencent.mm.plugin.wallet_payu.remittance.ui;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.o;
import com.tencent.mm.ai.m;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ao;
import com.tencent.mm.model.ao.b;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.plugin.remittance.ui.RemittanceAdapterUI;
import com.tencent.mm.plugin.wallet_payu.remittance.a.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.wallet_core.ui.e;

@a(7)
public class PayURemittanceAdapterUI extends RemittanceAdapterUI {
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public final void cfy() {
        AppMethodBeat.i(48539);
        a(new d(this.edV), false, false);
        AppMethodBeat.o(48539);
    }

    public final boolean c(int i, int i2, String str, m mVar) {
        AppMethodBeat.i(48540);
        super.c(i, i2, str, mVar);
        if (mVar instanceof d) {
            this.pQP = false;
        }
        if (i == 0 && i2 == 0 && (mVar instanceof d)) {
            final d dVar = (d) mVar;
            this.edV = dVar.username;
            if (bo.isNullOrNil(this.edV)) {
                ab.d("MicroMsg.PayURemittanceAdapterUI", "Username empty & fishsh. scene=" + this.gOW);
                finish();
                AppMethodBeat.o(48540);
                return true;
            }
            final Intent intent = new Intent();
            intent.putExtra("fee", dVar.kCJ);
            intent.putExtra("desc", dVar.desc);
            intent.putExtra("scan_remittance_id", dVar.pPQ);
            intent.putExtra("receiver_true_name", e.att(dVar.pPP));
            g.RQ();
            if (((j) g.K(j.class)).XM().aoN(this.edV) != null) {
                c(this.edV, dVar.scene, intent);
            } else {
                ab.d("MicroMsg.PayURemittanceAdapterUI", "Receiver in contactStg and try to get contact");
                final long anU = bo.anU();
                ao.a.flu.a(this.edV, "", new b.a() {
                    public final void o(String str, boolean z) {
                        AppMethodBeat.i(48538);
                        if (z) {
                            ab.v("MicroMsg.PayURemittanceAdapterUI", "getContact suc; cost=" + (bo.anU() - anU) + " ms");
                            com.tencent.mm.ah.b.U(str, 3);
                            o.acv().pZ(str);
                        } else {
                            ab.w("MicroMsg.PayURemittanceAdapterUI", "getContact failed");
                        }
                        PayURemittanceAdapterUI.this.c(PayURemittanceAdapterUI.this.edV, dVar.scene, intent);
                        AppMethodBeat.o(48538);
                    }
                });
            }
            AppMethodBeat.o(48540);
            return true;
        }
        AppMethodBeat.o(48540);
        return false;
    }

    public final void c(String str, int i, Intent intent) {
        Intent intent2;
        AppMethodBeat.i(48541);
        ab.i("MicroMsg.PayURemittanceAdapterUI", "startRemittanceUI scene=" + this.gOW + ", name=" + str);
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
        AppMethodBeat.o(48541);
    }
}
