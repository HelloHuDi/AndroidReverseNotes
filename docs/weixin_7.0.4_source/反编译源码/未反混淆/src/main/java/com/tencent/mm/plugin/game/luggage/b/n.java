package com.tencent.mm.plugin.game.luggage.b;

import android.content.Context;
import com.tencent.luggage.d.a.a;
import com.tencent.luggage.g.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.gx;
import com.tencent.mm.plugin.game.luggage.d.e;
import com.tencent.mm.plugin.webview.luggage.jsapi.bc;
import com.tencent.mm.plugin.webview.luggage.jsapi.bd;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import org.json.JSONException;
import org.json.JSONObject;

public class n extends bd<e> {
    public final String name() {
        return "operateGameCenterMsg";
    }

    public final int biG() {
        return 1;
    }

    public final void b(a aVar) {
    }

    public final void a(Context context, String str, bc.a aVar) {
        AppMethodBeat.i(135884);
        ab.i("MicroMsg.JsApiOperateGameCenterMsg", "invokeInMM");
        JSONObject bQ = i.bQ(str);
        if (bQ == null) {
            ab.i("MicroMsg.JsApiOperateGameCenterMsg", "data is null");
            aVar.d("invalid_data", null);
            AppMethodBeat.o(135884);
            return;
        }
        int optInt = bQ.optInt("cmd");
        bQ = bQ.optJSONObject("param");
        gx gxVar = new gx();
        gxVar.cBD.Cn = optInt;
        gxVar.cBD.cBy = bQ.toString();
        com.tencent.mm.sdk.b.a.xxA.m(gxVar);
        bQ = new JSONObject();
        try {
            bQ.put("result", bo.nullAsNil(gxVar.cBE.cBF));
        } catch (JSONException e) {
        }
        aVar.d(null, bQ);
        AppMethodBeat.o(135884);
    }
}
