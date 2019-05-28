package com.tencent.mm.plugin.webview.luggage.jsapi;

import android.content.Context;
import com.tencent.luggage.d.a.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.e.q;
import com.tencent.mm.plugin.webview.luggage.c.c;
import com.tencent.mm.plugin.webview.luggage.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bo;
import org.json.JSONException;
import org.json.JSONObject;

public class r extends bd<d> {
    public final String name() {
        return "getOpenDeviceId";
    }

    public final int biG() {
        return 1;
    }

    public final void b(a aVar) {
    }

    public final void a(Context context, String str, bc.a aVar) {
        AppMethodBeat.i(6313);
        ab.i("MicroMsg.JsApiGetOpenDeviceId", "invokeInMM");
        JSONObject AI = c.AI(str);
        if (AI == null) {
            ab.e("MicroMsg.JsApiGetOpenDeviceId", "data is null");
            aVar.d("fail", null);
            AppMethodBeat.o(6313);
            return;
        }
        String optString = AI.optString("preVerifyAppId");
        String LK = q.LK();
        String LM = q.LM();
        if (bo.isNullOrNil(LK) || bo.isNullOrNil(LM) || bo.isNullOrNil(optString)) {
            aVar.d("fail", null);
            AppMethodBeat.o(6313);
            return;
        }
        LK = ag.ck(ag.ck(optString + LK));
        optString = ag.ck(ag.ck(optString + LM));
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("deviceid", LK);
            jSONObject.put("newDeviceId", optString);
        } catch (JSONException e) {
        }
        aVar.d(null, jSONObject);
        AppMethodBeat.o(6313);
    }
}
