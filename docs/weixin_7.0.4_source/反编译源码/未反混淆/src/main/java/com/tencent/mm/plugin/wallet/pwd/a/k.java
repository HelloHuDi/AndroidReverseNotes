package com.tencent.mm.plugin.wallet.pwd.a;

import com.facebook.appevents.AppEventsConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.f;
import com.tencent.mm.network.e;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.wallet_core.tenpay.model.m;
import java.util.HashMap;
import org.json.JSONObject;

public final class k extends m implements com.tencent.mm.network.k {
    public JSONObject tqH;

    public k(boolean z, String str, String str2) {
        AppMethodBeat.i(46189);
        HashMap hashMap = new HashMap();
        ab.d("MicroMsg.NetSceneTenpayQueryBasicSecurityInfo", "cpuId: %s, uid: %s", str, str2);
        hashMap.put("is_root", AppEventsConstants.EVENT_PARAM_VALUE_NO);
        hashMap.put("is_device_open_touch", z ? "1" : AppEventsConstants.EVENT_PARAM_VALUE_NO);
        hashMap.put("cpu_id", str);
        hashMap.put("app_uid", str2);
        M(hashMap);
        AppMethodBeat.o(46189);
    }

    public final int a(e eVar, f fVar) {
        AppMethodBeat.i(46190);
        this.ehi = fVar;
        int a = super.a(eVar, fVar);
        AppMethodBeat.o(46190);
        return a;
    }

    public final String getUri() {
        return "/cgi-bin/mmpay-bin/tenpay/paysecurity";
    }

    public final int bgI() {
        return 0;
    }

    public final int ZU() {
        return 1669;
    }

    public final void a(int i, String str, JSONObject jSONObject) {
        AppMethodBeat.i(46191);
        ab.i("MicroMsg.NetSceneTenpayQueryBasicSecurityInfo", "alvinluo errCode: %d, errMsg: %s", Integer.valueOf(i), str);
        if (i == 0 && jSONObject != null) {
            ab.v("MicroMsg.NetSceneTenpayQueryBasicSecurityInfo", "alvinluo json: %s", jSONObject.toString());
            this.tqH = jSONObject;
            com.tencent.mm.wallet_core.c.ab.dNZ().aT(this.tqH);
        }
        AppMethodBeat.o(46191);
    }
}
