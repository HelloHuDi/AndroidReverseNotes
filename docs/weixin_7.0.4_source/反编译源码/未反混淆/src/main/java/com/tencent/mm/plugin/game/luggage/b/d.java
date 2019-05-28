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
import org.json.JSONArray;
import org.json.JSONObject;

public class d extends bd<e> {
    public final String name() {
        return "clearGameData";
    }

    public final int biG() {
        return 1;
    }

    public final void b(a aVar) {
    }

    public final void a(Context context, String str, bc.a aVar) {
        AppMethodBeat.i(135869);
        ab.i("MicroMsg.JsApiClearGameData", "invokeInMM");
        JSONObject bQ = i.bQ(str);
        if (bQ == null) {
            ab.e("MicroMsg.JsApiClearGameData", "data is null");
            aVar.d("null_data", null);
            AppMethodBeat.o(135869);
            return;
        }
        String optString = bQ.optString("preVerifyAppId");
        if (bo.isNullOrNil(optString)) {
            ab.i("MicroMsg.JsApiClearGameData", "appId is null");
            aVar.d("appid_null", null);
            AppMethodBeat.o(135869);
            return;
        }
        JSONArray optJSONArray = bQ.optJSONArray("keys");
        boolean optBoolean = bQ.optBoolean("clearAllData", false);
        if (optJSONArray != null && optJSONArray.length() > 0) {
            b.cWi().b(optString, optJSONArray);
            aVar.d(null, null);
            AppMethodBeat.o(135869);
        } else if (optBoolean) {
            b.cWi().adY(optString);
            aVar.d(null, null);
            AppMethodBeat.o(135869);
        } else {
            ab.i("MicroMsg.JsApiClearGameData", "keys is null");
            aVar.d("fail", null);
            AppMethodBeat.o(135869);
        }
    }
}
