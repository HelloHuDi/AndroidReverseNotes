package com.tencent.p177mm.plugin.wallet_core.p749c;

import com.google.android.gms.measurement.AppMeasurement.Param;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.wallet_core.tenpay.model.C5749m;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.wallet_core.c.u */
public final class C40096u extends C5749m {
    public C40096u(String str, String str2, String str3, String str4, String str5) {
        AppMethodBeat.m2504i(46540);
        HashMap hashMap = new HashMap();
        try {
            hashMap.put("appid", URLEncoder.encode(str, "UTF-8"));
            hashMap.put(Param.TIMESTAMP, URLEncoder.encode(str2, "UTF-8"));
            hashMap.put("noncestr", URLEncoder.encode(str3, "UTF-8"));
            hashMap.put("package", URLEncoder.encode(str4, "UTF-8"));
            hashMap.put("sign", URLEncoder.encode(str5, "UTF-8"));
            mo70323M(hashMap);
            C4990ab.m7411d("MicroMsg.NetSceneTenpayF2fJsapiCheck", "package: %s, sign: %s", str4, str5);
            AppMethodBeat.m2505o(46540);
        } catch (UnsupportedEncodingException e) {
            C4990ab.printErrStackTrace("MicroMsg.NetSceneTenpayF2fJsapiCheck", e, "", new Object[0]);
            AppMethodBeat.m2505o(46540);
        }
    }

    public final int bgI() {
        return 0;
    }

    public final String getUri() {
        return "/cgi-bin/mmpay-bin/f2frcvdlistjsapicheck";
    }

    /* renamed from: ZU */
    public final int mo9382ZU() {
        return 1973;
    }

    /* renamed from: a */
    public final void mo9383a(int i, String str, JSONObject jSONObject) {
        AppMethodBeat.m2504i(46541);
        C4990ab.m7411d("MicroMsg.NetSceneTenpayF2fJsapiCheck", "errCode: %d, errMsg: %s", Integer.valueOf(i), str);
        AppMethodBeat.m2505o(46541);
    }
}
