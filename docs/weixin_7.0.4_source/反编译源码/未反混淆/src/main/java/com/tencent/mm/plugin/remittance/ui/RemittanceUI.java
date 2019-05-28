package com.tencent.mm.plugin.remittance.ui;

import android.os.Bundle;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ai.m;
import com.tencent.mm.g.a.fw;
import com.tencent.mm.g.a.uo;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.plugin.remittance.model.e;
import com.tencent.mm.plugin.remittance.model.v;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.wallet_core.c.ae;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.ad;
import com.tencent.mm.ui.base.t;
import com.tencent.mm.wallet_core.c.p;

public class RemittanceUI extends RemittanceBaseUI {
    protected String pWR;
    private String pWS;

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public final void cfz() {
        AppMethodBeat.i(45164);
        if (cfK()) {
            g.RQ();
            this.pRy = (String) g.RP().Ry().get(a.USERINFO_DELAY_TRANSFER_CONFIRM_WORDING_STRING, (Object) "");
            g.RQ();
            this.pRz = (String) g.RP().Ry().get(a.USERINFO_DELAY_TRANSFER_DESC_URL_STRING, (Object) "");
            g.RQ();
            this.pRA = ((Integer) g.RP().Ry().get(a.USERINFO_DELAY_TRANSFER_DESC_URL_FLAG_INT, Integer.valueOf(0))).intValue();
            if (bo.isNullOrNil(this.pRy) || bo.isNullOrNil(this.pRz)) {
                ae.a(true, null);
            } else {
                ae.a(false, null);
            }
            ab.d("MicroMsg.RemittanceUI", "do before transfer");
            a(new e(this.edV), false, false);
        }
        AppMethodBeat.o(45164);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(45165);
        super.onCreate(bundle);
        h.pYm.e(15386, Integer.valueOf(1), Integer.valueOf(1));
        nf(2783);
        AppMethodBeat.o(45165);
    }

    public final void a(String str, int i, String str2, String str3, String str4, String str5, String str6, fw fwVar) {
        AppMethodBeat.i(45166);
        if (this.pQU != null) {
            this.pQU.i(3, Integer.valueOf(this.pQY), Double.valueOf(this.pQV));
        }
        int intExtra = getIntent().getIntExtra("pay_channel", -1);
        String str7 = "";
        if (!bo.Q(new String[0])) {
            g.RQ();
            ad aoM = ((j) g.K(j.class)).XM().aoM(this.edV);
            if (aoM != null) {
                str7 = aoM.Oj();
            } else {
                ab.e("MicroMsg.RemittanceUI", "can not found contact for user::" + this.edV);
            }
        }
        if (bo.isNullOrNil(str6)) {
            this.pRH = true;
        } else {
            this.pRH = false;
        }
        ab.i("MicroMsg.RemittanceUI", "doSceneGenRemittance, channel: %s", Integer.valueOf(intExtra));
        int i2 = 0;
        if (bo.gW(this.cKs, 4)) {
            boolean C = bo.C(Double.valueOf(this.pRS), Double.valueOf(this.pQV));
            boolean isEqual = bo.isEqual(this.pRT, str);
            boolean isEqual2 = bo.isEqual(this.pRU, str4);
            if (!C) {
                i2 = 1;
            }
            if (!isEqual) {
                i2 |= 2;
            }
            if (!isEqual2) {
                i2 |= 4;
            }
        }
        m vVar = new v(this.pQV, "1", this.edV, this.pRx, this.pQY, this.gOW, str, i, str2, str3, str4, str5, this.pRb, intExtra, this.pRC, str6, this.pQW, str7, this.pRx, fwVar, this.pRE, this.pRD, this.pWR, this.pWS, this.cKs, this.pRV, i2);
        vVar.eHT = "RemittanceProcess";
        a(vVar, true, true);
        this.pRE = "";
        AppMethodBeat.o(45166);
    }

    public final boolean c(int i, int i2, String str, m mVar) {
        AppMethodBeat.i(45167);
        if (mVar instanceof e) {
            final e eVar = (e) mVar;
            eVar.pOI.vWX = false;
            eVar.a(new p.a() {
                public final void e(int i, int i2, String str, m mVar) {
                    AppMethodBeat.i(45162);
                    ab.d("MicroMsg.RemittanceUI", "mask_name: %s truename_extend %s", eVar.pOI.vWW, eVar.pOI.pWR);
                    RemittanceUI.this.pRx = eVar.pOI.vWW;
                    RemittanceUI.this.pWR = eVar.pOI.pWR;
                    RemittanceUI.this.pRa = eVar.pOI.vWX;
                    RemittanceUI.this.pWS = eVar.pOI.pWS;
                    RemittanceUI.this.cfH();
                    AppMethodBeat.o(45162);
                }
            }).b(new p.a() {
                public final void e(int i, int i2, String str, m mVar) {
                    AppMethodBeat.i(45161);
                    ab.d("MicroMsg.RemittanceUI", "before transfer: %s, %s, %s", Integer.valueOf(i), Integer.valueOf(i2), str);
                    AppMethodBeat.o(45161);
                }
            }).c(new p.a() {
                public final void e(int i, int i2, String str, m mVar) {
                    AppMethodBeat.i(45160);
                    ab.e("MicroMsg.RemittanceUI", "net error: %s", eVar);
                    AppMethodBeat.o(45160);
                }
            });
            AppMethodBeat.o(45167);
            return true;
        }
        boolean c = super.c(i, i2, str, mVar);
        AppMethodBeat.o(45167);
        return c;
    }

    public void onDestroy() {
        AppMethodBeat.i(45169);
        super.onDestroy();
        ng(2783);
        AppMethodBeat.o(45169);
    }

    public final void cfG() {
        AppMethodBeat.i(45170);
        final uo uoVar = new uo();
        uoVar.cQJ.cQL = "7";
        uoVar.callback = new Runnable() {
            public final void run() {
                AppMethodBeat.i(45163);
                if (bo.isNullOrNil(uoVar.cQK.cQM)) {
                    ab.i("MicroMsg.RemittanceUI", "no bulletin data");
                    AppMethodBeat.o(45163);
                    return;
                }
                com.tencent.mm.wallet_core.ui.e.a((TextView) RemittanceUI.this.findViewById(R.id.a2f), uoVar.cQK.cQM, uoVar.cQK.content, uoVar.cQK.url);
                AppMethodBeat.o(45163);
            }
        };
        com.tencent.mm.sdk.b.a.xxA.m(uoVar);
        AppMethodBeat.o(45170);
    }

    public final void cfC() {
        AppMethodBeat.i(45168);
        t.makeText(this.mController.ylL, R.string.dnj, 0).show();
        AppMethodBeat.o(45168);
    }
}
