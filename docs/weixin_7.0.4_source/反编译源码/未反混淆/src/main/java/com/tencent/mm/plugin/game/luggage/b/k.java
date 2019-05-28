package com.tencent.mm.plugin.game.luggage.b;

import android.content.Context;
import com.tencent.luggage.d.a.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.lw;
import com.tencent.mm.plugin.game.luggage.d.e;
import com.tencent.mm.plugin.webview.luggage.jsapi.bc;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.sqlitelint.behaviour.persistence.IssueStorage;
import org.json.JSONException;
import org.json.JSONObject;

public class k extends bc<e> {
    public final String name() {
        return "openGameCenter";
    }

    public final int biG() {
        return 2;
    }

    public final void b(a aVar) {
    }

    public final void a(Context context, String str, bc.a aVar) {
        AppMethodBeat.i(135879);
        try {
            JSONObject jSONObject = new JSONObject(str);
            ab.i("MicroMsg.JsApiOpenGameCenter", "jumpView = %d, jumpType = %d", Integer.valueOf(jSONObject.optInt("jumpView")), Integer.valueOf(jSONObject.optInt("jumpType")));
            jSONObject = jSONObject.optJSONObject(IssueStorage.COLUMN_EXT_INFO);
            lw lwVar = new lw();
            lwVar.cHK.cHL = r1;
            lwVar.cHK.jumpType = r2;
            if (jSONObject != null) {
                lwVar.cHK.extraInfo = jSONObject.toString();
            }
            lwVar.cHK.context = context;
            com.tencent.mm.sdk.b.a.xxA.m(lwVar);
            aVar.d(null, null);
            AppMethodBeat.o(135879);
        } catch (JSONException e) {
            ab.e("MicroMsg.JsApiOpenGameCenter", "json parse exception");
            aVar.d("fail", null);
            AppMethodBeat.o(135879);
        }
    }
}
