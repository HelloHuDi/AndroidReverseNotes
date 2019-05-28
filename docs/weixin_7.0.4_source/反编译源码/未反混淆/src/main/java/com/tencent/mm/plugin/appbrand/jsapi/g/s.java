package com.tencent.mm.plugin.appbrand.jsapi.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.g.a.b;
import com.tencent.mm.sdk.platformtools.ab;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class s extends a {
    public static final int CTRL_INDEX = 343;
    public static final String NAME = "removeMapMarkers";

    public final void a(c cVar, JSONObject jSONObject, int i) {
        AppMethodBeat.i(93870);
        super.a(cVar, jSONObject, i);
        if (jSONObject == null) {
            ab.e("MicroMsg.JsApiRemoveMapMarkers", "data is null");
            cVar.M(i, j("fail:invalid data", null));
            AppMethodBeat.o(93870);
            return;
        }
        ab.i("MicroMsg.JsApiRemoveMapMarkers", "data:%s", jSONObject);
        b f = f(cVar, jSONObject);
        if (f == null) {
            ab.e("MicroMsg.JsApiRemoveMapMarkers", "mapView is null, return");
            cVar.M(i, j("fail:mapview is null", null));
            AppMethodBeat.o(93870);
            return;
        }
        if (jSONObject.has("markers")) {
            try {
                JSONArray jSONArray = new JSONArray(jSONObject.optString("markers"));
                for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                    f.Bi(jSONArray.getString(i2));
                }
            } catch (JSONException e) {
                ab.printErrStackTrace("MicroMsg.JsApiRemoveMapMarkers", e, "", new Object[0]);
                cVar.M(i, j("fail:internal error", null));
                AppMethodBeat.o(93870);
                return;
            }
        }
        a(cVar, i, j("ok", null), true, f.aDU());
        AppMethodBeat.o(93870);
    }
}
