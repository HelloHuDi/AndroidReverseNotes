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
import org.json.JSONObject;

public class q extends bd<e> {
    public final String name() {
        return "setGameData";
    }

    public final int biG() {
        return 1;
    }

    public final void b(a aVar) {
    }

    public final void a(Context context, String str, bc.a aVar) {
        AppMethodBeat.i(135888);
        ab.i("MicroMsg.JsApiSetGameData", "invokeInMM");
        JSONObject bQ = i.bQ(str);
        if (bQ == null) {
            ab.e("MicroMsg.JsApiSetGameData", "data is null");
            aVar.d("null_data", null);
            AppMethodBeat.o(135888);
            return;
        }
        String optString = bQ.optString("preVerifyAppId");
        if (bo.isNullOrNil(optString)) {
            ab.i("MicroMsg.JsApiSetGameData", "appId is null");
            aVar.d("appid_null", null);
            AppMethodBeat.o(135888);
            return;
        }
        String optString2 = bQ.optString("key");
        String optString3 = bQ.optString("value");
        String optString4 = bQ.optString("weight", "1");
        String optString5 = bQ.optString("expireTime");
        boolean optBoolean = bQ.optBoolean("autoClean", true);
        if (bo.isNullOrNil(optString2) || bo.isNullOrNil(optString3)) {
            ab.i("MicroMsg.JsApiSetGameData", "key or value is null");
            aVar.d("null_key", null);
            AppMethodBeat.o(135888);
        } else if (b.cWi().a(optString, optString2, optString3, optString4, optString5, optBoolean)) {
            aVar.d(null, null);
            AppMethodBeat.o(135888);
        } else {
            aVar.d("exceed_size", null);
            AppMethodBeat.o(135888);
        }
    }
}
