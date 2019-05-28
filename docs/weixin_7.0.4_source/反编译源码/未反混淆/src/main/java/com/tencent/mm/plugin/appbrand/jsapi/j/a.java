package com.tencent.mm.plugin.appbrand.jsapi.j;

import com.tencent.luggage.g.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.q;
import com.tencent.mm.plugin.cloudvoip.cloudvoice.c.j;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.bo;
import org.json.JSONObject;

public final class a extends d {
    public static final int CTRL_INDEX = 517;
    public static final String NAME = "exitVoIPChat";

    public final void b(q qVar, JSONObject jSONObject, int i) {
        AppMethodBeat.i(131384);
        d.i("MicroMsg.OpenVoice.JsApiCloudVoiceExitVoIPChat", "hy: invoke JsApiCloudVoiceExitVoIPChat");
        dU(false);
        final String appId = qVar.getAppId();
        final long yz = bo.yz();
        final q qVar2 = qVar;
        final int i2 = i;
        j.kzW.a(new com.tencent.mm.plugin.cloudvoip.cloudvoice.c.a<String>() {
            public final /* synthetic */ void a(int i, int i2, String str, Object obj) {
                AppMethodBeat.i(131383);
                String str2 = (String) obj;
                long az = bo.az(yz);
                d.i("MicroMsg.OpenVoice.JsApiCloudVoiceExitVoIPChat", "hy: exit conference result %d, %d, %s, %s, using %d ms", Integer.valueOf(i), Integer.valueOf(i2), str, str2, Long.valueOf(az));
                h.pYm.e(16093, appId, Integer.valueOf(i2), Long.valueOf(az));
                if (i == 0 && i2 == 0) {
                    h.pYm.k(935, 2, 1);
                    qVar2.M(i2, a.this.j("ok", null));
                    AppMethodBeat.o(131383);
                    return;
                }
                h.pYm.k(935, 3, 1);
                qVar2.M(i2, a.this.j("fail: ".concat(String.valueOf(str)), null));
                AppMethodBeat.o(131383);
            }
        }, com.tencent.mm.plugin.cloudvoip.cloudvoice.c.j.a.kBf);
        AppMethodBeat.o(131384);
    }
}
