package com.tencent.p177mm.plugin.wallet.pwd.p1049a;

import com.google.android.gms.measurement.AppMeasurement.Param;
import com.tencent.luggage.p147g.C45124d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.wallet_core.tenpay.model.C5749m;
import java.util.HashMap;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.wallet.pwd.a.g */
public final class C29602g extends C5749m {
    public C29602g(String str, String str2) {
        AppMethodBeat.m2504i(46176);
        HashMap hashMap = new HashMap();
        hashMap.put("auth_token", str);
        hashMap.put("passwd", String.valueOf(str2));
        hashMap.put(Param.TIMESTAMP, System.currentTimeMillis());
        mo70323M(hashMap);
        AppMethodBeat.m2505o(46176);
    }

    public final String getUri() {
        return "/cgi-bin/mmpay-bin/resetpaypwdbyface";
    }

    /* renamed from: ZU */
    public final int mo9382ZU() {
        return 2514;
    }

    public final int bgI() {
        return 2514;
    }

    /* renamed from: a */
    public final void mo9383a(int i, String str, JSONObject jSONObject) {
        AppMethodBeat.m2504i(46177);
        C45124d.m82930i("MicroMsg.NetSceneResetPayPwdByFace", "onGYNetEnd, errCode: %s, errMsg: %s, json: %s", Integer.valueOf(i), str, jSONObject);
        if (i == 0) {
            jSONObject.optString("retcode");
            jSONObject.optString("retmsg");
        }
        AppMethodBeat.m2505o(46177);
    }
}
