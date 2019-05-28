package com.tencent.mm.plugin.appbrand.jsapi.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.g.a.b;
import com.tencent.mm.sdk.platformtools.ab;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class r extends a {
    public static final int CTRL_INDEX = -2;
    public static final String NAME = "removeMapLines";

    public final void a(c cVar, JSONObject jSONObject, int i) {
        AppMethodBeat.i(93869);
        super.a(cVar, jSONObject, i);
        if (jSONObject == null) {
            ab.e("MicroMsg.JsApiRemoveMapLines", "data is null");
            cVar.M(i, j("fail:invalid data", null));
            AppMethodBeat.o(93869);
            return;
        }
        ab.i("MicroMsg.JsApiRemoveMapLines", "data:%s", jSONObject);
        b f = f(cVar, jSONObject);
        if (f == null) {
            ab.e("MicroMsg.JsApiRemoveMapLines", "mapView is null, return");
            cVar.M(i, j("fail:mapview is null", null));
            AppMethodBeat.o(93869);
            return;
        }
        if (jSONObject.has("lines")) {
            try {
                JSONArray jSONArray = new JSONArray(jSONObject.optString("lines"));
                for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                    f.Bg(jSONArray.getString(i2));
                }
            } catch (JSONException e) {
                ab.printErrStackTrace("MicroMsg.JsApiRemoveMapLines", e, "", new Object[0]);
                cVar.M(i, j("fail:internal error", null));
                AppMethodBeat.o(93869);
                return;
            }
        }
        a(cVar, i, j("ok", null), true, f.aDU());
        AppMethodBeat.o(93869);
    }
}
