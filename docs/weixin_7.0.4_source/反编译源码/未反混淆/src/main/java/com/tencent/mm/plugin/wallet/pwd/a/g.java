package com.tencent.mm.plugin.wallet.pwd.a;

import com.google.android.gms.measurement.AppMeasurement.Param;
import com.tencent.luggage.g.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.wallet_core.tenpay.model.m;
import java.util.HashMap;
import org.json.JSONObject;

public final class g extends m {
    public g(String str, String str2) {
        AppMethodBeat.i(46176);
        HashMap hashMap = new HashMap();
        hashMap.put("auth_token", str);
        hashMap.put("passwd", String.valueOf(str2));
        hashMap.put(Param.TIMESTAMP, System.currentTimeMillis());
        M(hashMap);
        AppMethodBeat.o(46176);
    }

    public final String getUri() {
        return "/cgi-bin/mmpay-bin/resetpaypwdbyface";
    }

    public final int ZU() {
        return 2514;
    }

    public final int bgI() {
        return 2514;
    }

    public final void a(int i, String str, JSONObject jSONObject) {
        AppMethodBeat.i(46177);
        d.i("MicroMsg.NetSceneResetPayPwdByFace", "onGYNetEnd, errCode: %s, errMsg: %s, json: %s", Integer.valueOf(i), str, jSONObject);
        if (i == 0) {
            jSONObject.optString("retcode");
            jSONObject.optString("retmsg");
        }
        AppMethodBeat.o(46177);
    }
}
