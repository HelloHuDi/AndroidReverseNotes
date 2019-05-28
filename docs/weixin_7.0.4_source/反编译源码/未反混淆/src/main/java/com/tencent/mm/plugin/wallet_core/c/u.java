package com.tencent.mm.plugin.wallet_core.c;

import com.google.android.gms.measurement.AppMeasurement.Param;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.wallet_core.tenpay.model.m;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import org.json.JSONObject;

public final class u extends m {
    public u(String str, String str2, String str3, String str4, String str5) {
        AppMethodBeat.i(46540);
        HashMap hashMap = new HashMap();
        try {
            hashMap.put("appid", URLEncoder.encode(str, "UTF-8"));
            hashMap.put(Param.TIMESTAMP, URLEncoder.encode(str2, "UTF-8"));
            hashMap.put("noncestr", URLEncoder.encode(str3, "UTF-8"));
            hashMap.put("package", URLEncoder.encode(str4, "UTF-8"));
            hashMap.put("sign", URLEncoder.encode(str5, "UTF-8"));
            M(hashMap);
            ab.d("MicroMsg.NetSceneTenpayF2fJsapiCheck", "package: %s, sign: %s", str4, str5);
            AppMethodBeat.o(46540);
        } catch (UnsupportedEncodingException e) {
            ab.printErrStackTrace("MicroMsg.NetSceneTenpayF2fJsapiCheck", e, "", new Object[0]);
            AppMethodBeat.o(46540);
        }
    }

    public final int bgI() {
        return 0;
    }

    public final String getUri() {
        return "/cgi-bin/mmpay-bin/f2frcvdlistjsapicheck";
    }

    public final int ZU() {
        return 1973;
    }

    public final void a(int i, String str, JSONObject jSONObject) {
        AppMethodBeat.i(46541);
        ab.d("MicroMsg.NetSceneTenpayF2fJsapiCheck", "errCode: %d, errMsg: %s", Integer.valueOf(i), str);
        AppMethodBeat.o(46541);
    }
}
