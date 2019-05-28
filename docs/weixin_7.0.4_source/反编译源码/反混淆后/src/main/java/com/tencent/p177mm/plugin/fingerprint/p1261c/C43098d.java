package com.tencent.p177mm.plugin.fingerprint.p1261c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.network.C1918k;
import com.tencent.p177mm.network.C1929q;
import com.tencent.p177mm.plugin.fingerprint.C43094a;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.plugin.soter.p528d.C13720d;
import com.tencent.p177mm.plugin.soter.p528d.C29254e;
import com.tencent.p177mm.pluginsdk.C30052l;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.wallet_core.tenpay.model.C5749m;
import java.util.HashMap;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.fingerprint.c.d */
public final class C43098d extends C5749m implements C1918k {
    public C43098d(int i) {
        AppMethodBeat.m2504i(41584);
        HashMap hashMap = new HashMap();
        C29254e cvQ = C13720d.cvQ();
        String str = cvQ.rOh;
        String str2 = cvQ.jSY;
        hashMap.put("cpu_id", str);
        hashMap.put("uid", str2);
        hashMap.put("soter_type", String.valueOf(i));
        mo70323M(hashMap);
        AppMethodBeat.m2505o(41584);
    }

    public final int bgI() {
        return 116;
    }

    /* renamed from: a */
    public final void mo9383a(int i, String str, JSONObject jSONObject) {
        AppMethodBeat.m2504i(41585);
        if (i == 0) {
            int optInt;
            if (jSONObject != null) {
                optInt = jSONObject.optInt("clear_rsa_key_level", 0);
            } else {
                optInt = 0;
            }
            C43094a.bwM();
            C43094a.bwN();
            new Object[1][0] = Integer.valueOf(optInt);
            ((C30052l) C1720g.m3528K(C30052l.class)).bxv();
            AppMethodBeat.m2505o(41585);
            return;
        }
        C4990ab.m7412e("MicroMsg.NetSceneTenpayCloseTouchPay", "do close fingerprint cgi failed!");
        AppMethodBeat.m2505o(41585);
    }

    /* renamed from: a */
    public final void mo4498a(int i, int i2, int i3, String str, C1929q c1929q, byte[] bArr) {
        AppMethodBeat.m2504i(41586);
        super.mo4498a(i, i2, i3, str, c1929q, bArr);
        C30052l c30052l = (C30052l) C1720g.m3528K(C30052l.class);
        if (c30052l.bxe()) {
            C7060h.pYm.mo8381e(13686, Integer.valueOf(i2), Integer.valueOf(i3));
        } else if (c30052l.bxh()) {
            C7060h.pYm.mo8381e(16994, Integer.valueOf(i2), Integer.valueOf(i3));
        }
        if (i2 == 0 && i3 == 0) {
            c30052l.mo48312hq(false);
            c30052l.mo48313hr(false);
            C4990ab.m7412e("MicroMsg.NetSceneTenpayCloseTouchPay", "hy: do close fingerprint cgi success!");
            AppMethodBeat.m2505o(41586);
            return;
        }
        C4990ab.m7412e("MicroMsg.NetSceneTenpayCloseTouchPay", "hy: do close fingerprint cgi failed!");
        AppMethodBeat.m2505o(41586);
    }

    /* renamed from: ZU */
    public final int mo9382ZU() {
        return 1597;
    }

    public final String getUri() {
        return "/cgi-bin/mmpay-bin/tenpay/closetouchpay";
    }
}
