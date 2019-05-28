package com.tencent.mm.plugin.appbrand.jsapi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import org.json.JSONObject;

public final class ab extends JsApiUploadWeRunData {
    public static final int CTRL_INDEX = 324;
    public static final String NAME = "addWeRunData";

    public final void a(c cVar, JSONObject jSONObject, int i) {
        AppMethodBeat.i(130391);
        com.tencent.mm.sdk.platformtools.ab.d("MicroMsg.JsApiAddWeRunData", "JsApiAddWeRunData!");
        if (jSONObject == null) {
            cVar.M(i, j("fail:data is null", null));
            com.tencent.mm.sdk.platformtools.ab.e("MicroMsg.JsApiAddWeRunData", "data is null");
            AppMethodBeat.o(130391);
            return;
        }
        a(this, cVar, i, jSONObject.optInt("step"), true);
        AppMethodBeat.o(130391);
    }
}
