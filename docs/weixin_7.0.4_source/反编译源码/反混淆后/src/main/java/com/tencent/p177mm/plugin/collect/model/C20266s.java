package com.tencent.p177mm.plugin.collect.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.wallet_core.tenpay.model.C5749m;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.collect.model.s */
public final class C20266s extends C5749m {
    public String cuZ;
    public String desc;
    public String kCI = null;
    public double kCJ;

    public C20266s(double d, String str, String str2) {
        AppMethodBeat.m2504i(40996);
        HashMap hashMap = new HashMap();
        try {
            hashMap.put("fee", Math.round(100.0d * d));
            hashMap.put("fee_type", str);
            hashMap.put("desc", URLEncoder.encode(str2, "UTF-8"));
        } catch (UnsupportedEncodingException e) {
            C4990ab.printErrStackTrace("Micromsg.NetSceneTenpayRemittanceQuery", e, "", new Object[0]);
        }
        this.kCJ = d;
        this.cuZ = str;
        this.desc = str2;
        mo70323M(hashMap);
        AppMethodBeat.m2505o(40996);
    }

    public final int bgI() {
        return 0;
    }

    /* renamed from: ZU */
    public final int mo9382ZU() {
        return 1623;
    }

    public final String getUri() {
        return "/cgi-bin/mmpay-bin/transfersetf2ffee";
    }

    /* renamed from: a */
    public final void mo9383a(int i, String str, JSONObject jSONObject) {
        AppMethodBeat.m2504i(40997);
        C4990ab.m7410d("Micromsg.NetSceneTenpayRemittanceQuery", "errCode " + i + " errMsg: " + str);
        if (i != 0) {
            AppMethodBeat.m2505o(40997);
            return;
        }
        this.kCI = jSONObject.optString("pay_url");
        AppMethodBeat.m2505o(40997);
    }
}
