package com.tencent.mm.plugin.game.luggage.b;

import android.content.Context;
import com.tencent.luggage.d.a.a;
import com.tencent.luggage.g.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.gu;
import com.tencent.mm.plugin.game.luggage.d.e;
import com.tencent.mm.plugin.webview.luggage.jsapi.bc;
import com.tencent.mm.sdk.platformtools.ab;
import org.json.JSONException;
import org.json.JSONObject;

public class f extends bc<e> {
    public final String name() {
        return "getGameCommInfo";
    }

    public final int biG() {
        return 1;
    }

    public final void b(a aVar) {
    }

    public final void a(Context context, String str, bc.a aVar) {
        AppMethodBeat.i(135871);
        ab.i("MicroMsg.JsApiGetGameCommInfo", "invoke");
        JSONObject bQ = i.bQ(str);
        if (bQ == null) {
            ab.e("MicroMsg.JsApiGetGameCommInfo", "data is null");
            aVar.d("invalid_data", null);
            AppMethodBeat.o(135871);
            return;
        }
        int optInt = bQ.optInt("cmd", 0);
        String optString = bQ.optString("param");
        if (optInt == 10002) {
            bQ = new JSONObject();
            try {
                bQ.put("webpageCount", 1);
            } catch (JSONException e) {
            }
            aVar.d(null, bQ);
            AppMethodBeat.o(135871);
            return;
        }
        gu guVar = new gu();
        guVar.cBw.Cn = optInt;
        guVar.cBw.cBy = optString;
        guVar.cBw.context = context;
        com.tencent.mm.sdk.b.a.xxA.m(guVar);
        try {
            aVar.d(null, new JSONObject(guVar.cBx.result));
            AppMethodBeat.o(135871);
        } catch (JSONException e2) {
            aVar.d(null, null);
            AppMethodBeat.o(135871);
        }
    }
}
