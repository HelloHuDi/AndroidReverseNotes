package com.tencent.mm.plugin.game.luggage.b;

import android.content.Context;
import com.tencent.luggage.d.a.a;
import com.tencent.luggage.g.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.game.luggage.d.e;
import com.tencent.mm.plugin.webview.b.b;
import com.tencent.mm.plugin.webview.luggage.jsapi.bc;
import com.tencent.mm.plugin.webview.luggage.jsapi.bd;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import org.json.JSONException;
import org.json.JSONObject;

public class g extends bd<e> {
    public final String name() {
        return "getGameData";
    }

    public final int biG() {
        return 1;
    }

    public final void b(a aVar) {
    }

    public final void a(Context context, String str, bc.a aVar) {
        AppMethodBeat.i(135872);
        ab.i("MicroMsg.JsApiGetGameData", "invokeInMM");
        JSONObject bQ = i.bQ(str);
        if (bQ == null) {
            ab.e("MicroMsg.JsApiGetGameData", "data is null");
            aVar.d("null_data", null);
            AppMethodBeat.o(135872);
            return;
        }
        String optString = bQ.optString("preVerifyAppId");
        if (bo.isNullOrNil(optString)) {
            ab.i("MicroMsg.JsApiGetGameData", "appId is null");
            aVar.d("appid_null", null);
            AppMethodBeat.o(135872);
            return;
        }
        String optString2 = bQ.optString("key");
        if (bo.isNullOrNil(optString2)) {
            ab.i("MicroMsg.JsApiGetGameData", "key is null");
            aVar.d("null_key", null);
            AppMethodBeat.o(135872);
            return;
        }
        com.tencent.mm.plugin.webview.b.a gV = b.cWi().gV(optString, optString2);
        if (bo.isNullOrNil(gV.field_value)) {
            aVar.d(null, null);
            AppMethodBeat.o(135872);
            return;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("value", gV.field_value);
            jSONObject.put("weight", gV.field_weight);
            jSONObject.put("expireTime", gV.field_expireTime - (System.currentTimeMillis() / 1000));
        } catch (JSONException e) {
        }
        aVar.d(null, jSONObject);
        AppMethodBeat.o(135872);
    }
}
