package com.tencent.mm.plugin.game.luggage.b;

import android.content.Context;
import com.tencent.luggage.d.a.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.game.luggage.d.e;
import com.tencent.mm.plugin.webview.luggage.jsapi.bc;
import com.tencent.mm.plugin.wepkg.model.g;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import org.json.JSONException;
import org.json.JSONObject;

public class h extends bc<e> {
    public final String name() {
        return "getLocalWePkgInfo";
    }

    public final int biG() {
        return 1;
    }

    public final void b(a aVar) {
    }

    public final void a(Context context, String str, final bc.a aVar) {
        AppMethodBeat.i(135875);
        ab.i("MicroMsg.JsApiGetLocalWePkgInfo", "invokeInMM");
        al.d(new Runnable() {
            public final void run() {
                AppMethodBeat.i(135874);
                g.a(new g.a() {
                    public final void U(JSONObject jSONObject) {
                        AppMethodBeat.i(135873);
                        JSONObject jSONObject2 = new JSONObject();
                        try {
                            jSONObject2.put("wepkg_info", jSONObject);
                        } catch (JSONException e) {
                        }
                        aVar.d(null, jSONObject2);
                        AppMethodBeat.o(135873);
                    }
                });
                AppMethodBeat.o(135874);
            }
        });
        AppMethodBeat.o(135875);
    }
}
