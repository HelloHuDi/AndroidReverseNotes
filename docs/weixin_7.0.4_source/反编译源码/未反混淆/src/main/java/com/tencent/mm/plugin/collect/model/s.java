package com.tencent.mm.plugin.collect.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.wallet_core.tenpay.model.m;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import org.json.JSONObject;

public final class s extends m {
    public String cuZ;
    public String desc;
    public String kCI = null;
    public double kCJ;

    public s(double d, String str, String str2) {
        AppMethodBeat.i(40996);
        HashMap hashMap = new HashMap();
        try {
            hashMap.put("fee", Math.round(100.0d * d));
            hashMap.put("fee_type", str);
            hashMap.put("desc", URLEncoder.encode(str2, "UTF-8"));
        } catch (UnsupportedEncodingException e) {
            ab.printErrStackTrace("Micromsg.NetSceneTenpayRemittanceQuery", e, "", new Object[0]);
        }
        this.kCJ = d;
        this.cuZ = str;
        this.desc = str2;
        M(hashMap);
        AppMethodBeat.o(40996);
    }

    public final int bgI() {
        return 0;
    }

    public final int ZU() {
        return 1623;
    }

    public final String getUri() {
        return "/cgi-bin/mmpay-bin/transfersetf2ffee";
    }

    public final void a(int i, String str, JSONObject jSONObject) {
        AppMethodBeat.i(40997);
        ab.d("Micromsg.NetSceneTenpayRemittanceQuery", "errCode " + i + " errMsg: " + str);
        if (i != 0) {
            AppMethodBeat.o(40997);
            return;
        }
        this.kCI = jSONObject.optString("pay_url");
        AppMethodBeat.o(40997);
    }
}
