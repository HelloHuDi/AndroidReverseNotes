package com.tencent.p177mm.plugin.remittance.p497ui;

import android.os.Bundle;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p230g.p231a.C37719fw;
import com.tencent.p177mm.p230g.p231a.C37807uo;
import com.tencent.p177mm.p612ui.base.C23639t;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.C6982j;
import com.tencent.p177mm.plugin.remittance.model.C39603v;
import com.tencent.p177mm.plugin.remittance.model.C46174e;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.plugin.wallet_core.p749c.C14224ae;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.C5128ac.C5127a;
import com.tencent.p177mm.storage.C7616ad;
import com.tencent.p177mm.wallet_core.p649c.C44428p.C40929a;
import com.tencent.p177mm.wallet_core.p650ui.C36391e;

/* renamed from: com.tencent.mm.plugin.remittance.ui.RemittanceUI */
public class RemittanceUI extends RemittanceBaseUI {
    protected String pWR;
    private String pWS;

    /* renamed from: com.tencent.mm.plugin.remittance.ui.RemittanceUI$2 */
    class C131062 implements C40929a {
        C131062() {
        }

        /* renamed from: e */
        public final void mo7656e(int i, int i2, String str, C1207m c1207m) {
            AppMethodBeat.m2504i(45161);
            C4990ab.m7411d("MicroMsg.RemittanceUI", "before transfer: %s, %s, %s", Integer.valueOf(i), Integer.valueOf(i2), str);
            AppMethodBeat.m2505o(45161);
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public final void cfz() {
        AppMethodBeat.m2504i(45164);
        if (cfK()) {
            C1720g.m3537RQ();
            this.pRy = (String) C1720g.m3536RP().mo5239Ry().get(C5127a.USERINFO_DELAY_TRANSFER_CONFIRM_WORDING_STRING, (Object) "");
            C1720g.m3537RQ();
            this.pRz = (String) C1720g.m3536RP().mo5239Ry().get(C5127a.USERINFO_DELAY_TRANSFER_DESC_URL_STRING, (Object) "");
            C1720g.m3537RQ();
            this.pRA = ((Integer) C1720g.m3536RP().mo5239Ry().get(C5127a.USERINFO_DELAY_TRANSFER_DESC_URL_FLAG_INT, Integer.valueOf(0))).intValue();
            if (C5046bo.isNullOrNil(this.pRy) || C5046bo.isNullOrNil(this.pRz)) {
                C14224ae.m22423a(true, null);
            } else {
                C14224ae.m22423a(false, null);
            }
            C4990ab.m7410d("MicroMsg.RemittanceUI", "do before transfer");
            mo39970a(new C46174e(this.edV), false, false);
        }
        AppMethodBeat.m2505o(45164);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(45165);
        super.onCreate(bundle);
        C7060h.pYm.mo8381e(15386, Integer.valueOf(1), Integer.valueOf(1));
        mo39992nf(2783);
        AppMethodBeat.m2505o(45165);
    }

    /* renamed from: a */
    public final void mo37144a(String str, int i, String str2, String str3, String str4, String str5, String str6, C37719fw c37719fw) {
        AppMethodBeat.m2504i(45166);
        if (this.pQU != null) {
            this.pQU.mo63380i(3, Integer.valueOf(this.pQY), Double.valueOf(this.pQV));
        }
        int intExtra = getIntent().getIntExtra("pay_channel", -1);
        String str7 = "";
        if (!C5046bo.m7510Q(new String[0])) {
            C1720g.m3537RQ();
            C7616ad aoM = ((C6982j) C1720g.m3528K(C6982j.class)).mo15369XM().aoM(this.edV);
            if (aoM != null) {
                str7 = aoM.mo16707Oj();
            } else {
                C4990ab.m7412e("MicroMsg.RemittanceUI", "can not found contact for user::" + this.edV);
            }
        }
        if (C5046bo.isNullOrNil(str6)) {
            this.pRH = true;
        } else {
            this.pRH = false;
        }
        C4990ab.m7417i("MicroMsg.RemittanceUI", "doSceneGenRemittance, channel: %s", Integer.valueOf(intExtra));
        int i2 = 0;
        if (C5046bo.m7563gW(this.cKs, 4)) {
            boolean C = C5046bo.m7500C(Double.valueOf(this.pRS), Double.valueOf(this.pQV));
            boolean isEqual = C5046bo.isEqual(this.pRT, str);
            boolean isEqual2 = C5046bo.isEqual(this.pRU, str4);
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
        C1207m c39603v = new C39603v(this.pQV, "1", this.edV, this.pRx, this.pQY, this.gOW, str, i, str2, str3, str4, str5, this.pRb, intExtra, this.pRC, str6, this.pQW, str7, this.pRx, c37719fw, this.pRE, this.pRD, this.pWR, this.pWS, this.cKs, this.pRV, i2);
        c39603v.eHT = "RemittanceProcess";
        mo39970a(c39603v, true, true);
        this.pRE = "";
        AppMethodBeat.m2505o(45166);
    }

    /* renamed from: c */
    public final boolean mo7885c(int i, int i2, String str, C1207m c1207m) {
        AppMethodBeat.m2504i(45167);
        if (c1207m instanceof C46174e) {
            final C46174e c46174e = (C46174e) c1207m;
            c46174e.pOI.vWX = false;
            c46174e.mo70318a(new C40929a() {
                /* renamed from: e */
                public final void mo7656e(int i, int i2, String str, C1207m c1207m) {
                    AppMethodBeat.m2504i(45162);
                    C4990ab.m7411d("MicroMsg.RemittanceUI", "mask_name: %s truename_extend %s", c46174e.pOI.vWW, c46174e.pOI.pWR);
                    RemittanceUI.this.pRx = c46174e.pOI.vWW;
                    RemittanceUI.this.pWR = c46174e.pOI.pWR;
                    RemittanceUI.this.pRa = c46174e.pOI.vWX;
                    RemittanceUI.this.pWS = c46174e.pOI.pWS;
                    RemittanceUI.this.cfH();
                    AppMethodBeat.m2505o(45162);
                }
            }).mo70319b(new C131062()).mo70320c(new C40929a() {
                /* renamed from: e */
                public final void mo7656e(int i, int i2, String str, C1207m c1207m) {
                    AppMethodBeat.m2504i(45160);
                    C4990ab.m7413e("MicroMsg.RemittanceUI", "net error: %s", c46174e);
                    AppMethodBeat.m2505o(45160);
                }
            });
            AppMethodBeat.m2505o(45167);
            return true;
        }
        boolean c = super.mo7885c(i, i2, str, c1207m);
        AppMethodBeat.m2505o(45167);
        return c;
    }

    public void onDestroy() {
        AppMethodBeat.m2504i(45169);
        super.onDestroy();
        mo39993ng(2783);
        AppMethodBeat.m2505o(45169);
    }

    public final void cfG() {
        AppMethodBeat.m2504i(45170);
        final C37807uo c37807uo = new C37807uo();
        c37807uo.cQJ.cQL = "7";
        c37807uo.callback = new Runnable() {
            public final void run() {
                AppMethodBeat.m2504i(45163);
                if (C5046bo.isNullOrNil(c37807uo.cQK.cQM)) {
                    C4990ab.m7416i("MicroMsg.RemittanceUI", "no bulletin data");
                    AppMethodBeat.m2505o(45163);
                    return;
                }
                C36391e.m59985a((TextView) RemittanceUI.this.findViewById(2131821634), c37807uo.cQK.cQM, c37807uo.cQK.content, c37807uo.cQK.url);
                AppMethodBeat.m2505o(45163);
            }
        };
        C4879a.xxA.mo10055m(c37807uo);
        AppMethodBeat.m2505o(45170);
    }

    public final void cfC() {
        AppMethodBeat.m2504i(45168);
        C23639t.makeText(this.mController.ylL, C25738R.string.dnj, 0).show();
        AppMethodBeat.m2505o(45168);
    }
}
